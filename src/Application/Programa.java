package Application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		Departamento depart = new Departamento(001, "Informatrica");
		
		Vendedor vend = new Vendedor(001, "Daniel", "danielamaral@hotmail.com", new Date(), 35000.0, depart);
		
		
		VendedorDao vendDao = DaoFactory.criarVendedorDao();
		
		
		System.out.println(vend);
		//System.out.println(depart);
		
		

	}

}
