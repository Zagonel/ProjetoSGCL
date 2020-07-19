/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.SuperUsuario;

import br.edu.ifmt.cba.Login.FXMLLoginController;
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
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ELUIR
 */
public class FXMLSuperUsuarioController implements Initializable {

    @FXML
    private MenuItem btn_Cadastro;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem btn_userRegister;

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_minimizer;
    
    @FXML
    private Button btn_exibirDados;

    @FXML
    private Button btn_deletarUsuario;

    @FXML
    private Button btn_ModificarUsuario;

    // abre a tela para cadastros de novos usuários.
    @FXML
    void cadastrarNovo(ActionEvent event) {
        Stage stage = new Stage();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifmt/cba/SuperUsuario/CadastroDeUsuarios/FXMLCadastroUsuario.fxml"));
            stage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // ver se faz um metodo para criação de stages.

    // Redireciona para a interface de busca de usuarios.
    @FXML
    void buscarUser(ActionEvent event) {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.close();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifmt/cba/SuperUsuario/BuscaDeUsuario/FXMLBuscaUsuario.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // fecha a tela ao clicar no botão
    @FXML
    void stageClose(ActionEvent event) {
        Stage stage = (Stage) btn_close.getScene().getWindow();
        stage.close();

    }

    //minimiza a tela ao clicar no botão
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
        // TODO
    }

}
