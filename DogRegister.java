//Adrian Shayesteh Dar adsh9563

import java.util.ArrayList;

public class DogRegister {

    private static final String REGISTER_NEW_OWNER = "REGISTER NEW OWNER";
    private static final String LIST_OWNERS = "LIST OWNERS";
    private static final String REMOVE_OWNER = "REMOVE OWNER";
    private static final String REGISTER_NEW_DOG = "REGISTER NEW DOG";
    private static final String REMOVE_DOG = "REMOVE DOG";
    private static final String LIST_DOGS = "LIST DOGS";
    private static final String INCREASE_AGE = "INCREASE AGE";
    private static final String GIVE_DOG_TO_OWNER = "GIVE DOG TO OWNER";
    private static final String REMOVE_DOG_FROM_OWNER = "REMOVE DOG FROM OWNER";
    private static final String EXIT = "EXIT";

    private OwnerCollection ownerCollection = new OwnerCollection();
    private DogCollection dogCollection = new DogCollection();
    private InputReader input;

    public DogRegister() {
        this.input = new InputReader();
    }

    public static void main(String[] args) {
        DogRegister dogRegister = new DogRegister();
        dogRegister.run();
    }

    public void run() {
        String commandChoice = input.stringReader("Enter command");

        while (!commandChoice.equalsIgnoreCase(EXIT)) {
            executeCommand(commandChoice);
            commandChoice = input.stringReader("Enter command");
        }
    }

    public void executeCommand(String commandChoice) {
        switch (commandChoice.toUpperCase()) {
            case REGISTER_NEW_OWNER:
                registerNewOwner();
                break;
            case LIST_OWNERS:
                listOwners();
                break;
            case REMOVE_OWNER:
                removeOwner();
                break;
            case REGISTER_NEW_DOG:
                registerNewDog();
                break;
            case REMOVE_DOG:
                removeDog();
                break;
            case LIST_DOGS:
                listDogs();
                break;
            case INCREASE_AGE:
                increaseAge();
                break;
            case GIVE_DOG_TO_OWNER:
                giveDogToOwner();
                break;
            case REMOVE_DOG_FROM_OWNER:
                removeDogFromOwner();
                break;
            default:
                System.out.println("error");
                break;
        }
    }

    private void registerNewOwner() {
        String enterOwnerName = input.stringReader("Enter owner name").trim();

        while (enterOwnerName.isEmpty()) {
            System.out.println("Error: A blank string is not allowed, try again");
            enterOwnerName = input.stringReader("Enter owner name").trim();
        }

        if (!(ownerCollection.addOwner(new Owner(enterOwnerName)))) {
            System.out.println("Error: The owner " + enterOwnerName + " already exists");
        } else {
            System.out.println("The owner " + enterOwnerName + " has been added to the register");
        }
    }

    private void removeOwner() {
        if (ownerCollection.getOwners().isEmpty()) {
            System.out.println("Error: No owners in register");
            return;
        }

        String enterOwnerName = input.stringReader("Enter owner name");
        Owner owner = ownerCollection.getOwner(enterOwnerName);

        if (owner == null) {
            System.out.println("Error: The owner " + enterOwnerName + " doesn't exist");
            return;
        }

        if (owner.getDogs().size() > 0) {
            for (Dog dog : new ArrayList<>(owner.getDogs())) {
                owner.removeDog(dog);
                dogCollection.removeDog(dog);
            }
        }
        ownerCollection.removeOwner(owner);
        System.out.println("The owner " + enterOwnerName + " has been removed from the register");
    }

    private void registerNewDog() {
        String enterDogName = input.stringReader("Enter dog name").trim();

        if (dogCollection.containsDog(enterDogName)) {
            System.out.println("Error: The dog " + enterDogName + " already exists");
            return;
        }

        while (enterDogName.isEmpty()) {
            System.out.println("Error: A blank string is not allowed, try again");
            enterDogName = input.stringReader("Enter dog name").trim();
        }

        String enterDogBreed = input.stringReader("Enter dog breed").trim();
        while (enterDogBreed.isEmpty()) {
            System.out.println("Error: A blank string is not allowed, try again");
            enterDogBreed = input.stringReader("Enter dog breed").trim();
        }

        int enterDogAge = input.intReader("Enter dog age");
        int enterDogWeight = input.intReader("Enter dog weight");

        dogCollection.addDog(new Dog(enterDogName, enterDogBreed, enterDogAge, enterDogWeight));
        System.out.println("The dog " + enterDogName + " has been added to the register.");
    }

