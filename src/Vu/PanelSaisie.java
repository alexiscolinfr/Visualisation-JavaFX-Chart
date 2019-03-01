package Vu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import Modele.DataGraph;

/**
 * <b>PanelSaisie permet de completer la première partie de DataGraph.</b>
 * <p>
 * Cette classe crée un formulaire qui complète les champs suivants:
 * <ul>
 * <li>Titre du graphe</li>
 * <li>Titre des abscisses</li>
 * <li>Titre des ordonnées</li>
 * <li>Nombre de series</li>
 * <li>Nombre d'éléments par series</li>
 * </ul>
 * Lorsque l'utilisateur clique sur le bouton suivant, les informations sont ajoutées
 * à DataGraph, FentreSaisie2 s'ouvre et FenetreSaisie1 se ferme
 * </p>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class PanelSaisie extends JPanel implements ActionListener{
	
	// JTextArea
	private JTextField chTextTitre = new JTextField(12);
	private JTextField chTextAbscisseTitre = new JTextField(12);
	private JTextField chTextOrdonneeTitre = new JTextField(12);
	
	// JLabel
	private JLabel chLabTitre = new JLabel("Titre");
	private JLabel chLabAbscisseTitre = new JLabel("Titre Abscisse");
	private JLabel chLabOrdonneeTitre = new JLabel("Titre Ordonnee");
	private JLabel chLabNbrSeries = new JLabel("Nombre de séries");
	private JLabel chLabNbrValeur = new JLabel("Nombre de valeurs");
	
	// JComboBox
	private JComboBox chChoixNbrSeries = new JComboBox();
	private JComboBox chChoixNbrValeurs = new JComboBox();
	
	// JButton
	private JButton chButtonSuivant = new JButton("Suivant");
	
	// JPanel
	JPanel chPanCentre = new JPanel();
	JPanel chPanNord = new JPanel();
	
	int chIndexSeries = 0;
	int chIndexValeurs = 0;
	String chTitre;
	String chAbscisseTitre;
	String chOrdonneeTitre;
	
	// Paramètres
	private DataGraph dataGraph;
	private File file;
	private FenetreSaisie1 fenetre1;
	private PanelGraphTab panelGT;
	
	/**
     * Constructeur PanelSaisie.
     * 
     * @param parDataGraph
     * @param parFile
     * @param parFentre1
     * @param parPanelGT
     */
	public PanelSaisie(DataGraph parDataGraph, File parFile, FenetreSaisie1 parFenetre1, PanelGraphTab parPanelGT){
		
		// Disposition des panels
		setLayout(new BorderLayout(10,10));
		add(chPanCentre, BorderLayout.CENTER);
		add(chPanNord, BorderLayout.NORTH);
		
		// ---------- chPanNord ----------
		
		chPanNord.add(new JLabel("Complétez les champs suivants: "));
		chPanNord.setLayout(new FlowLayout(FlowLayout.CENTER,40,20)); // afin de centrer le JLabel précédent
		chPanNord.setBackground(new Color(194,194,194));
		
		// ---------- chPanCentre ----------
		
		// JComboBox
		for(int i=1; i<7; i++){
			String str = Integer.toString(i);
			if (i<10)
				str = "0"+str;
			chChoixNbrSeries.addItem(str);
			
		}
		
		for(int i=1; i<11; i++){
			String str = Integer.toString(i);
			if (i<10)
				str = "0"+str;
			chChoixNbrValeurs.addItem(str);
			
		}
		
		// Général
		GridBagConstraints ctt = new GridBagConstraints();
		chPanCentre.setLayout(new GridBagLayout());
		
		dataGraph = parDataGraph;
		file = parFile;
		fenetre1 = parFenetre1;
		panelGT = parPanelGT;
		
		ctt.fill = GridBagConstraints.BOTH;
		
		ctt.insets = new Insets(2,2,2,2);
		
		// chTextTitre
		ctt.gridx = 0;
		ctt.gridy = 0;
		ctt.gridwidth = 5;
		ctt.gridheight=1;
		chPanCentre.add(chTextTitre, ctt);
		
		// chLabTitre
		ctt.gridx = 9;
		ctt.gridy = 0;
		ctt.gridwidth = 5;
		ctt.gridheight=1;
		chPanCentre.add(chLabTitre, ctt);
		
		// chTextAbscisseTitre
		ctt.gridx = 0;
		ctt.gridy = 1;
		ctt.gridwidth = 5;
		ctt.gridheight=1;
		chPanCentre.add(chTextAbscisseTitre, ctt);
		
		// chLabAbscisseTitre
		ctt.gridx = 9;
		ctt.gridy = 1;
		ctt.gridwidth = 5;
		ctt.gridheight=1;
		chPanCentre.add(chLabAbscisseTitre, ctt);
		
		// chTextOrdonneeTitre
		ctt.gridx = 0;
		ctt.gridy = 2;
		ctt.gridwidth = 5;
		ctt.gridheight=1;
		chPanCentre.add(chTextOrdonneeTitre, ctt);
		
		// chLabOrdonneeTitre
		ctt.gridx = 9;
		ctt.gridy = 2;
		ctt.gridwidth = 5;
		ctt.gridheight=1;
		chPanCentre.add(chLabOrdonneeTitre, ctt);
		
		// chChoixNbrSeries
		ctt.gridx = 0;
		ctt.gridy = 3;
		ctt.gridwidth = 5;
		ctt.gridheight=1;
		chPanCentre.add(chChoixNbrSeries, ctt);
		
		// chLabNbrSeries
		ctt.gridx = 9;
		ctt.gridy = 3;
		ctt.gridwidth = 5;
		ctt.gridheight=1;
		chPanCentre.add(chLabNbrSeries, ctt);
		
		// chChoixNbrValeur
		ctt.gridx = 0;
		ctt.gridy = 4;
		ctt.gridwidth = 5;
		ctt.gridheight=1;
		chPanCentre.add(chChoixNbrValeurs, ctt);
		
		// chLabNbrValeur
		ctt.gridx = 9;
		ctt.gridy = 4;
		ctt.gridwidth = 5;
		ctt.gridheight=1;
		chPanCentre.add(chLabNbrValeur, ctt);
		
		// chButtonValidation
		ctt.gridx = 0;
		ctt.gridy = 5;
		ctt.gridwidth = 5;
		ctt.gridheight=1;
		chPanCentre.add(chButtonSuivant, ctt);
		chButtonSuivant.addActionListener(this);

	}
	public void actionPerformed (ActionEvent parEvt){
		if (parEvt.getSource() == chButtonSuivant){
			chIndexSeries = Integer.parseInt((String) chChoixNbrSeries.getSelectedItem());
			chIndexValeurs = Integer.parseInt((String) chChoixNbrValeurs.getSelectedItem());
			int compteur =chIndexSeries;
			chTitre = chTextTitre.getText();
			chAbscisseTitre = chTextAbscisseTitre.getText();
			chOrdonneeTitre = chTextOrdonneeTitre.getText();
			
			dataGraph.setTitre(chTitre);
			dataGraph.setTitreX(chAbscisseTitre);
			dataGraph.setTitreY(chOrdonneeTitre);
			dataGraph.setNbrS(chIndexSeries);
			dataGraph.setNbrE(chIndexValeurs);
			FenetreSaisie2 fenetre2 = new FenetreSaisie2("Saisie2",dataGraph,file,panelGT);
			fenetre1.dispose();
		}
	}
}
