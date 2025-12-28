public class Route {//creates class Route
    public String routeId;      
    public String routeName;
    public int totalStops;
    
    public Route(String routeId, String routeName, int totalStops) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.totalStops = totalStops;
    }
    
    public String toString() {//format for printing route details
        return routeId + " - " + routeName + " (" + totalStops + " stops)";
    }
}