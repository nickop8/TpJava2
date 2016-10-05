package data;


import java.sql.*;

import javax.swing.JOptionPane;

import entidades.*;
import utils.ApplicationException;

public class DataPersonaje {
	
	public DataPersonaje(){
		
	}
	
	public void add(Personaje p){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=MySqlConexion.getInstancia().getConn().prepareStatement(
					"insert into personajes(nom_personaje, vida, energia, defensa, evasion, ptos_totales)"+
					" values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
						
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPtos_totales());
			stmt.execute();
			
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setCodigo(rs.getInt(1));
			}
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		} 
		catch (ApplicationException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) 
					rs.close();
				if(stmt!=null)
					stmt.close();
				MySqlConexion.getInstancia().releaseConn();
			} 
			catch (ApplicationException e) {
				
				e.printStackTrace();
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}		
	}
	
	
	public void update(Personaje p){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt= MySqlConexion.getInstancia().getConn().prepareStatement(
					"update personajes set nom_personaje=?, vida=?, energia=?, defensa=?, evasion=?, ptos_totales=?"+
					" where nom_personaje=?");
			
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPtos_totales());
			stmt.setString(7, p.getNombre());	
			
			stmt.execute();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		} 
		catch (ApplicationException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)
					stmt.close();
				MySqlConexion.getInstancia().releaseConn();
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			} 
			catch (ApplicationException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	public void delete(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt = MySqlConexion.getInstancia().getConn().prepareStatement(
					"delete from personajes where cod_personaje=?");
			stmt.setInt(1, p.getCodigo());
			stmt.execute();
		} 
		catch (SQLException e) {

			e.printStackTrace();
		} 
		catch (ApplicationException e) {
			
			e.printStackTrace();
		} 
		finally {
			try {
				if(stmt!=null)
					stmt.close();
				MySqlConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ApplicationException e) {
				
				e.printStackTrace();
			}
		}		
	}
	
	
	public Personaje getByNombre(String nom){
		
		Personaje p=null;
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = MySqlConexion.getInstancia().getConn().prepareStatement(
					"select cod_personaje, nom_personaje, vida, energia, defensa, evasion, ptos_totales from personajes"+
			" where nom_personaje=?");
			stmt.setString(1, nom);
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Personaje();
				p.setCodigo(rs.getInt("cod_personaje"));				
				p.setNombre(rs.getString("nom_personaje"));
				p.setVida(rs.getInt("vida"));
				p.setEnergia(rs.getInt("energia"));
				p.setDefensa(rs.getInt("defensa"));
				p.setEvasion(rs.getInt("evasion"));
				p.setPtos_totales(rs.getInt("ptos_totales"));
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		} 
		catch (ApplicationException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				MySqlConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ApplicationException e) {
				
				e.printStackTrace();
			}
		}		
		return p;
	}
}
