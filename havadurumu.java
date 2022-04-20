import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sicaklik;
        Scanner input = new Scanner(System.in);
        System.out.println("Havanın sıcaklığını giriniz: ");
        sicaklik = input.nextInt();

        if (sicaklik < 5) {
            System.out.println("Kayak yapmanız önerilmektedir.");
        }
        else if (5 <= sicaklik && sicaklik <= 25) {
            if (sicaklik <= 15) {
                System.out.println("Sinemaya gitmeniz önerilmektedir.");
            }
            if (sicaklik >= 15) {
                System.out.println("Pikniğe gitmeniz önerilmektedir");
            }
        }
        else if (sicaklik > 25) {
            System.out.println("Yüzmeye gitmeniz önerilmektedir");
        }
    }
}

