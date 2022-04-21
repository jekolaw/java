public class Course {
    Teacher teacher = new Teacher("","","");
    String name;
    String code;
    String prefix;
    int note;

    public Course(String name, String code, String prefix){
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = 0;
    }

    public void addTeacher(Teacher teacher) {
        if(this.prefix.equals(teacher.branch)) {
            this.teacher = teacher;
            printTeacher();
        }
        else {
            System.out.println("Dersin öğretmeni yanlıştır!");
        }
    }

    public void printTeacher() {
        if(teacher != null) {
            System.out.println(this.name + " dersinin öğretmeni: " + teacher.name);
        }
        else{
            System.out.println(this.name + "dersine öğretmen atanmamıştır.");
        }

    }
}
