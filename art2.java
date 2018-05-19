import java.io.*;
import java.util.*;


public class art2 {

	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("art2.in"));
		//Scanner br = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("art2.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st.nextToken());
		int[] canvas = new int[length];
		boolean isvalid = true;
		
		for(int k=0; k<length; k++){
			st = new StringTokenizer(br.readLine());
			canvas[k] = Integer.parseInt(st.nextToken());
		}
		int[][] table = new int[length][length];
		for(int k=0; k<length; k++){
			if(canvas[k]==0)
				table[k][k]=0;
			else
				table[k][k]=1;
		}
		for(int a=0; a<length; a++){
			for(int b=0; b<length; b++){
				if(a != b){
					table[a][b]=-1;
				}
			}
		}
		if(check(canvas)){
			out.println(solve(canvas, table, 0, length-1));
		}else{
			out.println("-1");
		}

		out.close();
	
	}
	static boolean check(int[] canvas){
		Deque<Integer> stack = new ArrayDeque<Integer>();
		BST<Integer> unusable = new BST<Integer>();
		for(int k=0; k<canvas.length; k++){
			if (unusable.contains(canvas[k])){
				return false;
			}
			if (stack.contains(canvas[k])){
				while(stack.peek()!=canvas[k])
				unusable.insert(stack.pop());
			} else if (canvas[k]==0){
				while(!stack.isEmpty()){
					unusable.insert(stack.pop());
				}
			} else {
				stack.push(canvas[k]);
			}
		}
		return true;
	}
	static int solve(int[] canvas, int[][]table, int left, int right){
		if(table[left][right]!=-1){
			return table[left][right];
		}else if(canvas[left]==0){
			int temp= solve(canvas, table, left+1, right);
			table[left][right]=temp;
			return temp;
		}else if (canvas[right]==0){
			int temp= solve(canvas, table, left, right-1);
			table[left][right]=temp;
			return temp;
		}else if (canvas[left]==canvas[right]){
			if(right-left == 1){
				return 1;
			}else{
			boolean anothercopy = false;
			int copypos = 0;
			for(int k=left; k<right; k++){
				if (canvas[k]==canvas[right]){
					anothercopy = true;
					copypos = k;
				}
			}
			if (anothercopy){
				int temp = Math.max(solve(canvas, table, left, copypos),
						solve(canvas, table, copypos, right));
				table[left][right]=temp;
				return temp;
						
			}
			else{
			int temp= 1+solve(canvas, table, left+1, right-1);
			table[left][right]=temp;
			return temp;
			}
			}
		}else{
			int temp = Math.max(solve(canvas, table, left, right-1), 
					solve(canvas, table, left+1, right));
			table[left][right]=temp;
			return temp;
		}
	}
	
}
class BST<T extends Comparable<T>> {
	  private T datum;
	  private BST<T> left;
	  private BST<T> right;
	  public BST() {
	    datum = null;   // this is our notion of an empty tree
	  }
	  public BST(T datum) {
	    this.datum = datum;
	    left = null;
	    right = null;
	  }
	  public BST(T datum, BST<T> left, BST<T> right) {
	    this.datum = datum;
	    this.left = left;
	    this.right = right;
	  }
	  public boolean isEmpty() {
	    return (datum == null);
	  }
	  public T getDatum() {
	    return datum;
	  }
	  public BST<T> getLeft() {
	    return left;
	  }
	  public BST<T> getRight() {
	    return right;
	  }
	  public boolean isLeaf() {
	    return (!(datum == null) &&(getLeft() == null) &&(getRight() ==  null));
	  }
	  public void insert(T datum) {
		  if (this.datum==null)
			  this.datum = datum;
	    if (this.datum.compareTo(datum) > 0) {
	      if (left != null) {
	        left.insert(datum);
	      } else {
	        left = new BST<T>(datum);
	      }
	    } else if (this.datum.compareTo(datum) < 0) {
	      if (right != null) {
	        right.insert(datum);
	      } else {
	        right = new BST<T>(datum);
	      }
	    }
	  }  
	  public int depth() {
	    if (isEmpty()) return 0;
	    else {
	      return (int) (1 + (Math.max(
	      left == null ? 0 : left.depth(),
	      right == null ? 0 : right.depth())));
	    }
	  }
	  public boolean contains(T datum) {
	    if (isEmpty()) return false;
	    if (datum.compareTo(this.datum) < 0) {
	      if (left == null) {
	        return false;
	      } else {
	        return left.contains(datum);
	      }
	    } else if (datum.compareTo(this.datum) > 0) {
	      if (right == null) {
	        return false;
	      } else {
	        return right.contains(datum);
	      }
	    } else {
	      return true;
	    }
	  }
	}
