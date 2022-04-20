import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int mesafe,yas,yolculukTipi;
        double normalTutar,yasIndirimi,indirimliTutar,biletIndirimi,yasIndirimOrani = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Gidilen mesafeyi giriniz (km cinsinden): ");
        mesafe = input.nextInt();
        System.out.println("Yaşınızı giriniz: ");
        yas = input.nextInt();
        System.out.println("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş): ");
        yolculukTipi = input.nextInt();
        
        if (mesafe <= 0 || yas <= 0 || yolculukTipi < 0 || yolculukTipi > 2) {
            System.out.println("BİR VEYA BİRDEN FAZLA HATALI VERİ GİRİŞİ !");
        }
        else{
            if (yas < 12) {
                yasIndirimOrani = 0.5;
            }
            if (12 <= yas && yas <= 24) {
                yasIndirimOrani = 0.1;
            }
            if (yas > 65) {
                yasIndirimOrani = 0.3;
            }
            normalTutar = mesafe * 0.10;
            yasIndirimi = normalTutar * yasIndirimOrani;
            indirimliTutar = normalTutar - yasIndirimi;
            if (yolculukTipi == 2) {
                biletIndirimi = indirimliTutar * 0.2;
                indirimliTutar = (indirimliTutar - biletIndirimi) * 2;
            }
            System.out.println("Toplam Tutar: " + indirimliTutar);
        }
    }
}
