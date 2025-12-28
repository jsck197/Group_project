public class BusHashSet {
    private Bus[] garage;//array that stores Bus objects
    private int busCount;//coiunts the number of buses
    
    public BusHashSet() {
        garage = new Bus[10];//creates array with 10 slots
        busCount = 0;
    }
    
    // Hash using license plate only
    private int hashValue(String licensePlate) { //converts plate to array index 
        int sum = 0;
        for (int i = 0; i < licensePlate.length(); i++) {
            sum += licensePlate.charAt(i);//add asciivalue of each character
        }
        return sum % garage.length;//gives index from 0 to 9
    }
    
    // Add a bus object
    public void addBus(Bus bus) {
        if (busCount >= garage.length) {//checks if garage is full
            System.out.println("Garage full!");
            return;
        }
        
        String license = bus.licensePlate;
        if (containsBus(license)) {//check if bus already exists
            System.out.println("Bus " + license + " already registered!");
            return;
        }
        
        int index = hashValue(license);//calculate where to store the bus
        while (garage[index] != null) {//if the slot is taken, check the next slot
            index = (index + 1) % garage.length;
        }
        
        garage[index] = bus;//store bus in the array
        busCount++;//increase the bus count
        System.out.println("Registered: " + bus);
    }
    
    // Check if bus exists by license plate
    public boolean containsBus(String licensePlate) {
        int startIndex = hashValue(licensePlate);
        int currentIndex = startIndex;
        
        do {
            if (garage[currentIndex] != null && //check if slot has a bus
                garage[currentIndex].licensePlate.equals(licensePlate)) {//compare license plates
                return true;
            }
            currentIndex = (currentIndex + 1) % garage.length;//checks next slot
        } while (currentIndex != startIndex);//loop until back to start
        
        return false;
    }
    
    // Get bus by license plate
    public Bus getBus(String licensePlate) {//returns bus object
        int startIndex = hashValue(licensePlate);
        int currentIndex = startIndex;
        
        do {
            if (garage[currentIndex] != null && //check if slot has a bus
                garage[currentIndex].licensePlate.equals(licensePlate)) {//compare license plates
                return garage[currentIndex];
            }
            currentIndex = (currentIndex + 1) % garage.length;
        } while (currentIndex != startIndex);//loop until back to start
        
        return null;//no bus found
    }
    
    // Display all buses with their spots
    public void displayGarage() {
        System.out.println("\n BUS GARAGE");
        System.out.println("=" .repeat(50));
        for (int i = 0; i < garage.length; i++) {
            if (garage[i] != null) {
                System.out.println("Spot " + i + ": " + garage[i]);//prints bus at that spot
            }
            else {
                System.out.println("Spot " + i + ": [Available]");
            }
        }
        System.out.println("=" .repeat(50));
        System.out.println("Total: " + busCount + " buses");
    }
    
    // Get bus count method
    public int getBusCount() {
        return busCount;
    }
    
    // Remove a bus
    public boolean removeBus(String licensePlate) {
        int startIndex = hashValue(licensePlate);
        int currentIndex = startIndex;
        
        do {
            if (garage[currentIndex] != null && //check if slot has a bus
                garage[currentIndex].licensePlate.equals(licensePlate)) {//compare license plates
                System.out.println("Removed bus: " + garage[currentIndex]);
                garage[currentIndex] = null;//remove bus from array
                busCount--;//decrease bus count
                return true;
            }
            currentIndex = (currentIndex + 1) % garage.length;
        } while (currentIndex != startIndex);
        
        System.out.println("Bus " + licensePlate + " not found!");
        return false;
    }
    
    
}