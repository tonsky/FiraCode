#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "`dirname $0`/.."

brew install python@3.12
python3.12 -m venv venv
source venv/bin/activate

## https://github.com/googlefonts/gftools/issues/121
brew install pkg-config
brew install zlib
pip install -U Pillow==8.0.1 idna==2.8 requests==2.21.0 urllib3==1.24.1
export PKG_CONFIG_PATH="/opt/homebrew/opt/libffi/lib/pkgconfig"
pip install pycairo
pip install gftools

pip install fontmake
brew install ttfautohint
brew install woff2
brew tap bramstein/webfonttools
brew install sfnt2woff-zopfli
pip install fontbakery