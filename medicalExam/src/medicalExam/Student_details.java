package medicalExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



public class Student_details {
    static LinkedHashMap<Integer,Integer> quota_AllogatedList=new LinkedHashMap<Integer, Integer>();
    String profile_name; 
	String name;
	String college_name; 
	int age;
	int mark_10th; 
	int mark_12th;
	String caste; 
	int certificate_count;
	int entrancemark;
	boolean allow;
	public Student_details(String profile_name, String name, String college_name, int age, int mark_10th, int mark_12th,
			String caste, int certificate_count,int entrancemark, boolean allow) {
	     this.profile_name=profile_name;
	     this.name=name;
	     this.college_name=college_name;
	     this.age=age;
	     this.mark_10th=mark_10th;
	     this.mark_12th=mark_12th;
	     this.caste=caste;
	     this.certificate_count=certificate_count;
	     this.entrancemark=entrancemark;
	     this.allow=allow;
	}
	
	public Student_details() {
	
		
	}

	public Integer[] sort() {
		 
	        Integer[] top_mark =new Integer[HomePage.student_details.size()];
	        int a=0;
	      
	        
	     for(Integer rslt :HomePage.student_details.keySet()) 
	     {
	    	top_mark[a++]=rslt;
	     }//get all key
		int temp=0;
	     //sort
	     for(int i=0;i<top_mark.length-1;i++) 
	     {
	    	for(int j=i+1;j<top_mark.length;j++) 
	    	{
	    	   if(HomePage.student_details.get(top_mark[i]).entrancemark<HomePage.student_details.get(top_mark[j]).entrancemark) 
	    	   {
	    	     temp=top_mark[i];
	    	     top_mark[i]=top_mark[j];
	    	     top_mark[j]=temp;
	    	   }	
	    	} 
	     }

	      return top_mark; 
	}
	



}


		
		
		
	


