Project Name : A Multithreaded Cosine Distance Computer
Lecturer     : Johne Healey.
Student      : Raja Naseer Ahmed Khan G00351263.
Course       : B.Sc Software Development (Hons)
-------------------------------------------------------------

About the Programm : 
---------------------
This is a Java API that can rapidly compare a query file against a collection of subject files by computing the cosine distance between them. It uphold the principles of loose-coupling and high cohesion throughout its design by correctly applying abstraction, encapsulation, composition and inheritance.


Programm Structure and Function :
----------------------------------
The package ie.gmit.sw contains following classes

-1) Runner.java:  Program starts with the loading of this class which contain the main method. Also this class create an instance of UserInterface Class.

-2) UserInterface.java: This class mainly deals with the UI. like greeting, proceeding with program or quit and taking input of query file and subject File Directory from the user. This class also check the validity of file and Directory. Upon Validating it send the query file and a Subject file from Directory to a Thread in loop until all the files are compared to query file.
 
-3) MyRunnable.java: This class implements the Runnable Thread to query file and subject File and also runs the main task of claculating the Cosine Distance.

-4) CosineDistance.Java: This class maps the Data from files to a DataStructure which later goes to a method [cosineSimilarity()] which ultimately calculate the difference between the two by implements the Mathematical formula.


Package Includes :
-----------------------------------------------
Complete Source Code Folder Named : ie.gmit.sw
Jar File
UML Class Diagram Name: designer.jpg( private methods and attributes are not shown as told on prject sheet by john).
Readme file(this) Named: readme.txt
files directory containing text files for the test(4 files).

How to Use App :
-----------------------------------------------------
use command withing the project directory
 java -cp ./oop.jar ie.gmit.sw.Runner

after the app starts the following can be done.
	type 1 and enter for reading cosine.
		now give path(location) of file to be comared with others e.g c:\files\file1.txt
			now give path(location) of directory to check files for smiliarity e.g c:\files

	type 0 to quit the program