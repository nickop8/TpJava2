package negocio;

import java.util.ArrayList;

import data.DataPersonaje;
import entidades.*;

public class CtrlABMPersonaje {

	private ArrayList<Personaje> personajes;
	
	private data.DataPersonaje dataPer;
	
	public CtrlABMPersonaje(){
		personajes = new ArrayList<Personaje>();
		dataPer=new DataPersonaje();
	}
	
	public void add(Personaje p) {
		dataPer.add(p);
	}
	
	public void update(Personaje p){
		dataPer.update(p);
	}
	
	public void delete(Personaje p){
		dataPer.delete(p);
	}
	
	public Personaje getPersonaje (Personaje p){
		return dataPer.getByCodigo(p);
	}
}
