#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "$(dirname "$0")/.."

glyphs_file=${FIRACODE_GLYPHS_FILE:-"FiraCode.glyphs"}

code_blocks=()

for feat in "$@"; do

	file="features/${feat}.fea"
	if [ ! -f "${file}" ]; then
		echo "Error: No file for feature ${feat} found!" >&2
		exit 1
	fi

	# don't grab the "lookup" surroundings or comments or whitespace lines
	code="$(grep -v '^[[:space:]]*lookup\|^[[:space:]]*}\|^[[:space:]]*#\|^[[:space:]]*$' "${file}")" \
		|| { echo "Error: No code for feature ${feat} found!" >&2; exit 1; }

	code_blocks+=("$(tr '\n' ' ' <<< "${code}")")
done

# code block is one line above name declaration
linenum=$(sed -n "/name = calt;/=" "${glyphs_file}")
linenum=$((linenum - 1))
# replace end of line (";) with code on specified line number
sed -i -e "${linenum}s@\";\$@\n${code_blocks[*]}\";@" "${glyphs_file}"
