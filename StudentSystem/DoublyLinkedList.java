package pkg05210000272_05210000216;


public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void ogrencileriSirala(Student student) {
        //Öğrencileri önce listeye ekleyip daha sonra o numara sırasına koyacak şekilde bir metod yazdık.
        Node newNode = new Node(student);

        newNode.data = student.getOgrenciNo();
        newNode.data1 = student.getAdSoyad();
        newNode.student = student;

        Node ptr = head;        

        if (ptr == null) {
            head = newNode;
            
        } else if (ptr.data > newNode.data) {
            //Bu kısımda öğrencinin öğrenci numarasını kıyaslıyor ve uygun yere yerleştiriyor.
            newNode.next = ptr;
            ptr.prev = newNode;
            head = newNode;

        } else {
            Node next = head.next;
            //Bu kısımda öğrencinin öğrenci numarasını kıyaslıyor ve uygun yere yerleştiriyor.
            while (next != null && next.data <= newNode.data) {
                ptr = next;
                next = next.next;
            }
            
            ptr.next = newNode;
            newNode.prev = ptr;

            if (next != null) {
                next.prev = newNode;
                newNode.next = next;
            }
        }
    }
   
    public void ogrenciBul(String adSoyad) {
        //Öğrencinin adını soyadını kullanıcıdan alan ve ekrana yazdıran metod.
        Node current = head;

        while (current != null) {
            if(current.data1.equals(" "+adSoyad) || current.data1.equals(adSoyad)) {
                //Eğer girilen ad soyad eşitse o ad soyada sahip olan kişi/kişileri yazdırıyor.
                System.out.print(current.getBilgiler() + "\n");
            }
            current = current.next;
        }
    }
    
    public void listedenOgrenciSil(int ogrenciNo) {
        //Numarası girilen öğrenciyi listeden silen metod
        Node current = head;

        while (current != null) {
            if (current.getNext() == null || head.getNext() == null) {
                //Eğer böyle bir öğrenci yoksa işlem yapmaması için.
                break;
            } else if (head.getBilgiler().getOgrenciNo() == ogrenciNo) {
                head = head.getNext();

            } else if (current.getNext().getBilgiler()==null || current.getNext().getBilgiler().getOgrenciNo() == ogrenciNo) {
                current.setNext(current.getNext().getNext());

            } else {
                current = current.getNext();
            }
        }
    }
    
    public void listeyiGosterKB() {
        //Tüm listeyi olduğu sırada (küçükten büyüğe) yazdıran metod.
        Node current = head;

        if (head == null) {
            //Listenin boş olduğunu bildirmesi için.
            System.out.println("LİSTE BOŞ LÜTFEN TEKRAR KONTROL EDİNİZ!");
        }
        while (current != null) {
            System.out.print(current.student + "\n");
            current = current.next;
        }
    }
    
    public void listeyiGosterBK(Node head) {
        //Tüm listeyi ters çeviriyor fakat listenin kendisini değiştirmeden.
        if (head == null) {
            return;
        }
        listeyiGosterBK(head.next);
        System.out.print(head.student + "\n");       
    }
}
