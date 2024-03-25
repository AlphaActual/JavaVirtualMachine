import java.util.Arrays;

public class Teacher extends Person {
    final int SUBJECTS_SIZE = 5;
    private String[] subjects = new String[SUBJECTS_SIZE];
    private double salary;

    public Teacher() {
        this("John", "Doe", new String[]{}, 0);
    }

    public Teacher(String name, String surname, String[] subjects, double salary) {
        super(name, surname);
        this.subjects = subjects;
        this.salary = salary;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name + ", Surname: " + surname + ", Salary: " + salary + " Subjects: " + Arrays.toString(subjects));
    }
}
