package hr.unipu.java.topic2.example3;
import java.util.Scanner;
public class Main {
	public static void printMenu() {
		System.out.printf("Dobrodošli u program za unos i ispis studenata! %nOdaberite jednu od opcija: %n");
		System.out.println("1. Unos novog studenta");
		System.out.println("2. Ispis svih studenata");
		System.out.println("3. Izlaz iz programa");
	}
	public static void main(String[] args) {
		final int STUDENT_ARR_SIZE = 1000;
		int studentIndex = 0;
		Student[] students = new Student[STUDENT_ARR_SIZE];

		printMenu();
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt(); sc.nextLine();
		while (option != 3) {

			switch(option) {
				case 1:
					Student s = new Student();
					s.init();
					System.out.println("Unesite ime studenta: ");
					String name = sc.nextLine();
					s.setName(name);
					System.out.println("Unesite prezime studenta: ");
					String surname = sc.nextLine();
					s.setSurname(surname);
					System.out.println("Unesite ID studenta: ");
					String id = sc.nextLine();
					s.setId(id);
					System.out.println("Unesite ocjena studenta");
					while(true) {
						System.out.println("Unesite šifru ocjene: ");
						int code = sc.nextInt(); sc.nextLine();
						System.out.println("Unesite naziv predmeta: ");
						String title = sc.nextLine();
						System.out.println("Unesite ocjenu: ");
						int grade = sc.nextInt(); sc.nextLine();

						s.addGrade(code, title, grade);
						System.out.println("Želite li unijeti još ocjena? (da/ne)");
						String answer = sc.nextLine();
						if(answer.equals("ne")) {
							break;
						}
					}
					students[studentIndex++] = s;
					break;
				case 2:
					System.out.println("Ispis svih studenata: ");
					// ispis svih studenata
					for(int i=0; i<studentIndex; i++) {
						System.out.println(students[i].toString());
					}
					break;
				default:
					System.out.println("Nepostojeća opcija");
					break;
			}
			printMenu();
			option = sc.nextInt(); sc.nextLine();
		}
		sc.close();
		System.out.println("Kraj programa");
	}
}
