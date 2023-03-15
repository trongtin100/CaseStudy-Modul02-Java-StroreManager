import java.io.IOException;
import java.util.Scanner;

public abstract class Menu implements learnAble{
    @Override
    public void menu(String display){
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            showMenu(display);
            System.out.println("Enter option");
            option = sc.nextInt();

            option(option);
        }
    }

    private void option(int option) {
        switch (option) {
            case 1:
                add();
                break;
            case 2:
                update();
                break;
            case 3:
                remove();
                break;
            case 4:
                search();
                break;
            case 5:
                displayAll();
                break;
            case 0:
                break;
        }
    }

    private static void showMenu(String display) {
        System.out.println("==========" + display + "==========");
        System.out.println("1. add ");
        System.out.println("2. update ");
        System.out.println("3. remove ");
        System.out.println("4. search ");
        System.out.println("5. displayAll ");
        System.out.println("0. exit ");
    }
}
