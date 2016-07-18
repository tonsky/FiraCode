#!/bin/bash

mv distr/*.eot distr/eot/     2> /dev/null
mv distr/*.woff distr/woff/   2> /dev/null
mv distr/*.woff2 distr/woff2/ 2> /dev/null
mv distr/*.ttf distr/ttf/     2> /dev/null
mv distr/*.otf distr/otf/     2> /dev/null
cp distr/otf/*.otf ~/Library/Fonts/