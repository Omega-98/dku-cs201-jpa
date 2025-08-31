#!/usr/bin/env python

import sys, os


def dash(s, msg):
   print()
   print(s+':')
   print('='*(len(s)+1))
   print(msg+'\n'*2)
   pass

def is_powershell():
   try:
      parent = psutil.Process(os.getppid())
      name = parent.name().lower()
      return "powershell" in name or "pwsh" in name
   except Exception:
      return False
 
try :
   import psutil
except:
   msg = "   Please run `pip install psutil` in your terminal"
   dash('Installation recommended:', msg)
   pass


try :
   import yaml
except:
   msg = "   Please run `pip install yaml` in your terminal"
   dash('Installation recommended:', msg)
   pass

try:
   import psutil
   if is_powershell():
      msg = "   Switch to use bash/gitbash to avoid errors"
      dash("Warning You are in PowerShell", msg)
except:
   pass

try:
   home = os.environ['HOME']
   fname = '%s/.sagrc'% home
   if not os.path.exists(fname):
      msg = '   ~/.sagrc not found. Check your email for SAG Password Set/Reset.'
      dash("Error", msg)
      pass
except:
   pass

cwd = os.path.dirname(__file__)

jarfile = cwd + '/'+ 'repolab_sag_client.jar'

cmd = 'java --enable-preview -jar %s ' % jarfile
#cmd = 'java  -jar %s ' % jarfile
#print(cmd)
print("Run SAG client: %s" % os.path.abspath(__file__))


cmd = cmd+  ' '.join(sys.argv[1:])
#print(cmd)
if sys.argv[1] == 'submit':
   fname = 'wdir_msg/compile.err'
   if os.path.exists(fname):
      open(fname,'w').write('')
   
os.system(cmd)
