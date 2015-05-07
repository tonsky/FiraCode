## Fira Code: monospaced font with programming ligatures

#### [Download Fira Code v0.2.1](https://github.com/tonsky/FiraCode/releases/download/0.2.1/FiraCode-Regular.otf)

### Problem

Programmers use a lot of symbols, often encoded with several characters. For human brain sequences like `->`, `<=` or `:=` are single logical token, even if they take two or three places on the screen. Your eye spends non-zero amount of evergy to scan, parse and join multiple characters into a single logical one. Ideally, all programming languages should be designed with full-fledged Unicode symbols for operators, but that’s not the case yet.

### Solution

Fira Code is a Fira Mono font extended with a set of ligatures for common programming multi-character combinations. This is just a font rendering feature: underlying code remains ASCII-compatible. This helps to read and understand code faster. For some frequent sequences like `..` or `//` ligatures allow us to correct spacing.

### Fira Code (with ligatures):

<img src="./showcases/all_ligatures.png" style="width: 728px; height: 175px;"/>

Compare to Fira Mono (without ligatures):

<img src="./showcases/no_ligatures.png" style="width: 728px; height: 175px;"/>

### Editor support

Please refer to [Hasklig Readme](https://github.com/i-tu/Hasklig) for editor support

_Note:_ I’m not a font designer, and Fira Code is built in sort of [a hacky way](https://github.com/mozilla/Fira/issues/62) from OTF version of Fira Mono. Please forgive me if it doesn’t work for you. Help will be greatly appreciated.

### Code examples

Erlang:

<img src="./showcases/erlang.png" width="405" height="433" />

Go:

<img src="./showcases/go.png" width="274" height="171"/>

Haskell:

<img src="./showcases/haskell.png" width="319" height="265"/>

JavaScript:

<img src="./showcases/javascript.png" width="361" height="183"/>

Ruby:

<img src="./showcases/ruby.png" width="464" height="143"/>


### Credits

This work is based on OFL-licensed [Fira Mono font](https://github.com/mozilla/Fira). Original Fira Mono font was not changed, only extended.

Fira Code was inspired by [Hasklig font](https://github.com/i-tu/Hasklig): Ligatures for Haskell code

### Changelog

**Version 0.2.1:**

Fixed witdh of `&&` and `||`

**Version 0.2:**

`-->` `<--` `&&` `||` `=>>` `=/=`

**Version 0.1:**

`>>=` `=<<` `<<=` `->>` `->` `=>` `<<-` `<-`  
`===` `==` `<=>` `>=` `<=` `>>` `<<` `!==` `!=` `<>`  
`:=` `++` `#(` `#_`  
`::` `...` `..` `!!` `//` `/*` `*/` `/>`  
