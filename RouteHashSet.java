public class RouteHashSet {
    private Route[] routeDepot;// an array of routes
    private int routeCount;// number of routes stored
    
    public RouteHashSet() {
        routeDepot = new Route[10];// array with 10 slots
        routeCount = 0;
    }
    
    // Hash using route ID
    private int hashValue(String routeId) {// converts routeId to array index
        int sum = 0;
        for (int i = 0; i < routeId.length(); i++) {
            sum += routeId.charAt(i);// add ASCII value of each character
        }
        return sum % routeDepot.length;// gives index from 0 to 9
    }
    
    // Add a route to the system
    public void addRoute(Route route) {
        if (routeCount >= routeDepot.length) {
            System.out.println("Route depot full!");
            return;
        }
        //gets routeId from route object
        String id = route.routeId;
        if (containsRoute(id)) {
            System.out.println("Route " + id + " already exists!");
            return;
        }
        
        int index = hashValue(id);
        while (routeDepot[index] != null) {
            System.out.println("Slot" + index + " taken, finding next slot");
            index = (index + 1) % routeDepot.length;
        }
        
        routeDepot[index] = route;
        routeCount++;
        System.out.println(" Route added: " + route);
    }
    
    // Check if route exists
    public boolean containsRoute(String routeId) {
        int startIndex = hashValue(routeId);
        int currentIndex = startIndex;
        
        do {
            if (routeDepot[currentIndex] != null && //check if slot has a route
                routeDepot[currentIndex].routeId.equals(routeId)) {//compare route IDs
                return true;
            }
            currentIndex = (currentIndex + 1) % routeDepot.length;//checks next slot
        } while (currentIndex != startIndex);//loop until back to start
        
        return false;
    }
    
    // Get route by ID
    public Route getRoute(String routeId) {
        int startIndex = hashValue(routeId);
        int currentIndex = startIndex;
        
        do {
            if (routeDepot[currentIndex] != null && //check if slot has a route
                routeDepot[currentIndex].routeId.equals(routeId)) {//compare route IDs
                return routeDepot[currentIndex];//return route object
            }
            currentIndex = (currentIndex + 1) % routeDepot.length;// checks next slot
        } while (currentIndex != startIndex);//loop until back to start
        
        return null;
    }
    
    // Display all routes
    public void displayAllRoutes() {
        System.out.println("\n ROUTE NETWORK");
        System.out.println("=" .repeat(50));
        for (int i = 0; i < routeDepot.length; i++) {
            if (routeDepot[i] != null) {
                System.out.println("Slot " + i + ": " + routeDepot[i]);
            } else {
                System.out.println("Slot " + i + ": [Available]");
            }
        }
        System.out.println("=" .repeat(50));
        System.out.println("Total routes: " + routeCount);
    }
    
    // Remove a route
    public boolean removeRoute(String routeId) {
        int startIndex = hashValue(routeId);
        int currentIndex = startIndex;
        
        do {
            if (routeDepot[currentIndex] != null && //check if slot has a route
                routeDepot[currentIndex].routeId.equals(routeId)) {//compare route IDs
                System.out.println("Removed route: " + routeDepot[currentIndex]);
                routeDepot[currentIndex] = null;//remove route from array
                routeCount--;//decrease route count
                return true;
            }
            currentIndex = (currentIndex + 1) % routeDepot.length;// checks next slot
        } while (currentIndex != startIndex);//loop until back to start
        
        System.out.println("Route " + routeId + " not found!");
        return false;
    }
    
    // Count routes
    public int getRouteCount() {
        return routeCount;
    }
    
    
}