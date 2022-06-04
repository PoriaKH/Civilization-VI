package View;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Member;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatBox {
    public static URL chatCSS;
    public static Member loggedInMember;
    public Pane root = new Pane();
    public Scene scene;
    public Stage stage;

    private final Button add = new Button("Add");
    private final VBox chatBox = new VBox(10);
    private final TextField textField = new TextField();
    private ArrayList<Label> messages = new ArrayList<>();
    private ArrayList<Button> editButtons = new ArrayList<>();
    private ArrayList<String> oldMessage = new ArrayList<>();
    private ScrollPane container = new ScrollPane();
    private int index = 0;

    public void run() throws FileNotFoundException {
        container.setPadding(new Insets(10, 0, 0, 10));
        chatBox.setPrefHeight(400);
        chatBox.setPadding(new Insets(0, 0, 0, 5));
        add.setTranslateX(50);
        add.setTranslateY(450);
        initChatBox();
        root.getStylesheets().add(chatCSS.toExternalForm());
        root.getChildren().add(textField);
        root.getChildren().addAll(container, add);
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    private void initChatBox() throws FileNotFoundException {
        textField.setPromptText("enter your message");
        container.setPrefSize(1000, 400);
        container.setContent(chatBox);
        chatBox.getStyleClass().add("chatBox");
        chatBox.setPadding(new Insets(10, 0, 0, 0));
        fileReading();
        add.setOnAction(evt -> {
            String message = loggedInMember.getUsername() + " : " + textField.getText() + "\n";
            try {
                fileAdder(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
            messages.add(new Label(loggedInMember.getUsername() + " : " + textField.getText()));
            messages.get(index).getStyleClass().add("secondLabel");
            messages.get(index).setPadding(new Insets(0, 0, 0, 5));
            messages.get(index).setAlignment(Pos.CENTER_LEFT);
            messages.get(index).setWrapText(true);
            messages.get(index).setPrefWidth(800);
            editButtons.add(new Button("edit"));
            editButtons.get(index).setAlignment(Pos.CENTER_RIGHT);
            editButtons.get(index).getStyleClass().add("secondButton");
            textField.clear();
            Group group = new Group();
            group.getChildren().add(messages.get(index));
            HBox temp = new HBox(50);
            temp.setMaxWidth(1000);
            temp.setPrefHeight(30);
            temp.getChildren().addAll(group, editButtons.get(index++));
            chatBox.getChildren().add(temp);
        });
    }

    private void fileAdder(String message) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/messageFile.txt", true));
        writer.write(message);
        writer.close();
    }


    private void fileReading() throws FileNotFoundException {
        File file = new File("src/main/resources/messageFile.txt");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine())
            oldMessage.add(fileScanner.nextLine());
        fileScanner.close();
        for (int i = 0; i < oldMessage.size(); i++) {
            messages.add(new Label(oldMessage.get(i)));
            if (oldMessage.get(i).substring(0, oldMessage.get(i).indexOf(" :")).equals(loggedInMember.getUsername()))
                messages.get(index).getStyleClass().add("secondLabel");
            messages.get(index).setWrapText(true);
            messages.get(index).setPrefWidth(800);
            messages.get(index).setPadding(new Insets(0, 0, 0, 5));
            messages.get(index).setAlignment(Pos.CENTER_LEFT);
            editButtons.add(new Button("edit"));
            editButtons.get(index).setAlignment(Pos.CENTER_RIGHT);
            editButtons.get(index).getStyleClass().add("secondButton");
            Group group = new Group();
            group.getChildren().add(messages.get(index));
            HBox temp = new HBox(50);
            temp.setMaxWidth(1000);
            temp.setPrefHeight(30);
            temp.getChildren().addAll(group, editButtons.get(index++));
            chatBox.getChildren().add(temp);
        }
    }

}
