import java.io.*;
import java.util.*;

public class tidynumbers {
/*
 * Problem
Tatiana likes to keep things tidy. Her toys are sorted from smallest to largest, her pencils are sorted from shortest to longest and her computers from oldest to newest. One day, when practicing her counting skills, she noticed that some integers, 
when written in base 10 with no leading zeroes, have their digits sorted in non-decreasing order. Some examples of this are 8, 123, 555, and 224488. She decided to call these numbers tidy. Numbers that do not have this property, like 20, 321, 495 
and 999990, are not tidy.

She just finished counting all positive integers in ascending order from 1 to N. What was the last tidy number she counted?

Input
The first line of the input gives the number of test cases, T. T lines follow. Each line describes a test case with a single integer N, the last number counted by Tatiana.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the last tidy number counted by Tatiana.

Solved
 */
	public static void main(String[] args) throws IOException {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 int numberofcases = in.nextInt();
		 //Check each case
		 for (int k=1; k<=numberofcases; k++){
			 //Take in input
			 long bignum = in.nextLong();
			 long temp = bignum;
			 int powers = 0;
			 long counter=1;
			 //Find number of digits in input number
			 while(counter<=bignum){
				 powers++; 
				 counter *= 10;
			 }
			 int[] altbignum = new int[powers];
			 for(int a=0; a<powers; a++){
				 //Convert input number to array
				 altbignum[a]=(int) (temp%10);
				 temp /= 10;
			 }
			 
			 for(int a=0; a<powers-1; a++){
				 //Fill in with 9's if necessary
				 if (altbignum[a]<altbignum[a+1]){
					 for(int b=0; b<=a; b++)
						 altbignum[b]=9;
					 altbignum[a+1]--;
				 }
			 }
			 
			 long returnresult = 0;
			 //Find the largest tidy number possible
			 for(int a=0; a<powers; a++){
				 long verytemp = altbignum[a];
				 int b=0;
				 while(b<a){
					 verytemp *= 10;
					 b++;
				 }
				 returnresult += verytemp;
			 }
			 //Return the largest tidy number
			 System.out.println("Case #" + k + ": " + returnresult);
		 }
	}
}
