package project3;

import java.util.Random;

public class Project3 {

		static int[] theArray;
		static int[] copy1;
		static int[] copy2;
		static int[] copy3;
		
		final int arraySize = 100000;
		
		final int MAXRNGE = 999999;
		
		int temp;
		
		long start = System.nanoTime();
		
		//Original quickSort
		public void quickSort(int [] list, int left, int right, Boolean show) {
			int l = left;
			int r = right;
			int pivot = list[((right+left)/2)];
			
			while (l <= r){
				while (list[l] < pivot)
					l++;
				while (list[r] > pivot)
					r--;
				if (l <= r){
					temp = list[l];
					list[l] = list[r];
					list[r] = temp;
					
					l++;
					r--;
				}
			}
			
			if (left < r)
				quickSort(list, left, r, show);
			if (l < right)
				quickSort(list, l, right, show);
			if (left == 0 && right == list.length - 1){
				System.out.println("Completed quickSort: ");
				show(list, show);
			}
		}
		
		//Executes insert sort on smaller portions of array
		public void quickSortOpt1(int [] list, int left, int right, Boolean show) {
			int l = left;
			int r = right;
			Boolean cont = true;
			int pivot = list[((right+left)/2)];
			while (l <= r && cont){
				if (show)
					System.out.println("quickSortingOpt1....");

				while (list[l] < pivot)
					l++;
				while (list[r] > pivot)
					r--;

				if (l <= r){
					temp = list[l];
					list[l] = list[r];
					list[r] = temp;
					l++;
					r--;
				}
				if ((r - l) < 10){
					insertSort(list,left,right, show);
					cont = false;
				}
			}
			if (left < r && cont)
				quickSortOpt1(list, left, r, show);
				
			if (l < right && cont)
				quickSortOpt1(list, l, right, show);
			}
		
		//Executes insert sort on almost sorted array
		public void quickSortOpt2(int [] list, int left, int right, Boolean show) {
			int l = left;
			int r = right;
			int pivot = list[((right+left)/2)];
			while (l <= r){
				if (show)
					System.out.println("quickSortingOpt2....");
				while (list[l] < pivot)
					l++;
				while (list[r] > pivot)
					r--;

				if (l <= r){
					temp = list[l];
					list[l] = list[r];
					list[r] = temp;
					l++;
					r--;
				}
				
				if ((r - l ) < 10){
					insertSort(list, left, right, show);
					l = r + 10;
				}
				
			}
			if (left < r)
				this.quickSort(list, left, r, show);
			if (l < right)
				this.quickSort(list, l, right, show);
		}
		
		//Insert sort
	    public void insertSort(int[] list, int start, int end, Boolean show){
	    	if (show)
	    		System.out.println("Array passed to insertSort: ");
	    		show(list, show);
	        for (int x = start; x < end+1; x++){
	            int val = list[x];
	            int j = (x - 1);
	            while (j >= 0 && val < list[j]) {
	                list[j + 1] = list[j];
	                j--;
	            }
	            list[j + 1] = val;
	        }
	        if (show)
	        	System.out.println("Completed insertSort:");
	        show(list,show);
	    }

	    //Creates new random array & clones for method use
	    public void createArray() {
		theArray = new int[arraySize];
		Random random = new Random ();

			for (int i = 0; i < arraySize; i++) {

				theArray[i] = random.nextInt(MAXRNGE);
			}
			 copy1 = theArray.clone();
			 copy2 = theArray.clone();
			 copy3 = theArray.clone();
		}
		
	    //Prints array out if true; prints elapsed time if false
	    public void show(int[] list, boolean show) {
		if (show){

		for (int n = 0; n < arraySize*8; n++)
				System.out.print("-");

			System.out.println();

			for (int n = 1; n < arraySize; n++) {
				System.out.print(String.format("| %2s " + " ", list[n-1]));
				if (n % 5 == 0){
					System.out.println();
				}
			}
			
			System.out.println();
			
			for (int n = 0; n < arraySize*8; n++)
				System.out.print("-");

			System.out.println();
		}
			else {
				long end = System.nanoTime();
				long elapsedTime = end - start;
				 System.out.println("The process took approximately: " + elapsedTime + " nano seconds");
			}
		}
}
