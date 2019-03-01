package Vu;

import java.io.File;

import javax.swing.JFrame;

import Modele.DataGraph;

/**
 * <b>FenetreSaisie1 ouvre le PanelSaisie</b>
 * <p>
 * Cette classe crée une JFrame qui permet de complèter DataGraph
 * </p>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class FenetreSaisie1 extends JFrame {
	
	/**
     * Constructeur FenetreSaisie1.
     * 
     * @param parTitre
     * @param parDataGraph
     * @param parFile
     * @param parPanelGT
     */
	public FenetreSaisie1(String parTitre, DataGraph parDataGraph, File parFile, PanelGraphTab parPanelGT) 
	{
		super (parTitre);
		PanelSaisie Pane= new PanelSaisie(parDataGraph, parFile,this,parPanelGT);
		setContentPane(Pane);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (500,400); setVisible(true); setLocation(400,300);
	}

	public static void main(String[] args, DataGraph data, File file, PanelGraphTab panelGT) {
		new FenetreSaisie1("Saisie",data, file,panelGT);
	}

}
