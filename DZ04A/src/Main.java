//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 *
 * @author Pritišanac Tin
 * @version 1.0
 * DZ 4A prikaz nadjačavanja metoda
 * Kod svih zadaća dostupan je na git repozitoriju: https://github.com/AlphaActual/JavaVirtualMachine
 *
 */
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("John", "Doe", new String[]{"Math", "Physics"}, 1000);
        teacher.displayDetails();

        Teacher teacher2 = new Teacher();
        teacher2.displayDetails();

        Student student = new Student("Jane", "Doe", 1, new Subject[]{new Subject("Math", "John"), new Subject("Physics", "Doe")});
        student.displayDetails();

        Student student2 = new Student( "Eddy", "Singer", 2, new Subject[]{new Subject("Physics", "Harrison"), new Subject("Biology", "Perry")});
        student2.displayDetails();
    }
}