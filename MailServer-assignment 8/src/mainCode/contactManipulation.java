package mainCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dataStructure.singleLinkedList;

public class contactManipulation {
	public singleLinkedList userContacts =new singleLinkedList();

	public void addContact(Contact c,String email) {
		String x=c.name+"#";
		x+=c.emails.get(0);
		for(int i=1; i<c.emails.size(); i++) {
			x+="~";
			x+=c.emails.get(i);
		
		}
		App a=new App();
		a.writeLineToFile(x, "C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+email+"\\contacts.txt");
		
	}
	public void deleteContact(Contact c,String email) throws IOException {
		String x=c.name+"#";
		x+=c.emails.get(0);
		for(int i=1; i<c.emails.size(); i++) {
			x+="~";
			x+=c.emails.get(i);
		
		}
		App a=new App();
		a.deleteLineFromFile(x, "C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+email+"\\contacts.txt");
		
	}

	public void loadContacts(String email) {
		 File file = new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+email+"\\contacts.txt");   
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
			  Contact c =new Contact();
				String[] cc =st.split("#");
			  String[] tmp =cc[1].split("~");
			  for(int i =0; i<tmp.length; i++ ) {
				  c.emails.add(tmp[i]);
			  }
			  c.name=cc[0];
			  userContacts.add(c);
			 }
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void contactEdit(Contact old,Contact newc ,String email ) throws IOException {
		deleteContact(old,email);
		addContact(newc,email);
	}

}
