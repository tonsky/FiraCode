#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "$(dirname "$0")/.."
[ -d venv ] && source venv/bin/activate

family_name=${FIRACODE_FAMILY_NAME:-"Fira Code"}
glyphs_file=${FIRACODE_GLYPHS_FILE:-"FiraCode.glyphs"}

dir="distr/otf/${family_name}"

mkdir -p "${dir}"
rm -rf "${dir:?}/"*

args=( "$@" )
default_weights=( "Light" "Regular" "Retina" "Medium" "SemiBold" "Bold" )
weights=( "${args[@]:-"${default_weights[@]}"}" )

for weight in "${weights[@]}"; do
	file="${dir}/FiraCode-${weight}.otf"

	echo "=============="
	echo
	echo "  [i] Creating ${file}"
	echo

	fontmake -g "${glyphs_file}" -o otf --output-path "${file}" -i ".* ${weight}"
done
