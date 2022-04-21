public class Student {
    String name,stuNo;
    int classes;
    Course Matematik;
    Course Fizik;
    Course Kimya;
    double average;
    boolean isPass;

    public Student(String name, int classes, String stuNo, Course Matematik,Course Fizik,Course Kimya){
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.Matematik = Matematik;
        this.Fizik = Fizik;
        this.Kimya = Kimya;
        this.isPass = false;
    }
    public void addBulkExamNote(int Matematik, int Fizik, int Kimya) {
        if(Matematik >= 0 && Matematik <= 100){
            this.Matematik.note = Matematik;
        }
        if(Fizik >= 0 && Fizik <= 100){
            this.Fizik.note = Fizik;
        }
        if(Kimya >= 0 && Kimya <= 100){
            this.Kimya.note = Kimya;
        }
    }

    public boolean isPassCheck() {
        calcAverage();
        return this.average > 55;
    }

    public void isPass() {
        if (this.Matematik.note == 0 || this.Fizik.note == 0 || this.Kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        }
        else {
            this.isPass = isPassCheck();
            printNote();
            System.out.println("Ortalaması: "+this.average);
            if (this.isPass) {
                System.out.println("Sınıfı geçti!");
            }
            else {
                System.out.println("Sınıfta kaldı!");
            }
        }
    }
    public void calcAverage() {
        this.average = (this.Fizik.note + this.Kimya.note + this.Matematik.note) / 3;
    }

    public void printNote() {
        System.out.println("=========================");
        System.out.println("Öğrenci: " + this.name);
        System.out.println("Matematik notu: " + this.Matematik.note);
        System.out.println("Fizik notu: " + this.Fizik.note);
        System.out.println("Kimya notu: " + this.Kimya.note);
    }
}
