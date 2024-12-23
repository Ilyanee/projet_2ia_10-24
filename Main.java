package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import java.util.Stack;

public class Main extends Application {
    private calculator calculatrice;
    private TextField accumulateurField;
    private TextArea pileField;
    private TextField empileField;

    public void start(Stage primaryStage) {
        calculatrice = new calculator();

        primaryStage.setTitle("Calculatrice NPI");

        // Affichage accumulateur
        accumulateurField = new TextField();
        accumulateurField.setEditable(false);

        // Affichage pile
        pileField = new TextArea();
        pileField.setEditable(false);
        pileField.setPrefRowCount(3);

        // Affichage zone d'empilement
        empileField = new TextField();
        empileField.setEditable(true);

        // Affichage écran
        VBox displayPanel = new VBox(10, new Label("Résultat:"), accumulateurField,
            new Label("Pile:"), pileField, new Label("Empiler:"), empileField);
        displayPanel.setPadding(new Insets(15));
        displayPanel.setStyle("-fx-background-color: lightslategray");
        
        // Panel pour les boutons numériques et opérations de base
        GridPane buttonPanel = new GridPane();
        buttonPanel.setHgap(10);
        buttonPanel.setVgap(10);
        buttonPanel.setPadding(new Insets(11));
        buttonPanel.setStyle("-fx-background-color: lightslategray");

        // Création des boutons d'opérations et d'actions
        String[] buttonLabels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", ".", "Empiler", "/",
            "Dépiler",  "(-)", "Effacer Tout"
        };

        int row = 0, col = 0;
        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setId(label);
            button.setOnAction(e -> handleButtonAction(label));
            button.setPrefSize(80, 40); // Taille ajustée pour tous les boutons
            button.setFont(new Font("Arial", 14));
            if (button.getId() == "+" || button.getId() == "-" || button.getId() == "*" || button.getId() == "/" || button.getId() == "(-)" || button.getId() == "Effacer Tout" || button.getId() == "Dépiler" || button.getId() == "Empiler") {
            	button.setStyle("-fx-background-color: coral");
            }
            else {
            	button.setStyle("-fx-background-color: beige");
            }
            buttonPanel.add(button, col++, row);
            if (col > 3) { // 4 boutons par rangée
                col = 0;
                row++;
            }
            else if (button.getId() == "Effacer Tout") { // Adaptation taille bouton "Effacer Tout"
            	button.setPrefSize(160, 40);
            	GridPane.setColumnSpan(button, 2);;
            }
            
        }

        // Scène principale avec BorderPane
        BorderPane root = new BorderPane();
        root.setTop(displayPanel);
        root.setCenter(buttonPanel);

        Scene scene = new Scene(root, 400, 500); // Taille ajustée pour le format calculatrice
        primaryStage.setScene(scene);

        // Donne le focus à la scène au démarrage
        scene.getRoot().requestFocus();

        // Actions depuis le clavier pour les opérations et empiler
        empileField.setOnAction(event -> {
            String input = empileField.getText().trim();
            empileField.clear();
            try {
                switch (input) {
                    case "+" -> calculatrice.add();
                    case "-" -> calculatrice.substract();
                    case "*" -> calculatrice.multiply();
                    case "/" -> calculatrice.divide();
                    case "" -> showAlert("Erreur", "Aucune valeur entrée.");
                    default -> calculatrice.push(Double.parseDouble(input));
                }
                updateDisplay();
            } catch (NumberFormatException e) {
                showAlert("Erreur", "Veuillez entrer un nombre valide.");
            } catch (Exception e) {
                showAlert("Erreur", e.getMessage());
            }
        });

        primaryStage.show();
    }

    private void handleButtonAction(String command) {
        try {
            switch (command) {
                case "Empiler" -> {
                    double value = Double.parseDouble(empileField.getText());
                    calculatrice.push(value);
                    empileField.clear();
                }
                case "+" -> calculatrice.add();
                case "-" -> calculatrice.substract();
                case "*" -> calculatrice.multiply();
                case "/" -> calculatrice.divide();
                case "Effacer Tout" -> calculatrice.clear();
                case "Dépiler" -> calculatrice.drop();
                default -> {
                    // Pour les boutons numériques et le point
                    empileField.appendText(command);
                }
            }
        } catch (NumberFormatException e) {
            showAlert("Erreur", "Veuillez entrer un nombre valide.");
        } catch (Exception ex) {
            showAlert("Erreur", ex.getMessage());
        }
        updateDisplay();
    }

    // Affichage des 3 derniers éléments de la pile
    private void updateDisplay() {
        accumulateurField.setText(String.valueOf(calculatrice.getAccu()));
        Stack<Double> pile = calculatrice.getPile();
        StringBuilder pileText = new StringBuilder();
        int count = 0;
        for (int i = pile.size() - 1; i >= 0 && count < 3; i--, count++) {
            pileText.append(pile.get(i)).append("\n");
        }
        pileField.setText(pileText.toString());
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}