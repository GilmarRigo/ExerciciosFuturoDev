package br.com.futurodev.pedidos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nome;

    @Column(length = 11, unique = true)
    private String cpf;

    @Column(length = 20)
    private String rg;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    //@JsonBackReference
    private List<Pedido> pedidos =  new ArrayList<>();

    @JsonManagedReference
    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
