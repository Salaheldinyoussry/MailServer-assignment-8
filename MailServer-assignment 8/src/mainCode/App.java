package mainCode;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.xml.transform.Source;

import dataStructure.DLinkedList;
import dataStructure.ILinkedList;
import dataStructure.LQueue;
import dataStructure.singleLinkedList;

public class App implements IApp{
	DLinkedList mail =new DLinkedList();
	public Contact c =new Contact();
	/*
	public void copyEmail(email e,String dir , String des) {
	   File file = new File(des+"\\"+e.subject);
	    file.mkdir();
        String x="\\";
	    
        for(int i=0; i<e.attachments.size(); i++) {

	        var source = new File(dir+x+((String)e.attachments.get(i)));
	        var dest =new File(dir+"\\"+e.subject);

	        try {
				Files.copy(source.toPath(), dest.toPath(),
				        StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }*/
	   /* 
	    var source = new File(dir+"\\email.txt");
        var dest =new File(des+x+e.subject);

        try {
			Files.copy(source.toPath(), dest.toPath(),
			        StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	*/
	
	
	public void deleteLineFromFile(String x,String path) throws IOException {
		 File file = new File(path);   
		  BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		   String st; 
		  singleLinkedList l =new singleLinkedList();
		  try {
			while ((st = br.readLine()) != null) { 
			 if(!st.equalsIgnoreCase(x)) {
				 l.add(st);
				 //int j=0;
				// System.out.println(l.get(j));
			//  j++;
			 }
			}	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		   BufferedWriter writer = null;
		  
		
		    try {
				writer = new BufferedWriter(
                        new FileWriter(path, false) 
                    );
		    	writer.write((String)l.get(0));
                for(int i=1; i<l.size(); i++ ) {
    		    	writer.newLine();
                	writer.write((String)l.get(i));
		    	}
		    	writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 br.close();
	 writer.close();
	}
	



    public void writeLineToFile(String x,String path) {

    	int flag=0;
    	 File file = new File(path); 
		  
		  BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  
		  String st; 
		  try {
			while ((st = br.readLine()) != null) { 
			flag=1;
			}
			 br.close();

		  }catch(Exception e) {
			  
		  }
    	
		   BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(  new FileWriter(path, true)     );
				if(flag==1) {
				writer.newLine();
				}
				writer.write(x);
				writer.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	}
    }
	
	
	@Override
	public boolean signin(String email, String password) {
		 File file = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt"); 
		  
		  BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  
		  String st; 
		  try {
			while ((st = br.readLine()) != null) { 

				String[] user =st.split("#");  
			   if(user[1].compareTo(email)==0) {
				   if(user[2].compareTo(password)==0) {
					 c.name=user[0];
					 c.email=user[1];
					 c.password=user[2];
					 String [] l =user[3].split("~");
					 for(int i=1; i<l.length; i++) {
						 c.folders.add(l[i]);
					 }
					   
					   
					   return true;
				     
				   }
				   else {
					   return false;
				   }
			   }
			}
			 br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean signup(IContact contact) {
		 File file = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt"); 
		  
		  BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  Contact c =(Contact) contact;
		  
		  String st; 
		  try {
			while ((st = br.readLine()) != null) { 
			   String[] user =st.split("#");  
			   if(user[0].compareTo(c.name)==0 || user[1].compareTo(c.email)==0) {
				   return false;
				   
				 
			   }
				 br.close();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  this.c=c;  
		  writeLineToFile(c.name+"#"+c.email+"#"+c.password+"#null","C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt");
		    
		    File file5 = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+c.email);
	
			
		    File file2 = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+c.email+"\\inbox");
		    File file3 = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+c.email+"\\sent");
		    File file4 = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+c.email+"\\trash");
		    File file6 = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+c.email+"\\drafts");

		    file5.mkdir();
		
		    file2.mkdir();
		    file3.mkdir();
		    file4.mkdir();
		    file6.mkdir();
		
		////////////////
		    
		    try (
		    		Writer writer = new BufferedWriter(new OutputStreamWriter(
		              new FileOutputStream("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+c.email+"\\inbox\\index.txt"), "utf-8"))) {
		 //  writer.write("something");
		
		    
				 writer.close();

		    }
		    
		    
		    catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		    catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    try (
		    		Writer writer = new BufferedWriter(new OutputStreamWriter(
		              new FileOutputStream("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+c.email+"\\drafts\\index.txt"), "utf-8"))) {
		 //  writer.write("something");
		
				 writer.close();

		    
		    } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try (
		    		Writer writer = new BufferedWriter(new OutputStreamWriter(
		              new FileOutputStream("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+c.email+"\\trash\\index.txt"), "utf-8"))) {
		 //  writer.write("something");
		
				 writer.close();

		    
		    } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try (
		    		Writer writer = new BufferedWriter(new OutputStreamWriter(
		              new FileOutputStream("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+c.email+"\\sent\\index.txt"), "utf-8"))) {
		 //  writer.write("something");
		
				 writer.close();

		    }
		    ///////////
 catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try (
		    		Writer writer = new BufferedWriter(new OutputStreamWriter(
		              new FileOutputStream("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+c.email+"\\contacts.txt"), "utf-8"))) {
		 //  writer.write("something");
		
				 writer.close();

		    
		    } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
	}

	@Override
	public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {
		Folder des=(Folder) folder; 
		DLinkedList l =new DLinkedList();
          
		///sender#receiver#subject#date#priority#attachment
		////0///////1////////2//////3//////4////////5////
		File file = new File(des.des+"\\index.txt"); 
		  BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  
		  String st; 
		  try {
			while ((st = br.readLine()) != null) { 
			  email e =new email();
				String[] s =st.split("#");  
			   
				e.sender=s[0];
				//e.receiver=s[1];
				e.subject=s[2];
				e.date=s[3];
				e.priority=Integer.parseInt(s[4]);
				e.dir=des.des+"\\";
				String str=s[6];
				if(str.equalsIgnoreCase("sent")) {
					e.sent=true;
				}
				else if(str.equalsIgnoreCase("drafts")) {
					e.drafts=true;
				}
				else if(str.equalsIgnoreCase("trash")) {
					e.trash=true;
				}
				else if(str.equalsIgnoreCase("inbox")) {
					e.inbox=true;
				}
				
				singleLinkedList at =new singleLinkedList();
				String[] x =s[5].split("~");
				for(int i=0; i<x.length;i++) {
					at.add(x[i]);
				}
                e.attachments=at;
                //System.out.println(e.date);
	
			LQueue q =new LQueue();
			
			String[] y =s[1].split("~");
			for(int i=0; i<y.length;i++) {
				q.enqueue(y[i]);
			}
			e.receivers=q;
                ///////////////////
		
			File file2 = new File(des.des+"\\"+e.subject+e.date+"\\email.txt"); 
			  BufferedReader br1 = null;
				try {
					br1 = new BufferedReader(new FileReader(file2));
					String stt;
					e.body="";
					while ((stt = br1.readLine()) != null) {
						e.body+=stt;
						e.body+="\n";
						
					}
				 br1.close();
				
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				
                              
            ///////////////////////////////    
                mail.add(e);
            
			
			
			}
			  Sort ss=(Sort) sort;
	    
			  if(filter!=null) {
	            Filter f=(Filter) filter;
          	  BinarySearch b=new BinarySearch();

	        	if(f.choice.equalsIgnoreCase("priority")) {
		        	QuickSort qq =new QuickSort(mail,f.choice); 	
	            	  mail=qq.sortByPriority(mail);
	            	  mail=b.searchPR(mail, f.prio);
	            	}
	            
	            else if(f.choice.equalsIgnoreCase("body")){
	            	mail=b.bodySearch(mail, f.st);
	            }
	            else if(f.choice.equalsIgnoreCase("receiver")) {
	            	mail=b.searchRec(mail, f.st);
	            	
	            }
	            else {
		        	QuickSort qq1 =new QuickSort(mail,f.choice); 	

	            	mail=qq1.sort(mail);
	            	System.out.println(f.st);
	            	mail=b.search(mail, f.st, f.choice);
	            	
	            }
	            
	            
	            }
	            if(sort!=null) {
	            	
	            	if(ss.choice.equalsIgnoreCase("priority")) {
			        	QuickSort qq =new QuickSort(mail,ss.choice); 	

	            		mail=qq.sortByPriority(mail);
	            		
	            	}
	            	else {
			        	QuickSort qq =new QuickSort(mail,ss.choice); 	
                         mail=qq.sort(mail);
	            	}
	            }
			
			
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Sort s=(Sort) sort;
	//	  QuickSort q =new QuickSort(mail,s.choice); 
		  
		//  mail=q.sort(mail);
		//  mail=l;
		  
		  
	//	if(sort!=null) {
			/*
			Sort sortt =(Sort) sort;
			if(sortt.attatchment) {
				
			}
			else if (sortt.date) {
				
			}
		
	else if (sortt.) {
				
			}
	else if (sortt.receiever) {
		
	}
	else if (sortt.sender) {
		
	}
	else if (sortt.subject) {
		
	}
*/
		
		
//		}
		
		/*
		if(filter!=null) {
			
			DLinkedList d =new DLinkedList();
            BinarySearch b =new BinarySearch();
			Filter filt =(Filter) filter;
			
		
			if(filt.attatchment) {
			 	
			}
			else if(filt.body) {
			}
			
	       else if(filt.priority) {
			b.searchPR(l, filt.prio);	

			}
	   	else if(filt.sender) {
			  b.search(l, filt.st, "sender");	
			
		}
			
		else if(filt.receiever) {
			  b.search(l, filt.st, "receiver");	
	
		}
			
			
		else if(filt.subject) {
			  b.search(l, filt.st, "subject");	
			
		}
			
		else if(filt.date) {
			  b.search(l, filt.st, "date");	
		
		}
			
		this.mail=d;
		
		}
		
		
		else {	
	this.mail=l;	
		}*/
	}

	@Override
	public IMail[] listEmails(int page) {
      email [] pageMail =new email[10];
		int j=0;
      for(int i= (page-1)*10+1;  i<=(page-1)*10+10; i++) {
    	pageMail[j]=(email) this.mail.get(i);
        j++;
      }
     
		
		
		return pageMail;
	}

	@Override
	public void deleteEmails(ILinkedList mails) {
	 	Folder f=new Folder();
		singleLinkedList l =(singleLinkedList) mails;
	 	f.des=((email)l.get(0)).dir+"trash";
		moveEmails(l,f);
	// System.out.println(f.des);
	// System.out.println(((email)l.get(0)).dir);
	 
	}

	@Override
	public void moveEmails(ILinkedList mails, IFolder des) {
		singleLinkedList l =(singleLinkedList) mails;
		Folder f=(Folder) des;
		
		    
		for(int i=0; i<l.size(); i++) {
		email e =(email) l.get(i);
	//	System.out.println(e.folder);
		///sender#receiver#subject#date#priority#attachment#sent
     String del ="";
     del+=e.sender+"#";
		
     LQueue q =new LQueue(); 
     LQueue q1 =new LQueue(); 

     for(int j=0; j<e.receivers.size(); j++) {
     	q.enqueue(e.receivers.dequeue());
     }
     for(int j=0; j<q.size(); j++) {
      Object o =q.dequeue();
     	q1.enqueue(o);
         e.receivers.enqueue(o);
     }

     del+=(String)q1.dequeue();

     for(int r=1; r<q1.size(); r++) {
     	del+="~";
     	del+=(String)q1.dequeue();
     	
     }
		del+="#"+e.subject+"#"+e.date+"#"+e.priority+"#";
		
		del+=e.attachments.get(0);
		for(int r=1; r<e.receivers.size(); r++) {
			del+="~";
			del+=(String)e.attachments.get(r);
			
		}
		
		try {
		if(e.inbox)  { deleteLineFromFile(del+"#inbox",e.dir+"inbox\\index.txt"); }
		else if(e.sent)  { deleteLineFromFile(del+"#sent",e.dir+"sent\\index.txt"); }
		else if(e.trash)  { deleteLineFromFile(del+"#trash",e.dir+"trash\\index.txt"); }
		else if(e.drafts) { deleteLineFromFile(del+"#drafts",e.dir+"drafts\\index.txt"); }
		else {deleteLineFromFile(del+"#"+e.folder,e.dir+e.folder+"\\index.txt"); }
		}
catch(Exception e4) {
	
}
//////		
		
		
		File file2 = new File(f.des+"\\"+e.subject+e.date);
		    file2.mkdir();
		
		   if(e.attachments!=null) {
		    for(int j=0; j<e.attachments.size(); j++) {
			
			 File file = null;
		if(e.inbox) { file = new File(e.dir+"inbox\\"+e.subject+e.date+"\\"+((String)e.attachments.get(j))); }
		else if(e.sent) { file = new File(e.dir+"sent\\"+e.subject+e.date+"\\"+((String)e.attachments.get(j))); }
		else if(e.trash) { file = new File(e.dir+"trash\\"+e.subject+e.date+"\\"+((String)e.attachments.get(j))); }
		else if(e.drafts) { file = new File(e.dir+"drafts\\"+e.subject+e.date+"\\"+((String)e.attachments.get(j))); }
		else {file = new File(e.dir+e.folder+"\\"+e.subject+e.date+"\\"+((String)e.attachments.get(j))); }
		
		// renaming the file and moving it to a new location 
		if(file.renameTo 
		   (new File(f.des+"\\"+e.subject+e.date+"\\"+((String)e.attachments.get(j))))) 
		{ 

		    // if file copied successfully then delete the original file 
		   // file.delete(); 
		}
		}}

		File file3 = null;
			if(e.inbox) {  file3 = new File(e.dir+"inbox\\"+e.subject+e.date+"\\email.txt"); }
			else if(e.sent) {  file3 = new File(e.dir+"sent\\"+e.subject+e.date+"\\email.txt"); }
			else if(e.trash) {  file3 = new File(e.dir+"trash\\"+e.subject+e.date+"\\email.txt"); }
			else if(e.drafts) {  file3 = new File(e.dir+"drafts\\"+e.subject+e.date+"\\email.txt"); }
			else {  file3 = new File(e.dir+e.folder+"\\"+e.subject+e.date+"\\email.txt"); }
			// renaming the file and moving it to a new location 
			if(file3.renameTo 
			   (new File(f.des+"\\"+e.subject+e.date+"\\email.txt"))) 
			{ 
			    // if file copied successfully then delete the original file 
			  //  file3.delete(); 
			}
			File f1 = null;
			if(e.inbox) { 
				
				deleteDir(new File(e.dir+"inbox\\"+e.subject+e.date));
				// f1 = new File(e.dir+"inbox\\"+e.subject);
			}
			else if(e.sent) {	
				deleteDir(new File(e.dir+"sent\\"+e.subject+e.date));
				// f1 = new File(e.dir+"inbox\\"+e.subject); 
			}
			else if(e.trash) {  	
				deleteDir(new File(e.dir+"trash\\"+e.subject+e.date));
				// f1 = new File(e.dir+"inbox\\"+e.subject)
			}
			else if(e.drafts) {  	
				deleteDir(new File(e.dir+"drafts\\"+e.subject+e.date));
				// f1 = new File(e.dir+"inbox\\"+e.subject)
			}
			else {
				deleteDir(new File(e.dir+e.folder+"\\"+e.subject+e.date));
				
			}
		
			try {
				if((e.dir+"inbox").equalsIgnoreCase(f.des))  { writeLineToFile(del+"#inbox",e.dir+"inbox\\index.txt"); }
				else if((e.dir+"sent").equalsIgnoreCase(f.des))   { writeLineToFile(del+"#sent",e.dir+"sent\\index.txt"); }
				else if((e.dir+"trash").equalsIgnoreCase(f.des))  { writeLineToFile(del+"#trash",e.dir+"trash\\index.txt"); }
				else if((e.dir+"drafts").equalsIgnoreCase(f.des))  { writeLineToFile(del+"#drafts",e.dir+"drafts\\index.txt"); }
				else {writeLineToFile(del+"#"+e.folder,f.des+"\\index.txt"); }

			}
		catch(Exception e4) {
			

			
		}}
		 
		 
		 
		 
		}
		
	
	public static boolean deleteDir(File dir) {
	      if (dir.isDirectory()) {
	         String[] children = dir.list();
	         for (int i = 0; i < children.length; i++) {
	            boolean success = deleteDir (new File(dir, children[i]));
	            
	           
	            if (!success) {
	               return false;
	            }
	         }
	      }
	      return dir.delete();}
	
		/*
		for(int i=0; i<l.size(); i++) {
		if(((email)l.get(i)).inbox)	{copyEmail((email)l.get(i) ,((email)l.get(i)).dir+"inbox\\"+((email)l.get(i)).subject , f.des);
		}
		else if(((email)l.get(i)).trash)	{copyEmail((email)l.get(i) ,((email)l.get(i)).dir+"trash\\"+((email)l.get(i)).subject , f.des);
		}
		else if(((email)l.get(i)).sent)	{copyEmail((email)l.get(i) ,((email)l.get(i)).dir+"sent\\"+((email)l.get(i)).subject , f.des);
		}
		
		
		}
		
		/*
		for(int i=0; i<l.size(); i++) {
			
			for(int j=0; j< ((email)l.get(i)).attachments.size(); j++) {
				String x = (String) ((email)l.get(i)).attachments.get(j);
				
				if(((email)l.get(i)).inbox) {
				File file = new File(((email)l.get(i)).dir+"inbox\\"+((email)l.get(i)).subject+"\\"+x);	
				file.delete();	
				}
				else if(((email)l.get(i)).sent) {
					File file = new File(((email)l.get(i)).dir+"sent\\"+((email)l.get(i)).subject+"\\"+x);	
					file.delete();	
					}
				else if(((email)l.get(i)).inbox) {
					File file = new File(((email)l.get(i)).dir+"trash\\"+((email)l.get(i)).subject+"\\"+x);	
					file.delete();	
					}
			}
			

			File file2 = new File(((email)l.get(i)).dir+((email)l.get(i)).subject+"\\email.txt");	
			file2.delete();	
			
			if(((email)l.get(i)).inbox) {
				File file = new File(((email)l.get(i)).dir+((email)l.get(i)).subject);	
				file.delete();	
				}
			else if(((email)l.get(i)).sent) {
					File file = new File(((email)l.get(i)).dir+((email)l.get(i)).subject);	
					file.delete();	}
			   else if(((email)l.get(i)).trash) {
					File file = new File(((email)l.get(i)).dir+((email)l.get(i)).subject);	
					file.delete();	
					}
			
		
		
		*/
		
		
		 
		
	

	@Override
	public boolean compose(IMail email) {

	///	
		email e =(email) email;

		LQueue q2 =new LQueue(); 
		LQueue q3 =new LQueue(); 

		for(int j=0; j<e.receivers.size(); j++) {
			q2.enqueue(e.receivers.dequeue());
		}
		for(int j=0; j<q2.size(); j++) {
		 Object o =q2.dequeue();
			q3.enqueue(o);
		    e.receivers.enqueue(o);
		}
		for(int i=0; i<q3.size(); i++) {
			Contact cnc =new Contact();
			if(!cnc.checkEmail((String)q3.dequeue())){
			  return false;	
			}
		}
		

		///
		

File file = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+e.sender+"\\sent\\"+e.subject+e.date);
file.mkdir();

String x="";
String y="";
///sender#receiver#subject#date#priority#attachment#sent
////0///////1////////2//////3//////4////////5////
x+=e.sender+"#";
LQueue q =new LQueue(); 
LQueue q1 =new LQueue(); 

for(int j=0; j<e.receivers.size(); j++) {
	q.enqueue(e.receivers.dequeue());
}
for(int j=0; j<q.size(); j++) {
 Object o =q.dequeue();
	q1.enqueue(o);
    e.receivers.enqueue(o);
}

y+=(String)q1.dequeue();

for(int i=1; i<q1.size(); i++) {
	y+="~";
	y+=(String)q1.dequeue();
	
}
e.subject = e.subject.replaceAll("\\s+", "");
e.subject = e.subject.replaceAll("\\n", "");
x+=y+"#"+e.subject+"#"+e.date+"#"+e.priority+"#";

x+=e.attachments.get(0);
for(int i=1; i<e.attachments.size(); i++) {
	
	x+="~";
	x+=(String)e.attachments.get(i);
	
}
x+="#"+"sent";
writeLineToFile(x, "C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+e.sender+"\\sent\\index.txt");

for(int i=0 ;i<e.attachmentsPath.size(); i++) {
//	file = new File((String)e.attachmentsPath.get(i)); 
//if(file.renameTo 
	//	   (new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+e.sender+"\\sent\\"+e.subject+e.date+"\\"+(String)e.attachments.get(i)) ))
		//{ 
		//}
var source = new File((String) e.attachmentsPath.get(i));
var dest = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+e.sender+"\\sent\\"+e.subject+e.date+"\\"+(String)e.attachments.get(i));

try {
	Files.copy(source.toPath(), dest.toPath(),
	        StandardCopyOption.REPLACE_EXISTING);
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
}

try (
		Writer writer = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+e.sender+"\\sent"+"\\"+e.subject+e.date+"\\email.txt")))) {
	writer.close();

} catch (UnsupportedEncodingException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (FileNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
writeLineToFile(e.body,"C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+e.sender+"\\sent\\"+e.subject+e.date+"\\email.txt");




for(int h=0 ; h<e.receivers.size(); h++) {
	///sender#receiver#subject#date#priority#attachment#dir#sent
////0///////1////////2//////3//////4////////5////		
	String re =(String) e.receivers.dequeue();
    re = re.replaceAll("\\s+", "");
    re = re.replaceAll("\\n", "");

    File file3 = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+re+"\\inbox\\"+e.subject+e.date);
    file3.mkdir();

			String st=e.sender+"#"+re+"#"+e.subject+"#"+e.date+"#"+e.priority+"#";
			
			st+=e.attachments.get(0);
			for(int i=1; i<e.receivers.size(); i++) {
				st+="~";
				st+=(String)e.attachments.get(i);
				
			}
			st+="#inbox";
			//System.out.println(re+"g");
			writeLineToFile(st, "C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+re+"\\inbox\\index.txt");
		//	writeLineToFile(st, "C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\ahmed@g.com\\inbox\\index.txt" );
			
			
			for(int i=0 ;i<e.attachmentsPath.size(); i++) {
			//	file = new File((String)e.attachmentsPath.get(i)); 
				//if(file.renameTo 
					//	   (new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+re+"\\inbox\\"+e.subject+e.date+"\\"+(String)e.attachments.get(i)) ))
						//{ 
						//}
				 var source = new File((String) e.attachmentsPath.get(i));
			        var dest = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+re+"\\inbox\\"+e.subject+e.date+"\\"+(String)e.attachments.get(i));

			        try {
						Files.copy(source.toPath(), dest.toPath(),
						        StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				try (
						Writer writer = new BufferedWriter(new OutputStreamWriter(
				          new FileOutputStream("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+re+"\\"+"inbox\\"+e.subject+e.date+"\\email.txt")))) {
					writer.close();

				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				writeLineToFile(e.body,"C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+re+"\\inbox\\"+e.subject+e.date+"\\email.txt");
			
		}
		
		
		
		
		return true;
	

	

	}
	public boolean makeDraft(email e) {
		

File file = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+e.sender+"\\drafts\\"+e.subject+e.date);
file.mkdir();

String x="";
String y="";
///sender#receiver#subject#date#priority#attachment#dir#sent
////0///////1////////2//////3//////4////////5////
x+=e.sender+"#";
LQueue q =new LQueue(); 
LQueue q1 =new LQueue(); 

for(int j=0; j<e.receivers.size(); j++) {
	q.enqueue(e.receivers.dequeue());
}
for(int j=0; j<q.size(); j++) {
 Object o =q.dequeue();
	q1.enqueue(o);
    e.receivers.enqueue(o);
}

y+=q1.dequeue();

for(int i=1; i<q1.size(); i++) {
	y+="~";
	y+=(String)q1.dequeue();
	
}
e.subject = e.subject.replaceAll("\\s+", "");
e.subject = e.subject.replaceAll("\\n", "");
x+=y+"#"+e.subject+"#"+e.date+"#"+e.priority+"#";

x+=e.attachments.get(0);
for(int i=1; i<e.receivers.size(); i++) {
	x+="~";
	x+=(String)e.attachments.get(i);
	
}
x+="#"+"drafts";
writeLineToFile(x, "C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+e.sender+"\\drafts\\index.txt");

for(int i=0 ;i<e.attachmentsPath.size(); i++) {

var source = new File((String) e.attachmentsPath.get(i));
var dest = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+e.sender+"\\drafts\\"+e.subject+e.date+"\\"+e.attachments.get(i));

try {
	Files.copy(source.toPath(), dest.toPath(),
	        StandardCopyOption.REPLACE_EXISTING);
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
}
try (
		Writer writer = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+e.sender+"\\drafts\\"+e.subject+e.date+"\\email.txt")))) {
	writer.close();

} catch (UnsupportedEncodingException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (FileNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
writeLineToFile(e.body,"C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+e.sender+"\\drafts\\"+e.subject+e.date+"\\email.txt");
		
		return true;
		
	}

	

}
