public class Bus { //creates a class named Bus
    public String licensePlate;  // Changed to public for simplicity
    public int capacity;//passenger capacity
    public String route;
    
    public Bus(String licensePlate, int capacity, String route) {//constructor
        this.licensePlate = licensePlate;
        this.capacity = capacity;
        this.route = route;
    }
    
    public String toString() {//whenever bus is printed it gets printed in this format
        return licensePlate + " (Route: " + route + ", Seats: " + capacity + ")";
    }
}