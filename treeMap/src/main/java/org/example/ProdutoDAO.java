package org.example;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface ProdutoDAO {

    void insere(Integer key, Produto produto);

    Collection<Produto> lista();

    Set<Map.Entry<Integer, Produto>> listaEntry();

    Produto deleta(Integer key);

    Produto pesquisa(Integer key);
}
