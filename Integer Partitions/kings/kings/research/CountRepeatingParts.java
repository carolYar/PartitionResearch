package kings.research;

import java.util.List;

public class CountRepeatingParts {
	
	public static void countRepeatingParts(List<int[]> partitions) {
		
		for(int[] partition : partitions) {
			int size = partition.length;
			
			for(int current: partition) {
				System.out.println("Count");
			}
		}
	}

}
