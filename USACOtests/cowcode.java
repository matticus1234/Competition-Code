import java.io.*;
import java.util.*;
/*
 * The cows are experimenting with secret codes, and have devised a method for creating an infinite-length string to be used as part of one of their codes.
Given a string s, let F(s) be s followed by s "rotated" one character to the right (in a right rotation, the last character of s rotates around and becomes the new first character). Given an initial string s, the cows build their infinite-length code string by repeatedly applying F; each step therefore doubles the length of the current string.

Given the initial string and an index N, please help the cows compute the character at the Nth position within the infinite code string.

INPUT FORMAT (file cowcode.in):
The input consists of a single line containing a string followed by N. The string consists of at most 30 uppercase characters, and N≤1018.
Note that N may be too large to fit into a standard 32-bit integer, so you may want to use a 64-bit integer type (e.g., a "long long" in C/C++).

OUTPUT FORMAT (file cowcode.out):
Please output the Nth character of the infinite code built from the initial string. The first character is N=1.

Status: Solved
 */
public class cowcode {
	public static void main(String[] args) throws IOException {
		//Take in Input
		BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String actualstring = st.nextToken();
		long n = Long.parseLong(st.nextToken());
		char[] resultarray = actualstring.toCharArray();
		int l = resultarray.length;
		//Figure out what character appears in the nth position
		while (n>l)
		{
			long x = l;
			while (x<n)
				x *= 2;
			if (n-(x/2)==1)
				n -=1;
			else
				n=n-(x/2)-1;
		}
		//Print the character
		if(n>0){
		pw.println(resultarray[(int)n-1]);
		}
		if(n==0){
			pw.println(resultarray[0]);
		}
		pw.close();
	}
	
	
}
