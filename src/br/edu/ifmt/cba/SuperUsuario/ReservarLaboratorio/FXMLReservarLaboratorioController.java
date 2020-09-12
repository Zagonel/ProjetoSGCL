/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.SuperUsuario.ReservarLaboratorio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLReservarLaboratorioController implements Initializable {

    @FXML
    private Button btn_minimizer;

    @FXML
    private Button btn_close;
    

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
