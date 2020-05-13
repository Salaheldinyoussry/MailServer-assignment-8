package dataStructure;

public class singleLinkedList implements ILinkedList {
  
	
	
	private class slNode{
		Object value;
		slNode next;
		slNode(Object val){
			this.value =val;
			this.next=null;
		}
		
	}
	private slNode head;
	private int size =0;
	
	public void add(int index, Object element) {
	
		slNode newNode =new slNode(element);
		
		slNode temp =head;

		if(index ==0) {
		
			head=newNode;
			newNode.next=temp;
			size++;
			
		}
		else if (index>this.size  || index<0 ||head==null ) {
		}
		else {
			 //temp = head;
			for (int i=0; i<index-1; i++) {
				temp=temp.next;
				
			}
			 slNode tmp2;
			 tmp2=temp.next;
			 temp.next=newNode;
			 newNode.next=tmp2;
			 size++;
			
			
		}
		
}
	
	
	
	
	
	
	public void add(Object element) {
		
		slNode newNode =new slNode(element);
		
		slNode temp =head;
		
		if(head==null) {
			head=newNode;
			size++;
		}
		
		else {
		
		while(temp.next!=null) {
			
			temp=temp.next;
		}
		
		temp.next=newNode;
		
		size++;
	}
	}
	
		

	

	public Object get(int index)  {
		slNode tmp = head;
		 if (index>=this.size  || index<0 ||head==null ) {
		   return null;
		 }
		 else {
		
		for(int i=0; i<index; i++) {
			tmp=tmp.next;
		}
		
		return tmp.value;
	}}
		
		
		
	public void set(int index, Object element) {
		if (index>=this.size  || index<0 ||head==null ) {
            		   
		}
		else {
		slNode temp = head;
		for(int i=0; i<index; i++) {
			temp=temp.next;
		}
		temp.value=element;
		
		}
	}
	
	
	public void clear() {
		head=null;
	    this.size=0;
	}
	
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		else {
			return false;
		}
	}
	

	
	
	
	
	public void remove(int index) {
		slNode tmp =head;
		if (index>=this.size || index<0 ||head==null ) {
		 }
		else {
		if(index==0) {
			head.next=null;
			head=tmp.next;
		   size--;
		}
		else {
		for(int i = 0; i<index-1; i++) {
			
			tmp=tmp.next;
			
		}
		
		slNode tmp2 =tmp.next.next;
		
		tmp.next=tmp2;
		
		size--;
	}}}
	
	
	public int size() {
		/*
		slNode tmp=head;
		int count=0;
		while(tmp!=null) {
			tmp=tmp.next;
			count++;
			
		}*/
	return this.size;
	}

	
	
	
	
	

	public ILinkedList sublist(int fromIndex, int toIndex) {
		
		if (fromIndex>=this.size  || fromIndex<0 ||head==null || toIndex>=this.size ||   toIndex<0) {
		 return null; 
		}
		else {
		
		ILinkedList  sublist =new singleLinkedList();
		slNode tmp = head;
		
		for(int i=0; i<fromIndex; i++) {
			tmp=tmp.next;
			
		}
	    for(int i=0; i<(toIndex-fromIndex+1); i++) {
	    	sublist.add(tmp.value);
	    	tmp=tmp.next;
	    	
	    }
	
	  return sublist;
	}
	}
	
	
	
	
	public boolean contains(Object o) {
		slNode tmp=head;
		while(tmp!=null) {
			if(tmp.value==o) {
				return true;
			}
			tmp=tmp.next;
		}
	   return false;
	}






	
	
	
	
	
	
	
	
	
	
	
}
