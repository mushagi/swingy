package za.co.wethinkcode.mmayibo.swingy;

import za.co.wethinkcode.mmayibo.swingy.controllers.GameManager;
import za.co.wethinkcode.mmayibo.swingy.enums.EInterfaceType;

class Main {
    public static void main(String args[]) {
        if (!validateArguments(args)) {
            System.out.println("Usage :\n\t\tswingy [console/gui]");
            System.exit(0);
        }
        EInterfaceType interfaceType = getStartingInterfaceType(args[0]);
        GameManager gameManager = new GameManager();
        gameManager.startGame(interfaceType);
    }

    private static EInterfaceType getStartingInterfaceType(String string) {
        return string.equals("gui") ? EInterfaceType.GUI : EInterfaceType.CLI;
    }

    private static boolean validateArguments(String[] args) {
        if (args.length != 1) return false;
        return args[0].equals("gui") || args[0].equals("console");
    }
}