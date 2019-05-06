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

import java.io.*;
import java.util.ArrayList;


public class Main extends Application {
    Stage window;
    Scene Mainscene;
    String ImageURL = "file:./images/usa_map.jpg";
    Label labelTripStops = new Label("TripStops");
    Label labelPossiblestops = new Label("Possible Stops              ");
    Image MapImage = loadImage(ImageURL);
    BorderPane borderPane = new BorderPane();
    HBox hbmainmenu = new HBox(20);
    VBox vbtrips = new VBox(10);
    HBox hbtrips = new HBox(10);
    GridPane centerpart = new GridPane();
    HBox hbstopschoice = new HBox();
    GridPane gpbottompart = new GridPane();
    GridPane gpuserinput = new GridPane();
    Button bttripsadd = new Button("+");
    Button bttripsubtract = new Button("-");
    Button btstopsadd = new Button("+");
    Button btstopssubtract = new Button("-");
    ImageView LeftImageView = new ImageView();
    Button btNew = new Button("New");
    Button btSave = new Button("Save");
    Button btLoad = new Button("Load");
    ListView<String> lvcities;
    ObservableList<Cities> olstops = FXCollections.observableArrayList();
    ListView<Cities> lvpossiblestops;
    private TextField tfCity;
    private TextField tfState;
    private TextField tflatde;
    private TextField tflatmin;
    private TextField tflongde;
    private TextField tflongmin;
    Button btupdate = new Button("Update");


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
        hbmainmenu.getChildren().addAll(btNew, btSave, btLoad);
        hbmainmenu.setPadding(new Insets(20, 20, 20, 20));
        hbmainmenu.getStyleClass().add("hboxtop");
        hbmainmenu.setPrefHeight(50);


        //Set up the Image(Center part)
        LeftImageView.setFitHeight(500);
        LeftImageView.setPreserveRatio(true);
        LeftImageView.setImage(MapImage);


        //Set up the center part
        hbtrips.getChildren().addAll(labelTripStops, bttripsadd, bttripsubtract);
        hbtrips.setSpacing(5);
        vbtrips.getChildren().addAll(hbtrips);
        vbtrips.getStyleClass().add("vboxcenter");
        vbtrips.setPrefWidth(350);
        hbtrips.setPadding(new Insets(20, 20, 20, 20));
        centerpart.add(LeftImageView, 0, 0);
        centerpart.add(vbtrips, 1, 0);
        centerpart.setPrefHeight(500);
        /*还没加listView */

        //Setting possible stops
        lvpossiblestops = new ListView<>();
        lvpossiblestops.setItems(olstops);
        lvpossiblestops.setPrefWidth(200);
        //Set up the bottom part
        hbstopschoice.getChildren().addAll(btstopsadd, btstopssubtract);
        gpbottompart.add(labelPossiblestops, 0, 0);
        gpbottompart.add(hbstopschoice, 1, 0);
        gpbottompart.add(gpuserinput, 1, 1);
        gpbottompart.add(lvpossiblestops,0,1);
        gpbottompart.setPadding(new Insets(20, 20, 20, 20));
        gpbottompart.setHgap(10);
        gpbottompart.setPrefHeight(430);
        gpbottompart.getStyleClass().add("bottompart");




        //Set up userinput view(bottom)
        tfCity = new TextField();
        tfState = new TextField();
        tflatde = new TextField();
        tflatmin = new TextField();
        tflongde = new TextField();
        tflongmin = new TextField();
        gpuserinput.add(new Label("City:"), 0, 0);
        gpuserinput.add(new Label("State:"), 0, 1);
        gpuserinput.add(new Label("latitude Degree:"), 0, 2);
        gpuserinput.add(new Label("latitude Minutes: "), 0, 3);
        gpuserinput.add(new Label("longitude Degree: "), 0, 4);
        gpuserinput.add(new Label("longitude Minutes: "), 0, 5);
        gpuserinput.add(tfCity, 1, 0);
        gpuserinput.add(tfState, 1, 1);
        gpuserinput.add(tflatde, 1, 2);
        gpuserinput.add(tflatmin, 1, 3);
        gpuserinput.add(tflongde, 1, 4);
        gpuserinput.add(tflongmin, 1, 5);
        gpuserinput.add(btupdate, 0, 6);


        //Set up scene
        borderPane.setTop(hbmainmenu);
        borderPane.setCenter(centerpart);
        borderPane.setBottom(gpbottompart);
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
                olstops.add(new Cities(name,latDe,latM,latDi,longde,longm,longDi));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void writeStoptoFile(String finleName){
        DataOutputStream dos;
        try{
            File f = new File(filename);
            FileOutputStream fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);

            for(int i =0; i<cities.size();i++){
                dos.writeUTF(cities.get(i).getName());
                dos.writeInt(cities.get(i).getLatDe());
                dos.writeInt(cities.get(i).getLatM());
                dos.writeUTF(cities.get(i).getLatDi());
                dos.writeInt(cities.get(i).getLongde());
                dos.writeInt(cities.get(i).getLongm());
                dos.writeUTF(cities.get(i).getLongDi());
            }
            dos.close();
        }catch (IOException ioe){
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
