package com.banco.bancobackend.control;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteControl {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping()
	public ArrayList<Cliente> obtenerClientes(){
		return this.clienteService.leerClientes();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Cliente> obtenerCliente(@PathVariable("id")Integer id){
		return this.clienteService.leerClientePorId(id);
		}
	
	@PostMapping()
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		
		return this.clienteService.guardarCliente(cliente);
	}
	
	@DeleteMapping(path = "/{id}")
	public void borrarCliente(@PathVariable ("id")Integer id) {
		this.clienteService.borrarCliente(id);
		}
	
	@GetMapping(path="/correo/{correo}")
	public Optional<Cliente> obtenerCorreo(@PathVariable("correo")String correo){
		return this.clienteService.buscarPorCorreo(correo);
		}
	@GetMapping(path="/gestor/{idGestor}")
	public ArrayList<Cliente> obtenerClientePorGestor(@PathVariable("idGestor")Integer id){
		return this.clienteService.buscarPorIdGestor(id);
	}
	@GetMapping(path="/login")
	public Optional<Cliente> loguearGestor(@RequestParam("correo")String correo,@RequestParam("password")String password){
		return this.clienteService.buscarPorCorreoYPass(correo, password);
		}
}
