import controllers.GameController;
import enums.EInterfaceType;

class Main {
    public static void main(String args[]) {
        if(!validateArguments(args)){
            System.out.println("Usage :\n\t\tswingy [console/gui]" );
            System.exit(0);
        }
        EInterfaceType interfaceType = getStartingInferaceType(args[0]);
        GameController gameController = new GameController();
        gameController.startGame(EInterfaceType.CLI);
    }

    private static EInterfaceType getStartingInferaceType(String string) {
        return string.equals("gui") ? EInterfaceType.GUI : EInterfaceType.CLI;
    }

    private static boolean validateArguments(String[] args) {
        if (args.length != 1)
            return false;
        return args[0].equals("gui") || args[0].equals("console");
    }
}