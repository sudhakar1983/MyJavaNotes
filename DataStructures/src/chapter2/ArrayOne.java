package chapter2;

public class ArrayOne {
	private int[] arr;
	private int size;
	
	
	public static void main(String[] args) {
		

		ArrayOne d = new ArrayOne();
		System.out.println(d.size);
		
		for(int i=0;i<10;i++){
			int r = (int) (Math.random()*10);
			d.add(r);
			System.out.print(r +" ");
		}
		
		
		
		System.out.println("");
		for(int i=0;i<d.size;i++){
			System.out.print(d.arr[i] +" ");
		}

	}
	
	public int getMax(){
		int max = -1;
		
		if(size >0 )  max = arr[size -1];
		
		return max;
	}
	
	public ArrayOne(){
		 arr = new int[10];
	}
	
	public void add(int value){

		
		//linear search
		int i=0;
		for(i=0;i<size;i++){
			if(arr[i]>value){
				break;
			}
		}
		
		if(i != size ) {			
			for(int j =size ;j>i;j--){
				arr[j] = arr[j -1];
			}
		}
		
		arr[i] = value;
		size++;

		if(size > arr.length) throw new RuntimeException("Array if full");
			
	}
	
	public int delete(int value){
		int delPosition = -1;
		for(int i=0;i<size;i++){
			if(arr[i] == value){
				arr[i] = 0;
				delPosition = i;
				break;
			}			
		}
		
		if(-1 != delPosition)
			for(int i = delPosition ;i<size;i++){
				if((i+1) == size){
					arr[i] = 0;
					size= size -1;	
					break;
				}
				arr[i] = arr[i+1];
			}
		
		return delPosition;
	}
}
