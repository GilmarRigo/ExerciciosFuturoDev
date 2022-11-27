package br.com.futurodev.pedidos.input;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoInput {

    @EqualsAndHashCode.Include

    private Long id;

    //private Long idProduto;

    private String descricao;

    private String descricaoReduzida;

    private double precoCompra;

    private double precoVenda;
}
