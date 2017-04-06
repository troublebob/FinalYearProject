import os
import sys
import shutil

assignmentPath = os.path.normpath(str(sys.argv[1]))
gitPath = os.path.normpath(os.path.join(assignmentPath, '.git'))

if os.path.isdir(assignmentPath)is False:
    print("Directory Does not exist")
    exit()
    # Need to return an error code here

if os.path.isdir(gitPath)is False:
    print("There is no repository here")
    exit()
    # Need to return an error code here

for file in assignmentPath:
    if os.path.isfile(os.path.join(assignmentPath,".gitignore"))is True:
        os.remove(os.path.join(assignmentPath,".gitignore"))

shutil.rmtree(gitPath)
print("Git Removed")