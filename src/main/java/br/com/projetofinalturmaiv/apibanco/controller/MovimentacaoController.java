package br.com.projetofinalturmaiv.apibanco.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinalturmaiv.apibanco.model.Conta;
import br.com.projetofinalturmaiv.apibanco.model.Movimentacao;
import br.com.projetofinalturmaiv.apibanco.service.IMovimentacaoService;

@RestController
public class MovimentacaoController {

	@Autowired
	private IMovimentacaoService service;

	@GetMapping("/movimentacao/{id}")
	public ResponseEntity<ArrayList<Movimentacao>> recuperarTodas(@PathVariable int id) {
		Conta conta = new Conta();
		conta.setNumeroConta(id);
		ArrayList<Movimentacao> m = service.recuperarTodasPorConta(conta);
		if (m != null) {
			return ResponseEntity.ok(m);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/movimentacao")
	public ResponseEntity<?> cadastrarNova(@RequestBody Movimentacao novo) {
		
		Movimentacao res = service.cadastrarNova(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@PostMapping("/transferencia")
	public ResponseEntity<?> cadastrarNova(	@RequestParam("origem") int contaOrigem,
											@RequestParam("destino") int contaDestino,
											@RequestParam("valor") double valor) {
		boolean res = service.transferirValores(contaOrigem, contaDestino, valor);
        if (res) {
            return ResponseEntity.ok("Transferência realizada com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Conta de origem não tem saldo suficiente");
        }
	}
	
}
