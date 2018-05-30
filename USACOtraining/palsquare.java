

/*
 ID: matthew55
 LANG: JAVA
 TASK: palsquare
 
 */

import java.io.*;
import java.util.*;

public class palsquare {


	  public static void main (String [] args) throws IOException {
		    BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		    StringTokenizer st = new StringTokenizer(f.readLine());
		    int thebase = Integer.parseInt(st.nextToken());

		    int numberofnumbers = 0;
		    int[] validnumbers = new int[300];
		    for (int k=1; k<300; k++)
		    {

		    	{
		    	validnumbers[numberofnumbers]=k;
		    	numberofnumbers++;
		    	}
		    }
		    String[][] outputready = new String[numberofnumbers][2];
		    for (int k=0; k<numberofnumbers; k++)
		    {

		    	out.println(outputready[k][0]+" "+outputready[k][1]);
		    }
		    out.close();
	  }
	  
}
