import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
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
    HBox hbmile = new HBox(5);
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
    Button btdisplay = new Button("Display");
    Label labelttmile = new Label("Total Mileage: ");
    Label labelyourmile = new Label();
    ListView<Cities> lvtripstops;
    ArrayList<Circle> circles = new ArrayList<>();
    ArrayList<Line> lines = new ArrayList<>();
    ObservableList<Cities> olstops = FXCollections.observableArrayList();
    ObservableList<Cities> oltrips = FXCollections.observableArrayList();
    ListView<Cities> lvpossiblestops;
    Cities possibleStopSelected;
    Cities tripsStopSelected;
    FileChooser fcsave = new FileChooser();
    FileChooser fcopen = new FileChooser();
    double distance;
    int whatuchose;
    DecimalFormat df = new DecimalFormat("#.00");
    Pane pane = new Pane();
    File txtpossibleplace = new File("PossiblePlaceToGo.txt");
    File txtdefault = new File("default.txt");
    FileChooser.ExtensionFilter txtfile = new FileChooser.ExtensionFilter("ONLY TEXT FILE!(.txt)","*.txt");

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
        loadStopsFromFile(txtpossibleplace,olstops);
        loadStopsFromFile(txtdefault,oltrips);

        //Setting stage
        window = primaryStage;
        window.setTitle("TripPlan-default");

        //Main Pane(border pane)
        //Set up the top Menu
        hbmainmenu.getChildren().addAll(btNew, btSave, btLoad);
        hbmainmenu.setPadding(new Insets(20, 20, 20, 20));
        hbmainmenu.getStyleClass().add("hboxtop");
        hbmainmenu.setPrefHeight(50);


        //Set up the Image(Center part)
        LeftImageView.setFitHeight(500);
        LeftImageView.setFitWidth(900);
        LeftImageView.setPreserveRatio(false);
        LeftImageView.setImage(MapImage);


        //Setting possible stops
        lvpossiblestops = new ListView<>();
        lvpossiblestops.setItems(olstops);
        lvpossiblestops.setPrefWidth(200);
        lvpossiblestops.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        lvpossiblestops.getSelectionModel().select(0);
        possibleStopSelected = olstops.get(0);
        lvpossiblestops.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                possibleStopSelected = lvpossiblestops.getSelectionModel().getSelectedItem();
                tfCity.setText(possibleStopSelected.getName());
                tfState.setText(possibleStopSelected.getState());
                tflatde.setText(String.valueOf(possibleStopSelected.getLatDe()));
                tflatmin.setText(String.valueOf(possibleStopSelected.getLatM()));
                tflongde.setText(String.valueOf(possibleStopSelected.getLongde()));
                tflongmin.setText(String.valueOf(possibleStopSelected.getLongm()));
                checkIfInteger(tflatde);
                checkIfInteger(tflatmin);
                checkIfInteger(tflongde);
                checkIfInteger(tflongmin);
            }
        });


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
        gpuserinput.getStyleClass().add("gpuserinput");

        //Set up button "update"
        btupdate.setOnAction(e->{
            possibleStopSelected.setName(tfCity.getText());
            possibleStopSelected.setState(tfState.getText());
            possibleStopSelected.setLatDe(Integer.parseInt(tflatde.getText()));
            possibleStopSelected.setLatM(Integer.parseInt(tflatmin.getText()));
            possibleStopSelected.setLongde(Integer.parseInt(tflongde.getText()));
            possibleStopSelected.setLongm(Integer.parseInt(tflongmin.getText()));
            writeToFile(txtpossibleplace,olstops);
            AlertBox.update();
        });
        //Set up possible stops plus button
        btstopsadd.getStyleClass().add("buttonAddAndSubtract");
        btstopsadd.setOnAction(e->{
            Cities Newone = new Cities("Name","State",0,0,0,0);
            olstops.add(Newone);
        });
        //Set up possible stops subtract button
        btstopssubtract.getStyleClass().add("buttonAddAndSubtract");
        btstopssubtract.setOnAction(e->{
            AlertBox.AreYourSure("Are you sure you wanna delete this stop?");
            if (AlertBox.answer){
                olstops.remove(possibleStopSelected);
            }
        });
        //Set up "NEW" trip button;
        btNew.setOnAction(e->{
            AlertBox.AreYourSure("Sure? Did u saved this one?");
            if (AlertBox.answer){
                oltrips.clear();
                pane.getChildren().clear();
                AlertBox.Nameit("What do you wanna call your new Trip?");
                window.setTitle(AlertBox.name);
                writeToFile(new File(AlertBox.name+".txt"),oltrips);
            }
        });

        //Set up "Save" button
        btSave.setOnAction(e->{
            fcsave.setTitle("Where you wanna save your trip?");
            fcsave.getExtensionFilters().add(txtfile);
            File f = fcsave.showSaveDialog(window);
            if(f !=null){
                writeToFile(f,oltrips);
            }
        });
        //Set up "Load" button
        btLoad.setOnAction(e->{
            fcopen.setTitle("Which file?");
            fcopen.getExtensionFilters().add(txtfile);
            File f = fcopen.showOpenDialog(window);
            if (f != null){
                oltrips.clear();
                loadStopsFromFile(f,oltrips);
                window.setTitle(f.getName().substring(0,f.getName().length()-4));
            }
        });


        //Set the Trips part
        lvtripstops = new ListView<>();
        lvtripstops.setItems(oltrips);
        lvtripstops.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        lvtripstops.prefWidth(200);
        lvtripstops.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tripsStopSelected = lvtripstops.getSelectionModel().getSelectedItem();
                whatuchose = lvtripstops.getSelectionModel().getSelectedIndex();
            }
        });

        //Set up trip stops add button
        bttripsadd.getStyleClass().add("buttonAddAndSubtract");
        bttripsadd.setOnAction(e->{
            if (lvtripstops.getSelectionModel().getSelectedItem()==null){
                oltrips.add(possibleStopSelected);
                calculatedistance();
            }else{
                oltrips.add(whatuchose+1,possibleStopSelected);
                calculatedistance();
            }


        });
        //Set up trip stops subtract button
        bttripsubtract.getStyleClass().add("buttonAddAndSubtract");
        bttripsubtract.setOnAction(e->{
            AlertBox.AreYourSure("Are you sure You don't wanna go for this place?");
            if(AlertBox.answer){
                oltrips.remove(tripsStopSelected);
                calculatedistance();
            }
        });

        //Set up total mileage display
        hbmile.getChildren().addAll(labelttmile,labelyourmile);

        btdisplay.setOnAction(e->{
            int a = 0;
            int b =0;
            circles.clear();
            lines.clear();
            pane.getChildren().clear();
            for(int i = 0; i<oltrips.size();i++){
                circles.add(new Circle((124.8-(oltrips.get(i).getLongde()+((oltrips.get(i).getLongm())/100)))*15,
                        (49-(oltrips.get(i).getLatDe()+((oltrips.get(i).getLatM())/100)))*20,5,Color.CORAL));
                if (i>=1){
                    lines.add(new Line((124.8-(oltrips.get(i-1).getLongde()+((oltrips.get(i-1).getLongm())/100)))*15,
                            (49-(oltrips.get(i-1).getLatDe()+((oltrips.get(i-1).getLatM())/100)))*20,
                            (124.8-(oltrips.get(i).getLongde()+((oltrips.get(i).getLongm())/100)))*15,
                            (49-(oltrips.get(i).getLatDe()+((oltrips.get(i).getLatM())/100)))*20));
                }
            }
            while (a<circles.size()){
                pane.getChildren().add(circles.get(a));
                a++;
            }
            while (b<lines.size()){
                lines.get(b).setStroke(Color.CORAL);
                pane.getChildren().add(lines.get(b));
                b++;
            }
        });




        //Set up the center part
        hbtrips.getChildren().addAll(labelTripStops, bttripsadd, bttripsubtract);
        hbtrips.setSpacing(5);
        vbtrips.getChildren().addAll(hbtrips,lvtripstops,hbmile,btdisplay);
        vbtrips.getStyleClass().add("vboxcenter");
        vbtrips.setPrefWidth(392);
        hbtrips.setPadding(new Insets(20, 20, 20, 20));
        centerpart.add(LeftImageView, 0, 0);
        centerpart.add(pane,0,0);
        centerpart.add(vbtrips, 1, 0);
        centerpart.setPrefHeight(500);




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

    public void checkIfInteger(TextField textField){
        textField.textProperty().addListener((observable, oldValue, newValue) ->{
            if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                textField.setText(oldValue);
            }
        } );
    }


    public void loadStopsFromFile(File f,ObservableList<Cities> observableList) {
        try {
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            while (fis.available() > 0) {
                String name = dis.readUTF();
                String state = dis.readUTF();
                int latDe = dis.readInt();
                int latM = dis.readInt();
                int longde = dis.readInt();
                int longm = dis.readInt();
                observableList.add(new Cities(name,state,latDe,latM,longde,longm));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public  void writeToFile(File f,ObservableList<Cities> observableList){
        DataOutputStream dos;
        try{
            FileOutputStream fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);

            for(int i =0; i<observableList.size();i++){
                dos.writeUTF(observableList.get(i).getName());
                dos.writeUTF(observableList.get(i).getState());
                dos.writeInt(observableList.get(i).getLatDe());
                dos.writeInt(observableList.get(i).getLatM());
                dos.writeInt(observableList.get(i).getLongde());
                dos.writeInt(observableList.get(i).getLongm());
            }
            dos.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public Image loadImage(String imageFileURL){
        Image image = new Image(imageFileURL);
        if (!image.isError()) {
            return image;
        }
        else
            return null;

    }
    public void  calculatedistance(){
        distance = 0;
        double x;
        double RF = 180/Math.PI;
        for(int i =0; i <oltrips.size()-1;i++){
            x = ((Math.sin(oltrips.get(i).getLatDe()/RF))*(Math.sin(oltrips.get(i+1).getLatDe()/RF)))+
                    ((Math.cos(oltrips.get(i).getLatDe()/RF))*(Math.cos(oltrips.get(i+1).getLatDe()/RF))*(Math.cos((oltrips.get(i).getLongde()/RF)-(oltrips.get(i+1).getLongde()/RF))));
            distance += (6371*Math.atan((Math.sqrt(1-Math.pow(x,2))/x)));
        }
        labelyourmile.setText(String.valueOf(df.format(distance)));
    }

}
