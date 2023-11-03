package com.example.newtodo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

public class TaskRelated {
    public void takeTask(Page1 page1) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Task");

        VBox vbox = new VBox();
        vbox.setStyle("-fx-spacing: 10; -fx-background-color: blur;");


        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10));
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10));
        hBox2.setAlignment(Pos.CENTER);
        HBox hBox3 = new HBox();
        hBox3.setPadding(new Insets(10));
        hBox3.setAlignment(Pos.CENTER);


        TextField textField = new TextField();
        textField.setPromptText("Please enter the task");

        DatePicker date = new DatePicker();
        date.setPromptText("Select date-time");
        LocalDate localDate= LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
        date.setValue(localDate);


        ComboBox<String> priority= new ComboBox<>();
        priority.setPromptText("Select Priority");
        priority.getItems().addAll("PRIORITY", "NO-PRIORITY");
        priority.setValue("NO-PRIORITY");

        Button ok = new Button("Add");
        Button cancel = new Button("Cancel");
        ok.setOnMouseClicked(e -> {
            if (textField.getText().isEmpty()) {
                textField.setPromptText("please fill the info");
            } else {
                page1.addTaskInfo(textField.getText(), date.getValue().toString(), priority.getValue());
                try{
                    fileWriter.writeInformation(textField.getText(), date.getValue().toString(), priority.getValue());
                } catch (Exception p){
                    System.out.println("problem found in file writing");
                }
                stage.close();
            }
        });
        cancel.setOnMouseClicked(e -> {
            stage.close();
        });

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(ok, cancel);
        hBox1.getChildren().add(textField);
        hBox2.getChildren().add(date);
        hBox3.getChildren().add(priority);

        vbox.getChildren().add(hBox1);
        vbox.getChildren().add(hBox2);
        vbox.getChildren().add(hBox3);
        vbox.getChildren().add(hBox);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.showAndWait();

    }
    public void takeTask(Schedule page1) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Task");

        VBox vbox = new VBox();
        vbox.setStyle("-fx-spacing: 10; -fx-background-color: blur;");


        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10));
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10));
        hBox2.setAlignment(Pos.CENTER);
        HBox hBox3 = new HBox();
        hBox3.setPadding(new Insets(10));
        hBox3.setAlignment(Pos.CENTER);


        TextField textField = new TextField();
        textField.setPromptText("Please enter the task");

        DatePicker date = new DatePicker();
        date.setPromptText("Select date-time");
        LocalDate localDate= LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
        date.setValue(localDate);


        ComboBox<String> priority= new ComboBox<>();
        priority.setPromptText("Select Priority");
        priority.getItems().addAll("PRIORITY", "NO-PRIORITY");
        priority.setValue("NO-PRIORITY");

        Button ok = new Button("Add");
        Button cancel = new Button("Cancel");
        ok.setOnMouseClicked(e -> {
            if (textField.getText().isEmpty()) {
                textField.setPromptText("please fill the info");
            } else {
                page1.addTaskInfo(textField.getText(), date.getValue().toString(), priority.getValue());
                try{
                    fileWriter.writeInformation(textField.getText(), date.getValue().toString(), priority.getValue());
                } catch (Exception p){
                    System.out.println("problem found in file writing");
                }
                stage.close();
            }
        });
        cancel.setOnMouseClicked(e -> {
            stage.close();
        });

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(ok, cancel);
        hBox1.getChildren().add(textField);
        hBox2.getChildren().add(date);
        hBox3.getChildren().add(priority);

        vbox.getChildren().add(hBox1);
        vbox.getChildren().add(hBox2);
        vbox.getChildren().add(hBox3);
        vbox.getChildren().add(hBox);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.showAndWait();

    }
    public void takeTask(Today page1) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Task");

        VBox vbox = new VBox();
        vbox.setStyle("-fx-spacing: 10; -fx-background-color: blur;");


        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10));
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10));
        hBox2.setAlignment(Pos.CENTER);
        HBox hBox3 = new HBox();
        hBox3.setPadding(new Insets(10));
        hBox3.setAlignment(Pos.CENTER);


        TextField textField = new TextField();
        textField.setPromptText("Please enter the task");

        DatePicker date = new DatePicker();
        date.setPromptText("Select date-time");
        LocalDate localDate= LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
        date.setValue(localDate);


        ComboBox<String> priority= new ComboBox<>();
        priority.setPromptText("Select Priority");
        priority.getItems().addAll("PRIORITY", "NO-PRIORITY");
        priority.setValue("NO-PRIORITY");

        Button ok = new Button("Add");
        Button cancel = new Button("Cancel");
        ok.setOnMouseClicked(e -> {
            if (textField.getText().isEmpty()) {
                textField.setPromptText("please fill the info");
            } else {
                page1.addTaskInfo(textField.getText(), date.getValue().toString(), priority.getValue());
                try{
                    fileWriter.writeInformation(textField.getText(), date.getValue().toString(), priority.getValue());
                } catch (Exception p){
                    System.out.println("problem found in file writing");
                }
                stage.close();
            }
        });
        cancel.setOnMouseClicked(e -> {
            stage.close();
        });

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(ok, cancel);
        hBox1.getChildren().add(textField);
        hBox2.getChildren().add(date);
        hBox3.getChildren().add(priority);

        vbox.getChildren().add(hBox1);
        vbox.getChildren().add(hBox2);
        vbox.getChildren().add(hBox3);
        vbox.getChildren().add(hBox);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.showAndWait();

    }
    public void takeTask(Priority page1) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Task");

        VBox vbox = new VBox();
        vbox.setStyle("-fx-spacing: 10; -fx-background-color: blur;");


        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10));
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10));
        hBox2.setAlignment(Pos.CENTER);
        HBox hBox3 = new HBox();
        hBox3.setPadding(new Insets(10));
        hBox3.setAlignment(Pos.CENTER);


        TextField textField = new TextField();
        textField.setPromptText("Please enter the task");

        DatePicker date = new DatePicker();
        date.setPromptText("Select date-time");
        LocalDate localDate= LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
        date.setValue(localDate);


        ComboBox<String> priority= new ComboBox<>();
        priority.setPromptText("Select Priority");
        priority.getItems().addAll("PRIORITY", "NO-PRIORITY");
        priority.setValue("NO-PRIORITY");

        Button ok = new Button("Add");
        Button cancel = new Button("Cancel");
        ok.setOnMouseClicked(e -> {
            if (textField.getText().isEmpty()) {
                textField.setPromptText("please fill the info");
            } else {
                page1.addTaskInfo(textField.getText(), date.getValue().toString(), priority.getValue());
                try{
                    fileWriter.writeInformation(textField.getText(), date.getValue().toString(), priority.getValue());
                } catch (Exception p){
                    System.out.println("problem found in file writing");
                }
                stage.close();
            }
        });
        cancel.setOnMouseClicked(e -> {
            stage.close();
        });

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(ok, cancel);
        hBox1.getChildren().add(textField);
        hBox2.getChildren().add(date);
        hBox3.getChildren().add(priority);

        vbox.getChildren().add(hBox1);
        vbox.getChildren().add(hBox2);
        vbox.getChildren().add(hBox3);
        vbox.getChildren().add(hBox);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.showAndWait();

    }
}
