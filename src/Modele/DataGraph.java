package Modele;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * <b>DataGraph contient toutes les données d'un graphique</b>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class DataGraph implements Serializable{
	
	/**
     * Le titre du tableau et des axes.
     * 
     * @see DataGraph#chTitre
     * @see DataGraph#chTitreX
     * @see DataGraph#chTitreY
     */
	private String chTitre,chTitreX, chTitreY;
	
	/**
     * Listes contenant les valeurs des différentes series.
     * 
     * @see DataGraph#setElement(int, int)
     * @see DataGraph#getElementY(int, int)
     * @see DataGraph#getListeY(int)
     */
	private ArrayList<Integer> serie1,serie2,serie3,serie4,serie5,serie6;
	
	/**
     * Liste contenant les valeurs de l'axe des abscisses.
     * 
     * @see DataGraph#setAbscisse(int)
     * @see DataGraph#getAbscisse(int)
     * @see DataGraph#getListeX()
     */
	private ArrayList<Integer> abscisse;
	
	/**
     * Tableau contenant les noms des series.
     * 
     * @see DataGraph#setNomSerie(int, String)
     * @see DataGraph#getNomSerie()
     * @see DataGraph#getTitreS(int)
     */
	private String[] chNomSerie;
	
	/**
     * Permet de connaître de nombre de series et d'éléments.
     * 
     * @see DataGraph#setNbrS(int)
     * @see DataGraph#setNbrE(int)
     * @see DataGraph#getNbrS()
     * @see DataGraph#getNbrE()
     */
	private int nbrS, nbrE;
	
	/**
     * Constructeur DataGraph.
     * 
     * @see DataGraph#chTitre
     * @see DataGraph#chTitreX
     * @see DataGraph#chTitreY
     * @see DataGraph#abscisse
     * @see DataGraph#serie1
     * @see DataGraph#serie2
     * @see DataGraph#serie3
     * @see DataGraph#serie4
     * @see DataGraph#serie5
     * @see DataGraph#serie6
     * @see DataGraph#chNomSerie
     * @see DataGraph#nbrS
     * @see DataGraph#nbrE
     */
	public DataGraph(){
		chTitre = new String();
		chTitreX = new String();
		chTitreY = new String();
		abscisse = new ArrayList<Integer>();
		serie1 = new ArrayList<Integer>();
		serie2 = new ArrayList<Integer>();
		serie3 = new ArrayList<Integer>();
		serie4 = new ArrayList<Integer>();
		serie5 = new ArrayList<Integer>();
		serie6 = new ArrayList<Integer>();
		chNomSerie = new String[6];
		nbrS = 0;
		nbrE = 0;
	}
	
	/**
     * Ajoute le nombre de series.
     * 
     * @param parNbr
     * @see Zero#nbrS
     */
	public void setNbrS(int parNbr){
		nbrS = parNbr;
	}
	
	/**
     * Ajoute le nombre d'éléments.
     * 
     * @param parNbr
     * @see Zero#nbrE
     */
	public void setNbrE(int parNbr){
		nbrE = parNbr;
	}
	
	/**
     * Ajoute le titre du graph.
     * 
     * @param parTitre
     * @see Zero#chTitre
     */
	public void setTitre(String parTitre){
		chTitre = parTitre;
	}
	
	/**
     * Ajoute le titre de l'abscisse du graph.
     * 
     * @param parTitre
     * @see Zero#chTitreX
     */
	public void setTitreX(String parTitre){
		chTitreX = parTitre;
	}
	
	/**
     * Ajoute le titre de l'ordonnée du graph.
     * 
     * @param parTitre
     * @see Zero#chTitreY
     */
	public void setTitreY(String parTitre){
		chTitreY = parTitre;
	}
	
	/**
     * Ajoute une valeurs à l'axe des abscisses.
     * 
     * @param parElement
     * @see Zero#abscisse
     */
	public void setAbscisse(int parElement){
		abscisse.add(parElement);
	}
	
	/**
     * Ajoute une valeurs à une serie.
     * 
     * @param parSerie
     * @param parElement
     * @see Zero#serie1
     * @see Zero#serie2
     * @see Zero#serie3
     * @see Zero#serie4
     * @see Zero#serie5
     * @see Zero#serie6
     */
	public void setElement(int parSerie, int parElement){
		switch (parSerie)
		{
		case 1:
			serie1.add(parElement);
			break;
		case 2:
			serie2.add(parElement);
			break;
		case 3:
			serie3.add(parElement);
			break;
		case 4:
			serie4.add(parElement);
			break;
		case 5:
			serie5.add(parElement);
			break;
		case 6:
			serie6.add(parElement);
			break;	
		}
	}
	
	/**
     * Ajoute un nom à une serie.
     * 
     * @param parSerie
     * @param parNomSerie
     * @see Zero#chNomSerie
     */
	public void setNomSerie(int parSerie, String parNomSerie){
		chNomSerie[parSerie] = parNomSerie;
	}
	
	/**
     * Retourne les noms des series.
     * 
     * @see Zero#chNomSerie
     * @return Un tableau de nom de serie
     */
	public String[] getNomSerie(){
		return chNomSerie;
	}
	
	/**
     * Retourne le titre du graph.
     * 
     * @see Zero#chTitre
     * @return Le titre du graph
     */
	public String getTitre(){
		return chTitre;
	}
	
	/**
     * Retourne le titre de l'abscisse.
     * 
     * @see Zero#chTitreX
     * @return Le titre de l'abscisse
     */
	public String getTitreX(){
		return chTitreX;
	}
	
	/**
     * Retourne le titre de l'ordonnée.
     * 
     * @see Zero#chTitreY
     * @return Le titre de l'ordonnée
     */
	public String getTitreY(){
		return chTitreY;
	}
	
	/**
     * Retourne le nom d'une serie.
     * 
     * @see Zero#chNomSerie
     * @param parSerie
     * @return Le nom en fonction de la serie
     */
	public String getTitreS(int parSerie){
		return chNomSerie[parSerie];
	}
	
	/**
     * Retourne le nombre de serie.
     * 
     * @see Zero#nbrS
     * @return nombre de series
     */
	public int getNbrS(){
		return nbrS;
	}
	
	/**
     * Retourne le nombre d'éléments.
     * 
     * @see Zero#nbrE
     * @return nombre d'éléments
     */
	public int getNbrE(){
		return nbrE;
	}
	
	/**
     * Retourne une valeur de l'abscisse.
     * 
     * @see Zero#abscisse
     * @param parElement
     * @return valeur de l'abscisse en fonction de son rang dans la liste
     */
	public int getAbscisse(int parElement){
		return abscisse.get(parElement);
	}
	
	/**
     * Retourne une valeur de l'ordonnée.
     * @param parSerie
     * @param parElement
     * @see Zero#serie1
     * @see Zero#serie2
     * @see Zero#serie3
     * @see Zero#serie4
     * @see Zero#serie5
     * @see Zero#serie6
     * @return valeur de l'ordonnée en fonction de son rang dans la liste et de sa serie
     */
	public int getElementY(int parSerie, int parElement){
		int i = 0;
		switch (parSerie)
		{
		case 1:
			i = serie1.get(parElement);
			break;
		case 2:
			i = serie2.get(parElement);
			break;
		case 3:
			i = serie3.get(parElement);
			break;
		case 4:
			i = serie4.get(parElement);
			break;
		case 5:
			i = serie5.get(parElement);
			break;
		case 6:
			i = serie6.get(parElement);
			break;
		}
		return i;
	}
	
	/**
     * Retourne la liste des abscisses.
     * 
     * @see Zero#abscisse
     * @return la liste des abscisses
     */
	public ArrayList getListeX(){
		return abscisse;
	}
	
	/**
     * Retourne une liste contenant tous les éléments de chaques series.
     * @param parNbrS
     * @see Zero#serie1
     * @see Zero#serie2
     * @see Zero#serie3
     * @see Zero#serie4
     * @see Zero#serie5
     * @see Zero#serie6
     * @return une liste de tous les éléments des series du graph
     */
	public ArrayList getListeY(int parNbrS){
		ArrayList l = new ArrayList();
		switch (parNbrS)
		{
		case 1:
			l.addAll(serie1);
			break;
		case 2:
			l.addAll(serie1);
			l.addAll(serie2);
			break;
		case 3:
			l.addAll(serie1);
			l.addAll(serie2);
			l.addAll(serie3);
			break;
		case 4:
			l.addAll(serie1);
			l.addAll(serie2);
			l.addAll(serie3);
			l.addAll(serie4);
			break;
		case 5:
			l.addAll(serie1);
			l.addAll(serie2);
			l.addAll(serie3);
			l.addAll(serie4);
			l.addAll(serie5);
			break;
		case 6:
			l.addAll(serie1);
			l.addAll(serie2);
			l.addAll(serie3);
			l.addAll(serie4);
			l.addAll(serie5);
			l.addAll(serie6);
			break;	
		}
		return l;
	}
}
