package br.edu.uninter.baozi.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity public class Produto {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
private String nome;
private BigDecimal preco;
private Boolean estoque;
public Long getId(){return id;} public void setId(Long id){this.id=id;}
public String getNome(){return nome;} public void setNome(String value){this.nome=value;}
public BigDecimal getPreco(){return preco;} public void setPreco(BigDecimal value){this.preco=value;}
public Boolean getEstoque(){return estoque;} public void setEstoque(Boolean value){this.estoque=value;}
}
