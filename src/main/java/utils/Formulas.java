package utils;

public class Formulas {
    public static int calculateRequiredLevelExperience(int level) {
        return level * 1000 + ((level - 1) *(level - 1)) *450;
    }

    public static int calculateMapSquares(int level) {
        return (level-1)*5+10-(level%2);
    }
}