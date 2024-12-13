package fr.univ_lyon1.info.m1.elizagpt.view;

import java.util.ArrayList;
import java.util.List;

import fr.univ_lyon1.info.m1.elizagpt.controler.Controler;
import fr.univ_lyon1.info.m1.elizagpt.dto.MessageDto;
import fr.univ_lyon1.info.m1.elizagpt.observer.Observer;
import fr.univ_lyon1.info.m1.elizagpt.dto.ResponseMessagesDto;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.EventHandler;

/**
 * Main class of the View (GUI) of the application.
 */
public class JfxView implements Observer {
    /**
     * The virtual box.
     */
    private final VBox dialog;
    /**
     * where we put the text.
     */
    private TextField text = null;
    /**
     * where we search something.
     */
    private TextField searchText = null;
    /**
     * Label for searchText.
     */
    private Label searchTextLabel = null;
    private ComboBox<String> searchOptions;
    private Button sendButton;

    private ResponseMessagesDto viewsCollection;
    private Controler controler;

    /**
     * update refresh notre box de dialog pour acceuillir la list a jour.
     * @param responseMessages list de messages
     */
    @Override
    public void update(final ResponseMessagesDto responseMessages) {
        dialog.getChildren().clear();
        for (MessageDto message :  responseMessages.getResponseDto()) {
            if (message.getUser().equals("Eliza")) {
                replyToUser(message.getId(), message.getMessage());
            } else {
                sendMessage(message.getId(), message.getMessage());
            }
        }
    }

    /**
     * The main view of our app.
     * 
     * @param stage
     * @param width
     * @param height
     */
    // TODO: style error in the following line. Check that checkstyle finds it, and
    // then fix it.
    public JfxView(final Stage stage, final int width, final int height,
                   final Controler controler) {
        this.controler = controler;
        stage.setTitle("Éliza GPT");

        final VBox root = new VBox(10);

        final Pane search = createSearchWidget();
        root.getChildren().add(search);

        ScrollPane dialogScroll = new ScrollPane();
        dialog = new VBox(10);
        dialogScroll.setContent(dialog);
        // scroll to bottom by default:
        dialogScroll.vvalueProperty().bind(dialog.heightProperty());
        root.getChildren().add(dialogScroll);
        dialogScroll.setFitToWidth(true);

        final Pane input = createInputWidget();
        root.getChildren().add(input);
        // replyToUser("Bonjour");

        // Everything's ready: add it to the scene and display it
        final Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        text.requestFocus();
        stage.show();
    }

    /**
     * BaseStyle.
     */
    static final String BASE_STYLE = "-fx-padding: 8px; "
            + "-fx-margin: 5px; "
            + "-fx-background-radius: 5px;"
            + "-fx-wrap-text: true;";
    /**
     * UserStyle.
     */
    static final String USER_STYLE = "-fx-background-color: #A0E0A0; " + BASE_STYLE;
    /**
     * ElizaStyle.
     */
    static final String ELIZA_STYLE = "-fx-background-color: #A0A0E0; " + BASE_STYLE;

    /**
     * replying to the user.
     *
     * @param id
     * @param text
     */
    public void replyToUser(final int id, final String text) {
        HBox hBox = createMessageHBox(id, text, USER_STYLE);
        addDeleteButton(hBox, id);
        dialog.getChildren().add(hBox);

    }

    /**
     * sending a message to eliza.
     *
     * @param text
     */
    public void sendMessage(final int id, final String text) {
        HBox hBox = createMessageHBox(id, text, ELIZA_STYLE);
        addDeleteButton(hBox, id);
        dialog.getChildren().add(hBox);
        };

    /**
     * function qui gere les inputs du user.
     * @param message
     */
    public void inputMessage(final String message) {

        controler.incomingMessage(message);
    };


