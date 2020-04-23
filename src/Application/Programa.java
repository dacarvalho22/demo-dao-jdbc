package Application;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDao vendDao = DaoFactory.criarVendedorDao();
		
		Vendedor ved = vendDao.retornaId(3);
		
		System.out.println(ved);
	}

}
