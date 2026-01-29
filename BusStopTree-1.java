import java.util.ArrayList;
import java.util.List;

// Tree node class
class BusStop {
    String name;
    List<BusStop> children;

    // Constructor
    BusStop(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    // Add child bus stop
    void addChild(BusStop stop) {
        children.add(stop);
    }

    // Display tree hierarchy
    void display(String indent) {
        System.out.println(indent + name);
        for (BusStop child : children) {
            child.display(indent + "  ");
        }
    }
}

public class BusStopTree {
    public static void main(String[] args) {

        // Creating bus stops
        BusStop right = new BusStop("Right");
        BusStop gate = new BusStop("Gate");
        BusStop kwaChief = new BusStop("Kwa Chief");
        BusStop nakuruTown = new BusStop("Nakuru Town");

        // Building hierarchy
        right.addChild(gate);
        gate.addChild(kwaChief);
        kwaChief.addChild(nakuruTown);

        // Display the tree
        System.out.println("Bus Stop Hierarchy:");
        right.display("");
    }
}
