import java.io.*;
import java.util.*;

public class cownomics {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		//Scanner br = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numberofcows = Integer.parseInt(st.nextToken());
		int lengthofnome = Integer.parseInt(st.nextToken());
		char[][] spotcows = new char[numberofcows][lengthofnome];
		char[][] unspotcows = new char[numberofcows][lengthofnome];
		for(int k=0; k<numberofcows; k++){
			st = new StringTokenizer(br.readLine());
			spotcows[k] = st.nextToken().toCharArray();
		}
		for(int k=0; k<numberofcows; k++){
			st = new StringTokenizer(br.readLine());
			unspotcows[k] = st.nextToken().toCharArray();
		}
		
		

	}

}
