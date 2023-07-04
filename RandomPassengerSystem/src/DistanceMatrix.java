import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class DistanceMatrix {
    Random r = new Random();
    public double[][] distanceMatrixCreator(int passengerCount) {
        double distanceMatrix[][] = new double[passengerCount][passengerCount];
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                double distance = 10.00 * r.nextDouble();
                distanceMatrix[i][j] = distance;
                distanceMatrix[j][i] = distance;
                distanceMatrix[i][i] = 0;
            }
        }
        return distanceMatrix;
    }

    public void seatingGenerator(double[][] distanceMatrix) {
        ArrayList<Double> distanceValues = new ArrayList<>();
        String nameList[] = new String[40];
        int counter = 0;
        int seatCounter = 5;
        int valueCounter = 0;
        double totalDistanceValue = 0;
        try {
            File passengerList = new File("PassengerNames.txt");
            Scanner scanner = new Scanner(passengerList);
            while (scanner.hasNextLine()) {
                String passengerName = scanner.nextLine();
                nameList[counter] = passengerName;
                counter++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("DOSYANIN YERİ YANLIŞ LÜTFEN TEKRAR KONTROL EDİNİZ!.");
            e.printStackTrace();
        }

        Passenger passengerMatrix[][] = new Passenger[10][4];
        int firstSeatNumber = r.nextInt(40);
        int seatedIndex[][] = new int[10][4];
        Passenger firstPassenger = new Passenger(nameList[firstSeatNumber], 1);
        distanceValues.add(0.0);
        seatedIndex[0][0] = firstSeatNumber;
        passengerMatrix[0][0] = firstPassenger;

        for (int i = 1; i < 4; i++) {
            double min = Double.MAX_VALUE;
            int header = 0;

            for (int j = 0; j < 40; j++) {
                if (min > distanceMatrix[firstSeatNumber][j] && distanceMatrix[firstSeatNumber][j] != 0) {
                    min = distanceMatrix[firstSeatNumber][j];
                    header = j;
                }
            }
            distanceValues.add(min);
            distanceMatrix[header][firstSeatNumber] = 0;
            firstSeatNumber = header;
            seatedIndex[0][i] = firstSeatNumber;
            Passenger nextPassenger = new Passenger(nameList[firstSeatNumber], i + 1);
            passengerMatrix[0][i] = nextPassenger;
        }

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 40; y++) {
                distanceMatrix[seatedIndex[0][x]][y] = 0;
            }
        }

        for (int k = 1; k < 10; k++) {
            int header2 = 0;
            double minVal0 = Double.MAX_VALUE;
            double minVal1 = Double.MAX_VALUE;
            double minVal2 = Double.MAX_VALUE;
            double minVal3 = Double.MAX_VALUE;
            double sumsOfDistances0 = 0;
            double sumsOfDistances1 = 0;
            double sumsOfDistances2 = 0;
            double sumsOfDistances3 = 0;


            for (int l = 0; l < 40; l++) {
                if (distanceMatrix[l][seatedIndex[k-1][0]] != 0 && distanceMatrix[l][seatedIndex[k-1][1]] != 0) {
                    sumsOfDistances0 = distanceMatrix[l][seatedIndex[k-1][0]] + distanceMatrix[l][seatedIndex[k-1][0]];
                }

                if (minVal0 > sumsOfDistances0 && distanceMatrix[l][seatedIndex[k-1][0]] != 0
                && distanceMatrix[l][seatedIndex[k-1][1]] != 0) {
                    minVal0 = distanceMatrix[l][seatedIndex[k-1][0]] + distanceMatrix[l][seatedIndex[k-1][1]];
                    header2 = l;
                }
            }
            distanceValues.add(sumsOfDistances0);
            firstSeatNumber = header2;
            seatedIndex[k][0] = firstSeatNumber;
            Passenger nextPassenger0 = new Passenger(nameList[firstSeatNumber], seatCounter);
            seatCounter++;
            passengerMatrix[k][0] = nextPassenger0;
            for (int y = 0; y < 40; y++) {
                distanceMatrix[seatedIndex[k][0]][y] = 0;
            }


            for (int l = 0; l < 40; l++) {
                if (distanceMatrix[l][seatedIndex[k-1][0]] != 0 && distanceMatrix[l][seatedIndex[k-1][1]] != 0
                        && distanceMatrix[l][seatedIndex[k-1][2]] != 0 && distanceMatrix[l][seatedIndex[k][0]] != 0) {
                    sumsOfDistances1 = distanceMatrix[l][seatedIndex[k-1][0]] + distanceMatrix[l][seatedIndex[k-1][0]]
                            + distanceMatrix[l][seatedIndex[k-1][0]] + distanceMatrix[l][seatedIndex[k][0]];
                }

                if (minVal1 > sumsOfDistances1 && distanceMatrix[l][seatedIndex[k-1][0]] != 0
                        && distanceMatrix[l][seatedIndex[k-1][1]] != 0 &&
                        distanceMatrix[l][seatedIndex[k-1][2]] != 0 && distanceMatrix[l][seatedIndex[k][0]] != 0) {
                    minVal1 = distanceMatrix[l][seatedIndex[k-1][0]] + distanceMatrix[l][seatedIndex[k-1][1]]
                            + distanceMatrix[l][seatedIndex[k-1][2]] + distanceMatrix[l][seatedIndex[k][0]];;
                    header2 = l;
                }
            }
            distanceValues.add(sumsOfDistances1);
            firstSeatNumber = header2;
            seatedIndex[k][1] = firstSeatNumber;
            Passenger nextPassenger1 = new Passenger(nameList[firstSeatNumber], seatCounter);
            seatCounter++;
            passengerMatrix[k][1] = nextPassenger1;
            for (int y = 0; y < 40; y++) {
                distanceMatrix[seatedIndex[k][1]][y] = 0;
            }


            for (int l = 0; l < 40; l++) {
                if (distanceMatrix[l][seatedIndex[k-1][1]] != 0 && distanceMatrix[l][seatedIndex[k-1][2]] != 0
                        && distanceMatrix[l][seatedIndex[k-1][3]] != 0 && distanceMatrix[l][seatedIndex[k][1]] != 0) {
                    sumsOfDistances2 = distanceMatrix[l][seatedIndex[k-1][0]] + distanceMatrix[l][seatedIndex[k-1][0]]
                            + distanceMatrix[l][seatedIndex[k][0]] + distanceMatrix[l][seatedIndex[k][0]];
                }

                if (minVal2 > sumsOfDistances2 && distanceMatrix[l][seatedIndex[k-1][1]] != 0
                        && distanceMatrix[l][seatedIndex[k-1][2]] != 0 &&
                        distanceMatrix[l][seatedIndex[k-1][3]] != 0 && distanceMatrix[l][seatedIndex[k][1]] != 0) {
                    minVal2 = distanceMatrix[l][seatedIndex[k-1][1]] + distanceMatrix[l][seatedIndex[k-1][2]]
                            + distanceMatrix[l][seatedIndex[k-1][3]] + distanceMatrix[l][seatedIndex[k][1]];;
                    header2 = l;
                }
            }
            distanceValues.add(sumsOfDistances2);
            firstSeatNumber = header2;
            seatedIndex[k][2] = firstSeatNumber;
            Passenger nextPassenger2 = new Passenger(nameList[firstSeatNumber], seatCounter);
            seatCounter++;
            passengerMatrix[k][2] = nextPassenger2;
            for (int y = 0; y < 40; y++) {
                distanceMatrix[seatedIndex[k][2]][y] = 0;
            }


            for (int l = 0; l < 40; l++) {
                if (distanceMatrix[l][seatedIndex[k-1][2]] != 0 && distanceMatrix[l][seatedIndex[k-1][3]] != 0
                        && distanceMatrix[l][seatedIndex[k][2]] != 0) {
                    sumsOfDistances3 = distanceMatrix[l][seatedIndex[k-1][0]] + distanceMatrix[l][seatedIndex[k-1][0]]
                            + distanceMatrix[l][seatedIndex[k][0]];
                }

                if (minVal3 > sumsOfDistances3 && distanceMatrix[l][seatedIndex[k-1][2]] != 0
                        && distanceMatrix[l][seatedIndex[k-1][3]] != 0 &&
                        distanceMatrix[l][seatedIndex[k][2]] != 0){
                    minVal3 = distanceMatrix[l][seatedIndex[k-1][2]] + distanceMatrix[l][seatedIndex[k-1][3]]
                            + distanceMatrix[l][seatedIndex[k][2]];
                    header2 = l;
                }
            }
            distanceValues.add(sumsOfDistances3);
            firstSeatNumber = header2;
            seatedIndex[k][3] = firstSeatNumber;
            Passenger nextPassenger3 = new Passenger(nameList[firstSeatNumber], seatCounter);
            seatCounter++;
            passengerMatrix[k][3] = nextPassenger3;
            for (int y = 0; y < 40; y++) {
                distanceMatrix[seatedIndex[k][3]][y] = 0;
            }
        }


        System.out.println("+------------------------------------------------------------------------------------+");
        for (int p = 0; p < 10; p++) {
            for (int m = 0; m < 4; m++) {
                System.out.println(passengerMatrix[p][m]+" ------> "+"Distance Value: "+String.format("%.3f",distanceValues.get(valueCounter)));
                valueCounter++;
            }
            System.out.println("+------------------------------------------------------------------------------------+");
        }
        for (int u = 0; u < 40; u++) {
            totalDistanceValue += distanceValues.get(u);
        }
        System.out.println("Sum of all distance: "+String.format("%.3f",totalDistanceValue));
        System.out.println("--------------------------------");
    }
}


