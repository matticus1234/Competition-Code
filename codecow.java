import java.io.*;
import java.util.*;

public class codecow {
	public static void main(String[] args) throws IOException {
		Scanner br = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		StringTokenizer st = new StringTokenizer(br.nextLine());
		String actualstring = st.nextToken();
		long n = Long.parseLong(st.nextToken());
		char[] resultarray = actualstring.toCharArray();
		int l = resultarray.length;
		while (n>=l)
		{
			long x = l;
			while (x<n)
				x *= 2;
			if (n-(x/2)==1)
				n -=1;
			else
				n=n-(x/2)-1;
		}
		
		System.out.println(resultarray[(int)n-1]);
		pw.close();
	}
	
	
}
