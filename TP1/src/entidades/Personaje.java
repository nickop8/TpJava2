package entidades;/*Nico**/

import javax.swing.JOptionPane;

public class Personaje {
	private int codigo, vida, energia, defensa, evasion, ptos_totales, energiaPartida, vidaPartida;
	private String nombre;
	
	public Personaje(){
		this.setDefensa(0);
		this.setVida(0);
		this.setEnergia(0);
		this.setEvasion(0);
		this.setPtos_totales(200);
	}
	
	public boolean atacar(String ataque, int evasionOponente){
	
		this.energiaPartida -= Integer.parseInt(ataque);
		if((Math.random() * 100) > evasionOponente)	
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void recibirAtaque(String ataque){
		
		this.vidaPartida -= Integer.parseInt(ataque);
		
	}
	
	public void defender(){
		int energiaARecuperar, vidaARecuperar;
		energiaARecuperar = this.energiaPartida * this.defensa / 100;
		if ((energiaARecuperar + this.energiaPartida) > this.energia )
		{
			this.energiaPartida = this.energia;
		}
		else
		{
			this.energiaPartida += energiaARecuperar ;
		}
		vidaARecuperar = this.vidaPartida * this.defensa / 250;
		if ((vidaARecuperar + this.vidaPartida)> this.vida)
		{
			this.vidaPartida = this.vida;
		}
		else{
			this.vidaPartida += vidaARecuperar;
		}
	}
	
	public int getEnergiaPartida() {
		return energiaPartida;
	}
	public void setEnergiaPartida() {
		this.energiaPartida = this.energia;
	}
	
	public int getVidaPartida() {
		return vidaPartida;
	}
	public void setVidaPartida() {
		this.vidaPartida = this.vida;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}
	
	public int getPtos_totales() {
		return ptos_totales;
	}
	public void setPtos_totales(int ptos_totales) {
		this.ptos_totales = ptos_totales;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
