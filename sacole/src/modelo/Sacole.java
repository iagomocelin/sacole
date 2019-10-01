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
    private Integer codigo;
    private Integer nrdeserie;
    private LocalDate data; 
    private Double preco;
    private String sabor;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNrdeserie() {
        return nrdeserie;
    }

    public void setNrdeserie(Integer nrdeserie) {
        this.nrdeserie = nrdeserie;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
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
        return "Sacole{" + "sabor=" + sabor + '}';
    }

    

}
