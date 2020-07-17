/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.Login;

import br.edu.ifmt.cba.DAO.CheckLoginDAO;
import br.edu.ifmt.cba.Main.DirecionamentoDeUsuario;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLLoginController implements Initializable {

    @FXML
    private TextField usuario;

    @FXML
    private PasswordField senha;

    @FXML
    private Label recuperaSenha;

    @FXML
    private Button btn_entrar;

    @FXML
    private Label cadastrar;

    @FXML
    private Label erroLogin;

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_minimizer;

    // busca no banco de dados para validar o acesso do usuario.
    @FXML
    private void acessar(ActionEvent event) {
        String user = usuario.getText();
        String password = senha.getText();

        // aqui entra a parte de banco de dados que vai fazer a busca e verificar se o username e senha são validos
        if (CheckLoginDAO.validarUser(user, password)) {

            DirecionamentoDeUsuario iniciarSessao = new DirecionamentoDeUsuario(user, password);
            iniciarSessao.direcionarInterface(event);

        } else {
            erroLogin.setText("Usuario/Senha Invalida");
        }

    }
    
    // abre a tela de recuperação de senha.
    @FXML
    public void telaRecuperarSenha(MouseEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifmt/cba/Login/FXMLRecuperarSenha.fxml"));
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

    @FXML
    void controleFormulario() {
        usuario.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                senha.requestFocus();
            }
        });
        senha.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                btn_entrar.fire();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controleFormulario();
    }

}
