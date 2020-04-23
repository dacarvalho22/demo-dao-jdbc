package model.dao;

import db.DB;
import model.dao.impl.VendedorDaoJDBC;

public class DaoFactory {
	
	public static VendedorDao criarVendedorDao() {
		// Onde vai contar todos os meus CRUDs - 
		// PASSANDO MINHA CLASSE CONEXÃO.
		return new VendedorDaoJDBC(DB.getConnection());
	}
}
