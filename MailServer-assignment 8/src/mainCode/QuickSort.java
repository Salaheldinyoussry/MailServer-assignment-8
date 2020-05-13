package mainCode;

import dataStructure.DLinkedList;
import dataStructure.stack;

/*public class QuickSort {
	
	DLinkedList D=new DLinkedList();
	Stack s=new Stack();
	private int st;
    String[] t;
	QuickSort(DLinkedList D,String st){
		for(int i=1;i<=D.size();i++) D.set(i,(""+D.get(i)).trim());
		this.D=D;
		if(st.compareToIgnoreCase("sender")==0) {this.st=1;}
		else if(st.compareToIgnoreCase("receivers")==0) {this.st=2;}
		else if(st.compareToIgnoreCase("subject")==0) {this.st=3;}
		else if(st.compareToIgnoreCase("date")==0) {this.st=4;}
		else if(st.compareToIgnoreCase("attachments")==0) {this.st=6;}
		else if(st.compareToIgnoreCase("body")==0) {this.st=7;}
	}
	//sender#receivers#subject#date#priority#attachments#body
	//////////////////////////////////////////////////////////
	public void swap(int i,int j) {
		Object temp=D.get(i);
		D.set(i,D.get(j));D.set(j,temp);
	}
    
    public int part(int low,int high) {
    	int i=low,j=0;
    	for(j=low;j<high;j++) {
    		if(((((""+D.get(j)).split("#")[st-1]).compareTo((""+D.get(high)).split("#")[st-1])>0))&&(st==4)) {
    			swap(i++,j);}
    		else if(((((""+D.get(j)).split("#")[st-1]).compareTo((""+D.get(high)).split("#")[st-1])<0))&&(st!=4)) {
    			swap(i++,j);}
    	}
    	swap(i,j);
    	return i;}
    
    public String sortEI(String da) {
    	if(st==2) {
    	t=da.split("#")[1].split("~");}
    	else if(st==6) {
    	t=da.split("#")[5].split("~");
    	}
    	String tr[]=sortLQ(t);
    	String stt="";
    	for(int i=0;i<tr.length;i++) {stt+=tr[i]+"~";}
    	stt=stt.substring(0,stt.length()-1);
    	String []ss=da.split("#");
    	if(st==2) {
        	ss[1]=stt;}
        	else if(st==6) {
        	ss[5]=stt;
        	}
    	stt="";
    	for(int i=0;i<ss.length;i++) {stt+=ss[i]+"#";}
    	stt=stt.substring(0,stt.length()-1);
    	return stt;
    }
    
    public DLinkedList sort(DLinkedList d) {
    	if(st==2||st==6) {
    		for(int i=1;i<=d.size();i++) 
    		{String e= sortEI(d.get(i)+"");
    		D.set(i,e);}
    	}
    	int low=0;int high=D.size()-1;
    	s.push(low+1);int p=0;
    	s.push(high+1);
    	while(!s.isEmpty()) {
    		high=(int) s.pop();
    		low=(int) s.pop();
    			p=part(low,high);
    		if(p-1>low) {
    			s.push(low);
    			s.push(p-1);}
    		if(p+1<high) {
    			s.push(p+1);
    			s.push(high);
    		}
    	}
    	return D;}

    public int parts(int low,int high, String[] tr) {
    	int i=low,j=0;
    	for(j=low;j<high;j++) {
    		if((t[j]).compareTo((t[high]))<0){
    			swapo(i++,j);}
    	}
    	swapo(i,j);
    	return i;}
    
	public void swapo(int i,int j) {
		String temp=t[i];
		t[i]=t[j];t[j]=temp;
	}
    
public String[] sortLQ(String [] t) {

	int low=0;int high=t.length-1;
	s.push(low);int p=0;
	s.push(high);
	while(!s.isEmpty()) {
		high=(int) s.pop();
		low=(int) s.pop();
		p=parts(low,high,t);
		if(p-1>low) {
			s.push(low);
			s.push(p-1);}
		if(p+1<high) {
			s.push(p+1);
			s.push(high);
		}
	}
	return t;
}
}*/

public class QuickSort {
	
	DLinkedList D=new DLinkedList();
	DLinkedList sa=new DLinkedList();
	stack s=new stack();
	private String st;
    boolean n=false;
    Object[] t;
	QuickSort(DLinkedList D,String st){
		//for(int i=1;i<=D.size();i++) D.set(i,(""+D.get(i)).trim());
		this.D=D;
		this.st=st;
	}
	
