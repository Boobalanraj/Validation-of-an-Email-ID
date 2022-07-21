package com.emailvalidation.demo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationEmail {
	
	//employees email Id's to check from this data
	String[] emails= {"raj@outlook.com","kumar@google.com","yujith@gmail.com","dilip@wipro.com","suhail@google.com"};

		public boolean checkemail(String userEmail) {
			for(String employeeemail : emails) {
				if(employeeemail.equals(userEmail)) {
					return true;
				}
			}
			return false;
		}
		
		//regex checking in email input
		String regex ="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		
		public boolean regexcheck(String userEmail) {
			Matcher confirm = pattern.matcher(userEmail);
			
			if(confirm.matches()) {
				return true;
			}
			return false;
		}
		
		//main function
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userEmail;
		
		String execute ="yes";
		while(execute.equals("yes")) {
			System.out.print("Enter Email ID: ");
			userEmail = sc.next();
			System.out.println("Given Email ID: "+userEmail);
			ValidationEmail emailValidation = new ValidationEmail();

			//checking regular expression from user
			System.out.println(emailValidation.regexcheck(userEmail)? "Valid Email\n":"Invalid Email");
			
			if(emailValidation.checkemail(userEmail)==true) {          //checking input email id in data
				System.out.println("Email ID found in data");
			}
			else {
				System.out.println("Email ID not found in data");
			}
			System.out.println("Would you like to continue ? (yes or no)");       //want to continue checking email
			execute = sc.next();
		}
		sc.close();        //stop leak from Scanner input
	}
}
