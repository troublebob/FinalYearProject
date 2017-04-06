import git
import os
import sys
import shutil

# Arguments passed in from command line
# 1=Path 2=Gitignore
# This is the installation path for codefolio
installationPath = os.path.normpath("C:/FYP/GitIgnores")
# This is the folder for the assignment in question
assignmentPath = os.path.normpath(str(sys.argv[1]))

languageGitignore = str(sys.argv[2])
# Checks to see if a respoitory already exists and leaves
gitPath = os.path.normpath(os.path.join(assignmentPath, '.git'))

if os.path.isdir(assignmentPath)is False:
    print("Directory Does not exist")
    exit()
    # Need to return an error code here
if os.path.isdir(gitPath):
    print("Repository already exists")
    exit()
    # Need to return an error code here

ignored = ".gitignore"
if languageGitignore=='Java':
	shutil.copyfile(os.path.join(installationPath,"Java"+ignored),os.path.join(assignmentPath,ignored))
elif languageGitignore=='C':
    shutil.copyfile(os.path.join(installationPath,"C"+ignored),os.path.join(assignmentPath,ignored))
elif languageGitignore=='Python':
    shutil.copyfile(os.path.join(installationPath,"Python"+ignored),os.path.join(assignmentPath,ignored))

#Create and add README and gitignore
repository = git.Repo.init(assignmentPath)
file_path = os.path.join(assignmentPath,"README.md")
open(file_path,'wb').close()
repository.index.add([file_path])
file_path = os.path.join(assignmentPath,".gitignore")
repository.index.add([file_path])
#Initial Commit for gitignore
repository.index.commit("initial commit")

# for path,dirs,files in os.walk(assignmentPath):
#     for fn in files:
#         print(os.path.join(assignmentPath,fn))
#         repository.index.add([os.path.join(assignmentPath,fn)])

repository.add(".")
repository.index.commit("CodeFolio Commit")
print("Repository initialised")