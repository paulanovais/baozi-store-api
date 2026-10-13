package br.edu.uninter.baozi.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity public class Cliente {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
private String nome;
private LocalDate clienteDesde;
public Long getId(){return id;} public void setId(Long id){this.id=id;}
public String getNome(){return nome;} public void setNome(String value){this.nome=value;}
public LocalDate getClienteDesde(){return clienteDesde;} public void setClienteDesde(LocalDate value){this.clienteDesde=value;}
}
