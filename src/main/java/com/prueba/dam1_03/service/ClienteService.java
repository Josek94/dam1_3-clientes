package com.prueba.dam1_03.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.prueba.dam1_03.entity.Cliente;
import com.prueba.dam1_03.repository.IClienteRepository;


@Service
public class ClienteService implements IClienteService {
	
	
	@Autowired
	IClienteRepository clienteRepository;

	@Override
	public Iterable<Cliente> todosLosClientes() {

		return clienteRepository.findAll();
	}

	@Override
	public Cliente clientePorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void borrarClientePorId(Long id) {
		clienteRepository.deleteById(id);
	}
	@Override
	public void save(Cliente cliente) {
		
		clienteRepository.save(cliente);
		
	}

	

}
