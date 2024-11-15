package lec10;

import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    public static class NameComparator implements Comparator<Dog> {
        public int compare(Dog d1, Dog d2) {
            return d1.name.compareTo(d2.name);
        }
    }

    /** Returns negative number if this dog is less than the dog pointed at by o, and so forth. */
    public int compareTo(Dog uddaDog) {
        return this.size - uddaDog.size;
    }


    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }


}