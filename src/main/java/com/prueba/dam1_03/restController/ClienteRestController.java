package com.prueba.dam1_03.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prueba.dam1_03.entity.Cliente;
import com.prueba.dam1_03.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/all-rest")
	public Iterable<Cliente> listaDeClientesAPIRest() {
		return clienteService.todosLosClientes();
	}
	
	@GetMapping("cliente/{id}")
	public Cliente mostrarUnCliente(@PathVariable Long id) {
		
		return clienteService.clientePorId(id);
	
	}
	
	@DeleteMapping("cliente/delete/{id}")
	public Iterable<Cliente> borrarUnCliente(@PathVariable Long id) {
		clienteService.borrarClientePorId(id);
			return clienteService.todosLosClientes();
	}
	
	
}
