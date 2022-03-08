#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "$(dirname "$0")/.."
[ -d venv ] && source venv/bin/activate

family_name=${FIRACODE_FAMILY_NAME:-"Fira Code"}

ttf_dir="distr/ttf/${family_name}"
woff_dir="distr/woff2/${family_name}"

echo "=============="
echo
echo "  [i] Creating .woff2 files!"
echo

mkdir -p "${woff_dir}"
rm -rf "${woff_dir:?}/"*

# requires woff2_compress (get from https://github.com/bramstein/homebrew-webfonttools)

for ttf in "${ttf_dir}/"*.ttf; do
	echo "woff2_compress ${ttf}"
	woff2_compress "${ttf}"
done

mv "${ttf_dir}/"*.woff2 "${woff_dir}"
rm -f "${woff_dir}/FiraCode-Retina.woff2"
