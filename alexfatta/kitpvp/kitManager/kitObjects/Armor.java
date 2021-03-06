package fr.alexfatta.kitpvp.kitManager.kitObjects;

import org.bukkit.inventory.ItemStack;

public class Armor {

    private ItemStack helmet, chestplate, leggings, boots;

    public Armor() {

    }

    public Armor (ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {

        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;

    }


    public ItemStack getHelmet() {
        return helmet;
    }

    public void setHelmet(ItemStack helmet) {
        this.helmet = helmet;
    }

    public ItemStack getChestplate() {
        return chestplate;
    }

    public void setChestplate(ItemStack chestplate) {
        this.chestplate = chestplate;
    }

    public ItemStack getLeggings() {
        return leggings;
    }

    public void setLeggings(ItemStack leggings) {
        this.leggings = leggings;
    }

    public ItemStack getBoots() {
        return boots;
    }

    public void setBoots(ItemStack boots) {
        this.boots = boots;
    }
}
