#! /usr/bin/env python3
import common, os, re, subprocess, sys

def update_version(major, minor, src):
  print(f"update_version: {major}.{minor} in {src}")
  with open(src, 'r') as f:
    contents = f.read()
  contents = re.sub(r"versionMajor\s+=\s+\d+;",
                    f"versionMajor = {major};",
                    contents)
  contents = re.sub(r"versionMinor\s+=\s+\d+;",
                    f"versionMinor = {minor};",
                    contents)
  with open(src, 'w') as f:
    f.write(contents)

if __name__ == '__main__':
  os.chdir(common.root)
  (major, minor) = common.version().split(".")
  update_version(major, minor, 'FiraCode.glyphs')
  sys.exit(0)