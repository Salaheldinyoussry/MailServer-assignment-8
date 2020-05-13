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

import dataStructure.singleLinkedList;



public class Folder implements IFolder{
public String des;

public boolean createDir(String name,Contact cn) {
	boolean f=false;
	f= (new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+cn.email+"\\"+name)).mkdir();
	
    try (
    		Writer writer = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+cn.email+name+"\\index.txt"), "utf-8"))) {
 //  writer.write("something");

    
		 writer.close();

    }
    
    
    catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
	
	
	if(f) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		 String st = null; String []l = null;String[] user=null;
		 try {
				while ((st = br.readLine()) != null) { 
					user =st.split("#");  
					for(int i=0; i<user.length; i++) {
						System.out.println(user[i]);
					}
				   if(user[1].compareTo(cn.email)==0) {
					   if(user[2].compareTo(cn.password)==0) {
						   l=user[3].split("~");
						   break;
					   }
				   }
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		App a=new App();
		 try {
			a.deleteLineFromFile(st,"C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	 for(int i=0;i<l.length;i++) {st+=l[i];st+="~";}
		 st+="~"+name;
		// st=user[0]+"#"+user[1]+"#"+user[2]+"#"+user[3];
		 a.writeLineToFile(st,"C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt");
	}
	return f;
}

public static boolean renameDir(Contact cn,String Oldname,String newName) {
	boolean f=false;
	String path="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+cn.email;
	f= (new File(path+"\\"+Oldname)).renameTo(new File(path+"\\"+newName));
	if(f) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		 String st = null; String []l = null;String[] user=null;
		 try {
				while ((st = br.readLine()) != null) { 
					user =st.split("#");  
				   if(user[1].compareTo(cn.email)==0) {
					   if(user[2].compareTo(cn.password)==0) {
						   l=user[3].split("~");
						   break;
					   }
				   }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		App a=new App();
		 try {
			a.deleteLineFromFile(st,"C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<l.length;i++) {if(l[i].compareTo(Oldname)==0) {l[i]=newName;}}
		// user[3]=st.substring(0,st.length()-1);
		 st=user[0]+"#"+user[1]+"#"+user[2]+"#";
		 st+=l[0];
		 for(int i=1;i<l.length;i++) {st+="~"; st+=l[i];}

		 a.writeLineToFile(st,"C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt");
	}
	return f;
}

public static boolean deleteFile(String name ,Contact cn) {
	boolean f=false;
	File dir =new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+cn.email+"\\"+name);
	f=deleteDir(dir);
	if(f) {
		  BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(new File("C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt")));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			 String st = null; String []l = null;String[] user=null;
			 try {
					while ((st = br.readLine()) != null) { 
						user =st.split("#");  
					   if(user[1].compareTo(cn.email)==0) {
						   if(user[2].compareTo(cn.password)==0) {
							   l=user[3].split("~");
							   break;
						   }
					   }
					}			 br.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			App a=new App();
			 try {
				a.deleteLineFromFile(st,"C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/* String []s=new String[l.length-1];int t=0;st="";
			 for(int i=0;i<l.length;i++) {if(l[i].compareTo(dir.getName())!=0) {s[t++]=l[i];}}
			 for(int i=0;i<s.length;i++) {st+=s[i];st+="~";}
			 user[3]=st.substring(0,st.length()-1);
		*/	 
			 st=user[0]+"#"+user[1]+"#"+user[2]+"#";
			 for(int i=0 ; i<l.length;i++) {
				  if(l[i].compareTo(name)!=0) {
				 st+=l[i];
				 if(i!=l.length-1) {
					 st+="~";
				 }}
			 }
			
			a.writeLineToFile(st,"C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\users.txt");
			
	}
	return f;
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

}

