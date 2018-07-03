package fr.alexfatta.kitpvp.kitManager;

import fr.alexfatta.kitpvp.kitManager.kitObjects.Armor;
import fr.alexfatta.kitpvp.kitManager.kitObjects.Consumables;
import fr.alexfatta.kitpvp.kitManager.kitObjects.PotionsLots;
import fr.alexfatta.kitpvp.kitManager.kitObjects.Weapons;

public class Kits {

    private Armor armor = new Armor();
    private Weapons weapons = new Weapons();
    private PotionsLots potionsLots = new PotionsLots();
    private Consumables consumables = new Consumables();
    private String kitName;

    public Kits() {
    }

    public Kits(Armor armor, Weapons weapons, Integer weaponNumber, PotionsLots potionsLots, Consumables consumables, String kitName){
        this.armor = armor;
        this.weapons = weapons;
        this.potionsLots = potionsLots;
        this.consumables = consumables;
        this.kitName = kitName;
    }

    public String getKitName() {
        return kitName;
    }

    public void setKitName(String kitName) {
        this.kitName = kitName;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public PotionsLots getPotionsLots() {
        return potionsLots;
    }

    public void setPotionsLots(PotionsLots potionsLots) {
        this.potionsLots = potionsLots;
    }

    public Consumables getConsumables() {
        return consumables;
    }

    public void setConsumables(Consumables consumables) {
        this.consumables = consumables;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

}
