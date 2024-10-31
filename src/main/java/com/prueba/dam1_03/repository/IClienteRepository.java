package com.prueba.dam1_03.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.dam1_03.entity.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long> {

}
