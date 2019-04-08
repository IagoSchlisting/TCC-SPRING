package com.castel.models;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PEDIDO")
@Repository
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PEDIDO_ID")
    private Integer id;

    private String nomeCliente;

    private String telefone;

    @Enumerated(EnumType.ORDINAL)
    private StatusPedido statusPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "pedido")
    private List<Item> itens;

    private LocalDate start;

    private LocalDate end;

    private Double valorTotal;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "ENDERECO_ID")
//    private Endereco endereco;

//
//    @Enumerated(EnumType.ORDINAL)
//    private TipoPagamento tipoPagamento;
//
//    @Enumerated(EnumType.ORDINAL)
//    private Bandeira bandeira;
//
//    private Double troco;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
