package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		PreparedStatement st = null;
		String sql = "INSERT INTO seller " 
					+ " (Name, Email, BirthDate, BaseSalary, DepartmentId) "
				    + " VALUES " 
					+ " (?, ?, ?, ?, ?)";
					
		try{
			st = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNomeVend());
			st.setString(2, obj.getEmailVend());
			st.setDate(3, new java.sql.Date(obj.getDataAniVend().getTime()));
			st.setDouble(4, obj.getSalarioVend());
			st.setInt(5, obj.getDepatamento().getIdDepart());
			
			int linhaAf = st.executeUpdate();
			
			if(linhaAf > 0){
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setIdVend(id);
				}
				DB.closeStatementResultSet(null, rs);
			}else {
				throw new DbException("Erro ao inserir dados.");
			}			
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}finally{
			DB.closeStatementResultSet(st, null);
		}

	}

	@Override
	public void update(Vendedor obj) {
		PreparedStatement st = null;		
		
		String sql = "UPDATE seller " 
				+ " SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? " 
				+ " WHERE Id = ? ";
		
		try{	
			st = conexao.prepareStatement(sql);
			st.setString(1, obj.getNomeVend());
			st.setString(2, obj.getEmailVend());
			st.setDate(3, new java.sql.Date(obj.getDataAniVend().getTime()));
			st.setDouble(4, obj.getSalarioVend());
			st.setInt(5, obj.getDepatamento().getIdDepart());
			st.setInt(6, obj.getIdVend());
			st.executeUpdate();
									
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}finally{
			DB.closeStatementResultSet(st, null);
		}
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
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = " SELECT seller.*,department.Name as DepName " + 
				" FROM seller INNER JOIN department " + 
				" ON seller.DepartmentId = department.Id " + 
				" ORDER BY Name ";
		try{
			st = conexao.prepareStatement(sql);
			rs = st.executeQuery();
			
			List<Vendedor> list = new ArrayList<Vendedor>();
			Map<Integer, Departamento> map = new HashMap<Integer, Departamento>();
			
			while(rs.next()){
				Departamento dep = map.get(rs.getInt("DepartmentId"));
				if(dep == null) {
					dep = instanciandoDept(rs);
					map.put(rs.getInt("DepartmentId"), dep);					
				}			
				Vendedor vend2 = instaciaVendedor(dep, rs);
				list.add(vend2);
			}				
			return list;			
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}finally{
			DB.closeStatementResultSet(st, rs);
		}	
	}	

	@Override
	public List<Vendedor> retornaDepart(Departamento dept) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = " SELECT seller.*,department.Name as DepName " + 
				" FROM seller INNER JOIN department " + 
				" ON seller.DepartmentId = department.Id " + 
				" WHERE DepartmentId = ? " + 
				" ORDER BY Name ";
		try{
			st = conexao.prepareStatement(sql);
			st.setInt(1, dept.getIdDepart());
			rs = st.executeQuery();
			
			List<Vendedor> list = new ArrayList<Vendedor>();
			Map<Integer, Departamento> map = new HashMap<Integer, Departamento>();
			
			while(rs.next()){
				Departamento dep = map.get(rs.getInt("DepartmentId"));
				if(dep == null) {
					dep = instanciandoDept(rs);
					map.put(rs.getInt("DepartmentId"), dep);					
				}			
				Vendedor vend2 = instaciaVendedor(dep, rs);
				list.add(vend2);
			}				
			return list;			
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}finally{
			DB.closeStatementResultSet(st, rs);
		}	
	}

}
