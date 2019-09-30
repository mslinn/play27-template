# Play Framework 2.7 Template

[![License](https://licensebuttons.net/p/zero/1.0/88x31.png)](https://creativecommons.org/share-your-work/public-domain/cc0/)
[![GitHub version](https://badge.fury.io/gh/mslinn%2Fplay27Template.svg)](https://badge.fury.io/gh/mslinn%2Fplay256emplate)

Template for Play 2.7.x projects, using Scala 2.13, including all official Play Framework dependencies,
JQuery and Bootstrap. Dependency injection is used throughout.
A Bootstrap view template is provided, and a plain HTML view template is provided.

Links to the appropriate ScalaCourses.com lectures are provided in each file.
The [Standard Files and Directories and Improved Template](https://scalacourses.com/student/showLecture/169)
lecture discusses this GitHub project in detail.

## Bash Script
This template is best used in conjunction with a bash script that looks like this, which you might place in `/usr/local/bin/play27Template`:

```bash
#!/bin/bash

# Clones play27-template and starts a new SBT project
# Optional argument specifies name of directory to place the new project into

DIR=sbtTemplate
if [ "$1" ]; then DIR="$1"; fi
git clone https://github.com/mslinn/play27-template.git "$DIR"
cd "$DIR"
rm -rf .git
git init
echo "Remember to edit README.md and build.sbt ASAP"
```

Remember to make the script executable!
```bash
$ chmod a+x /usr/local/bin/play27-template
```

## Using GitHub?

### GitHub Pages
`play27Template` sets up the GitHub pages branch for your new project.
Before you can use it, edit `build.sbt` and change this line so your GitHub user id and project name are substituted
for the placeholders `yourGithubId` and `my-new-project`:

    git.remoteRepo := "git@github.com:yourGithubId/my-new-project.git"

Now you can publish the Scaladoc for your project with this command:

    sbt ";doc ;ghpagesPushSite"

The Scaladoc will be available at a URL of the form:

    http://yourGithubId.github.io/my-new-project/latest/api/index.html

The Scaladoc for this template project is [here](http://mslinn.github.io/play25-template/latest/api/index.html)

### Try Hub!
With `hub` and `play27Template` you can create a new SBT project and a matching GitHub project with only two commands.
The setup documented below will supply your GitHub username and password,
and will only prompt your for your 2-factor-authentication (2FA) token each time
you run it if you set up your GitHub account to use 2FA.

#### Install Hub
Install Hub on Mac OS:

    $ brew install hub

Install Hub on Linux:

    $ sudo -H pip install hub

Put your GitHub login credentials in `~/.bash_profile` or `~/.profile`.
Also alias `hub` as `git` (`hub` also executes `git` commands):

    export GITHUB_USER=yourGithubUserName
    export GITHUB_PASSWORD=yourPassword
    alias git=hub

Reload `~/.bash_profile`

    $ source `~/.bash_profile`

... or reload `~/.profile`

    $ source `~/.profile`

#### Using play27Template with Hub
Create a new SBT project and create a new GitHub project, which `hub` automatically adds as a `git` `remote`:

    $ play27Template bigBadProject
    $ git create -d "Project description"
    two-factor authentication code: 881078
    Updating origin
    created repository: mslinn/bigBadProject

Now check in the new project:

    $ git add -A && git commit -m "Initial checkin" && git push -u origin master
