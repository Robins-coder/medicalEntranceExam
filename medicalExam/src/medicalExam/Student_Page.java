package medicalExam;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Student_Page {

	public static void student_Home_Page(String userName) 
	{   Scanner input=new Scanner(System.in);
         System.out.println(" \t\t 1.Check Mark sheet \n \t\t 2.Result publish \n \t\t 3.Goto_Exam \n \t\t 4.Exit");		
		 int choice=input.nextInt();
		switch (choice) {
		case 1: {
            check_Mark_Sheet(userName);			
			break;
		}
		case 2:{
			Admin_page admin_page =new Admin_page();
			admin_page.published_Result(userName);
			break;
		}
		case 3 :{
			goto_Exam(userName);
			break;
		}
		case 4:{
			HomePage homePage=new HomePage();
			homePage.home_page();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		
	}
	
	private static void check_Mark_Sheet(String namekey) {
		System.out.println();
		System.out.println("<......Check_mark_sheet.......>>");
       HomePage home=new HomePage();
//       int key=get_key(namekey);
       LinkedHashMap attendqestions=home.login_details.get(namekey).questions;
       Iterator<Integer> itr=attendqestions.keySet().iterator();
       int count=1;
       
       if(attendqestions.size()==0)
    	   System.out.println("you're not attend any exam !!  ");
       else 
       {
    	   while(itr.hasNext()) 
           {
        	   int key=itr.next();
        	   Admin_details ob= (Admin_details) home.login_details.get(namekey).questions.get(key);
        	   System.out.println("-----------------------[ NO "+(count++)+" ]----------------------------------------");
               System.out.println(" "+count+" Question :: "+ob.Question);
               System.out.println(" Options :: "+ob.options);
               System.out.println(" Correct Answer :: "+ob.correct_answer);
               System.out.println(" Your Answer :: "+ob.get_answer);
               System.out.println(" Question Mark :: "+ob.Question_mark);
               System.out.println(" your mark :: "+ob.current_mark);
               System.out.println();
               
           }
   
       }
              student_Home_Page(namekey);
		
	}

	private static void goto_Exam(String userName) {
		Scanner scanner=new Scanner(System.in);
		
       while(true) 
		{
			System.out.println("<<------------------Student page------------------->>");
			System.out.println(" 1.Start Exam \n 2.Exit ");
		    String choice=scanner.next();
	        int key=get_Key(userName);
		    switch (choice) {
			case "1": {
				start_exam(key,userName);
				break;
			}
			case "2":{
	            student_Home_Page(userName);			
				break;
			}
			default:
				System.out.println("Enter valid input(1-2)");
			  continue;
		    }	
		    break;
		}
		
			
	}

	private static int get_Key(String userName) 
	{
	
	//	 System.out.println("<<...................Student detils..............>>");
		 Iterator<Integer> itr=HomePage.student_details.keySet().iterator();
		 int key=0; int original_key=0;
		 while(itr.hasNext()) 
		 {  key=itr.next();
		    
   		    Student_details student_details =HomePage.student_details.get(key);
   		      if(student_details.profile_name.equals(userName)) 
   		      {
   		    	original_key=key;
   		    	break;
   		      } 
		 }
		
	    return original_key;	 
	}
	//------------------Start Exam----------------------------
	private static void start_exam(int key,String username) {
		Scanner input=new Scanner(System.in);
		
		if(HomePage.Question_bank.size()==0) 
		{
			System.out.println("page not available currently !!!");
			goto_Exam(username);
		}
		else 
		{
		
			System.out.println("------------------Exam_Start--------------------");
			HomePage homePage=new HomePage(); 
			boolean allow=homePage.student_details.get(key).allow;
//	       System.out.println("Allow"+allow);
	       
	       if(allow) {
		   int count=1;String get_answer="";
	       int max_mark=0,sum_mark=0,negative_mark=0;
	       for(Map.Entry<Integer, Admin_details> rsl: homePage.Question_bank.entrySet()) 
	       {
	           Admin_details values=rsl.getValue();
	           System.out.println(" "+(count++)+"Questions :"+values.Question);
	           for(int i=0;i<values.options.size();i++) 
	           {
	        	   System.out.println("  "+(i+1)+". "+values.options.get(i));
	           }
	           System.out.println("........Write Answer.....");
	            get_answer=input.next();
	           System.out.println();
	           if(values.correct_answer.equalsIgnoreCase(get_answer))
	           {
	              sum_mark=sum_mark+values.Question_mark;	   
	           }
	           else 
	           {
	        	  negative_mark--;   
	           }
	           int current_mark=sum_mark-negative_mark;
	          // String choose_answer=get_answer;
	           Admin_details ob2=new Admin_details(values.Question,values.options,values.correct_answer,values.Question_mark,current_mark,get_answer);
	      	   int key1=(int) (Math.random()*999999+100);
	            HomePage home=new HomePage();
	            LinkedHashMap questions=home.login_details.get(username).questions;
	            questions.put(key1, ob2);
	       
	       
	       }
	    
	       max_mark=sum_mark+negative_mark;
	       Student_details student_details=HomePage.student_details.get(key);
	      student_details .entrancemark=max_mark;
	      
	       System.out.println("......................Exam finished.................");  
	       homePage.student_details.get(key).allow=false;       
	       HomePage op=new HomePage();
	       op.home_page();
	       }
			else 
			{
				System.out.println("----------------**Your test is summited**---------------------");
			}
			student_Home_Page(username); 

			
		}
		}

//_____________________________________End___________________________________		
}
