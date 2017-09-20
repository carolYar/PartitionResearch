package kings.research;

import java.util.List;

public class CountRepeatingParts {
	
	public static void countRepeatingParts(List<int[]> partitions) {
		
		int[] numParts = null;
		
		for(int[] partition : partitions) {
			int size = partition.length;
			numParts = new int[size];
			//correspoding index to part size.
			//since starts at 0 need to shift down part size - 1 in order
			// to place at the proper index.
			for(int current: partition) {
				System.out.println("Count");
			}
		}
	}

}
