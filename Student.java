import java.util.ArrayList;

public class Student {
    private int rollnum;
    private String firstName;
    private String lastName;
    private int age;
    private String major;
    private String streetAddress;
    private String city;
    private String state;
    private int zip;
    private int phoneNumber;
    private double gpa;
    public ArrayList<Course> courses;

    public Student(int rollnum, String firstName, String lastName) {
        this.rollnum = rollnum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = 0;
        this.major = "";
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.zip = 0;
        this.phoneNumber = 0;
        this.gpa = 0.0;
        this.courses = new ArrayList<Course>();
    }

    public Student(int rollnum, String firstName, String lastName, double gpa) {
        this.rollnum = rollnum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = 0;
        this.major = "";
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.zip = 0;
        this.phoneNumber = 0;
        this.gpa = 0.0;
        this.courses = new ArrayList<Course>();
    }

    public Student(int rollnum, String firstName, String lastName, int age, String major, String streetAddress, String city, String state, int zip, int phoneNumber, double gpa) {
        this.rollnum = rollnum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.major = major;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.gpa = gpa;
        this.courses = new ArrayList<Course>();
    }

    public int getID() {
        return rollnum;
    }

    public int getRollnum() {
        return rollnum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setRollnum(int rollnum) {
        this.rollnum = rollnum;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void addCourse(Course course) {
        courses.add(course);
        double weightedGpa = 0.0;
        int totalCredits = 0;
        for(Course c : courses) {
            switch (c.getGrade()) {
                case "A":
                    weightedGpa += 4.0 * c.getCredits();
                    break;
                case "A-":
                    weightedGpa += 3.7 * c.getCredits();
                    break;
                case "B+":
                    weightedGpa += 3.3 * c.getCredits();
                    break;
                case "B":
                    weightedGpa += 3.0 * c.getCredits();
                    break;
                case "B-":
                    weightedGpa += 2.7 * c.getCredits();
                    break;
                case "C+":
                    weightedGpa += 2.3 * c.getCredits();
                    break;
                case "C":
                    weightedGpa += 2.0 * c.getCredits();
                    break;
                case "D":
                    weightedGpa += 1.0 * c.getCredits();
                    break;
                default:
                    weightedGpa += 0.0 * c.getCredits();
                    break;
            }
            totalCredits += c.getCredits();
        }
        this.gpa = weightedGpa / totalCredits;
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public String toString() {
        String result = "";
        result += "Roll Number: " + rollnum + "; ";
        result += "First Name: " + firstName + "; ";
        result += "Last Name: " + lastName + "; ";
        result += "GPA: " + gpa + ";\n";
        if(courses.size() > 0) {
            result += "Courses:\n";
            for (Course course : courses) {
                result += course.toString() + "\n";
            }   
        }
        return result;
    }

    public void toStringCourses() {
        for (Course course : courses) {
            System.out.println(course.toString());
        }
    }

    public boolean isStudentGtLastName(Student student) {
        return this.lastName.compareTo(student.getLastName()) > 0;
    }

    public boolean isStudentGtFirstName(Student student) {
        return this.firstName.compareTo(student.getFirstName()) > 0;
    }

    public boolean isStudentGtGpa(Student student) {
        return this.gpa > student.getGpa();
    }

    public boolean isStudentGtAge(Student student) {
        return this.age > student.getAge();
    }
}