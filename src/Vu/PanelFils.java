package Vu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.File;

import javax.swing.JPanel;

import Modele.DataGraph;

/**
 * <b>PanelFils est la classe qui instancie PanelGraphTab</b>
 * <p>
 * Cette classe créer un JPanel qui contient PanelGraphTab.
 * </p>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class PanelFils extends JPanel {
	
	/**
     * Constructeur PanelFils.
     * 
     * @param parDataGraph
     * @param parFile
     * @param parPanelGT
     * @see PanelGraphTab
     */
	public PanelFils(DataGraph parDataGraph, File parFile, PanelGraphTab parPanelGT)
	{
		
		this.setLayout(new BorderLayout(10,10));
		this.add(parPanelGT);
	}
}
