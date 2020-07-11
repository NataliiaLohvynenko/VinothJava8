package toequals;


import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        String string1 = "Hello";
        String string2 = "Hello";

      //  System.out.println(string1.equals(string2));

        System.out.println(string1.length());
    }




}

class Animal{
    private int id;

    public Animal(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

