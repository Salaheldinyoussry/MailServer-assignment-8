package sortAndSearch;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dataStructure.DLinkedList;
import dataStructure.stack;
import mainCode.email;

public class BinarySearch {

	public DLinkedList searchPR(DLinkedList l, int o ) {
		DLinkedList ret =new DLinkedList();
		stack s=new stack();
		Point p =new Point(1,l.size());
		s.push(p);
		while(!s.isEmpty()) {
		 Point tmp =(Point) s.pop();
		 int left=tmp.x;
		 int right=tmp.y;
		 int mid=(right+left)/2;
		email e= (email) l.get(mid);
		 if(e.priority==o) {
			 ret.add(l.get(mid));
		int j=mid+1;
		while(j<=l.size() && e.priority==o) {
			 ret.add(l.get(j));
		j++;
		}
		j=mid-1;
		while(j>0 && e.priority==o) {
			 ret.add(l.get(j));
		j--;
		}
			 
		 }
		 else if(e.priority<o && mid+1<=right) {
			 Point p2 =new Point(mid+1,right);

			 s.push(p2);
			 
		 }
		 else if(e.priority>o && mid-1>=left) {
			 Point p3 =new Point(left,mid-1);

			 s.push(p3);
			 
		 }
		}
		return ret;
		
	}
	public DLinkedList search(DLinkedList l, String  o, String x ) {
		DLinkedList ret =new DLinkedList();
		stack s=new stack();
		Point p =new Point(1,l.size());
		s.push(p);
		while(!s.isEmpty()) {
		 Point tmp =(Point) s.pop();
		 int left=tmp.x;
		 int right=tmp.y;
		 int mid=(right+left)/2;
		email e= (email) l.get(mid);
		
		if(x.equalsIgnoreCase("subject")) {
		
		
		if(e.subject.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(mid));
		int j=mid+1;
		while(j<=l.size() && e.subject.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(j));
		j++;
		}
		j=mid-1;
		while(j>0 &&e.subject.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(j));
		j--;
		}
			 
		 }
		 else if(e.subject.compareToIgnoreCase(o)<0 && mid+1<=right) {
			 Point p2 =new Point(mid+1,right);

			 s.push(p2);
			 
		 }
		 else if(e.subject.compareToIgnoreCase(o)<0 && mid-1>=left) {
			 Point p3 =new Point(left,mid-1);

			 s.push(p3);
			 
		 }
		}
		
		
		
		else if(x.equalsIgnoreCase("date")) {
			
			
		if(e.date.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(mid));
		int j=mid+1;
		while(j<=l.size() && e.date.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(j));
		j++;
		}
		j=mid-1;
		while(j>0 &&e.date.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(j));
		j--;
		}
			 
		 }
		 else if(e.date.compareToIgnoreCase(o)<0 && mid+1<=right) {
			 Point p2 =new Point(mid+1,right);

			 s.push(p2);
			 
		 }
		 else if(e.date.compareToIgnoreCase(o)<0 && mid-1>=left) {
			 Point p3 =new Point(left,mid-1);

			 s.push(p3);
			 
		 }
		}
		
		
		
		else if(x.equalsIgnoreCase("receiver")) {
		
		if(e.receiver.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(mid));
		int j=mid+1;
		while(j<=l.size() && e.receiver.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(j));
		j++;
		}
		j=mid-1;
		while(j>0 &&e.receiver.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(j));
		j--;
		}
			 
		 }
		 else if(e.receiver.compareToIgnoreCase(o)<0 && mid+1<=right) {
			 Point p2 =new Point(mid+1,right);

			 s.push(p2);
			 
		 }
		 else if(e.receiver.compareToIgnoreCase(o)<0 && mid-1>=left) {
			 Point p3 =new Point(left,mid-1);

			 s.push(p3);
			 
		 }
		}
		
		
		
		
		else if(x.equalsIgnoreCase("sender")) {
		
		if(e.sender.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(mid));
		int j=mid+1;
		while(j<=l.size() && e.sender.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(j));
		j++;
		}
		j=mid-1;
		while(j>0 &&e.sender.compareToIgnoreCase(o)==0) {
			 ret.add(l.get(j));
		j--;
		}
			 
		 }
		 else if(e.sender.compareToIgnoreCase(o)<0 && mid+1<=right) {
			 Point p2 =new Point(mid+1,right);

			 s.push(p2);
			 
		 }
		 else if(e.sender.compareToIgnoreCase(o)<0 && mid-1>=left) {
			 Point p3 =new Point(left,mid-1);

			 s.push(p3);
			 
		 }
		}
		
		
		
		
		
		}
		return ret;
		
	}

	
	
	public DLinkedList bodySearch(DLinkedList l, String x) {
		DLinkedList d= new DLinkedList();
		for(int i=0; i<l.size(); i++) {
			email e=(email) l.get(i);
			String path=e.dir;
			if(e.inbox) {
				path+="inbox";
			}
			else if(e.drafts) {
				path+="draft";
			}
			else if(e.sent) {
				path+="sent";
			}
			else if(e.trash) {
				path+="trash";
			}
			path+="\\email.txt";
		 File file = new File(path); 
		  
		  BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} 
		  String body="";
		  String tmp; 
		  try {
			while ((tmp = br.readLine()) != null) { 
			   body+=tmp+" ";
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if(body.toLowerCase().contains(x.toLowerCase())) {
			d.add(e);
		}
		}
		return d;
		
	}
	
	
	
	
	
}
