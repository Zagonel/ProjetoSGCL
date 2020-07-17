/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.Main;

import br.edu.ifmt.cba.Login.FXMLLoginController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ELUIR
 */
public class DirecionamentoDeUsuario {

    private final String usuario;
    private final String senha;

    public DirecionamentoDeUsuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public void direcionarInterface(ActionEvent event) {

        //Pesquisa no banco de dados o privilegio do usuario sendo usado para abrir uma nova interface;
        
        //Rascunho superUsuario
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifmt/cba/SuperUsuario/FXMLSuperUsuario.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
