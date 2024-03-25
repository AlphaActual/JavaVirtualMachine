public class Person {
    protected String name;
    protected String surname;

    public Person() {
        this("John", "Doe");
    }
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", Surname: " + surname);
    }
}
