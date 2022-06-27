package medicalExam;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Admin_page {
	//--------------------------------------------------------------------------
	//static Scanner input=new Scanner(System.in);
	static boolean viewAllStudentOurResult=false;
	//----------------------------------------------------------------------------
      //------------------Admin_home_page---------------------->
	public static void admin_Home_Page(String userName) {
		Scanner input=new Scanner(System.in);
		
		while(true) 
		{
			System.out.println();
			System.out.println("<------------------Admin_Main_page------------------------->");
			System.out.println();
			System.out.println("  \t\t 1.Exam_control \n \t\t 2. Add Admin \n \t\t 3. Add Question  "
					+ "  \n \t\t 4.view Student details \n \t\t 5.view questions \n \t\t 6.Add_question_main_Exam \n \t\t 7.mainExam_Questions \n \t\t 8.exit");
			Admin_page admin_page=new Admin_page();
			String choice =input.next();
		   switch (choice) {
		   case "1":{
			   Exam_control(userName);
			   break;
		   }
		   case "2": {
			      Add_admin();
			      break;
		         }
		   case "3":{
			   
			   admin_page.add_Question(userName);
			   break;
		   }
		   case "4":{
			   admin_page.view_Student_Details(userName);
			   break;
		   }
		   case "5":
		   {   admin_page.view_Questions(userName);
			   break;
		   }
		   case "6":{
			    Add_Question_main_Exam(userName);
			   break;
		   }
		   case "7":{
			   main_exam_question(userName);
			   break;
		   }
	       case "8":{
			   HomePage homePage=new HomePage();
			   homePage.home_page();   
			    break;
		   }
	       default:
			  {
				  System.out.println("Enter valid input (0-7)");;
			  }
			}	
		}
		
	}
	//.........................Exam_Control...........................................
	public static void Exam_control(String userName) {
		Scanner input=new Scanner(System.in);
	   
		
		breakit:while(true) 
		{
			System.out.println("<<-----------------------Exam control------------------------>>");
			   System.out.println();
			   System.out.println(" \t\t 1.Quota_allogated \n\t\t 2.Published result \n\t\t 3.exit");
			   String examControlChoice=input.next();
			   switch (examControlChoice) {
			   case "1": {
				   Quota_Allogated.quota_Allogated(userName);
				  break;
			     }
			   case "2":{
				   published_result(userName);
				   break;
			   }
			   case "3":{
				   break breakit;
			   }
			    default:
				   System.out.println("Enter valid input (1-3)");
			}
			   
		}
		
	   
	}
	
	private static void published_result(String namekey) {
		Scanner input=new Scanner(System.in);
		
		breakit:while(true) 
		{
			System.out.println();
			System.out.println("<<......................Published_Results_Options.....................>>");
			System.out.println();
			System.out.println(" \t\t==>1.publish all results \n\t\t==>2.View Results \n\t\t==>3.Exit");
			String choice =input.next();
			switch(choice) 
			{
			case "1":{
	            System.out.println();
	             
	            if(HomePage.student_details.size()==0) 
	    		{
	    			System.out.println(" no one can Register Currently !!");
	    		    break;
	    		}
	    		if(Quota_Allogated.Quota_allogated.size()==0) 
	    		 {
	    			   System.out.println(" First allogated seat in Quoto !!");
	    		  }
	    		
	    		else {
			    System.out.println("       ****Are you sure to release all results!!!*****");
	            System.out.println(" press 'yes' release Results or press 'No' not release");
				String check=input.next().toLowerCase();
				if(check.equals("yes")) {
				System.out.println();
				System.out.println("<<........................Access  student to view Final_results ..................>>");
				System.out.println();
				viewAllStudentOurResult=true;
				Exam_control(namekey);
				}
				else {
					System.out.println("     ***Cancel publised****");
					Exam_control(namekey);
				}
				break;
			   }
	    	}
			case "2":{
			    Published_result_view(namekey);	
				break;
			}
			case "3":{
				System.out.println();
			   	break breakit;
				
			}
			default : System.out.println(" enter valid input (1-3)");
			}	
		}
		
		
		
	}
	private static void Published_result_view(String namekey) {
		
		System.out.println();
		//System.out.println("<---------------Final_result----------------------->");
		
		Student_details ob=new Student_details();
		Integer[] mark_order_key=ob.sort();
		Quota_Allogated ob1=new Quota_Allogated();	
		System.out.println("<---------------Final_result----------------------->");
//		ob1.Quota_allogated.get(1);
		String caste="",checkempty="";
		int mark=0;int listcount=1;
		
		if(HomePage.student_details.size()==0) 
		{
			System.out.println(" no one can Register Currently !!");
		}
		else 
		{   if(Quota_Allogated.Quota_allogated.size()==0) 
		    {
			   System.out.println(" First allogated seat in Quoto !!");
		    }
		   else 
		   {
			   for(int i=1;i<ob1.Quota_allogated.size();i++) //Quota size
				{     switch(i) 
					  {
				       case 1:{caste="BC";break;}case 2:{caste="OBC";break;}case 3:{caste="SC";break;}case 4:{caste="Others";break;}
				      }
				      int top_first=ob1.Quota_allogated.get(i);//get -/set count 
		                 for(int k=0;k<mark_order_key.length;k++) //keys
		                 {
				                     if((caste.equals(HomePage.student_details.get(mark_order_key[k]).caste) && top_first!=0))
				            		 {
				                    	 Student_details get=HomePage.student_details.get(mark_order_key[k]);
				                    	  System.out.println("----------------------------[Rank list "+(listcount++)+"]---------------------------------------");
				                    	  System.out.println(" Name : "+get.name);
				                    	  System.out.println(" College Name :"+get.college_name);
				                    	  System.out.println(" Total Mark "+get.entrancemark);
				            	          top_first--;
				            	          
				            		 }   
				         }
				}	   
		   }
		}
		System.out.println("<------------[End-Of-List]----------->");
		published_result(namekey);
		
}

		
	
	//published final result 
	static void published_Result(String namekey) {
    System.out.println();
    System.out.println("<--------------------------Final Qualified results---------------------->");
		if(viewAllStudentOurResult) {
		Student_details ob=new Student_details();
		Integer[] mark_order_key=ob.sort();
		Quota_Allogated ob1=new Quota_Allogated();
		ob1.Quota_allogated.get(1);
		String caste="";
		int mark=0;int listcount=1;
		for(int i=1;i<ob1.Quota_allogated.size();i++) //Quota size
		{     switch(i) 
			  {
		       case 1:{caste="BC";break;}case 2:{caste="OBC";break;}case 3:{caste="SC";break;}case 4:{caste="Others";break;}
		      }
		      int top_first=ob1.Quota_allogated.get(i);//get set count 
 
                 for(int k=0;k<mark_order_key.length;k++) //keys
                 {
		                     if((caste.equals(HomePage.student_details.get(mark_order_key[k]).caste)&& top_first!=0))
		            		 {
		                    	 Student_details get=HomePage.student_details.get(mark_order_key[k]);
		                    	  System.out.println("----------------------------[ "+(listcount++)+" Rank ]---------------------------------------");
		                    	  System.out.println(" Name : "+get.name);
		                    	  System.out.println(" College Name :"+get.college_name);
		                    	  System.out.println(" Total Mark "+get.entrancemark);
		            	        top_first--;
		            		 }
		                     
		         }
		}
		Student_Page student_Page=new Student_Page();
		student_Page.student_Home_Page(namekey);
		}
		else 
		{
			System.out.println("Result not published");
			Student_Page student_Page=new Student_Page();
			student_Page.student_Home_Page(namekey);
		}
        		
	}

//----------------------------main_exam_quetions-----------------
   private static void main_exam_question(String namekey) {
	   HomePage home=new HomePage();
     int size=home.Question_bank.size();
     if(size!=0) {
	    System.out.println();
	    System.out.println("<<..........................MAIN EXAM QUESTIONS........................>>");
		HomePage homePage=new HomePage();int count=1;
		Iterator<Integer> itr=homePage.Question_bank.keySet().iterator();
		while(itr.hasNext()) 
		{
			int key=itr.next();
			Admin_details ob2=homePage.Question_bank.get(key);
			System.out.println("--------------------[No "+(count++)+"]---------------------------------");
			System.out.println(" Question : "+ob2.Question);
			for(int i=0;i<ob2.options.size();i++) 
			{
				System.out.println((i+1)+" option "+ ob2.options.get(i));
			}
			System.out.println(" Correct Answer : "+ob2.correct_answer);
		}
       admin_Home_Page(namekey);
       }
     else {
    	 System.out.println("     * *No Question Available  * *");
    	 admin_Home_Page(namekey);
     }
	}
	//---------------------------------Add_Question_main_Exam------------------------
	private static void Add_Question_main_Exam(String namekey) {
         Scanner scanner=new Scanner(System.in);
		 HomePage homepage=new HomePage();
         int size=homepage.login_details.get(namekey).questions.size();
		 if(size==0) {System.out.println(" No Questions Available currently  ");}
		 else 
		 {  System.out.println("press 'yes' to published it or not press 'NO'");
			 if(scanner.next().equals("yes")) 
			 {
		         Iterator<Integer> itr =homepage.login_details.get(namekey).questions.keySet().iterator();
				 while(itr.hasNext()) 
				 {
					 int key=itr.next();
					 Admin_details ob1=(Admin_details) homepage.login_details.get(namekey).questions.get(key);
					 homepage.Question_bank.put(key, ob1);
				 }
				 System.out.println();
				 System.out.println("<<<...............All question uploaded to Main Exam.................>>>");
				 System.out.println();				 
			 }
			 else System.out.println("Cancel it !!!");
			 System.out.println();
			 

//			 Admin_home_page(namekey);			 
		 }

	}

	//<-----------------------Add_Admin------------------------------------------>
	private static void Add_admin() {
		Scanner input=new Scanner(System.in);
		LinkedHashMap question_details=new LinkedHashMap<Integer,HomePage>();
		System.out.println("<----------------Add Admin----------------->");
		System.out.println();
		//key check unique or not
		System.out.println("Enter the Profile_name(unique) : ");
		String profile_name =input.next();//unique 
	    
		//validate profile name unique
		     boolean get_name=HomePage.login_details.containsKey(profile_name);
//             System.out.println(get_name);
        	if(get_name)
        	{ System.out.println("/t/t<<    Try Another profile_Name it's exists     >>");
        	  Add_admin();	//change pannanum note it
        	}
        	
        //Add_admin
        System.out.println("Enter your Fullname : ");
        String name=input.next();
        boolean flag=true;
        String pass="";
        while(flag) {
         System.out.println("Enter the password (8 pin ): ");
         pass=input.next();
        String check_password=pass+"";
        if(check_password.length()==8) 
        {
             flag=false;	
        }
        else {System.out.println(" pls enter 8 digit pin ");}
        }
        //get profile_name set as key and user_name,password,set manual admin
        
        Login_details ob=new Login_details(name, pass, "Admin",question_details);
        HomePage.login_details.put(profile_name, ob);
        System.out.println();
        System.out.println("\t\t\t<<      * * Admin created Successfully * *      >>");
        System.out.println();
//        HomePage home=new HomePage();
//        home.home_page(); 	
	}

//---------------------Add_question-------------------------------
	private  void add_Question(String userName) {
		Scanner scanner=new Scanner(System.in);
         
		
			try {
				 System.out.println();
				 System.out.println("<<---------Add_question_answer------->>");
			     LinkedHashMap<Integer,Admin_details> question_bank=new LinkedHashMap<Integer,Admin_details>();
		         String Question="";
		         LinkedList<String> options=new LinkedList<String>();
		         LinkedList<String> options_Copy=new LinkedList<String>();
		         System.out.println("how many questions provide ");
		         int question_count=scanner.nextInt();
		         System.out.println("how many options provide ");
		         int options_count=scanner.nextInt();
		         String correct_answer="";
		         for(int i=1;i<=question_count;i++) 
		         {   System.out.println("write "+i+" question ?");
		        	 Question=scanner.next();
		        	 for(int j=1;j<=options_count;j++) 
		        	 {    System.out.println("write "+j+" option ::");
		                  options.add(scanner.next());
		        	 }
		        	 System.out.println("write correct Answer ::");
		        	 correct_answer=scanner.next();
		        	 System.out.println("Enter the mark : ");
		        	 int question_mark=scanner.nextInt();
		        	 options_Copy=(LinkedList<String>) options.clone(); 
		        	 Admin_details ob=new Admin_details(Question,options_Copy,correct_answer,question_mark,0,"");
		        	 int key=(int) (Math.random()*999999+100);
		              HomePage home=new HomePage();
		              LinkedHashMap qe=home.login_details.get(userName).questions;
		        	  qe.put(key, ob);
		              options.clear();
		         }
		         System.out.println("All question and answer uploaded Successfully..");
    		} catch (Exception e) {
                   System.out.println("Enter correctly only numbers is allowed ");
	                add_Question(userName);	           	       
			}

		}
		 
		
	
//----------------------view_student_details------------------------------->>
	private  void view_Student_Details(String userName) {
		 System.out.println("<<...................Student detils..............>>");
		 Iterator<Integer> itr=HomePage.student_details.keySet().iterator();
		 if(HomePage.student_details.isEmpty()) 
		 {   System.out.println();
			 System.out.println("NO details available currently");
			 System.out.println();
			 admin_Home_Page(userName);
		 }
		 int key=0;
		 while(itr.hasNext()) 
		 {  key=itr.next();
            System.out.println();
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		    System.out.println(" Student : "+key);
   		    Student_details ob=HomePage.student_details.get(key);
   		    System.out.println(" | Profile_name | \t\t | Name | \t\t | College_name | \t\t | Age | \t\t | 10th Mark | \t\t | 12th mark | \t\t | caste | \t\t | certificate_count | ");
            System.out.println("\t\t"+ob.profile_name+"\t\t"+ob.name+"\t\t"+ob.college_name+"\t\t"+ob.age+"\t\t"+ob.mark_10th+"\t\t"+ob.mark_12th+"\t\t"+ob.caste+"\t\t"+ob.certificate_count);
		   
		 }
		 admin_Home_Page(userName);
	}
	//---------------------view_Questions-----------------------
	private void view_Questions(String userName) {
		HomePage home1=new HomePage();
	    int size=home1.login_details.get(userName).questions.size();
		
	    if(size!=0) {
	    Scanner input=new Scanner(System.in);
        System.out.println();		int count=1;
        HomePage home=new HomePage();
        System.out.println("------------------------------------------------------------------------------------");
        Iterator<Integer> itr=home.login_details.get(userName).questions.keySet().iterator();
        while(itr.hasNext()) 
        {   System.out.println("--------------------[ NO : "+count+" ]--------------------------------------");
        	int key=itr.next();
        	Admin_details ob= (Admin_details) home.login_details.get(userName).questions.get(key);
        	System.out.println(count+".Question : "+ob.Question+"        reference_NO => "+key);count++;
        	System.out.println("options : "+ob.options);
        	for(int i=0;i<ob.options.size();i++) 
        	{
        		System.out.println(" "+(i+1)+". "+ob.options.get(i));
        	}
        	System.out.println("Correct Answer : "+ob.correct_answer);
        	
        }
        
       System.out.println("----------------------------------------------------------------------------------------");
       System.out.println(" \t\t 1.Edit Questions \n\t\t 2.remove Question \n\t\t 3.Exit "); 
       int choice =input.nextInt();
       switch(choice) 
       {
       case 1:{
    	     edit_Question(userName);
    	   break;
       }
       case 2:{
            remove_Question(userName);
    	   break;
       }
       case 3:{
    	   admin_Home_Page(userName);
    	   break;
       }
       }
	    }
	    else 
	    {
	    	System.out.println(" No Question Avalable !! ");
	    	admin_Home_Page(userName);
	    } 
	}

//--------------------------------------[ remove Question ]--------------------------------------------------------------------	
	private void remove_Question(String namekey) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("[****************************][Remove_Question][***********************************************]");
        System.out.print(" Enter the Question Key :: ");
        int key=scanner.nextInt();
        HomePage homepage=new HomePage();
        boolean key_verify=homepage.login_details.get(namekey).questions.containsKey(key);
        
        if(key_verify==false) {
        	System.out.println();System.out.println(" * * Enter valid Question_key * * ");System.out.println();
        	view_Questions(namekey);}
        
        System.out.println(" Are you sure to Deleted (yes or no ) ::  ");
	    String check=scanner.next().toLowerCase();
	    
	    if(check.equals("no")) 
	    {
         view_Questions(namekey);	    	
	    }
	    else 
	    {
	    	Login_details ob= HomePage.login_details.get(namekey);
	    	ob.questions.remove(key);
	    	System.out.println();
	    	System.out.println("-------------------[ Question Deleted !!]--------------------------------");
            System.out.println();
            int size=homepage.login_details.get(namekey).questions.size();
            if(size!=0) 
            {
            	 view_Questions(namekey); 	
            }else {admin_Home_Page(namekey);}
	    }
	}
	
