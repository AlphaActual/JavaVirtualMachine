import java.util.Arrays;

public class Student extends Person  {
    final int SUBJECTS_SIZE = 5;
    private int studentId;

    private Subject[] subjects = new Subject[SUBJECTS_SIZE];

    public Student(String name, String surname, int ID, Subject[] subjects) {
        super(name, surname);
        this.studentId = ID;
        this.subjects = subjects;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name + ", Surname: " + surname + ", ID: " + studentId + " Subjects: ");
        for (Subject subject : subjects) {
            System.out.println("- " + subject.getSubjectRecord());
        }
    }

}
