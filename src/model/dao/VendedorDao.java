package model.dao;

import java.util.List;

import model.entities.Vendedor;

public interface VendedorDao {
	
	void insert(Vendedor obj);

	void update(Vendedor obj);

	void deleteById(Integer id);

	Vendedor retornaId(Integer id);

	// O tipo de lista quem escolhe sou eu
	List<Vendedor> retornarTodosVend();

}
