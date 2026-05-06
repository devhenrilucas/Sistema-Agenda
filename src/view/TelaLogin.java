package view;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Classe TelaLogin para criar uma tela de login de biblioteca usando JavaFX.
 * Esta classe é projetada para ser simples e bem comentada, ideal para estudantes aprendendo JavaFX.
 * Ela retorna uma Scene pronta para ser usada no Stage principal.
 */
public class TelaLogin {

    private TextField tfUsuario;  // Campo para o nome de usuário
    private TextField pfEmail;
    private TextField pfTelefone;// Campo para a senha (mascara os caracteres)
    private Label lblErro;         // Label para exibir mensagens de erro ou sucesso

    /**
     * Método principal que cria e configura toda a interface da tela de login.
     * Retorna uma Scene pronta para ser exibida no Stage.
     * @return Scene configurada com a tela de login
     */
    public Scene getScene() {
        // VBox principal para organizar os componentes verticalmente
        VBox root = new VBox(20); // Espaçamento de 20 pixels entre componentes
        root.setAlignment(Pos.CENTER); // Centraliza os componentes
        root.setPadding(new Insets(40)); // Padding de 40 pixels em todos os lados

        // Fundo claro para melhor aparência
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #e3f2fd, #f5f5f5);");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // Espaço horizontal entre label e campo
        grid.setVgap(15); // Espaço vertical entre as linhas
        grid.setPadding(new Insets(10, 10, 10, 10));

        // Título da tela
        Label lblTitulo = new Label("Cadastro Usuário");
        lblTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        lblTitulo.setTextFill(Color.DARKBLUE);

        // HBox para linha do usuário
        HBox hboxUsuario = new HBox(15);
        hboxUsuario.setAlignment(Pos.CENTER_LEFT);
        Label lblUsuario = new Label("Nome:");
        lblUsuario.setFont(Font.font(14));
        tfUsuario = new TextField();
        tfUsuario.setPrefWidth(250);
        tfUsuario.setPromptText("Digite seu nome de usuário");
        grid.add(lblUsuario, 0, 0);
        grid.add(tfUsuario, 1, 0);

        // HBox para linha da senha
        HBox hboxEmail = new HBox(15);
        hboxEmail.setAlignment(Pos.CENTER_LEFT);
        Label lblEmail = new Label("Email: ");
        lblEmail.setFont(Font.font(14));
        pfEmail = new TextField();
        pfEmail.setPrefWidth(250);
        pfEmail.setPromptText("Digite o email do usuario");
        grid.add(lblEmail, 0, 1); 
        grid.add(pfEmail, 1, 1);
        
        HBox hboxTelefone = new HBox(15);
        hboxTelefone.setAlignment(Pos.CENTER_LEFT);
        Label lblTelefone = new Label("Telefone: ");
        lblTelefone.setFont(Font.font(14));
        pfTelefone = new TextField();
        pfTelefone.setPrefWidth(250);
        pfTelefone.setPromptText("Digite o número de telefone do usuario");
        grid.add(lblTelefone, 0, 2);
        grid.add(pfTelefone, 1, 2);

        // Botão Entrar com estilo
        Button btnEntrar = new Button("Cadastrar");
        btnEntrar.setPrefWidth(150);
        btnEntrar.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        btnEntrar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5; -fx-padding: 10 20;");
        btnEntrar.setOnAction(e -> handleLogin()); // Ação do botão

        // Label para mensagens de erro/sucesso
        lblErro = new Label();
        lblErro.setTextFill(Color.RED);
        lblErro.setFont(Font.font(12));
        lblErro.setStyle("-fx-padding: 10 0 0 0;");

        // Adiciona todos os componentes ao VBox principal
        root.getChildren().addAll(
            lblTitulo,
            grid,
            btnEntrar,
            lblErro
        );

        // Cria a Scene com tamanho fixo (400x350)
        Scene scene = new Scene(root, 450, 350);
        return scene;
    }

    private boolean validarCampos() {
        String usuario  = tfUsuario.getText().trim();
        String email    = pfEmail.getText().trim();
        String telefone = pfTelefone.getText().trim();
        return !usuario.isEmpty() && !email.isEmpty() && !telefone.isEmpty();
    }

    /**
     * Manipulador do evento do botão Entrar.
     * Valida os campos e exibe mensagem apropriada.
     * (Futuramente, aqui você pode conectar ao banco de dados)
     */
    private void handleLogin() {
        lblErro.setText(""); // Limpa mensagem anterior
        if (validarCampos()) {
            lblErro.setTextFill(Color.GREEN);
            lblErro.setText("Login realizado com sucesso! (Estrutura pronta para BD)");
            // Aqui você pode adicionar lógica para navegar para a tela principal
            // Exemplo: MainApp.mudarTelaPrincipal();
        } else {
            lblErro.setTextFill(Color.RED);
            lblErro.setText("Por favor, preencha todos os campos!");
            tfUsuario.requestFocus(); // Foca no campo usuário
        }
    }

    // Exemplo de uso (para testar em uma classe Main):
    /*
    public static void main(String[] args) {
        Application.launch(MainApp.class, args);
    }
    */
}