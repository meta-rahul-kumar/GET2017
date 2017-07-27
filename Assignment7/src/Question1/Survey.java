package Question1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Survey{
	/**
	 * @Method compareStrings(String source_string,String compare_with_string)
	 * this method is comparing two strings
	 * @param two string ,which has to be compared 
	 * @return Integer , Zero, Negative or Positive  
	 * */
	public static int compareStrings(String source_string,String compare_with_string)
	{
		return source_string.compareTo(compare_with_string);
	}
	
	/**
	 * @Method countNoOfLinesInFile(String path)
	 * count no of lines in file
	 * @param String , file path is entered
	 * @return Integer , number of line
	 * */
	public static int countNoOfLinesInFile(String path) throws IOException {
		FileInputStream file_input = new FileInputStream(path);
		BufferedReader buffer_input = new BufferedReader(new InputStreamReader(
				file_input));
		int line_count = 0;
		while ((buffer_input.readLine()) != null) {
			line_count++;
		}

		buffer_input.close();
		return line_count;
	}

	/**
	 * @Method storeUserAnswers(int no_of_users,Questions[] question_object)
	 * take user input and store the valid response 
	 * @param number of users and Question objects
	 * @return void
	 * */
	public static void storeUserAnswers(int no_of_users,Question[] question_object) 
	{
		Scanner scanInput = new Scanner(System.in);
		
		for (int user_no = 1; user_no <= no_of_users; user_no++) {
			System.out.println("User no " + (user_no));
			// creating participant key in all_participant_answers HashMap
			ParticipantAnswers.all_participant_answers.put("Participant " + (user_no), "");
			
			for (int question_index = 0; question_index < question_object.length; question_index++) {
				// doing Question Printing and recording user input
				String participant_answer = "";

				if (compareStrings("Single Select", question_object[question_index].question_type) == 0) {
					// checking for single select
					System.out.println(question_object[question_index].question_text+ ", "+ question_object[question_index].question_type+ ", "+ question_object[question_index].options);
					participant_answer = scanInput.nextLine();
					if (SingleTypeQuestion.isValidInput(participant_answer, question_object[question_index])) {
						SingleTypeQuestion.recordUserInputForSingleSelect(participant_answer, question_object[question_index]);
					} else {
						System.out.println("Invalid Input");
						question_index--;		
					}

				} else if (compareStrings("Multi Select", question_object[question_index].question_type) == 0) {
					// checking for multiple select
					System.out.println(question_object[question_index].question_text+ ", "+ question_object[question_index].question_type+ ", "+ question_object[question_index].options);
					participant_answer = scanInput.nextLine();
				
					if (MultipleTypeQuestion.isValidInput(participant_answer, question_object[question_index]) == false) 
					{
						System.out.println("Invalid Input");
						question_index--;		
					}
					
				} else if (compareStrings("Text", question_object[question_index].question_type) == 0) {
					// for text select
					System.out.println(question_object[question_index].question_text+ ", "+ question_object[question_index].question_type);
					participant_answer = scanInput.nextLine();
					
				} else if(compareStrings("Number", question_object[question_index].question_type) == 0){
					// for Number select
						while (participant_answer.equals("")) {
							try {
								System.out.println(question_object[question_index].question_text+ ", "+ question_object[question_index].question_type);
								participant_answer = scanInput.nextLine();
								}catch(Exception e) {
									System.out.println("It Must be an Integer and greater than 0. Please Try Again");
									participant_answer = "";
									continue;
								}
							
							if(Integer.parseInt(participant_answer) <= 0) {
								System.out.println("It Must be an Integer and greater than 0. Please Try Again");
								participant_answer = "";
							}
						}
						if(NumberTypeQuestion.isValidInput(participant_answer)==false)
						{
							System.out.println("Invalid number input");
							question_index--;
						}
				}
				
				// updating all participant input in hash map
				String previous_responce = ParticipantAnswers.all_participant_answers.get("Participant " + (user_no));
				ParticipantAnswers.all_participant_answers.put("Participant " + (user_no),previous_responce + "," + participant_answer);
			}
					
		}
		scanInput.close();
	}

	/**
	 * @Method printReportA(Questions[] question_object)
	 * print ReportA (analysis report of single choice question) according to user input 
	 * @param Question objects
	 * @return void
	 * */
	public static void printReportA(Question[] question_object) {
		System.out.println("\nReport A");
		for (int question_index = 0; question_index < question_object.length; question_index++) {
			//printing single_select_array recorded inputs 
			
			if (compareStrings("Single Select", question_object[question_index].question_type) == 0) {
				int total = 0;

				System.out.println("Overall Rating, Single Select, ("
						+ question_object[question_index].options + ")");
				for (int i : question_object[question_index].single_choice_options
						.values()) {
					total += i;
				}
				for (String name : question_object[question_index].single_choice_options
						.keySet()) {
					float value=((question_object[question_index].single_choice_options
							.get(name).intValue() * 100) / (float)total);
					System.out.println(name+" - "+String.format("%.02f", value)+"%");
				}
			}

		}

	}

	/**
	 * @Method printReportB(int no_of_users)
	 * print ReportB (all user's recored survey responses ) 
	 * @param Question objects
	 * @return void
	 * */
	public static void printReportB(int no_of_users) {
		System.out.println("\nReport B");
		for(int i=1;i<=no_of_users;i++)
		{
			// getting data from all_participant_answers HashMap
			String participant="Participant "+i;
			System.out.println( participant+ParticipantAnswers.all_participant_answers.get(participant));
		}
	}

	/**
	 * @Method sortQuestionsFromText(Questions[] question_object)
	 * sort Questions in alphabetical order of question text
	 * @param Question objects
	 * @return void
	 * */
	public static void sortQuestions(Question[] question_object) {
		System.out.println("\nSorted Order Of Questions");
		List<Question> list = new ArrayList<Question>(); // adding all questions objects in list

		for (int index = 0; index < question_object.length; index++) {
			list.add(question_object[index]);
		}
		
		System.out.println("\nQuestions before sorting");
		Iterator<Question> itr = list.iterator(); // printing initial questions order using list iterator
		while (itr.hasNext()) {
			System.out.println(itr.next().question_text);
		}
		
		Collections.sort(list); // sorting list
		System.out.println("\nQuestions after sorting:-");
		// printing sorted output using list iterator

		itr = list.iterator();
		int i = 1;
		while (itr.hasNext()) {
			String[] split_one = itr.next().question_text.split("\\. ");
			System.out.println("Q" + i + ". " + split_one[1]);
			i++;
		}

	}

	/**
	 * @Method main(String... s)
	 * calling all methods for scanning and storing input of users and for printing reportA and reportB
	 * @param Question objects
	 * @return void
	 * */
	public static void main(String[] s) throws IOException {
		String file_path = "src/Question1/test.txt"; // giving file path
		int lines_count = countNoOfLinesInFile(file_path); // Question array creation

		Question[] question_object =Question.createQuestionObject(lines_count); // reading from question file and initializing objects

		Question.initializeQuestionsParameters(file_path, question_object); // taking user input for given question

		try {
			Scanner scanInput = new Scanner(System.in);
			int no_of_users = 0;
			while (no_of_users <= 0) {
				System.out.println("Enter no of participant in servey:-");
				try {
					no_of_users = scanInput.nextInt();
				}catch(Exception e) {
					System.out.println("It Must be an Integer and greater than 0. Please Try Again");
					no_of_users = 0;
					scanInput.nextLine();
					continue;
				}
				
				if(no_of_users <= 0) {
					System.out.println("It Must be an Integer and greater than 0. Please Try Again");
				}
			}

			storeUserAnswers(no_of_users, question_object);
			printReportA(question_object); // Generating Report A
			printReportB(no_of_users); // Generating Report B
			sortQuestions(question_object); // Using comparator interface for sorting Questions
			scanInput.close();
		} catch (InputMismatchException e) {
			System.out.print("Wrong Input:-"+e);
		}

	}

}
