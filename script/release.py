#! /usr/bin/env python3
import argparse, base64, common, glob, json, os, platform, re, subprocess, sys, urllib.request, urllib.error, zipfile

def log_errors(name):
  def wrap(f):
    def result(*args, **kwargs):
      try:
        f(*args, **kwargs)
      except Exception as e:
        print(f"{name}: Failed {e}")
    return result
  return wrap

def package(version):
  zip = f"Fira_Code_v{version}.zip"

  print('Package:', zip)
  with zipfile.ZipFile(zip, 'w', compression = zipfile.ZIP_DEFLATED, compresslevel = 9) as archive:
    for f in glob.glob("distr/**", recursive = True):
      arcname = f[len("distr/"):]
      if arcname and not os.path.basename(arcname).startswith("."):
        archive.write(f, arcname)

def github_headers():
  if os.environ.get('GITHUB_BASIC'):
    auth = 'Basic ' + base64.b64encode(os.environ.get('GITHUB_BASIC').encode('utf-8')).decode('utf-8')
  else:
    token = os.environ.get('API_TOKEN') or os.environ.get('GITHUB_TOKEN')
    if not token:
      raise Exception("Missing API_TOKEN or GITHUB_TOKEN")
    auth = 'token ' + token
  return {
    'Accept': 'application/vnd.github.v3+json',
    'Authorization': auth
  }

def github_release(version):
  zip = f"Fira_Code_v{version}.zip"

  repo = os.environ.get('GITHUB_REPOSITORY', 'tonsky/FiraCode')
  print(f"Releasing to {repo}")

  data = '{"tag_name":"' + version + '","name":"' + version + '"}'
  headers = github_headers()
  
  try:
    req = urllib.request.Request(f'https://api.github.com/repos/{repo}/releases', data=data.encode('utf-8'), headers=headers)
    resp = urllib.request.urlopen(req).read()
    upload_url = re.match('https://.*/assets', json.loads(resp.decode('utf-8'))['upload_url']).group(0)

    print('github_release: Uploading', zip, 'to', upload_url)
    headers['Content-Type'] = 'application/zip'
    headers['Content-Length'] = os.path.getsize(zip)
    with open(zip, 'rb') as data:
      urllib.request.urlopen(urllib.request.Request(upload_url + '?name=' + zip, data=data, headers=headers))
  except urllib.error.HTTPError as e:
    print(f"github_release: HTTP Error {e.code} {e.reason}")
    print(e.read().decode('utf-8'))
    raise e

@log_errors("npm_publish")
def npm_publish(version):
  print("npm_publish: Skip")

@log_errors("update_homebrew")
def update_homebrew(version):
  print("update_homebrew: Skip") # Update https://github.com/Homebrew/homebrew-cask-fonts

@log_errors("update_scoop")
def update_scoop(version):
  print("update_scoop: Skip") # Update https://github.com/matthewjberger/scoop-nerd-fonts/blob/master/bucket/FiraCode.json

@log_errors("update_google_fonts")
def update_google_fonts(version):
  print("update_google_fonts: Skip")

if __name__ == '__main__':
  os.chdir(common.root)
  version = common.version()
  package(version)
  github_release(version)
  npm_publish(version)
  update_homebrew(version)
  update_scoop(version)
  update_google_fonts(version)
  sys.exit(0)