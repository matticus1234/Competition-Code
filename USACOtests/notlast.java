import java.io.*;
import java.util.*;
class notlast {
	/*
	 * Farmer John owns 7 dairy cows: Bessie, Elsie, Daisy, Gertie, Annabelle, Maggie, and Henrietta. He milks them every day and keeps detailed records on the amount of milk provided by each cow during each milking session. Not surprisingly, Farmer John highly prizes cows that provide large amounts of milk.
Cows, being lazy creatures, don't necessarily want to be responsible for producing too much milk. If it were up to them, they would each be perfectly content to be the lowest-producing cow in the entire herd. However, they keep hearing Farmer John mentioning the phrase "farm to table" with his human friends, and while they don't quite understand what this means, they have a suspicion that it actually may not be the best idea to be the cow producing the least amount of milk. Instead, they figure it's safer to be in the position of producing the second-smallest amount of milk in the herd. Please help the cows figure out which of them currently occupies this desirable position.

INPUT FORMAT (file notlast.in):
The input file for this task starts with a line containing the integer N (1≤N≤100), giving the number of entries in Farmer John's milking log.
Each of the N following lines contains the name of a cow (one of the seven above) followed by a positive integer (at most 100), indicating the amount of milk produced by the cow during one of its milking sessions.

Any cow that does not appear in the log at all is assumed to have produced no milk.

OUTPUT FORMAT (file notlast.out):
On a single line of output, please print the name of the cow that produces the second-smallest amount of milk. More precisely, if M is the minimum total amount of milk produced by any cow, please output the name of the cow whose total production is minimal among all cows that produce more than M units of milk. If several cows tie for this designation, or if no cow has this designation (i.e., if all cows have production equal to M), please output the word "Tie". Don't forget to add a newline character at the end of your line of output. Note that M=0 if one of the seven cows is completely absent from the milking log, since this cow would have produced no milk.

Status: Solved
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		HashMap<String, Integer> cows = new HashMap<String, Integer>(7);
		StringTokenizer st = new StringTokenizer(br.readLine());
		//Set up input
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
		//Find the minimum 
		int minimum = milkmade[0];
		for (int k=0; k<7; ++k)
		{
			if (minimum > milkmade[k])
				minimum = milkmade[k];
		}
		int secondminimum = 999999999;
		//Find the secondleast minimum
		for (int k=0; k<7; ++k)
		{
			if(milkmade[k]>minimum && secondminimum > milkmade[k])
				secondminimum = milkmade[k];
		}
		String successfulcows = "Tie";
		Boolean chosen = false;
		//Determine who has the position or if it's a tie
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
		//Print Result
		pw.println(successfulcows);
		pw.close();
	}
}
