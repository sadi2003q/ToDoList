package com.example.newtodo;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Schedule {
    @FXML
    private Stage stage;
    public ArrayList<String> taskInfo = new ArrayList<>();
    private double currentPosition = 90.0;

    public DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private LocalDate currentDate = LocalDate.now();
    @FXML
    private Button addButton;
    @FXML
    private Button changeToScheduleButton;
    @FXML
    private Button todayButton;
    @FXML
    private Button changeToPriority;
    @FXML
    private AnchorPane main;
    EventHandler<MouseEvent> blueCircleHandler = mouseEvent -> {

        Circle clickedCircle = (Circle) mouseEvent.getSource();
        Parent parent= clickedCircle.getParent();
        ObservableList<Node> list= parent.getChildrenUnmodifiable();

        for(Node node: list){
            if(node instanceof FlowPane){
                ObservableList<Node> pane= ((FlowPane) node).getChildren();
                for(Node newNode: pane){
                    if(newNode instanceof Text){
                        String[] parts= ((Text) newNode).getText().split("\n");
                        try {
                            new fileWriter().writeInformationComplete(parts[0], parts[1], parts[2]);
                            new fileWriter().deleteTask(parts[0]);
                        } catch (Exception e) {
                            System.out.println("unable to send into fileWriter to insert into c_taskFIle");
                        }
                    }else{
                        System.out.println("no text Node found");
                    }
                }
            }
        }
        HBox hbox = findParentHBox(clickedCircle);
        if (hbox == null) {
            System.err.println("Parent HBox not found.");
            return;
        }
        main.getChildren().remove(hbox);

        double newYPosition = hbox.getLayoutY();

        for (Node node : main.getChildren()) {
            if (node instanceof HBox currentHBox) {
                if (currentHBox != hbox && currentHBox.getLayoutY() > newYPosition) {
                    currentHBox.setLayoutY(newYPosition);
                    newYPosition += currentHBox.getBoundsInLocal().getHeight() + 10.0;
                }
            }
        }
    };
    private HBox findParentHBox(Circle circle) {
        Node parent = circle.getParent();
        while (parent != null) {
            if (parent instanceof HBox) {
                return (HBox) parent;
            }
            parent = parent.getParent();
        }
        return null;
    }
    public void ChangeToMain(Event e) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("page1.fxml"));
        Parent root = loader.load();
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void ChangeToComplete(Event e) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("complete.fxml"));
        Parent root = loader.load();
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void ChangeToToday(Event e) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("today.fxml"));
        Parent root = loader.load();
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void ChangeToPriority(Event e) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("priority.fxml"));
        Parent root = loader.load();
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static EventHandler<MouseEvent> redCircleHandler(HBox hbox, AnchorPane main, Schedule controller, FlowPane flowPane, double currentPosition){
        return mouseEvent -> {
            Circle circle = (Circle) mouseEvent.getSource();
            Parent parent= circle.getParent();
            ObservableList<Node> list= parent.getChildrenUnmodifiable();

            for(Node node: list){
                if(node instanceof FlowPane){
                    ObservableList<Node> pane= ((FlowPane) node).getChildren();
                    for(Node newNode : pane){
                        if(newNode instanceof Text){
                            String[] line=(((Text) newNode).getText()).split("\n");
                            try {
                                new fileWriter().deleteTask(line[0]);
                            } catch (IOException e) {
                                System.out.println("some problem is found for deleting");
                            }
                        }
                    }
                }else{
                    System.out.println("flowPane not found");
                }
            }

            main.getChildren().remove(hbox);
            controller.currentPosition = currentPosition-(flowPane.getBoundsInLocal().getHeight()+35.0);
            double newYPosition = hbox.getLayoutY();

            for (Node node : main.getChildren()) {
                if (node instanceof HBox currentHBox) {
                    if (currentHBox != hbox && currentHBox.getLayoutY() > newYPosition) {
                        currentHBox.setLayoutY(newYPosition);
                        newYPosition += currentHBox.getBoundsInLocal().getHeight() + 20.0;
                    }
                }
            }
        };
    }
    public void addTaskInfo(String task, String date, String priority) {
        this.taskInfo.add(task);
        this.taskInfo.add(date);
        this.taskInfo.add(priority);
    }
    public void showToCanvas() {
        TaskRelated taskRelated = new TaskRelated();
        taskRelated.takeTask(this); // Pass a reference to this Page1 instance

        HBox hbox = new maker().makeHbox();
        Circle circle1 = new maker().makeCircleBlue();
        Circle circle2 = new maker().makeCircleRed();
        FlowPane flowPane = new maker().makeFlowpane(taskInfo.get(0), taskInfo.get(1), taskInfo.get(2));

        hbox.getChildren().add(circle1);
        hbox.getChildren().add(circle2);
        hbox.getChildren().add(flowPane);

        HBox.setMargin(circle1, new Insets(10.0, 0, 0, 0));
        HBox.setMargin(circle2, new Insets(10.0, 0, 0, 0));


        LocalDate taskDate = LocalDate.parse(taskInfo.get(1), format);
        if(taskDate.isAfter(currentDate)){
            new Page1().showToCanvas3(taskInfo.get(0), taskInfo.get(1), taskInfo.get(2));
            main.getChildren().add(hbox);
        }else{
            new Page1().showToCanvas3(taskInfo.get(0), taskInfo.get(1), taskInfo.get(2));
        }



        hbox.setLayoutY(currentPosition);
        currentPosition += hbox.getHeight() + 20.0;
        currentPosition += flowPane.getBoundsInLocal().getHeight()+20.0;
        circle1.setOnMouseClicked(blueCircleHandler);
        circle2.setOnMouseClicked(redCircleHandler(hbox, main, this, flowPane, currentPosition));

        taskInfo.clear();
    }
    public void showToCanvas2(){
        HBox hbox = new maker().makeHbox();
        Circle circle1 = new maker().makeCircleBlue();
        Circle circle2 = new maker().makeCircleRed();
        FlowPane flowPane = new maker().makeFlowpane(taskInfo.get(0), taskInfo.get(1), taskInfo.get(2));

        hbox.getChildren().add(circle1);
        hbox.getChildren().add(circle2);
        hbox.getChildren().add(flowPane);

        HBox.setMargin(circle1, new Insets(10.0, 0, 0, 0));
        HBox.setMargin(circle2, new Insets(10.0, 0, 0, 0));

        main.getChildren().add(hbox);

        hbox.setLayoutY(currentPosition);
        currentPosition += hbox.getHeight() + 20.0;
        currentPosition += flowPane.getBoundsInLocal().getHeight()+20.0;
        circle1.setOnMouseClicked(blueCircleHandler);
        circle2.setOnMouseClicked(redCircleHandler(hbox, main, this, flowPane, currentPosition));

        taskInfo.clear();
    }
    public void showToCanvas3(String s1, String s2, String s3){
        HBox hbox = new maker().makeHbox();
        Circle circle1 = new maker().makeCircleBlue();
        Circle circle2 = new maker().makeCircleRed();
        FlowPane flowPane = new maker().makeFlowpane(s1, s2, s3);

        hbox.getChildren().add(circle1);
        hbox.getChildren().add(circle2);
        hbox.getChildren().add(flowPane);

        HBox.setMargin(circle1, new Insets(10.0, 0, 0, 0));
        HBox.setMargin(circle2, new Insets(10.0, 0, 0, 0));

        main.getChildren().add(hbox);

        hbox.setLayoutY(currentPosition);
        currentPosition += hbox.getHeight() + 20.0;
        currentPosition += flowPane.getBoundsInLocal().getHeight()+20.0;
        circle1.setOnMouseClicked(blueCircleHandler);
        circle2.setOnMouseClicked(redCircleHandler(hbox, main, this, flowPane, currentPosition));

        taskInfo.clear();
    }
    public void initialize() {
        loadTasksFromFileAndShow();
    }
    private void loadTasksFromFileAndShow() {
        try {
            ArrayList<ArrayList<String>> taskInfoList = fileReader.readTasksFromFile();

            for (ArrayList<String> taskInfo : taskInfoList) {
                LocalDate taskDate = LocalDate.parse(taskInfo.get(1), format);
                if(taskDate.isAfter(currentDate)){
                    addTaskInfo(taskInfo.get(0), taskInfo.get(1), taskInfo.get(2));
                    showToCanvas2();
                }
//                addTaskInfo(taskInfo.get(0), taskInfo.get(1), taskInfo.get(2));
//                showToCanvas2();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
