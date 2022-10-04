## Fira Code: 免费的编程连字等宽字体

![Fira Code](./extras/logo.svg)

### 问题

开发者们使用的多标记，通常都是用几个字符编码。对于人的大脑来说，像`->`、`<=`或`:=`这样的序列是单一的逻辑标记，即使它们在屏幕上显示两到三个字符。您的眼睛并非无消耗的来扫描、解析并将多个字符连接到一个逻辑字符中。理想情况下，所有编程语言都应该为操作符设计成熟的Unicode符号，但现在还不是这样。

### 解决方案

Fira Code是一种免费的等宽字体，包含常用的编程语言中多种字符组合的连字。这只是一个字体呈现功能，底层代码仍然与ASCII兼容。这有助于更快地阅读和理解代码。对于一些常见的序列，如`..`或`//`，连字允许我们纠正间距。

### 下载和安装

<a href="https://github.com/tonsky/FiraCode/releases/download/6.2/Fira_Code_v6.2.zip"><img alt="Fira_Code_v6.2.zip - December 6, 2021 - 2.5 MB" src="./extras/download.png" width="520"></a>

下一步：

- [如何安装](https://github.com/tonsky/FiraCode/wiki)
- [疑难解答](https://github.com/tonsky/FiraCode/wiki#troubleshooting)
- [相关新闻](https://twitter.com/FiraCode)

### 赞助商

<a href="https://github.com/sponsors/tonsky" target="_blank"><img alt="Sponsor" src="./extras/sponsor.png"></a>

Fira Code 是个人的空闲时间进行的项目，缺乏资金但有大量的 [功能请求积压](https://github.com/tonsky/FiraCode/issues)。如果你也热爱这个项目, 请考虑通过 [GitHub Sponsors](https://github.com/sponsors/tonsky) 或 [Patreon](https://patreon.com/tonsky) 来支持它的发展。任何帮助都很重要！

非常感谢：

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

### 字体里都有哪些特征?

左侧：Fira Code中呈现的连字。右侧：没有连字的相同字符序列。

<img src="./extras/ligatures.png" width="754">

Fira Code 带有种类繁多的箭头。更棒的是：您可以随心所欲地制作它们，并根据需要组合开始/中间/结束片段！

<img src="./extras/arrows.png" width="754">

Fira Code 不仅与连字有关，还对标点符号和频繁的字母对进行了一些微调。

<img src="./extras/typographics.png" width="754">

Fira Code 带有各种各样的箭头，更棒的是，您可以随心所欲地制作它们，并且可以任意组合开始/中间/结束片段！[如何启用](https://github.com/tonsky/FiraCode/wiki/How-to-enable-stylistic-sets)

<img src="./extras/character_variants.png" width="754">

可以使用样式集/字符变体更改或启用某些连字：

<img src="./extras/ligature_variants.png" width="754">

作为一种编程字体，Fira Code 对 ASCII/框绘图、powerline和其他形式的控制台 UI 具有出色的支持：

<img src="./extras/console.png" width="754">

Fira Code 是第一个提供专用字形来渲染进度条的编程字体：

<img src="./extras/progress.png" width="754">

在运行中:

<img src="./extras/progress.gif" width="560">

我们希望更多的编程字体能够采用这个约定并发布自己的版本。

Unicode 覆盖使 Fira Code 成为数学写作的绝佳选择：

<img src="./extras/math.png" width="754">

### 它看起来怎样?

<img src="./extras/samples.png" width="754">
<img src="./extras/samples2.png" width="754">

### 编辑器兼容性列表

|  支持  |  不支持   |
|-------|----------------|
| **Abricotine** | **Arduino IDE** |
| **Android Studio** (2.3+, [说明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) | **Adobe Dreamweaver** |
| **Anjuta** (除非在 EOF) | **Delphi IDE** |
| **AppCode** (2016.2+, [说明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) | Standalone **Emacs** ([解决方法](https://github.com/tonsky/FiraCode/wiki/Emacs-instructions)) | **IDLE** |
| **Atom** 1.1 或更新版本 ([说明](https://github.com/tonsky/FiraCode/wiki/Atom-instructions)) | **KDevelop 4** |
| **BBEdit** (14.6+, [说明](https://github.com/tonsky/FiraCode/wiki/BBEdit-instructions)) | **Monkey Studio IDE** |
| **Brackets** (使用 [此插件](https://github.com/polo2ro/firacode-in-brackets)) | 
| **Chocolat** | **UltraEdit** |
| **CLion** (2016.2+, [说明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) | 
| **Cloud9** ([说明](https://github.com/tonsky/FiraCode/wiki/Cloud9-Instructions)) | 
| **Coda 2** |
| **CodeLite** |
| **CodeRunner** |
| **Comma** (在 首选项 > 编辑器 > 字体 中) |
| **CotEditor** |
| **Eclipse** |
| **elementary Code** |
| **Geany** (1.37+) |
| **gEdit / Pluma** |
| **GNOME Builder** |
| **Godot** |
| **GoormIDE** ([说明](https://github.com/tonsky/FiraCode/wiki/GoormIDE-Instructions)) |
| **gVim** ([Windows](https://github.com/tonsky/FiraCode/issues/462), [GTK](https://vimhelp.org/options.txt.html#%27guiligatures%27)) |
| **IntelliJ IDEA** (2016.2+, [说明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) |
| **Kate, KWrite** |
| **KDevelop 5+** |
| **Komodo** |
| **Leafpad** |
| **LibreOffice** |
| **LightTable** ([说明](https://github.com/tonsky/FiraCode/wiki/LightTable-instructions)) |
| **LINQPad** |
| **MacVim** 7.4 或更新版本 ([说明](https://github.com/tonsky/FiraCode/wiki/MacVim-instructions)) |
| **Mancy** |
| **MATLAB** ([说明](https://github.com/tonsky/FiraCode/wiki/MATLAB-for-Windows-Instructions)) |
| **Meld** |
| **Mousepad** |
| **NeoVim-gtk** |
| **NetBeans** |
| **Notepad** (Windows) |
| **Notepad++** ([解决方法](https://github.com/notepad-plus-plus/notepad-plus-plus/issues/2287#issuecomment-256638098))  |
| **Notepad3** ([说明](https://github.com/rizonesoft/Notepad3/issues/361#issuecomment-365977420))|
| **Nova** |
| **PhpStorm** (2016.2+, [说明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) |
| **PyCharm** (2016.2+, [说明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) |
| **QOwnNotes** (21.16.6+) |
| **QtCreator** |
| **Rider** |
| **RStudio** ([说明](https://github.com/tonsky/FiraCode/wiki/RStudio-instructions)) |
| **RubyMine** (2016.2+, [说明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) |
| **Scratch** |
| **Scribus** (1.5.3+) |
| **SublimeText** (3146+) |
| **Spyder IDE** (仅适用于 Qt5) |
| **SuperCollider 3** |
| **TeXShop**|
| **TextAdept** (Linux, macOS) |
| **TextEdit** |
| **TextMate 2** |
| **VimR** ([说明](https://github.com/qvacua/vimr/wiki#ligatures)) |
| **Visual Studio** (2015+, [说明](https://github.com/tonsky/FiraCode/wiki/Visual-Studio-Instructions)) |
| **Visual Studio Code** ([说明](https://github.com/tonsky/FiraCode/wiki/VS-Code-Instructions)) |
| **WebStorm** (2016.2+, [说明](https://github.com/tonsky/FiraCode/wiki/IntelliJ-products-instructions)) |
| **Xamarin Studio/Monodevelop** |
| **Xcode** (8.0+, 否则 [使用插件](https://github.com/robertvojta/LigatureXcodePlugin)) |
| **Xi** |
| Probably work: **Smultron, Vico** | Under question: **Code::Blocks IDE** |

### 终端兼容性列表

|  支持  |  不支持  |
|-------|--------------|
| crosh ([说明](https://github.com/tonsky/FiraCode/wiki/ChromeOS-Terminal)) | Alacritty |
| Hyper (参见 [#3607](https://github.com/vercel/hyper/issues/3607)) | Cmder |
| iTerm 2 | ConEmu |
| Kitty | GNOME Terminal |
| Konsole | gtkterm ([需求](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| Mintty | guake ([需求](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| QTerminal | LXTerminal ([需求](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| st ([补丁](https://st.suckless.org/patches/ligatures/)) | mate-terminal |
| Terminal.app | PuTTY |
| Termux | rxvt |
| Token2Shell | sakura ([需求](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| Wez’s terminal | Terminator ([需求](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| Windows Terminal | terminology |
| ZOC (macOS) | Windows Console |
| | xfce4-terminal ([需求](https://gitlab.gnome.org/GNOME/vte/-/issues/1661)) |
| | xterm |
| | ZOC (Windows) |

### 浏览器支持

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

- IE 10+, Edge Legacy: 启用 `font-feature-settings: "calt";`
- Firefox
- Safari
- Chromium-based browsers (Chrome, Opera)
- ACE
- CodeMirror (enable with `font-variant-ligatures: contextual;`)

### 使用 Fira Code的项目

- [CodePen](https://codepen.io/)
- [Blink Shell](http://www.blink.sh/)
- [Klipse](http://app.klipse.tech/)
- [IlyaBirman.net](http://ilyabirman.net/)
- [EvilMartians.com](https://evilmartians.com/)
- [Web Maker](https://webmakerapp.com/)
- [FromScratch](https://fromscratch.rocks/)
- [PEP20.org](https://pep20.org/)

### 备选方案

带连字的免费等宽字体：

- [Hasklig](https://github.com/i-tu/Hasklig)
- [Monoid](http://larsenwork.com/monoid/)
- [Fixedsys Excelsior](https://github.com/kika/fixedsys)
- [Iosevka](https://be5invis.github.io/Iosevka/)
- [DejaVu Sans Code](https://github.com/SSNikolaevich/DejaVuSansCode)
- [Victor Mono](https://rubjo.github.io/victor-mono/)
- [Cascadia Code](https://github.com/microsoft/cascadia-code)
- [JetBrains Mono](https://github.com/JetBrains/JetBrainsMono)

带连字的付费等宽字体:

- [PragmataPro](http://www.fsd.it/fonts/pragmatapro.htm)
- [Mono Lisa](https://www.monolisa.dev/)

### 在本地构建 Fira Code

如果您想更改 FiraCode.glyphs 并自己构建 OTF / TTF / WOFF 文件，这是我在 macOS 上使用的设置：

```bash
# 安装所有编译需要的工具
./script/bootstrap_macos.sh

# 编译字体文件
./script/build.sh

# 将otf文件安装到 ~/Library/Fonts
cp distr/otf/*.otf ~/Library/Fonts
```

或者，您可以使用 Docker 构建 Fira Code：

```bash
# install dependencies in a container and build the font files
make

# package the font files from dist/ into a zip
make package
```

如果你想要*永久开启*某个特定的文体集或者字符变种，但你的编辑器有可能不允许你单独开启它们，你可以将你想要的功能作为一个用逗号分隔的列表，通过 `-f / --features` 标志来加入到编译脚本中。<br>默认：无。

要分隔不同的字体版本的话，你可以用 `-n / --family-name` 标志来指定你所需的字体系列名称。特殊值 'features' 将在默认的系列名称后面添加一个有序的、空格分隔的列表，列表内为已经启用的功能。<br>默认："Fira Code"

你也可以用 `-w / --weights` 选项来限制将要被编译的字体的重量。<br>默认："Light,Regular,Retina,Medium,SemiBold,Bold"

```bash
# 在你本地的shell中
./script/build.sh --features "ss02,ss08,ss10,cv03,cv07,cv14" --family-name "Fira Code straight" --weights "Regular,Bold"

# 或者通过一个docker容器 (创建系列名为：'Fira Code cv01 cv02 cv06 cv31 onum ss01 ss03 ss04 zero')
docker run --rm -v "${PWD}":/opt tonsky/firacode:latest ./script/build.sh -f "cv01,cv02,cv06,ss01,zero,onum,ss03,ss04,cv31" -n "features"
```

### 制作人员

- 作者: Nikita Prokopov [@nikitonsky](https://twitter.com/nikitonsky)
- 基于此项目: [Fira Mono](https://github.com/mozilla/Fira)
- 灵感来源: [Hasklig](https://github.com/i-tu/Hasklig)
- 翻译：墨抒颖[@moshuying](https://github.com/moshuying)
