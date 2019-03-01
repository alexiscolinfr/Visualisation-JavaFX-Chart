package Modele;

import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * <b>ModeleTab est la classe qui actualise les données du tableau</b>
 * <p>
 * Cette classe permet de créer un tableau correspondant aux données de DataGraph.
 * </p>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class ModeleTab extends DefaultTableModel {
	
	/**
     * Constructeur ModeleTab.
     * 
     * @param parDataGraph
     */
	public ModeleTab(DataGraph parDataGraph){
		
		String[] titreTable = new String[parDataGraph.getNomSerie().length+1];
		titreTable[0]=" ";
		
		for (int i=1 ; i<parDataGraph.getNomSerie().length+1 ; i++){
			titreTable[i]=parDataGraph.getTitreS(i-1);
		}
		
		setColumnIdentifiers(titreTable); //titre column table
		setColumnCount(parDataGraph.getNbrS()+1); //nbr de colonnes
		setRowCount(parDataGraph.getNbrE()); //nbr de lignes
		
		
		for (int i=0 ; i<parDataGraph.getNbrE() ; i++) {
			setValueAt(parDataGraph.getAbscisse(i), i, 0);
		}
		
		
		for (int i=0 ; i<parDataGraph.getNbrE() ; i++) {
			for (int j=1 ; j<parDataGraph.getNbrS()+1 ; j++) {
				setValueAt(parDataGraph.getElementY(j,i), i, j);
			}
		}
	}
}