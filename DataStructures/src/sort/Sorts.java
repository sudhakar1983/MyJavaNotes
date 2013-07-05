package sort;

import java.util.Random;

public class Sorts {
	
	private static final int LIMIT = 1000;
	
	int arr[];
	//Statistics
	long swapCount = 0;
	long copyCOunt = 0;
	long comparisons = 0;
	
	
	public Sorts(int [] arr){
		this.arr = arr;
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("Reverse Sorted Array ");
		System.out.println("=======================");
		int arr[] = Sorts.reverseSortedArray(10);
		
			
		Sorts s = new Sorts(arr);
		s.displayArray();	
		System.out.println("Bubble sort");
		s.bubbleSort();
		s.displayStatistics();		
		arr = Sorts.reverseSortedArray(10);
		s = new Sorts(arr);
		System.out.println("Selection sort");
		s.selectionSort();
		s.displayStatistics();
		
		arr = Sorts.reverseSortedArray(10);
		s = new Sorts(arr);
		System.out.println("INsertion  sort");
		s.insertionSort();	
		s.displayStatistics();
		
		
		
		System.out.println("Random Sorted Array ");
		System.out.println("=======================");		
		arr = Sorts.generateArray(10);
		s = new Sorts(arr);
		s.displayArray();	
		System.out.println("Bubble sort");
		s.bubbleSort();
		s.displayStatistics();		
		arr = Sorts.generateArray(10);
		s = new Sorts(arr);
		System.out.println("Selection sort");
		s.selectionSort();
		s.displayStatistics();
		
		arr = Sorts.generateArray(10);
		s = new Sorts(arr);
		System.out.println("INsertion  sort");
		s.insertionSort();	
		s.displayStatistics();

	}
	
	
	public void displayStatistics(){
		
		System.out.println(" Swap Count = "+ swapCount);
		System.out.println(" Copy Count = "+ copyCOunt);
		System.out.println(" comparisons = "+ comparisons);		
		System.out.println("**********************************");
	}
	
	public  void displayArray(){
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println(" ");System.out.println(" ");
	}
	
	
	
	public  void bubbleSort(){		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				//Statistics
				comparisons++;
				
				if(arr[j] < arr[i]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
					//Statistics
					swapCount++;
					//Statistics
					copyCOunt = copyCOunt+ 3;
				}
			}
			//Statistics
			comparisons++;
			
		}
	}
	
	
	public  void selectionSort(){
		for(int i=0;i<arr.length;i++){
			int index = i;
			for(int j=i+1;j<arr.length;j++){
				//Statistics
				comparisons++;
								
				if(arr[j] < arr[index]){
					index = j;
					
					//Statistics
					copyCOunt++;
				}
			}
			if(index != i){
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				
				//Statistics
				swapCount++;
				//Statistics
				copyCOunt++;
			}
			//Statistics
			comparisons++;
			
		}
	}
	
	
	public  void insertionSort(){
		for(int i=0;i< arr.length;i++ ){
			int temp = arr[i];
			int j = i-1;
			while(j>=0 && arr[j] > temp){
				
				
				arr[j+1] = arr[j];

				//Statistics
				copyCOunt++;	
				//Statistics
				comparisons++;
				
				j--;
			}
			arr[j+1]= temp;
			//Statistics
			copyCOunt++;
			//Statistics
			swapCount++;
/*			int j = 0;
			for(j=i-1; j>=0 ;j--){				
				if(arr[j] < temp ){
					break;
				}			
				arr[j+1]= arr[j];
			}
			arr[j+1] = temp;*/
			
			//Statistics
			comparisons++;
			
			
		}
	}
	
	
	public static int[] generateArray(int noOfItems){
		int[] arr = new int[noOfItems];		
		Random r = new Random(noOfItems * noOfItems);
		
		for(int i=0;i<noOfItems;i++){			
			arr[i] = r.nextInt(LIMIT);			
		}		
		return arr;
	}
	
	
	public static int[] reverseSortedArray(int noOfItems){
		int[] arr = new int[noOfItems];			
		
		int limit = noOfItems;
		for(int i=0;i<limit;i++){			
			arr[i] = noOfItems;	
			noOfItems--;
		}		
		return arr;
	} 

}
