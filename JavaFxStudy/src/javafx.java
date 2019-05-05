import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class javafx extends Application {

    Stage window;
    Scene scene1;
    Button button1;
    Scene scene2;

    @Override
    public void start(Stage primaryStage) {
        //init settings
        window = primaryStage;
        window.setTitle("My stage");
        //GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);

        Label label = new Label("Name: ");
        GridPane.setConstraints(label,0,0);
        TextField nameinput = new TextField();
        GridPane.setConstraints(nameinput,1,0);

        Label Passwords = new Label("Password: ");
        GridPane.setConstraints(Passwords,0,1);
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("password");
        GridPane.setConstraints(passwordInput,1,1);

        grid.getChildren().addAll(label,nameinput,Passwords,passwordInput);



        //button
        button1 = new Button("Touch me");
        //这个“layout”板块的设置
        StackPane layout = new StackPane();
        layout.getChildren().add(button1);
        //Scene settings;
        scene1 = new Scene(layout,300,300);
        scene2 = new Scene(grid,300,200);
        //显示这个window
        window.setScene(scene2);
        window.show();
        //button 的作用
        button1.setOnAction(e -> {
             boolean result = confirmbox.display("title~~","Try to use these buttons!");
            System.out.println(result);
        });



    }

    public static void main (String[] args){launch(args);}
}
