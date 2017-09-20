package kings.research;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class IntegerPartitions {
	
    /**
     * partition returns a list of int[] that represent all distinct partitions of n.
     */
    public static List<int[]> partition(int n) {
        List<Integer> partial = new ArrayList<Integer>();
        List<int[]> partitions = new ArrayList<int[]>();
        partition(n, partial, partitions);
        return partitions;
    }

    /**
     * If n=0, it copies the partial solution into the list of complete solutions.
     * Else, for all values i less than or equal to n, put i in the partial solution and partition the remainder n-i.
     */
    private static void partition(int n, List<Integer> partial, List<int[]> partitions) {
        //System.out.println("partition " + n + ", partial solution: " + partial);
        if (n == 0) {
            // Complete solution is held in 'partial' --> add it to list of solutions
        	int lastListIndex = partial.size() - 1;
        	//gets rid of all the partitions with multiple rows of ones
        	if(partial.size() == 1 || (partial.get(lastListIndex) + partial.get(lastListIndex - 1)) > 2) {
        		if(partial.size() == partial.get(0))
        		partitions.add(toArray(partial));
        	}
            
        } else {
            // Iterate through all numbers i less than n.
            // Avoid duplicate solutions by ensuring that the partial array is always non-increasing
            for (int i=n; i>0; i--) {
                if (partial.isEmpty() || partial.get(partial.size()-1) >= i) {
                    partial.add(i);
                    partition(n-i, partial, partitions);
                    partial.remove(partial.size()-1);
                }
            }
        }
    }

    /**
     * Helper method: creates a new integer array and copies the contents of the list into the array.
     */
    private static int[] toArray(List<Integer> list) {
        int i = 0;
        int[] arr = new int[list.size()];
        for (int val : list) {
            arr[i++] = val;
        }
        return arr;
    }
    
    
    /**
     * Main method written by Carol to utilize  partition code.
     * 
     * @param args Not used.
     */
    public static void main(String [] args) {
    	Scanner input = new Scanner(System.in);
    	
    	boolean quit = false;

    	while(!quit) {

    		System.out.println("Enter an integer or type quit");

    		try {
    			int ans = input.nextInt();


    			List<int[]> integerOne = IntegerPartitions.partition(ans);

    			int count = 1;

    			for(int[] i : integerOne) {
    				System.out.println("Partition " + count + ": ");
    				for(int p : i) {
    					System.out.print(p);
    					for(int j = 0; j < p; j++) {
    						System.out.print("*");
    					}
    					System.out.println();
    				}
    				System.out.println("");
    				CountRepeatingParts.countRepeatingPartsOfArray(i);
    				
    				System.out.println();
    				count++;
    			}

    			System.out.println("Number of partitions: " + (count - 1));

    		} catch(InputMismatchException e) {
    			quit = true;
    			System.out.println("Done!");
    		}
    	}

    	input.close();
    }

}
