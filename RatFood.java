import java.io.*;
import java.util.*;

public class RatFood {
/*Problem
You've discovered it: the ultimate recipe for ratatouille, the famous French dish! You know which ingredients to use, and how many grams of each one to use, in order to make one serving of ratatouille. But you believe that anyone can cook, and so you want to share the recipe with the world... and make some money in the process!

You have ordered some ingredient packages that are easy to ship. Each package contains some amount of one ingredient; different packages may have different amounts even if they contain the same ingredient. For convenience, you ordered the same number of packages of each ingredient.

You would like to use these packages to form as many ratatouille kits as possible to send to customers. A kit consists of exactly one package of each ingredient, and a label with the integer number of servings of ratatouille that the kit makes. Since you do not want to shortchange customers or waste food, each package must contain between 90 and 110 percent (inclusive) of the amount of that ingredient that is actually needed to make the number of servings of ratatouille on the kit's label.

For example, suppose that one serving of ratatouille takes 500 g of tomato and 300 g of onion. Suppose that you have a 900 g package of tomato and a 660 g package of onion. You could form these into a kit that makes two servings of ratatouille. To make two servings, 1000 g of tomato and 600 g of onion are required. Since the 900 g of tomato you have is within [90, 110]% of the 1000 g of tomato required, and the 660 g of onion you have is within [90, 110]% of the 600 g of onion required, this is acceptable. However, you could not say that the kit makes one or three servings of ratatouille, nor could you say that it makes 1.999 servings (the number of servings must be an integer).

Note that there are some sets of packages that could never form a kit. Continuing with our recipe above, if you have a 1500 g package of tomato and an 809 g package of onion, for example, there is no amount of servings that you can make. Three servings would take 1500 g of tomato and 900 g of onion, and the amount of onion is not within the [90, 110]% range. No other integer amount of servings works, either.

You want to share your recipe with as many customers as possible, so you want to produce the maximum number of valid kits. (Of course, each package can be used in at most one kit.) What is the largest number of kits that you can form? Note that you are not required to maximize the total number of servings of ratatouille formed.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each case consists of the following:

One line with two integers N: the number of ingredients, and P, the number of packages of each ingredient.
One line with N integers R_i. The i-th of these represents the number of grams of the i-th ingredient needed to make one serving of ratatouille.
N more lines of P integers each. The j-th value on the i-th of these lines, Q_ij, represents the quantity, in grams, in the j-th package of the i-th ingredient.
Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum number of kits you can produce, as described above.

Limits
1 ≤ T ≤ 100.
1 ≤ R_i ≤ 106, for all i.
1 ≤ Q_ij ≤ 106, for all i and j.
 * 
 * 
 */
	public static void main(String[] args) throws IOException {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 int numberofcases = in.nextInt();
		 //Solve each case
		 for (int k=1; k<=numberofcases; k++){
			 //Set up the input
			 int ingnum = in.nextInt();
			 int packnum = in.nextInt();
			 int[] ingreds = new int[ingnum];
			 for(int j=0; j<ingnum; j++){
				 ingreds[j]=in.nextInt();
			 }
			 int[][] packages = new int[ingnum][packnum];
			 
			 for(int a=0; a<ingnum; a++){
				 for(int b=0; b<packnum; b++){
					 double temp=in.nextInt();
					 int servings = (int)(temp/ingreds[a]);
					 double base = servings*ingreds[a];
					 if (temp>=base*0.9 && temp <= base*1.1){
						 //Calculate number of packages creatable
						 packages[a][b]=(int)(base*1.1/ingreds[a]);
					 }
					 else
						 //No packages created
						 packages[a][b]=-1;
				 }
			 }
			 //Print out the result
			 for(int a=0; a<ingnum; a++){
				 for(int b=0; b<packnum; b++){
					 System.out.print(packages[a][b]+" ");
				 }
				 System.out.println();
			 }
		 }
	}
}
