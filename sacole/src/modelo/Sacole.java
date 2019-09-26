/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author Administrador
 */
public class Sacole {
    private int codigo;
    private int nrdeserie;
    private LocalDate data; 
    private double preco;
    private String sabor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNrdeserie() {
        return nrdeserie;
    }

    public void setNrdeserie(int nrdeserie) {
        this.nrdeserie = nrdeserie;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return "Sacole{" + "data=" + data + ", sabor=" + sabor + '}';
    }

}
