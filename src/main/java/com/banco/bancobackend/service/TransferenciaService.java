package com.banco.bancobackend.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancobackend.model.Transferencia;
import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.repository.TransferenciaRepository;
@Service
public class TransferenciaService {
	
	@Autowired
	TransferenciaRepository transferenciaRepository;
	@Autowired
	ClienteService clienteService;
	
	public ArrayList<Transferencia> leerTransferencias(){
		return (ArrayList<Transferencia>) this.transferenciaRepository.findAll();
	}
	
	public Optional<Transferencia> leerTransferenciaPorId(Integer id){
		return this.transferenciaRepository.findById(id);
	}
	public Transferencia guardarTransferencia(Transferencia transferencia) {
		
		this.transferenciaRepository.save(transferencia);
		
		Double importe = transferencia.getImporte();
		
		Cliente ordenante =transferencia.getOrigen();
		
		ordenante = clienteService.leerClientePorId(ordenante.getId()).orElse(null);
		
		ordenante.setPassword(null);
		
		Double saldoOrdenante = ordenante.getSaldo();
		
		ordenante.setSaldo(saldoOrdenante-importe);
		
		return transferencia;
	}
	
	public void borrarTransferencia(Integer id) {
		this.transferenciaRepository.deleteById(id);
	}
}
