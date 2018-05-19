import java.util.*;
import java.io.*;

public class circlecross2 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
		//Scanner br = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int numberofcows = Integer.parseInt(st.nextToken());
		int numberofpoints = numberofcows * 2;
		int numberofintersections = 0;
		String temp;
		int tempind;
		HashMap<String, Integer> positionmap = new HashMap<String, Integer>();
		for (int k=0; k<numberofpoints; k++){
			st = new StringTokenizer(br.readLine());
			temp = st.nextToken();
			if (positionmap.get(temp) != null){
				tempind = positionmap.get(temp);
			numberofintersections += positionmap.size()-tempind-1;
			}
			else{
				positionmap.put(temp, positionmap.size()-1);

			}
		}
		out.println(numberofintersections);
		out.close();
			
			
			
		}
	
	}
