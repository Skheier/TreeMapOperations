package org.example;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto implements Comparable {

    @EqualsAndHashCode.Include
    private Integer id;

    private String produto;

    private BigDecimal preco;

    @Override
    public int compareTo(Object o) {
        if (o instanceof Produto) {
            Produto outroProduto = (Produto) o;
            return id.compareTo(outroProduto.id);
        }
        throw new IllegalStateException("o nao e Produto");
    }
}
