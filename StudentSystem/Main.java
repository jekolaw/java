package pkg05210000272_05210000216;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        DoublyLinkedList ogrenciListesi = new DoublyLinkedList();
                
        //Öğrencinin bilgileri için 4 tane farklı input oluşturdum(adSoyad,öğrenciNo,telNo)
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        
        System.out.println("Text dosyasından okuma yapmak için '1' yazınız.");
        System.out.println("Öğrenci girmek için '2' yazınız.");
        System.out.println("İstediğiniz öğrencinin bilgilerini yazdırmak için '3' yazınız.");
        System.out.println("Öğrenci silmek için '4' yazınız.");
        System.out.println("Öğrencileri artan sırada (küçük öğrenci numarasından büyük öğrenci numarasına) "
                + "yazdırmak için '5' yazınız.");
        System.out.println("Öğrencileri azalan sırada (büyük öğrenci numarasından küçük öğrenci numarasına) "
                + "yazdırmak için '6' yazınız.");
        System.out.println("Programdan çıkmak için '7' yazınız.");
        
        System.out.println("\n"+"Lütfen yapmak istediğiniz işlemi giriniz:");
        int girilenNumara = input.nextInt();
        System.out.println("\n");
        
        //Menüden bilgi seçebilmesi için switch-case yapısını kullandım.    
        while (1 <= girilenNumara && girilenNumara <= 6) {            
            switch(girilenNumara){
                case (1):
                    System.out.println("-----------------------------------");
                    System.out.println("DOSYADAN ÖĞRENCİ EKLEMEYİ SEÇTİNİZ!");
                    System.out.println("İŞLEM BAŞARILI!");
                    System.out.println("-----------------------------------");
                    
                    //ALT TARAFI DOSYAYI OLUŞTURDUĞUM YERDEN OKUMASI İÇİN BÖYLE YAZDIM KİŞİ KENDİ DOSYA YERİNE GÖRE DEĞİŞTİRMELİ.
                    File file = new File("C:\\Users\\merta\\OneDrive\\Masaüstü\\ogrenciler.txt");
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String satir;                  
                    
                    while ((satir = br.readLine()) != null) {
                                                                   
                        Student myObj = new Student();
                        //Text dosyasındaki öğrencilerden object yaratıp listeye eklemesi için. 
                        
                        ArrayList<String> myObjArray = myObj.getTelefonNumaralari();
                        //Birden fazla telefon numarası için ArrayList kullandık.
                        
                        String[] bilgiler = satir.split(",");
                        //Text dosyasındaki bilgileri ekleyebilmesi için. Her virgül yeni bir data'ya denk.(NUMARA , ADSOYAD ,TELNO gibi)
                        
                        for(int i=2;i < bilgiler.length;i++) {
                            //Telefon numarasını ArrayListe ekleyebilmesi için.
                            myObjArray.add(bilgiler[i]);
                        }
                        
                        Student ogrencilerDosyasi = new Student(0, null, null);
                        //Text dosyasındaki öğrencileri tekrar tekrar ekleyebilmesi için.
                        
                        ogrencilerDosyasi.setOgrenciNo(Integer.parseInt(bilgiler[0]));
                        //Öğrencinin numarasını belirliyor.(Text dosyasından okuyarak.)   
                        ogrencilerDosyasi.setAdSoyad(bilgiler[1]);
                        //Öğrencinin adını soyadını belirliyor.(Text dosyasından okuyarak.)                        
                        String telno = String.join(",", myObjArray);     
                        //Öğrencinin telefon numarasını virgülle ayırması için. (1'den fazla olduğu durumlar için.)
                        ogrencilerDosyasi.setTelefonNo(telno);
                        //Öğrencinin telefon numarasını belirliyor.(Text dosyasından okuyarak.)   
                        ogrenciListesi.ogrencileriSirala(ogrencilerDosyasi);
                        //Öğrencileri listeye sıralayıp ekliyor.
                    }
                    break;
                
                case (2):
                    System.out.println("---------------------------------------------");
                    System.out.println("KLAVYEDEN ÖĞRENCİ EKLEMEYİ SEÇTİNİZ!");
                    System.out.println();                                               
                    Student student1 = new Student(0, null, null);
                    System.out.println("Öğrencinin numarasını giriniz: ");
                    int ogrenciNosu = input1.nextInt();
                    student1.setOgrenciNo(ogrenciNosu);
                    
                    System.out.println("Öğrencinin adını ve soyadını giriniz: ");                  
                    String adiSoyadi = input2.nextLine();
                    student1.setAdSoyad(adiSoyadi);
                    
                    System.out.println("Telefonunu/Telefonlarını giriniz(1'den fazlaysa boşluk bırakınız): ");
                    String telefonNosu = input3.nextLine();
                    student1.setTelefonNo(telefonNosu);
                    System.out.println("---------------------------------------------");   
                    
                    ogrenciListesi.ogrencileriSirala(student1);
                    break;
                    
                case (3):
                    System.out.println("---------------------------------------------");
                    System.out.println("ADINA VE SOYADINA GÖRE "
                            + "ÖĞRENCİ/ÖĞRENCİLERİN BİLGİLERİNİ GETİRMEYİ SEÇTİNİZ!");
                    System.out.println();  
                    System.out.println("Öğrencinin adını ve soyadını giriniz: ");                    
                    adiSoyadi = input2.nextLine();
                    System.out.println("---------------------------------------------");
                    ogrenciListesi.ogrenciBul(adiSoyadi);
                    System.out.println("---------------------------------------------");
                    break;
                    
                case (4):
                    System.out.println("---------------------------------------------");
                    System.out.println("NUMARASI GİRİLEN ÖĞRENCİYİ SİLMEYİ SEÇTİNİZ!");
                    System.out.println();
                    System.out.println("Öğrencinin numarasını: ");
                    ogrenciNosu = input1.nextInt();
                    System.out.println("---------------------------------------------");
                    ogrenciListesi.listedenOgrenciSil(ogrenciNosu);
                    break;
                
                case (5):
                    System.out.println("---------------------------------------------");
                    System.out.println("ÖĞRENCİLERİ KÜÇÜK NUMARADAN BÜYÜK NUMARAYA "
                            + "YAZDIRMAYI SEÇTİNİZ!");
                    System.out.println();
                    ogrenciListesi.listeyiGosterKB();
                    System.out.println("---------------------------------------------");
                    break;
                    
                case (6):
                    System.out.println("---------------------------------------------");
                    System.out.println("ÖĞRENCİLERİ BÜYÜK NUMARADAN KÜÇÜK NUMARAYA "
                            + "YAZDIRMAYI SEÇTİNİZ!");
                    System.out.println();
                    ogrenciListesi.listeyiGosterBK(ogrenciListesi.head);
                    System.out.println("---------------------------------------------");
                            
            }
            System.out.println("Dosyadan Okuma '1' / Öğrenci Ekleme '2' / Öğrencinin Bilgilerini Yazdırma '3'/"
                    + "\nÖğrenci Silme '4' / Numaraya Göre Küçükten Büyüğe Yazdırma '5' / Büyükten Küçüğe"
                    + " Yazdırma '6'/ ");
            System.out.println("Lütfen yapmak istediğiniz işlemi giriniz (ÇIKMAK İÇİN 7 YAZINIZ): "+"\n");           
            girilenNumara = input.nextInt();
            if (girilenNumara == 7) {             
                break;
            }            
        }
    }   
}
