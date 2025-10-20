package br.com.fiap.produtos.view;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;
import br.com.fiap.produtos.repository.ProdutoCollectionRepository;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoView {

    public static Produto form(Produto produto) {

        Categoria categoria;

        do {
            categoria = CategoriaView.select(produto != null ? produto.getCategoria() : null);
        } while (categoria == null);

        String nome = "";
        do {
            nome = JOptionPane.showInputDialog(null, "Informe o nome do produto", produto != null ? produto.getNome() : "");
        } while (nome == null || nome.isEmpty());

        String descricao = "";
        do {
            descricao = JOptionPane.showInputDialog(null, "Informe a descrição do produto", produto != null ? produto.getDescricao() : "");
        } while (descricao == null || descricao.isEmpty());

        double preco = 0;
        do {
            try {
                preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o preço do produto", produto != null ? produto.getPreco() : 0));
            } catch (Exception e) {
                preco = 0;
            }
        } while (preco <= 0);

        Produto ret = produto;

        ret.setCategoria(categoria)
                .setNome(nome)
                .setDescricao(descricao)
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(preco));

        return ret;
    }

    public static void sucesso() {
        JOptionPane.showMessageDialog(null, "O produto foi salvo com sucesso!");
    }

    public static void sucesso(Produto produto) {
        JOptionPane.showMessageDialog(null, "Produto " + produto.getNome() + " foi salvo com sucesso!");
    }

    public static Produto select(Produto produto) {
        ProdutoCollectionRepository repository = new ProdutoCollectionRepository();

        Produto ret = (Produto) JOptionPane.showInputDialog(
                null,
                "Selecione um produto",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                repository.findAll().toArray(),
                produto == null ? null : produto
        );

        return ret;
    }

    public static void update(Produto produto) {
        Produto atualizado = form(produto);
        sucesso(atualizado);
        show(atualizado);
    }

    // Alteração feita aqui: private → public
    public static void show(Produto p) {
        System.out.println(p);

        String textoFormado = String.format(
                "PRODUTO:" + p.getNome() + System.lineSeparator() +
                        "DESCRIÇÃO:" + p.getDescricao() + System.lineSeparator() +
                        "CATEGORIA:" + p.getCategoria().toString() + System.lineSeparator() +
                        "PREÇO: %,.2f",
                p.getPreco().doubleValue()
        );

        JOptionPane.showMessageDialog(null, textoFormado);
    }
}
