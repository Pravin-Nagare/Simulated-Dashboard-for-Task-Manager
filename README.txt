Project Description:

Develop a file based dashboard for a TaskManager. There are three tabs on the dashboard:

Performance: It has the following information: Memory Total, Memory Used, Memory Free, Memory Cached, CPU Idle, CPU User Level, CPU System Level.

Processes: It has the following information: PID, Command, User, %CPU, %MEM

Users: It has the following information: User name, Status.

Use the following to split the strings in the input files:
( * ) for tabs
( - ) if there are multiple items in the tab (multiple users and processes) ( : ) seperates fields of items
Data from the local file should be read by a single thread. So, do NOT design for a multi-threaded application.
Use MyLogger (renamed the Debug class) in the following manner:
0: No output should be printed. Only error messages should be printed (for example, message from a catch caluse before exiting).
1: Only ouput from the dashboard should be printed
2: Design on your own and mention in the README what is printed at this debug granularity
3: Design on your own and mention in the README what is printed at this debug granularity 4: Design on your own and mention in the README what is printed at this debug granularity

The following should be read from command line (or hardcoded in build.xml): inputFileName, outputFileName, Logger_level
Program Flow

The Driver should create a Subject instance, 3 observers and their filters, and register the observers and corresponding filters with the subject.

The Subject implementation should have an appropriate data structure to store observers and filters. The Driver should then invoke a method on the Subject to get it started.

The Subject should use the FileProcessor to read a line at at time from the input file. The Subject should use notifyAllObservers to send the string (entire line) to the appropriate listener, not all listeners. However, if a line has data for more than one listener, then split the line correctly in the Subject to send the appropriate data to each listener.. Use filter (programmed to an interface) so just the appropriate method of the listener is called.

Each listener should use internal methods to process the data it has received, store it in a data structure, and also write it to the output file using the method in the displayFile interface.
