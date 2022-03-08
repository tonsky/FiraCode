#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "$(dirname "$0")/.."
[ -d venv ] && source venv/bin/activate

family_name=${FIRACODE_FAMILY_NAME:-"Fira Code"}
glyphs_file=${FIRACODE_GLYPHS_FILE:-"FiraCode.glyphs"}

dir="distr/variable_ttf/${family_name}"
file="${dir}/FiraCode-VF.ttf"

echo "=============="
echo
echo "  [i] Creating variable font file!"
echo

mkdir -p "${dir}"
rm -rf "${dir:?}/"*

# make a temporary file here to avoid parallel runs from stepping on each other's toes
vf_glyphs=$(mktemp --suffix=".glyphs")

awk '/name = Retina;/ { print; print "exports = 0;"; next }1' \
	"${glyphs_file}" > "${vf_glyphs}"

fontmake -g "${vf_glyphs}" -o variable --output-path "${file}"
rm -f "${vf_glyphs}"

# fix variable font metadata – very important
gftools fix-vf-meta "${file}"
mv "${file}.fix" "${file}"

# other fixes for metadata and hinting
gftools fix-nonhinting "${file}" "${file}.fix"
mv "${file}.fix" "${file}"

gftools fix-gasp --autofix "${file}"
mv "${file}.fix" "${file}"

gftools fix-dsig --autofix "${file}"

# cleanup of temp files
rm -rf "${dir}/"*-gasp.ttf

# TODO (late 2019?): use TTFautohint-VF for variable font (current support is minimal)
