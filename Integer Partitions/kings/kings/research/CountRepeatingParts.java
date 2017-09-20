package kings.research;

//import java.util.List;

public class CountRepeatingParts {
	
//	/**
//	 * Counts the number of times a part repeats in a given partition.
//	 * 
//	 * @param partitions The list of partitions.
//	 */
//	public static void countRepeatingParts(List<int[]> partitions) {
//		
//		int[] numParts = null;
//		
//		for(int[] partition : partitions) {
//			int size = partition.length;
//			numParts = new int[size];
//			for(int i = 0; i < numParts.length; i++) {
//				numParts[i] = 0;
//			}
//			//correspoding index to part size.
//			//since starts at 0 need to shift down part size - 1 in order
//			// to place at the proper index.
//			for(int current: partition) {
//				numParts[current - 1] = numParts[current - 1]++;
//			}
//		}
//	}
	
	/**
	 * Counts number of repeating parts in a specific array.
	 * 
	 * @param partition The array we're working with.
	 */
	public static void countRepeatingPartsOfArray(int[] partition) {
		//TODO: THIS WILL NOT WORK WITH A CASE THAT IS NOT N X N
		// FIX TO WORK WITH GREATER CASES OR ELSE INDEX OUT OF BOUNDS.
		
		int[] numParts = new int[partition.length];
		
		for(int i = 0; i < numParts.length; i++) {
			numParts[i] = 0;
		}
		

		//correspoding index to part size.
		//since starts at 0 need to shift down part size - 1 in order
		// to place at the proper index.
		for(int i = 0; i < partition.length; i++) {
			//System.out.println("Current index: " + i);
			
			int size = partition[i];
			//System.out.println("Size of this index: " + size);
			
			int trueIndex = size - 1;
			
			//System.out.println("True index: " + trueIndex);
			
			int currentNumParts = numParts[trueIndex];
			
			//System.out.println("Current number of parts: " + currentNumParts);
			
			currentNumParts++;
			
			//System.out.println("New number of parts: " + currentNumParts);
			
			numParts[trueIndex] = currentNumParts++;
			
			//System.out.println("Num parts at " + trueIndex + " is " + numParts[trueIndex]);
			
			//System.out.println();
		}
		
		for(int i = 0; i < numParts.length; i++) {
			int repeats = numParts[i];
			if(repeats > 0) {
				System.out.println("Part of size " + (i + 1) + " repeats " + repeats + " times." );
			}
		}

	}

}
