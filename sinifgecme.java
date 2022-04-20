import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int mat,fiz,turkce,kim,muzik;
        double total,ortalama;
        Scanner input = new Scanner(System.in);

        System.out.println("Matematik notunuzu giriniz: ");
        mat = input.nextInt();
        if (mat < 0 || mat > 100) {
            mat = 0;
        }

        System.out.println("Fizik notunuzu giriniz: ");
        fiz = input.nextInt();
        if (fiz < 0 || fiz > 100) {
            fiz = 0;
        }

        System.out.println("Türkçe notunuzu giriniz: ");
        turkce = input.nextInt();
        if (turkce < 0 || turkce > 100) {
            turkce = 0;
        }

        System.out.println("Kimya notunuzu giriniz: ");
        kim = input.nextInt();
        if (kim < 0 || kim > 100) {
            kim = 0;
        }

        System.out.println("Müzik notunuzu giriniz: ");
        muzik = input.nextInt();
        if (muzik < 0 || muzik > 100) {
            muzik = 0;
        }

        total = mat+fiz+kim+turkce+muzik;
        ortalama = total / 5;
        if (ortalama >= 55) {
            System.out.println("Tebriker sınıfı geçtiniz! Ortalamanız: "+ortalama);
        }
        else {
            System.out.println("Maalesef sınıfta kaldınız! Ortalamanız: "+ortalama);
        }
    }
}

