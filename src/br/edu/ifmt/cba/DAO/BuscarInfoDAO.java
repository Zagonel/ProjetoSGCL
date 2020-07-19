/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.DAO;

import br.edu.ifmt.cba.Main.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author igor_
 */
public class BuscarInfoDAO {

    public static ObservableList<usuario> registroUsuarios() {
        Connection con = DAO.IniciarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ObservableList<usuario> usuarios = FXCollections.observableArrayList();

        try {
            stmt = con.prepareStatement("SELECT *FROM Cadastro");
            rs = stmt.executeQuery();

            while (rs.next()) {

                usuario userCadastrado = new usuario();
                userCadastrado.setUser(rs.getString("usuario"));
                userCadastrado.setNome(rs.getString("nome"));
                userCadastrado.setCPF(rs.getString("cpf"));
                userCadastrado.setAfiliacao(rs.getString("afiliação"));
                userCadastrado.setDepartamento(rs.getString("departamento"));
                userCadastrado.setCargo(rs.getString("cargo"));
                userCadastrado.setCargaHoraria(rs.getInt("carga_horaria"));

                usuarios.add(userCadastrado);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            DAO.FecharConexao(con, stmt, rs);
        }
        return usuarios;
    }

    public static void deletaRegistroUsuario(String cpf) {
        Connection con = DAO.IniciarConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM Cadastro WHERE cpf = ?");
            stmt.setString(1, cpf);
            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(BuscarInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            DAO.FecharConexao(con, stmt);
        }

    }

}
