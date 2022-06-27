package medicalExam;

import java.util.LinkedHashMap;

import java.util.Scanner;

public class Quota_Allogated {
    // static Scanner input=new Scanner(System.in);
     static LinkedHashMap<Integer, Integer> Quota_allogated=new LinkedHashMap<>();
     static boolean onceQuotaAllogatedCheck=false;     
	public static void quota_Allogated(String namekey) {
		Scanner input=new Scanner(System.in);
		
		int len=Quota_allogated.size();
		
		if(len==0) {System.out.println("  Quota is not allogated !! ");}
		else { System.out.println("Seats allowed in Quota order listed as below ");
		System.out.println(" the BC Seat percentage : "+Quota_allogated.get(1));
		System.out.println(" the OBC Seat percentage : "+Quota_allogated.get(2));
		System.out.println(" the SC Seat percentage : "+Quota_allogated.get(3));
		System.out.println(" the Others Seat percentage : "+Quota_allogated.get(4));		
		System.out.println();        
		      }
		
		if(len!=0) 
		{
			System.out.println("if you want change Quota press 'yes' or not press 'no' ");
	    	
			if(input.next().equals("yes"))
				onceQuotaAllogatedCheck=false;
			else
				System.out.println(" cancel it ...");	
		}
		
		
		
		
		if(onceQuotaAllogatedCheck==false) 
		{
			System.out.println("");
			System.out.println("Enter the BC Seat percentage : ");
			int BC=input.nextInt()/10;
			System.out.println("Enter the OBC Seat percentage : ");
			int OBC=input.nextInt()/10;
			System.out.println("Enter the SC Seat percentage : ");
			int SC=input.nextInt()/10;
			System.out.println("Enter the Others Seat percentage : ");
			int Others=input.nextInt()/10;
			Quota_allogated.put(1,BC);		
			Quota_allogated.put(2,OBC);		
			Quota_allogated.put(3,SC);		
			Quota_allogated.put(4,Others);
			System.out.println("`````````````````````````````````````````");
	        System.out.println(" |BC seats\t: "+Quota_allogated.get(1));
	        System.out.println(" |OBC seats\t: "+Quota_allogated.get(2));
	        System.out.println(" |SC seats\t: "+Quota_allogated.get(3));
	        System.out.println(" |Others seats\t: "+Quota_allogated.get(4));
		    System.out.println("```````````````````````````````````````````");	
	 	    System.out.println(); System.out.println("\t\t<<<........Quota_alloted.....>>>");System.out.println();
		    Admin_page ob=new Admin_page();
            onceQuotaAllogatedCheck=true;
		    ob.Exam_control(namekey);
		}

		
	}
}
