import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Model.Student;


public class JavaExam {
	
	public static void main (String[] args){
		// Validate IP Address with regex
		System.out.println("------QUESTION 1------");
		question1();
		
		// Sorting List
		System.out.println("------QUESTION 2------");
		question2();
		
		// Calculate Processing Time
		System.out.println("------QUESTION 3------");
		question3();
	}
	
	/**
	 * Validate IP Address
	 */
	public static void question1(){
		TimeElapse processTime = new TimeElapse();
		IPValidationRegex ipValidator = null;
		boolean validIp = false;
		
		try {
			List<String> ipAddressList = readFile("File/IpAddresses.txt"); // Read IP Address from file
			if (ipAddressList != null){
				StringBuffer strBuffInvalidIP = new StringBuffer("Invalid IP Address List:");
				StringBuffer strBuffValidIP = new StringBuffer("Valid IP Address List:");
				
				for (String ipAddress : ipAddressList){
					
					ipValidator = new IPValidationRegex();
					validIp = ipValidator.validate(ipAddress);
					
					if (validIp){
						strBuffValidIP.append("\n").append(ipAddress);
					} else {
						strBuffInvalidIP.append("\n").append(ipAddress);
					}
				}
				System.out.println(strBuffInvalidIP.toString());
				System.out.println();
				System.out.println(strBuffValidIP.toString());
			}
			processTime.end();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Sorting list
	 */
	public static void question2() {
		TimeElapse processTime = new TimeElapse();
		List<Student> list = new ArrayList<Student>();
		
		try {
		
			list.add(new Student(33, "Tina", 3.68));
		    list.add(new Student(85, "Louis", 3.85));
		    list.add(new Student(56, "Samil", 3.75));
		    list.add(new Student(19, "Samar", 3.75));
		    list.add(new Student(22, "Lorry", 3.76));
		      
		    Collections.sort(list, new Student());
		      
		    for (Student student : list){
		    	System.out.println(student.getName());
		    }
		    processTime.end();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void question3() {
		
		try {
			// Method 1 -- Call by method
			TimeElapse processTime = new TimeElapse();
			System.out.println("Sum Of Numbers = [" + process1(100000) + "]");
			processTime.end();
			
			// Method 2 -- Call by class
			TimeElapse processTime2 = new TimeElapse();
			Process2 process2 = new Process2();
			process2.SumOfNumbers(20000);
			processTime2.end();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * process 1
	 * @param count
	 * @return
	 */
	public static int process1(int count) {
		
		int total = 0;
		for (int i=0; i<count; i++){
			total += i;
		}
		return total;
	}
	
	/**
	 * Read from txt
	 * @param sFileName
	 * @return
	 */
	public static List<String> readFile(String sFileName) throws Exception{
		
		BufferedReader br = null;
		FileReader fr = null;
		List<String> ipAddress = new ArrayList<String>();
		
		try {
			fr = new FileReader(sFileName);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				ipAddress.add(sCurrentLine);
			}
			
		} catch (IOException ioe){
			throw ioe;
		} finally{
			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ioex) {
				throw ioex;
			}
		}
		
		return ipAddress;
	}
}
