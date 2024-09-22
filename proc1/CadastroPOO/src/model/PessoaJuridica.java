/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;

/**
 *
 * @author rafae
 */
public class PessoaJuridica extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L; 
    private String cnpj;

    // Construtor padrão
    public PessoaJuridica() {
    }

    // Construtor completo
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
   
    // Método exibir polimórfico
    @Override
    public void exibir() {
        super.exibir(); // Chama o método da classe pai
        System.out.println("CNPJ: " + cnpj);
    }
}