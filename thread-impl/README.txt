Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile:
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD -Darg3=FOURTH -Darg4=FIFTH

FIRST - input file
SECOND - output file
THIRD - number of threads
FOURTH - String of words to delete
FIFTH - Debug Level
-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf siddhesh_dandekar_jaydeep_ingle_assign_4.tar.gz firstName_secondName_firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 11/7/2017]

-----------------------------------------------------------------------
Justification for Data Structures:

We have used Binary search tree in this assignment. As BST allow fast lookup, addition and removal of items. 
While adding / removing words/word_count from a particular node we have to search that particular node and Binary 
Search Tree search Time Complexity is O(log n). And also insering is fast in BST O(log n). As we are first searching 
the node and then decrement the count of word so time complexity for deletion is also O(log n)(same as searching). 
That is why BST is the perfect fit for this assignment.
BST time Best case complexity for insertion, deletion and search O(log n), Average case is O(log n) and worst case is O(n).

We are using following data structures in our code
1. ArrayList - To store the message in Results class.
Add: O(1)
Remove: O(n)
Get: O(1)
Contains: O(n)

-----------------------------------------------------------------------
Explanation about Debug Level:
DEBUG_VALUE=2 [Print to stdout everytime a new message is stored in a results]
DEBUG_VALUE=1 [Print to stdout everytime a output is written to the file]
-----------------------------------------------------------------------
