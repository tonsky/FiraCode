Installing
==========

Windows
-------

In the ttf folder, double-click each font file, click “Install font”; to install all at once, select all files, right-click, and choose “Install”

OR

Use https://chocolatey.org:

    choco install firacode


macOS
-----

In the downloaded TTF folder:

1.  Select all font files
2.  Right click and select `Open` (alternatively `Open With Font Book`)
3.  Select "Install Font"

OR

Use http://brew.sh:

    `brew tap homebrew/cask-fonts`
    `brew cask install font-fira-code`


Ubuntu Zesty (17.04), Debian Stretch (9) or newer
-------------------------------------------------

1. Make sure that the `universe` (for Ubuntu) or `contrib` (for Debian) repository is enabled (see https://askubuntu.com/questions/148638/how-do-i-enable-the-universe-repository or https://wiki.debian.org/SourcesList#Component)
2. Install `fonts-firacode` package either by executing `sudo apt install fonts-firacode` in the terminal or via GUI tool (like “Software Center”)


Arch Linux
----------

Fira Code package is available in the official repository: https://www.archlinux.org/packages/community/any/otf-fira-code/.

Variant of Fira Code package is available in the AUR: https://aur.archlinux.org/packages/otf-fira-code-git/.


Gentoo
------

    emerge -av media-fonts/fira-code


Fedora
------

A Fedora copr repository is available: https://copr.fedorainfracloud.org/coprs/evana/fira-code-fonts/. Package sources https://gitlab.com/evana11/fira-code-fonts-fedora.

To install, perform the following commands:

    dnf copr enable evana/fira-code-fonts
    dnf install fira-code-fonts


Solus
-----

Fira Code package is available in the official repository: `font-firacode-ttf` and `font-firacode-otf`.  
They can be installed by running:

    sudo eopkg install font-firacode-ttf font-firacode-otf


Void linux
----------

    xbps-install font-firacode


Linux Manual Installation
-------------------------

With most desktop-oriented distributions, double-clicking each font file in the ttf folder and selecting “Install font” should be enough. If it isn’t, create and run `download_and_install.sh` script:

    #!/usr/bin/env bash

    fonts_dir="${HOME}/.local/share/fonts"
    if [ ! -d "${fonts_dir}" ]; then
        echo "mkdir -p $fonts_dir"
        mkdir -p "${fonts_dir}"
    else
        echo "Found fonts dir $fonts_dir"
    fi

    for type in Bold Light Medium Regular Retina; do
        file_path="${HOME}/.local/share/fonts/FiraCode-${type}.ttf"
        file_url="https://github.com/tonsky/FiraCode/blob/master/distr/ttf/FiraCode-${type}.ttf?raw=true"
        if [ ! -e "${file_path}" ]; then
            echo "wget -O $file_path $file_url"
            wget -O "${file_path}" "${file_url}"
        else
      echo "Found existing file $file_path"
        fi;
    done

    echo "fc-cache -f"
    fc-cache -f

More details: https://github.com/tonsky/FiraCode/issues/4


FreeBSD
-------

Using pkg(8):

    pkg install firacode

OR

Using ports:

    cd /usr/ports/x11-fonts/firacode && make install clean


Enabling ligatures
==================

Atom
----

To change your font to Fira Code, open Atom's preferences (`cmd + ,` on a Mac, `ctrl + ,` on PC), make sure the "Settings" tab is selected, or the "Editor" in Atom 1.10+, and scroll down to "Editor Settings". In the "Font Family" field, enter `Fira Code`.

If you wish to specify a font weight, for example, Light, use `Fira Code Light` as a font name (Windows) or `FiraCode-Light` (macOS).

Ligatures are enabled by default in Atom 1.9 and above.


VS Code
-------

To open the settings editor, first from the File menu choose Preferences, Settings or use keyboard shortcut `Ctrl + ,` (Windows) or `Cmd + ,` (macOS).

To enable FiraCode in the settings editor, under "Commonly Used", expand the "Text Editor" settings and then click on "Font". In the "Font Family" input box type `Fira Code`, replacing any content. Tick the check box "Enables/Disables font ligatures" under "Font Ligatures" to enable the special ligatures.

If you wish to specify a font weight, for example, Light, use `Fira Code Light` as a font name (Windows) or `FiraCode-Light` (macOS).


IntelliJ products
-----------------

1. Enable in Settings → Editor → Font → Enable Font Ligatures
2. Select `Fira Code` as "Primary font" under Settings → Editor → Font

Additionally, if a Color Scheme is selected:

3. Enable in Settings → Editor → Color Scheme → Color Scheme Font → Enable Font Ligatures
4. Select Fira Code as "Primary font" under Settings → Editor → Color Scheme → Color Scheme Font


BBEdit, TextWrangler
--------------------

Run in your terminal:

    defaults write com.barebones.bbedit "EnableFontLigatures_Fira Code" -bool YES

Source: https://www.barebones.com/support/bbedit/ExpertPreferences.html


Brackets
--------

1. From the `View` menu choose `Themes....`
2. Paste `'Fira Code'`, at the begining of `Font Family`


Emacs
-----

There are a few options when it comes down to using ligatures in
Emacs. They are listed in order of preferred to less-preferred. Pick one!

1. Using composition mode in Emacs Mac port

If you're using the latest Mac port of Emacs (https://bitbucket.org/mituharu/emacs-mac by Mitsuharu Yamamoto) for macOS, you can use:

    (mac-auto-operator-composition-mode)

This is generally the easiest solution, but can only be used on macOS.

2. Using prettify-symbols

These instructions are pieced together by https://github.com/Triavanicus, taking some pieces from https://github.com/minad/hasklig-mode.

This method requires you to install the Fira Code Symbol font, made by https://github.com/siegebell:
https://github.com/tonsky/FiraCode/issues/211#issuecomment-239058632

    (defun fira-code-mode--make-alist (list)
      "Generate prettify-symbols alist from LIST."
      (let ((idx -1))
        (mapcar
         (lambda (s)
           (setq idx (1+ idx))
           (let* ((code (+ #Xe100 idx))
              (width (string-width s))
              (prefix ())
              (suffix '(?\s (Br . Br)))
              (n 1))
         (while (< n width)
           (setq prefix (append prefix '(?\s (Br . Bl))))
           (setq n (1+ n)))
         (cons s (append prefix suffix (list (decode-char 'ucs code))))))
         list)))

    (defconst fira-code-mode--ligatures
      '("www" "**" "***" "**/" "*>" "*/" "\\\\" "\\\\\\"
        "{-" "[]" "::" ":::" ":=" "!!" "!=" "!==" "-}"
        "--" "---" "-->" "->" "->>" "-<" "-<<" "-~"
        "#{" "#[" "##" "###" "####" "#(" "#?" "#_" "#_("
        ".-" ".=" ".." "..<" "..." "?=" "??" ";;" "/*"
        "/**" "/=" "/==" "/>" "//" "///" "&&" "||" "||="
        "|=" "|>" "^=" "$>" "++" "+++" "+>" "=:=" "=="
        "===" "==>" "=>" "=>>" "<=" "=<<" "=/=" ">-" ">="
        ">=>" ">>" ">>-" ">>=" ">>>" "<*" "<*>" "<|" "<|>"
        "<$" "<$>" "<!--" "<-" "<--" "<->" "<+" "<+>" "<="
        "<==" "<=>" "<=<" "<>" "<<" "<<-" "<<=" "<<<" "<~"
        "<~~" "</" "</>" "~@" "~-" "~=" "~>" "~~" "~~>" "%%"
        "x" ":" "+" "+" "*"))

    (defvar fira-code-mode--old-prettify-alist)

    (defun fira-code-mode--enable ()
      "Enable Fira Code ligatures in current buffer."
      (setq-local fira-code-mode--old-prettify-alist prettify-symbols-alist)
      (setq-local prettify-symbols-alist (append (fira-code-mode--make-alist fira-code-mode--ligatures) fira-code-mode--old-prettify-alist))
      (prettify-symbols-mode t))

    (defun fira-code-mode--disable ()
      "Disable Fira Code ligatures in current buffer."
      (setq-local prettify-symbols-alist fira-code-mode--old-prettify-alist)
      (prettify-symbols-mode -1))

    (define-minor-mode fira-code-mode
      "Fira Code ligatures minor mode"
      :lighter " Fira Code"
      (setq-local prettify-symbols-unprettify-at-point 'right-edge)
      (if fira-code-mode
          (fira-code-mode--enable)
        (fira-code-mode--disable)))

    (defun fira-code-mode--setup ()
      "Setup Fira Code Symbols"
      (set-fontset-font t '(#Xe100 . #Xe16f) "Fira Code Symbol"))

    (provide 'fira-code-mode)

Alternative instructions: https://github.com/Profpatsch/blog/blob/master/posts/ligature-emulation-in-emacs/post.md#appendix-b-update-1-firacode-integration

3. Using composition char table

Thanks to https://github.com/seanfarley for putting this together; extended by https://github.com/jrblevin.

Put this lisp in your .emacs:

    (when (window-system)
      (set-frame-font "Fira Code"))
    (let ((alist '((33 . ".\\(?:\\(?:==\\|!!\\)\\|[!=]\\)")
                   (35 . ".\\(?:###\\|##\\|_(\\|[#(?[_{]\\)")
                   (36 . ".\\(?:>\\)")
                   (37 . ".\\(?:\\(?:%%\\)\\|%\\)")
                   (38 . ".\\(?:\\(?:&&\\)\\|&\\)")
                   (42 . ".\\(?:\\(?:\\*\\*/\\)\\|\\(?:\\*[*/]\\)\\|[*/>]\\)")
                   (43 . ".\\(?:\\(?:\\+\\+\\)\\|[+>]\\)")
                   (45 . ".\\(?:\\(?:-[>-]\\|<<\\|>>\\)\\|[<>}~-]\\)")
                   (46 . ".\\(?:\\(?:\\.[.<]\\)\\|[.=-]\\)")
                   (47 . ".\\(?:\\(?:\\*\\*\\|//\\|==\\)\\|[*/=>]\\)")
                   (48 . ".\\(?:x[a-zA-Z]\\)")
                   (58 . ".\\(?:::\\|[:=]\\)")
                   (59 . ".\\(?:;;\\|;\\)")
                   (60 . ".\\(?:\\(?:!--\\)\\|\\(?:~~\\|->\\|\\$>\\|\\*>\\|\\+>\\|--\\|<[<=-]\\|=[<=>]\\||>\\)\\|[*$+~/<=>|-]\\)")
                   (61 . ".\\(?:\\(?:/=\\|:=\\|<<\\|=[=>]\\|>>\\)\\|[<=>~]\\)")
                   (62 . ".\\(?:\\(?:=>\\|>[=>-]\\)\\|[=>-]\\)")
                   (63 . ".\\(?:\\(\\?\\?\\)\\|[:=?]\\)")
                   (91 . ".\\(?:]\\)")
                   (92 . ".\\(?:\\(?:\\\\\\\\\\)\\|\\\\\\)")
                   (94 . ".\\(?:=\\)")
                   (119 . ".\\(?:ww\\)")
                   (123 . ".\\(?:-\\)")
                   (124 . ".\\(?:\\(?:|[=|]\\)\\|[=>|]\\)")
                   (126 . ".\\(?:~>\\|~~\\|[>=@~-]\\)")
                   )
                 ))
      (dolist (char-regexp alist)
        (set-char-table-range composition-function-table (car char-regexp)
                              `([,(cdr char-regexp) 0 font-shape-gstring]))))

**Note!** If you get `error in process filter: Attempt to shape unibyte text`, check out https://github.com/tonsky/FiraCode/issues/42. Emacs Cider users may avoid this issue by commenting the following line from the above config:

    ;; (46 . ".\\(?:\\(?:\\.[.<]\\)\\|[.=-]\\)")

Char `45` is also known to have issues in macOS Mojave.

If you are having problems with helm you can disable ligatures in helm:

    (add-hook 'helm-major-mode-hook
           (lambda ()
             (setq auto-composition-mode nil)))

4. Using font-lock keywords

If none of the above worked, you can try this method.

This method requires you to install the Fira Code Symbol font, made by https://github.com/siegebell:
https://github.com/tonsky/FiraCode/issues/211#issuecomment-239058632

    ;;; Fira code
    ;; This works when using emacs --daemon + emacsclient
    (add-hook 'after-make-frame-functions (lambda (frame) (set-fontset-font t '(#Xe100 . #Xe16f) "Fira Code Symbol")))
    ;; This works when using emacs without server/client
    (set-fontset-font t '(#Xe100 . #Xe16f) "Fira Code Symbol")
    ;; I haven't found one statement that makes both of the above situations work, so I use both for now

    (defconst fira-code-font-lock-keywords-alist
      (mapcar (lambda (regex-char-pair)
                `(,(car regex-char-pair)
                  (0 (prog1 ()
                       (compose-region (match-beginning 1)
                                       (match-end 1)
                                       ;; The first argument to concat is a string containing a literal tab
                                       ,(concat "   " (list (decode-char 'ucs (cadr regex-char-pair)))))))))
              '(("\\(www\\)"                   #Xe100)
                ("[^/]\\(\\*\\*\\)[^/]"        #Xe101)
                ("\\(\\*\\*\\*\\)"             #Xe102)
                ("\\(\\*\\*/\\)"               #Xe103)
                ("\\(\\*>\\)"                  #Xe104)
                ("[^*]\\(\\*/\\)"              #Xe105)
                ("\\(\\\\\\\\\\)"              #Xe106)
                ("\\(\\\\\\\\\\\\\\)"          #Xe107)
                ("\\({-\\)"                    #Xe108)
                ("\\(\\[\\]\\)"                #Xe109)
                ("\\(::\\)"                    #Xe10a)
                ("\\(:::\\)"                   #Xe10b)
                ("[^=]\\(:=\\)"                #Xe10c)
                ("\\(!!\\)"                    #Xe10d)
                ("\\(!=\\)"                    #Xe10e)
                ("\\(!==\\)"                   #Xe10f)
                ("\\(-}\\)"                    #Xe110)
                ("\\(--\\)"                    #Xe111)
                ("\\(---\\)"                   #Xe112)
                ("\\(-->\\)"                   #Xe113)
                ("[^-]\\(->\\)"                #Xe114)
                ("\\(->>\\)"                   #Xe115)
                ("\\(-<\\)"                    #Xe116)
                ("\\(-<<\\)"                   #Xe117)
                ("\\(-~\\)"                    #Xe118)
                ("\\(#{\\)"                    #Xe119)
                ("\\(#\\[\\)"                  #Xe11a)
                ("\\(##\\)"                    #Xe11b)
                ("\\(###\\)"                   #Xe11c)
                ("\\(####\\)"                  #Xe11d)
                ("\\(#(\\)"                    #Xe11e)
                ("\\(#\\?\\)"                  #Xe11f)
                ("\\(#_\\)"                    #Xe120)
                ("\\(#_(\\)"                   #Xe121)
                ("\\(\\.-\\)"                  #Xe122)
                ("\\(\\.=\\)"                  #Xe123)
                ("\\(\\.\\.\\)"                #Xe124)
                ("\\(\\.\\.<\\)"               #Xe125)
                ("\\(\\.\\.\\.\\)"             #Xe126)
                ("\\(\\?=\\)"                  #Xe127)
                ("\\(\\?\\?\\)"                #Xe128)
                ("\\(;;\\)"                    #Xe129)
                ("\\(/\\*\\)"                  #Xe12a)
                ("\\(/\\*\\*\\)"               #Xe12b)
                ("\\(/=\\)"                    #Xe12c)
                ("\\(/==\\)"                   #Xe12d)
                ("\\(/>\\)"                    #Xe12e)
                ("\\(//\\)"                    #Xe12f)
                ("\\(///\\)"                   #Xe130)
                ("\\(&&\\)"                    #Xe131)
                ("\\(||\\)"                    #Xe132)
                ("\\(||=\\)"                   #Xe133)
                ("[^|]\\(|=\\)"                #Xe134)
                ("\\(|>\\)"                    #Xe135)
                ("\\(\\^=\\)"                  #Xe136)
                ("\\(\\$>\\)"                  #Xe137)
                ("\\(\\+\\+\\)"                #Xe138)
                ("\\(\\+\\+\\+\\)"             #Xe139)
                ("\\(\\+>\\)"                  #Xe13a)
                ("\\(=:=\\)"                   #Xe13b)
                ("[^!/]\\(==\\)[^>]"           #Xe13c)
                ("\\(===\\)"                   #Xe13d)
                ("\\(==>\\)"                   #Xe13e)
                ("[^=]\\(=>\\)"                #Xe13f)
                ("\\(=>>\\)"                   #Xe140)
                ("\\(<=\\)"                    #Xe141)
                ("\\(=<<\\)"                   #Xe142)
                ("\\(=/=\\)"                   #Xe143)
                ("\\(>-\\)"                    #Xe144)
                ("\\(>=\\)"                    #Xe145)
                ("\\(>=>\\)"                   #Xe146)
                ("[^-=]\\(>>\\)"               #Xe147)
                ("\\(>>-\\)"                   #Xe148)
                ("\\(>>=\\)"                   #Xe149)
                ("\\(>>>\\)"                   #Xe14a)
                ("\\(<\\*\\)"                  #Xe14b)
                ("\\(<\\*>\\)"                 #Xe14c)
                ("\\(<|\\)"                    #Xe14d)
                ("\\(<|>\\)"                   #Xe14e)
                ("\\(<\\$\\)"                  #Xe14f)
                ("\\(<\\$>\\)"                 #Xe150)
                ("\\(<!--\\)"                  #Xe151)
                ("\\(<-\\)"                    #Xe152)
                ("\\(<--\\)"                   #Xe153)
                ("\\(<->\\)"                   #Xe154)
                ("\\(<\\+\\)"                  #Xe155)
                ("\\(<\\+>\\)"                 #Xe156)
                ("\\(<=\\)"                    #Xe157)
                ("\\(<==\\)"                   #Xe158)
                ("\\(<=>\\)"                   #Xe159)
                ("\\(<=<\\)"                   #Xe15a)
                ("\\(<>\\)"                    #Xe15b)
                ("[^-=]\\(<<\\)"               #Xe15c)
                ("\\(<<-\\)"                   #Xe15d)
                ("\\(<<=\\)"                   #Xe15e)
                ("\\(<<<\\)"                   #Xe15f)
                ("\\(<~\\)"                    #Xe160)
                ("\\(<~~\\)"                   #Xe161)
                ("\\(</\\)"                    #Xe162)
                ("\\(</>\\)"                   #Xe163)
                ("\\(~@\\)"                    #Xe164)
                ("\\(~-\\)"                    #Xe165)
                ("\\(~=\\)"                    #Xe166)
                ("\\(~>\\)"                    #Xe167)
                ("[^<]\\(~~\\)"                #Xe168)
                ("\\(~~>\\)"                   #Xe169)
                ("\\(%%\\)"                    #Xe16a)
                ("[0\[]\\(x\\)"                #Xe16b)
                ("[^:=]\\(:\\)[^:=]"           #Xe16c)
                ("[^\\+<>]\\(\\+\\)[^\\+<>]"   #Xe16d)
                ("[^\\*/<>]\\(\\*\\)[^\\*/<>]" #Xe16f))))

    (defun add-fira-code-symbol-keywords ()
      (font-lock-add-keywords nil fira-code-font-lock-keywords-alist))

    (add-hook 'prog-mode-hook
              #'add-fira-code-symbol-keywords)

On some systems, `==` will appear incorrectly as a blank space in certain modes unless you add the following lines to your init file:

    (set-language-environment "UTF-8")
    (set-default-coding-systems 'utf-8)


GoormIDE
--------

In a workspace:

1. Click goormIDE, then Preferences.
2. Go to Theme, then focus Custom Theme CSS.
3. Copy & paste the following:

    @font-face{
        font-family: 'Fira Code';
        src: url('https://raw.githubusercontent.com/tonsky/FiraCode/master/distr/eot/FiraCode-Regular.eot') format('embedded-opentype'),
             url('https://raw.githubusercontent.com/tonsky/FiraCode/master/distr/woff2/FiraCode-Regular.woff2') format('woff2'),
             url('https://raw.githubusercontent.com/tonsky/FiraCode/master/distr/woff/FiraCode-Regular.woff') format('woff'),
             url('https://raw.githubusercontent.com/tonsky/FiraCode/master/distr/ttf/FiraCode-Regular.ttf') format('truetype');
        font-weight: normal;
        font-style: normal;
    }

    .editor_container pre {
        -webkit-font-feature-settings: "liga" on, "calt" on;
        -webkit-font-smoothing: antialiased;
        text-rendering: optimizeLegibility;
        font-family: 'Fira Code';
    }

4. Click Aplly or OK
5. Happy coding!


Cloud9
------

In a workspace:

1. Click Cloud9, then Preferences (or use keyboard shortcut CTRL + ,)
2. Go to Themes, then click on You can also style Cloud9 by editing your stylesheet (this will open a blank styles.css file in the C9 editor)
3. Copy & paste the following:

    @font-face{
        font-family: 'Fira Code';
        src: url('https://raw.githubusercontent.com/tonsky/FiraCode/master/distr/eot/FiraCode-Regular.eot') format('embedded-opentype'),
             url('https://raw.githubusercontent.com/tonsky/FiraCode/master/distr/woff2/FiraCode-Regular.woff2') format('woff2'),
             url('https://raw.githubusercontent.com/tonsky/FiraCode/master/distr/woff/FiraCode-Regular.woff') format('woff'),
             url('https://raw.githubusercontent.com/tonsky/FiraCode/master/distr/ttf/FiraCode-Regular.ttf') format('truetype');
        font-weight: normal;
        font-style: normal;
    }

    .ace_editor{
        -webkit-font-feature-settings: "liga" on, "calt" on;
        -webkit-font-smoothing: antialiased;
        text-rendering: optimizeLegibility;
        font-family: 'Fira Code';
    }

4. Back in Preferences tab, click on User Settings, then click on Code Editor (Ace)
5. In Font Family field, enter Fira Code
6. Optionally, repeat step 5 for Preferences > User Settings > Terminal, if you want Fira Code font in C9 terminal.


MacVim
------

Add this to ~/.gvimrc:

    set macligatures
    set guifont=Fira\ Code:h12

MacVim supports ligatures starting from version 7.4.


RStudio
-------

In RStudio:

1. Go to Tools > Global Options > Appearance
2. Select "Fira Code" as Editor Font. In older versions of RStudio, check "Use Ligatures".
3. Hit "OK" and enjoy


Sublime Text
------------

Preferences --> Settings

Add before "ignored_packages":

    "font_face": "Fira Code",
    "font_options": ["subpixel_antialias"],

If you want enable antialias, add in font_options: "gray_antialias"


Visual Studio
-------------

1. Launch Visual Studio (2015 or later).
2. Launch the Options dialog by opening the "Tools" menu and selecting "Options". 
3. In the Options dialog, under the "Environment" category, you'll find "Fonts and Colors". Click on that. You'll see a combo-box on the right hand side of the dialog labelled "Font". Select "Fira Code" from that combo-box. 
4. Click "OK" to dismiss.
5. Restart Visual Studio.

Now, most FiraCode ligatures will work. A notable exception is the hyphen-based ligatures (e.g. the C++ dereference '->'). See https://github.com/tonsky/FiraCode/issues/422 for details.


Troubleshooting
===============

See https://github.com/tonsky/FiraCode/wiki/Troubleshooting
