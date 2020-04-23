package Application;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDao vendDao = DaoFactory.criarVendedorDao();
		
		System.out.println("=== Teste 1 - seller findById ===");
		Vendedor ved = vendDao.retornaId(3);
		
		System.out.println(ved);
	}

}
