import java.io.*;
public class Main {
	//If you have a valid IDE, the only thing you need to do is open this file
	//and run it. It should spit out the answer 1530807640.
	public static void main(String[] args){
		// I create the hypercube, as well as an array of "blinkers" that tell me 
		// which entries in the hypercube could have a 1. I then have a boolean 
		// array which tells me if that entry is a 1 or a 0.
		int[][] hcube = new int[8][8];
		int[] config = new int[32];
		config[0]=0; config[1]=1; config[2]=2; config[3]=3;
		config[4]=8; config[5]=9; config[6]=12; config[7]=13;
		config[8]=16; config[9]=18; config[10]=20; config[11]=22;
		config[12]=25; config[13]=26; config[14]=28; config[15]=31;
		config[16]=32; config[17]=35; config[18]=37; config[19]=38;
		config[20]=41; config[21]=43; config[22]=45; config[23]=47;
		config[24]=50; config[25]=51; config[26]=54; config[27]=55;
		config[28]=60; config[29]=61; config[30]=62; config[31]=63;
		int retresult = 0;
		boolean[] onoff = new boolean[32];
		//I create the hypercube here.
		for (int a=0; a<8; a++)
			for(int b=0; b<8; b++)
				hcube[a][b]=0;
		//I create the boolean array here and update the hypercube so it starts with
		//all 1s in play. Except for the 1st one, which gets added on at the end
		//because I got lazy while coding.
		for (int k=0; k<32; k++)
			onoff[k] = true;
		update(onoff, config, hcube, 31);
		//I create my number 2^32. This will let me iterate through all possible
		//boolean states.
		long asdf = 1024;
		asdf *= 1024;
		asdf *= 1024;
		asdf *= 4;
		for (long k=0; k<asdf; k++){
			//First I update my hypercube.
			int temp = bupdate(onoff);
			update(onoff, config, hcube, temp);
			//Then I check if my hypercube satsifies a valid configuration.
			//I have two checking conditions which I'll explain down below.
			if (checko(onoff) && check(hcube)){
				//If it does, then I add one to the returned result.
				retresult++;
			}
			//I leave this in here to ensure that my code is running and runs smoothly.
			//The program does take anywhere from 5 to 15 minutes, and could
			//potentially take a much longer time if the computer is running slowly.
			if (k%100000==0){
				System.out.println(retresult);
			}
			//I print my result out here.
		}
		System.out.print(retresult);
	}
	public static boolean checko (boolean[] onoff){
		//This checks if I have at least eight ones in my array.
		//If not, I return false.
		int a=0;
		for (int k=0; k<32; k++)
			if(onoff[k])
				a++;
		if (a>7)
			return true;
		return false;	
	}
	public static int bupdate(boolean[] onoff){
		//This sends my boolean array to the next state it's supposed to be in.
		//It returns how many numbers I had to change, in order to optimize
		//my program. So my program won't take an entire day to run.
		int k=0;
		while (k<32 && !onoff[k]){
			onoff[k]=true;
			k++;
		}
		//This makes sure that I'm not causing my program to crash via an
		//array out-of-bounds error.
		if (k<32){
			onoff[k]=false;
		return k+1;
		}
		return k;
	}
	public static void update(boolean[] onoff, int[] config, int[][] hcube, int temp){
		//This uses my boolean array to update my hypercube.
		for (int j=0; j<temp; j++){
			if (onoff[j]){
				hcube[config[j]/8][config[j]%8]=1;
			}
			else{
				hcube[config[j]/8][config[j]%8]=0;
			}	
		}
	}
	public static boolean check(int[][] set){
		//This checks my hypercube to make sure that every row has a 1 and every
		//column has a 1. If it does so, it's a valid configuration.
		for (int a=0; a<8; a++)
		{
			if (!rcheck(set, a))
				return false;
		}
		for (int a=0; a<8; a++)
		{
			if (!ccheck(set, a))
				return false;
		}
		return true;
	}
	public static boolean ccheck(int[][] set, int col){
		//This checks a specific column for a 1.
		for (int a=0; a<8; a++)
		{
			if(set[col][a]==1)
				return true;
		}
		return false;
	}
	public static boolean rcheck(int[][] set, int row){
		//This checks a specific row for a 1.
		for (int a=0; a<8; a++)
		{
			if(set[a][row]==1)
				return true;
		}
		return false;
	}	
}
