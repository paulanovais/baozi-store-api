package br.edu.uninter.baozi.model;
import jakarta.persistence.*;

@Entity public class Pedido {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
private Long clienteId;
private Long produtoId;
private Integer quantidade;
public Long getId(){return id;} public void setId(Long id){this.id=id;}
public Long getClienteId(){return clienteId;} public void setClienteId(Long value){this.clienteId=value;}
public Long getProdutoId(){return produtoId;} public void setProdutoId(Long value){this.produtoId=value;}
public Integer getQuantidade(){return quantidade;} public void setQuantidade(Integer value){this.quantidade=value;}
}
