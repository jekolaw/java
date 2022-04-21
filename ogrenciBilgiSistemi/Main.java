public class Main {
    public static void main(String[] args) {
        Course Matematik = new Course("Matematik", "MAT101", "MAT");
        Course Fizik = new Course("Fizik", "FİZ101", "FİZ");
        Course Kimya = new Course("Kimya", "KİM101", "KİM");

        Teacher teacher1 = new Teacher("Mahmut Hoca", "90550000000", "MAT");
        Teacher teacher2 = new Teacher("Fatma Ayşe", "90550000001", "FİZ");
        Teacher teacher3 = new Teacher("Ali Veli", "90550000002", "KİM");

        Matematik.addTeacher(teacher1);
        Fizik.addTeacher(teacher2);
        Kimya.addTeacher(teacher3);

        Student student1 = new Student("İnek Şaban", 4, "140144015", Matematik, Fizik, Kimya);
        student1.addBulkExamNote(50,20,40);
        student1.isPass();

        Student student2 = new Student("Güdük Necmi", 4, "2211133", Matematik, Fizik, Kimya);
        student2.addBulkExamNote(100,50,40);
        student2.isPass();

        Student student3 = new Student("Hayta İsmail", 4, "221121312", Matematik, Fizik, Kimya);
        student3.addBulkExamNote(50,20,40);
        student3.isPass();
    }
}
