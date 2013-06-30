package chapter2;

public class HighArray {
	
	
	public static void main(String[] args) {
		HighArray d = new HighArray();
		System.out.println(d.size);
		
		for(int i=0;i<10;i++){
			int r = (int) (Math.random()*10);
			d.add(r);
			System.out.print(r +" ");
		}
		
		d.delete1(9);
		
		
		for(int i=0;i<=d.last_index;i++){
			System.out.print(d.arr[i] +" ");
		}

	}
	
	
	public int[] arr;
	public int size;
	public int last_index=-1;
	
	
	public HighArray(){
		arr = new int[10];
		this.size = 10;
	}
	
	
	public void add(int value){
		last_index = last_index +1;
		
		if((last_index +1) > size ) throw new RuntimeException("Arrays is full");
		arr[last_index] = value;
	}
	
	public int findPositionByValue(int value){
		int pos = -1;
		
		for(int i =0;i<=last_index;i++){			
			if(arr[i] == value) {
				pos = i;
				break;				
			}
		}
		return pos;
	}
	
	
	public int delete1(int value){
		int deletedPOs = -1;
		for(int i =0;i<=last_index;i++){
			if(arr[i] == value  && deletedPOs == -1) {
				arr[i] = 0;	
				deletedPOs = i;		
				break;
			}			
		}
	
		if(deletedPOs != -1)
		for(int i=deletedPOs ;i<=last_index ;i++){			
			if(i == last_index){
				arr[last_index] = 0; break;
			}
			arr[i] = arr[i+1];			
		}
		
		
		return  deletedPOs;
	}
	
	public int delete(int value){
		int deletedPOs = -1;
		for(int i =0;i<=last_index;i++){			
			if(arr[i] == value  && deletedPOs == -1) {
				arr[i] = 0;	
				deletedPOs = i;
				if( (i+1) < last_index)arr[deletedPOs]=arr[i+1];
			}else if(deletedPOs != -1){
				if( (i+1) <= last_index)arr[i]= arr[i+1];	
			}
		}
		arr[last_index] = 0;
		last_index = last_index -1;
		return deletedPOs;
	}

}
