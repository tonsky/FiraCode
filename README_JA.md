## Fira Code: プログラミング合字のフリー等幅フォント

![Fira Code](./extras/logo.svg)

[English](./README.md) | [Español](./LEEME.md) | [简体中文](./README_CN.md) で読む

### 問題点

プログラマは多くの記号を使用し、しばしば数文字で符号化されます。人間の脳にとって`->`、`<=`、`:=`といったシーケンスは、たとえ画面上で 2 文字や 3 文字になったとしても、単一の論理トークンである。あなたの目は、複数の文字をスキャンし、解析し、1 つの論理的なものに結合するために、ゼロではない量のエネルギーを費やしているのです。理想を言えば、すべてのプログラミング言語が演算子のための本格的なユニコード記号を備えて設計されるべきですが、まだそうではありません。

### 解決法

Fira Code は、一般的なプログラミングの複数文字の組み合わせのための合字を含む無料の等幅フォントです。これは単にフォントのレンダリング機能であり、基礎となるコードは ASCII 互換のままです。これによりコードをより速く読み、理解することができます。`...` や `//` のような頻度の高い文字列は、合字によって間隔を修正することができます。

### ダウンロードとインストール

<a href="https://github.com/tonsky/FiraCode/releases/download/6.2/Fira_Code_v6.2.zip"><img alt="Fira_Code_v6.2.zip - December 6, 2021 - 2.5 MB" src="./extras/download.png" width="520"></a>

次は:

