package br.com.projetofinalturmaiv.apibanco.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinalturmaiv.apibanco.model.Conta;
import br.com.projetofinalturmaiv.apibanco.model.Movimentacao;

public interface MovimentacaoRepo extends CrudRepository<Movimentacao, Integer>{
	
	public ArrayList<Movimentacao> findByConta(Conta conta);

}
