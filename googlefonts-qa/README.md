# Onboarding to Google Fonts

This directory is made to run a Google Fonts onboarding process for Fira Code.

The `build.sh` script builds variable and static font files as required by Google Fonts.

The `move-check.sh` script does a few things:
- Fixes a few pieces of font metadata to align them to Google Fonts standards
- Moves font files into a google/fonts directory, to prep/update a PR to [the official google/fonts repo](https://github.com/google/fonts)
- Runs [FontBakery](https://github.com/googlefonts/fontbakery) to check the fonts against Google Fonts standards, and saves results to the [checks](checks) subfolder.

This process must be run multiple times, tweaking source files and rebuilding output fonts to solve issues flagged by FontBakery.

## USAGE

### First, setup prerequisites

If you haven't already done so, open a terminal, clone this repo, and move to the `qa` branch:

```
git clone git@github.com:thundernixon/firacode.git
cd firacode
git checkout qa
```

FontBakery checks are made to be run on fonts within the folder structure of the [google/fonts repo](https://github.com/google/fonts). Therefore, you must have a local copy of this repo on your computer to run this QA procedure. If you don't yet have a local google/fonts repo, open a new terminal session, navigate to a parent folder for this (e.g. `cd ~/yourusername/type_repos`, but use whatever location makes sense), and clone the repo:

```
git clone git@github.com:google/fonts.git
```

### Second, set up your testing environment

Create a Python 3 virtual environment:

```
virtualenv -p python3 build/venv
```

Then, activate the new virtual environment:

```
source venv/bin/activate
```

Now, install the QA dependencies:

```
pip install -U -r googlefonts-qa/scripts/requirements.txt
```

Give the build and move-check scripts permission to run:

```
chmod +x googlefonts-qa/scripts/build.sh
chmod +x googlefonts-qa/scripts/move-check.sh
```

### Third, use scripts to build fonts, then move and check

With your terminal at the top level of your Fira Code directory, build fresh copies of the relevant fonts by running:

```
googlefonts-qa/scripts/build.sh
```

When that completes, run the move-check script (using the path to your local `google/fonts` repo as an argument):

```
move-check <absolute_path_to_parent_dir>/fonts
```

If all goes well, you will have created a local `firacode` branch in your google fonts directory, moved the fresh fonts there, and run QA checks which will create new markdown documents at `googlefonts-qa/scripts/checks`. If following this guide doesn't work, please file an issue at `thundernixon/firacode`.
