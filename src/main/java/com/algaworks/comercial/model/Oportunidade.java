package com.algaworks.comercial.model;

import java.math.BigDecimal;

public class Oportunidade {
  private Long id;
  private String nomeProspecto;
  private String descricao;
  private BigDecimal valor;
  
  public Oportunidade() {}
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getNomeProspecto() {
    return nomeProspecto;
  }
  
  public void setNomeProspecto(String nomeProspecto) {
    this.nomeProspecto = nomeProspecto;
  }
  
  public String getDescricao() {
    return descricao;
  }
  
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  
  public BigDecimal getValor() {
    return valor;
  }
  
  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if ((o == null) || (getClass() != o.getClass())) return false;
    Oportunidade that = (Oportunidade)o;
    return id.equals(id);
  }
  
  public int hashCode()
  {
    return java.util.Objects.hash(new Object[] { id });
  }
}
