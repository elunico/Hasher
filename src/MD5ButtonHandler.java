import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

/**
 * @author Thomas Povinelli
 * Created 2017-Aug-30
 * In Hasher
 */
public class MD5ButtonHandler implements EventHandler<ActionEvent> {

    private TextArea in, out;
    private CheckBox box;

    public MD5ButtonHandler(TextArea in, TextArea out, CheckBox box) {
        this.in = in;
        this.out = out;
        this.box = box;
    }

    @Override
    public void handle(ActionEvent event) {
        String text = in.getText();
        if (box.isSelected()) {
            String[] strings = text.split("\n");
            out.setText("");
            for (String string : strings) {
                out.setText(out.getText() + "MD5 of " + string + ": " +
                            org.apache.commons.codec.digest.DigestUtils.md5Hex(string) +
                            "\n");
            }
        } else {
            out.setText(org.apache.commons.codec.digest.DigestUtils.md5Hex(text));
        }

    }

}
