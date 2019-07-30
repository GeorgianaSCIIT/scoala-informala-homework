package ro.sciit.entities;
import java.util.Objects;

/**
 * @author Georgiana
 * the parent class
 */

public class Persoane {
    private String name;
    private int age;


    public Persoane(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoane)) return false;
        Persoane persoane = (Persoane) o;
        return age != persoane.age &&
                name.equals(persoane.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Persoane{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
