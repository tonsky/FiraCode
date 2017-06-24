### Changelog

All notable changes to this project will be documented in this file.

#### 1.204 (November 6, 2016)

- Added `U+25B6` (black right-pointing triangle) and `U+25C0` (black left-pointing triangle) ([#289])
- Changed look of Markdown headers `##` `###` `####` to make them easier to tell apart ([#287])
- Fixed BBEdit incorrectly applying ligatures after tab ([#274])
- Returned Nim pragmas `{.` `.}` ([#279])
- Added Unicode increment `U+2206` ([#174], [#298])
- Added fish operators `>->` `<-<` ([#297])
- Added safe navigation operators `?.` `.?` `?:` ([#215])
- Added `<~>` ([#179], used in IntelliJ for collapsed methods)
- Added F# piping operators `||>` `|||>` `<||` `<|||` ([#184])
- Added shebang `#!` ([#169], [#193])

#### 1.203 (September 17, 2016)

- Added `__` ([#120], [#269])

#### 1.202 (September 17, 2016)

- Removed `{.` `.}` `[.` `.]` `(.` `.)` ([#264])

#### 1.201 (August 30, 2016)

- Removed `[]` ([#92]) `{-` `-}` ([#248])
- Removed `/**` `**/` and disabled ligatures for `/*/` `*/*` sequences ([#219] [#238])
- Added `]#` `{.` `.}` `[.` `.]` `(.` `.)` ([#214])

#### 1.200 (July 18, 2016)

- Removed `!!!` `???` `;;;` `&&&` `|||` `=~` ([#167]) `~~~` `%%%`
- New safer `calt` code that doesn’t  apply ligatures to long sequences of chars, e.g. `!!!!`, `>>>>`, etc ([#49], [#110], [#176])
- Larger `+` `-` `*` and corresponding ligatures ([#86])
- Hexadecimal `x` (`0xFF`) is now applied to sequences like `128x128` as well ([#161])
- Added twoTurned (U+218A) and threeTurned (U+218B) ([#146])
- Added whiteFrowningFace (U+2639) ([#190])
- Simplified visual style on markdown headers `##` `###` `####` ([#107])
- Added `</>` ([#147])
- Provided ttf and webfonts versions (eot, woff, woff2) ([#18], [#24], [#38], [#101], [#106])
- Increased spacing in `<=` `>=` ([#117])

#### 1.102

- Support for IntelliJ-based IDEs ([instructions](https://github.com/tonsky/FiraCode/wiki/Intellij-products-instructions))
- Turned on autohinting

#### 1.101

- Added Light weight
- Adjusted rules when vertical centering of `:`, `-`, `*` and `+` occurs

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

Fira Code is now drawn and built in Glyphs 2 app (should improve compatibility).

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
- `===` and `!==` are now rendered with 3 horizontal bars

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

[#18]: https://github.com/tonsky/FiraCode/issues/18
[#24]: https://github.com/tonsky/FiraCode/issues/24
[#38]: https://github.com/tonsky/FiraCode/issues/38
[#49]: https://github.com/tonsky/FiraCode/issues/49
[#86]: https://github.com/tonsky/FiraCode/issues/86
[#92]: https://github.com/tonsky/FiraCode/issues/92
[#101]: https://github.com/tonsky/FiraCode/issues/101
[#106]: https://github.com/tonsky/FiraCode/issues/106
[#107]: https://github.com/tonsky/FiraCode/issues/107
[#110]: https://github.com/tonsky/FiraCode/issues/110
[#117]: https://github.com/tonsky/FiraCode/issues/117
[#120]: https://github.com/tonsky/FiraCode/issues/120
[#146]: https://github.com/tonsky/FiraCode/issues/146
[#147]: https://github.com/tonsky/FiraCode/issues/147
[#161]: https://github.com/tonsky/FiraCode/issues/161
[#167]: https://github.com/tonsky/FiraCode/issues/167
[#169]: https://github.com/tonsky/FiraCode/issues/169
[#174]: https://github.com/tonsky/FiraCode/issues/174
[#176]: https://github.com/tonsky/FiraCode/issues/176
[#179]: https://github.com/tonsky/FiraCode/issues/179
[#184]: https://github.com/tonsky/FiraCode/issues/184
[#190]: https://github.com/tonsky/FiraCode/issues/190
[#193]: https://github.com/tonsky/FiraCode/issues/193
[#214]: https://github.com/tonsky/FiraCode/issues/214
[#215]: https://github.com/tonsky/FiraCode/issues/215
[#219]: https://github.com/tonsky/FiraCode/issues/219
[#238]: https://github.com/tonsky/FiraCode/issues/238
[#248]: https://github.com/tonsky/FiraCode/issues/248
[#264]: https://github.com/tonsky/FiraCode/issues/264
[#269]: https://github.com/tonsky/FiraCode/issues/269
[#274]: https://github.com/tonsky/FiraCode/issues/274
[#279]: https://github.com/tonsky/FiraCode/issues/279
[#287]: https://github.com/tonsky/FiraCode/issues/287
[#289]: https://github.com/tonsky/FiraCode/issues/289
[#297]: https://github.com/tonsky/FiraCode/issues/297
[#298]: https://github.com/tonsky/FiraCode/issues/298
