package view;

import dao.DaoFactory;
import dao.VenueDAO;
import javafx.geometry.Insets;
import javafx.util.converter.IntegerStringConverter;
import model.entities.User;
import model.entities.Venue;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class VenueRegistrationView {
	private TextField venueName;
	private TextField maxCapacity;
	private Label lblErro; 
	
	public Scene getScene() {
		IntegerStringConverter converter = new IntegerStringConverter();
		TextFormatter<Integer> formatter = new TextFormatter<>(
		    converter,
		    0,
		    change -> {
		        if (change.getControlNewText().matches("\\d*")) {
		            return change;
		        }
		        return null;
		    }
		);
		
		VBox root = new VBox(20);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(40));
		root.setStyle("-fx-background-color: linear-gradient(to bottom, #e3f2fd, #f5f5f5);");
		
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); 
        grid.setVgap(15); 
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        Label lblTitulo = new Label("Cadastro Local");
        lblTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        lblTitulo.setTextFill(Color.DARKBLUE);
        
        HBox hboxVanue = new HBox(15);
        hboxVanue.setAlignment(Pos.CENTER_LEFT);
        Label lblVanue = new Label("Local:");
        lblVanue.setFont(Font.font(14));
        venueName = new TextField();
        venueName.setPrefWidth(250);
        venueName.setPromptText("Digite o nome do Local");
        grid.add(lblVanue, 0, 0);
        grid.add(venueName, 1, 0);
        
        HBox hboxMaxCapacity = new HBox(15);
        hboxMaxCapacity.setAlignment(Pos.CENTER_LEFT);
        Label lblMaxCapacity = new Label("Cap. máxima:");
        lblMaxCapacity.setFont(Font.font(14));
        maxCapacity = new TextField();
        maxCapacity.setPrefWidth(250);
        maxCapacity.setPromptText("Digite o nome do Local");
        maxCapacity.setTextFormatter(formatter);
        grid.add(lblMaxCapacity, 0, 1);
        grid.add(maxCapacity, 1, 1);
        
        Button btnRegisterVenue = new Button("Cadastrar");
        btnRegisterVenue.setPrefWidth(150);
        btnRegisterVenue.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        btnRegisterVenue.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5; -fx-padding: 10 20;");
        btnRegisterVenue.setOnAction(e -> handleVenueLogOn());
        
        lblErro = new Label();
        lblErro.setTextFill(Color.RED);
        lblErro.setFont(Font.font(12));
        lblErro.setStyle("-fx-padding: 10 0 0 0;");
        
        root.getChildren().addAll(
            lblTitulo,
            grid,
            btnRegisterVenue,
            lblErro
        );

        Scene scene = new Scene(root, 450, 350);
        return scene;
	}
	
	private boolean validarCampos() {
        String name	= venueName.getText().trim();
        String mCap	= maxCapacity.getText().trim();
        return !name.isEmpty() && !mCap.isEmpty();
    }
	
	private void handleVenueLogOn() {
	    lblErro.setText("");
	    if (validarCampos()) {
	        String name = venueName.getText().trim();
	        Integer mCap = Integer.parseInt(maxCapacity.getText().trim()); 
	        
	        lblErro.setTextFill(Color.GREEN);
	        VenueDAO venueDao = DaoFactory.createVenueDAO();
	        Venue venue = new Venue(null, name, mCap);
	        
	        venueDao.insert(venue);
	        lblErro.setText("" + venueDao.findById(venue.getId()));
	        
	    } else {
	        lblErro.setTextFill(Color.RED);
	        lblErro.setText("Por favor, preencha todos os campos!");
	        venueName.requestFocus();
	    }
	}
	

}
