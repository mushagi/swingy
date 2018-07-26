import factory.UserInterfaceFactory;
import views.UserInterface;

class Main {
    public static void main(String args[]) {
        UserInterface userInterface = UserInterfaceFactory.newCLIInterfaceFromGameData();
        userInterface.show();
    }
}