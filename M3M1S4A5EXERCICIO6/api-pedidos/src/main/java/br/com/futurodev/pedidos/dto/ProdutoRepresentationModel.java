package br.com.futurodev.pedidos.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRepresentationModel {

    @EqualsAndHashCode.Include

    private Long id;

    private String descricao;

    private String descricaoReduzida;

    private double precoCompra;

    private double precoVenda;
}
