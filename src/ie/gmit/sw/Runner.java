/*
 * @author Raja Naseer Ahmed Khan G00351263
 */

package ie.gmit.sw;

import java.io.IOException;

public class Runner { // main class for user running
	static UserInterface UI; //static call to userInterface Class
	
	public static void main(String[] args) {
		// Instance of the user interface
			try {
				UI = new UserInterface();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
	}
}
