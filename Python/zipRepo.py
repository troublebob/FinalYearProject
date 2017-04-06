import git
import os
import sys

installationPath = os.path.normpath("C:/FYP/Archives")
#Arguments passed in
#1 Path to repo 2 Module 3 Assignment 4 UserId
assignmentPath = os.path.normpath(str(sys.argv[1]))
module = str(sys.argv[2])
assignment =  str(sys.argv[3])
userId =str(sys.argv[4])

gitPath = os.path.normpath(os.path.join(assignmentPath, '.git'))

if os.path.isdir(assignmentPath)is False:
    print("Directory Does not exist")
    exit()
    # Need to return an error code here

if os.path.isdir(gitPath)is False:
    print("There is no repoistory here")
    exit()
    # Need to return an error code here

repository = git.Repo(assignmentPath)
repository.archive(open(os.path.join(installationPath,module + '_' +assignment+ '_' + userId + ".zip"),'wb'),format='zip')
print("Archive Created")