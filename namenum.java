/*
 ID: matthew55
 LANG: JAVA
 TASK: namenum
 
 */





import java.io.*;
import java.util.*;


public class namenum {

	  public static void main (String [] args) throws IOException {
		    BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		    StringTokenizer st = new StringTokenizer(f.readLine());
		    String serialnum = st.nextToken();
		    
		    f = new BufferedReader(new FileReader("dict.txt"));
		    String namecheck;
		    String[] listofnames = new String[2000];
		    listofnames[0]="NONE";
		    int numberofnames = 0;
		    for (int i=0; i<4617; i++)
		    {
		    	st = new StringTokenizer(f.readLine());
		    	namecheck = st.nextToken();
		    	if (namecheck.length()==serialnum.length())
		    	{
		    		int charcheck = 0;
		    		while(charcheck<serialnum.length() && numbercheck(namecheck, serialnum, charcheck))
		    		{
		    			++charcheck;
		    		}
		    		if (charcheck == serialnum.length())
		    		{
		    			listofnames[numberofnames]=namecheck;
		    			++numberofnames;
		    		}
		    	}
		    }
		    if (numberofnames != 0)
		    {
		    	for(int k=0; k<numberofnames; k++)
		    		out.println(listofnames[k]);
		    }
		    else
		    {
		    	out.println("NONE");
		    }
		    out.close();
	  }
	  public static boolean numbercheck(String name, String number, int k)
	  {
		  char[] namarray = name.toCharArray();
		  char[] numarray = number.toCharArray();
		  if (numarray[k]=='2' && (namarray[k] == 'A' || namarray[k] == 'B' || namarray[k] == 'C'))
			  return true;
		  if (numarray[k]=='3' && (namarray[k] == 'D' || namarray[k] == 'E' || namarray[k] == 'F'))
			  return true;
		  if (numarray[k]=='4' && (namarray[k] == 'G' || namarray[k] == 'H' || namarray[k] == 'I'))
			  return true;
		  if (numarray[k]=='5' && (namarray[k] == 'J' || namarray[k] == 'K' || namarray[k] == 'L'))
			  return true;
		  if (numarray[k]=='6' && (namarray[k] == 'M' || namarray[k] == 'N' || namarray[k] == 'O'))
			  return true;
		  if (numarray[k]=='7' && (namarray[k] == 'P' || namarray[k] == 'R' || namarray[k] == 'S'))
			  return true;
		  if (numarray[k]=='8' && (namarray[k] == 'T' || namarray[k] == 'U' || namarray[k] == 'V'))
			  return true;
		  if (numarray[k]=='9' && (namarray[k] == 'W' || namarray[k] == 'X' || namarray[k] == 'Y'))
			  return true;

		  return false;
		  
		  
	  }
	  
	  
	  
}
