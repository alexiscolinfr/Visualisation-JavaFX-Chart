package Vu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

import Controleur.Sauvegarde;
import Modele.DataGraph;

/**
 * <b>FenetreMere est la classe qui instancie PanelFils</b>
 * <p>
 * Cette classe créer la JFame principal de l'application avec son menu.
 * </p>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class FenetreMere {
	
	private static JMenuBar menuBar = new JMenuBar();
	
	private static JMenu saisie = new JMenu("Saisie");
	private static JMenu visualisation = new JMenu("Visualisation");
	//private static JMenu quitter = new JMenu("Quitter");
	
	private static ButtonGroup btn = new ButtonGroup();
	
	private static JRadioButtonMenuItem graphAires  = new JRadioButtonMenuItem("Aires");
	private static JRadioButtonMenuItem graphBarres = new JRadioButtonMenuItem("Barres");
	private static JRadioButtonMenuItem graphBulles = new JRadioButtonMenuItem("Bulles");
	private static JRadioButtonMenuItem graphCourbes = new JRadioButtonMenuItem("Courbes");
	
	private static JMenuItem itemQuitter = new JMenuItem("Quitter");
	private static JMenuItem itemOuvrir = new JMenuItem("Ouvrir");
	private static JMenuItem itemNouveau = new JMenuItem("Nouveau");
	private static DataGraph chDataGraph;
	private static int tampon = 1;
	
	/**
     * Permet d'afficher le JFXPanel dans une JFrame
     * 
     * @param parDataGraph
     * @param parFile
     * @param parPanelGT
     */
	private static void initAndShowGUI(DataGraph parDataGraph, File parFile, PanelGraphTab parPanelGT) { // This method is invoked on the EDT thread 
		chDataGraph = parDataGraph;
		JFrame frame = new JFrame("Visualisation de données avec JavaFX"); 
		frame.setContentPane(new PanelFils(chDataGraph, parFile, parPanelGT)); 
		frame.setSize(1100, 480); 
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.add(graphCourbes);
		btn.add(graphBarres);
		btn.add(graphBulles);
		btn.add(graphAires);
		
		visualisation.add(graphCourbes);
		visualisation.add(graphBarres);
		visualisation.add(graphBulles);
		visualisation.add(graphAires);
		
		saisie.add(itemOuvrir);
		saisie.add(itemNouveau);
		
		graphCourbes.setSelected(true);
		
		menuBar.add(saisie);
		menuBar.add(visualisation);
		menuBar.add(itemQuitter);
		
		itemQuitter.addActionListener(new ActionListener() {
			public void actionPerformed( 
					ActionEvent arg0) { System.exit(0); 
			} } );
		itemOuvrir.addActionListener(new ActionListener() { 
			public void actionPerformed( ActionEvent arg0) {  
				try { FenetreSelect ouvrir = new FenetreSelect(parPanelGT, parFile);
				}
				catch (IOException e) {
					e.printStackTrace();
			}} } );
		itemNouveau.addActionListener(new ActionListener() { 
			public void actionPerformed( ActionEvent arg0) { 
				parPanelGT.viderDataGraph();
				FenetreSaisie1 fenetre1 = new FenetreSaisie1("Saisie 1", new DataGraph(), parFile, parPanelGT);
			} } );
		frame.setJMenuBar(menuBar);
		
		
		graphCourbes.addActionListener(new ActionListener() { 
			public void actionPerformed( ActionEvent arg0) { 
				tampon = 1;
				parPanelGT.setType(tampon);
				parPanelGT.initFX((DataGraph)Sauvegarde.lecture(parFile));
		} } );
		graphBarres.addActionListener(new ActionListener() { 
			public void actionPerformed( ActionEvent arg0) { 
				tampon = 2;
				parPanelGT.setType(tampon);
				parPanelGT.initFX((DataGraph)Sauvegarde.lecture(parFile));
			} } );
		graphBulles.addActionListener(new ActionListener() { 
			public void actionPerformed( ActionEvent arg0) { 
				tampon = 3;
				parPanelGT.setType(tampon);
				parPanelGT.initFX((DataGraph)Sauvegarde.lecture(parFile));
			} } );
		graphAires.addActionListener(new ActionListener() { 
			public void actionPerformed( ActionEvent arg0) { 
				tampon = 4;
				parPanelGT.setType(tampon);
				parPanelGT.initFX((DataGraph)Sauvegarde.lecture(parFile));
			} } );
	}
	
	public static void main(String[] args) {
		File file = new File("Data_Nom_Fichier");
		DataGraph dataGraph =(DataGraph)Sauvegarde.lecture(file);
		//DataGraph dataGraph = new DataGraph();
		PanelGraphTab panelGT = new PanelGraphTab(dataGraph,file);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initAndShowGUI(dataGraph, file, panelGT);
			} 
		});
	}
}
