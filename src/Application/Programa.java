package Application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDao vendDao = DaoFactory.criarVendedorDao();
		
		System.out.println("=== Teste 1 - seller findById ===");
		Vendedor ved = vendDao.retornaId(3);
		System.out.println(ved);
		
		System.out.println("\n=== Teste 2 - seller RetoraDept ===");
		Departamento dept = new Departamento(2, null);				
		List<Vendedor> list = vendDao.retornaDepart(dept);		
		for (Vendedor vend : list) {
			System.out.println(vend);
		}
		
		System.out.println("\n=== Teste 3 - seller RetoraTodos ===");
		
		List<Vendedor> list2 = vendDao.retornarTodosVend();
		for (Vendedor vend : list2) {
			System.out.println(vend);
		}
		
		System.out.println("\n=== Teste 4 - seller Insert ===");
		
        Vendedor ved2 = new Vendedor(null, "Daniel", "danielamaral@hotmail.com", new Date(), 4000.00, dept);
        vendDao.insert(ved2);
        System.out.println("Novo id: " + ved2.getIdVend());
		
        System.out.println("\n=== Teste 5 - seller Update ===");
        ved = vendDao.retornaId(1);
        ved.setNomeVend("Fulano de tal");
        vendDao.update(ved);
        System.out.println("Update: atualizado os dados. ");
        
        
        
	}

}
