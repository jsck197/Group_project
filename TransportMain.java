public class TransportMain {
    public static void main(String[] args) {
        System.out.println("=== INTEGRATED TRANSPORT SYSTEM ===");
        System.out.println("=" .repeat(40));
        
        // Create the two hash sets
        BusHashSet busSystem = new BusHashSet();
        RouteHashSet routeSystem = new RouteHashSet();
        
        // Add some buses
        System.out.println("\n--- ADDING BUSES ---");
        busSystem.addBus(new Bus("KAA123A", 45, "R101"));//Create & add bus
        busSystem.addBus(new Bus("KBB456B", 52, "R202"));
        busSystem.addBus(new Bus("KCC789C", 38, "R303"));
        busSystem.addBus(new Bus("KAA123A", 50, "R404")); // duplicate 
        
        // Add some routes
        System.out.println("\n--- ADDING ROUTES ---");
        routeSystem.addRoute(new Route("R101", "Nairobi to Mombasa", 15));//Create & add route
        routeSystem.addRoute(new Route("R202", "Nakuru CBD to WhiteHouse", 8));
        routeSystem.addRoute(new Route("R303", "Nakuru CBD to Egerton University", 20));
        routeSystem.addRoute(new Route("R101", "Nairobi CBD to Nakuru CBD", 10)); // duplicate
        
        // Display everything
        System.out.println("\n--- SYSTEM STATUS ---");
        busSystem.displayGarage();
        routeSystem.displayAllRoutes();
        
        // Show summary
        System.out.println("\n SYSTEM SUMMARY:");
        System.out.println("Total Buses: " + busSystem.getBusCount());
        System.out.println("Total Routes: " + routeSystem.getRouteCount());
        
        // Test searching
        System.out.println("\n--- SEARCH TESTS ---");
        Bus myBus = busSystem.getBus("KBB456B");
        if (myBus != null) {
            System.out.println("Found bus: " + myBus);
        }

        Route myRoute = routeSystem.getRoute("R202");
        if (myRoute != null) {
            System.out.println("Found route: " + myRoute);
        }
        
        // Test removal
        System.out.println("\n--- REMOVAL TESTS ---");
        busSystem.removeBus("KCC789C");
        routeSystem.removeRoute("R303");
        
        // Final display
        System.out.println("\n--- FINAL STATUS ---");
        busSystem.displayGarage();
        routeSystem.displayAllRoutes();
        System.out.println("\nFinal counts:");
        System.out.println("Buses: " + busSystem.getBusCount());
        System.out.println("Routes: " + routeSystem.getRouteCount());
    }
}