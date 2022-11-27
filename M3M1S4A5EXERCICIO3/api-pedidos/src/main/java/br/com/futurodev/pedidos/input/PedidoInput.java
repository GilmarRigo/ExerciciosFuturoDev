package br.com.futurodev.pedidos.input;

import br.com.futurodev.pedidos.model.Cliente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class PedidoInput {

    @EqualsAndHashCode.Include

    private Long id;

    private OffsetDateTime dataHoraCadastro;

    private OffsetDateTime dataHoraAlteracao;

    private List<Cliente> cliente = new ArrayList<Cliente>();
}
