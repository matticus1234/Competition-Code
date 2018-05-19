

/*
 ID: matthew55
 LANG: JAVA
 TASK: milk2
 
 */

import java.io.*;
import java.util.*;

public class milk2 {
	 public static void main (String [] args) throws IOException {
		    BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		    StringTokenizer st = new StringTokenizer(f.readLine());
		 
		    int numberoftimes = Integer.parseInt(st.nextToken());
		    
		    int[][] intimes = new int[5000][2];
		    for(int a=0; a<numberoftimes; a++)
		    {
			    st = new StringTokenizer(f.readLine());
		    	intimes[a][0] =  Integer.parseInt(st.nextToken());
		    	intimes[a][1] =  Integer.parseInt(st.nextToken());
		    }
		    int numberofpairs = numberoftimes;
		    for(int a=0; a<numberofpairs; a++)
		    {
		    	for (int b=numberofpairs-1; b>a; b--){
		    		if ((intimes[b][0]>=intimes[a][0]&&intimes[b][0]<=intimes[a][1])||
		    				(intimes[b][1]>=intimes[a][0]&&intimes[b][1]<=intimes[a][1]))
		    		{
		    			intimes[a][0]=Math.min(intimes[a][0], intimes[b][0]);
		    			intimes[a][1]=Math.max(intimes[a][1], intimes[b][1]);
		    			numberofpairs--;
		    		} else if (intimes[a][0]>=intimes[b][0] && intimes[a][1]<=intimes[b][1]){
		    			intimes[a][0]=intimes[b][0];
		    			intimes[a][1]=intimes[b][1];
		    			numberofpairs--;
		    		} else if (intimes[b][0]>=intimes[a][0] && intimes[b][1]<=intimes[a][1]){
		    			numberofpairs--;
		    		}
		    	}
		    }
		    int milktime = 0;
		    int notmilktime = 0;
		    for(int a=0; a<numberofpairs; a++)
		    {
		    	if (intimes[a][1]-intimes[a][0]>milktime)
		    		milktime = intimes[a][1]-intimes[a][0];
		    	if (a!=numberofpairs-1 && intimes[a+1][0]-intimes[a][1]>notmilktime)
		    		notmilktime=intimes[a+1][0]-intimes[a][1];
		    }
		    out.println(milktime+" "+notmilktime);
		    out.close();
		    
		 
		    
		    
		    
	 }
}
