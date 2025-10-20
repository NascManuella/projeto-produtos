package br.com.fiap.produtos.view;

import javax.swing.JOptionPane;
import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.repository.CategoriaCollectionRepository;

public class CategoriaView {

    static CategoriaCollectionRepository repository;

    public static Categoria select(Categoria categoria) {
        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null,
                "Selecione uma categoria",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                repository.findAll().toArray(),
                categoria == null ? 1 : categoria);
        return ret;
    }



    public void sucesso() {
        JOptionPane.showMessageDialog(null, "A categoria foi salva com sucesso!");
    }

    public void sucesso(Categoria categoria) {
        JOptionPane.showMessageDialog(null, "Categoria " + categoria.getNome() + " foi salva com sucesso!");
    }

    public static Categoria form(Categoria categoria) {
        String nome = JOptionPane.showInputDialog(null, "Informe o nome da categoria", categoria !=null? categoria.getNome():"");
        return new Categoria(nome);
    }

}
