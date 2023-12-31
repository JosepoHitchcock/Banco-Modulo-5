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
import org.springframework.web.bind.annotation.RestController;

import com.banco.bancobackend.model.Transferencia;
import com.banco.bancobackend.service.TransferenciaService;


@RestController
@RequestMapping("/transferencia")
@CrossOrigin(origins = "http://localhost:4200")
public class TransferenciaControl {
	
	@Autowired
	TransferenciaService transferenciaService;
	
	@GetMapping()
	public ArrayList<Transferencia> obtenerTransferencias(){
		return this.transferenciaService.leerTransferencias();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Transferencia> obtenerTransferencia(@PathVariable("id")Integer id){
		return this.transferenciaService.leerTransferenciaPorId(id);
		}
	@GetMapping(path="/ordenante/{idOrdenante}")
	public ArrayList<Transferencia> buscarTransferenciaPorOrdenante(@PathVariable("idOrdenante")Integer id){
		return this.transferenciaService.buscarTransferenciaPorOrdenante(id);
	}
	
	@GetMapping(path="/destino/{idDestino}")
	public ArrayList<Transferencia> buscarTransferenciaPorDestino(@PathVariable("idDestino")Integer id){
		return this.transferenciaService.buscarTransferenciaPorDestino(id);
	}
	
	@PostMapping()
	public Transferencia guardarTransferencia(@RequestBody Transferencia transferencia) {
		
		return this.transferenciaService.guardarTransferencia(transferencia);
	}
	
	@DeleteMapping(path = "/{id}")
	public void borrarTransferencia(@PathVariable ("id")Integer id) {
		this.transferenciaService.borrarTransferencia(id);
		}

}