//----------------------------------------[ Edit Question ]-----------------------------------------------------------------

	private void edit_Question(String namekey) {
		Scanner input=new Scanner(System.in);
           System.out.println("````````````````````````````````````````````````````````````````");
           System.out.print(" Enter the Question Key :: ");
           int key=input.nextInt();
           System.out.println(" Are you sure to edit(yes or no ) ::  ");
	       String check=input.next().toLowerCase();
	       String Question="";
	       List<String > options=new LinkedList<String>();
	       String correctAnswer="";
	       
	       if(check.equals("yes")){
	       HomePage ob=new HomePage();
	       Admin_details edit=(Admin_details) ob.login_details.get(namekey).questions.get(key);
	       System.out.println();
	       System.out.println("--------------current question data ------------");
	       System.out.println(" \t\t Question : "+edit.Question);
	       for(int i=0;i<edit.options.size();i++) 
	       {
	    	System.out.println(" \t\t"+(i+1)+" option is => "+edit.options.get(i));   
	       }
	       System.out.println(" \t\tCorrect Answer : "+edit.correct_answer);
	       boolean flag=true;
	       System.out.println();
	       while(flag) {
	       System.out.println(" \t\t1.Edit Question \n \t\t2.Edit Options \n\t\t 3.Edit Correct Answer \n\t\t 4.Save " );   
	       String choice=input.next();
	       System.out.print("=>");
	       System.out.println();
	       switch (choice) {
		   case "1": {

			   System.out.print(" re-write Question >> ");
               Question=input.next(); 
			  break;
			}
		   case "2":
		   {   System.out.println("re_write options >> ");
		       System.out.println(" How many option provide : ");
		       String len=input.next();
		       System.out.println("re_write options >> ");
		       for(int i=0;i<Integer.parseInt(len);i++) {
		            System.out.print(" write "+(i+1)+" option : ");
		    	    options.add(input.next());
		    	    System.out.println();
		       }
		       break;
		   }
		   case "3":
		   {   System.out.print(" re_write Correct Answer >> ");
			    correctAnswer=input.next();
		   break;   
		   }
		   case "4":
		   {  flag=false;
			   break;
		   }
		   default:
			System.out.println("Enter valid Input(1-4)");
		   }
	       }
	       
	       }
          else  
	       {   System.out.println("<<.........Cancel..........>>");
	    	   view_Questions(namekey);
	       }
	       
	       boolean b=update(Question,options,correctAnswer,namekey,key);
	       if(b) 
	       {
	    	   System.out.println("......................[ Update Successfully ].............");
	    	   admin_Home_Page(namekey);
	       }
	       else 
	       {
	    	   System.out.println("---------------------[ update Cancel ]-------------------------");
	    	   admin_Home_Page(namekey);
	       }
	}
//--------------------------------------[ Update method ]-----------------------------------------------------------------------------------
	private boolean update(String question, List<String> options, String correctAnswer, String namekey,int key) {
		Scanner input=new Scanner(System.in);
		System.out.println("................update details............. ");
		System.out.println("Question "+question);
		for(int i=0;i<options.size();i++)
		{
		System.out.println((i+1)+". option "+options.get(i));
		}
		System.out.println("CorrectAnswer "+correctAnswer);
		System.out.println("check once again all details correct press yes or no :");
		System.out.println("..........................................");
		String check=input.next().toLowerCase();
		if(check.equals("no")) 
		{
		  return false;	
		}
		else 
		{   HomePage ob=new HomePage();
			Admin_details update=(Admin_details) ob.login_details.get(namekey).questions.get(key);
			update.Question=question;
			update.correct_answer=correctAnswer;
			update.options.clear();
		    for(int i=0;i<options.size();i++) 
		    {
		    	update.options.add(options.get(i));
		    }
		  return true;	
		}		
		
		
	}	
	
	//------------------------------------------end-------------
}