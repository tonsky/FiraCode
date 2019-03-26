#!/bin/bash

source venv/bin/activate

# variable font
fontmake -g FiraCode.glyphs -o variable --output-dir distr/variable_ttf

# static TTFs
fontmake -g FiraCode.glyphs -o ttf --output-dir distr/ttf

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