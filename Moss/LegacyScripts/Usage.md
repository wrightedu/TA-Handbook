# Legacy Moss Usage

Note: Please use the more general purpose scripts in the parent directory if
you need to run MOSS locally. This script will only work with Java files anyway

## Requirements
- Linux (works on Mac OS M1, should work on WSL)
- [Perl](https://www.perl.org/get.html)
- [Java](https://openjdk.org/)


## Registration

- Send an email to `moss@moss.stanford.edu`
- The content of the email should be exactly like the follow
```
registeruser
mail [Your email here]
```
For example 

`To: 
moss@moss.stanford.edu`
```
registeruser
mail hatfield.69@wright.edu
```

- Wait for an email reply, when you get a response you are succesfully registered.


## Stanford's Magical Perl Script

The email reply you received during registration should contain source code for a perl script.

- In this script, there *should* be a field called userid. 
- `$userid=2*******8;`
- If this is not there, you are not registered yet, please try to re-send the email

<br/>

Create a file called `moss.pl` and copy/paste the contents of the email into it. Add execute permissions with `chmod ug+x moss.pl`

## Dr. Cheatham's Magical Code Unpack
In this this directory, you should find a file called `CodeUnpack.java` When ran, it will look through all zip files in the current directory, find the driver class, rename the file to `student_last_name.java`, and move it to the outermost directory.

 Currently, this only supports unpacking for java programs, and also only the class contain the main method. This makes it less useful for non-introductory courses. Maybe someone can fix this in a later patch

 ## Putting it all Together
In Pilot, go to Assesment->DropBox->Project_you_want_to_check. Check the top-most checkbox, and hit download. You will get a zip file, filled with everyone submission (as more zip files). Extract the outermost zip file. Then, move `CodeUnpack.java` and `moss.pl` into this directory. At this point, your file structure should look like
```
/Pilot-Download/
  | -> StudentSubmission1.zip
  | -> StudentSubmission2.zip
  | -> ... 
  | -> StudentSubmissionN.zip
  | -> moss.pl 
  | -> CodeUnpack.java
```



