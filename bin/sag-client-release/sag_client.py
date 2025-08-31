#!/usr/bin/env python

import sys, os



def is_powershell():
    return "PSModulePath" in os.environ

if is_powershell():
   print()
   print('='*60)
   print('User Error:')
   print('='*60)
   print("   Error: You are running in PowerShell, switch to bash/gitbash shell!")
   print('\n'*2)
   
   exit(0)

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
