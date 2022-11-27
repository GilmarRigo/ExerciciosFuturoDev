package br.com.futurodev.pedidos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table( name = "pedido")
public class Pedido implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(columnDefinition = "timestamp without time zone DEFAULT timezone('utc'::text, CURRENT_TIMESTAMP(0))", updatable = false)
    private OffsetDateTime dataHoraCadastro;

    @UpdateTimestamp
    @Column(columnDefinition = "timestamp without time zone")
    private OffsetDateTime dataHoraAlteracao;

    @ManyToOne
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "fk_cliente"))
    //@JsonManagedReference
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_forma_pagamento", referencedColumnName = "id",  foreignKey = @ForeignKey(name = "fk_forma_pgto"))
    private FormaPagamento formaPagamento;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

    @JsonManagedReference
    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    @JsonBackReference
    public Cliente getCliente() {
        return cliente;
    }
}
