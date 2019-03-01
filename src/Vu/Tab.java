package Vu;

import java.awt.*;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 * <b>Tab d�finit la structure du tableau</b>
 * <p>
 * Cette classe fixe la taille des lignes du tableau et permet de faire d�filer le tableau
 * lorsque celui-ci est trop grand pour la taille de la fen�tre.
 * </p>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class Tab extends JTable {
	
	/**
     * Constructeur Tab.
     * 
     */
	public Tab(){
		setRowHeight(30);
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
}