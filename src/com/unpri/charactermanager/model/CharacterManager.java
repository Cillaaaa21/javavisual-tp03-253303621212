package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    private List<Character> characterList;

    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        characterList.add(character);
    }

    // Pastikan method ini ada agar error hilang
    public List<Character> getCharacterList() {
        return characterList;
    }

    public int getTotalCharacters() {
        return characterList.size();
    }

    public double getAverageLevel() {
        if (characterList.isEmpty()) return 0.0;
        int sum = 0;
        for (Character c : characterList) {
            sum += c.getLevel();
        }
        return (double) sum / characterList.size();
    }
}