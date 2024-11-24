package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import model.Dictionary;

public class DictionaryView extends Application {
    private DictionaryController controller;
    private TextField wordField;
    private Label meaningLabel;

    @Override
    public void start(Stage window) {
        // Initialize the dictionary model and controller
        Dictionary dictionary = new Dictionary();
        controller = new DictionaryController(dictionary);

        // Adding a hardcoded word to the dictionary for testing purposes
        controller.addWord("hello", "A greeting or expression of goodwill.");

        // Create a text field for user input
        wordField = new TextField();
        wordField.setPromptText("Enter word");

        // Create a button to trigger the search action
        Button searchButton = new Button("Search");

        // Create a label to display the meaning of the word
        meaningLabel = new Label();

        // Set the action for the search button using an inner class
        searchButton.setOnAction(new SearchButtonHandler());

        // Create a layout and add the components to it
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(wordField);
        componentGroup.getChildren().add(searchButton);
        componentGroup.getChildren().add(meaningLabel);

        // Set up the scene (w x h) and the stage
        Scene view = new Scene(componentGroup, 400, 200);
        window.setTitle("Virtual Dictionary");
        window.setScene(view);
        window.show();
    }

    // Inner class to handle the search button click event
    private class SearchButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Get the word entered by the user
            String word = wordField.getText().trim();

            // Check if the input is empty and provide feedback
            if (word.isEmpty()) {
                meaningLabel.setText("Please enter a word.");
            } else {
                // Search for the word in the dictionary
                String meaning = controller.searchWord(word);

                // Display the meaning if found, otherwise indicate that the word was not found
                if (meaning != null) {
                    meaningLabel.setText(meaning);
                } else {
                    meaningLabel.setText("Word not found.");
                }
            }
        }
    }

}