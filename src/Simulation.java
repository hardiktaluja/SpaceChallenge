import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    ArrayList<Item> loadItems(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ArrayList<Item> items = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] itemNameAndWeight = line.split("=");
            Item item = new Item(itemNameAndWeight[0], Integer.parseInt(itemNameAndWeight[1]));
            items.add(item);
        }
        return items;
    }

    ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> u1s = new ArrayList<>();
        Rocket u1 = new U1();
        for (Item item : items) {
            if (u1.canCarry(item)) {
                u1.carry(item);
            } else {
                u1s.add(u1);
                u1 = new U1();
            }
        }
        return u1s;
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> u2s = new ArrayList<>();
        Rocket u2 = new U2();
        for (Item item : items) {
            if (u2.canCarry(item)) {
                u2.carry(item);
            } else {
                u2s.add(u2);
                u2 = new U2();
            }
        }
        return u2s;
    }

    double runSimulation(ArrayList<Rocket> rockets) {
        double totalBudget = 0;
        while (!rockets.isEmpty()) {
            Rocket rocket = rockets.get(0);
            totalBudget += rocket.cost;
            if (rocket.launch() && rocket.land()) {
                rockets.remove(rocket);
            }
        }
        return totalBudget;
    }

}
