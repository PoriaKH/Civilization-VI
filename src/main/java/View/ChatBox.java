package View;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import Model.FunctionsGson.PrivateChatGson;
import Model.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatBox {
    public static URL chatCSS;
    public static URL mainMenuFxmlURL;
    public static Member loggedInMember;
    public Pane root = new Pane();
    public Scene scene;
    public Stage stage;
    public String fileName;
    public boolean isPublic;

    private Button add = new Button("Add");
    private Button exit = new Button("Exit");
    private Button refresh = new Button("refresh");
    private VBox chatBox = new VBox(10);
    private TextField textField = new TextField();
    private ArrayList<Label> messages = new ArrayList<>();
    private ArrayList<Button> editButtons = new ArrayList<>();
    public ArrayList<String> oldMessage;
    private ScrollPane container = new ScrollPane();
    private int index = 0;

    public void run() throws FileNotFoundException {
        container.setPadding(new Insets(10, 0, 0, 10));
        chatBox.setPrefHeight(400);
        chatBox.setPadding(new Insets(0, 0, 0, 5));
        add.setTranslateX(50);
        add.setTranslateY(450);
        exit.setTranslateX(900);
        exit.setTranslateY(450);
        refresh.setTranslateX(475);
        refresh.setTranslateY(450);
        initChatBox();
        root.getStylesheets().add(chatCSS.toExternalForm());
        root.getChildren().add(textField);
        root.getChildren().addAll(container, add, refresh, exit);
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
        container.vvalueProperty().bind(chatBox.heightProperty());
        fileReading();
        exit.setOnMouseClicked(event -> {
            try {
                addToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                root = FXMLLoader.load(mainMenuFxmlURL);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });
        refresh.setOnMouseClicked(event -> {
            try {
                root = new Pane();
                messages = new ArrayList<>();
                editButtons = new ArrayList<>();
                container = new ScrollPane();
                add = new Button("Add");
                exit = new Button("Exit");
                refresh = new Button("refresh");
                chatBox = new VBox(10);
                textField = new TextField();
                index = 0;
                if (isPublic){
                    CreateHost.dataOutputStream.writeUTF("public chat");
                    CreateHost.dataOutputStream.flush();
                    String response = CreateHost.dataInputStream.readUTF();
                    String[] oldMessages = response.split("\n");
                    oldMessage = new ArrayList<>();
                    for (int i = 0; i < oldMessages.length; i++)
                        oldMessage.add(oldMessages[i]);
                }
                else {
                    CreateHost.dataOutputStream.writeUTF("private chat " + fileName);
                    CreateHost.dataOutputStream.flush();
                    String response = CreateHost.dataInputStream.readUTF();
                    String[] oldMessages = response.split("\n");
                    oldMessage = new ArrayList<>();
                    for (int j = 0; j < oldMessages.length; j++)
                        oldMessage.add(oldMessages[j]);
                }
                this.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        add.setOnAction(evt -> {
            messages.add(new Label(loggedInMember.getUsername() + " : " + textField.getText()));
            messages.get(index).getStyleClass().add("secondLabel");
            messages.get(index).setPadding(new Insets(0, 0, 0, 5));
            messages.get(index).setAlignment(Pos.CENTER_LEFT);
            messages.get(index).setWrapText(true);
            messages.get(index).setPrefWidth(800);
            editButtons.add(new Button("edit"));
            editButtons.get(index).setAlignment(Pos.CENTER_RIGHT);
            editButtons.get(index).getStyleClass().add("secondButton");
            Button tmp = editButtons.get(index);
            editButtons.get(index).setOnAction(event -> {
                int j = 0;
                for (int k = 0; k < editButtons.size(); k++)
                    if (editButtons.get(k).equals(tmp)) {
                        j = k;
                        break;
                    }
                if (messages.get(j).getText().substring(0, messages.get(j).getText().indexOf(" :")).equals(loggedInMember.getUsername())) {
                    int finalJ = j;
                    messages.get(finalJ).setText(loggedInMember.getUsername() + " : " + textField.getText());
                    textField.clear();
                }
            });
            textField.clear();
            Group group = new Group();
            group.getChildren().add(messages.get(index));
            HBox temp = new HBox(50);
            temp.setMaxWidth(1000);
            temp.setPrefHeight(30);
            temp.getChildren().addAll(group, editButtons.get(index++));
            chatBox.getChildren().add(temp);
            try {
                addToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void fileReading() throws FileNotFoundException {
        if (oldMessage.get(0).equals(""))
            return;
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
            Button tmp = editButtons.get(index);
            editButtons.get(index).setOnAction(event -> {
                int j = 0;
                for (int k = 0; k < editButtons.size(); k++)
                    if (editButtons.get(k).equals(tmp)) {
                        j = k;
                        break;
                    }
                if (messages.get(j).getText().substring(0, messages.get(j).getText().indexOf(" :")).equals(loggedInMember.getUsername())) {
                    int finalJ = j;
                    messages.get(finalJ).setText(loggedInMember.getUsername() + " : " + textField.getText());
                    textField.clear();
                }
            });
            Group group = new Group();
            group.getChildren().add(messages.get(index));
            HBox temp = new HBox(50);
            temp.setMaxWidth(1000);
            temp.setPrefHeight(30);
            temp.getChildren().addAll(group, editButtons.get(index++));
            chatBox.getChildren().add(temp);
        }
    }

    private void addToFile() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (Label label : messages)
            stringBuilder.append(label.getText()).append("\n");
        if (fileName.equals("messageFile")){
            CreateHost.dataOutputStream.writeUTF("write to public chat " + String.valueOf(stringBuilder));
            CreateHost.dataOutputStream.flush();
        }
        else {
            PrivateChatGson privateChatGson = new PrivateChatGson();
            privateChatGson.fileName = fileName;
            privateChatGson.message = String.valueOf(stringBuilder);
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            String request = gson.toJson(privateChatGson);
            CreateHost.dataOutputStream.writeUTF("write to private chat " + request);
            CreateHost.dataOutputStream.flush();
        }
    }
}
