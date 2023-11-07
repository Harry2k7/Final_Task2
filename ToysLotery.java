import java.util.ArrayList;
import java.util.Random;

public class ToysLotery {
    private ArrayList<Toy> toys;

    public ToysLotery(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    public Toy getRandomToy() {
        double totalFrequency = toys.stream().mapToDouble(Toy::getFrequency).sum();
        double randomValue = new Random().nextDouble() * totalFrequency;
        double cumulativeFrequency = 0.0;

        for (Toy toy : toys) {
            cumulativeFrequency += toy.getFrequency();
            if (randomValue <= cumulativeFrequency) {
                return toy;
            }
        }
        return null;
    }
}
