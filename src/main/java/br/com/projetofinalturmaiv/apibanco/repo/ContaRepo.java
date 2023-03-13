package br.com.projetofinalturmaiv.apibanco.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinalturmaiv.apibanco.model.Conta;

public interface ContaRepo extends CrudRepository<Conta, Integer> {
	
	public ArrayList<Conta> findAll();

	public ArrayList<Conta> findByOrderByCliente();
	
}
