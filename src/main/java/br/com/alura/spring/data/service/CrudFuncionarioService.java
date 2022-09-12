package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {

	private final FuncionarioRepository funcionarioRepository;
	private Boolean system = true;

	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void initial(Scanner scanner) {
		while (system) {
			System.out.println("Qual funcao de Fucionario deseja executar");
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
		System.out.println("Nome do Funcionario");
		String nome = scanner.next();
		System.out.println("CPF do Funcionario");
		String cpf = scanner.next();
		System.out.println("Salario do Funcionario");
		Double salario = scanner.nextDouble();
		//String dataContratacao = scanner.next();

		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDataContatacao(null);
		funcionarioRepository.save(funcionario);
		System.out.println("####################Registro salvo#############");

	}

}
