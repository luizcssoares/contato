package br.luiz.contato.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Contato implements Serializable {
 
  private static final long serialVersionUID = 1L;
   
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
 
  private String cpf;
  
  private String fone;
  
  private String nome;
   
  private String email;
  
  @DateTimeFormat(pattern="dd/MM/yyyy")
  private Date data;

  public long getId() {
	  return id;
  }

  public void setId(long id) {
	 this.id = id;
  }

  public String getNome() {
	 return nome;
  }

  public void setNome(String nome) {
	 this.nome = nome;
  }

  public String getEmail() {
	 return email;
  }

  public void setEmail(String email) {
	 this.email = email;
  }

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getFone() {
	return fone;
}

public void setFone(String fone) {
	this.fone = fone;
}

public Date getData() {
	return data;
}

public void setData(Date date) {
	this.data = (Date) date;
}
}