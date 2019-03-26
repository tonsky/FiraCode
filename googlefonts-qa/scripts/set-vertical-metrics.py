#MenuTitle: Set Vertical Metric Params
# -*- coding: utf-8 -*-

font = Glyphs.font

print(font)

__doc__="""
  Assumes the masters keep the same vertical metrics. 
  
  I am not sure whether winAscent and winDescent should be different between masters, 
  otherwise, but you should check if that's the case before using this script 
  on a font where min/max heights are different between styles. 

  Useful when created; may or may not match the latest Google Fonts vertical metrics standards. 
"""

font = Glyphs.font



caps = ["A", "Aacute", "Abreve", "Acircumflex", "Adieresis", "Agrave", "Amacron", "Aogonek", "Aring", "Aringacute", "Atilde", "AE", "AEacute", "B", "C", "Cacute", "Ccaron", "Ccedilla", "Ccircumflex", "Cdotaccent", "D", "Eth", "Dcaron", "Dcroat", "Ddotbelow", "E", "Eacute", "Ebreve", "Ecaron", "Ecircumflex", "Edieresis", "Edotaccent", "Edotbelow", "Egrave", "Emacron", "Eogonek", "Etilde", "F", "G", "Gbreve", "Gcircumflex", "Gcommaaccent", "Gdotaccent", "H", "Hbar", "Hcircumflex", "Hdotbelow", "I", "IJ", "Iacute", "Ibreve", "Icircumflex", "Idieresis", "Idotaccent", "Idotbelow", "Igrave", "Imacron", "Iogonek", "Itilde", "J", "Jcircumflex", "K", "Kcommaaccent", "L", "Lacute", "Lcaron", "Lcommaaccent", "Ldot", "Lslash", "M", "N", "Nacute", "Ncaron", "Ncommaaccent", "Ndotaccent", "Eng", "Ntilde", "O", "Oacute", "Obreve", "Ocircumflex", "Odieresis", "Odotbelow", "Ograve", "Ohungarumlaut", "Omacron", "Oogonek", "Oslash", "Oslashacute", "Otilde", "OE", "P", "Thorn", "Q", "R", "Racute", "Rcaron", "Rcommaaccent", "Rdotbelow", "S", "Sacute", "Scaron", "Scircumflex", "Sdotbelow", "Schwa", "T", "Tbar", "Tcaron", "Tdotbelow", "U", "Uacute", "Ubreve", "Ucircumflex", "Udieresis", "Udotbelow", "Ugrave", "Uhungarumlaut", "Umacron", "Uogonek", "Uring", "Utilde", "V", "W", "Wacute", "Wcircumflex", "Wdieresis", "Wgrave", "X", "Y", "Yacute", "Ycircumflex", "Ydieresis", "Ygrave", "Ytilde", "Z", "Zacute", "Zcaron", "Zdotaccent", "Zdotbelow", "uni015E", "uni0162", "uni01C4", "uni01C5", "uni01C7", "uni01C8", "uni01CA", "uni01CB", "uni01F1", "uni01F2", "uni0218", "uni021A" ]  
lowercase = ["a", "aacute", "abreve", "acircumflex", "adieresis", "agrave", "amacron", "aogonek", "aring", "aringacute", "atilde", "ae", "aeacute", "b", "c", "cacute", "ccaron", "ccedilla", "ccircumflex", "cdotaccent", "d", "eth", "dcaron", "dcroat", "ddotbelow", "e", "eacute", "ebreve", "ecaron", "ecircumflex", "edieresis", "edotaccent", "edotbelow", "egrave", "emacron", "eogonek", "etilde", "schwa", "f", "g", "gbreve", "gcircumflex", "gcommaaccent", "gdotaccent", "h", "hbar", "hcircumflex", "hdotbelow", "i", "dotlessi", "iacute", "ibreve", "icircumflex", "idieresis", "idotbelow", "igrave", "ij", "imacron", "iogonek", "itilde", "j", "dotlessj", "jcircumflex", "k", "kcommaaccent", "kgreenlandic", "l", "lacute", "lcaron", "lcommaaccent", "ldot", "lslash", "m", "n", "nacute", "napostrophe", "ncaron", "ncommaaccent", "ndotaccent", "eng", "ntilde", "o", "oacute", "obreve", "ocircumflex", "odieresis", "odotbelow", "ograve", "ohungarumlaut", "omacron", "oogonek", "oslash", "oslashacute", "otilde", "oe", "p", "thorn", "q", "r", "racute", "rcaron", "rcommaaccent", "rdotbelow", "s", "sacute", "scaron", "scircumflex", "sdotbelow", "germandbls", "t", "tbar", "tcaron", "tdotbelow", "u", "uacute", "ubreve", "ucircumflex", "udieresis", "udotbelow", "ugrave", "uhungarumlaut", "umacron", "uni015F", "uni0163", "uni01C6", "uni01C9", "uni01CC", "uni01F3", "uni0219", "uni021B", "uogonek", "uring", "utilde", "v", "w", "wacute", "wcircumflex", "wdieresis", "wgrave", "x", "y", "yacute", "ycircumflex", "ydieresis", "ygrave", "ytilde", "z", "zacute", "zcaron", "zdotaccent", "zdotbelow", "c_t", "f_b", "f_f", "f_f_b", "f_f_h", "f_f_i", "f_f_j", "f_f_k", "f_f_l", "f_f_t", "f_h", "f_i", "f_j", "f_k", "f_l", "f_t", "s_t", ]

