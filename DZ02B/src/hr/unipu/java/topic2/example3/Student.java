package hr.unipu.java.topic2.example3;

public class Student {
	final int ARR_SIZE = 60;
	private String id;
	private String name;
	private String surname;	
	private int noOfGrades;
	private CourseGrade[] grades; /* primijetiti razliku u deklaraciji polja u 	odnosu na C. 
							         Ovo je slično tome da je ocjene pokazivač na dinamički
							         alocirano polje */
	
	public void init(){ /* nakon 3. predavanja ovakve vlasite inicijalizacijske 
						   metode ćemo zamijeniti konstruktorima */
		grades = new CourseGrade[ARR_SIZE];
		noOfGrades = 0;
	}
	
	public void addGrade(int code, String title, int grade){
		if (grade >= 2 && grade <=5){
			CourseGrade courseGrade = new CourseGrade();
			courseGrade.code = code;
			courseGrade.title = title;
			courseGrade.grade = grade;
			grades[noOfGrades++] = courseGrade;
		}
	}
	
	public double averageGrade(){
		int sum = 0;
		for(int i=0; i<noOfGrades; i++)
			sum += grades[i].grade;
		return noOfGrades > 0 ? (double) sum / noOfGrades : 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String newId) {
		id = newId;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String newSurname) {
		surname = newSurname;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s, %s - Average grade = %.2f", id, surname, name, averageGrade() );
	}

	@Override
	public boolean equals(Object obj) {
		//pretpostavit ćemo da je primljeni objekt uistinu Student
		Student otherStudent = (Student) obj;
		return id.equals(otherStudent.id);
	}
}
