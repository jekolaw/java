package pkg05210000272_05210000216;


public class Node {   
    Node next;
    Node prev;
    Student student;
    int data; //Öğrenci numarası için.
    String data1; //Ad soyad için.

    public Node(Student Student)
    {
        this.student = Student;
    }

    public void setBilgiler(Student bilgiler) {
        this.student = bilgiler;
    }

    public void setNext(Node node) {
        next = node;
    }

    public void setPrev(Node node) {
        prev = node;
    }

    public Student getBilgiler() {
        return student;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }    
}