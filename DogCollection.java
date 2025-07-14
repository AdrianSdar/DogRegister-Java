//Adrian Shayesteh Dar adsh9563

import java.util.ArrayList;

public class DogCollection {
    private ArrayList<Dog> dogs = new ArrayList<>();

    public boolean addDog(Dog newDog) {
        for (Dog dog : dogs) {
            if (dog.getName().equalsIgnoreCase(newDog.getName())) {
                return false;
            }
        }
        dogs.add(newDog);
        return true;
    }

    public boolean removeDog(String dogName) {
        for (Dog dog : dogs) {
            if (dog.getName().equalsIgnoreCase(dogName)) {
                if (dog.getOwner() != null) {
                    return false;
                }
                dogs.remove(dog);
                return true;
            }
        }
        return false;
    }

    public boolean removeDog(Dog dog) {
        if (dogs.contains(dog)) {
            if (dog.getOwner() != null) {
                return false;
            }
            dogs.remove(dog);
            return true;
        }
        return false;
    }

    public boolean containsDog(String dogName) {
        for (Dog dog : dogs) {
            if (dog.getName().equalsIgnoreCase(dogName)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDog(Dog dog) {
        return dogs.contains(dog);
    }

    public Dog getDog(String dogName) {
        for (Dog dog : dogs) {
            if (dog.getName().equalsIgnoreCase(dogName)) {
                return dog;
            }
        }
        return null;
    }

    public ArrayList<Dog> getDogs() {
        ArrayList<Dog> dogsCopy = new ArrayList<>(dogs);
        DogSorter.sortDogs(new DogNameComparator(), dogsCopy);
        return dogsCopy;
    }

    public ArrayList<Dog> getDogsWithTailNewName(double minTailLength) {
        ArrayList<Dog> dogsTail = new ArrayList<>();

        for (Dog dog : dogs) {
            if (dog.getTailLength() >= minTailLength) {
                dogsTail.add(dog);
            }
        }
        DogSorter.sortDogs(new DogTailNameComparator(), dogsTail);
        return dogsTail;
    }
}