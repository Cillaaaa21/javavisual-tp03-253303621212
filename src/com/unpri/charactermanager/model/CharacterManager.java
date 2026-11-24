
package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {

    private final List<Character> characters = new ArrayList<>();

    // Menambahkan karakter baru
    public boolean add(Character character) {

        if (character == null) {
            return false;
        }

        if (isNameTaken(character.getName())) {
            return false;
        }

        characters.add(character);
        return true;
    }

    // Alias untuk kebutuhan CharacterFormPanel
    public boolean addCharacter(Character character) {
        return add(character);
    }

    // Memeriksa apakah nama sudah digunakan
    public boolean isNameTaken(String name) {

        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        return findByName(name.trim()) != null;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {

        if (name == null || name.trim().isEmpty()) {
            return null;
        }

        String searchedName = name.trim();

        for (Character character : characters) {

            if (character.getName().equalsIgnoreCase(searchedName)) {
                return character;
            }
        }

        return null;
    }

    // Menghapus karakter berdasarkan nama
    public boolean remove(String name) {

        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    // Menghitung total karakter
    public int getTotal() {
        return characters.size();
    }

    // Mengambil salinan daftar karakter
    public List<Character> getAll() {
        return new ArrayList<>(characters);
    }

    // Menghitung rata-rata level
    public double getAverageLevel() {

        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }
}
