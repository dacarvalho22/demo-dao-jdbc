package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;
             
public class VendedorDaoJDBC implements VendedorDao {

	private Connection conexao;
	
	public VendedorDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}
	
	@Override
	public void insert(Vendedor obj) {
		

	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vendedor retornaId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = " SELECT seller.*,department.Name as DepName " + 
				" FROM seller INNER JOIN department " + 
				" ON seller.DepartmentId = department.Id " + 
				" WHERE seller.Id = ?";
		try{
			st = conexao.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()){
				Departamento dept = instanciandoDept(rs);				
				Vendedor ved = instaciaVendedor(dept, rs);
				return ved;
			}		
			return null;
			
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}finally{
			DB.closeStatementResultSet(st, rs);
		}	
	}

	private Vendedor instaciaVendedor(Departamento dept, ResultSet rs) throws SQLException {
		Vendedor vend = new Vendedor();
		vend.setIdVend(rs.getInt("Id"));
		vend.setNomeVend(rs.getString("Name"));
		vend.setEmailVend(rs.getString("Email"));
		vend.setDataAniVend(rs.getDate("BirthDate"));
		vend.setSalarioVend(rs.getDouble("BaseSalary"));
		vend.setDepatamento(dept);
		return vend;
	}

	private Departamento instanciandoDept(ResultSet rs) throws SQLException {
		Departamento dept = new Departamento();
		dept.setIdDepart(rs.getInt("DepartmentId"));
		dept.setNomeDepart(rs.getString("DepName"));
		return dept;
	}

	@Override
	public List<Vendedor> retornarTodosVend() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> retornaDepart(Departamento dept) {
		// TODO Auto-generated method stub
		return null;
	}

}
