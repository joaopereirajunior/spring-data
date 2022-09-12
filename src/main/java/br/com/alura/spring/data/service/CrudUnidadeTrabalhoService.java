package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {

	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	private Boolean system = true;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}

	public void initial(Scanner scanner) {
		while (system) {
			System.out.println("Qual funcao de unidade de trabalho deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);

				break;

			default:
				system = false;
				break;
			}
		}

	}

	private void salvar(Scanner scanner) {
		System.out.println("Descricao");
		String descricao = scanner.next();
		System.out.println("endereco");
		String endereco = scanner.next();
		

		UnidadeTrabalho unidade = new UnidadeTrabalho();
		unidade.setDescricao(descricao);
		unidade.setEndereco(endereco);
		unidadeTrabalhoRepository.save(unidade);
		System.out.println("####################Registro salvo#############");

	}

}
