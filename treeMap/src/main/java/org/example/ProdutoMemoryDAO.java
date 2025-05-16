package org.example;

import java.util.*;

public class ProdutoMemoryDAO implements ProdutoDAO {
    private Map<Integer, Produto> produtos = new TreeMap<>();


    public void insere(Integer key, Produto produto) {
        produtos.put(key, produto);
    }

    public Produto deleta(Integer key) {
        return produtos.remove(key);
    }

    public Collection<Produto> lista(){
        return produtos.values();
    }

    public Set<Map.Entry<Integer, Produto> > listaEntry(){
        return produtos.entrySet();
    }

    public Produto pesquisa(Integer key){
        return produtos.get(key);
    }

}