    /**
     * creating a search widget with a dropdown list.
     *
     * @return
     */
    private Pane createSearchWidget() {
        final HBox firstLine = new HBox();
        final HBox secondLine = new HBox();
        firstLine.setAlignment(Pos.BASELINE_LEFT);
        secondLine.setAlignment(Pos.BASELINE_LEFT);

        // Create a ComboBox with search options
        searchOptions = new ComboBox<>();
        searchOptions.getItems().addAll("Search by Regex", "Search by Substring");
        searchOptions.setValue("Search by Regex"); // Set default option
        firstLine.getChildren().add(searchOptions);

        searchText = new TextField();
        searchText.setOnAction(e -> {
            viewsCollection = controler.search(searchText.getText(),
                    searchOptions.getValue());
            update(viewsCollection);
        });
        firstLine.getChildren().add(searchText);

        final Button send = new Button("Search");
        send.setOnAction(e -> {
            viewsCollection = controler.search(searchText.getText(),
                    searchOptions.getValue());
            update(controler.search(searchText.getText(),
                    searchOptions.getValue()));
        });

        searchTextLabel = new Label();
        final Button undo = new Button("Undo search");
        undo.setOnAction(e -> {
            controler.refresh();
        });

        secondLine.getChildren().addAll(send, searchTextLabel, undo);
        final VBox input = new VBox();
        input.getChildren().addAll(firstLine, secondLine);

        return input;
    }

    /**
     * Get the selected search option.
     *
     * @return Selected search option (Regex or Substring)
     */
    public String getSelectedSearchOption() {
        return searchOptions.getValue();
    }

    /**
     * using the searchText.
     * 
     * @param text
     */
    private void searchText(final TextField text) {
        Pattern pattern;
        Matcher matcher;
        String currentSearchText = text.getText();
        if (currentSearchText == null) {
            searchTextLabel.setText("No active search");
        } else {
            searchTextLabel.setText("Searching for: " + currentSearchText);
        }
        List<HBox> toDelete = new ArrayList<>();
        for (Node hBox : dialog.getChildren()) {
            for (Node label : ((HBox) hBox).getChildren()) {
                String t = ((Label) label).getText();
                // matching regex
                pattern = Pattern.compile(currentSearchText,
                        Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(t);
                if (!matcher.find()) {
                    // Can delete it right now, we're iterating over the list.
                    toDelete.add((HBox) hBox);
                }
            }
        }
        dialog.getChildren().removeAll(toDelete);
        text.setText("");
    }

    /**
     * create an inputwidget.
     * 
     * @return the inputWidget.
     */
    private Pane createInputWidget() {
        final Pane input = new HBox();
        text = new TextField();
        Button send = new Button("Send");
        send.setOnAction(e -> {
            inputMessage(text.getText());
            //sendMessage(text.getText());
            text.setText("");
        });
        sendButton = send;
        input.getChildren().addAll(text, send);
        return input;
    }
    /**
     * Delete this Message.
     * @param id
     */
    public void deleteMessage(final int id) {
        controler.deleteThisMessage(id);
    }

    /**
     * Assuming 'text' is the TextField we want to get the text from.
     * 
     * @return text.
     */
    public String getText() {
        return text.getText();
    }

    /**
     * To send a handler to the controler.
     * 
     * @param handler
     */
    public void setOnSendAction(final EventHandler<ActionEvent> handler) {
        sendButton.setOnAction(handler);
    }

    /**
     * Delete Button.
     * @param hBox
     * @param id
     */
    private void addDeleteButton(final HBox hBox, final int id) {
        Button deleteButton = new Button();
        deleteButton.setGraphic(new Label("X")); // Use a Label with "X" as the graphic
        deleteButton.setStyle("-fx-background-color: transparent;");
        deleteButton.setOnAction(e -> {
            deleteMessage(id);
            dialog.getChildren().remove(hBox);
        });
        hBox.getChildren().add(deleteButton);
    }
    /**
     * Create a messageBox.
     * @param id
     * @param text
     * @param style
     */
    private HBox createMessageHBox(final int id, final String text, final String style) {
        HBox hBox = new HBox();
        final Label label = new Label(text);
        hBox.getChildren().add(label);
        label.setStyle(style);
        if (style.equals(USER_STYLE)) {
            hBox.setAlignment(Pos.BASELINE_RIGHT);
        } else {
            hBox.setAlignment(Pos.BASELINE_LEFT);
        }
        return hBox;
    }
}

