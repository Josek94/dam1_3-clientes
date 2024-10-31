package com.prueba.dam1_03.service;


import com.prueba.dam1_03.entity.Cliente;

public interface IClienteService {
	Iterable<Cliente> todosLosClientes();
	Cliente clientePorId(Long id);
	void borrarClientePorId(Long id);
	void save(Cliente cliente);
}
