package shelter;

public class Animal {

    private String name;
    private int age;
    private String caretaker;

    public Animal(String name, int age, String caretaker) {
        this.name = name;
        this.age = age;
        this.caretaker = caretaker;
    }

    public String getName() {
        return this.name = name;
    }

    public int getAge() {
        return this.age = age;
    }

    public String getCaretaker() {
        return this.caretaker = caretaker;
    }

    @Override
    public String toString() {

        return String.format("%s %d (%s)", getName(), getAge(), getCaretaker());
    }
}
