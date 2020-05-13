package mainCode;

	
	import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import dataStructure.singleLinkedList;
	public class Contact implements  IContact {
		public String name;

		public String email;
		public String password;
		public singleLinkedList folders =new singleLinkedList();
		public singleLinkedList emails =new singleLinkedList();
	


	
public Boolean checkEmail(String email) {
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
		     if(user[1].equalsIgnoreCase(email)) {
		    	 return true;
		     }
				   
			   }}
	  catch(Exception e) {
		  
	  }
				   return false;
	}	   
	  }
	
	
	
	
	 

