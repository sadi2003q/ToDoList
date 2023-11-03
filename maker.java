package com.example.newtodo;

import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class maker {
    private double currentPosition = 50.0;
    public HBox makeHbox(){
        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: transparent; -fx-border-radius: 3px; -fx-spacing: 10px");
        hbox.setMaxWidth(280);
        hbox.setLayoutY(currentPosition+20);
        currentPosition+=hbox.getLayoutY()+hbox.getHeight();
        return hbox;
    }
    public Circle makeCircleBlue(){
        Circle circle = new Circle(10.0);
        circle.setFill(Color.DODGERBLUE);
        circle.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        return circle;
    }
    public Circle makeCircleRed(){
        Circle circle = new Circle(10.0);
        circle.setFill(Color.RED);
        circle.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        return circle;
    }
    public FlowPane makeFlowpane(String task, String date, String priority){
        Text textNode= new Text(task+"\n"+priority+"\n"+date);
        textNode.setFont(Font.font("BM HANNA Pro OTF", 15));
        textNode.setFill(Color.BLACK);
        textNode.setWrappingWidth(250.0);

        FlowPane flowPane= new FlowPane();
        flowPane.setPadding(new Insets(15));
        flowPane.setStyle("-fx-border-color: green; -fx-border-radius: 15px; -fx-padding: 15; -fx-background-color: transparent;");
        currentPosition +=flowPane.getBoundsInLocal().getHeight()+10.0;
        flowPane.getChildren().add(textNode);

        return flowPane;
    }
}
