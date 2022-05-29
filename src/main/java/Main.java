import View.LoginMenu;
import View.MainMenu;
import View.ProfileMenu;
import View.RegisterMenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MainMenu.mediaURL = new URL(Main.class.getResource("musics/1-01 Opening Movie Music (1).mp3").toExternalForm());
        LoginMenu.mainMenuFxmlURL = new URL(Main.class.getResource("fxml/mainMenu.fxml").toExternalForm());
        LoginMenu.registerMenuFxmlURL = new URL(Main.class.getResource("fxml/registerMenu.fxml").toExternalForm());
        RegisterMenu.loginMenuFxmlURL = new URL(Main.class.getResource("fxml/loginMenu.fxml").toExternalForm());
        MainMenu.scoreBoardFxmlURL = new URL(Main.class.getResource("fxml/scoreBoard.fxml").toExternalForm());
        MainMenu.gameMenuFxmlURL = new URL(Main.class.getResource("fxml/playGameMenu.fxml").toExternalForm());
        MainMenu.scoreBoardFxmlURL = new URL(Main.class.getResource("fxml/scoreBoard.fxml").toExternalForm());
        MainMenu.profileFxmlURL = new URL(Main.class.getResource("fxml/profileMenu.fxml").toExternalForm());
        ProfileMenu.mainMenuFxml = LoginMenu.mainMenuFxmlURL;
        ProfileMenu.profileMenuFxml = MainMenu.profileFxmlURL;
        ProfileMenu.changeNicknameFxml = new URL(Main.class.getResource("fxml/ChangeNickName.fxml").toExternalForm());
        ProfileMenu.changePasswordFxml = new URL(Main.class.getResource("fxml/ChangePassword.fxml").toExternalForm());
        ProfileMenu.changeProfilePicFxml = new URL(Main.class.getResource("fxml/ChangeProfilePicture.fxml").toExternalForm());
        ProfileMenu.firstPic = new URL(Main.class.getResource("pictures/0.png").toExternalForm());
        ProfileMenu.secondPic = new URL(Main.class.getResource("pictures/1.png").toExternalForm());
        ProfileMenu.thirdPic = new URL(Main.class.getResource("pictures/2.png").toExternalForm());
        ProfileMenu.forthPic = new URL(Main.class.getResource("pictures/3.png").toExternalForm());
//        Scanner scan = new Scanner(System.in);
//        LoginMenu loginMenu = new LoginMenu();
//        loginMenu.run(scan);
        URL address_login_page = new URL(Main.class.getResource("fxml/loginMenu.fxml").toExternalForm());
        Parent root = FXMLLoader.load(address_login_page);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