# starter values
mainMaxDescent = 0
mainMaxDescentGlyph = ""
maxDescent = 0
mainMaxAscent = 0
mainMaxAscentGlyph = ""
maxAscent = 0

# find highest and lowest point in font
for glyph in font.glyphs:

  # get total yMax and yMin, for win values
  for layer in glyph.layers:
  
    # get descender of current layer
    descent = layer.bounds.origin.y
    
    # get ascender of current layer
    ascent = layer.bounds.size.height + descent  

    # if descent/ascent of current layer is greater than previous max descents/ascents, update the max descent/ascent
    if descent <= maxDescent:
      maxDescent = descent
      maxDescentGlyph = glyph.name
      
    if ascent >= maxAscent:
      maxAscent = ascent
      maxAscentGlyph = glyph.name

  # get descender of current layer
  descent = layer.bounds.origin.y
      
  # get ascender of current layer (total height of layer, subtracting value of descender)
  ascent = layer.bounds.size.height + descent

  # get maximums of only letters in list vars, for typo and hhea values
  if glyph.name in caps:

    for layer in glyph.layers:
      if ascent >= mainMaxAscent:
        mainMaxAscent = ascent
        mainMaxAscentGlyph = glyph.name


  if glyph.name in lowercase:
      # if descent/ascent of current layer is greater than previous max descents/ascents, update the max descent/ascent
      if descent <= mainMaxDescent:
        mainMaxDescent = descent
        mainMaxDescentGlyph = glyph.name


      

# check values for sanity
print(maxDescentGlyph, maxDescent, maxAscentGlyph, maxAscent)

# make lineGap so that the total of `ascent + descent + lineGap` equals 120% of UPM size

UPM = font.upm

totalSize = maxAscent + abs(maxDescent)

# lineGap = int((UPM * 1.2)) - totalSize

# print(UPM, UPM * 1.2, totalSize, lineGap)

## use highest/lowest points to set custom parameters for winAscent and winDescent
## following vertical metric schema from https://github.com/googlefonts/gf-docs/tree/master/VerticalMetrics (actually, that source must be updated to better recommendations found at https://github.com/googlefonts/fontbakery/issues/2164#issuecomment-436595886)

font.customParameters["Use Typo Metrics"] = True

for master in font.masters:

  # Win Ascent/Descent = Font bbox yMax/yMin
  master.customParameters["winAscent"] = maxAscent
  master.customParameters["winDescent"] = abs(maxDescent)

  typoLineGap = 0
  master.customParameters["typoLineGap"] = typoLineGap
  master.customParameters["hheaLineGap"] = typoLineGap

  typoDescender = mainMaxDescent
  master.customParameters["typoDescender"] = typoDescender
  master.customParameters["hheaDescender"] = typoDescender

  typoAscender = mainMaxAscent
  master.customParameters["typoAscender"] = typoAscender
  master.customParameters["hheaAscender"] = typoAscender

