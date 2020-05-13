package dataStructure;



public class stack   {
    private node head;
	private int size =0;
	private class node {
		private Object value;
		private node next;
		
		node(Object val){
			this.value=val;
		}
		node(Object val,node next){
			this.value=val;
			this.next=next;
		}
		public Object getValue() {
			return value;
		}
		
		
		
	}
	
	
	
	
	
	public Object pop() {
       if(head==null) { 	
    	   throw new IllegalArgumentException(" Stack is empty.");}
       else {
    	   Object o = head.getValue();
   
    	   head=head.next;
    	  size--;
    	   return o;
       }
       
       
	}

	
	public Object peek() {
		if(head==null) { throw new IllegalArgumentException(" Stack is empty.");
}
		return head.value;
	}

	
	public void push(Object element) {
      if(head==null) {
    	  node newNode =new node(element);
    	  head=newNode;
    	  }
      else {
		node newNode =new node(element,head);
		head=newNode;      
	}
       size++;  
	}

	
	public boolean isEmpty() {
	    if(head==null) {
	    	return true;
	    }
		
		
		return false;
	}

	
	public int size() {
		return this.size;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}