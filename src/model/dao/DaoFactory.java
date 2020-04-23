package model.dao;

import model.dao.impl.VendedorDaoJDBC;

public class DaoFactory {
	
	public static VendedorDao criarVendedorDao() {
		// Onde vai contar todos os meus CRUDs
		return new VendedorDaoJDBC();
	}

}
