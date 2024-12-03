/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lastf
 */
public class Estagiario extends Pinguim {
    private int registro;
    private int salarioPeixes;

    public Estagiario(int id, String nome, int idade, String endereco, String sexo, float altura, String telefone,
                      int registro, int salarioPeixes) {
        super(id, nome, idade, endereco, sexo, altura, telefone);
        this.registro = registro;
        this.salarioPeixes = salarioPeixes;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getSalarioPeixes() {
        return salarioPeixes;
    }

    public void setSalarioPeixes(int salarioPeixes) {
        this.salarioPeixes = salarioPeixes;
    }


    
    
}   
