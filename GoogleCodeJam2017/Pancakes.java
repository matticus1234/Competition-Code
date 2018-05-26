import java.io.*;
import java.util.*;
/*
 * 
 * Problem
Last year, the Infinite House of Pancakes introduced a new kind of pancake. It has a happy face made of chocolate chips on one side (the "happy side"), and nothing on the other side (the "blank side").

You are the head cook on duty. The pancakes are cooked in a single row over a hot surface. As part of its infinite efforts to maximize efficiency, the House has recently given you an oversized pancake flipper that flips exactly K consecutive pancakes. That is, in that range of K pancakes, it changes every happy-side pancake to a blank-side pancake, and vice versa; it does not change the left-to-right order of those pancakes.

You cannot flip fewer than K pancakes at a time with the flipper, even at the ends of the row (since there are raised borders on both sides of the cooking surface). For example, you can flip the first K pancakes, but not the first K - 1 pancakes.

Your apprentice cook, who is still learning the job, just used the old-fashioned single-pancake flipper to flip some individual pancakes and then ran to the restroom with it, right before the time when customers come to visit the kitchen. You only have the oversized pancake flipper left, and you need to use it quickly to leave all the cooking pancakes happy side up, so that the customers leave feeling happy with their visit.

Given the current state of the pancakes, calculate the minimum number of uses of the oversized pancake flipper needed to leave all pancakes happy side up, or state that there is no way to do it.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with a string S and an integer K. S represents the row of pancakes: each of its characters is either + (which represents a pancake that is initially happy side up) or - (which represents a pancake that is initially blank side up).

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is either IMPOSSIBLE if there is no way to get all the pancakes happy side up, or an integer representing the the minimum number of times you will need to use the oversized pancake flipper to do it.

Limits
1 ≤ T ≤ 100.
Every character in S is either + or -.
2 ≤ K ≤ length of S.

Solved
 */
public class Pancakes {

	public static void main(String[] args) throws IOException {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 int numberofcases = in.nextInt();
		 //Solve each Case
		 for (int k=1; k<=numberofcases; k++){
			 //Take in Inputs
			 char[] pancakes = in.next().toCharArray();
			 int fliplength = in.nextInt();
			 int counter = 0;
			 //Flip every pancake that you need to flip
			 for(int a=0; a<=pancakes.length-fliplength; a++){
				 if(pancakes[a]=='-'){
					 //Flip fliplength pancakes
					 for(int b=0; b<fliplength; b++){
						 flip(pancakes, a+b);
					 }
					 //Note that one flip happened
					 counter++;
				 }
			 }
			 //Check if it satisfies the end condition
			 boolean tresult = check(pancakes, fliplength);
			 if (tresult){
				 //Print number of flips
				 System.out.println("Case #" + k + ": " + counter);
			 }else{
				 //Not Possible
				 System.out.println("Case #" + k + ": " + "IMPOSSIBLE");
			 }
		 }
		 
		 
		 

	}
	public static boolean check(char[] pancakes, int flipper){
		//Checks if stack is correct
		boolean returnresult = true;
		for(int k = pancakes.length-1 ; k>pancakes.length-flipper; k--){
			if(pancakes[k]=='-')
				returnresult = false;
		}
		return returnresult;
	}
	public static void flip(char[] pancakes, int position){
		//Flip an individual pancake
		if (pancakes[position]=='+'){
			pancakes[position]='-';
		}
		else
			pancakes[position]='+';
	}

}
