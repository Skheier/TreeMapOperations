package org.example;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static ProdutoDAO dao = new ProdutoMemoryDAO();

    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("Cadastro de produtos");
            System.out.println(" 1 - Inserir");
            System.out.println(" 2 - Listar");
            System.out.println(" 3 - Alterar");
            System.out.println(" 4 - Excluir");
            System.out.println(" 5 - Pesquisar");
            System.out.println(" 6 - Sair");

            System.out.print("Digite a opção desejada: ");
            opcao = s.nextInt();
            switch (opcao) {
                case 1 -> insere();
                case 2 -> listar();
                case 3 -> editar();
                case 4 -> deletar();
                case 5 -> pesquisar();
                case 6 -> System.out.println("Desligando...");
                default -> System.out.println("Opcao invalida!\n");
            }
        }
        s.close();
    }

    private static void insere() {

        System.out.print("Digite a chave do novo índice: ");
        Integer key = s.nextInt();

        if(dao.pesquisa(key) != null){
            System.out.println("A chave "+key+" já está ocupada!\n");
            return;
        }

        System.out.print("Digite o id: ");
        Integer id = s.nextInt();

        System.out.print("Digite o nome: ");
        String produto = s.next();

        System.out.print("Digite o preco: ");
        String preco = s.next();

        Produto newProd = new Produto(id, produto, new BigDecimal(preco));
        dao.insere(key, newProd);
        System.out.println(newProd.getProduto()+ " adicionado com sucesso!\n");
    }

    private static void editar() {
        listar();

        System.out.print("Digite a chave do produto que deseja editar: ");
        Integer key = s.nextInt();

        Produto updatedProd = dao.pesquisa(key); //pega o valor do produtos.get

        if(updatedProd == null){
            System.out.println("Produto com a chave "+key+" não encontrado.\n");
            return;
        }

        System.out.print("Digite o novo id do produto: ");
        String id = s.next();
        updatedProd.setProduto(id);

        System.out.print("Digite o novo nome do produto: ");
        String produto = s.next();
        updatedProd.setProduto(produto);

        System.out.print("Digite o novo preco do produto: ");
        String preco = s.next();
        updatedProd.setPreco( new BigDecimal(preco) );

        dao.insere(key, updatedProd);
        System.out.println(updatedProd.getProduto()+ " alterado com sucesso!\n");
    }

    private static void deletar() {
        listar();

        System.out.print("Digite a chave do produto que deseja deletar: ");
        Integer key = s.nextInt();

        Produto returnedProd = dao.deleta(key);

        if(returnedProd == null){
            System.out.println("Produto com a chave "+key+" não encontrado.\n");
        } else {
            System.out.println( returnedProd.getProduto() +" deletado com sucesso!\n");
        }
    }

    private static void listar(){
        Collection<Produto> values = dao.lista();
        Set<Map.Entry<Integer, Produto>> indices = dao.listaEntry();

        for (Map.Entry<Integer, Produto> i : indices) {
            System.out.println(i.getKey() + " -> " + i.getValue());
        }

    }

    private static void pesquisar(){
        listar();
        System.out.print("Digite a chave do produto: ");
        Integer key = s.nextInt();

        Produto returnedProd = dao.pesquisa(key); //pega o valor do produtos.get

        if(returnedProd == null){
            System.out.println("Produto com a chave "+key+" não encontrado.\n");
            return;
        }

        System.out.println("Produto encontrado: "+returnedProd+"\n");
    }
}