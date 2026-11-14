
package com.unpri.charactermanager.controller;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import java.util.List;

public class CharacterController {

    private CharacterManager manager;

    public CharacterController(CharacterManager manager) {
        this.manager = manager;
    }

    public void addCharacter(String name, CharacterType type, int level) {
        Character newChar = new Character(name, type, level);
        manager.addCharacter(newChar);
    }

    public List<Character> getAllCharacters() {
        return manager.getCharacterList();
    }

    public int getTotalCharacters() {
        return manager.getTotalCharacters();
    }

    public double getAverageLevel() {
        return manager.getAverageLevel();
    }
}
