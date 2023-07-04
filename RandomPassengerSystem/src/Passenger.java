public class Passenger {
    String name;
    int seatNumber;

    public Passenger(String name, int seatNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString(){
    return "Name Surname: " + name +" ------>"+" Seat Number: " + seatNumber ;
    }
}
