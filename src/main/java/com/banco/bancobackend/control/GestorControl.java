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

import com.banco.bancobackend.model.Gestor;
import com.banco.bancobackend.service.GestorService;

@RestController
@RequestMapping("/gestor")
@CrossOrigin(origins = "http://localhost:4200")
public class GestorControl {

	@Autowired
	GestorService gestorService;
	
	@GetMapping()
	public ArrayList<Gestor> obtenerGestores(){
		return this.gestorService.leerGestores();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Gestor> obtenerGestor(@PathVariable("id")Integer id){
		return this.gestorService.leerGestorPorId(id);
		}
	
	@PostMapping()
	public Gestor guardarGestor(@RequestBody Gestor gestor) {
		
		return this.gestorService.guardarGestor(gestor);
	}
	
	@DeleteMapping(path = "/{id}")
	public void borrarGestor(@PathVariable ("id")Integer id) {
		this.gestorService.borrarGestor(id);
		}
	
	@GetMapping(path="/correo/{correo}")
	public Optional<Gestor> obtenerCorreo(@PathVariable("correo")String correo){
		return this.gestorService.buscarPorCorreo(correo);
		}
	@GetMapping(path="/login")
	public Optional<Gestor> loguearGestor(@RequestParam("correo")String correo,@RequestParam("password")String password){
		return this.gestorService.buscarPorCorreoYPass(correo, password);
		}
}
