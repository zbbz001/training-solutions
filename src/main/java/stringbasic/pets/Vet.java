package stringbasic.pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {
    private List<Pet> pets = new ArrayList<>();

    public void add(Pet newPet){
        for(Pet storedPet:pets) {
            if(areEquals(storedPet, newPet)) {
                return;
            }
        }
        pets.add(newPet);
    }

    public List<Pet> getPets() {
        return pets;
    }

    public boolean areEquals(Pet storedPet, Pet newPet) {
        return storedPet.getRegistrationNumber().equals(newPet.getRegistrationNumber());
    }
}