- [インストール方法](https://github.com/tonsky/FiraCode/wiki)
- [トラブルシューティング](https://github.com/tonsky/FiraCode/wiki#troubleshooting)
- [ニュースとアップデート](https://twitter.com/FiraCode)

### スポンサー

Fira Code は個人的なフリータイムのプロジェクトで、資金はなく膨大な[機能リクエストバックログ](https://github.com/tonsky/FiraCode/issues)を抱えています。もし気に入っていただけたなら、[GitHub Sponsors](https://github.com/sponsors/tonsky) または [Patreon](https://patreon.com/tonsky) で開発をサポートすることを検討してください。どんな支援でもかまいません！

大いに感謝します:

<table>
  <td align="center">
    <a href="https://workos.com/?utm_campaign=github_repo&utm_medium=referral&utm_content=firacode&utm_source=github">
      <div>
        <img src="https://user-images.githubusercontent.com/629429/151508669-efb4c3b3-8fe3-45eb-8e47-e9510b5f0af1.svg" width="290" alt="WorkOS">
      </div>
      <b>Your app, enterprise-ready.</b>
      <div>
        <sub>Start selling to enterprise customers with just a few lines of code. Add Single Sign-On (and more) in minutes instead of months.</sup>
      </div>
    </a>
  </td>
</table>

### 何が入っているのでしょうか？

左: Fira Code で描画される合字。右: 合字のない同じ文字列。

<img src="./extras/ligatures.png" width="754">

Fira Code には、膨大な種類の矢印が用意されています。さらに、好きな長さにしたり、始点・中間・終点の断片を自由に組み合わせたりすることができます！

<img src="./extras/arrows.png" width="754">

Fira Code は合字だけではありません。句読点や頻度の高い文字ペアについても、いくつかの微調整が行われています。

<img src="./extras/typographics.png" width="754">

Fira Code には、数種類の文字バリエーション（`cv01`、`cv02` など）、スタイルセット（`ss01`、`ss02` など）、その他のフォント機能（`zero`、`onum`、`calt` など）があり、誰もが自分に最適なものを選ぶことができます。[有効にする方法](https://github.com/tonsky/FiraCode/wiki/How-to-enable-stylistic-sets)

<img src="./extras/character_variants.png" width="754">

一部の合字は、スタイルセット/文字バリアントを使用して変更または有効にすることができます:

<img src="./extras/ligature_variants.png" width="754">

プログラミング用フォントである Fira Code は、ASCII/ボックスドローイング、パワーライン、その他の形式のコンソール UI に素晴らしい対応をしています:

<img src="./extras/console.png" width="754">

Fira Code は、プログレスバーを描画するための専用グリフを提供する最初のプログラミングフォントです:

<img src="./extras/progress.png" width="754">

動作すると:

<img src="./extras/progress.gif" width="560">

より多くのプログラミング用フォントがこの規約を採用し、独自のバージョンを出荷することを望んでいます。

ユニコード対応により、Fira Code は数学の記述に最適です:

<img src="./extras/math.png" width="754">

### どのように見えるのでしょうか？

<img src="./extras/samples.png" width="754">
<img src="./extras/samples2.png" width="754">

### エディタ互換性リスト

| サポート | 非サポート   |
|-------|----------------|
| **Arduino IDE** (2.0+,same instructions as [vscode](https://github.com/tonsky/FiraCode/wiki/VS-Code-Instructions)) | **Adobe Dreamweaver** |
| **Abricotine** | **Delphi IDE** |
| **Android Studio** (2.3+, [説明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) | Standalone **Emacs** ([回避方法](https://github.com/tonsky/FiraCode/wiki/Emacs-instructions)) |
| **Anjuta** (unless at the EOF) |  **IDLE** |
| **AppCode** (2016.2+, [説明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) | **KDevelop 4** |
| **Atom** 1.1 or newer ([説明](https://github.com/tonsky/FiraCode/wiki/Atom-instructions)) | **Monkey Studio IDE** |
| **BBEdit** (14.6+ [説明](https://github.com/tonsky/FiraCode/wiki/BBEdit-instructions)) | **UltraEdit** (Windows) |
| **Brackets** (with [this plugin](https://github.com/polo2ro/firacode-in-brackets)) |
| **Chocolat** |
| **CLion** (2016.2+, [説明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) |
| **Cloud9** ([説明](https://github.com/tonsky/FiraCode/wiki/Cloud9-Instructions)) |
| **Coda 2** |
| **CodeLite** |
| **CodeRunner** |
| **Comma** (Under: Preferences > Editor > Font) |
| **CotEditor** |
| **Eclipse** |
| **elementary Code** |
| **Geany** (1.37+) |
| **gEdit / Pluma** |
| **GNOME Builder** |
| **Godot** |
| **GoormIDE** ([説明](https://github.com/tonsky/FiraCode/wiki/GoormIDE-Instructions)) |
| **gVim** ([Windows](https://github.com/tonsky/FiraCode/issues/462), [GTK](https://vimhelp.org/options.txt.html#%27guiligatures%27)) |
| **IntelliJ IDEA** (2016.2+, [説明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) |
| **Kate, KWrite** |
| **KDevelop 5+** |
| **Komodo** |
| **Leafpad** |
| **LibreOffice** |
| **LightTable** ([説明](https://github.com/tonsky/FiraCode/wiki/LightTable-instructions)) |
| **LINQPad** |
| **MacVim** 7.4 or newer ([説明](https://github.com/tonsky/FiraCode/wiki/MacVim-instructions)) |
| **Mancy** |
| **MATLAB** ([説明](https://github.com/tonsky/FiraCode/wiki/MATLAB-for-Windows-Instructions)) |
| **Meld** |
| **Mousepad** |
| **NeoVim-gtk** |
| **NetBeans** |
| **Notepad** (Windows) |
| **Notepad++** ([回避方法](https://github.com/notepad-plus-plus/notepad-plus-plus/issues/2287#issuecomment-256638098))  |
| **Notepad3** ([説明](https://github.com/rizonesoft/Notepad3/issues/361#issuecomment-365977420))|
| **Nova** |
| **PhpStorm** (2016.2+, [説明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) |
| **PyCharm** (2016.2+, [説明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) |
| **QOwnNotes** (21.16.6+) |
| **QtCreator** |
| **Rider** |
| **RStudio** ([説明](https://github.com/tonsky/FiraCode/wiki/RStudio-instructions)) |
| **RubyMine** (2016.2+, [説明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) |
| **Scratch** |
| **Scribus** (1.5.3+) |
| **SublimeText** (3146+) |
| **Spyder IDE** (Qt5 のみ) |
| **SuperCollider 3** |
| **TeXShop**|
| **TextAdept** (Linux, macOS) |
| **TextEdit** |
| **TextMate 2** |
| **UltraEdit (UEX)** (Linux) |
| **VimR** ([説明](https://github.com/qvacua/vimr/wiki#ligatures)) |
| **Visual Studio** (2015+, [説明](https://github.com/tonsky/FiraCode/wiki/Visual-Studio-Instructions)) |
| **Visual Studio Code** ([説明](https://github.com/tonsky/FiraCode/wiki/VS-Code-Instructions)) |
| **WebStorm** (2016.2+, [説明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) |
| **Xamarin Studio/Monodevelop** |
| **Xcode** (8.0+, それ以外は[プラグイン付き](https://github.com/robertvojta/LigatureXcodePlugin)) |
| **Xi** |
| Probably work: **Smultron, Vico** | Under question: **Code::Blocks IDE** |

### ターミナル互換性リスト

| サポート | 非サポート |
|-------|--------------|
| crosh ([説明](https://github.com/tonsky/FiraCode/wiki/ChromeOS-Terminal)) | Alacritty |
| Hyper ([#3607](https://github.com/vercel/hyper/issues/3607) を確認) | Asbru Connection Manager |
| iTerm 2 | Cmder |
| Kitty | ConEmu |
| Konsole | GNOME Terminal |
| Mintty | gtkterm ([チケット](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| QTerminal | guake ([チケット](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| st ([パッチ](https://st.suckless.org/patches/ligatures/)) | LXTerminal ([チケット](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| Tabby | mate-terminal |
| Terminal.app | PuTTY |
| Termux | rxvt |
| Token2Shell | sakura ([チケット](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| Wez’s terminal | SecureCRT
| Windows Terminal | Terminator ([チケット](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| ZOC (macOS) | terminology |
| | Tilix |
| | Windows Console |
| | xfce4-terminal ([チケット](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| | xterm |
| | ZOC (Windows) |

### ブラウザサポート

```html
<!-- HTML -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/firacode@6.2.0/distr/fira_code.css">
```

```css
/* CSS */
@import url(https://cdn.jsdelivr.net/npm/firacode@6.2.0/distr/fira_code.css);
```

```css
/* Specify in CSS */
code { font-family: 'Fira Code', monospace; }

@supports (font-variation-settings: normal) {
  code { font-family: 'Fira Code VF', monospace; }
}
```

- IE 10+, Edge Legacy: `font-feature-settings: "calt";` で有効にします
- Firefox
- Safari
- Chromium-based browsers (Chrome, Opera)
- ACE
- CodeMirror (`font-variant-ligatures: contextual;` で有効にします)

### Fira Code を使用したプロジェクト

- [CodePen](https://codepen.io/)
- [Blink Shell](http://www.blink.sh/)
- [Klipse](http://app.klipse.tech/)
- [IlyaBirman.net](http://ilyabirman.net/)
- [EvilMartians.com](https://evilmartians.com/)
- [Web Maker](https://webmakerapp.com/)
- [FromScratch](https://fromscratch.rocks/)
- [PEP20.org](https://pep20.org/)

### 代替品

合字のある無料等幅フォント:

- [Hasklig](https://github.com/i-tu/Hasklig)
- [Monoid](http://larsenwork.com/monoid/)
- [Fixedsys Excelsior](https://github.com/kika/fixedsys)
- [Iosevka](https://be5invis.github.io/Iosevka/)
- [DejaVu Sans Code](https://github.com/SSNikolaevich/DejaVuSansCode)
- [Victor Mono](https://rubjo.github.io/victor-mono/)
- [Cascadia Code](https://github.com/microsoft/cascadia-code)
- [JetBrains Mono](https://github.com/JetBrains/JetBrainsMono)

合字のある有償等幅フォント:

- [PragmataPro](http://www.fsd.it/fonts/pragmatapro.htm)
- [Mono Lisa](https://www.monolisa.dev/)

### Fira Code をローカルでビルドする

FiraCode.glyphs を変更し、OTF/TTF/WOFF ファイルを自分でビルドしたい場合、私が macOS で使用している設定は次のとおりです:

```bash
# 必要なビルドツールをすべてインストール
./script/bootstrap_macos.sh

# フォントファイルのビルド
./script/build.sh

# OTF を ~/Library/Fonts にインストール
cp distr/otf/*.otf ~/Library/Fonts
```

または、Docker を使用して Fira Code を構築することもできます:

```bash
# コンテナ内に依存関係をインストールし、フォントファイルをビルド
make

# dist/ のフォントファイルを zip にまとめる
make package
```

特定のスタイルセットやキャラクタバリエーションを *永久的に* 有効にしたい場合、おそらくあなたの選んだエディタではこれらを個別に切り替えることができないため、`-f / --features` フラグでビルドスクリプトにカンマ区切りリストとして希望の機能を提供することができます。<br>デフォルト: なし。

異なるバージョンのフォントを分けるために、`-n / --family-name` フラグで希望のフォントファミリー名を指定することができます。特別な値 'features' を指定すると、有効な機能をソートしてスペースで区切ったリストをデフォルトのファミリー名に追加します。<br>デフォルト: "Fira Code"

また、`-w / --weights` オプションで、作成されるフォントのウェイトを制限することができます。<br>デフォルト: "Light,Regular,Retina,Medium,SemiBold,Bold"

```bash
# ローカルでシェル内
./script/build.sh --features "ss02,ss08,ss10,cv03,cv07,cv14" --family-name "Fira Code straight" --weights "Regular,Bold"

# または Docker コンテナ経由（ファミリー名 'Fira Code cv01 cv02 cv06 cv31 onum ss01 ss03 ss04 zero' を作成）
docker run --rm -v "${PWD}":/opt tonsky/firacode:latest ./script/build.sh -f "cv01,cv02,cv06,ss01,zero,onum,ss03,ss04,cv31" -n "features"

# Git for Windows の Git Bash やその他の MSYS2 ベースのシェルで使用する場合は、パス変換を無効にする必要があるかもしれません
MSYS2_ARG_CONV_EXCL="*" docker run --rm -v "${PWD}":/opt tonsky/firacode:latest ./script/build.sh -f "ss02,ss03,ss04,ss05,ss06,ss07"
```

### クレジット

- 作者: Nikita Prokopov [@nikitonsky](https://twitter.com/nikitonsky)
- 基にした: [Fira Mono](https://github.com/mozilla/Fira)
- インスパイアされた: [Hasklig](https://github.com/i-tu/Hasklig)
