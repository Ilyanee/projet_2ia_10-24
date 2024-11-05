package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import java.util.Stack;

public class Main extends Application {
	private Calculator calculatrice;
    private TextField accumulateurField;
    private TextArea pileField;
    private TextField EmpileField;
    
    public void start(Stage primaryStage) {
        calculatrice = new Calculator();
        
        primaryStage.setTitle("Calculatrice"); //Fenêtre principale
        
        //Affichage accumulateur
        
        accumulateurField = new TextField();
        accumulateurField.setEditable(false);
        
        //Affichage pile
        
        pileField = new TextArea();
        pileField.setEditable(false);
        pileField.setPrefRowCount(3);
        
        //Affichage zone d'empilement
        
        EmpileField = new TextField();
        EmpileField.setEditable(true);
		
		//Affichage écran
		
        VBox displayPanel = new VBox(9, new Label("Résultat:"), accumulateurField, 
        new Label("Pile:"), pileField, new Label("Empiler:"), EmpileField);
        displayPanel.setPadding(new Insets(12));
        
        //Affichage et définition boutons
        /*Supprimer ce commentaire après usage
         * pour editer les boutons individuellement : setId()
         * donner un id au bouton et le selectionner apres avec getId() correspondant (faire une comparaison)
         * pour changer les couleurs (fond et texte) : setStyle()
	 * modifiable avec css sinon
         */
                
        
        GridPane buttonPanel = new GridPane();
        buttonPanel.setPrefHeight(1600);
        buttonPanel.setPrefWidth(1600);
        buttonPanel.setHgap(18);
        buttonPanel.setVgap(18);
        buttonPanel.setPadding(new Insets(8));
        
        String[] buttonLabels = {"+", "-", "*", "/","Empiler","Dépiler","Effacer Tout"};
        int row = 0, col = 0;
        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setOnAction(e -> handleButtonAction(label));
            button.setPrefWidth(500);
            button.setPrefHeight(500);
            button.setFont(new Font("Times New Roman", 18));
            buttonPanel.add(button, col++, row);
            if (col > 2) { //3 boutons par colonne
                col = 0;
                row++;
            }            
          
        }
        
     //Scène principale
        BorderPane root = new BorderPane();
        root.setTop(displayPanel);
        root.setCenter(buttonPanel);
        
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        
     //Actions depuis le clavier
        scene.setOnKeyPressed(event -> {
            try {
                if (event.getText().equals("+")) {
                    calculatrice.add();
                } 
                else if (event.getText().equals("-")) {
                    calculatrice.substract();
                } 
                else if (event.getText().equals("*")) {
                    calculatrice.multiply();
                } 
                else if (event.getText().equals("/")) {
                    calculatrice.divide();
                }
                else if (event.getCode() == KeyCode.ENTER) {
                	calculatrice.push(Double.parseDouble(EmpileField.getText()));
                	EmpileField.clear();
                	
                }
                else if (event.getCode() == KeyCode.BACK_SPACE) {
                	calculatrice.drop();
                }

                updateDisplay();
            } catch (Exception e) {
                showAlert("Erreur", e.getMessage());
            }
        });
        
        primaryStage.show();
}
    
    private void handleButtonAction(String command) {
        try {
            switch (command) {
                case "Empiler":
                        try {
                            double value = Double.parseDouble(EmpileField.getText());
                            calculatrice.push(value);
                            EmpileField.clear();
                        } catch (NumberFormatException e) {
                            showAlert("Erreur", "Veuillez entrer un nombre valide.");
                        }
                    
                    break;
                case "+":
                    calculatrice.add();
                    break;
                case "-":
                    calculatrice.substract();
                    break;
                case "*":
                    calculatrice.multiply();
                    break;
                case "/":
                    calculatrice.divide();
                    break;
                case "Effacer":
                    calculatrice.clear();
                    break;
                case "Dépiler":
                    calculatrice.drop();
                    break;

            }
        } catch (Exception ex) {
            showAlert("Erreur", ex.getMessage());
        }
        updateDisplay();
    }
    
    //Affichage 3 derniers éléments de la pile

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
