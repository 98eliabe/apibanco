package br.com.projetofinalturmaiv.apibanco.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinalturmaiv.apibanco.model.Cliente;
import br.com.projetofinalturmaiv.apibanco.service.IClienteService;


@RestController
public class ClienteController {	

	@Autowired
	private IClienteService service;
	
	@GetMapping("/cliente")
	public ArrayList<Cliente> recuperarTodos() {
		
		return  service.recuperarTodos();
	}
	
		@GetMapping("/cliente/{id}")
		public ResponseEntity<Cliente> recuperarPeloId
		(@PathVariable int id) {
			Cliente c = service.recuperarPeloId(id);  
			if (c!= null) {
				return ResponseEntity.ok(c);
			}
			return ResponseEntity.notFound().build();

		}
		@PostMapping("/cliente")
		public ResponseEntity<?> cadastrarNovo(
				@RequestBody Cliente novo){
			Cliente res = service.cadastrarNovo(novo);
			if (res != null) {
				return ResponseEntity.ok(res);
			}
			return ResponseEntity.badRequest().build();
		}
	

	
}
	
	