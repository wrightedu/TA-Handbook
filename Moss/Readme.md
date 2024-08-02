# MOSS 
A Code Plagiarism Checker

## To use MOSS, you will first need a MOSS account.
You'll need to email `moss@moss.stanford.edu`. The body of your email
should look exactly like the following:
```
registeruser
mail [your email address]
```
Eventually, you should receive a reply. This reply will contain a Perl script. 
Notably, there will be a line somewhere in there that looks like the following:
```
$userid=2######8;
```
Save this number. You will probably need it. If you got this reply, you have
successfully registered a MOSS account.

## Running MOSS With Discord
The easiest way to use MOSS is the CSE Discord server. If you have the TA role, you 
should see an additional channel called `#ta-moss`. You can use the 
`/moss_register [userid]` command to begin (you only need to do this once).
After registering, you can mass-download Dropbox files from Pilot 
(Dropbox > Assignment > Select All > Download) to receive a zip file of all submissions.
Run the `/moss` command and then upload the zip file you previously downloaded. In a few minutes,
you should receive a reply with the MOSS results.


## Running MOSS locally
If you need to run MOSS locally for whatever reason, you will need to run that 
Perl script you received during the registration process. 
This script will require you to have Perl downloaded onto your system to run it. The script comes with usage instructions in the email.
<br/>
The main issue with this Perl script is that it expects a certain directory structure that a mass download from Pilot
will not give you (too many zipped/unzipped files, multi-submissions, etc.). There are several file management scripts available for you to use
in [ManagementScripts](./ManagementScripts) or [LegacyScripts](./LegacyScripts)

## How MOSS Works

[How MOSS Works](https://yangdanny97.github.io/blog/2019/05/03/MOSS)  
[Understanding Winnowing](https://theory.stanford.edu/~aiken/publications/papers/sigmod03.pdf)  
[MOSS - Original Writeup & Source Code](https://github.com/RobYang1024/OCaMOSS/blob/master/3110%20Final%20Project%20Writeup.pdf)  

## Additional Tools

[Mossum - generate correlation graphs from MOSS results](https://github.com/hjalti/mossum)
