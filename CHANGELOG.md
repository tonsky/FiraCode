### Changelog

All notable changes to this project will be documented in this file.

### 6.2

- Fixed monospaced property #1325

### 6.1

- Fixed hinting settings to match Glyphs export #1315

### 6.0

Unicode:

- Fixed height of `∑` U+2211 N-ARY SUMMATION #1083
- Added U+2241..U+224B `≁ ≂ ≃ ≄ ≅ ≆ ≇ ≉ ≊ ≋` #1090
- Added new enclosed characters from Unicode 13 U+0229C `⊜`, U+1F10D `🄍`, U+1F10E `🄎`, U+1F10F `🄏`, U+1F16D `🅭`, U+1F16E `🅮`, U+1F16F `🅯`, U+1F1AD `🆭` #1070
- Redrew U+27F0..U+27FF Supplemental Arrows-A to be strict monospace `⟲⟳⟴⟵⟶⟷⟸⟹⟺⟻⟼⟽⟾⟿` #1109 #1123
- Added U+220E End of Proof `∎` #1115
- Added U+FFFD Replacement Character `�` #1137, thanks @gjvnq
- Added U+EE00..U+EE0B Progress Bar `` #1182
- Added U+2237 Proportion `∷` #1219
- Added U+21AA Rightwards Arrow with Hook `↪` #1307
  
Changed:

- Fixed weird look of `::<` `::>` `<::` `>::` #1145
- `---` now makes a line #1190

Removed:

- C-style compound assignment `>>=` `<<=` `||=` `|=` are not combined with equal sign by default. Old behavior is moved into `ss09` #974
- Restored short `|` by default, long one moved to `cv30` #843 #1160
- Moved `.-` into `cv25` #670 #860 #1103
- Moved `.=` into `cv32` #670
- Removed named “Retina” instance from FiraCode-VF.ttf (you can still get it by setting `wght=450`) #1318

Added (variants):

- Alternative `a` `cv01` #949
- Alternative `g` `cv02` #886
- Alternative `i` `cv03`-`cv06`
- Alternative `l` `cv07`-`cv10` #899
- Alternative `0` `cv11`-`cv13`
- Alternative `3` `cv14`
- Top-aligned `*` `cv15`
- Hexagonal `*` `cv16` #708 #1134
- Top-aligned `~` `cv17`
- Alternative `%` `cv18`
- `<=` with a horizontal bar `cv19`
- `<=` as an arrow `cv20` #34 #696 #858
- `=<` as less than or equal `cv21` #34
- `=<` as less than or equal with horizontal bar `cv22` #34
- `>=` with a horizontal bar `cv23`
- `/=` as not equals `cv24` #125
- Added `:-` to `cv26` #790
- Returned `[]` as `cv27`
- Returned `{. .}` as `cv28` #875 #635 #409 #279 #264 #214
- Alternative `{}` `cv29`
- Returned full ligatures for `Fl` `Tl` `fi` `fj` `fl` `ft` as `ss10`
- Alternative `()` `cv31` #1198

#### 5.2 (June 12, 2020)

- Fixed hinting problems caused by build_ttf #1075

#### 5.1 (June 10, 2020)

- Fixed monospace property broken by adding threeemdash #1073

#### 5.0 (June 8, 2020)

- Fixed Box drawing diagonal lines U+2571 `╱` U+2572 `╲` U+2573 `╳` #929
- Added U+2236 Ratio `∶` #926
- Added U+2E3A 2-em dash `⸺`, U+2E3B 3-em dash `⸻` #1019
- Fixed arrows next to lowercase letters #1049 #1059
- Vertically-aligned colons, greater/less signs #980 #1061
- Make U+2388 Helm Symbol `⎈` single-width #1036
- Disable `=/` because of conflicts with paths `PATH=/...` #1056
- Fixed STAT table in FiraCode-VF.ttf #770 #1054
- Added `//=` `=//` `=//=` #816 
- Added U+21B0..U+21B3 `↰ ↱ ↲ ↳`, U+2770..U+2771 `❰ ❱` #1032
- Fixed U+27F8 `⟸` U+27F9 `⟹` U+27FA `⟺` U+27FD `⟽` U+27FE `⟾` U+27FF `⟿` that were broken in v4 #1067
- Added `ss08` that adds gaps to `==` `===` `!=` `!==` #187 #383
- Removed OTF from distr to avoid confusion #939

#### 4.0 (May 18, 2020)

Removed 44 individual arrow ligatures, replaced with four universal, combinative substitutions. 100-150% faster shaping performance, infinite amount of arrow combinations.

- Arbitrary-long combinative hyphen-based arrows #346 #494 #713 #826 #968 #983 #1029
- Arbitrary-long combinative equal-based arrows #229 #234 #346 #494 #698 #826 #919 #931 #946 #948 #968 #1016 #1018 #1022 
- Arbitrary-long underscores #120 #269 #346 #494
- Arbitrary-long numbersign sequences #1014
- Fixed descender in U+040F `Џ`
- Undid #995 and properly fixed U+04CB `Ӌ`, U+04CC `ӌ` #1001 and  U+0449 `щ` #1007
- Added `|||` to prevent partial ligatures in `|||-|||` `|||=|||` #346

#### 3.1 (April 15, 2020)

- Fixed width of Germandbls, cornerbracketleft, cornerbracketleft, negativeAcknowledge-control, cornerbracketleft.half, cornerbracketright.half [#1000]
- Fixed misplaced descenders on U+04B3 `ҳ` U+04CB `Ӌ` and U+04CC `ӌ` [#995]
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
  - Ampersand `&` (ss03) [#371] [#617] 
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

- Support for IntelliJ-based IDEs ([instructions](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions))
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
