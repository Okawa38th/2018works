import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AlertBox {

    static boolean answer;
    static String name = "null";
    public static void update() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(200);
        window.setMinHeight(200);

        Label label = new Label("Update Successful");
        Button button = new Button("OK");
        button.setOnAction(e -> window.close());

        VBox pane = new VBox(10);
        pane.getChildren().addAll(label, button);
        pane.setAlignment(Pos.CENTER);
        pane.getStyleClass().add("AleartBox");
        Scene scene = new Scene(pane);
        scene.getStylesheets().add("style.css");
        window.setScene(scene);
        window.showAndWait();

    }

    public static boolean AreYourSure(String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(200);
        window.setMinHeight(200);

        Label label = new Label(message);
        Button yes = new Button("Yup");
        Button nope = new Button("Nah nah");
        yes.setOnAction(e -> {
            window.close();
            answer = true;
        });
        nope.setOnAction(e->{
            window.close();
            answer = false;
        });

        VBox pane = new VBox(10);
        pane.getChildren().addAll(label, yes, nope);
        pane.setAlignment(Pos.CENTER);
        pane.getStyleClass().add("AleartBox");
        Scene scene = new Scene(pane);
        scene.getStylesheets().add("style.css");
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }
    public static void Nameit(String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(400);
        window.setMinHeight(400);

        Label label = new Label(message);
        TextField textField = new TextField();
        textField.setPromptText("Name");
        Button yes = new Button("That's it!");
        Button no = new Button("Wait a min");

        yes.setOnAction(e->{
            window.close();
            name = textField.getText();
        });
        no.setOnAction(e->{
            textField.clear();
        });
        VBox pane = new VBox(10);
        HBox buttonpane = new HBox(10);
        buttonpane.getChildren().addAll(yes,no);
        buttonpane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(label,textField,buttonpane);
        pane.setAlignment(Pos.CENTER);
        pane.getStyleClass().add("AleartBox");
        Scene scene = new Scene(pane);
        scene.getStylesheets().add("style.css");
        window.setScene(scene);
        window.showAndWait();
    }

}
