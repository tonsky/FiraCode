#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "`dirname $0`/.."

brew install python@3.12
python3.12 -m venv venv
source venv/bin/activate

brew install pkg-config
brew install zlib
export PKG_CONFIG_PATH="/opt/homebrew/opt/libffi/lib/pkgconfig"
pip install -r requirements.txt
brew install ttfautohint
brew install woff2
brew tap bramstein/webfonttools
brew install sfnt2woff-zopfli