//Adrian Shayesteh Dar adsh9563

import java.util.ArrayList;

public class Owner implements Comparable<Owner> {
    private String name;
    private ArrayList<Dog> dogs;

    public Owner(String name) {
        this.name = name;
        this.dogs = new ArrayList<>();
    }

    public String getName() {
        return name.toUpperCase();
    }

    public String toString() {
        String allDogs = "";
        for (int i = 0; i < dogs.size(); i++) {
            allDogs = allDogs + dogs.get(i).getName() + " ";
        }
        return name + " " + allDogs;
    }

    public int compareTo(Owner other) {
        return this.getName().compareToIgnoreCase(other.getName());
    }

    public boolean addDog(Dog dog) {
        if (dogs.contains(dog)) {
            return false;
        }
        if (dog.getOwner() == this) {
            dogs.add(dog);
            return true;
        }

        return false;
    }


    public boolean removeDog(Dog dog) {
        if (dogs.contains(dog)) {
            dogs.remove(dog);
            dog.setOwner(null);
            return true;
        }
        return false;
    }


    public ArrayList<Dog> getDogs() {
        ArrayList<Dog> dogsCopy = new ArrayList<>(dogs);
        DogNameComparator dogNameComparator = new DogNameComparator();
        DogSorter.sortDogs(dogNameComparator, dogsCopy);
        return dogsCopy;
    }
}