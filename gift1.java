/*
ID: matthew55
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
	  public static void main (String [] args) throws IOException {
		    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		    StringTokenizer st = new StringTokenizer(f.readLine());

		    int numberofppl = Integer.parseInt(st.nextToken());

		    String[] names = new String[numberofppl];
		    HashMap<String, Integer> people = new HashMap<String, Integer>(numberofppl);
		    for (int counter=0; counter<numberofppl; ++counter)
		    {
			    st = new StringTokenizer(f.readLine());
		    	names[counter]=st.nextToken();
		    	people.put(names[counter], 0);
		    }

		    String giver;
		    int gift;
		    int split;
		    int payment;
		    String given;
		    for (int counter=0; counter<numberofppl; ++counter)
		    {
			    st = new StringTokenizer(f.readLine());
		    	giver = st.nextToken();
		    	 st = new StringTokenizer(f.readLine());
				gift = Integer.parseInt(st.nextToken());
				split = Integer.parseInt(st.nextToken());
				if (split == 0)
					payment = 0;
				else
					payment = gift/split;
				

		    	people.put(giver, people.get(giver)-payment*split);
		    	for (int counter2=0; counter2<split; ++counter2)
		    	{

			    	 st = new StringTokenizer(f.readLine());
		    		given = st.nextToken();

			    	people.put(given, people.get(given)+payment);
		    	}
		    }
		    for (int counter=0; counter<numberofppl; ++counter)
		    {
		    	out.println(names[counter]+" "+people.get(names[counter]));
		    }
		    
		    
		    out.close();                                  // close the output file
		  }
}
