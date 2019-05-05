import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {
    Stage window;
    Scene Mainscene;
    String ImageURL = "file:./images/usa_map.jpg";
    Label labelTripStops = new Label("TripStops");
    Label labelPossiblestops = new Label("Possible Stops              ");
    Image MapImage = loadImage(ImageURL);
    BorderPane borderPane = new BorderPane();
    HBox mainmenu = new HBox(20);
    VBox tripsvbox = new VBox(10);
    HBox tripshbox = new HBox(10);
    GridPane centerpart = new GridPane();
    HBox stopschoice = new HBox();
    GridPane bottompart = new GridPane();
    GridPane userinput = new GridPane();
    Button tripsadd = new Button("+");
    Button tripsubtract = new Button("-");
    Button stopsadd = new Button("+");
    Button stopssubtract = new Button("-");
    ImageView LeftImageView = new ImageView();
    Button New = new Button("New");
    Button Save = new Button("Save");
    Button Load = new Button("Load");
    ListView<String> citiesListView;
    ObservableList<Cities> stops = FXCollections.observableArrayList();
    ListView<Cities> possibleStops;
    private TextField tfCity;
    private TextField tfState;
    private TextField tflatde;
    private TextField tflatmin;
    private TextField tflongde;
    private TextField tflongmin;
    Button update = new Button("Update");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //load stops from file
        loadStopsFromFile("PossiblePlaceToGo.text");

        //Setting stage
        window = primaryStage;
        window.setTitle("TripPlan");

        //Main Pane(border pane)
        //Set up the top Menu
        mainmenu.getChildren().addAll(New, Save, Load);
        mainmenu.setPadding(new Insets(20, 20, 20, 20));
        mainmenu.getStyleClass().add("hboxtop");
        mainmenu.setPrefHeight(50);


        //Set up the Image(Center part)
        LeftImageView.setFitHeight(500);
        LeftImageView.setPreserveRatio(true);
        LeftImageView.setImage(MapImage);


        //Set up the center part
        tripshbox.getChildren().addAll(labelTripStops, tripsadd, tripsubtract);
        tripshbox.setSpacing(5);
        tripsvbox.getChildren().addAll(tripshbox);
        tripsvbox.getStyleClass().add("vboxcenter");
        tripsvbox.setPrefWidth(350);
        tripshbox.setPadding(new Insets(20, 20, 20, 20));
        centerpart.add(LeftImageView, 0, 0);
        centerpart.add(tripsvbox, 1, 0);
        centerpart.setPrefHeight(500);
        /*还没加listView */

        //Setting possible stops
        possibleStops = new ListView<>();
        possibleStops.setItems(stops);
        possibleStops.setPrefWidth(100);
        //Set up the bottom part
        stopschoice.getChildren().addAll(stopsadd, stopssubtract);
        bottompart.add(labelPossiblestops, 0, 0);
        bottompart.add(stopschoice, 1, 0);
        bottompart.add(userinput, 1, 1);
        bottompart.add(possibleStops,0,1);
        bottompart.setPadding(new Insets(20, 20, 20, 20));
        bottompart.setHgap(10);
        bottompart.setPrefHeight(430);
        bottompart.getStyleClass().add("bottompart");



        //Set up userinput view(bottom)
        tfCity = new TextField();
        tfState = new TextField();
        tflatde = new TextField();
        tflatmin = new TextField();
        tflongde = new TextField();
        tflongmin = new TextField();
        userinput.add(new Label("City:"), 0, 0);
        userinput.add(new Label("State:"), 0, 1);
        userinput.add(new Label("latitude Degree:"), 0, 2);
        userinput.add(new Label("latitude Minutes: "), 0, 3);
        userinput.add(new Label("longitude Degree: "), 0, 4);
        userinput.add(new Label("longitude Minutes: "), 0, 5);
        userinput.add(tfCity, 1, 0);
        userinput.add(tfState, 1, 1);
        userinput.add(tflatde, 1, 2);
        userinput.add(tflatmin, 1, 3);
        userinput.add(tflongde, 1, 4);
        userinput.add(tflongmin, 1, 5);
        userinput.add(update, 0, 6);


        //Set up scene
        borderPane.setTop(mainmenu);
        borderPane.setCenter(centerpart);
        borderPane.setBottom(bottompart);
        Mainscene = new Scene(borderPane, 1300, 1000);

        //Set up Stage
        Mainscene.getStylesheets().add("style.css");
        window.setScene(Mainscene);
        window.show();

    }

    public void loadStopsFromFile(String fileName) {
        try {
            File f = new File(fileName);
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            while (fis.available() > 0) {
                String name = dis.readUTF();
                int latDe = dis.readInt();
                int latM = dis.readInt();
                String latDi = dis.readUTF();
                int longde = dis.readInt();
                int longm = dis.readInt();
                String longDi = dis.readUTF();
                stops.add(new Cities(name,latDe,latM,latDi,longde,longm,longDi));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**Image file 等下可以放到最后*/
    public Image loadImage(String imageFileURL){
        Image image = new Image(imageFileURL);
        if (!image.isError()) {
            return image;
        }
        else
            return null;

    }

}
