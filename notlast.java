import java.io.*;
import java.util.*;
class notlast {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		HashMap<String, Integer> cows = new HashMap<String, Integer>(7);
		StringTokenizer st = new StringTokenizer(br.readLine());
		cows.put("Bessie", 0);
		cows.put("Elsie", 0);
		cows.put("Daisy", 0);
		cows.put("Gertie", 0);
		cows.put("Annabelle", 0);
		cows.put("Maggie", 0);
		cows.put("Henrietta", 0);
		String currentcow;
		int milk=0;
		int[] milkmade = new int[7];
		String[] names = new String[7];
		names[0]="Bessie";
		names[1]="Elsie";
		names[2]="Daisy";
		names[3]="Gertie";
		names[4]="Annabelle";
		names[5]="Maggie";
		names[6]="Henrietta";
		for (int i=0; i<7; i++)
		{
			milkmade[i]=0;
		}
		int entries = Integer.parseInt(st.nextToken());
		for (int counter=0; counter<entries; ++counter)
		{
			st = new StringTokenizer(br.readLine());
			currentcow = st.nextToken();
			milk = Integer.parseInt(st.nextToken());
			cows.put(currentcow, cows.get(currentcow)+milk);
		}
		milkmade[0]=cows.get("Bessie");
		milkmade[1]=cows.get("Elsie");
		milkmade[2]=cows.get("Daisy");
		milkmade[3]=cows.get("Gertie");
		milkmade[4]=cows.get("Annabelle");
		milkmade[5]=cows.get("Maggie");
		milkmade[6]=cows.get("Henrietta");
		int minimum = milkmade[0];
		for (int k=0; k<7; ++k)
		{
			if (minimum > milkmade[k])
				minimum = milkmade[k];
		}
		int secondminimum = 999999999;
		for (int k=0; k<7; ++k)
		{
			if(milkmade[k]>minimum && secondminimum > milkmade[k])
				secondminimum = milkmade[k];
		}
		String successfulcows = "Tie";
		Boolean chosen = false;
		for (int k=0; k<7; ++k)
		{
			if(cows.get(names[k])==secondminimum)
			{
				if (chosen)
				{
					successfulcows = "Tie";
				}
				else
				{
					chosen = true;
					successfulcows = names[k];
				}
			}
		}
		pw.println(successfulcows);
		pw.close();
	}
}
