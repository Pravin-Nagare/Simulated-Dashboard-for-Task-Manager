CS542 Design Patterns
Spring 2015
PROJECT <3> README FILE

Due Date: <Friday, April 3, 2015>
Submission Date: <Monday, March 09, 2015>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Pravin Nagare> 
e-mail(s): <pnagare1@binghamton.edu> 

PURPOSE:
[
  To implement DashBoard using observer pattern
]

PERCENT COMPLETE:
[
  I believe I have completed 100% of this assignment as per the requirements. 
]

PARTS THAT ARE NOT COMPLETE:
[
  I believe everything is complete.
]

BUGS:

[
  None
]

FILES:

[
	Driver
	FileProcessor
	DashBoardSubject
	Subject
	Observer
	ProcessesTab
	UsersTab
	PerformanceTab
	PerformanceTabFilterImpl
	UsersTabFilterImpl
	ProcessesTabFilterImpl
	DisplayFile
	DashboardFilter	

]

SAMPLE OUTPUT:

[
	Pravins-Mac:taskManager pravin$ ant -buildfile src/build.xml run
	Buildfile: /Users/pravin/Documents/workspace/taskManager/src/build.xml

jar:

run:
     [java] register of DashBoardSubject is called
     [java] register of DashBoardSubject is called
     [java] register of DashBoardSubject is called
     [java] startProcessing of DashBoardSubject is called
     [java] openfile of FileProcessor is called
     [java] File Not Found.
     [java] Java Result: 1

BUILD SUCCESSFUL
Total time: 0 seconds


]

TO COMPILE:

[
  ant -buildfile src/build.xml all
]

TO RUN:

[
  ant -buildfile src/build.xml run
]

EXTRA CREDIT:

[
  Project running successfully using ANT. 
  DEBUG_VALUE=0 [Print to stdout Only error messages] 			
  DEBUG_VALUE=1 [Prints output from the dashboard]
  DEBUG_VALUE=2 [Print all methods called]
  DEBUG_VALUE=3 [Print to stdout everytime constructor called]
    	
]

BIBLIOGRAPHY:

[
http://stackoverflow.com/questions/22663107/print-all-key-value-pairs-in-a-java-concurrenthashmap
http://www.dotnetperls.com/arraylist-java
http://stackoverflow.com/questions/9620683/java-fileoutputstream-create-file-if-not-exists
http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap

]

ACKNOWLEDGEMENT:
[

Prof. Madhusudhan Govindaraju
cs542.cs.binghamton.edu mailing list

]
