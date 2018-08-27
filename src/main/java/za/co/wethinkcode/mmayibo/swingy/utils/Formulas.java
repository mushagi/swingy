package za.co.wethinkcode.mmayibo.swingy.utils;

public class Formulas {
    public static int calculateRequiredLevelExperience(int level) {
        return level * 1000 + ((level - 1) *(level - 1)) *450;
    }

    public static int calculateMapSquares(int level) {
        return (level-1)*5+10-(level%2);
    }

    public static int getLevelFromMap(int mapSize, int level) {
        if (calculateMapSquares(level) == mapSize)
            return level;
        return 1;
       // return  getLevelFromMap(mapSize, level++);
    }
}