/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igor_
 */
public class CheckLoginDAO {

    public static boolean validarUser(String usuario, String senha) {

        Connection con = DAO.IniciarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("USE zagonel_TesteIFMT");
            stmt.executeQuery();
            stmt = con.prepareStatement("SELECT *FROM Cadastro WHERE usuario = ? and senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CheckLoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAO.FecharConexao(con, stmt, rs);
        }

        return check;

    }
}
