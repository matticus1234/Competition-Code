/*
ID: matthew55
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;


class beads {
	  public static void main (String [] args) throws IOException {
		    // Use BufferedReader rather than RandomAccessFile; it's much faster
		    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		                                                  // input file name goes above
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		    // Use StringTokenizer vs. readLine/split -- lots faster
		    StringTokenizer st = new StringTokenizer(f.readLine());
								  // Get line, break into tokens
		    int numberofbeads = Integer.parseInt(st.nextToken());
		    st = new StringTokenizer(f.readLine());
		    String beadstring = st.nextToken();
		    char[] falselace = beadstring.toCharArray();
		    char[] necklace = new char[2*numberofbeads];
		    int maximum = 0;
		    for (int counter=0; counter<numberofbeads; counter++)
		    {
		    	necklace[counter]=falselace[counter];
		    	necklace[counter+numberofbeads]=falselace[counter];
		    }
		    int whitestring = 0;
		    int currentstring = 0;
		    int currentstring2 = -1;
		    char whichbit = 'k';
		    
		    for (int counter=0; counter<2*numberofbeads; ++counter)
		    {
		    	if (necklace[counter]=='w')
		    	{
		    		whitestring++;
		    		currentstring++;
		    		currentstring2++;
		    	}
		    	else if (necklace[counter]!=whichbit)
		    	{
		    		if(currentstring>currentstring2)
		    		{
		    			if(maximum < currentstring)
		    				maximum = currentstring;
		    			currentstring = whitestring;
		    			whitestring = 0;
		    			whichbit = necklace[counter];
		    		}
		    		else
		    		{
		    			if (maximum < currentstring2)
		    				maximum = currentstring2;
		    			currentstring2 = whitestring;
		    			whitestring = 0;
		    			whichbit = necklace[counter];
		    		}
		    	}
		    	else
		    	{
		    		++currentstring;
		    		++currentstring2;
		    		whitestring = 0;
		    	}
		    	System.out.println(maximum);
		    }
		    if (currentstring2 > maximum)
		    	maximum = currentstring2;
		    if (currentstring > maximum)
		    	maximum = currentstring;
		    	
    		
		    if (maximum+2 > numberofbeads)
		    	maximum = numberofbeads-2;
		    out.println(maximum+2);
		    out.close();                                  // close the output file
		  }


}
