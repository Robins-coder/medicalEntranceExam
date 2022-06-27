package medicalExam;

import java.util.LinkedList;


public class Admin_details {
     
      String Question;
      LinkedList<String> options;
      String correct_answer;
      int Question_mark;
      int current_mark; String get_answer;
	public Admin_details(String qusetion, LinkedList<String> option_save, String correct_answer, int question_mark, int current_mark, String get_answer) {
		this.Question=qusetion;
		this.options=option_save;
		this.correct_answer=correct_answer;
	    this.Question_mark=question_mark;
	    this.current_mark=current_mark;
	    this.get_answer=get_answer;
	}
	
	
}
