/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.DAO;

import br.edu.ifmt.cba.SuperUsuario.CadastroDeUsuarios.FXMLCadastroUsuarioController;
import br.edu.ifmt.cba.Main.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igor_
 */
public class CadastrarUsuarioDAO {

    public static String cadastrarUser(usuario novoUser) {

        Connection con = DAO.IniciarConexao();
        PreparedStatement stmt = null;

        try {
            if (novoUser.getUser().trim().equals("") || novoUser.getCargo().equals("Escolha") || novoUser.getPass().trim().equals("") || novoUser.getNome().trim().equals("") || novoUser.getCPF().trim().equals("") || novoUser.getAfiliacao().equals("Escolha") || novoUser.getDepartamento().equals("Escolha")) {
                return ("Preencha todos os dados!!!");
            } else {

                stmt = con.prepareStatement("INSERT INTO Cadastro (usuario,senha,privilegio,nome,cpf,afiliação,departamento,carga_horaria,cargo) VALUES (?,?,?,?,?,?,?,?,?)");
                stmt.setString(1, novoUser.getUser());
                stmt.setString(2, novoUser.getPass());
                if (novoUser.getCargo().equals("Professor")) {
                    stmt.setInt(3, 1);
                    stmt.setString(9, "Professor");
                }
                if (novoUser.getCargo().equals("Tecnico")) {
                    stmt.setInt(3, 2);
                    stmt.setString(9, "Tecnico");
                }
                if (novoUser.getCargo().equals("Gestor")) {
                    stmt.setInt(3, 3);
                    stmt.setString(9, "Gestor");
                }
                stmt.setString(4, novoUser.getNome());
                stmt.setString(5, novoUser.getCPF());
                stmt.setString(6, novoUser.getAfiliacao());
                stmt.setString(7, novoUser.getDepartamento());
                stmt.setInt(8, novoUser.getCargaHoraria());

                stmt.executeUpdate();

                return ("Cadastrado com Sucesso !!!!");

            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLCadastroUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return ("Erro ao salvar no Banco De dados");

        } finally {
            DAO.FecharConexao(con, stmt);
        }
    }

}
