package fr.alexfatta.kitpvp.kitManager;

public class CheckExistingKit {

    public static boolean checkExistingAskedKit(String kitName) {

        Kits kitToTest = new Kits();
        kitToTest.setKitName(kitName);

        for(Kits kit : LoadKits.getLoadedKits()) {
            if (kit.getKitName().equals(kitToTest.getKitName())) {
                return true;
            }
        }
        return false;
    }

}
