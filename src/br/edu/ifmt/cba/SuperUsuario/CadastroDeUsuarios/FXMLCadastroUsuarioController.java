package br.edu.ifmt.cba.SuperUsuario.CadastroDeUsuarios;

import br.edu.ifmt.cba.DAO.CadastrarUsuarioDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class FXMLCadastroUsuarioController implements Initializable {

    ObservableList<String> afiliacaoList = FXCollections.observableArrayList("Escolha", "Efetivo", "Temporario");
    ObservableList<String> departamentoList = FXCollections.observableArrayList("Escolha", "Informatica", "Outro");
    ObservableList<String> cargoList = FXCollections.observableArrayList("Escolha", "Professor", "Tecnico", "Gestor");

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_minimizer;

    @FXML
    private TextField usuario;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField nome;

    @FXML
    private TextField cpf;

    @FXML
    private TextField cargaHoraria;

    @FXML
    private ChoiceBox afiliacao;

    @FXML
    private ChoiceBox departamento;

    @FXML
    private ChoiceBox cargo;

    @FXML
    private Button btn_enviar;

    @FXML
    private Label informeStatus;

    public class usuario {

        private String user;
        private String pass;
        private String Nome;
        private String CPF;
        private String Afiliacao;
        private String Departamento;
        private String Cargo;

        public int getCargaHoraria() {
            return cargaHoraria;
        }

        public void setCargaHoraria(int cargaHoraria) {
            this.cargaHoraria = cargaHoraria;
        }
        private int cargaHoraria;

        public String getUser() {
            return user;
        }

        public String getPass() {
            return pass;
        }

        public String getNome() {
            return Nome;
        }

        public String getCPF() {
            return CPF;
        }

        public String getAfiliacao() {
            return Afiliacao;
        }

        public String getDepartamento() {
            return Departamento;
        }

        public String getCargo() {
            return Cargo;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public void setNome(String Nome) {
            this.Nome = Nome;
        }

        public void setCPF(String CPF) {
            this.CPF = CPF;
        }

        public void setAfiliacao(String Afiliacao) {
            this.Afiliacao = Afiliacao;
        }

        public void setDepartamento(String Departamento) {
            this.Departamento = Departamento;
        }

        public void setCargo(String Cargo) {
            this.Cargo = Cargo;
        }

    }

    @FXML
    void cadastrarUsuario(ActionEvent event) {
        usuario novoUser = new usuario();

        // inicializando o valor dos atributos do novo usuario.
        novoUser.setUser("");
        novoUser.setPass("");
        novoUser.setNome("");
        novoUser.setCPF("");

        novoUser.setUser(usuario.getText());
        novoUser.setPass(senha.getText());
        novoUser.setNome(nome.getText());

        //Fazer validação de cpf e colocar com formato tbm.
        novoUser.setCPF(cpf.getText());
        novoUser.setAfiliacao(afiliacao.getValue().toString());
        novoUser.setDepartamento(departamento.getValue().toString());
        novoUser.setCargo(cargo.getValue().toString());

        //Fazer validação para aceitar apenas numeros.
        if (cargaHoraria.getText().isEmpty()) {
            novoUser.setCargaHoraria(0);
        } else {
            int aux = Integer.parseInt(cargaHoraria.getText());
            novoUser.setCargaHoraria(aux);
        }
        String status = CadastrarUsuarioDAO.cadastrarUser(novoUser);
        informeStatus.setText(status);
        if (status.equals("Cadastrado com Sucesso !!!!")) {
            limparCampos();
        }
    }

    // limpa os dados da tela de cadastro.
    @FXML
    void limparCampos() {
        usuario.clear();
        senha.clear();
        nome.clear();
        cpf.clear();
        cargaHoraria.clear();
        afiliacao.setValue(null);
        departamento.setValue(null);
        cargo.setValue(null);
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
    private void ChoiceBoxInitialize() {
        afiliacao.setItems(afiliacaoList);
        departamento.setItems(departamentoList);
        cargo.setItems(cargoList);
        afiliacao.setValue("Escolha");
        departamento.setValue("Escolha");
        cargo.setValue("Escolha");
    }

    // controle de chamda ao clicar enter.
    @FXML
    private void controleFormulario() {
        usuario.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                senha.requestFocus();
            }
        });
        senha.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                nome.requestFocus();
            }
        });
        nome.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                cpf.requestFocus();
            }
        });
        cpf.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                cargaHoraria.requestFocus();
            }
        });
        cargaHoraria.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                afiliacao.requestFocus();
            }
        });
        afiliacao.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                departamento.requestFocus();
            }
        });
        departamento.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                cargo.requestFocus();
            }
        });
        cargo.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                btn_enviar.fire();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChoiceBoxInitialize();
        controleFormulario();
    }

}
