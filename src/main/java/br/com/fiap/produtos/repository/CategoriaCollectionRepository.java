package br.com.fiap.produtos.repository;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class CategoriaCollectionRepository {

    private static List<Categoria> categorias;

    static {
        categorias = new Vector<>();

        Categoria eletronicos = new Categoria(1L, "Eletrônicos");
        Categoria celulares = new Categoria(2L, "Celulares");
        Categoria livros = new Categoria(3L, "Livros");

        categorias.add(eletronicos);
        categorias.add(celulares);
        categorias.add(livros);
    }

    public static List<Categoria> findAll() {
        return categorias;
    }

    public static Categoria findById(Long id) {
        return categorias.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Categoria> findByNome(String nome) {
        return categorias.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .toList();
    }

    public static Categoria save(Categoria categoria) {
        boolean exists = categorias.stream()
                .anyMatch(c -> c.getNome().equalsIgnoreCase(categoria.getNome()));

        if (exists) {
            JOptionPane.showMessageDialog(null, "Já existe uma categoria com o nome informado");
            return null;
        }

        categorias.add(categoria);
        return categoria;
    }

    // Por enquanto apenas retorna lista vazia para compilar;
    // se quiser, implemento a busca verdadeira usando ProdutoCollectionRepository.
    public static List<Produto> findByCategoria(Categoria categoria) {
        return new Vector<>();
    }
}
