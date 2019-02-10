package com.algaworks.comercial.controller;

import com.algaworks.comercial.model.Oportunidade;
import java.util.Arrays;
import java.util.Optional;

import com.algaworks.comercial.repository.OportunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping({"/oportunidades"})
public class OportunidadeController
{
  public OportunidadeController() {}

  @Autowired
  private OportunidadeRepository oportunidadeRepository;
  
  @GetMapping
  public java.util.List<Oportunidade> Listar()
  {
    return oportunidadeRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Oportunidade> Buscar(@PathVariable Long id)
  {
    Optional<Oportunidade> oportunidade = oportunidadeRepository.findById(id);

    if(oportunidade.isPresent())
    {
      return ResponseEntity.ok(oportunidade.get());
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Oportunidade adicionar(@Valid @RequestBody Oportunidade oportunidade)
  {
    Optional<Oportunidade> oportunidadeExistente = oportunidadeRepository
            .findByDescricaoAndNomeProspecto(oportunidade.getDescricao(), oportunidade.getNomeProspecto());

    if(oportunidadeExistente.isPresent()){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
              "Já existe uma oportunidade para este prospecto com a mesma descrição ");
    }

    return oportunidadeRepository.save(oportunidade);
  }
}
