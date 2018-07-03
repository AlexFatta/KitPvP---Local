package fr.alexfatta.kitpvp.kitManager.kitObjects;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

public class Weapons {

    private static ArrayList<ItemStack> listWeapons = new ArrayList<>();

    public Weapons() {
    }

    public Weapons(ArrayList<ItemStack> mapWeapons) {
        Weapons.listWeapons = mapWeapons;
    }

    public static ArrayList<ItemStack> getListWeapons() {
        return listWeapons;
    }

    public static void setListWeapons(ArrayList<ItemStack> mapWeapons) {
        Weapons.listWeapons = mapWeapons;
    }

}