	public void swap(int i,int j) {
		Object temp=D.get(i);
		D.set(i,D.get(j));D.set(j,temp);
	}
    
    public int part(int low,int high) {
    	int i=low,j=0;
    	for(j=low;j<high;j++) {
    		if((st.compareToIgnoreCase("date")==0)&&
    				((((email)D.get(j)).date).compareTo((((email)D.get(high)).date))>0)
    				) {
    			swap(i++,j);}
    		else if((st.compareToIgnoreCase("sender")==0)&&
    				((((email)D.get(j)).sender).compareTo((((email)D.get(high)).sender))<0)) {
    			swap(i++,j);}
    		else if((st.compareToIgnoreCase("subject")==0)&&
    				((((email)D.get(j)).subject).compareTo((((email)D.get(high)).subject))<0)) {
    			swap(i++,j);}
    		else if((st.compareToIgnoreCase("body")==0)&&
    				((((email)D.get(j)).body).compareTo((((email)D.get(high)).body))<0)) {
    			swap(i++,j);}
    		else if((st.compareToIgnoreCase("attachments")==0)&&
    				((((email)D.get(j)).attachments.get(0)+"").compareTo((((email)D.get(high)).attachments.get(0)+""))<0)) {
    			swap(i++,j);}
    		else if((st.compareToIgnoreCase("receivers")==0)) {
    			Object t=((email)D.get(j)).receivers.dequeue();
    			Object t1=((email)D.get(high)).receivers.dequeue();
    			((email)D.get(j)).receivers.enqueue(t);int tr=((email)D.get(j)).receivers.size();
    			((email)D.get(high)).receivers.enqueue(t1);int tr1=((email)D.get(high)).receivers.size();
    			for(int z=0;z<tr-1;z++) 
    				{Object s=((email)D.get(j)).receivers.dequeue();
    				((email)D.get(j)).receivers.enqueue(s);}
    			for(int z=0;z<tr1-1;z++) 
				{Object s=((email)D.get(high)).receivers.dequeue();
				((email)D.get(high)).receivers.enqueue(s);}
    			if((t+"").compareTo(t1+"")<0) {swap(i++,j);}
    		}
    		
    	}
    	swap(i,j);
    	return i;}


    
    public email sortEIT(email da) {
    	email f=da;
    	Object o[]=new Object[f.attachments.size()];
    	for(int i=0;i<o.length;i++) {o[i]=f.attachments.get(i);}
    	t=o;
    	Object tr[]=sortLQ(t);
    	for(int j=0;j<tr.length;j++) {f.attachments.set(j,tr[j]);}
    	return f;
    }

    public Object[] sortLQ(Object [] OP) {

    	int low=0;int high=t.length-1;
    	s.push(low);int p=0;
    	s.push(high);
    	while(!s.isEmpty()) {
    		high=(int) s.pop();
    		low=(int) s.pop();
    		p=parts(low,high,t);
    		if(p-1>low) {
    			s.push(low);
    			s.push(p-1);}
    		if(p+1<high) {
    			s.push(p+1);
    			s.push(high);
    		}
    	}
	
    	return t;
    	}
    
    public int parts(int low,int high, Object[] tr) {
    	int i=low,j=0;
    	for(j=low;j<high;j++) {
    		if((t[j]+"").compareTo((t[high]+""))<0){
    			swapo(i++,j);}
    	}
    	swapo(i,j);
    	return i;}
    
    public void swapo(int i,int j) {
		Object temp=t[i];
		t[i]=t[j];t[j]=temp;
	}
    
    public DLinkedList sort(DLinkedList d) {
    	if(st.compareToIgnoreCase("attachments")==0) {
    		for(int i=1;i<=d.size();i++) 
    		{email e= sortEIT((email) d.get(i));
    		D.set(i,e);}
    	}
    	int low=0;int high=D.size()-1;
    	s.push(low+1);int p=0;
    	s.push(high+1);
    	while(!s.isEmpty()) {
    		high=(int) s.pop();
    		low=(int) s.pop();

    		p=part(low,high);
            
    		if(p-1>low) {
    			s.push(low);
    			s.push(p-1);}
    		if(p+1<high) {
    			s.push(p+1);
    			s.push(high);
    		}
    	}
			return D;
    	}
    
    public DLinkedList sortByPriority(DLinkedList list) {
		PriorityQueue pq=new PriorityQueue();
		for(int i=1;i<=list.size();i++) 
		pq.insert(list.get(i),((email)list.get(i)).priority);	
		for(int i=1;i<=list.size();i++) list.set(i,pq.removeMin());
	    return list;
	}
    


     }