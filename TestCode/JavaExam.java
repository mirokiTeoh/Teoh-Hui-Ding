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
		question1();
		
		// Sorting List
		question2();
		
		// Calculate Processing Time
		question3();
	}
	
	/**
	 * Validate IP Address
	 */
	public static void question1(){
		TimeElapse processTime = new TimeElapse();
		IPValidationRegex ipValidator = null;
		List<String> ipAddressList = readFile("../IpAddresses.txt"); // Read IP Address from file
		boolean validIp = false;
		
		if (ipAddressList != null){
			StringBuffer strBuff = new StringBuffer("Invalid IP Address List:");
			for (String ipAddress : ipAddressList){
				
				ipValidator = new IPValidationRegex();
				validIp = ipValidator.validate(ipAddress);
				
				if (!validIp){
					strBuff.append("\n").append(ipAddress);
				}
			}
			System.out.println(strBuff.toString());
		}
		processTime.end();
	}
	
	/**
	 * Sorting list
	 */
	public static void question2() {
		TimeElapse processTime = new TimeElapse();
		List<Student> list = new ArrayList<Student>();
		
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
	}
	
	public static void question3() {
		// Method 1 -- Call by method
		TimeElapse processTime = new TimeElapse();
		System.out.println("Sum Of Numbers = [" + process1(100000) + "]");
		processTime.end();
		
		// Method 2 -- Call by class
		TimeElapse processTime2 = new TimeElapse();
		Process2 process2 = new Process2();
		process2.SumOfNumbers(20000);
		processTime2.end();
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
	public static List<String> readFile(String sFileName){
		
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
			ioe.printStackTrace();
		} finally{
			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ioex) {

				ioex.printStackTrace();

			}
		}
		
		return ipAddress;
	}
}
