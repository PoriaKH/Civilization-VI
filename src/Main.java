import View.LoginMenu;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.run(scan);
    }
}

