#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "$(dirname "$0")/.."
[ -d venv ] && source venv/bin/activate

family_name=${FIRACODE_FAMILY_NAME:-"Fira Code"}

ttf_dir="distr/ttf/${family_name}"
woff_dir="distr/woff/${family_name}"

echo "=============="
echo
echo "  [i] Creating .woff files!"
echo

mkdir -p "${woff_dir}"
rm -rf "${woff_dir:?}/"*

# requires sfnt2woff-zopfli (get from https://github.com/bramstein/homebrew-webfonttools)

for ttf in "${ttf_dir}/"*.ttf; do
	echo "sfnt2woff-zopfli ${ttf}"
	sfnt2woff-zopfli "${ttf}"
done

mv "${ttf_dir}/"*.woff "${woff_dir}"
rm -f "${woff_dir}/FiraCode-Retina.woff"
