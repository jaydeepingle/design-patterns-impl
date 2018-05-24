Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD -Darg0=FORTH -Darg1=FIFTH

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf jaydeep_ingle_assign_2.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 10/2/2017]

-----------------------------------------------------------------------
Justification for Data Structures:

Used BST for tree. It's simple where we can easily add, print and search for nodes.
Complexity is o(log n) for these operations.
I have also used arraylist at few places for adding courses and the backup nodes too.

-----------------------------------------------------------------------
Implementation of Observer Pattern:

In this assignment there is one main node and 2 backup nodes for each and every single
node in the tree. At the time of creation I am cloning the Node objects and assigning the same to
Observer objects. These observers will get notified as soon as we are going to delete the course from
one of the node and will get updated. This way the push operation is going to work out.

-----------------------------------------------------------------------
