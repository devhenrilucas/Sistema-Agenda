package view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view.CustomerRegistrationView;
import javafx.application.Application;

public class Principal extends Application{

    @Override
    public void start(Stage stage) {
//        CustomerRegistrationView CustomerRegistration = new CustomerRegistrationView();
//        Scene scene = CustomerRegistration.getScene();
//
//        stage.setTitle("Sistema de Biblioteca - Login");
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
        
        VenueRegistrationView venueRegistration = new VenueRegistrationView();
        Scene scene = venueRegistration.getScene();

        stage.setTitle("Sistema de Biblioteca - Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
