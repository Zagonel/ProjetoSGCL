/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.SuperUsuario.BuscaDeUsuario;

import br.edu.ifmt.cba.DAO.BuscarInfoDAO;
import br.edu.ifmt.cba.Login.FXMLLoginController;
import br.edu.ifmt.cba.Main.usuario;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author igor_
 */
public class FXMLBuscaUsuarioController implements Initializable {

    @FXML
    private Button btn_minimizer;

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_voltar;

    @FXML
    private TableView<usuario> infoTable;

    @FXML
    private TableColumn<usuario, String> colunaUser;

    @FXML
    private TableColumn<usuario, String> colunaNome;

    @FXML
    private TableColumn<usuario, String> colunaCpf;

    @FXML
    private TableColumn<usuario, String> colunaAfiliacao;

    @FXML
    private TableColumn<usuario, String> colunaDepartamento;

    @FXML
    private TableColumn<usuario, String> colunaCargo;

    @FXML
    private TableColumn<usuario, String> colunaCargaHoraria;

    @FXML
    private Button btn_exibirDados;

    @FXML
    private Button btn_deletarUsuario;

    @FXML
    private Button btn_ModificarUsuario;

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
    void exibirDados(ActionEvent event) {
        infoTable.setItems(BuscarInfoDAO.registroUsuarios());
    }

    @FXML
    void deletarUsuario(ActionEvent event) {
        BuscarInfoDAO.deletaRegistroUsuario(infoTable.getSelectionModel().getSelectedItem().getCPF());
        infoTable.setItems(BuscarInfoDAO.registroUsuarios());
    }

    @FXML
    void modificarUsuario(ActionEvent event) {

    }

    @FXML
    private void iniciaTable() {
        colunaUser.setCellValueFactory(new PropertyValueFactory<>("user"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        colunaAfiliacao.setCellValueFactory(new PropertyValueFactory<>("Afiliacao"));
        colunaDepartamento.setCellValueFactory(new PropertyValueFactory<>("Departamento"));
        colunaCargo.setCellValueFactory(new PropertyValueFactory<>("Cargo"));
        colunaCargaHoraria.setCellValueFactory(new PropertyValueFactory<>("cargaHoraria"));
        infoTable.setPlaceholder(new Label(""));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciaTable();
    }

}
