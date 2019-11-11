import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Simulation simulation = new Simulation();
        ArrayList<Item> phase1Items = simulation.loadItems("phase-1.txt");
        ArrayList<Item> phase2Items = simulation.loadItems("phase-2.txt");
        
        ArrayList<Rocket> u1Phase1 = simulation.loadU1(phase1Items);
        ArrayList<Rocket> u1Phase2 = simulation.loadU1(phase2Items);
        System.out.println("Total budget required for U1 rockets for phase1: $" + simulation.runSimulation(u1Phase1) +
                " Million and phase2: $" + simulation.runSimulation(u1Phase2) + " Million");

        ArrayList<Rocket> u2Phase1 = simulation.loadU2(phase1Items);
        ArrayList<Rocket> u2Phase2 = simulation.loadU2(phase2Items);
        System.out.println("Total budget required for U2 rockets for phase1: $" + simulation.runSimulation(u2Phase1) +
                " Million and phase2: $" + simulation.runSimulation(u2Phase2) + " Million");
    }

}
