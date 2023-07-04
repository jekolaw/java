package pkg05210000272_05210000216;
import java.util.ArrayList;


public class Student {
    private String adSoyad;
    private int ogrenciNo;
    private String telefonNo;
    private ArrayList<String> telefonNumaralari; //Telefon numaralari için ArrayList.
    
    public Student() {
        adSoyad = null;
        ogrenciNo = 0;
        telefonNo = null;
        telefonNumaralari = new ArrayList<>();
    }
    
    public Student(int ogrenciNo,String adSoyad,String telefonNo){
        this.adSoyad = adSoyad;
        this.ogrenciNo = ogrenciNo;
        this.telefonNo = telefonNo;
    }
    
    public Student(Student student){
        this.adSoyad = student.adSoyad;
        this.ogrenciNo = student.ogrenciNo;
        this.telefonNo = student.telefonNo;
    }
    
        public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public ArrayList<String> getTelefonNumaralari() {
        return telefonNumaralari;
    }

    @Override
    public String toString() {
        return (ogrenciNo+","+adSoyad+","+telefonNo);
    }
}