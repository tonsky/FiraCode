#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "`dirname $0`/.."
[ -d venv ] && source venv/bin/activate
mkdir -p distr/ttf
rm -rf distr/ttf/*

args=( "$@" )
default_weights=( "Light" "Regular" "Retina" "Medium" "SemiBold" "Bold" )
weights=( "${args[@]:-"${default_weights[@]}"}" )

for weight in "${weights[@]}"; do
    file=distr/ttf/FiraCode-${weight}.ttf
    
    echo "Making " ${file}
    rm -rf ${file}
    fontmake -g FiraCode.glyphs -o ttf --output-dir distr/ttf -i "Fira Code ${weight}"

    echo "Fixing DSIG in " ${file}
    gftools fix-dsig --autofix ${file}

    echo "TTFautohint " ${file}
    ttfautohint --detailed-info ${file} ${file}.hinted --stem-width-mode nnn --composites
    #--windows-compatibility
    mv ${file}.hinted ${file}
done
