#! /usr/bin/env python3

import os, re, subprocess, sys

def revision():
  os.chdir(os.path.abspath(os.path.dirname(__file__) + '/..'))
  desc = subprocess.check_output(["git", "describe", "--tags"], cwd = os.path.dirname(__file__)).decode("utf-8") 
  match = re.match("([0-9.]+)-([0-9]+)-[a-z0-9]+", desc)
  if match:
    return match.group(1) + "." + match.group(2)
  match = re.match("([0-9]+.[0-9]+).0", desc)
  if match:
    return match.group(1) + ".0"
  raise Exception("Can’t parse revision: " + desc)

if __name__ == '__main__':
  print(revision())
  sys.exit(0)