package br.com.projetofinalturmaiv.apibanco.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projetofinalturmaiv.apibanco.model.Conta;
import br.com.projetofinalturmaiv.apibanco.model.Movimentacao;
import br.com.projetofinalturmaiv.apibanco.repo.MovimentacaoRepo;

@Component
public class MovimentacaoServiceImpl implements IMovimentacaoService {
	@Autowired
	private MovimentacaoRepo repo;

	@Autowired
	private IContaService service;
	
	@Override
	public ArrayList<Movimentacao> recuperarTodasPorConta(Conta c) {
		// TODO Auto-generated method stub
		return repo.findByConta(c);
	}

	@Override
	public Movimentacao cadastrarNova(Movimentacao nova) {
		// TODO Auto-generated method stub
		Conta c = service.recuperarPeloId(nova.getConta().getNumeroConta());
			if (c != null) {
				c.setSaldo(c.getSaldo()+nova.getValor()*nova.getTipoMovimentacao());
				service.atualizarConta(c);
				return repo.save(nova);
			}return null;
		
	}
	
}
