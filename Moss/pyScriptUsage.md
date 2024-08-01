# MOSS Code Similarity Checker

<p style='font-size:36px'>Untested on Windows!</p>

This script was made to organize a "select-all" submissions zip file downloaded from the LMS Pilot. Simply go to the assignment dropbox and press the check mark that highlights all submissions and press download. Wait for the download to finish then move the `.zip` file to a folder called `StudentCode` in the same directory as mossScript.

A `moss` file with execute permissions needs to be in root directory next to `mossScript.py`. it's contents are whatever you get in the email back after registration.

After running, a folder inside `StudentCode` named `namedFiles` should contain all the submissions in the format `lastName.fileExtension`. Run the moss script on these files(Or just let the code run it ;\) ): `./moss ./StudentCode/namedFiles/*.java` and the output should be a link to the report.

# mossScript.py vs CodeUnpack.java

They do the same thing, but the python one can deal with other file extensions such as `.cpp` and `.c`

I havent tested it for 1181 projects that use multiple `.java` files per submission.

Also when a student submits two files in one submission, they'll both be kept and will probably show up in the moss report as 90%+ identical.

# Registration

You can follow Reese's [Usage.md](./Usage.md) for registration and `moss` file creation. The only difference is my `moss` has no extension.

# Directory structure

```
/currentDir/
  | -> moss
  | -> mossScript.py
  | -> StudentCode/
        | -> all_student_assignments.zip
```

## Typical run from a MacOS device

```
$ pwd
$ -> /Users/alialjaffer/Desktop/Code/moss
$ ls ./StudentCode/
$ -> Project 1 Download Oct 31, 2023 1224 PM.zip
$ python3 mossScript.py
$ -> Use .java file extension? if not, enter the file extension to use (.cpp,.py,etc)yes
$ -> Using .java as file extension and / as directory seperator
$ -> Found 54 submissions.
$ -> Checking files . . .
$ -> OK
$ -> Uploading ./StudentCode/namedFiles/lastName1.java ...done.
$ -> Uploading ./StudentCode/namedFiles/lastName2.java ...done.
$ -> Uploading ./StudentCode/namedFiles/lastName3.java ...done.
                    *********************
$ -> Uploading ./StudentCode/namedFiles/lastNameN.java ...done.
$ -> Query submitted.  Waiting for the server's response.
$ -> http://moss.stanford.edu/results/6/7********8
$ (ctrl+C)
$ mossum -p 50 http://moss.stanford.edu/results/6/7********8
$ -> Generating image for moss_31-10-2023_122901
$ -> DONE
$ open moss_31-10-2023_122901.png
```

After running the `moss` command it still waits for more input, so just Ctrl+C to kill the process.
