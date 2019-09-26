/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Sacole;
import java.sql.Date;
/**
 *
 * @author Administrador
 */
public class SacoleDao {
     public static boolean inserir(Sacole objeto) {
        String sql = "INSERT INTO sacole (codigo, nrdeserie, data, preco, sabor) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.setInt(2, objeto.getNrdeserie());
            ps.setDate(3, Date.valueOf(objeto.getData()));
            ps.setDouble(4, objeto.getPreco());
            ps.setString(5, objeto.getSabor());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
}
