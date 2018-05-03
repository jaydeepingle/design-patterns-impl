## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD 

FIRST = modeName
SECOND = number of objects
THIRD = input file or checkpoint file

-----------------------------------------------------------------------
Justification for Data Structures:

I am using following data structures in our code
1. ArrayList - To store the message in Results class.
Add: O(1)
Remove: O(n)
Get: O(1)
Contains: O(n)

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.?

[Date: 12/11/17]

-----------------------------------------------------------------------
