public class Main {
    public static void main(String args[]) {
        DistanceMatrix deneme1 = new DistanceMatrix();
        deneme1.seatingGenerator(deneme1.distanceMatrixCreator(40));
        System.out.println(deneme1);
    }
}
