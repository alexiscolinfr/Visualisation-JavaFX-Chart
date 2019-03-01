package Vu;

import Modele.DataGraph;
import Modele.ModeleTab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import Controleur.Sauvegarde;

/**
 * <b>PanelValeurs2 permet de completer la troisième partie de DataGraph.</b>
 * <p>
 * Cette classe crée un formulaire qui complète les valeurs de chaques series.
 * Lorsque l'utilisateur clique sur le bouton suivant, les informations sont ajoutées
 * à DataGraph, FenetreSaisie3 se ferme et PanelGraphTab est actualisé avec le nouveau DataGraph
 * </p>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class PanelValeurs2 extends JPanel implements ActionListener {
	
	private JPanel chPanCentre = new JPanel();
	private JPanel chPanNord = new JPanel();
	private JPanel chPanValeur = new JPanel();
	
	private JLabel chAbscisses,chSerie1,chSerie2,chSerie3,chSerie4,chSerie5,chSerie6;
	private JTextField chAbs1,chAbs2,chAbs3,chAbs4,chAbs5,chAbs6,chAbs7,chAbs8,chAbs9,chAbs10;
	private JTextField chTitre11,chTitre12,chTitre13,chTitre14,chTitre15,chTitre16,chTitre17,chTitre18,chTitre19,chTitre110;
	private JTextField chTitre21,chTitre22,chTitre23,chTitre24,chTitre25,chTitre26,chTitre27,chTitre28,chTitre29,chTitre210;
	private JTextField chTitre31,chTitre32,chTitre33,chTitre34,chTitre35,chTitre36,chTitre37,chTitre38,chTitre39,chTitre310;
	private JTextField chTitre41,chTitre42,chTitre43,chTitre44,chTitre45,chTitre46,chTitre47,chTitre48,chTitre49,chTitre410;
	private JTextField chTitre51,chTitre52,chTitre53,chTitre54,chTitre55,chTitre56,chTitre57,chTitre58,chTitre59,chTitre510;
	private JTextField chTitre61,chTitre62,chTitre63,chTitre64,chTitre65,chTitre66,chTitre67,chTitre68,chTitre69,chTitre610;
	
	private JButton chButtonSuivant = new JButton("Suivant");
	
	private DataGraph data;
	private File file;
	private FenetreSaisie3 fenetre3;
	private PanelGraphTab panelGT;
	
	/**
     * Constructeur PanelValeurs2.
     * 
     * @param parDataGraph
     * @param parFile
     * @param parFentre3
     * @param parPanelGT
     */
	public PanelValeurs2(DataGraph parDataGraph, File parFile, FenetreSaisie3 parFenetre3, PanelGraphTab parPanelGT){
		
		data = parDataGraph;
		file = parFile;
		fenetre3 = parFenetre3;
		panelGT = parPanelGT;
		
		setLayout(new BorderLayout(10,10));
		add(chPanCentre, BorderLayout.CENTER);
		add(chPanNord, BorderLayout.NORTH);
		
		// ---------- chPanNord ----------
		chPanNord.add(new JLabel("Entrez les valeurs des series"));
		chPanNord.setLayout(new FlowLayout(FlowLayout.CENTER,40,20)); // afin de centrer le JLabel précédent
		chPanNord.setBackground(new Color(194,194,194));
		
		// ---------- chPanCentre ----------
		chPanCentre.setLayout(new FlowLayout(FlowLayout.CENTER,40,20));
		chPanValeur.setLayout(new GridLayout(0,data.getNbrE()+1));
		
		chPanCentre.add(chPanValeur);
		int compteur = 0;
		for (int i=0 ; i<data.getNbrS()+1 ; i++)
		{
			if (compteur == 0){
				int compteur2 = 0;
				chAbscisses = new JLabel(data.getTitreX());
				chPanValeur.add(chAbscisses);
				for (int j=0 ; j<data.getNbrE() ; j++){
					if (compteur2 == 0){
						chAbs1 = new JTextField(5);
						chPanValeur.add(chAbs1);
					}
					if (compteur2 == 1){
						chAbs2 = new JTextField(5);
						chPanValeur.add(chAbs2);
					}
					if (compteur2 == 2){
						chAbs3 = new JTextField(5);
						chPanValeur.add(chAbs3);
					}
					if (compteur2 == 3){
						chAbs4 = new JTextField(5);
						chPanValeur.add(chAbs4);
					}
					if (compteur2 == 4){
						chAbs5 = new JTextField(5);
						chPanValeur.add(chAbs5);
					}
					if (compteur2 == 5){
						chAbs6 = new JTextField(5);
						chPanValeur.add(chAbs6);
					}
					if (compteur2 == 6){
						chAbs7 = new JTextField(5);
						chPanValeur.add(chAbs7);
					}
					if (compteur2 == 7){
						chAbs8 = new JTextField(5);
						chPanValeur.add(chAbs8);
					}
					if (compteur2 == 8){
						chAbs9 = new JTextField(5);
						chPanValeur.add(chAbs9);
					}
					if (compteur2 == 9){
						chAbs10 = new JTextField(5);
						chPanValeur.add(chAbs10);
					}
					compteur2++;
				}
			}
			
			if (compteur == 1){
				int compteur2 = 0;
				chSerie1 = new JLabel(data.getTitreS(0));
				chPanValeur.add(chSerie1);
				for (int j=0 ; j<data.getNbrE() ; j++){
					if (compteur2 == 0){
						chTitre11 = new JTextField(5);
						chPanValeur.add(chTitre11);
					}
					if (compteur2 == 1){
						chTitre12 = new JTextField(5);
						chPanValeur.add(chTitre12);
					}
					if (compteur2 == 2){
						chTitre13 = new JTextField(5);
						chPanValeur.add(chTitre13);
					}
					if (compteur2 == 3){
						chTitre14 = new JTextField(5);
						chPanValeur.add(chTitre14);
					}
					if (compteur2 == 4){
						chTitre15 = new JTextField(5);
						chPanValeur.add(chTitre15);
					}
					if (compteur2 == 5){
						chTitre16 = new JTextField(5);
						chPanValeur.add(chTitre16);
					}
					if (compteur2 == 6){
						chTitre17 = new JTextField(5);
						chPanValeur.add(chTitre17);
					}
					if (compteur2 == 7){
						chTitre18 = new JTextField(5);
						chPanValeur.add(chTitre18);
					}
					if (compteur2 == 8){
						chTitre19 = new JTextField(5);
						chPanValeur.add(chTitre19);
					}
					if (compteur2 == 9){
						chTitre110 = new JTextField(5);
						chPanValeur.add(chTitre110);
					}
					compteur2++;
				}
			}
			
			if (compteur == 2){
				int compteur2 = 0;
				chSerie2 = new JLabel(data.getTitreS(1));
				chPanValeur.add(chSerie2);
				for (int j=0 ; j<data.getNbrE() ; j++){
					if (compteur2 == 0){
						chTitre21 = new JTextField(5);
						chPanValeur.add(chTitre21);
					}
					if (compteur2 == 1){
						chTitre22 = new JTextField(5);
						chPanValeur.add(chTitre22);
					}
					if (compteur2 == 2){
						chTitre23 = new JTextField(5);
						chPanValeur.add(chTitre23);
					}
					if (compteur2 == 3){
						chTitre24 = new JTextField(5);
						chPanValeur.add(chTitre24);
					}
					if (compteur2 == 4){
						chTitre25 = new JTextField(5);
						chPanValeur.add(chTitre25);
					}
					if (compteur2 == 5){
						chTitre26 = new JTextField(5);
						chPanValeur.add(chTitre26);
					}
					if (compteur2 == 6){
						chTitre27 = new JTextField(5);
						chPanValeur.add(chTitre27);
					}
					if (compteur2 == 7){
						chTitre28 = new JTextField(5);
						chPanValeur.add(chTitre28);
					}
					if (compteur2 == 8){
						chTitre29 = new JTextField(5);
						chPanValeur.add(chTitre29);
					}
					if (compteur2 == 9){
						chTitre210 = new JTextField(5);
						chPanValeur.add(chTitre210);
					}
					compteur2++;
				}
			}
			
			if (compteur == 3){
				int compteur2 = 0;
				chSerie3 = new JLabel(data.getTitreS(2));
				chPanValeur.add(chSerie3);
				for (int j=0 ; j<data.getNbrE() ; j++){
					if (compteur2 == 0){
						chTitre31 = new JTextField(5);
						chPanValeur.add(chTitre31);
					}
					if (compteur2 == 1){
						chTitre32 = new JTextField(5);
						chPanValeur.add(chTitre32);
					}
					if (compteur2 == 2){
						chTitre33 = new JTextField(5);
						chPanValeur.add(chTitre33);
					}
					if (compteur2 == 3){
						chTitre34 = new JTextField(5);
						chPanValeur.add(chTitre34);
					}
					if (compteur2 == 4){
						chTitre35 = new JTextField(5);
						chPanValeur.add(chTitre35);
					}
					if (compteur2 == 5){
						chTitre36 = new JTextField(5);
						chPanValeur.add(chTitre36);
					}
					if (compteur2 == 6){
						chTitre37 = new JTextField(5);
						chPanValeur.add(chTitre37);
					}
					if (compteur2 == 7){
						chTitre38 = new JTextField(5);
						chPanValeur.add(chTitre38);
					}
					if (compteur2 == 8){
						chTitre39 = new JTextField(5);
						chPanValeur.add(chTitre39);
					}
					if (compteur2 == 9){
						chTitre310 = new JTextField(5);
						chPanValeur.add(chTitre310);
					}
					compteur2++;
				}
			}
			if (compteur == 4){
				int compteur2 = 0;
				chSerie4 = new JLabel(data.getTitreS(3));
				chPanValeur.add(chSerie4);
				for (int j=0 ; j<data.getNbrE() ; j++){
					if (compteur2 == 0){
						chTitre41 = new JTextField(5);
						chPanValeur.add(chTitre41);
					}
					if (compteur2 == 1){
						chTitre42 = new JTextField(5);
						chPanValeur.add(chTitre42);
					}
					if (compteur2 == 2){
						chTitre43 = new JTextField(5);
						chPanValeur.add(chTitre43);
					}
					if (compteur2 == 3){
						chTitre44 = new JTextField(5);
						chPanValeur.add(chTitre44);
					}
					if (compteur2 == 4){
						chTitre45 = new JTextField(5);
						chPanValeur.add(chTitre45);
					}
					if (compteur2 == 5){
						chTitre46 = new JTextField(5);
						chPanValeur.add(chTitre46);
					}
					if (compteur2 == 6){
						chTitre47 = new JTextField(5);
						chPanValeur.add(chTitre47);
					}
					if (compteur2 == 7){
						chTitre48 = new JTextField(5);
						chPanValeur.add(chTitre48);
					}
					if (compteur2 == 8){
						chTitre49 = new JTextField(5);
						chPanValeur.add(chTitre49);
					}
					if (compteur2 == 9){
						chTitre410 = new JTextField(5);
						chPanValeur.add(chTitre410);
					}
					compteur2++;
				}
			}
			
			if (compteur == 5){
				int compteur2 = 0;
				chSerie5 = new JLabel(data.getTitreS(4));
				chPanValeur.add(chSerie5);
				for (int j=0 ; j<data.getNbrE() ; j++){
					if (compteur2 == 0){
						chTitre51 = new JTextField(5);
						chPanValeur.add(chTitre51);
					}
					if (compteur2 == 1){
						chTitre52 = new JTextField(5);
						chPanValeur.add(chTitre52);
					}
					if (compteur2 == 2){
						chTitre53 = new JTextField(5);
						chPanValeur.add(chTitre53);
					}
					if (compteur2 == 3){
						chTitre54 = new JTextField(5);
						chPanValeur.add(chTitre54);
					}
					if (compteur2 == 4){
						chTitre55 = new JTextField(5);
						chPanValeur.add(chTitre55);
					}
					if (compteur2 == 5){
						chTitre56 = new JTextField(5);
						chPanValeur.add(chTitre56);
					}
					if (compteur2 == 6){
						chTitre57 = new JTextField(5);
						chPanValeur.add(chTitre57);
					}
					if (compteur2 == 7){
						chTitre58 = new JTextField(5);
						chPanValeur.add(chTitre58);
					}
					if (compteur2 == 8){
						chTitre59 = new JTextField(5);
						chPanValeur.add(chTitre59);
					}
					if (compteur2 == 9){
						chTitre510 = new JTextField(5);
						chPanValeur.add(chTitre510);
					}
					compteur2++;
				}
			}
			
			if (compteur == 6){
				int compteur2 = 0;
				chSerie6 = new JLabel(data.getTitreS(5));
				chPanValeur.add(chSerie6);
				for (int j=0 ; j<data.getNbrE() ; j++){
					if (compteur2 == 0){
						chTitre61 = new JTextField(5);
						chPanValeur.add(chTitre61);
					}
					if (compteur2 == 1){
						chTitre62 = new JTextField(5);
						chPanValeur.add(chTitre62);
					}
					if (compteur2 == 2){
						chTitre63 = new JTextField(5);
						chPanValeur.add(chTitre63);
					}
					if (compteur2 == 3){
						chTitre64 = new JTextField(5);
						chPanValeur.add(chTitre64);
					}
					if (compteur2 == 4){
						chTitre65 = new JTextField(5);
						chPanValeur.add(chTitre65);
					}
					if (compteur2 == 5){
						chTitre66 = new JTextField(5);
						chPanValeur.add(chTitre66);
					}
					if (compteur2 == 6){
						chTitre67 = new JTextField(5);
						chPanValeur.add(chTitre67);
					}
					if (compteur2 == 7){
						chTitre68 = new JTextField(5);
						chPanValeur.add(chTitre68);
					}
					if (compteur2 == 8){
						chTitre69 = new JTextField(5);
						chPanValeur.add(chTitre69);
					}
					if (compteur2 == 9){
						chTitre610 = new JTextField(5);
						chPanValeur.add(chTitre610);
					}
					compteur2++;
				}
			}
			compteur++;
		}
		
		chPanValeur.add(chButtonSuivant);
		chButtonSuivant.addActionListener(this);
			
	}
	
	public void actionPerformed (ActionEvent parEvt){
		if (parEvt.getSource() == chButtonSuivant){
			int compteur = 0;
			for (int i=0 ; i<data.getNbrS()+1 ; i++)
			{
				if (compteur == 0){
					int compteur2 = 0;
					for (int j=0 ; j<data.getNbrE() ; j++){
						if (compteur2 == 0){
							data.setAbscisse(Integer.parseInt(chAbs1.getText()));
						}
						if (compteur2 == 1){
							data.setAbscisse(Integer.parseInt(chAbs2.getText()));
						}
						if (compteur2 == 2){
							data.setAbscisse(Integer.parseInt(chAbs3.getText()));
						}
						if (compteur2 == 3){
							data.setAbscisse(Integer.parseInt(chAbs4.getText()));
						}
						if (compteur2 == 4){
							data.setAbscisse(Integer.parseInt(chAbs5.getText()));
						}
						if (compteur2 == 5){
							data.setAbscisse(Integer.parseInt(chAbs6.getText()));
						}
						if (compteur2 == 6){
							data.setAbscisse(Integer.parseInt(chAbs7.getText()));
						}
						if (compteur2 == 7){
							data.setAbscisse(Integer.parseInt(chAbs8.getText()));
						}
						if (compteur2 == 8){
							data.setAbscisse(Integer.parseInt(chAbs9.getText()));
						}
						if (compteur2 == 9){
							data.setAbscisse(Integer.parseInt(chAbs10.getText()));
						}
						compteur2++;
					}
				}
				
				if (compteur == 1){
					int compteur2 = 0;
					for (int j=0 ; j<data.getNbrE() ; j++){
						if (compteur2 == 0){
							data.setElement(1,Integer.parseInt(chTitre11.getText()));
						}
						if (compteur2 == 1){
							data.setElement(1,Integer.parseInt(chTitre12.getText()));
						}
						if (compteur2 == 2){
							data.setElement(1,Integer.parseInt(chTitre13.getText()));
						}
						if (compteur2 == 3){
							data.setElement(1,Integer.parseInt(chTitre14.getText()));
						}
						if (compteur2 == 4){
							data.setElement(1,Integer.parseInt(chTitre15.getText()));
						}
						if (compteur2 == 5){
							data.setElement(1,Integer.parseInt(chTitre16.getText()));
						}
						if (compteur2 == 6){
							data.setElement(1,Integer.parseInt(chTitre17.getText()));
						}
						if (compteur2 == 7){
							data.setElement(1,Integer.parseInt(chTitre18.getText()));
						}
						if (compteur2 == 8){
							data.setElement(1,Integer.parseInt(chTitre19.getText()));
						}
						if (compteur2 == 9){
							data.setElement(1,Integer.parseInt(chTitre110.getText()));
						}
						compteur2++;
					}
				}
				
				if (compteur == 2){
					int compteur2 = 0;
					chSerie2 = new JLabel(data.getTitreS(1));
					chPanValeur.add(chSerie2);
					for (int j=0 ; j<data.getNbrE() ; j++){
						if (compteur2 == 0){
							data.setElement(2,Integer.parseInt(chTitre21.getText()));
						}
						if (compteur2 == 1){
							data.setElement(2,Integer.parseInt(chTitre22.getText()));
						}
						if (compteur2 == 2){
							data.setElement(2,Integer.parseInt(chTitre23.getText()));
						}
						if (compteur2 == 3){
							data.setElement(2,Integer.parseInt(chTitre24.getText()));
						}
						if (compteur2 == 4){
							data.setElement(2,Integer.parseInt(chTitre25.getText()));
						}
						if (compteur2 == 5){
							data.setElement(2,Integer.parseInt(chTitre26.getText()));
						}
						if (compteur2 == 6){
							data.setElement(2,Integer.parseInt(chTitre27.getText()));
						}
						if (compteur2 == 7){
							data.setElement(2,Integer.parseInt(chTitre28.getText()));
						}
						if (compteur2 == 8){
							data.setElement(2,Integer.parseInt(chTitre29.getText()));
						}
						if (compteur2 == 9){
							data.setElement(2,Integer.parseInt(chTitre210.getText()));
						}
						compteur2++;
					}
				}
				
				if (compteur == 3){
					int compteur2 = 0;
					chSerie3 = new JLabel(data.getTitreS(2));
					chPanValeur.add(chSerie3);
					for (int j=0 ; j<data.getNbrE() ; j++){
						if (compteur2 == 0){
							data.setElement(3,Integer.parseInt(chTitre31.getText()));
						}
						if (compteur2 == 1){
							data.setElement(3,Integer.parseInt(chTitre32.getText()));
						}
						if (compteur2 == 2){
							data.setElement(3,Integer.parseInt(chTitre33.getText()));
						}
						if (compteur2 == 3){
							data.setElement(3,Integer.parseInt(chTitre34.getText()));
						}
						if (compteur2 == 4){
							data.setElement(3,Integer.parseInt(chTitre35.getText()));
						}
						if (compteur2 == 5){
							data.setElement(3,Integer.parseInt(chTitre36.getText()));
						}
						if (compteur2 == 6){
							data.setElement(3,Integer.parseInt(chTitre37.getText()));
						}
						if (compteur2 == 7){
							data.setElement(3,Integer.parseInt(chTitre38.getText()));
						}
						if (compteur2 == 8){
							data.setElement(3,Integer.parseInt(chTitre39.getText()));
						}
						if (compteur2 == 9){
							data.setElement(3,Integer.parseInt(chTitre310.getText()));
						}
						compteur2++;
					}
				}
				if (compteur == 4){
					int compteur2 = 0;
					chSerie4 = new JLabel(data.getTitreS(3));
					chPanValeur.add(chSerie4);
					for (int j=0 ; j<data.getNbrE() ; j++){
						if (compteur2 == 0){
							data.setElement(4,Integer.parseInt(chTitre41.getText()));
						}
						if (compteur2 == 1){
							data.setElement(4,Integer.parseInt(chTitre42.getText()));
						}
						if (compteur2 == 2){
							data.setElement(4,Integer.parseInt(chTitre43.getText()));
						}
						if (compteur2 == 3){
							data.setElement(4,Integer.parseInt(chTitre44.getText()));
						}
						if (compteur2 == 4){
							data.setElement(4,Integer.parseInt(chTitre45.getText()));
						}
						if (compteur2 == 5){
							data.setElement(4,Integer.parseInt(chTitre46.getText()));
						}
						if (compteur2 == 6){
							data.setElement(4,Integer.parseInt(chTitre47.getText()));
						}
						if (compteur2 == 7){
							data.setElement(4,Integer.parseInt(chTitre48.getText()));
						}
						if (compteur2 == 8){
							data.setElement(4,Integer.parseInt(chTitre49.getText()));
						}
						if (compteur2 == 9){
							data.setElement(4,Integer.parseInt(chTitre410.getText()));
						}
						compteur2++;
					}
				}
				
				if (compteur == 5){
					int compteur2 = 0;
					chSerie5 = new JLabel(data.getTitreS(4));
					chPanValeur.add(chSerie5);
					for (int j=0 ; j<data.getNbrE() ; j++){
						if (compteur2 == 0){
							data.setElement(5,Integer.parseInt(chTitre51.getText()));
						}
						if (compteur2 == 1){
							data.setElement(5,Integer.parseInt(chTitre52.getText()));
						}
						if (compteur2 == 2){
							data.setElement(5,Integer.parseInt(chTitre53.getText()));
						}
						if (compteur2 == 3){
							data.setElement(5,Integer.parseInt(chTitre54.getText()));
						}
						if (compteur2 == 4){
							data.setElement(5,Integer.parseInt(chTitre55.getText()));
						}
						if (compteur2 == 5){
							data.setElement(5,Integer.parseInt(chTitre56.getText()));
						}
						if (compteur2 == 6){
							data.setElement(5,Integer.parseInt(chTitre57.getText()));
						}
						if (compteur2 == 7){
							data.setElement(5,Integer.parseInt(chTitre58.getText()));
						}
						if (compteur2 == 8){
							data.setElement(5,Integer.parseInt(chTitre59.getText()));
						}
						if (compteur2 == 9){
							data.setElement(5,Integer.parseInt(chTitre510.getText()));
						}
						compteur2++;
					}
				}
				
				if (compteur == 6){
					int compteur2 = 0;
					chSerie6 = new JLabel(data.getTitreS(5));
					chPanValeur.add(chSerie6);
					for (int j=0 ; j<data.getNbrE() ; j++){
						if (compteur2 == 0){
							data.setElement(6,Integer.parseInt(chTitre61.getText()));
						}
						if (compteur2 == 1){
							data.setElement(6,Integer.parseInt(chTitre62.getText()));
						}
						if (compteur2 == 2){
							data.setElement(6,Integer.parseInt(chTitre63.getText()));
						}
						if (compteur2 == 3){
							data.setElement(6,Integer.parseInt(chTitre64.getText()));
						}
						if (compteur2 == 4){
							data.setElement(6,Integer.parseInt(chTitre65.getText()));
						}
						if (compteur2 == 5){
							data.setElement(6,Integer.parseInt(chTitre66.getText()));
						}
						if (compteur2 == 6){
							data.setElement(6,Integer.parseInt(chTitre67.getText()));
						}
						if (compteur2 == 7){
							data.setElement(6,Integer.parseInt(chTitre68.getText()));
						}
						if (compteur2 == 8){
							data.setElement(6,Integer.parseInt(chTitre69.getText()));
						}
						if (compteur2 == 9){
							data.setElement(6,Integer.parseInt(chTitre610.getText()));
						}
						compteur2++;
					}
				}
				compteur++;
			}
		}
	panelGT.viderDataGraph();
	panelGT.initFX(data);
	panelGT.setModel(new ModeleTab(data));
	Sauvegarde.ecriture(file, data);
	fenetre3.dispose();
	}
}
