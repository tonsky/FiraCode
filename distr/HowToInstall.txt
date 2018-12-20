Return to [FiraCode](https://github.com/tonsky/FiraCode)

### [](#installing-font)Installing font

Windows:

*   In the ttf folder, double-click each font file, click “Install font”; to install all at once, select all files, right-click, and choose “Install”

_or_

*   Use [chocolatey](https://chocolatey.org): `choco install firacode`

Mac:

In the downloaded TTF folder:

1.  Select all font files
2.  Right click and select `Open` (alternatively `Open With Font Book`)
3.  Select "Install Font"

_or_

*   Use [brew](http://brew.sh) and [cask](https://caskroom.github.io):

    _Not officially supported, might install outdated version_

    <div class="highlight highlight-source-shell">

    brew tap caskroom/fonts
    brew cask install font-fira-code



Linux:

*   Install a package available for your distribution following [the instructions](https://github.com/tonsky/FiraCode/wiki/Linux-instructions#installing-with-a-package-manager)

_or_

*   In the ttf folder double-click each font file and click “Install font”; see [“Manual Installation”](https://github.com/tonsky/FiraCode/wiki/Linux-instructions#manual-installation) if double-clicking doesn't work

FreeBSD:

*   Using pkg(8): `pkg install firacode`

_or_

*   Using ports: `cd /usr/ports/x11-fonts/firacode && make install clean`

### [](#how-to-enable-ligatures)How to enable ligatures

You need to explicitly enable ligatures support in following editors:

*   [Atom](https://github.com/tonsky/FiraCode/wiki/Atom-instructions)
*   [Brackets](https://github.com/tonsky/FiraCode/wiki/Brackets-Instructions/)
*   [Cloud9](https://github.com/tonsky/FiraCode/wiki/cloud9-instructions)
*   [Jetbrains' products](https://github.com/tonsky/FiraCode/wiki/Intellij-products-instructions) (IntelliJ, etc)
*   [Emacs](https://github.com/tonsky/FiraCode/wiki/Emacs-instructions)
*   [MacVim](https://github.com/tonsky/FiraCode/wiki/MacVim-instructions)
*   [VS Code](https://github.com/tonsky/FiraCode/wiki/VS-Code-Instructions)
*   [BBEdit](https://github.com/tonsky/FiraCode/wiki/BBEdit-instructions)
*   [LightTable](https://github.com/tonsky/FiraCode/wiki/LightTable-instructions)
*   [Sublimetext](https://github.com/tonsky/FiraCode/wiki/Sublimetext-Instructions)

For other editors it must be enough to simply select Fira Code as your font of choice. [Full list of supported editors](https://github.com/tonsky/FiraCode#editor-support)

### [](#troubleshooting)Troubleshooting

#### [](#1-make-sure-the-font-your-editor-displays-is-actually-fira-code)1\. Make sure the font your editor displays is actually Fira Code

Easiest way is to compare the shape of `@` `&` and `r` with the reference image:

![](https://user-images.githubusercontent.com/285292/26971424-c609be76-4d15-11e7-8684-23e7b1c08929.png)

Issues: [#393](https://github.com/tonsky/FiraCode/issues/393) [#373](https://github.com/tonsky/FiraCode/issues/373) [#227](https://github.com/tonsky/FiraCode/issues/227)

#### [](#2-make-sure-youve-enabled-ligatures-in-your-editor)2\. Make sure you’ve enabled ligatures in your editor

Consult this wiki (see above ↑) for instruction on how to do that.

Issues: [#291](https://github.com/tonsky/FiraCode/issues/291)

#### [](#3-make-sure-youre-on-the-latest-version-of-fira-code)3\. Make sure you’re on the latest version of Fira Code

Consult [CHANGELOG](https://github.com/tonsky/FiraCode/blob/master/CHANGELOG.md) to see when it was last updated.

#### [](#4-check-the-list-of-known-issues-below-)4\. Check the list of known issues below ↓

### [](#known-issues)Known issues

#### [](#hinting-issues)Hinting issues

*   Uneven spacing in `===` and `!==` at certain font sizes, esp. on Windows [#405](https://github.com/tonsky/FiraCode/issues/405) [#243](https://github.com/tonsky/FiraCode/issues/243) [#119](https://github.com/tonsky/FiraCode/issues/119) [#114](https://github.com/tonsky/FiraCode/issues/114)

*   Different height of `[]` at certain font sizes [#332](https://github.com/tonsky/FiraCode/issues/332) [#251](https://github.com/tonsky/FiraCode/issues/251)

#### [](#powerline-characters-are-of-slightly-wrong-size)Powerline characters are of slightly wrong size

Unfortunately this can’t be fixed for all terminals because they have different ways of calculate font metrics. See [this comment](https://github.com/tonsky/FiraCode/issues/44#issuecomment-187305276)

Issues: [#426](https://github.com/tonsky/FiraCode/issues/426) [#131](https://github.com/tonsky/FiraCode/issues/131) [#44](https://github.com/tonsky/FiraCode/issues/44)

#### [](#some-ligatures-work-while-some-dont)Some ligatures work while some don’t

This is an issue with your editor and how it handles tokenization/syntax highlighting. Nothing can be done in a font to work around that. Report your problem to the corresponding editor’s issue tracker.

*   All ligatures with dashes in Visual Studio (not Code) [#422](https://github.com/tonsky/FiraCode/issues/422) [#395](https://github.com/tonsky/FiraCode/issues/395) [#360](https://github.com/tonsky/FiraCode/issues/360) [#273](https://github.com/tonsky/FiraCode/issues/273) [#259](https://github.com/tonsky/FiraCode/issues/259) [#233](https://github.com/tonsky/FiraCode/issues/233) [#220](https://github.com/tonsky/FiraCode/issues/220) [#196](https://github.com/tonsky/FiraCode/issues/196) [#181](https://github.com/tonsky/FiraCode/issues/181) [#157](https://github.com/tonsky/FiraCode/issues/157) [#99](https://github.com/tonsky/FiraCode/issues/99) [#43](https://github.com/tonsky/FiraCode/issues/43) [#32](https://github.com/tonsky/FiraCode/issues/32)

*   Ligatures in column 100 in VS Code [#403](https://github.com/tonsky/FiraCode/issues/403) [#397](https://github.com/tonsky/FiraCode/issues/397) [#372](https://github.com/tonsky/FiraCode/issues/372)

*   Atom/VS Code are known to break certain ligatures in certain syntaxes [#361](https://github.com/tonsky/FiraCode/issues/361) [#353](https://github.com/tonsky/FiraCode/issues/353) [#348](https://github.com/tonsky/FiraCode/issues/348) [#328](https://github.com/tonsky/FiraCode/issues/328) [#326](https://github.com/tonsky/FiraCode/issues/326) [#235](https://github.com/tonsky/FiraCode/issues/235)

#### [](#corrupted-font-in-intellij-on-windows)Corrupted font in IntelliJ on Windows

Go to `C:\Windows\Fonts` with `cmd.exe`, find and delete everything having Fira in the file name. It’s important that you use terminal commands, not Explorer.

Issues: [#589](https://github.com/tonsky/FiraCode/issues/589) [#581](https://github.com/tonsky/FiraCode/issues/581) [#398](https://github.com/tonsky/FiraCode/issues/398) [IDEA-159901](https://youtrack.jetbrains.com/issue/IDEA-159901)

#### [](#anything-related-to-italics)Anything related to italics

Fira Code does not have italics at all. If you see italicized glyphs it means your editor is “faking” them.

Issues: [#375](https://github.com/tonsky/FiraCode/issues/375) [#320](https://github.com/tonsky/FiraCode/issues/320) [#281](https://github.com/tonsky/FiraCode/issues/281)