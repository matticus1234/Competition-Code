import java.io.*;
import java.util.*;

public class cowtip {
	
	public static void main (String[] args) throws IOException{
	 BufferedReader f = new BufferedReader(new FileReader("cowtip.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int nsize = Integer.parseInt(st.nextToken());
	    char[][] thesquare = new char[nsize][nsize];
	    int numberofflips=0;
	    String thisone = "";
	    for(int counter=0; counter<nsize; ++counter)
	    {
	    	st = new StringTokenizer(f.readLine());
	    	thisone = st.nextToken();
	    	char[] charzed = thisone.toCharArray();
	    	for(int b=0; b<nsize; ++b)
	    	{
	    		thesquare[counter][b]=charzed[b];
	    		
	    	}
	    }
	    for (int height=nsize-1; height>=0; --height)
	    {
	    	for (int width=nsize-1; width>=0; --width)
	    	{
	    		if (thesquare[height][width]=='1')
	    		{
	    			numberofflips++;
	    			for (int hcounter=0; hcounter<=height; ++hcounter)
	    				{
	    				for(int wcounter=0; wcounter<=width; ++wcounter)
	    				{
	    					if(thesquare[hcounter][wcounter]=='0')
	    						thesquare[hcounter][wcounter]='1';
	    					else
	    						thesquare[hcounter][wcounter]='0';
	    				}
	    				}
	    		}
	    	}
	    }
	    out.println(numberofflips);
	    out.close();
	}
}
