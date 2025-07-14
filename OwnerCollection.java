//Adrian Shayesteh Dar adsh9563

import java.util.Arrays;
import java.util.ArrayList;

public class OwnerCollection {
    private Owner[] owners = new Owner[0];

    public boolean addOwner(Owner newOwner) {
        if (containsOwner(newOwner.getName())) {
            return false;
        }
        Owner[] newOwners = new Owner[owners.length + 1];
        System.arraycopy(owners, 0, newOwners, 0, owners.length);
        newOwners[owners.length] = newOwner;
        owners = newOwners;
        return true;
    }

    public boolean removeOwner(String ownerName) {
        for (Owner owner : owners) {
            if (owner.getName().equalsIgnoreCase(ownerName)) {
                return removeOwner(owner);
            }
        }
        return false;
    }

    public boolean removeOwner(Owner owner) {
        int indexToRemove = -1;
        for (int i = 0; i < owners.length; i++) {
            if (owners[i].equals(owner)) {
                if (owners[i].getDogs().size() > 0) {
                    return false;
                }
                indexToRemove = i;
            }
        }
        if (indexToRemove == -1) {
            return false;
        }
        Owner[] newOwners = new Owner[owners.length - 1];
        System.arraycopy(owners, 0, newOwners, 0, indexToRemove);
        System.arraycopy(owners, indexToRemove + 1, newOwners, indexToRemove, owners.length - indexToRemove - 1);
        owners = newOwners;
        return true;
    }

    public boolean containsOwner(String ownerName) {
        for (Owner owner : owners) {
            if (owner.getName().equalsIgnoreCase(ownerName)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsOwner(Owner ownerName) {
        for (Owner owner : owners) {
            if (owner.equals(ownerName)) {
                return true;
            }
        }
        return false;
    }

    public Owner getOwner(String ownerName) {
        for (Owner owner : owners) {
            if (owner.getName().equalsIgnoreCase(ownerName)) {
                return owner;
            }
        }
        return null;
    }

    public ArrayList<Owner> getOwners() {
        Arrays.sort(owners);
        ArrayList<Owner> ownersList = new ArrayList<>();
        for (Owner owner : owners) {
            ownersList.add(owner);
        }
        return ownersList;
    }
}