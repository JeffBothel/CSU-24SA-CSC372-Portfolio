public class Course {
    private String courseName;
    private String courseCode;
    private String instructor;
    private String semester;
    private int year;
    private int credits;
    private String grade;

    public Course(String courseCode, String courseName, String semester, int year, int credits, String grade) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = "";
        this.semester = semester;
        this.year = year;
        this.credits = credits;
        this.grade = grade;
    }

    public Course(String courseName, String courseCode, String instructor, String semester, int year, int credits, String grade) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = instructor;
        this.semester = semester;
        this.year = year;
        this.credits = credits;
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getSemester() {
        return semester;
    }

    public int getYear() {
        return year;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setGrade(String grade) {
        switch(grade) {
            case "A":
            case "A-":
            case "B+":
            case "B":
            case "B-":
            case "C+":
            case "C":
            case "D":
            case "F":
                this.grade = grade;
                break;
            default:
                System.out.println("Invalid grade. Please enter a valid grade.");
        }
    }

    public String toString() {
        return "Course Code: " + courseCode + "; " +
               "Course Name: " + courseName + "; " +
               "Credits: " + credits + "; " +
               "Grade: " + grade + ";";
    }
}