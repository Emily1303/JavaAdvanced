package shelter;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Shelter {

    private String name;
    private int age;
    private String caretaker;
    private int capacity;
    private List<Animal> data;

    public String getName() {
        return this.name = name;
    }

    public int getCapacity() {
        return this.capacity = capacity;
    }

    public List<Animal> getData() {
       return this.data = data;
    }

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < getCapacity()) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < getData().size(); i++) {
            String currentName = getData().get(i).getName();
            if (currentName.equals(name)) {
                getData().remove(i);
                return true;
            }
        }

        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (int i = 0; i < getData().size(); i++) {
            if (getData().get(i).getName().equals(name) && getData().get(i).getCaretaker().equals(caretaker)) {
                return getData().get(i);
            }
        }

        return null;
    }

    public Animal getOldestAnimal() {
        int maxAge = Integer.MIN_VALUE;
        Animal max = null;
        for (int i = 0; i < getData().size(); i++) {
            if (getData().get(i).getAge() > maxAge) {
                maxAge = getData().get(i).getAge();
                max = getData().get(i);
            }
        }

        return max;
    }

    public int getCount() {
        return getData().size();
    }

    public String getStatistics() {

        for (int i = 0; i < getData().size(); i++) {
            String output = String.format("The shelter has the following animals:%n%s %s%n",
                    getData().get(i).getName(), getData().get(i).getCaretaker());
            return output;
        }

        return null;
    }
}
