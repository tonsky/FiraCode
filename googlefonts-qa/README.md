# Onboarding to Google Fonts

This directory is made to run a Google Fonts onboarding process for Inter.

The `build.sh` script builds variable and static font files as required by Google Fonts.

The `move-check.sh` script does a few things:
- Fixes a few pieces of font metadata to align them to Google Fonts standards
- Moves font files into a google/fonts directory, to prep/update a PR to [the official google/fonts repo](https://github.com/google/fonts)
- Runs [FontBakery](https://github.com/googlefonts/fontbakery) to check the fonts against Google Fonts standards, and saves results to the [checks](checks) subfolder.

This process must be run multiple times, tweaking source files and rebuilding output fonts to solve issues flagged by FontBakery.