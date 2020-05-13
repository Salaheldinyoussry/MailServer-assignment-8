package mainCode;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import dataStructure.DLinkedList;
import dataStructure.singleLinkedList;

public class MMMM {

	
	public class s <Key extends Comparable<Key>>{
		
	}
	

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		// TODO Auto-generat

	
		
		email e =new email();
		email e1 =new email();
		email e2 =new email();
	
		e.subject="play";
		e.date="1";
		e.priority=1;
		e1.subject="play";
		e1.date="2";

		e1.priority=3;

		e2.subject="zan";
		e2.date="3";
		e2.priority=1;

		DLinkedList l =new  DLinkedList();
		l.add(e);
		l.add(e1);
		l.add(e2);
		BinarySearch b =new  BinarySearch();
       QuickSort q=new QuickSort(l,"priority");
       l=q.sortByPriority(l);
       l=b.searchPR(l, 1);
    
		
		
		//	System.out.println(((email)l.get(1)).date);
		//System.out.println(((email)l.get(2)).date);
		
		
		
		
		
	/*	
		email e =new email();
		email e1 =new email();
		email e2 =new email();
	
		e.subject="play";
		e.date="1";
		e.priority=1;
		e1.subject="play";
		e1.date="2";

		e1.priority=1;

		e2.subject="zan";
		e2.date="3";
		e2.priority=3;

		DLinkedList l =new  DLinkedList();
		l.add(e);
		l.add(e1);
		l.add(e2);
	//	System.out.println(((email)l.get(1)).date);
		//System.out.println(((email)l.get(2)).date);
		
		
		BinarySearch b =new  BinarySearch();
		l=b.search(l, "play", "subject");
		
		System.out.println(((email)l.get(1)).subject);
		System.out.println(((email)l.get(2)).subject);
		
		
		
		
	*/	
		
		
		
		
		
		
		
/*		
		email e =new email();
	//	why#10,05,2020 06,30,37#
		e.subject="whyy";
		e.date="10,05,2020 06,30,37";
		e.dir="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\ahmed@g.com\\";
				e.inbox=true;
		singleLinkedList l =new singleLinkedList();
		l.add(e);
		App a =new App();
		a.deleteEmails(l);
		
		
		
		
	*/	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	/*	
		App a=new App();
	Folder f=new Folder();
//	f.des="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\salah@g.com\\sent";
	//a.setViewingOptions(f, null, null);
//	DLinkedList mail=a.mail; 
	DLinkedList m =new DLinkedList();
	email e=new email();
	email e1=new email();
	e.subject="ba";
	e1.subject="aa";
	//e.date="1~2~3";
//	e1.date="1~5~3";
	m.add(e);
	m.add(e1);
	DLinkedList mail1 =new DLinkedList();

//	System.out.println(((email)mail.get(1)).subject);
	//  System.out.println(((email)mail.get(2)).subject);

	QuickSort q =new QuickSort(m,"subject"); 
	  mail1=q.sort(m);

	System.out.println(((email)mail1.get(1)).subject);
	  System.out.println(((email)mail1.get(2)).subject);
*/
	}}
