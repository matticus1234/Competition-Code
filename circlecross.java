import java.util.*;
import java.io.*;

public class circlecross {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
		// Scanner br = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int numberofcows = Integer.parseInt(st.nextToken());
		int numberofpoints = numberofcows * 2;
		int[][] entrypoints = new int[numberofcows][2];
		for (int k=0; k<numberofcows; k++){
			entrypoints[k][0] = -1;
			entrypoints[k][1] = -1;
		}
		int temp = 0;
		for (int k=0; k<numberofpoints; k++){
			st = new StringTokenizer(br.readLine());
			temp = Integer.parseInt(st.nextToken())-1;
			if (entrypoints[temp][0]==-1){
				entrypoints[temp][0]=k;
			}
			else
				entrypoints[temp][1]=k;
		}
		int numberofintersections = 0;
		for (int a=0; a<numberofcows; a++){
			for (int b=a+1; b<numberofcows; b++){
				if((entrypoints[a][0]>entrypoints[b][0] && entrypoints[a][0]<entrypoints[b][1])&&
						(entrypoints[b][1]>entrypoints[a][0] && entrypoints[b][1]<entrypoints[a][1])){
					numberofintersections++;
				}
				else if ((entrypoints[b][0]>entrypoints[a][0] && entrypoints[b][0]<entrypoints[a][1])&&
						(entrypoints[a][1]>entrypoints[b][0] && entrypoints[a][1]<entrypoints[b][1]))
					numberofintersections++;
			}
		}
		out.println(numberofintersections);
		out.close();
	
	}
}
