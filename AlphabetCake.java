import java.io.*;
import java.util.*;
/*Problem
You are catering a party for some children, and you are serving them a cake in the shape of a grid with R rows and C columns. Your assistant has started to decorate the cake by writing every child's initial in icing on exactly one cell of the cake. Each cell contains at most one initial, and since no two children share the same initial, no initial appears more than once on the cake.

Each child wants a single rectangular (grid-aligned) piece of cake that has their initial and no other child's initial(s). Can you find a way to assign every blank cell of the cake to one child, such that this goal is accomplished? It is guaranteed that this is always possible. There is no need to split the cake evenly among the children, and one or more of them may even get a 1-by-1 piece; this will be a valuable life lesson about unfairness.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each begins with one line with two integers R and C. Then, there are R more lines of C characters each, representing the cake. Each character is either an uppercase English letter (which means that your assistant has already added that letter to that cell) or ? (which means that that cell is blank).

Output
For each test case, output one line containing Case #x: and nothing else. Then output R more lines of C characters each. Your output grid must be identical to the input grid, but with every ? replaced with an uppercase English letter, representing that that cell appears in the slice for the child who has that initial. You may not add letters that did not originally appear in the input. In your grid, for each letter, the region formed by all the cells containing that letter must be a single grid-aligned rectangle.

If there are multiple possible answers, you may output any of them.

Limits
1 ≤ T ≤ 100.
There is at least one letter in the input grid.
No letter appears in more than one cell in the input grid.
It is guaranteed that at least one answer exists for each test case.
 */
public class AlphabetCake {

	public static void main(String[] args) throws IOException {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 int numberofcases = in.nextInt();
		 //Run code on each case
		 for (int k=1; k<=numberofcases; k++){
			 int numrows = in.nextInt();
			 int numcols = in.nextInt();
			 char[][] cake = new char[numrows][numcols];
			 for(int a=0; a<numrows; a++){
					char[] temp = in.next().toCharArray();
				 for(int b=0; b<numcols; b++){

					cake[a][b]=temp[b];
				 }
			 }
			 ArrayList<Character> used = new ArrayList<>();
			 //Keep a running list of characters used
			 for(int a=0; a<numrows; a++){
				 for(int b=0; b<numcols; b++){
					 //If kid has not been considered yet
					 if (cake[a][b]!='?' && !used.contains(cake[a][b])){
						 convert(cake, a, a, b, b, numrows, numcols);
						 used.add(cake[a][b]);
					 }
				 }
			 }
			 System.out.println("Case #"+k+":");
			 //Print out the cake
			 for(int a=0; a<numrows; a++){
				 for(int b=0; b<numcols; b++){
					 System.out.print(cake[a][b]);
					
				 }
				 System.out.println();
			 }
		 }
}
	private static void convert(char[][] cake, int up, int down, int left, int right, int numrows, int numcols) {
		//Converts rectangles of '?' to letters
		while(left>0 && cake[up][left-1]=='?'){
			cake[up][left-1]=cake[up][left];
			left--;
		}
		if (left==0 && cake[up][left]=='?'){
			cake[up][0]=cake[up][1];
		}
		if(right!=numcols-1)
		while(right<numcols-1 && cake[up][right+1]=='?'){
			cake[up][right+1]=cake[up][right];
			right++;
		}
		if (right==numcols-1 && cake[up][right]=='?'){
			cake[up][numcols-1]=cake[up][numcols-2];
		}
		boolean checker = true;
		if(up!=0)
			while(up>0 && checker){
				for(int k=left; k<=right; k++){
					if(cake[up-1][k]!='?'){
						checker = false;
					}
				}
				if (checker){
					for(int k=left; k<=right; k++){
						cake[up-1][k]=cake[up][k];
					}
				}
				up--;
			}
		checker = true;
		if(up==0){
			for(int k=left; k<=right; k++){
				if(cake[up][k]!='?'){
					checker = false;
				}
			}
			if (checker){
				for(int k=left; k<=right; k++){
					cake[up][k]=cake[up+1][k];
				}
			}
		}
		checker = true;
		if(down!=numrows-1)
			while(down<numrows-1 && checker){
				for(int k=left; k<=right; k++){
					if(cake[down+1][k]!='?'){
						checker = false;
					}
				}
				if (checker){
					for(int k=left; k<=right; k++){
						cake[down+1][k]=cake[down][k];
					}
				}
				down++;
			}
		checker = true;
		if(down==numrows-1){
			for(int k=left; k<=right; k++){
				if(cake[down][k]!='?'){
					checker = false;
				}
			}
			if (checker){
				for(int k=left; k<=right; k++){
					cake[down][k]=cake[down-1][k];
				}
			}
		}
	}
}
