public class Subject {
    private String name;
    private String professor;

    public Subject(String name, String professor) {
        this.name = name;
        this.professor = professor;
    }

    public String getSubjectRecord() {
        return "Subject: " + name + ", Professor: " + professor;
    }
}
