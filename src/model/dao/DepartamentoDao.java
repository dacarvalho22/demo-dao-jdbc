package model.dao;

import java.util.List;

import model.entities.Departamento;

// IMPLEMETAÇÃO DO MEU DAO DO "DEPARTAMENTO"
public interface DepartamentoDao {

	void insert(Departamento obj);

	void update(Departamento obj);

	void deleteById(Integer id);

	Departamento retornaId(Integer id);

	// O tipo de lista quem escolhe sou eu
	List<Departamento> retornarTodosDep();

}
