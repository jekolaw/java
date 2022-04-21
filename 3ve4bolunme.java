import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sayi,toplam = 0,sayac = 0;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Sayıyı giriniz: ");
        sayi = input.nextInt();

        for (int i=1; i<=sayi; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                toplam += i;
                sayac ++;
            }
            if (i == sayi)
                break;
        }

        if (sayac > 0){
            toplam = toplam / sayac;
            System.out.println("Girdiğiniz sayıya kadar olan sayılardan 3 ve 4'e bölünen sayıların ortalaması: "+toplam);
        }
        else{
            System.out.println("Bu aralıkta 3 ve 4'e bölünen sayı bulunmamaktadır");
        }
    }
}
