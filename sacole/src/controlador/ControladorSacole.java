/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.SacoleDao;
import javax.swing.JOptionPane;
import modelo.Sacole;
import tela.manutencao.ManutencaoSacole;
/**
 *
 * @author Administrador
 */
public class ControladorSacole {
    public static void inserir(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNrdeserie(Integer.parseInt(man.jtfNrdeserie.getText()));
        objeto.setPreco(Double.parseDouble(man.jtfPreco.getText()));
        objeto.setSabor(man.jtfSabor.getText());
        
        boolean resultado = SacoleDao.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
}
