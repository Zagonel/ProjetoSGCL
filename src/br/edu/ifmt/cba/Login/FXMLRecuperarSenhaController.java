/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.Login;

import br.edu.ifmt.cba.DAO.BuscarInfoDAO;
import br.edu.ifmt.cba.DAO.CheckLoginDAO;
import br.edu.ifmt.cba.Main.usuario;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Label loginRecuperado;
    
    @FXML
    private Label senhaRecuperada;
    
    @FXML
    private Label labelUsuario;
    
    @FXML
    private Label labelSenha;
    
    @FXML
    void RecuperarSenha(ActionEvent event) {
        String cpf = CPF.getText();
        usuario user = new usuario();
        
        user = BuscarInfoDAO.buscaDados(cpf, cpf);
        System.out.println(user);
        if (user.getNome().equals("")) {
            erroBusca.setText("Não encontrado no Banco de Dados !!");
        } else {
            labelUsuario.setText("Nome de Usuário : ");
            loginRecuperado.setText(user.getUser());
            
            labelSenha.setText("Senha : ");
            senhaRecuperada.setText(user.getPass());
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
        CPF.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                btn_RecuperarSenhaBD.fire();
            }
        });
    }
    
}
