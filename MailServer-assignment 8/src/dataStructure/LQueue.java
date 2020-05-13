package dataStructure;

public class LQueue implements IQueue {

	
	
	
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
	
	node head;
	node tail;
	private int size=0;
	
	@Override
	public void enqueue(Object item) {
		node newNode= new node(item);
		if(isEmpty()) {
			head=newNode;
			tail=newNode;
		}
		else {
			newNode.next=null;
			tail.next=newNode;
			tail=newNode;
		}
	 size++;
	}

	@Override
	public Object dequeue() {
      Object o;
		if(isEmpty()) {
    	throw new IllegalStateException("Queue is Empty"); 
     }
     else {
    	  o=head.value;
    	 head=head.next;
    	 size--;
     }
		return o;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}


}

