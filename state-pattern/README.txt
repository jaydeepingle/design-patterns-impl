Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile:
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD

FIRST - input file
SECOND - output file
THIRD - Debug Level
-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf jaydeep_ingle_assign_3.tar.gz firstName_secondName_assign_number

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

I am using following data structures in my code
1. ArrayList - To store the prohibited items.
Add: O(1)
Remove: O(n)
Get: O(1)
Contains: O(n)

2. Array - Using array to store the operation IDs
And the complexity is O(1)
These are static final values.

-----------------------------------------------------------------------
Implementation of State Pattern:

There is one interface named AirportStateI which is being implemented by 3
different state classes HighRisk, LowRisk and ModerateRisk. In addition to this
we have a context class which is initiating the process of transiting from one state
to another on the basis of inputs from the input file.
On the basis of few conditions the state is being changed from one to another.
All the 3 Risk classes implementing tightenOrLoosenSecurity method.

-----------------------------------------------------------------------
Assumption about the number of days
The days that have been skipped will be taken into consideration. There is no track of
distinct days in the program.
-----------------------------------------------------------------------
