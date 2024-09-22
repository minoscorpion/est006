/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author rafae
 */
// Classe PessoaJuridicaRepo
public class PessoaJuridicaRepo {
    private List<PessoaJuridica> lista = new ArrayList<>();

    // Método para inserir uma nova pessoa jurídica
    public void inserir(PessoaJuridica pessoa) {
        lista.add(pessoa);
    }

    // Método para alterar uma pessoa jurídica existente
    public void alterar(PessoaJuridica pessoa) {
        Optional<PessoaJuridica> existente = lista.stream()
                .filter(p -> p.getId() == pessoa.getId())
                .findFirst();
        existente.ifPresent(p -> p.setNome(pessoa.getNome()));
    }

    // Método para excluir uma pessoa jurídica por id
    public void excluir(int id) {
        lista.removeIf(p -> p.getId() == id);
    }

    // Método para obter uma pessoa jurídica por id
    public PessoaJuridica obter(int id) {
        return lista.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Método para obter todas as pessoas jurídicas
    public List<PessoaJuridica> obterTodos() {
        return lista;
    }

    // Método para persistir os dados em arquivo
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(lista);
        }
    }

    // Método para recuperar os dados de arquivo
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            lista = (ArrayList<PessoaJuridica>) ois.readObject();
        }
    }
}
