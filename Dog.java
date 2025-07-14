//Adrian Shayesteh Dar adsh9563

public class Dog {
    private static final double DACHSHUND_TAIL_LENGTH = 3.7;
    private String breed;
    private String name;
    private int age;
    private int weight;
    private Owner owner;

    public Dog(String name, String breed, int age, int weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public String getBreed() {
        return breed.toUpperCase();
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public double getTailLength() {
        double tailLength = age * weight / 10.0;
        if (breed.equalsIgnoreCase("Tax") || breed.equalsIgnoreCase("Dachshund")) {
            return DACHSHUND_TAIL_LENGTH;
        } else {
            return tailLength;
        }
    }

    public String toString() {
        return name + breed + age + weight + owner + getTailLength();
    }

    public int ageIncrease() {
        if (age < Integer.MAX_VALUE) {
            return age++;
        }
        return age;
    }

    public boolean setOwner(Owner owner) {
        if (owner == null) {

            if (this.owner != null) {
                this.owner.removeDog(this);
                this.owner = null;
                return true;
            }
            return false;
        }

        if (this.owner == null) {
            this.owner = owner;
            owner.addDog(this);
            return true;
        }
        return false;
    }

    public Owner getOwner() {
        return owner;
    }
}


