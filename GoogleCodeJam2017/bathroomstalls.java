import java.io.*;
import java.util.*;
/*
 * Problem
A certain bathroom has N + 2 stalls in a single row; the stalls on the left and right ends are permanently occupied by the bathroom guards. The other N stalls are for users.

Whenever someone enters the bathroom, they try to choose a stall that is as far from other people as possible. To avoid confusion, they follow deterministic rules: For each empty stall S, they compute two values LS and RS, each of which is the number of empty stalls between S and the closest occupied stall to the left or right, respectively. Then they consider the set of stalls with the farthest closest neighbor, that is, those S for which min(LS, RS) is maximal. If there is only one such stall, they choose it; otherwise, they choose the one among those where max(LS, RS) is maximal. If there are still multiple tied stalls, they choose the leftmost stall among those.

K people are about to enter the bathroom; each one will choose their stall before the next arrives. Nobody will ever leave.

When the last person chooses their stall S, what will the values of max(LS, RS) and min(LS, RS) be?

Solving this problem
This problem has 2 Small datasets and 1 Large dataset. You must solve the first Small dataset before you can attempt the second Small dataset. You will be able to retry either of the Small datasets (with a time penalty). You will be able to make a single attempt at the Large, as usual, only after solving both Small datasets.

Input
The first line of the input gives the number of test cases, T. T lines follow. Each line describes a test case with two integers N and K, as described above.

Output
For each test case, output one line containing Case #x: y z, where x is the test case number (starting from 1), y is max(LS, RS), and z is min(LS, RS) as calculated by the last person to enter the bathroom for their chosen stall S.

Limits
1 ≤ T ≤ 100.
1 ≤ K ≤ N.

Solved: Smallest Case
Failed: Small Case, Large Case
 */
public class bathroomstalls {

	public static void main(String[] args) throws IOException
	{
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 int numberofcases = in.nextInt();
		 //Check each case
		 for (int k=1; k<=numberofcases; k++){
			 int stalls = in.nextInt();
			 int people = in.nextInt();
			 //Keep a list of people
			ArrayList<Integer> asdf = new ArrayList<Integer>();
			asdf.add(1);
			asdf.add(stalls);
			int left;
			int right;
			while(people > 0){
				//Implement the people behavior
				left = asdf.remove(0);
				right = asdf.remove(0);
				if (right-left == 1){
					insert(right, right, asdf);
				}
				if (right-left == 2){
					insert(left, left, asdf);
					insert(right, right, asdf);
				}
				if (right-left >2){
					int median = (left+right)/2;
					if ((right-left)%2==0)
					{
						insert(left, median-1, asdf);
						insert(median+1, right, asdf);
					}
					else
					{
						insert(median+1, right, asdf);
						insert(left, median-1, asdf);
						
					}
				}
				if (people == 1){
					//Returns max and min possible
					int diff = right-left;
					int min = diff/2;
					int max = min;
					if (diff%2 == 1)
						max++;
					System.out.println("Case #"+ k + ": " + max + " " + min);
				}
				people--;
			}
		 }
	}
	public static void insert(int a, int b, ArrayList<Integer> asdf){
		//Insert a person into the correct slot
		int difference = b-a;
		int max = asdf.size()-2;

		while (max>=0){
			if (asdf.get(max+1)-asdf.get(max)>difference){
				asdf.add(max+2, b);
				asdf.add(max+2, a);
				break;
			}
			if(asdf.get(max+1)-asdf.get(max)==difference && a<asdf.get(max)){
				asdf.add(max, b);
				asdf.add(max, a);
				break;
			}
			max -= 2;
		}
		if (max<0){
			asdf.add(0, b);
			asdf.add(0, a);
		}

	}

}
