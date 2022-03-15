#!/bin/bash
set -o errexit -o pipefail
cd "$(dirname "$0")"

features=()
weights=()
gen_glyphs_file_only=0
use_features_for_family_name=0
export FIRACODE_FAMILY_NAME="Fira Code"

########### Parsing inputs ########### {{{
check_required_args()
{
	if [ -z "$2" ] || [ "${2:0:1}" = "-" ]; then
		echo "Error: Missing argument for '$1'" >&2
		return 1
	fi
	return 0
}
while [ $# -gt 0 ]; do
	# split parameters like '-f="1,2,3"' into '-f "1,2,3"'
	[[ "$1" == -*=* ]] && set -- "${1%%=*}" "${1#*=}" "${@:2}"
	case "$1" in
		-f | --features)
			check_required_args "$1" "$2" || exit 1
			# turn comma separated list into sorted array
			IFS=',' read -r -a features <<< "$(echo "$2" | tr ',' '\n' | sort -u | tr '\n' ',')"
			shift 2 # remove two params (flag + arg)
			;;
		-w | --weights)
			check_required_args "$1" "$2" || exit 1
			IFS=',' read -r -a weights <<< "$2"
			shift 2 # remove two params (flag + arg)
			;;
		-n | --family-name)
			check_required_args "$1" "$2" || exit 1
			if [ "$2" = "features" ]; then
				use_features_for_family_name=1
			else
				FIRACODE_FAMILY_NAME=$2
			fi
			shift 2 # remove two params (flag + arg)
			;;
		-g | --generate-glyphs-only)
			gen_glyphs_file_only=1
			shift 1
			;;
		-*) # unsupported flags
			echo "Error: Unsupported flag '$1'" >&2
			exit 1
			;;
		*) # positional parameters
			echo "Error: No use case for positional paramter '$1'" >&2
			exit 1
			;;
	esac
done
########### ############## ########### }}}

# Create a temporary file that can be manipulated without messing with the original
FIRACODE_GLYPHS_FILE=$(mktemp)
mv "${FIRACODE_GLYPHS_FILE}" "${FIRACODE_GLYPHS_FILE}.glyphs"
FIRACODE_GLYPHS_FILE="${FIRACODE_GLYPHS_FILE}.glyphs"
export FIRACODE_GLYPHS_FILE
cp ../FiraCode.glyphs "${FIRACODE_GLYPHS_FILE}"

feat_string=""
if [ -n "${features[*]}" ]; then
	echo "Creating font with these features: ${features[*]}"
	./bake_in_features.sh "${features[@]}"

	feat_string=" ${features[*]}"
fi

if [ "${use_features_for_family_name}" -ne 0 ]; then
	FIRACODE_FAMILY_NAME=${FIRACODE_FAMILY_NAME}${feat_string}
fi

if [ "${FIRACODE_FAMILY_NAME}" != "Fira Code" ]; then
	tmp_glyphs=$(mktemp)
	echo "Creating font with family name: ${FIRACODE_FAMILY_NAME}"

	awk '/familyName = "Fira Code";/ {$0=nc}1' nc="familyName = \"${FIRACODE_FAMILY_NAME}\";" \
		"${FIRACODE_GLYPHS_FILE}" > "${tmp_glyphs}"

	mv "${tmp_glyphs}" "${FIRACODE_GLYPHS_FILE}"
fi

cp "${FIRACODE_GLYPHS_FILE}" "../${FIRACODE_FAMILY_NAME}.glyphs"
echo "Generated glyphs file: ${FIRACODE_FAMILY_NAME}.glyphs"

if [ "${gen_glyphs_file_only}" -ne 0 ]; then
	echo "Custom .glyphs file created. Exiting here!"
	exit 0
fi

./build_ttf.sh "${weights[@]}"
./build_variable.sh
./build_woff2.sh
./build_woff.sh

rm -f "${FIRACODE_GLYPHS_FILE}"
