//Adrian Shayesteh Dar adsh9563

import java.util.Comparator;

public class DogTailNameComparator implements Comparator<Dog> {
    public int compare(Dog first, Dog second) {
        if (first.getTailLength() < second.getTailLength()) {
            return -1;
        }
        if (first.getTailLength() > second.getTailLength()) {
            return 1;
        }
        return first.getName().compareTo(second.getName());
    }
}