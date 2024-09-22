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
// Classe PessoaFisicaRepo
public class PessoaFisicaRepo {
    private List<PessoaFisica> lista = new ArrayList<>();

    // Método para inserir uma nova pessoa
    public void inserir(PessoaFisica pessoa) {
        lista.add(pessoa);
    }

    // Método para alterar uma pessoa existente
    public void alterar(PessoaFisica pessoa) {
        Optional<PessoaFisica> existente = lista.stream()
                .filter(p -> p.getId() == pessoa.getId())
                .findFirst();
        existente.ifPresent(p -> p.setNome(pessoa.getNome()));
    }

    // Método para excluir uma pessoa por id
    public void excluir(int id) {
        lista.removeIf(p -> p.getId() == id);
    }

    // Método para obter uma pessoa por id
    public PessoaFisica obter(int id) {
        return lista.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Método para obter todas as pessoas
    public List<PessoaFisica> obterTodos() {
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
            lista = (List<PessoaFisica>) ois.readObject();
        }
    }
}
