#! /usr/bin/env python3
import argparse, os, re, subprocess

root = os.path.abspath(os.path.join(os.path.dirname(__file__), os.pardir))

def version():
  parser = argparse.ArgumentParser()
  parser.add_argument('--version')
  (args, _) = parser.parse_known_args()
  if args.version:
    return args.version

  ref = os.getenv('GITHUB_REF')
  if ref and ref.startswith('refs/tags/'):
    return ref[len('refs/tags/'):]

  raise Exception("Can’t identify version")