import java.util.*;
import java.io.*;

public class bphoto {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("bphoto.in"));
		//Scanner br = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bphoto.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numberofcows = Integer.parseInt(st.nextToken());
		int[][] photo = new int[numberofcows][3];
		for (int k=0; k<numberofcows; k++)
		{
			st = new StringTokenizer(br.readLine());
			photo[k][0]=Integer.parseInt(st.nextToken());
			photo[k][1]=0;
			photo[k][2]=0;
		}
		for (int counter1 = 0; counter1<numberofcows; counter1++)
		{
			for(int counter2 = 0; counter2<counter1; counter2++)
			{
				if (photo[counter1][0]>photo[counter2][0])
				{
					++photo[counter2][2];
				}
				else
				{
					++photo[counter1][1];
				}
			}
		}
		int result = 0;
		for (int counter=0; counter<numberofcows; counter++)
		{
			if (photo[counter][1]>2*photo[counter][2] || photo[counter][2]>2*photo[counter][1])
				result++;
		}
		
		out.println(result);
		out.close();	
	}
}
