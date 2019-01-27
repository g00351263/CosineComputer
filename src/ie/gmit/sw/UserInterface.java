/*
 * @author Raja Naseer Ahmed Khan G00351263
 */


package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class UserInterface {
	
	/*
	 * @param variables for menu choices, keep thread running or stop, and string to file paths
	 */
	private boolean keepRunning = true;
	private int choice = -1;
	// File Locations
	private String location1;
	private String location2;
	File queryFile, folder;
	// BlockingQueue
	//Scanner
	private Scanner sc = new Scanner(System.in);
	
	UserInterface() throws IOException{ // menu interface
		do{
			System.out.println("<<<<< WELCOME TO COSINE DISTANCE CALCULATOR >>>>>");
			System.out.println("\nTo Continue with the application press \t1\nTo Quit press \t\t\t\t0\n");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				compareDocuments();
				break;
			case 0:
				keepRunning = false;
				System.out.println("Thank you for using the Application!");
				System.out.println("Have a nice day :-)");
				break;
				
			default:
				System.out.println("Invalid Choice.");
				break;
			}
		} while(keepRunning);
	}
	
	private void compareDocuments() throws IOException {
		getFileLocations(); // getting files for comparision
	}
	
	private void getFileLocations() {


		System.out.println("<<<<< Document Comparison Service >>>>>");
		System.out.println("To Compute the Cosine distance you need you provide the query file and a directory containing a suite of files.");

		getSubjectDirectory(getQueryFile());
	}

	private String getQueryFile() { // main file to be compared
		String queryStr = "";
		System.out.println("\nEnter query file name and Directory \te.g: D:/123.txt");
		
		this.location1 = sc.next();
		
		queryFile = new File(this.location1);
		
		if(queryFile.isFile() && queryFile.exists()){
			try {
				queryStr = new String (Files.readAllBytes(Paths.get(this.location1)));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}else{
			System.out.println(this.location1 + " No such file exists. Please make sure the file and address is correct.\n");
			getFileLocations();
		}
		return queryStr; 
	}
	
	private void getSubjectDirectory(String queryStr) {

		System.out.println("Enter the Folder Address with files to be compared e.g: D:/Cosine/");
		this.location2 = sc.next();

		folder = new File(this.location2);
		if(folder.exists() && folder.isDirectory()){
			// Initialize file parsers
			//loop through each file in the directory
			for (final File fileEntry : folder.listFiles()) {
				if (!fileEntry.isDirectory()){
					String fileStr = "";
					try {
						fileStr = new String (Files.readAllBytes(fileEntry.toPath()));
						} 
					catch (IOException e) 
					{
						System.out.print(e.getMessage());
					}
		        	System.out.println();
		        	System.out.println("Checking Similarity between: " + fileEntry.getName() + " and " + this.location1);
		        	
					startThread(queryStr, fileStr);
		        	}
		        }			
		}else{
			System.out.println(this.location2 + " Directory does not exists.\n");
			getFileLocations();
		}
	}

	
	private void startThread(String queryStr, String SubjectStr) {
		
		MyRunnable runnable = new MyRunnable(queryStr, SubjectStr);
		Thread th = new Thread(runnable);
		th.start();
		try {
			th.join();
		} catch ( InterruptedException ex ) {
			System.out.println(ex.getMessage());
		}
	}
}
