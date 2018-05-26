import java.io.*;
import java.util.*;

public class hps {
/*
 * You have probably heard of the game "Rock, Paper, Scissors". The cows like to play a similar game they call "Hoof, Paper, Scissors".
The rules of "Hoof, Paper, Scissors" are simple. Two cows play against each-other. They both count to three and then each simultaneously makes a gesture that represents either a hoof, a piece of paper, or a pair of scissors. Hoof beats scissors (since a hoof can smash a pair of scissors), scissors beats paper (since scissors can cut paper), and paper beats hoof (since the hoof can get a papercut). For example, if the first cow makes a "hoof" gesture and the second a "paper" gesture, then the second cow wins. Of course, it is also possible to tie, if both cows make the same gesture.

Farmer John wants to play against his prize cow, Bessie, at N games of "Hoof, Paper, Scissors" (1≤N≤100,000). Bessie, being an expert at the game, can predict each of FJ's gestures before he makes it. Unfortunately, Bessie, being a cow, is also very lazy. As a result, she tends to play the same gesture multiple times in a row. In fact, she is only willing to switch gestures at most K times over the entire set of games (0≤K≤20). For example, if K=2, she might play "hoof" for the first few games, then switch to "paper" for a while, then finish the remaining games playing "hoof".

Given the sequence of gestures FJ will be playing, please determine the maximum number of games that Bessie can win.

INPUT FORMAT (file hps.in):
The first line of the input file contains N and K.
The remaining N lines contains FJ's gestures, each either H, P, or S.

OUTPUT FORMAT (file hps.out):
Print the maximum number of games Bessie can win, given that she can only change gestures at most K times.

Status: Not Solved for K swaps, Solved for 1 Swap
 */
	public static void main (String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("hps.in"));
		//Scanner f = new Scanner(System.in);
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		    StringTokenizer st = new StringTokenizer(f.readLine());
		    //Set up Input
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
		    //Calculate
		    result = findbreak(archives, numberofswaps, breakloc, 0, numberofgames-1);
		    //print result
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
	    	//Count max number of H, P, S at any given entry
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
	    	//Find the right breakpoint by iterating through it all 
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
	    //Should be another thing returned
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
