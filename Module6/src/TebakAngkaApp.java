import javafx.application.Application; //class dasar buat javafx
import javafx.geometry.Insets; //buat elemen spacing atau padding
import javafx.geometry.Pos; //posisi buat komponen ui
import javafx.scene.Scene; //ui control buat javafx
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox; //layout vertikal
import javafx.scene.layout.HBox; //layout horizontal
import javafx.scene.paint.Color; //buat ngisi warna
import javafx.stage.Stage;

import java.util.Random;

public class TebakAngkaApp extends Application {

    private int targetNumber; //angka yg harus ditebak
    private int attemptCount; //jumlah percobaan
    private Random random; //buat generate angka random

    //komponen gui
    private TextField inputField;
    private Button guessButton;
    private Button playAgainButton;
    private Label feedbackLabel;
    private Label attemptLabel;
    private Label titleLable;

    @Override
    public void start(Stage primaryStage) { //entry point
        random = new Random();
        InitializeGame();

        titleLable = new Label("🎯 Tebak angka dari 1-100");
        titleLable.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #1C1C1C;");

        Label instructionLabel = new Label("Masukkan tebakanmu!");
        instructionLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #014D4D;");

        inputField = new TextField();

        inputField.setPromptText("Masukkan angka di sini");
        inputField.setPrefWidth(200);
        inputField.setStyle("-fx-font-size: 14px;");

        guessButton = new Button("🎲 Coba Tebak!");
        guessButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 8 16;");

        playAgainButton = new Button("🔄 Main Lagi!");
        playAgainButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 8 16;");

        playAgainButton.setVisible(false);

        feedbackLabel = new Label("");
        feedbackLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        attemptLabel = new Label("Jumlah percobaan: 0");
        attemptLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666;");

        guessButton.setOnAction(e -> handleGuess());
        playAgainButton.setOnAction(e -> resetGame());

        //Allow Enter key to submit the guess entered
        inputField.setOnAction(e -> handleGuess());

        //layout
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(guessButton, playAgainButton);

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #A7C7E7;");
        root.getChildren().addAll(
                titleLable,
                instructionLabel,
                inputField,
                buttonBox,
                feedbackLabel,
                attemptLabel
                );

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Tebak Angka App");
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.show();

        //Focusing on the input field
        inputField.requestFocus();
    }

    private void InitializeGame() {
        targetNumber = random.nextInt(100) + 1; //Random number from 1-100
        attemptCount = 0;
    }

    private void handleGuess() {
        try {
            String input = inputField.getText().trim();
            if (input.isEmpty()) {
                showFeedback("Masukkan angka terlebih dahulu!", "#dc3545");
                return;
            }
            int guess = Integer.parseInt(input);
            if (guess < 1 || guess > 100) {
                showFeedback("Angka harus diantara 1-100!", "#dc3545");
                return;
            }
            attemptCount++;
            updateAttemptLabel();

            if (guess == targetNumber) {
                showFeedback("✅ Tebakan benar!", "#28a745");
                gameOver(true);
            }
            else if (guess > targetNumber) {
                showFeedback("⚠️ Tebakan terlalu besar!", "#F08080");
            }
            else {
                showFeedback("⚠️ Tebakan terlalu kecil!", "#F08080");
            }

            inputField.clear();
            inputField.requestFocus();
        } catch (NumberFormatException e) {
            showFeedback("Masukkan angka yang valid!", "#dc3545");
            inputField.clear();
        }
    }

    private void showFeedback(String message, String color) {
        feedbackLabel.setText(message);

        feedbackLabel.setTextFill(Color.web(color));
    }

    private void updateAttemptLabel() {
        attemptLabel.setText("Jumlah percobaan: " + attemptCount);
    }

    private void gameOver(boolean won) {
        inputField.setDisable(true);
        guessButton.setVisible(false);

        playAgainButton.setVisible(true);
        if (won) {
            feedbackLabel.setText("🎉 Tebakan benar! Angkanya adalah " + targetNumber);

            feedbackLabel.setTextFill(Color.web("#28a745"));
        }
    }

    private void resetGame() {
        InitializeGame();

        inputField.setDisable(false);
        inputField.clear();
        guessButton.setVisible(true);

        playAgainButton.setVisible(false);

        showFeedback("", "#000");
        updateAttemptLabel();

        inputField.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}