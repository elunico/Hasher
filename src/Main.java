import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Thomas Povinelli
 * Created 2017-Aug-30
 * In Hasher
 */
public class Main extends Application {
    public static void main(String[] args)
    {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label = new Label("Enter text below: ");
        CheckBox box = new CheckBox("Multistring?");
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        TextArea area = new TextArea();
        area.setPrefWidth(600);
        GridPane.setColumnSpan(area, 2);
        Button md5Button = new Button("MD5");
        Button shaButton = new Button("SHA1");


        Label result = new Label("Result: ");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);

        GridPane.setColumnSpan(result, 2);
        GridPane.setColumnSpan(resultArea, 2);
        md5Button.setPrefWidth(area.getPrefWidth() / 2 - 5);
        shaButton.setPrefWidth(area.getPrefWidth() / 2 - 5);

        md5Button.setOnAction(new MD5ButtonHandler(area, resultArea, box));
        shaButton.setOnAction(new SHA1ButtonHandler(area, resultArea, box));

        pane.add(box, 1, 0);
        pane.add(label, 0, 0);
        pane.add(area, 0, 1);
        pane.add(md5Button, 0, 2);
        pane.add(shaButton, 1, 2);
        pane.add(result, 0, 3);
        pane.add(resultArea, 0, 4);


        Scene s = new Scene(pane);
        primaryStage.setScene(s);
        primaryStage.setTitle("Hasher");
        primaryStage.show();
    }
}
