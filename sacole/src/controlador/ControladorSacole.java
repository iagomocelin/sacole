/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.SacoleDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Sacole;
import tela.manutencao.ManutencaoSacole;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrador
 */
public class ControladorSacole {
    public static void inserir(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        objeto.setNrdeserie(Integer.parseInt(man.jtfNrdeserie.getText()));
        objeto.setData(LocalDate.parse(man.jtfData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setPreco(Double.parseDouble(man.jtfPreco.getText()));  
        objeto.setSabor(man.jtfSabor.getText());
        
        boolean resultado = SacoleDao.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
        
        
    }
    
    public static void alterar(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNrdeserie(Integer.parseInt(man.jtfNrdeserie.getText()));
        objeto.setData(LocalDate.parse(man.jtfData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setPreco(Double.parseDouble(man.jtfPreco.getText()));
        objeto.setSabor(man.jtfSabor.getText());
        
        boolean resultado = SacoleDao.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
     public static void excluir(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = SacoleDao.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("NÚMERO DE SÉRIE");
        modelo.addColumn("DATA DE VALIDADE");
        modelo.addColumn("PREÇO");
        modelo.addColumn("SABOR");
        List<Sacole> resultados = SacoleDao.consultar();
        for (Sacole objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNrdeserie());
            linha.add(objeto.getData());
            linha.add(objeto.getPreco());
            linha.add(objeto.getSabor());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    
    public static void atualizaCampos(ManutencaoSacole man, int pk){ 
        Sacole objeto = SacoleDao.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfNrdeserie.setText(objeto.getNrdeserie().toString());
        man.jtfData.setText(objeto.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jtfPreco.setText(objeto.getPreco().toString());
        man.jtfSabor.setText(objeto.getSabor());
        
        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
}
