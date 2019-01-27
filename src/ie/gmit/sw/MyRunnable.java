/*
 * @author Raja Naseer Ahmed Khan G00351263
 */


package ie.gmit.sw;

import java.lang.Runnable;

public class MyRunnable implements Runnable {
	
	/*
	 * @param string comparing between 2 strings
	 */

	private String str1;
	private String str2;
	
	public MyRunnable(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}
	
	@Override
	public void run() {
		
		/*
		 * @param thread runnable to count each cosine
		 */
		
		CosineDistance csd = new CosineDistance();
		Double similar = csd.cosineSimilarity(str1, str2);
		similar = similar*1;

		System.out.println("Similarity: " + similar  + "\n");
	}
}
