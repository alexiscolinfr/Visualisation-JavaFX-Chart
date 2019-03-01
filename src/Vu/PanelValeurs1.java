package Vu;

import Modele.DataGraph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/**
 * <b>PanelValeurs1 permet de completer la deuxième partie de DataGraph.</b>
 * <p>
 * Cette classe crée un formulaire qui complète les noms des series.
 * Lorsque l'utilisateur clique sur le bouton suivant, les informations sont ajoutées
 * à DataGraph, FentreSaisie3 s'ouvre et FenetreSaisie2 se ferme
 * </p>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class PanelValeurs1 extends JPanel implements ActionListener {
	
	private JPanel chPanCentre = new JPanel();
	private JPanel chPanNord = new JPanel();
	private JPanel chPanValeur = new JPanel();
	
	private JLabel chSerie1,chSerie2,chSerie3,chSerie4,chSerie5,chSerie6;
	private JTextField chTitreSerie1,chTitreSerie2,chTitreSerie3,chTitreSerie4,chTitreSerie5,chTitreSerie6;
	
	private JButton chButtonSuivant = new JButton("Suivant");
	
	private DataGraph data;
	private File file;
	private FenetreSaisie2 fenetre2;
	private PanelGraphTab panelGT;
	
	/**
     * Constructeur PanelValeurs1.
     * 
     * @param parDataGraph
     * @param parFile
     * @param parFentre2
     * @param parPanelGT
     */
	public PanelValeurs1(DataGraph parDataGraph, File parFile, FenetreSaisie2 parFenetre2, PanelGraphTab parPanelGT){
		
		data = parDataGraph;
		file = parFile;
		fenetre2 = parFenetre2;
		panelGT = parPanelGT;
		
		setLayout(new BorderLayout(10,10));
		add(chPanCentre, BorderLayout.CENTER);
		add(chPanNord, BorderLayout.NORTH);
		
		// ---------- chPanNord ----------
		
		chPanNord.add(new JLabel("Entrez les noms des series: "));
		chPanNord.setLayout(new FlowLayout(FlowLayout.CENTER,40,20)); // afin de centrer le JLabel précédent
		chPanNord.setBackground(new Color(194,194,194));
		
		// ---------- chPanCentre ----------
		chPanCentre.setLayout(new FlowLayout(FlowLayout.CENTER,40,20));
		chPanValeur.setLayout(new GridLayout(data.getNbrS()+1,2));
		
		chPanCentre.add(chPanValeur);
		int compteur = 0;
		for (int i=0 ; i<data.getNbrS() ; i++)
		{
			if (compteur == 0){
				chSerie1 = new JLabel("Serie 1 : ");
				chTitreSerie1 = new JTextField(10);
				chPanValeur.add(chSerie1);
				chPanValeur.add(chTitreSerie1);
			}
			
			if (compteur == 1){
				chSerie2 = new JLabel("Serie 2 : ");
				chTitreSerie2 = new JTextField(10);
				chPanValeur.add(chSerie2);
				chPanValeur.add(chTitreSerie2);
			}
			
			if (compteur == 2){
				chSerie3 = new JLabel("Serie 3 : ");
				chTitreSerie3 = new JTextField(10);
				chPanValeur.add(chSerie3);
				chPanValeur.add(chTitreSerie3);
			}
			if (compteur == 3){
				chSerie4 = new JLabel("Serie 4 : ");
				chTitreSerie4 = new JTextField(10);
				chPanValeur.add(chSerie4);
				chPanValeur.add(chTitreSerie4);
			}
			
			if (compteur == 4){
				chSerie5 = new JLabel("Serie 5 : ");
				chTitreSerie5 = new JTextField(10);
				chPanValeur.add(chSerie5);
				chPanValeur.add(chTitreSerie5);
			}
			
			if (compteur == 5){
				chSerie6 = new JLabel("Serie 6 : ");
				chTitreSerie6 = new JTextField(10);
				chPanValeur.add(chSerie6);
				chPanValeur.add(chTitreSerie6);
			}
			compteur++;
		}
		chPanValeur.add(chButtonSuivant);
		chButtonSuivant.addActionListener(this);
			
	}
	
	public void actionPerformed (ActionEvent parEvt){
		if (parEvt.getSource() == chButtonSuivant){
			int compteur = 0;
			for (int i=0 ; i<data.getNbrS() ; i++)
			{
				if (compteur == 0){
					data.setNomSerie(0, chTitreSerie1.getText());
				}
				
				if (compteur == 1){
					data.setNomSerie(1, chTitreSerie2.getText());
				}
				
				if (compteur == 2){
					data.setNomSerie(2, chTitreSerie3.getText());
				}
				if (compteur == 3){
					data.setNomSerie(3, chTitreSerie4.getText());
				}
				
				if (compteur == 4){
					data.setNomSerie(4, chTitreSerie5.getText());
				}
				
				if (compteur == 5){
					data.setNomSerie(5, chTitreSerie6.getText());
				}
				compteur++;
			}
		}
	FenetreSaisie3 fenetre3 = new FenetreSaisie3("Saisie 3", data, file, panelGT);
	fenetre2.dispose();
	}
}