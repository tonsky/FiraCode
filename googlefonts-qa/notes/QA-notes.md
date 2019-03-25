# QA Notes – checking & polishing Fira Code for Google Fonts

- [ ] autohint static TTFs

## Checks to resolve

----------------------------
<details>
<summary>🔥 <b>FAIL:</b> Variable font weight coordinates must be multiples of 100.</summary>

* [com.google.fonts/check/varfont_weight_instances](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/varfont_weight_instances)
* 🔥 **FAIL** Found an variable font instance with 'wght'=450.0. This should instead be a multiple of 100.

</details>

- (fontmake also started to fail, as "Retina" instance was given a custom param of `weightClass: 900`)

- [x] uncheck "Retina" instance as `is active` instance
- [ ] file issue with FontBakery to ask Dave/Marc about this `450` weight "Retina" instance

----------------------------

<details>
<summary>🔥 <b>FAIL:</b> Checking OS/2 usWinAscent & usWinDescent.</summary>

* [com.google.fonts/check/family/win_ascent_and_descent](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/family/win_ascent_and_descent)
* 🔥 **FAIL** OS/2.usWinAscent value should be equal or greater than 1050, but got 935 instead [code: ascent]
* 🔥 **FAIL** OS/2.usWinDescent value should be equal or greater than 500, but got 265 instead [code: descent]

</details>

- [ ] run script to correct vertical metrics, recheck


----------------------------

<details>
<summary>🔥 <b>FAIL:</b> Are there non-ASCII characters in ASCII-only NAME table entries?</summary>

* [com.google.fonts/check/name/ascii_only_entries](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/name/ascii_only_entries)
* 🔥 **FAIL** There are 1 strings containing non-ASCII characters in the ASCII-only NAME table entries.
* ℹ **INFO** Bad string at [nameID 0, 'utf_16_be']: 'b'Copyright &#169; 2015 by Nikita Prokopov''

</details>

- [ ] remove © symbol

======================================================================================

## Edits and corrected FontBakery checks



<details>
<summary>⚠ <b>WARN:</b> Stricter unitsPerEm criteria for Google Fonts. </summary>

* [com.google.fonts/check/unitsperem_strict](https://github.com/googlefonts/fontbakery/search?q=com.google.fonts/check/unitsperem_strict)
* ⚠ **WARN** Even though unitsPerEm (1000) in this font is reasonable. It is strongly advised to consider changing it to 2000, since it will likely improve the quality of Variable Fonts by avoiding excessive rounding of coordinates on interpolations.

</details>

- [x] scale UPM to 2000

----------------------------