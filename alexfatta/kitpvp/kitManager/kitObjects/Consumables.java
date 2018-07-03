package fr.alexfatta.kitpvp.kitManager.kitObjects;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

public class Consumables {
	
	private ItemStack potion1, potion2, potion3, food;
	private int potions_slot, food_slot;
	private static String consumableName;
	private static ArrayList<ItemStack> listConsumables = new ArrayList<>();
	
	public Consumables(){
	}
	
	public Consumables(ArrayList<ItemStack> listOfConsumables) {
		Consumables.listConsumables = listOfConsumables;
	}
	
	public Consumables(ItemStack potion1, Integer potions_slot, ArrayList<ItemStack> listOfConsumables) {
		this.potion1 = potion1;
		this.setPotions_slot(potions_slot);
		Consumables.listConsumables = listOfConsumables;
	}
	
	public Consumables(ItemStack potion1, ItemStack potion2, Integer potions_slot, ArrayList<ItemStack> listOfConsumables) {
		this.potion1 = potion1;
		this.potion2 = potion2;
		this.setPotions_slot(potions_slot);
		Consumables.listConsumables = listOfConsumables;
	}
	
	public Consumables(ItemStack potion1, ItemStack potion2, ItemStack potion3, Integer potions_slot, ArrayList<ItemStack> listOfConsumables) {
		this.potion1 = potion1;
		this.potion2 = potion2;
		this.potion3 = potion3;
		this.setPotions_slot(potions_slot);
		Consumables.listConsumables = listOfConsumables;
	}

	public ItemStack getPotion1() {
		return potion1;
	}

	public void setPotion1(ItemStack potion1) {
		this.potion1 = potion1;
	}

	public ItemStack getPotion2() {
		return potion2;
	}

	public void setPotion2(ItemStack potion2) {
		this.potion2 = potion2;
	}

	public ItemStack getPotion3() {
		return potion3;
	}

	public void setPotion3(ItemStack potion3) {
		this.potion3 = potion3;
	}

	public ItemStack getFood() {
		return food;
	}

	public void setFood(ItemStack food) {
		this.food = food;
	}

	public int getPotions_slot() {
		return potions_slot;
	}

	public void setPotions_slot(int potions_slot) {
		this.potions_slot = potions_slot;
	}

	public int getFood_slot() {
		return food_slot;
	}

	public void setFood_slot(int food_slot) {
		this.food_slot = food_slot;
	}

	public static ArrayList<ItemStack> getMapConsumables() {
		return listConsumables;
	}

	public static void setMapConsumables(ArrayList<ItemStack> mapConsumables) {
		Consumables.listConsumables = mapConsumables;
	}

	public static String getConsumableName() {
		return consumableName;
	}

	public static void setConsumableName(String consumableName) {
		Consumables.consumableName = consumableName;
	}

}