//Adrian Shayesteh Dar adsh9563

import java.util.ArrayList;
import java.util.Comparator;

public class DogSorter {
    private static void swapDogs(ArrayList<Dog> dogsList, int firstIndex, int secondIndex) {
        Dog firstDog = dogsList.get(firstIndex);
        Dog secondDog = dogsList.get(secondIndex);

        dogsList.set(firstIndex, secondDog);
        dogsList.set(secondIndex, firstDog);
    }

    private static int nextDog(Comparator<Dog> comparator, ArrayList<Dog> dogsList, int startIndex) {

        for (int i = startIndex; i < dogsList.size(); i++) {
            if (comparator.compare(dogsList.get(i), dogsList.get(startIndex)) < 0) {
                startIndex = i;
            }
        }
        return startIndex;
    }

    public static int sortDogs(Comparator<Dog> comparator, ArrayList<Dog> dogsList) {

        int amountOfSwaps = 0;


        for (int i = 0; i < dogsList.size(); i++) {
            int indexOfMin = nextDog(comparator, dogsList, i);

            if (indexOfMin != i) {
                swapDogs(dogsList, i, indexOfMin);
                amountOfSwaps++;
            }
        }

        return amountOfSwaps;
    }
}