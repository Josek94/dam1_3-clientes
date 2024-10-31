package com.prueba.dam1_03.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prueba.dam1_03.entity.Cliente;
import com.prueba.dam1_03.service.IClienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	IClienteService clienteService;
	
	@ModelAttribute("titulo")
	public String dameTitulo() {
		return "Los clientes";
	}
	
	@GetMapping("/all")
	public String mostrarTodosLosClientes(Model model) {
		model.addAttribute("titular", "Listado de clientes");
		model.addAttribute("text", "mostrando el listado de clientes");
		model.addAttribute("clientes", clienteService.todosLosClientes());
		return "cliente/lista";
	}
	
	@GetMapping("/id/{id}")
	public String mostrarUnCliente(Model model, @PathVariable Long id) {
		model.addAttribute("titular", "Informacion de cliente");
		model.addAttribute("text", "mostrando informacion de cliente");
		model.addAttribute("cliente", clienteService.clientePorId(id));
		return "cliente/un-cliente";
	}
	
	@GetMapping("/delete/id/{id}")
	public String borrarUnCliente(@PathVariable Long id, RedirectAttributes flash) {
		clienteService.borrarClientePorId(id);
		flash.addFlashAttribute("warning", "Usuario borrado con éxito");
		return "redirect:/cliente/all";
	}
	
	@GetMapping("/form/{id}")
	public String UnClienteEnForm(Model model, @PathVariable Long id) {
		model.addAttribute("titular", "modificacion de informacion de cliente");
		model.addAttribute("text", "mostrando informacion del cliente para su modificacion");
		model.addAttribute("cliente", clienteService.clientePorId(id));
		return "cliente/form";
	}
	
	@PostMapping("/form")
	public String formClientePost(@Valid Cliente cliente, BindingResult result, Map<String, Object> model,RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.put("titular", "modificacion de informacion de cliente");
			model.put("text", "mostrando informacion del cliente para su modificacion");
			model.put("cliente", cliente);
			return "cliente/form";
		}
		clienteService.save(cliente);
		flash.addFlashAttribute("success", "Usuario guardado con éxito");
		return "redirect:/cliente/all";
	}
	
	@GetMapping("/form")
	public String UnClienteNuevo(Model model) {
		model.addAttribute("titular", "modificacion de informacion de cliente");
		model.addAttribute("text", "mostrando informacion del cliente para su modificacion");
		model.addAttribute("cliente", new Cliente());
		return "cliente/form";
	}
	
	
	
	
	
}
