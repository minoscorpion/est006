package cadastropoo;

import model.PessoaFisica;
import model.PessoaJuridica;
import model.PessoaFisicaRepo;
import model.PessoaJuridicaRepo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.IOException;
/**
 *
 * @author rafae
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try 
        {    
            /* PF */
            PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
            repoFisica.inserir(new PessoaFisica(1, "Mario", "99999999902", 23));
            repoFisica.inserir(new PessoaFisica(2, "Maria", "88888888801", 25));
            System.out.println("Dados de pessoas fisica armazenados");
            repoFisica.persistir("pessoas_fisicas.dat");
            System.out.println("Dados de pessoas fisica recuperados");
            repoFisica.recuperar("pessoas_fisicas.dat");
            
            for(PessoaFisica pf : repoFisica.obterTodos())
                pf.exibir();

            /* PJ */
            PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
            repoJuridica.inserir(new PessoaJuridica(1, "Empresa ABC", "11123323423422"));
            repoJuridica.inserir(new PessoaJuridica(2, "Empresa BDEF", "11232323232323"));
            repoJuridica.persistir("pessoas_juridicas.dat");
            System.out.println("Dados de pessoas juridica armazenados");
            repoJuridica.recuperar("pessoas_juridicas.dat");
            System.out.println("Dados de pessoas fisica recuperados");
                        
            for(PessoaJuridica pj : repoJuridica.obterTodos())
                pj.exibir();

        } 
        catch (IOException | ClassNotFoundException e) 
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
