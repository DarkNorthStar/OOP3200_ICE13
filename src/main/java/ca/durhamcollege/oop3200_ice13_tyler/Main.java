/*
* Author: Tyler Osborne
* Date: 2021-12-15
* Description:
*       This program uses javafx to have a image with a button where the image and its label change when the button is
*       clicked
*
* */
package ca.durhamcollege.oop3200_ice13_tyler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class Main  extends Application
{
    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle(("Hello World"));

        // Creates new controls
        Label imageLabel = new Label("Clem"); // Labels

        Label anotherLabel = new Label("Another Label"); // More labels
        Label yetAnotherLabel = new Label("Yet Another Label");

        Button clickMeButton = new Button("Gundam!"); // Button
        clickMeButton.setStyle("-fx-font-family: Arial;");

        // Create image Clem.jpg
        FileInputStream imagePath = new FileInputStream("src/main/java/ca/durhamcollege/oop3200_ice13_tyler/Clem.jpg");
        Image clem = new Image(imagePath);
        ImageView imageView = new ImageView(clem);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        // Create image gundam.gif
        FileInputStream gundamPath = new FileInputStream("src/main/java/ca/durhamcollege/oop3200_ice13_tyler/Gundam.gif");
        Image gundam = new Image(gundamPath);


        // Configure controls
        //Font font = Font.font("Consolas", FontWeight.BOLD, 40); // Creates new font
        //clickMeButton.setFont(font); // Adds new font to the button

        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                // Change hello label to "clicked"
                imageLabel.setText("Gundam");

                // Change image
                imageView.setImage(gundam);
            }
        }

        // Assign action to the button
        clickMeButton.setOnAction(new ButtonClickHandler());

        /*
        // Event Handler
        clickMeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                // Output to console
                System.out.println("Click Me Button Clicked");

                // Change hello label to "clicked"
                imageLabel.setText("Gundam");

                // Change image
                imageView.setImage(gundam);

            }
        });
         */

        // Creates new HBoxs
        HBox hbox = new HBox(16, imageLabel);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-border-color: black; -fx-alignment: center;");
        HBox hbox2 = new HBox(16, imageView);
        hbox.setAlignment(Pos.CENTER);


        // Create new GridPane
        GridPane gridPane = new GridPane();
        // set gridPanes settings
        gridPane.setMinSize(6,8);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        // Adds items to the grid pane
        gridPane.add(hbox, 0, 0);
        gridPane.add(hbox2, 0, 1);
        //gridPane.add(imageView, 0,2);
        gridPane.add(clickMeButton, 2, 2);

        // Set border
        //gridPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        // Set border and default font size for the GridPane
        gridPane.setStyle("-fX-border-color: black; -fx-font-size: 20; -fx-font-family: Consolas; -fx-font-weight: bold; -fx-cell-size: 60px");

        // Get children
        var children = gridPane.getChildren();

        // Creates new scene
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);

        // Add scene to stage
        primaryStage.setScene(scene);

        // Display Stage
        primaryStage.show();
    }

    public static void main(String[] args){launch(args);}
}
