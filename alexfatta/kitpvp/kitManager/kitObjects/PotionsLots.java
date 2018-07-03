
package fr.alexfatta.kitpvp.kitManager.kitObjects;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

public class PotionsLots {

    private ItemStack potion_1, potion_2, potion_3;
    private static ArrayList<ItemStack> listOfPotions = new ArrayList<>();

    public PotionsLots() {

    }

    public PotionsLots(ArrayList<ItemStack> potionsList) {
        PotionsLots.listOfPotions = potionsList;
        attributePotionFromListToVariable(potionsList);
    }

    public static void attributePotionFromListToVariable(ArrayList<ItemStack> listToLoad) {

        int i = 0;
        if(!listToLoad.isEmpty()) {
            for (i = 0; i < listToLoad.size(); i++) {
                listOfPotions.set(i, listToLoad.get(i));
            }
        }
    }

    public ItemStack getPotion_1() {
        return potion_1;
    }

    public void setPotion_1(ItemStack potion_1) {
        this.potion_1 = potion_1;
    }

    public ItemStack getPotion_2() {
        return potion_2;
    }

    public void setPotion_2(ItemStack potion_2) {
        this.potion_2 = potion_2;
    }

    public ItemStack getPotion_3() {
        return potion_3;
    }

    public void setPotion_3(ItemStack potion_3) {
        this.potion_3 = potion_3;
    }

    public static ArrayList<ItemStack> getListOfPotions() {
        return listOfPotions;
    }

    public void setListOfPotions(ArrayList<ItemStack> listOfPotions) {
        PotionsLots.listOfPotions = listOfPotions;
    }

}