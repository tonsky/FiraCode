### Changelog

All notable changes to this project will be documented in this file.

#### 3.1 (April 15, 2020)

- Fixed width of Germandbls, cornerbracketleft, cornerbracketleft, negativeAcknowledge-control, cornerbracketleft.half, cornerbracketright.half [#1000]
- Fixed misplaced descenders on U+04B3 `ҳ` U+04CB `Ӌ` and U+04CC`ӌ` [#995]
- Fixed U+03F4 `ϴ` [#996]
- Fixed U+0314 COMBINING REVERSED COMMA ABOVE [#997]

#### 3.0 (April 9, 2020)

- Disabled ligatures in progress bars `[-> [--> [---> [=> [==> [===>` [#968]
- Added set letters U+2102 `ℂ` U+210D `ℍ` U+2115 `ℕ` U+2119 `ℙ` U+211A `ℚ` U+211D `ℝ` U+2124 `ℤ` and U+1D539 `𝔹` [#841]
- Removed `?:` [#970]
- Added missing set operations U+2200 `∀` U+2203..U+2205 `∃ ∄ ∅` U+2207 `∇` U+2282..U+228B `⊂ ⊃ ⊄ ⊅ ⊆ ⊇ ⊈ ⊉ ⊊ ⊋` U+2208..U+220# `∈ ∉ ∊ ∋ ∌ ∍` U+222A `∪` [#822]
- Added U+300C U+300D Corner brackets `「」` and U+FF62 U+FF63 Halfwidth Corner brackets `｢｣` [#940]
- Added `<<->>` [#919]
- Disabled `fl` `Fl` `Tl` ligatures, adjusted `l` height in combination with `[F T I f]` instead [#902]
- Added U+25A4..25A9 Squares with fill `▤▥▦▧▨▩` [#450]
- Slightly tuned multiple ampersands in `ss03` [#831]
- Fixed horizontal bar height in `<!--` [#917]
- Fixed multiply sign in `0xFF` and `10x10` with combination of `onum` and `zero` [#888]
- Fixed dollar sign in `<$` `$>` `<$>` when `ss04` is active [#830]
- Removed `ss19` and `ss20` (they are covered by `zero` and `onum`)
- Added `=~` and `!~` to `ss07` [#293]
- Removed `~=` [#381]
- Re-added `..=` with just a subtle spacing adjustment [#934]
- Added U+2630..U+2637 `☰☱☲☳☴☵☶☷` (Bagua trigrams) [#859]
- Disabled `<?=` (`?=` after `<`) [#850]
- Added SemiBold weight [#987]
- Replaced single LIG with per-glyph *.spacer

#### 2.0 (September 9, 2019)

- Characters U+25DE `◟` and U+25DF `◞` were swapped [#761]
- Added Box Drawing Light Arcs U+256D `╭` U+256E `╮` U+256F `╯` U+2570 `╰` [#349] [#702] [#714] [#725]
- Added Mathematical Angle Brackets U+27E8 `⟨` U+27E9 `⟩` [#763]
- Added Light and heavy dashed lines U+2504..U+250B `┄┅┆┇┈┉┊┋` [#702]
- Adjusted Box drawings double dashes U+254C..U+254F `╌╍╎╏`
- Fixed outlines of U+04FA `Ӻ` and U+04FB `ӻ` [#806]
- Added Not identical to U+2262 `≢` [#396]
- Added Latin Capital Letter Sharp S U+1E9E `ẞ` [#587]
- Tuned position and width of U+2044 Fraction Slash ` ⁄ ` [#588] and U+2215 Division Slash `∕` [#805]
- Added U+1405 Canadian Syllabics O `ᐅ` and U+140A Canadian Syllabics A `ᐊ` [#666]
- Added U+2234 Therefore `∴` and U+2235 Because `∵` [#669]
- Added U+239B..U+23AD multi-line brackets [#675]

```
⎛ 1 ⎞ ⎡ a ⎤ ⎧ x ⎫
⎜ 2 ⎟ ⎢ b ⎥ ⎪ y ⎪
⎜ 3 ⎟ ⎢ c ⎥ ⎨ z ⎬
⎜ 4 ⎟ ⎢ d ⎥ ⎪ y ⎪
⎝ 5 ⎠ ⎣ e ⎦ ⎩ x ⎭
```

- Added U+27F0..U+27FF Supplemental Arrows-A `⟲⟳⟰⟱⟴⟵⟶⟷⟸⟹⟺⟻⟼⟽⟾⟿` [#677]
- Added U+2400..U+2426 Control Pictures `␆␈␇␣␢␘␍␐␡␥␔␑␓␒␙␃␄␗␅␛␜␌␝␉␊␕␤␀␞␏␎␠␁␂␚␦␖␟␋` [#764]
- Added U+2388 Helm Symbol `⎈` [#766]
- Added U+2016 Double Vertical Line `‖` [#780]
- Tuned metrics (1870,-530 -> 1800,-600, upm 2000 -> 1950, hopefully fix [#241] [#252] [#459] [#552] [#798])
- Box characters to not overflow line height, taller `|` [#449]
- Added few technical symbols [#799]:
  - U+21A9 Leftwards arrow with hook (Return) `↩`
  - U+21DE Upwards arrow with double stroke (Page Up) `⇞`
  - U+21DF Downwards arrow with double stroke (Page down) `⇟`
  - U+21E4 Left Tab Arrow `⇤`
  - U+21E5 Right Tab Arrow `⇥`
  - U+2300 Diameter sign `⌀`
  - U+2303 Up Arrowhead (Control) `⌃`
  - U+2304 Down Arrowhead `⌄`
  - U+2305 Projective `⌅`
  - U+2306 Perspective `⌆`
  - U+2318 Place of interest sign (Command) `⌘`
  - U+2324 Up Arrowhead between two horizontal bars `⌤`
  - U+2325 Option Key `⌥`
  - U+2387 Alternative Key Symbol `⎇`
  - U+238B Broken Circle with Northwest Arrow (Escape) `⎋`
  - U+23CF Eject symbol `⏏`
- Added Coq logical and ` /\ ` and logical or ` \/ ` ligatures, U+2227 `∧` and U+2228 `∨` [#191] [#488] [#738] [#810]
- Added SystemVerilog `|->` `|=>` and `<-|` `<=|` for symmetry [#695]
- Added Forces `||-` ligature and U+22A2..U+22AF `⊢ ⊣ ⊤ ⊥ ⊦ ⊧ ⊨ ⊩ ⊪ ⊫ ⊬ ⊭ ⊮ ⊯` [#709]
- Added `fl` `Fl` `Tl` ligatures, adjusted `fi` `fj` pairs [#795]
- Disabled ligatures after regexp lookahead/lookbehinds `(?<=<` `(?<=>` `(?<==>` `(?<=|` `(?<==` `(?=:=` `(?=!=` `(?==` `(?===` `(?==>` `(?=>` `(?=>>` `(?=<<` `(?=/=` `(?!!` `(?!!.` `(?!=` `(?!==` `(?<!!` `(?<!!.` `(?<!=` `(?<!==` `(?<!--` [#578]
- Removed `..=` [#757]
- Alternatives (stylistic sets):
  - Lowercase `r` (ss01) [#601]
  - Less than/greater than `<=` `>=` (ss02) [#263] [#617]
  - Ampersand `&` (ss03) [#617]
  - Dollar sign `$` (ss04) [#617]
  - At sign `@` (ss05) [#617] [#748] [#817]
  - Thin backslash (ss06) [#577 #720 #825]
  - Dotted zero `0` (zero, ss19)
  - Old-style figures (onum, ss20) [#561] [#715]
- Old-style figures no longer prevent ligatures [#561] [#715]

#### 1.207 (April 6, 2019)

- Variable TTF, cleaned up [many small Light weight errors](https://github.com/thundernixon/FiraCode/blob/qa/googlefonts-qa/notes/outline-checks.md) (done by @thundernixon, PR #735)
- Dropped EOF which were only useful for IE 6-11
- Fixed different vertical position of `<=` `>=` in Light and Bold caused during [#483]

#### 1.206 (September 30, 2018)

- Added `<==>` ([#392]), `#:` ([#642]), `!!.` ([#618]), `>:` `:<` ([#605]), U+0305 Combining overline ([#608]), U+2610 Ballot box, U+2611 Ballot box with check, U+2612 Ballot box with x ([#384])
- Fixed incorrect width of `[` `**` ([#607])
- Redrew `{|` `|}` `[|` `|]` ([#643])
- Removed `{.` `.}` ([#635]), thin backslash ([#577])
- Disabled ligatures in `(?=` `(?<=` `(?:` ([#624]), `>=<` ([#548]), `{|}` `[|]` ([#593])
- Fixed ligatures precedence in `<||>` ([#621]), `:>=` ([#574]), `<<*>>` `<<<*>>>` `<<+>>` <<<+>>>` `<<$>>` `<<<$>>>` ([#410]), `!=<` ([#276])
- Fixed incorrectly swapped box drawing characters `╵` and `╷` ([#595])
- Adjusted vertical position of `<=` `>=` to align with `<` `>` ([#483])

#### 1.205 (February 27, 2018)

- Slashed zero by default ([#481] [#342])
- Adjusted vertical position of colon `:` near `{[()]}` ([#486])
- Thin backslash except when in `\\`, removed `\\\` ([#536])
- Added `:>` ([#547]) and `<:` ([#525])
- Removed `=<` ([#479] [#468] [#424] [#406] [#355] [#305])
- Added `::=` ([#539])
- Added `[|` `|]` ([#516]) `{|` `|}` ([#330])
- Added `✓` (U+2713)
- Added `..=` ([#433])
- Added `=!=` ([#338])
- Added `|-` `-|` `_|_` and adjusted `|=` `||=` ([#494])
- Added `#=` ([#208])

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

- Removed `!!!` `???` `;;;` `&&&` `|||` `=~` [#167] `~~~` `%%%`
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
