/*
ID: matthew55
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    String s1 = st.nextToken();
    st = new StringTokenizer(f.readLine());
    String s2 = st.nextToken();
    char[] ch1 = s1.toCharArray();
    char[] ch2 = s2.toCharArray();
    int result1 = 1;
    int result2 = 1;
    for (char k : ch1)
    {
    	result1 *= Character.getNumericValue(k)-9;
    	result1 %= 47;
    }
    for (char k : ch2)
    {
    	result2 *= Character.getNumericValue(k)-9;
    	result2 %= 47;
    }
    if (result1 == result2)
    {
    out.println("GO");	
    }
    else
    {
    	out.println("STAY");
    }
    out.close();                                  // close the output file
  }
}
