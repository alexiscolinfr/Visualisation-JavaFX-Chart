package Vu;

import java.io.File;

import javax.swing.JFrame;

import Modele.DataGraph;

/**
 * <b>FenetreSaisie3 ouvre le PanelValeurs2</b>
 * <p>
 * Cette classe crée une JFrame qui permet de complèter DataGraph
 * </p>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class FenetreSaisie3 extends JFrame {
	
	/**
     * Constructeur FenetreSaisie3.
     * 
     * @param parTitre
     * @param parDataGraph
     * @param parFile
     * @param parPanelGT
     */
	public FenetreSaisie3(String parTitre, DataGraph parDataGraph, File parFile, PanelGraphTab parPanelGT) 
	{
		super (parTitre);
		PanelValeurs2 Pane= new PanelValeurs2(parDataGraph, parFile, this, parPanelGT);
		setContentPane(Pane);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (1000,400); setVisible(true); setLocation(200,300);
	}

	public static void main(String[] args, DataGraph data, File file, PanelGraphTab panelGT) {
		new FenetreSaisie1("Saisie",data,file, panelGT);
	}

}
