import java.io.*;
import java.util.*;

public class cowdance {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
		//Scanner br = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numberofcows = Integer.parseInt(st.nextToken());
		int maxtime = Integer.parseInt(st.nextToken());
		int[] archives = new int[numberofcows];
		int stagesize = 1;
		
		for(int k=0; k<numberofcows; ++k)
		{
			 st = new StringTokenizer(br.readLine());
			 archives[k]= Integer.parseInt(st.nextToken());
		}
		while(dance(archives, maxtime, stagesize)>maxtime && stagesize<numberofcows)
		{
			stagesize++;
		}
		out.println(stagesize);
		out.close();

	}
	public static int dance(int[]array, int maxtime, int stagesize){
		int time = 0;
		int counter = stagesize;
		int min=999999;
		int max=0;
		int minloc=0;
		int[] copy = new int[stagesize];
		for(int k=0; k<stagesize; ++k)
			copy[k]=array[k];
		while (counter<array.length && time<maxtime)
		{
			min = 999999;
			for(int k=0; k<stagesize; k++)
			{
				if (min>copy[k])
				{
					min = copy[k];
					minloc = k;
				}
			}
			time += min;
			for(int k=0; k<stagesize; k++)
			{
				copy[k] -= min;
			}
			copy[minloc] += array[counter];
			counter++;
		}
		for(int k=0; k<stagesize; k++)
		{
			if (max<copy[k])
				max=copy[k];
		}
		return time+max;
	}
}
