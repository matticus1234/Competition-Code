import java.util.*;
import java.io.*;

public class bphoto {
/*
 * Farmer John is arranging his N cows in a line to take a photo (1≤N≤100,000). The height of the ith cow in sequence is hi, and the heights of all cows are distinct.
As with all photographs of his cows, FJ wants this one to come out looking as nice as possible. He decides that cow i looks "unbalanced" if Li and Ri differ by more than factor of 2, where Li and Ri are the number of cows taller than i on her left and right, respectively. That is, i is unbalanced if the larger of Li and Ri is strictly more than twice the smaller of these two numbers. FJ is hoping that not too many of his cows are unbalanced.

Please help FJ compute the total number of unbalanced cows.

INPUT FORMAT (file bphoto.in):
The first line of input contains N. The next N lines contain h1…hN, each a nonnegative integer at most 1,000,000,000.
OUTPUT FORMAT (file bphoto.out):
Please output a count of the number of cows that are unbalanced.

Solved 7/10 cases quickly, O(n^2).
 */
	public static void main(String[] args) throws IOException {
		//Take in input
		BufferedReader br = new BufferedReader(new FileReader("bphoto.in"));
		//Scanner br = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bphoto.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numberofcows = Integer.parseInt(st.nextToken());
		int[][] photo = new int[numberofcows][3];
		for (int k=0; k<numberofcows; k++)
		{
			st = new StringTokenizer(br.readLine());
			photo[k][0]=Integer.parseInt(st.nextToken());
			photo[k][1]=0;
			photo[k][2]=0;
		}
		//Keep track of number of taller cows on left vs right side
		for (int counter1 = 0; counter1<numberofcows; counter1++)
		{
			for(int counter2 = 0; counter2<counter1; counter2++)
			{
				if (photo[counter1][0]>photo[counter2][0])
				{
					++photo[counter2][2];
				}
				else
				{
					++photo[counter1][1];
				}
			}
		}
		int result = 0;
		//Find number of unbalanced cows
		for (int counter=0; counter<numberofcows; counter++)
		{
			//If a cow is unbalanced, increment by one
			if (photo[counter][1]>2*photo[counter][2] || photo[counter][2]>2*photo[counter][1])
				result++;
		}
		
		out.println(result);
		out.close();	
	}
}