    private void removeDog() {
        if (dogCollection.getDogs().isEmpty()) {
            System.out.println("Error: No dogs in register");
            return;
        }

        String enterDogName = input.stringReader("Enter dog name");
        Dog dog = dogCollection.getDog(enterDogName);

        if (dog == null) {
            System.out.println("Error: The dog " + enterDogName + " doesn't exist");
            return;
        }

        if (dog.getOwner() != null) {
            Owner owner = dog.getOwner();
            owner.removeDog(dog);
        }

        dogCollection.removeDog(dog);
        System.out.println("The dog " + enterDogName + " has been removed from the register");
    }

    private void listDogs() {
        if (dogCollection.getDogs().isEmpty()) {
            System.out.println("Error: No dogs in register");
            return;
        }

        double enterMinimumTailLength = input.doubleReader("Enter minimum tail length");
        System.out.println("Name      Breed       Age    Weight    Tail   Owner");
        System.out.println("====================================================");

        ArrayList<Dog> dogsWithTailLength = dogCollection.getDogsWithTailNewName(enterMinimumTailLength);

        for (Dog dog : dogsWithTailLength) {
            String ownerName = (dog.getOwner() != null) ? dog.getOwner().getName() : "";
            System.out.println(dog.getName() + "     " + dog.getBreed() + "     " + dog.getAge() + "     " + dog.getWeight() + "      " + dog.getTailLength() + "      " + ownerName);
        }
    }

    private void listOwners() {
        if (ownerCollection.getOwners().isEmpty()) {
            System.out.println("Error: No owners in register");
            return;
        }
        System.out.println("Name         Dogs");
        System.out.println("==================");

        for (Owner owner : ownerCollection.getOwners()) {
            String ownerName = owner.getName();
            ArrayList<String> ownerDogs = new ArrayList<>();

            for (Dog dog : dogCollection.getDogs()) {
                if (dog.getOwner() != null && dog.getOwner().equals(owner)) {
                    ownerDogs.add(dog.getName());
                }
            }
            String dogs = ownerDogs.isEmpty() ? "" : String.join(", ", ownerDogs);
            System.out.println(ownerName + "          " + dogs);
        }
    }

    private void increaseAge() {
        if (dogCollection.getDogs().isEmpty()) {
            System.out.println("Error: No dogs in register");
            return;
        }

        String enterDogName = input.stringReader("Enter dog name");
        Dog dog = dogCollection.getDog(enterDogName);

        if (dog == null) {
            System.out.println("Error: The dog " + enterDogName + " doesn't exist");
            return;
        }
        dog.ageIncrease();
        System.out.println("The dog " + enterDogName + " now one year older");

    }

    private void giveDogToOwner() {
        if (dogCollection.getDogs().isEmpty()) {
            System.out.println("Error: No dogs in register");
            return;
        }
        if (ownerCollection.getOwners().isEmpty()) {
            System.out.println("Error: No owners in register");
            return;
        }

        String enterDogName = input.stringReader("Enter dog name").trim();

        Dog dog = dogCollection.getDog(enterDogName);
        if (dog == null) {
            System.out.println("Error: The dog " + enterDogName + " doesn't exist");
            return;
        }

        if (dog.getOwner() != null) {
            System.out.println("Error: The dog " + enterDogName + " already have an owner");
            return;
        }

        String enterOwnerName = input.stringReader("Enter owner name").trim();
        Owner owner = ownerCollection.getOwner(enterOwnerName);

        if (owner == null) {
            System.out.println("Error: The owner " + enterOwnerName + " doesn't exist");
        }

        dog.setOwner(owner);
        System.out.println("The dog " + enterDogName + " is now owned by " + enterOwnerName);
    }

    private void removeDogFromOwner() {
        if (dogCollection.getDogs().isEmpty()) {
            System.out.println("Error: No dogs in register");
            return;
        }
        if (ownerCollection.getOwners().isEmpty()) {
            System.out.println("Error: No owners in register");
            return;
        }
        String enterDogName = input.stringReader("Enter dog name");
        Dog dog = dogCollection.getDog(enterDogName);

        if (dog == null) {
            System.out.println("Error: The dog " + enterDogName + " doesn't exist");
            return;
        }

        dog.setOwner(null);
        System.out.println("The dog " + enterDogName + " now have no owner");
    }
}