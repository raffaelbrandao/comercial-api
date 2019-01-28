package com.algaworks.comercial.controller;

import com.algaworks.comercial.model.Oportunidade;
import java.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/oportunidades"})
public class OportunidadeController
{
  public OportunidadeController() {}
  
  @GetMapping
  public java.util.List<Oportunidade> Listar()
  {
    Oportunidade oportunidade = new Oportunidade();
    oportunidade.setId(Long.valueOf(1L));
    oportunidade.setDescricao("Desenvolvimento de ERP com Angular e Spring");
    oportunidade.setNomeProspecto("Grupo Logística Brasil");
    oportunidade.setValor(new java.math.BigDecimal(490000));
    
    return Arrays.asList(new Oportunidade[] { oportunidade });
  }
}
