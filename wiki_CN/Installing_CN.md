## macOS

在已经[下载好的 TTF 文件夹](https://github.com/tonsky/FiraCode/releases)内：

1. 选中所有字体文件
1. 右键点击并选择`打开`（也可以选择`用字体簿打开`）
1. 选择“安装字体”

*或者*

- 使用[brew](http://brew.sh)和[cask](https://caskroom.github.io)：

  *未得到官方支持，有可能安装到已过时的版本*
  ```bash
  brew tap homebrew/cask-fonts
  brew install --cask font-fira-code
  ```

## Linux

- 根据[操作指南](https://github.com/tonsky/FiraCode/wiki/Linux-instructions#installing-with-a-package-manager)安装一个符合您的系统版本的软件包

*或者*

- 在ttf文件夹内，双击每个字体文件并点击“安装字体”；如果双击没有用的话，请查看[“手动安装”](https://github.com/tonsky/FiraCode/wiki/Linux-instructions#manual-installation)部分


## FreeBSD

- 使用pkg(8)：`pkg install firacode`

*或者*

- 使用ports：`cd /usr/ports/x11-fonts/firacode && make install clean`

## Windows

- 下载最新的字体压缩包[Fira_Code_v6.2.zip](https://github.com/tonsky/FiraCode/releases/download/6.2/Fira_Code_v6.2.zip)
- 在ttf文件夹内，双击每个字体文件，点击“安装”（或“安装字体”）；想要一次性全部安装的话，选中所有字体文件，右键点击，然后选择“安装”
- 在某些系统中（尤其是Windows 10），您可能需要在安装之前“解除锁定”每个字体文件。要这么做的话，右键点击每个字体文件，点击属性，然后在常规标签中的下方，安全那一栏的右边位置，选中“解除锁定“。点击确定，然后安装。_注意：跳过这一步有可能会使Fira Code系列字体间歇性的在VS Code中停止工作，虽然这个字体依然会在其他应用中显示。_

*或者*

在Windows 10中，打开设置，找到字体设置并将ttf文件夹内的字体文件拖到上方的“拖放以安装”区域中。

*或者*

- 使用[chocolatey](https://chocolatey.org)：`choco install firacode`

- 使用[scoop](https://github.com/lukesampson/scoop)：
  
  *以管理员身份运行*
  ```
  scoop bucket add nerd-fonts
  scoop install firacode
  ```