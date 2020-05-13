package mainCode;

public class PriorityQueue implements IPriorityQueue {
	  private node head;
		private int size =0;
		private class node {
			 Object value;
			 int key;
			 node next;
			
			
			node(Object val,int key){
				this.value=val;
				this.key=key;
			}
			
		}
 
	@Override
	public void insert(Object item, int key) {
	 node newNode =new node(item ,key);
		if(size==0) {
		head=newNode;
	}
		else if(key<head.key) {
			node tmp=head;
			if(key<head.key) {
				newNode.next=tmp; 
			 head=newNode;
			}
			else {head.next=newNode;}
		}
	else {
		node x=head;
		while(x.next!=null) {
			if(key<x.next.key) {
				break;
			}
			x=x.next;
		}
	   newNode.next=x.next;
	   x.next=newNode;
	
	}
		size++;
	}

	@Override
	public Object removeMin() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new IllegalArgumentException("PriorityQueue is Empty!!!");
		}
		Object x= head.value;
		head=head.next;
		size--;

		return x;
	}

	@Override
	public Object min() {
		return head.value;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return size;
	}

}
