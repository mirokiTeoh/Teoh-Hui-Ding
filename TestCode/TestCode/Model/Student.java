package Model;

/**
 * @author huiding.teoh, 24/6/2018
 * Question 2
 */
import java.util.Comparator;

public class Student implements Comparator<Student> {

	private int id;
	private String name;
	private double gpa;
	
	public Student(int id, String name, double gpa){
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}
	
	public Student(){
		
	}
	
	public String getName() {
		return this.name;
	}
	public int getId() {
		return this.id;
	}
	public double getGpa() {
		return this.gpa;
	}
	
	// Overriding compare method
	public int compare(Student s1, Student s2){
		// Compare GPA
		int gpaDiff = Double.compare(s2.gpa, s1.gpa);
		if (gpaDiff != 0){
			return gpaDiff;
		}
		// Compare First Name
		int firstNameDiff = (s1.name.substring(0,1).compareToIgnoreCase(s2.name.substring(0,1)));
		if (firstNameDiff != 0){
			return firstNameDiff;
		}
		
		// Compare ID
		return s1.id - s2.id;
	}
}
