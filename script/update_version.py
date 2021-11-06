#! /usr/bin/env python3

import os, re, subprocess, sys

def version():
  desc = subprocess.check_output(["git", "describe", "--tags"], cwd = os.path.dirname(__file__)).decode("utf-8") 
  match = re.match(r"([0-9]+)\.([0-9]+)-([0-9]+)-([a-z0-9]+)", desc)
  if match:
    major = int(match.group(1))
    minor = int(match.group(2)) + int(match.group(3))
    sha = match.group(4)
    return (major, minor, sha)
  else:
    raise Exception("Can’t parse version from: " + desc)

def update_version(major, minor, src, dst):
  with open(src, 'r') as f:
    contents = f.read()
  contents = re.sub(r"versionMajor\s+=\s+\d+;",
                    f"versionMajor = {major};",
                    contents)
  contents = re.sub(r"versionMinor\s+=\s+\d+;",
                    f"versionMinor = {minor};",
                    contents)
  with open(dst, 'w') as f:
    f.write(contents)

if __name__ == '__main__':
  os.chdir(os.path.abspath(os.path.dirname(__file__) + '/..'))
  (major, minor, sha) = version()
  update_version(major, minor, 'FiraCode.glyphs', 'FiraCode.glyphs')
  print(f"{major}.{minor}-{sha}")
  sys.exit(0)