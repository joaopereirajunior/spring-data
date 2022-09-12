package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private final CargoRepository cargoRepository;
	private Boolean system = true;
	
	public CrudCargoService (CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void initial (Scanner scanner) {
		while (system) {
			System.out.println("Qual funcao de cargo deseja executar");
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
				
			case 2:
				atualizar(scanner);
					
				break;
			case 3:
				visualizar();
					
				break;
			case 4:
				deletar(scanner);
					
				break;

			default:
				system = false;
				break;
				}
			}

			
		
		
		
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
	    cargoRepository.save(cargo); 
	    System.out.println("####################Registro salvo#############");
		
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("id a ser alterado");
		int idCargo = scanner.nextInt();
		
		System.out.println("Descricao novo cargo");
		String descricao = scanner.next();
		
		
		Cargo cargo = new Cargo();
		cargo.setId(idCargo);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		
	}
	
	public void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll(); 
		cargos.forEach(c -> System.out.println(c));
		
	}
	
	public void deletar(Scanner scanner) {
		System.out.println("Digite o id que deseja Deletar");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Registro deletado ###########");
	}
	

}
