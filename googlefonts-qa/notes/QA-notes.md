# QA Notes – checking & polishing Fira Code for Google Fonts

- [x] autohint static TTFs
- [ ] check extrapolated outlines for issues

## Checks to resolve



======================================================================================

## Waiting on others

<details>
<summary>🔥 <b>FAIL:</b> Copyright notices match canonical pattern in fonts</summary>

* [com.google.fonts/check/font_copyright](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/font_copyright)
* 🔥 **FAIL** Name Table entry: Copyright notices should match a pattern similar to: 'Copyright 2017 The Familyname Project Authors (git url)'
But instead we have got: 'Copyright 2012-2015 The Mozilla Foundation, Telefonica S.A., and Nikita Prokopov (https://github.com/tonsky/FiraCode)'

</details>

- additionally, it's unclear how the original copyright on Fira Mono & Fira Code should best be integrated to credit all designers involved

- [x] file issue on fontbakery (https://github.com/googlefonts/fontbakery/issues/2419)
- [x] confirm that current approach is fine (https://github.com/google/fonts/issues/1460#issuecomment-476713822) (seems okay, based on Hangouts discussion)

----------------------------

<details>
<summary><b>[119] FiraCode-Light.ttf</b></summary>
<details>
<summary>🔥 <b>FAIL:</b> Checking file is named canonically.</summary>

* [com.google.fonts/check/canonical_filename](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/canonical_filename)
* 🔥 **FAIL** This is a variable font, but it is using a naming scheme typical of a static font.
* 🔥 **FAIL** Please change the font filename to use one of the following valid suffixes for variable fonts: VF, Italic-VF, Roman-VF

</details>

- [x] ask if/when this is changing (via hangouts) – Marc: "We’ll batch the vfs once they’ve implemented it"

----------------------------

======================================================================================

## Edits and corrected FontBakery checks



<details>
<summary>⚠ <b>WARN:</b> Stricter unitsPerEm criteria for Google Fonts. </summary>

* [com.google.fonts/check/unitsperem_strict](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/unitsperem_strict)
* ⚠ **WARN** Even though unitsPerEm (1000) in this font is reasonable. It is strongly advised to consider changing it to 2000, since it will likely improve the quality of Variable Fonts by avoiding excessive rounding of coordinates on interpolations.

</details>

- [x] scale UPM to 2000

----------------------------

<details>
<summary>🔥 <b>FAIL:</b> Are there non-ASCII characters in ASCII-only NAME table entries?</summary>

* [com.google.fonts/check/name/ascii_only_entries](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/name/ascii_only_entries)
* 🔥 **FAIL** There are 1 strings containing non-ASCII characters in the ASCII-only NAME table entries.
* ℹ **INFO** Bad string at [nameID 0, 'utf_16_be']: 'b'Copyright &#169; 2015 by Nikita Prokopov''

</details>

- [x] remove © symbol

----------------------------

<details>
<summary><b>[31] Family checks</b></summary>
<details>
<summary>🔥 <b>FAIL:</b> METADATA.pb: According Google Fonts standards, families should have a Regular style.</summary>

* [com.google.fonts/check/metadata/has_regular](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/metadata/has_regular)
* 🔥 **FAIL** This family lacks a Regular (style: normal and weight: 400) as required by Google Fonts standards.

</details>

- [x] this issue is already filed with fontbakery (https://github.com/googlefonts/fontbakery/issues/2378)

----------------------------

<details>
<summary>🔥 <b>FAIL:</b> Checking OS/2 usWinAscent & usWinDescent.</summary>

* [com.google.fonts/check/family/win_ascent_and_descent](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/family/win_ascent_and_descent)
* 🔥 **FAIL** OS/2.usWinAscent value should be equal or greater than 1050, but got 935 instead [code: ascent]
* 🔥 **FAIL** OS/2.usWinDescent value should be equal or greater than 500, but got 265 instead [code: descent]

</details>

- [x] run script to correct vertical metrics, recheck
- [x] ~~add issue~~ issue exists to gf-docs to update vertical metrics to recommendation at https://github.com/googlefonts/fontbakery/issues/2164#issuecomment-436595886 (will track / manage separately)


----------------------------

<details>
<summary>🔥 <b>FAIL:</b> Glyph names are all valid?</summary>

* [com.google.fonts/check/valid_glyphnames](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/valid_glyphnames)
* 🔥 **FAIL** The following glyph names do not comply with naming conventions: ['numbersign_numbersign_numbersign.liga', 'numbersign_numbersign_numbersign_numbersign.liga', 'numbersign_underscore_parenleft.liga', 'backslash_backslash_backslash.rem', 'numbersign_numbersign_numbersign.liga.rem', 'numbersign_numbersign_numbersign_numbersign.liga.rem', 'semicolon_semicolon_semicolon.rem', 'quadrantUpperLeftAndLowerLeftAndLowerRight', 'quadrantUpperLeftAndUpperRightAndLowerLeft', 'quadrantUpperLeftAndUpperRightAndLowerRight', 'quadrantUpperRightAndLowerLeftAndLowerRight', 'whiteSquareWithUpperLeftQuadrant', 'whiteSquareWithLowerLeftQuadrant', 'whiteSquareWithLowerRightQuadrant', 'whiteSquareWithUpperRightQuadrant', 'asciitilde_asciitilde_greater.liga', 'ampersand_ampersand_ampersand.rem', 'asciitilde_asciitilde_asciitilde.rem'] A glyph name may be up to 31 characters in length, must be entirely comprised of characters from the following set: A-Z a-z 0-9 .(period) _(underscore). and must not start with a digit or period. There are a few exceptions such as the special character ".notdef". The glyph names "twocents", "a1", and "_" are all valid, while "2cents" and ".twocents" are not.

</details>

- [x] issue filed at https://github.com/tonsky/FiraCode/issues/730 – I'm guessing this won't cause any real issues on the web fonts.
    - I'll leave these glyphs as they are for now, and let @tonsky handle it if it seems to be the cause of an actual user issue

----------------------------

<details>
<summary>🔥 <b>FAIL:</b> Variable font weight coordinates must be multiples of 100.</summary>

* [com.google.fonts/check/varfont_weight_instances](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/varfont_weight_instances)
* 🔥 **FAIL** Found an variable font instance with 'wght'=450.0. This should instead be a multiple of 100.

</details>

- (fontmake also started to fail, as "Retina" instance was given a custom param of `weightClass: 900`)

- [x] uncheck "Retina" instance as `is active` instance
- [x] file issue with FontBakery to ask Dave/Marc about this `450` weight "Retina" instance (https://github.com/googlefonts/fontbakery/issues/2420)- 
- [x] change if you find a better approach to keep Retina without disrupting builds / Regular weight
  - To set up the instance in GlyphsApp such that it exports a font as expected: "Retina" gets a custom parameter of `weightClass: 450`, and a glyphs menu-weight of "Normal." Tested in axis-praxis, it seems to work well. All instances have a `weightClass` custom parameter.
  
----------------------------

<details>
<summary>🔥 <b>FAIL:</b> Checking OS/2 usWeightClass.</summary>

* [com.google.fonts/check/usweightclass](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/usweightclass)
* 🔥 **FAIL** OS/2 usWeightClass expected value for 'Light' is 300 but this font has 400.

</details>

- [ ] explore to find why this would be happening ... 
  - Encode Sans gets an OS/2 usWeightClass of `100`, matching its default instance.
  
**Solution**
- Custom Parameters of `Axis Location` needed to be set in source masters (https://github.com/googlei18n/fontmake/issues/540)

----------------------------