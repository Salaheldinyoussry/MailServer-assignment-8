package mainCode;
import dataStructure.LQueue;
import dataStructure.singleLinkedList;

public class email implements IMail{
	public String sender;
	public singleLinkedList attachments ;
	public singleLinkedList attachmentsPath ;
	public String body;
	
	public String receiver;
	public String date;
	public int priority;
	
	public LQueue receivers;
	public String dir;
	public String subject;
	public Boolean sent=false;
	public Boolean inbox=false;
	public Boolean trash=false;
	public Boolean drafts=false;
	public String folder;
//public	String userFolder;

	//public email() {sender=null;}
	
/*
	public boolean found() {
		int i=0;
		boolean flag=true;
		Object k=null;
		Contact cont;
		Object []arr=new Object[receivers.size()];
		while(!receivers.isEmpty()) {
			k=receivers.dequeue();
			arr[i++]=k;String d=""+k;
			cont=new Contact(d,null);
			if(!cont.found()) {flag=false;}
		}
		for(int j=0;j<i;j++) {receivers.enqueue(arr[j]);}
		return flag;
	}*/
}
