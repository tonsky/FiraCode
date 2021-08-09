#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "`dirname $0`/.."
[ -d venv ] && source venv/bin/activate
mkdir -p distr/woff2
rm -rf distr/woff2/*

# requires woff2_compress (get from https://github.com/bramstein/homebrew-webfonttools)

ttfs=$(ls distr/*/*.ttf)
for ttf in $ttfs; do
    woff2_compress $ttf
done

mkdir -p distr/woff2
mv distr/*/*.woff2 distr/woff2
rm -f distr/woff2/FiraCode-Retina.woff2
