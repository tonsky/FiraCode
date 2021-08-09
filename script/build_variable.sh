#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "`dirname $0`/.."
[ -d venv ] && source venv/bin/activate
mkdir -p distr/variable_ttf
rm -rf distr/variable_ttf/*

FILE=FiraCode-VF.ttf

awk '/name = Retina;/ { print; print "exports = 0;"; next }1' FiraCode.glyphs > FiraCode_VF.glyphs
fontmake -g FiraCode_VF.glyphs -o variable --output-dir distr/variable_ttf
rm FiraCode_VF.glyphs

pushd distr/variable_ttf

# fix variable font metadata – very important
gftools fix-vf-meta $FILE
mv $FILE.fix $FILE

# other fixes for metadata and hinting
gftools fix-nonhinting $FILE $FILE.fix
mv $FILE.fix $FILE

gftools fix-gasp --autofix $FILE
mv $FILE.fix $FILE

gftools fix-dsig --autofix $FILE

# cleanup of temp files
rm -rf *-gasp.ttf

# TODO (late 2019?): use TTFautohint-VF for variable font (current support is minimal)

popd