package fr.univ_lyon1.info.m1.elizagpt;

import fr.univ_lyon1.info.m1.elizagpt.controler.Controler;
import fr.univ_lyon1.info.m1.elizagpt.view.JfxView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class for the application (structure imposed by JavaFX).
 */
public class App extends Application {

   private static final int FIRSTVIEW = 600;
    private static final int SECONDVIEW = 400;

    /**
     * With javafx, start() is called when the application is launched.
     * 
     * @param stage
     */
    @Override
    public void start(final Stage stage) throws Exception {
        Controler controler = new Controler();
        JfxView vue1 = new JfxView(stage, FIRSTVIEW, FIRSTVIEW, controler);
        JfxView vue2 = new JfxView(new Stage(), SECONDVIEW, SECONDVIEW, controler);
        controler.getMessages().addObserver(vue1);
        controler.getMessages().addObserver(vue2);

    }

    /**
     * A main method in case the user launches the application using
     * App as the main class.
     * 
     * @param args
     */
    public static void main(final String[] args) {
        Application.launch(args);
    }
}
