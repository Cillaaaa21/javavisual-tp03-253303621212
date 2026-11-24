
package com.unpri.charactermanager.model;

import java.util.Objects;
import java.util.Locale;

public class Character {

    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Konstruktor utama
    public Character(String name, CharacterType type, int level) {

        setName(name);
        setLevel(level);
        setType(type);
        setMana(0);
    }

    // Getter nama
    public String getName() {
        return name;
    }

    // Setter nama
    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter tidak boleh kosong!"
            );
        }

        String cleanedName = name.trim();

        if (cleanedName.length() > 20) {
            throw new IllegalArgumentException(
                "Nama karakter maksimal 20 karakter!"
            );
        }

        this.name = cleanedName;
    }

    // Getter tipe karakter
    public CharacterType getType() {
        return type;
    }

    // Setter tipe karakter
    public void setType(CharacterType type) {

        if (type == null) {
            throw new IllegalArgumentException(
                "Role karakter harus dipilih!"
            );
        }

        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException(
                "MAGE tidak boleh memiliki level di atas 60!"
            );
        }

        this.type = type;
    }

    // Getter level
    public int getLevel() {
        return level;
    }

    // Setter level
    public void setLevel(int level) {

        if (level < 1 || level > 99) {
            throw new IllegalArgumentException(
                "Level karakter harus antara 1 sampai 99!"
            );
        }

        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException(
                "MAGE tidak boleh memiliki level di atas 60!"
            );
        }

        this.level = level;

        // Perhitungan otomatis HP dan Attack Power
        this.hitPoints = 100 + (level * 10);
        this.attackPower = 20 + (level * 5);
    }

    // Getter Hit Points
    public int getHitPoints() {
        return hitPoints;
    }

    // Getter Attack Power
    public int getAttackPower() {
        return attackPower;
    }

    // Getter Mana
    public int getMana() {
        return mana;
    }

    // Setter Mana
    public void setMana(int mana) {

        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif!"
            );
        }

        this.mana = mana;
    }

    // Membandingkan karakter berdasarkan nama
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return name.equalsIgnoreCase(other.name);
    }

    // HashCode berdasarkan nama
    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(Locale.ROOT));
    }

    // Tampilan informasi karakter
    @Override
    public String toString() {

        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attackPower=" + attackPower +
                ", mana=" + mana +
                '}';
    }
}
