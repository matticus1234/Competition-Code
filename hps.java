import java.io.*;
import java.util.*;

public class hps {

	public static void main (String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("hps.in"));
		//Scanner f = new Scanner(System.in);
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		    StringTokenizer st = new StringTokenizer(f.readLine());
		    int numberofgames = Integer.parseInt(st.nextToken());
		    int numberofswaps = Integer.parseInt(st.nextToken());
		    String[] archives = new String[numberofgames];
		    for (int k=0; k<numberofgames; ++k)
		    {
		    	st = new StringTokenizer(f.readLine());
		    	archives[k]=st.nextToken();
		    }

		    int[] breakloc = new int[numberofswaps];
		    breakloc[0]=0;
		    breakloc[1]=numberofgames-1;
		    int result = 0;
		    result = findbreak(archives, numberofswaps, breakloc, 0, numberofgames-1);
		    out.println(result);
		    out.close();
	}
	public static int findbreak(String[] array, int numberofbreaks, int[] breakloc, int start, int end)
	{
		int maximums[][] = new int[end-start][3];
		maximums[0][0]=0;
		maximums[0][1]=0;		
		maximums[0][2]=0;
	    
		for (int k=start; k<end+1; k++)
	    {
	    	
	    	if (array.equals("H"))
	    	{
	    		maximums[k-start][0]=maximums[k-start-1][0]+1;
			    maximums[k-start][1]=maximums[k-start-1][1];
			    maximums[k-start][2]=maximums[k-start-1][2];
	    	}
	    	else if (array.equals("P"))
	    	{
	    		maximums[k-start][0]=maximums[k-start-1][0];
			    maximums[k-start][1]=maximums[k-start-1][1]+1;
			    maximums[k-start][2]=maximums[k-start-1][2];
	    	}
	    	else if (array.equals("S"))
	    	{
	    		maximums[k-start][0]=maximums[k-start-1][0];
			    maximums[k-start][1]=maximums[k-start-1][1];
			    maximums[k-start][2]=maximums[k-start-1][2]+1;
	    	}
	    }
		int theoutput = 0;
	    int max1=0;
	    int max2=0;
	    int breakpoint=0;
	    for (int k=start; k<end+1; k++)
	    {
	    	max1=0;
	    	max2=0;
	    	for(int counter=0; counter<3; counter++)
	    	{
	    		if(maximums[k][counter]>max1)
	    			max1 = maximums[k][counter];
	    		if(maximums[end][counter]-maximums[k][counter]>max2)
	    			max2 = maximums[end][counter]-maximums[k][counter];
		    	if (max1+max2>theoutput)
		    	{
		    		theoutput = max1+max2;
		    		breakpoint=counter;
		    	}
	    	}
	    }

		return 0;
	}
}





























/*		    int[] cow1 = new int[numberofgames];
int[] cow2 = new int[numberofgames];
for (int counter=0; counter<numberofgames; ++counter)
{
	st = new StringTokenizer(f.readLine());
	cow1[counter] = Integer.parseInt(st.nextToken());
	cow2[counter] = Integer.parseInt(st.nextToken());
}
int rot1 = 0;
int rot2 = 0;
for (int counter=0; counter<numberofgames; ++counter)
{
	if(cow1[counter]==1 && cow2[counter]==2)
		++rot1;
	if(cow1[counter]==2 && cow2[counter]==3)
		++rot1;
	if(cow1[counter]==3 && cow2[counter]==1)
		++rot1;
	if(cow1[counter]==1 && cow2[counter]==3)
		++rot2;
	if(cow1[counter]==3 && cow2[counter]==2)
		++rot2;
	if(cow1[counter]==2 && cow2[counter]==1)
		++rot2;
}

if (rot1>rot2)
   out.println(rot1);
else
   out.println(rot2);
*/
