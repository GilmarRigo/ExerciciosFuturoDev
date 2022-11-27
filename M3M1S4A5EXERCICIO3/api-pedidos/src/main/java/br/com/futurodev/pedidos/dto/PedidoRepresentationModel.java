package br.com.futurodev.pedidos.dto;

import br.com.futurodev.pedidos.model.Cliente;
import br.com.futurodev.pedidos.model.FormaPagamento;
import br.com.futurodev.pedidos.model.Pedido;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PedidoRepresentationModel {
    @EqualsAndHashCode.Include

    private Long id;

    private OffsetDateTime dataHoraCadastro;

    private OffsetDateTime dataHoraAlteracao;

    private List<Cliente> cliente = new ArrayList<Cliente>();

    private List<FormaPagamento> formaPagamento = new ArrayList<FormaPagamento>();

    private List<Pedido> pedido = new ArrayList<Pedido>();


}
