package br.com.projetofinalturmaiv.apibanco.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetofinalturmaiv.apibanco.model.Movimentacao;

public class MovimentacaoServiceImpl implements IMovimentacaoService {
	@Autowired
	private MovimentacaoRepo repo;

	@Override
	public ArrayList<Movimentacao> recuperarTodas() {
		// TODO Auto-generated method stub
		return (ArrayList<Movimentacao>) repo.findAll();
	}

	@Override
	public Movimentacao cadastrarNova(Movimentacao nova) {
		// TODO Auto-generated method stub
		return repo.save(nova);
	}

}
