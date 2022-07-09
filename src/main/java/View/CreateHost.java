package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static View.MainMenu.lobbyURL;

public class CreateHost {
    public Pane root;
    public Stage stage;
    public Scene scene;
    @FXML
    public TextField names;

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(lobbyURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void createClicked(MouseEvent mouseEvent) {
        String[] args = names.getText().split(",");
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }
}
