package view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view.TelaLogin;
import javafx.application.Application;

public class Principal extends Application{

    @Override
    public void start(Stage stage) {
        TelaLogin telaLogin = new TelaLogin();
        Scene scene = telaLogin.getScene();

        stage.setTitle("Sistema de Biblioteca - Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
