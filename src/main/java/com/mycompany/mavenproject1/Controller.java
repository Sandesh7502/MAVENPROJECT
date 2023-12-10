import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

public class Controller implements IView {
    @FXML
    private TextArea textArea;

    public void bind(Game game) {
        // Bind the game to the controller in later phases
    }

    // Implement IView methods here...

    @Override
    public boolean choose(String question) {
        // Implement the logic for a simple yes/no choice
        String response = choose(question, "Yes", "No");
        return response.equalsIgnoreCase("Yes");
    }

    @Override
    public String choose(String question, String option1, String option2) {
        // Implement logic for a choice with two options (e.g., Yes/No)
        ButtonType b1 = new ButtonType(option1);
        ButtonType b2 = new ButtonType(option2);
        Alert alert = new Alert(Alert.AlertType.NONE, question, b1, b2);
        alert.setTitle("Choose");
        java.util.Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == b1) {
                return option1;
            } else if (result.get() == b2) {
                return option2;
            }
        }
        return ""; // Default return value, you can modify it as needed
    }

    @Override
    public String ask(String question) {
        // Implement logic for asking a question and receiving text input
        String r = question + "\nText is required.";
        String s = "";
        boolean valid = false;
        while (!valid) {
            TextInputDialog tid = new TextInputDialog("");
            tid.setHeaderText(question);
            Button cancel = (Button) tid.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancel.setDisable(true);
            tid.showAndWait();
            s = tid.getEditor().getText();
            valid = validate(s);
            if (!valid) {
                question = r;
            }
        }
        return s.trim();
    }

    // Added validate method to check for non-empty strings
    private boolean validate(String s) {
        return s != null && !s.trim().isEmpty();
    }

    @Override
    public void append(String message) {
        textArea.appendText(message);
    }

    @Override
    public void display(String message) {
        textArea.setText(message);
    }

    // Other methods and event handlers...
}
