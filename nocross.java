import java.util.*;
import java.io.*;

public class nocross {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("nocross.in"));
		//Scanner br = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocross.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int numberofspots =Integer.parseInt(st.nextToken());
		
		int[] topside = new int[numberofspots];
		int[] botside = new int[numberofspots];
		for (int k=0; k<numberofspots; k++)
		{
			st = new StringTokenizer(br.readLine());
			topside[k]=Integer.parseInt(st.nextToken());
		}
		for (int k=0; k<numberofspots; k++)
		{
			st = new StringTokenizer(br.readLine());
			botside[k]=Integer.parseInt(st.nextToken());
		}
		int[][] helpervalues = new int[numberofspots+1][numberofspots+1];
		for (int a=0; a<numberofspots+1; a++)
			for (int b=0; b<numberofspots+1; b++)
				helpervalues[a][b]=-1;
		
		out.println(helper(topside, botside, 0, 0, helpervalues, numberofspots));
		out.close();
		
	}
	
	public static int helper(int[] topside, int[]botside, int topspot, int botspot, int[][]helpervalues, int numberofspots){
		if (topspot >= numberofspots || botspot >= numberofspots){
			return 0;
		}
		if (topside[topspot]-botside[botspot]>=-4 && topside[topspot]-botside[botspot]<=4){
			if (helpervalues[topspot+1][botspot+1]!=-1)
			{
				helpervalues[topspot][botspot]=helpervalues[topspot+1][botspot+1]+1;
				return helpervalues[topspot][botspot];
			}
			else
			return 1 + helper(topside, botside, topspot+1, botspot+1, helpervalues, numberofspots);
		}
		else{
			if(helpervalues[topspot+1][botspot]==-1 && helpervalues[topspot][botspot+1]==-1){
				helpervalues[topspot][botspot] = Math.max(helper(topside, botside, topspot, botspot+1, helpervalues, numberofspots),
						helper(topside, botside, topspot+1, botspot, helpervalues, numberofspots));
				return 	helpervalues[topspot][botspot];}
			else if(helpervalues[topspot+1][botspot]==-1 && helpervalues[topspot][botspot+1]!=-1){
				helpervalues[topspot][botspot] = 
						Math.max(helpervalues[topspot][botspot+1],
								helper(topside, botside, topspot+1, botspot, helpervalues, numberofspots));
				return helpervalues[topspot][botspot];}
			else if(helpervalues[topspot+1][botspot]!=-1 && helpervalues[topspot][botspot+1]==-1){
				helpervalues[topspot][botspot]=
						Math.max(helpervalues[topspot+1][botspot],
								helper(topside, botside, topspot, botspot+1, helpervalues, numberofspots));;
				return helpervalues[topspot][botspot];}
			else{
				helpervalues[topspot][botspot]=Math.max(helpervalues[topspot+1][botspot], helpervalues[topspot][botspot+1]);
				return helpervalues[topspot][botspot];
				
			}
				
			
		}
	}
}
