## Fira Code: monospaced font with programming ligatures

<img src="https://dl.dropboxusercontent.com/u/561580/imgs/fira_code_logo.svg">

#### [Download Fira Code v1.100](https://github.com/tonsky/FiraCode/releases/download/1.100/FiraCode_1.100.zip)

### Problem

Programmers use a lot of symbols, often encoded with several characters. For human brain sequences like `->`, `<=` or `:=` are single logical token, even if they take two or three places on the screen. Your eye spends non-zero amount of energy to scan, parse and join multiple characters into a single logical one. Ideally, all programming languages should be designed with full-fledged Unicode symbols for operators, but that’s not the case yet.

### Solution

Fira Code is a Fira Mono font extended with a set of ligatures for common programming multi-character combinations. This is just a font rendering feature: underlying code remains ASCII-compatible. This helps to read and understand code faster. For some frequent sequences like `..` or `//` ligatures allow us to correct spacing.

<img src="./showcases/all_ligatures.png" />

### Editor support

Do **not** work:

- SublimeText ([vote here](http://sublimetext.userecho.com/topic/433445-opentype-support-ligatures-curly-quotes-contextual-and-alternate-symbols/))
- Intellij Idea ([vote here](https://youtrack.jetbrains.com/issue/IDEA-127539)), including everything built on top of it (PhpStorm, PyCharm, RubyMine, WebStorm, AppCode, CLion, ReSharper)
- iTerm 2 ([feature request](https://gitlab.com/gnachman/iterm2/issues/3568))
- OS X Terminal.app
- Emacs ([workaround](https://github.com/tonsky/FiraCode/wiki/Setting-up-Emacs))
- gVim, MacVim
- Eclipse (Mac and Win, [vote here](https://bugs.eclipse.org/bugs/show_bug.cgi?id=398656))
- Notepad++
- Kate, Konsole, KWrite in KDE 4
- Xamarin Studio/Monodevelop

Do work:

- Atom (since [1.1](http://blog.atom.io/2015/10/29/atom-1-1-is-out.html), add `atom-text-editor { text-rendering:optimizeLegibility }` to the stylesheet)
- Xcode (with [this plugin](https://github.com/robertvojta/LigatureXcodePlugin))
- Visual Studio
- TextMate 2
- Coda 2
- Eclipse (Linux)
- QtCreator
- LightTable ([instructions](https://github.com/LightTable/LightTable/issues/1459#issuecomment-57366504))
- BBEdit — enter this command in a terminal to enable ligatures:  
  `defaults write com.barebones.bbedit "EnableFontLigatures_Fira Code" -bool YES`
- RStudio
- Chocolat
- Kate, Konsole, KWrite in Plasma/KDE 5
- Kate, Konsole, KWrite in KDE 4 using Debian Jessie or OS X
- Mancy
- TextAdept (Mac)

Should work (copied from [Hasklig README](https://github.com/i-tu/Hasklig)):

- Geany
- gEdit
- Smultron
- Vico


### Code examples

Ruby:

<img src="./showcases/ruby.png" />

JavaScript:

<img src="./showcases/javascript.png" />

Erlang:

<img src="./showcases/erlang.png" />

Go:

<img src="./showcases/go.png" />

Haskell:

<img src="./showcases/haskell.png" />

### Alternatives

Another monospaced fonts with ligatures:

- [Hasklig](https://github.com/i-tu/Hasklig) (free)
- [PragmataPro](http://www.fsd.it/fonts/pragmatapro.htm) (€59)
- [Monoid](http://larsenwork.com/monoid/) (free)

### Credits

This work is based on OFL-licensed [Fira Mono font](https://github.com/mozilla/Fira). Original Fira Mono font was not changed, only extended.

Fira Code was inspired by [Hasklig font](https://github.com/i-tu/Hasklig): Ligatures for Haskell code.

Thanks Georg Seifert for providing a [Glyphs 2](https://glyphsapp.com) license.

### Changelog

#### 1.100

- Fixed calt table conflicts (`----` would incorrectly render as `<!--`)
- Added centered `:` (between digits, e.g. `10:40`)
- Added lowercase-aligned `-`, `*` and `+` (only between lowercase letters, e.g. kebab case `var-name`, pointers `*ptr` etc)


#### 1.000

Added weights:

- Retina (just slightly heavier than Regular)
- Medium
- Bold

Switched to `calt` instead of `liga`. You can now “step inside” the ligature in text editors.

Fira Code is now drawn and built in Glyps 2 app (should improve compatibility).

Added:

`<->` `<~~` `<~` `~~~` `~>` `~~>`  
`<$` `<+` `<*` `*>` `+>` `$>`  
`;;;` `:::` `!!!` `???` `%%` `%%%` `##` `###` `####`  
`.-` `#_(` `=<`  `**/` `0x` `www` `[]` 

Redrawn:

`{-` `-}` `~=` `=~` `=<<` `>>=` `<$>` `<=>` `.=`

Removed: `?:`

Total ligatures count: 115


#### 0.6

Redrawn from Fira Mono 3.204 (slightly heavier weight)

Added:

`**` `***` `+++` `--` `---` `?:`  
`/=` `/==` `.=` `^=` `=~` `?=` `||=` `|=`  
`<<<` `<=<` `-<<` `-<` `>-` `>>-` `>=>` `>>>`  
`<*>` `<|>` `<$>` `<+>`  
`<!--` `{-` `-}` `/**`  `\\` `\\\`
`..<` `??` `|||` `&&&` `<|` `|>`  
  
Added support for Powerline


#### 0.5

Added: `#{` `~-` `-~` `<==` `==>` `///` `;;` `</`


#### 0.4

- Added `~=` `~~` `#[`
- Rolled back `&&` and `||` to more traditional look
- `===` and `!==` are now rendered with 3 horisontal bars


#### 0.3

Added: `~@` `#?` `=:=` `=<`


#### 0.2.1

Fixed width of `&&` and `||`


#### 0.2

Added: `-->` `<--` `&&` `||` `=>>` `=/=`


#### 0.1

`>>=` `=<<` `<<=` `->>` `->` `=>` `<<-` `<-`  
`===` `==` `<=>` `>=` `<=` `>>` `<<` `!==` `!=` `<>`  
`:=` `++` `#(` `#_`  
`::` `...` `..` `!!` `//` `/*` `*/` `/>`  
