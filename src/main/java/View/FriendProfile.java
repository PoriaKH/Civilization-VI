package View;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class FriendProfile {
    public static URL friendProfileURL;
    public static URL firstImageURL;
    public static URL secondImageURL;
    public static URL thirdImageURL;
    public static URL forthImageURL;
    public static Stage stage;
    public FriendsList friendsList;
    private BorderPane pane;
    private Button back = new Button("back");

    public void run(String[] userInfo) throws IOException {
        pane = FXMLLoader.load(friendProfileURL);
        back.setOnMouseClicked(event -> {
            try {
                new FriendsList().run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        String username = userInfo[0];
        String nickname = userInfo[1];
        String score = userInfo[3];
        String imageURL = userInfo[4];
        String lastLogin = userInfo[5];
        Label usernameLabel = new Label("username : " + username);
        Label nicknameLabel = new Label("nickname : " + nickname);
        Label scoreLabel = new Label("score : " + score);
        Label lastLoginLabel = new Label("last login date : " + lastLogin);
        Label imageLabel = new Label("profile image :");
        Rectangle rectangle = new Rectangle();
        usernameLabel.setStyle("-fx-font-size: 27;\n" +
                "    -fx-font-family: Ebrima;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgb(255, 0, 47), 6, 0.0 , 0 , 2 );");
        nicknameLabel.setStyle("-fx-font-size: 27;\n" +
                "    -fx-font-family: Ebrima;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgb(255, 0, 47), 6, 0.0 , 0 , 2 );");
        scoreLabel.setStyle("-fx-font-size: 27;\n" +
                "    -fx-font-family: Ebrima;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgb(255, 0, 47), 6, 0.0 , 0 , 2 );");
        lastLoginLabel.setStyle("-fx-font-size: 27;\n" +
                "    -fx-font-family: Ebrima;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgb(255, 0, 47), 6, 0.0 , 0 , 2 );");
        imageLabel.setStyle("-fx-font-size: 27;\n" +
                "    -fx-font-family: Ebrima;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgb(255, 0, 47), 6, 0.0 , 0 , 2 );");
        rectangle.setHeight(270);
        rectangle.setWidth(270);
        if (imageURL.equals("1"))
            rectangle.setFill(new ImagePattern(new Image(firstImageURL.toExternalForm())));
        else if (imageURL.equals("2"))
            rectangle.setFill(new ImagePattern(new Image(secondImageURL.toExternalForm())));
        else if (imageURL.equals("3"))
            rectangle.setFill(new ImagePattern(new Image(thirdImageURL.toExternalForm())));
        else if (imageURL.equals("4"))
            rectangle.setFill(new ImagePattern(new Image(forthImageURL.toExternalForm())));
        VBox vBox = new VBox(30);
        vBox.getChildren().add(usernameLabel);
        vBox.getChildren().add(nicknameLabel);
        vBox.getChildren().add(scoreLabel);
        vBox.getChildren().add(lastLoginLabel);
        vBox.getChildren().add(imageLabel);
        vBox.getChildren().add(rectangle);
        vBox.getChildren().add(back);
        vBox.setAlignment(Pos.CENTER);
        pane.setCenter(vBox);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
