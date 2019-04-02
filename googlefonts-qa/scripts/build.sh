#!/bin/bash

source venv/bin/activate

# variable font
fontmake -m master_ufo/FiraCode.designspace -o variable --output-dir distr/variable_ttf

# statics
fontmake -m master_ufo/FiraCode.designspace -o ttf --output-dir distr/ttf
fontmake -m master_ufo/FiraCode.designspace -o otf --output-dir distr/otf

# ============================================================================
# Autohinting ================================================================

statics=$(ls distr/ttf/*.ttf)
for file in $statics; do 
    echo "fix DSIG in " ${file}
    gftools fix-dsig --autofix ${file}

    echo "TTFautohint " ${file}
    # autohint with detailed info
    hintedFile=${file/".ttf"/"-hinted.ttf"}
    ttfautohint -I ${file} ${hintedFile} --stem-width-mode nnn
    cp ${hintedFile} ${file}
    rm -rf ${hintedFile}
done


# ============================================================================
# Build woff2 fonts ==========================================================

# requires https://github.com/google/woff2

rm -rf distr/woff2

ttfs=$(ls distr/*/*.ttf)
for ttf in $ttfs; do
    woff2_compress $ttf
done

mkdir -p distr/woff2
woff2s=$(ls distr/*/*.woff2)
for woff2 in $woff2s; do
    mv $woff2 distr/woff2/$(basename $woff2)
done