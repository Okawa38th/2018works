import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;




public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;
    ListView<String > listView;
    Text t = new Text();

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("It's just a title");
        button = new Button("Try me");
        t.setText("TEST!!!");
        t.setFont(Font.font(20));





        listView = new ListView<>();
        listView.getItems().addAll("frankie","percy","JingYe","zuile","zuile","zuile","zuile","zuile","zuile","zuile");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        button.setOnAction( e-> TryMeButton());

        HBox layout = new HBox();
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(listView,button,t);

        scene = new Scene(layout,400,400);
        window.setScene(scene);
        window.show();


    }


    public void TryMeButton(){
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            String message = "";
                ObservableList<String> names;
            @Override
            public void handle(MouseEvent event) {
                names = listView.getSelectionModel().getSelectedItems();
                for (String n: names){
                    message += n + "\n";
                }
                System.out.println(message);
            }
        });

    }

    public static void main(String[] args){
        launch(args);
    }
}