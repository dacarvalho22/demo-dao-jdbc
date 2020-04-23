package Application;

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
		
	}

}
