import java.io.*;
import java.util.*;

public class art {

	public static void main (String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new FileReader("art2.in"));
			//Scanner br = new Scanner(System.in);
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("art2.out")));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int[][] canvas = new int[length][length];

			for (int a=0; a<length; a++){
				st = new StringTokenizer(br.readLine());
				for(int b=0; b<length; b++){
					canvas[a][b] = Integer.parseInt(st.nextToken());
					}
					
				}
			}
}