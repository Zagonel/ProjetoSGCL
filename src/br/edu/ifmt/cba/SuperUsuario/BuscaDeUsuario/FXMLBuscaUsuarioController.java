/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.SuperUsuario.BuscaDeUsuario;

import br.edu.ifmt.cba.Login.FXMLLoginController;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author igor_
 */
public class FXMLBuscaUsuarioController implements Initializable {

    public static final ObservableList names = FXCollections.observableArrayList();

    @FXML
    private Button btn_minimizer;

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_voltar;

    @FXML
    private TableView<?> infoTable;

    @FXML
    private TableColumn<?, ?> colunaUser;

    @FXML
    private TableColumn<?, ?> colunaNome;

    @FXML
    private TableColumn<?, ?> colunaCpf;

    @FXML
    private TableColumn<?, ?> colunaAfiliacao;

    @FXML
    private TableColumn<?, ?> colunaDepartamento;

    @FXML
    private TableColumn<?, ?> colunaCargo;

    @FXML
    private TableColumn<?, ?> colunaCargaHoraria;

    @FXML
    void voltarPaginaPrincipal(ActionEvent event) {
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

    @FXML
    private void iniciaTable() {
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciaTable();
    }

}
