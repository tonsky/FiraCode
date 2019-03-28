#!/bin/bash

# This script copies the latest builds to the google fonts dir in order to run QA checks and prep for a PR
#
# USAGE: 
# Install requirements with `pip install -U -r googlefonts-qa/requirements.txt`
# 
# call this script from the root of your fira code repo, with the absolute path your your local google/fonts repo
# `move-check <your_username>/<path>/fonts`

set -e
source venv/bin/activate
gFontsDir=$1

if [[ -z "$gFontsDir" || $gFontsDir = "--help" ]] ; then
    echo 'Add absolute path to your Google Fonts Git directory, like:'
    echo 'move-check /Users/username/type-repos/google-font-repos/fonts'
    exit 2
fi

firaCodeDir=$(pwd)

firaCodeQADir=$firaCodeDir/googlefonts-qa

firaCodeVF=$firaCodeDir/distr/variable_ttf/FiraCode-VF.ttf


# -------------------------------------------------------------------
# get latest version ------------------------------------------------

ttx -t head $firaCodeVF
fontVersion=v$(xml sel -t --match "//*/fontRevision" -v "@value" ${firaCodeVF/".ttf"/".ttx"})
rm ${firaCodeVF/".ttf"/".ttx"}

# -------------------------------------------------------------------
# fix variable font metadata as needed ------------------------------

# TODO: Add gftools scripts as needed

# TODO: test VFs with TTFautohint-VF vs no hinting

gftools fix-nonhinting $firaCodeVF $firaCodeVF

# TODO: decide if `--autofix` is really the best option, or if we should assert more control
gftools fix-gasp --autofix $firaCodeVF

gftools fix-dsig --autofix $firaCodeVF

# fix variable font metadata
gftools fix-vf-meta $firaCodeVF

# cleanup
tempFiles=$(ls distr/variable_ttf/*.fix && ls distr/variable_ttf/*-gasp*)
for temp in $tempFiles
do
    rm -rf $temp
done


# -------------------------------------------------------------------
# navigate to google/fonts repo, then fira code branch --------------

cd $gFontsDir
git checkout master
git pull upstream master
git reset --hard
git checkout -B firacode
git clean -f -d

# -------------------------------------------------------------------
# move fonts --------------------------------------------------------

mkdir -p ofl/firacode

cp $firaCodeVF    ofl/firacode/FiraCode-Light.ttf

mkdir -p ofl/firacode/static
statics=$(ls $firaCodeDir/distr/ttf/*.ttf)
for ttf in $statics
do
    cp $ttf ofl/firacode/static/$(basename $ttf)
done

# -------------------------------------------------------------------
# make or move basic metadata ---------------------------------------

cp $firaCodeDir/googlefonts-qa/METADATA.pb ofl/firacode/METADATA.pb

cp $firaCodeDir/LICENSE ofl/firacode/OFL.txt

cp $firaCodeQADir/gfonts-description.html ofl/firacode/DESCRIPTION.en_us.html

# -------------------------------------------------------------------
# run checks, saving to firacode/googlefonts-qa/checks ------------

set +e # otherwise, the script stops after the first fontbakery check output

mkdir -p $firaCodeQADir/checks/static

cd ofl/firacode

# ttfs=$(ls -R */*.ttf && ls *.ttf) # use this to statics and VFs
ttfs=$(ls *.ttf) # use this to check only the VFs
# ttfs=$(ls -R */*.ttf ) # use this to check only statics

for ttf in $ttfs
do
    fontbakery check-googlefonts $ttf --ghmarkdown $firaCodeQADir/checks/${ttf/".ttf"/".checks.md"}
done

git add .
git commit -m "fira code: $fontVersion added."

git push --force upstream firacode