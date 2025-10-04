public class Student {
    private int id;
    private String name;
    private String course;
    private int marks;

    public Student(int id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getMarks() {
        return marks;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void display() {
        System.out.printf("%-5d %-15s %-10s %-5d%n", id, name, course, marks);
    }
}
