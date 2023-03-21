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

		return service.recuperarTodos();
	}

	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> recuperarPeloId(@PathVariable int id) {
		Cliente c = service.recuperarPeloId(id);
		if (c != null) {
			return ResponseEntity.ok(c);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/cliente")
	public ResponseEntity<?> cadastrarNovo(@RequestBody Cliente novo) {
		if (novo.getNome() != null && novo.getCpf() != null && novo.getTelefone() != null) {
			Cliente res = service.cadastrarNovo(novo);
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.badRequest().body("Dados inválidos. Cliente não cadastrado");
	}
	
	//https://apijavau-production.up.railway.app/
	@GetMapping("/")
    public String home() {
        return "<!DOCTYPE html>\r\n"
        		+ "<html>\r\n"
        		+ "<head>\r\n"
        		+ "    <title>Javaú - Um banco pensado para você!</title>\r\n"
        		+ "    <meta charset=\"UTF-8\">\r\n"
        		+ "    <style>\r\n"
        		+ "        body {\r\n"
        		+ "            background-color: #ffffff;\r\n"
        		+ "            color: #1a1a1a;\r\n"
        		+ "            font-family: Arial, sans-serif;\r\n"
        		+ "            margin: 0;\r\n"
        		+ "            padding: 0;\r\n"
        		+ "        }\r\n"
        		+ "\r\n"
        		+ "        /* Estilos para o banner */\r\n"
        		+ "        .banner {\r\n"
        		+ "            background-color: #ff6600;\r\n"
        		+ "            padding: 10px;\r\n"
        		+ "            text-align: center;\r\n"
        		+ "            color: #ffffff;\r\n"
        		+ "            font-family: Arial Black, sans-serif;\r\n"
        		+ "            font-size: 32px;\r\n"
        		+ "        }\r\n"
        		+ "\r\n"
        		+ "        /* Estilos para o texto de boas-vindas */\r\n"
        		+ "        h1 {\r\n"
        		+ "            color: #1a1a1a;\r\n"
        		+ "            font-size: 28px;\r\n"
        		+ "            font-family: Arial Black, sans-serif;\r\n"
        		+ "            text-align: center;\r\n"
        		+ "        }\r\n"
        		+ "\r\n"
        		+ "        /* Estilos para os botões */\r\n"
        		+ "        button {\r\n"
        		+ "            background-color: #00408A;\r\n"
        		+ "            border: none;\r\n"
        		+ "            border-radius: 5px;\r\n"
        		+ "            color: #ffffff;\r\n"
        		+ "            cursor: pointer;\r\n"
        		+ "            font-family: Arial, sans-serif;\r\n"
        		+ "            font-size: 16px;\r\n"
        		+ "            margin: 10px;\r\n"
        		+ "            padding: 10px 20px;\r\n"
        		+ "            text-align: center;\r\n"
        		+ "            text-decoration: none;\r\n"
        		+ "            display: inline-block;\r\n"
        		+ "        }\r\n"
        		+ "\r\n"
        		+ "        button:hover {\r\n"
        		+ "            background-color: #1a1a1a;\r\n"
        		+ "        }\r\n"
        		+ "\r\n"
        		+ "        /* Estilos para o subtítulo */\r\n"
        		+ "        h2 {\r\n"
        		+ "            color: #ffffff;\r\n"
        		+ "            font-size: 24px;\r\n"
        		+ "            font-family: Arial, sans-serif;\r\n"
        		+ "            text-align: center;\r\n"
        		+ "            margin-top: 0;\r\n"
        		+ "            padding-top: 30px;\r\n"
        		+ "            background-color: #00408A;\r\n"
        		+ "            padding-bottom: 30px;\r\n"
        		+ "        }\r\n"
        		+ "    </style>\r\n"
        		+ "</head>\r\n"
        		+ "<body>\r\n"
        		+ "    <div class=\"banner\">\r\n"
        		+ "        Javaú\r\n"
        		+ "    </div>\r\n"
        		+ "    <h1>Bem-vindo(a) ao Javaú</h1>\r\n"
        		+ "    <h2>Um banco pensado para você!</h2>\r\n"
        		+ "    <div style=\"text-align: center;\">\r\n"
        		+ "        <a href=\"/cliente\"><button>Clientes</button></a>\r\n"
        		+ "        <a href=\"/conta\"><button>Contas</button></a>\r\n"
        		+ "    </div>\r\n"
        		+ "</body>\r\n"
        		+ "</html>";
    }

}
