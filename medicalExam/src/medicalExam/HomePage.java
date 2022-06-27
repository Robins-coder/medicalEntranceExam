package medicalExam;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HomePage {
    
	static LinkedHashMap<String, Login_details> login_details=new LinkedHashMap<>();
	static LinkedHashMap<Integer, Student_details> student_details=new LinkedHashMap<>();
	static LinkedHashMap<Integer, Admin_details> Question_bank=new LinkedHashMap<>();
	String adminname;
	LinkedHashMap<Integer, HomePage> questiondetails;	

	
    public void Question_bank(String adminname,LinkedHashMap questiondetails)
	{
	   this.adminname=adminname;
	   this.questiondetails=questiondetails;
	}
    static LinkedHashMap<Integer, Student_details> student_details_pass=new LinkedHashMap<>();

    static int  leaveLoginPageCount=1;    

	
    private void first_Admin_Added_Automatically() {
	questiondetails =new LinkedHashMap<Integer,HomePage>();
	Login_details login_obj=new Login_details("ram","1234","Admin",questiondetails);
	login_details.put("admin", login_obj);
	HomePage ob=new HomePage();
	ob.home_page();
	}
    
public static void notEligibleExam() 
{  System.out.println();
	System.out.println("\t\t\t<<    Sry your not elgible for this exam   >>");
	HomePage ob=new HomePage();
	ob.home_page();
}
	   public  void home_page() {
		Scanner input=new Scanner(System.in);
		System.out.println();
		System.out.println("<<--------------Home_page--------------->>");
		System.out.println("    ");
		System.out.println("                1. login \n                2. Register "
				+ "\n                3. Exit");
		System.out.println();
		System.out.println("<----------------------------------------->");
		System.out.println("(Choose option......)");
		System.out.print("== > ");
       
		try {
		int homepagechoice=input.nextInt();
        switch (homepagechoice) {
		case 1: {
		    login_Page();//same page 	
			break;
		}
		case 2: {
			register_Page();
			break;
		}
		case 3:
		{  System.out.println("<<----------------log_out-------------------->>");
		    System.exit(0);
		    System.out.println();
	    	   break;
		}
		
		}
        }
		catch (InputMismatchException e) {
			System.out.println("   * * Enter valid input * * ");
            home_page();		
		}
		catch(Exception e) 
		{
		   System.out.println(" ** try again **");	
	       home_page();
		}
        
	}

   	private static void login_Page() {
		Scanner scanner=new Scanner(System.in);
        System.out.println();
        System.out.println("<---------login_page----------->");
        String name="";String password="";
        
        try {
         System.out.print("  User Profile_Name == > ");
         name=scanner.next();
         System.out.println();
         System.out.print("  Password  == > ");
         password=scanner.next();
        
        
        Login_details get_detail=login_details.get(name);
        if(password.equals(get_detail.pass)) 
        {
           
           if(get_detail.typeOfUser.equals("Admin")) 
           {System.out.println();
        	 System.out.println("         * * ADmin LOgin * *");
        	 System.out.println();
        	 Admin_page.admin_Home_Page(name);
           }
           else if(get_detail.typeOfUser.equals("Student")) 
           { System.out.println();
        	 System.out.println("      * * STudent LOgin * *");  
        	  System.out.println();
        	 Student_Page.student_Home_Page(name);//parameter is key 
           }
           
           
        }
        else 
        {
         System.out.println();
         System.out.println("   \t**Incorrect password and name** ");
         System.out.println();
         HomePage homePage=new HomePage();
         homePage.home_page();
        }
       }
       catch (Exception e) {
    	 System.out.println(" Check USerName And Password !!");
   		leaveLoginPageCount++;
   		if(leaveLoginPageCount>=3) 
   		{  
   			HomePage homePage=new HomePage();
   		    leaveLoginPageCount=1;
   			homePage.home_page();
   		}
   		login_Page();    
       }
       
	}
	
	//--------------------------Register_page---------------------------------------->
	private  void register_Page() {
		Scanner scanner=new Scanner(System.in);
        
		System.out.println();
		System.out.println("\t\t\t<<       ***Student Registeration Page***       >> ");
	    System.out.println();
	    String profile_name="";
	    boolean existOrNotUserName=true;
        while(existOrNotUserName)
	    {
	    System.out.print("Enter the Profile_name :: ");
	    profile_name=scanner.next();
        System.out.println();
	    //-----login_details_get---
	    if(login_details.containsKey(profile_name)) 
	    {System.out.println();
	      System.out.println("       <<     ***Already exits***     >>");
	      System.out.println();
	    }
	    else {existOrNotUserName=false;}
	    
	    }
	    boolean passwordvalidated=true;
	    String pass="";
	    while(passwordvalidated) 
	    {
	    System.out.print("Enter password (5 digit ) ::  ");
	     pass=scanner.next();
	    System.out.println();
	    String pass_check=pass+"";
	    if(pass_check.length()==5) 
	    {
	    	break;
	    }
	    else {System.out.println(); System.out.println("      ***pls enter 5 digit password***        ");System.out.println();}
	    }
	    
	    
	    //---------student_details-get----------------------------->
	    System.out.print("Enter your FullName :: ");
	    String name=scanner.next();
	    System.out.println();
	    System.out.print("Enter College Name :: ");
	    String college_name=scanner.next();
	    System.out.println(); 
	    System.out.print("Enter your Age (18-24) :: ");
	    int age=scanner.nextInt();
	    System.out.println();
	    if(age>=18&&18<=24) {}
	    else {
	        System.out.println();
	    	System.out.println("<.....your not eligible canditate this exam .....>");
	    	System.out.println(); 
	    	notEligibleExam();
	         }
	    
	    System.out.print("Enter your 10th mark (300-500):: ");
	    int mark_10th=scanner.nextInt();
	    System.out.println();
	    if(mark_10th<=500 && mark_10th>=300){}
	    else 
	    {
	    System.out.println();
	    	System.out.println("<..sry for that min and max mark is 300 t0 500 eligible...>");	
	    System.out.println();
	    	notEligibleExam();
	    }
	    
	    System.out.print("Enter your 12th mark (800-1200) :: ");
	    int mark_12th=scanner.nextInt();
	    System.out.println();
	    if(mark_12th<=1200 && mark_12th>=800){}
	    else 
	    {
	    System.out.println();
	    	System.out.println("<..sry for that min and max mark is 900 t0 1200 eligible ...>");	
	    System.out.println();
	    	notEligibleExam();
	    
	    } 
	    
	    System.out.println("select your caste");
        System.out.println(" 1. BC 2.OBC 3.SC 4.Others");
	    System.out.print(" == > ");
        int choice=scanner.nextInt();
        System.out.println();
        String caste="";
	    switch(choice)
        {
        case 1:{ caste="BC"; break;}
        case 2:{ caste="OBC"; break;}
        case 3:{ caste="SC"; break;}
        case 4:{ caste="Others"; break;}
        }
	    System.out.print("Enter your Sport_cerficate Count :: ");
        int certificate_count=scanner.nextInt();    
	    System.out.println();
	    questiondetails =new LinkedHashMap<Integer,HomePage>();
	    boolean add_account=student_account_add(profile_name,pass,"Student",questiondetails);
	    
	    if(add_account) 
	    {
           Student_details ob=new Student_details(profile_name,name,college_name,age,mark_10th,mark_12th,caste,certificate_count,100,true);	    	
           int key=(int)(Math.random()*9999+100);//student_details list key auto generated
        //   System.out.println("Check key ..."+key);
           student_details.put(key, ob);
         //  System.out.println("<<...... data uploaded successfully ....>>");
	    }
	    else {System.out.println("<<.....Student Account is not Created.....>>");}
	    home_page();
	}

	private static boolean student_account_add(String profile_name, String pass, String typeOfuser, LinkedHashMap<Integer, HomePage> questiondetails) {
		try {
		Login_details login_details=new Login_details(profile_name,pass,typeOfuser,questiondetails);
		HomePage.login_details.put(profile_name, login_details);
        System.out.println();
		System.out.println("<<....user created successfully....>>");
		System.out.println();
		return true;
		}
		catch (Exception e) {
	     return false;
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		HomePage homePage=new HomePage();
		
		homePage.first_Admin_Added_Automatically();
        
	}
	
}
