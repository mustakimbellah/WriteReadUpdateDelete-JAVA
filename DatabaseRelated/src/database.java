import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class database {


	 public static void data_write()
	    {
	        try
	        {
	           File f  = new File("F:\\mustakim.txt"); 
	           if(f.createNewFile())
	           {
	               System.out.println("File created Successfully...");
	           }
	           else
	           {
	               System.out.println("File Did not able to create...");
	           }
	        }
	        catch(IOException ex)
	        {
	            System.out.println("Something went wrong to create the file: ");
	            ex.printStackTrace();
	        }
	        
	        try{
	            File f  = new File("F:\\mustakim.txt");
	            FileWriter fw = new FileWriter(f,true);
	            BufferedWriter bw = new BufferedWriter(fw);
	            PrintWriter pw = new PrintWriter(bw);
	            
	            String input;
	            
	            Scanner s = new Scanner(System.in);
	            
	            System.out.println("Enter Book Name: ");
	            input = s.nextLine();
	            pw.println(input);
	            
	            System.out.println("Enter Author Name: ");
	            input = s.nextLine();
	            pw.println(input);
	            
	            System.out.println("Enter price: ");
	            input = s.nextLine();
	            pw.println(input);
	            
	            System.out.println("Enter No. of copies: ");
	            input = s.nextLine();
	            pw.println(input);
	            
	            pw.close();
	            bw.close();
	            fw.close();   
	            
	        }
	        catch(IOException ex)
	        {
	            ex.printStackTrace();
	        }
	        
	        
	    }
	    
	    
	    public static void data_read()
	    {
	        String n, a;
	        double p;
	        int c;
	        
	        try
	        {
	            File f  = new File("F:\\mustakim.txt");
	            Scanner s = new Scanner(f); 
	            
	            
	            while(s.hasNextLine())
	            {
	                n = s.nextLine();
	                a = s.nextLine();
	                p = Double.parseDouble(s.nextLine()) ;
	                c = Integer.parseInt(s.nextLine()) ;
	                
	                
	                System.out.println("Book Name: "+n+" Author name: "+a+" Price: "+p+" Copy: "+c+"\n" );
	            }
	            
	            s.close();
	            
	            
	        }
	        catch(IOException ex)
	        {
	            ex.printStackTrace();
	        }
	    }
	    
	    public static void data_update()
	    {
	        String n,a,p,c,input_name,new_price;
	        int add_copy;
	        
	        
	        
	        
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.println("Enter Book name, new price and number of copies to add: ");
	        input_name = sc.nextLine();
	        new_price = sc.nextLine();
	        add_copy = sc.nextInt();
	        
	        try
	        {
	            File f  = new File("F:\\mustakim.txt");
	            Scanner s = new Scanner(f); 
	            
	            StringBuffer sb = new StringBuffer();
	            while(s.hasNextLine())
	            {
	                n = s.nextLine();
	                a = s.nextLine();
	                p = s.nextLine();
	                c = s.nextLine() ;
	                
	                if(input_name.equalsIgnoreCase(n))
	                {
	                    p = new_price;
	                    int total_copy = add_copy + Integer.valueOf(c);
	                    c = String.valueOf(total_copy);  
	                }
	                
	                sb.append(n+"\n");
	                sb.append(a+"\n");
	                sb.append(p+"\n");
	                sb.append(c+"\n");
	            }
	            
	            String all_book_details = sb.toString();
	            s.close();
	            
	            
	            FileWriter fw = new FileWriter("F:\\mustakim.txt");
	            
	            fw.append(all_book_details);
	            
	            fw.close();
	        }
	        catch(IOException ex)
	        {
	            ex.printStackTrace();
	        }
	        
	        
	    }
	    
	    public static void data_delete()
	    {
	        String n,a,p,c,input_name,new_price;
	        
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.println("Enter Book name for delete: ");
	        input_name = sc.nextLine();
	      
	        try
	        {
	            File f  = new File("F:\\mustakim.txt");
	            Scanner s = new Scanner(f); 
	            
	            StringBuffer sb = new StringBuffer();
	            while(s.hasNextLine())
	            {
	                n = s.nextLine();
	                a = s.nextLine();
	                p = s.nextLine();
	                c = s.nextLine() ;
	                
	                if(input_name.equalsIgnoreCase(n))
	                {
	                   continue;
	                }
	                
	                sb.append(n+"\n");
	                sb.append(a+"\n");
	                sb.append(p+"\n");
	                sb.append(c+"\n");
	            }
	            
	            String all_book_details = sb.toString();
	            s.close();
	            
	            
	            FileWriter fw = new FileWriter("F:\\mustakim.txt");
	            
	            fw.append(all_book_details);
	            
	            fw.close();
	        }
	        catch(IOException ex)
	        {
	            ex.printStackTrace();
	        }
	          
	    }
	
	    public static void main(String[] args) {
	        
	        data_write();
	        data_read(); 
	        data_update();
	        data_delete();
	    }
	
	
}
