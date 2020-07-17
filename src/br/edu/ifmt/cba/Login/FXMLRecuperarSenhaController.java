/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.Login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ELUIR
 */
public class FXMLRecuperarSenhaController implements Initializable {

    @FXML
    private Button btn_voltaLogin;

    @FXML
    private TextField Email;

    @FXML
    private TextField CPF;

    @FXML
    private Button btn_RecuperarSenhaBD;

    @FXML
    private Label erroBusca;

    @FXML
    private Button btn_minimizer;

    @FXML
    private Button btn_close;

    @FXML
    void RecuperarSenha(ActionEvent event) {
        // tenho que modificar o banco de dados para todas as caracteristicas necessarias para cadastro ainda, fazer dps a checagem;
        String email = Email.getText();
        String cpf = CPF.getText();

        if (email.equals("igorzagonel@gmail.com") && cpf.equals("04418562176")) {
            System.out.println("Fazer o resto");
        } else {
            erroBusca.setText("Não encontrado no Banco de Dados !!");
        }

    }

    @FXML
    void voltarLogin(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifmt/cba/Login/FXMLLogin.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void stageClose(ActionEvent event) {
        Stage stage = (Stage) btn_close.getScene().getWindow();
        stage.close();

    }

    @FXML
    void stageMinimizar(ActionEvent event) {
        Stage stage = (Stage) btn_minimizer.getScene().getWindow();
        stage.setIconified(true);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Email.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                CPF.requestFocus();
            }
        });
        CPF.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                btn_RecuperarSenhaBD.fire();
            }
        });
    }

}
