package Vu;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import Controleur.Sauvegarde;
import Modele.DataGraph;
import Modele.ModeleTab;

/**
 * <b>FenetreSelect permet de s�l�ctionner un fichier � ouvrir.</b>
 * <p>
 * Cette classe ouvre une fen�tre de s�l�ction de fichiers.
 * Lorsque le fichier est s�l�ctionner, le graphique et le tableau sont actualis�s.
 * </p>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class FenetreSelect extends JFrame{
	
	/**
     * Constructeur FenetreSelect.
     * 
     * @param parFile
     * @param parPanelGT
     */
	public FenetreSelect(PanelGraphTab parPanelGT, File parFile) throws IOException 
	{
		JFileChooser dialogue = new JFileChooser(new File("."));
		File fichier;
		
		if (dialogue.showOpenDialog(null)== 
		    JFileChooser.APPROVE_OPTION) {
			fichier = new File(dialogue.getSelectedFile().getAbsolutePath());
			fichier.createNewFile();
			DataGraph dataGraph =(DataGraph)Sauvegarde.lecture(fichier);
			
			parPanelGT.viderDataGraph();
			parPanelGT.initFX(dataGraph);
			parPanelGT.setModel(new ModeleTab(dataGraph));
			Sauvegarde.ecriture(parFile, dataGraph);
		}
	}

	public static void main(String[] args,PanelGraphTab parPanelGT, File parFile) throws IOException {
		new FenetreSelect(parPanelGT, parFile);
	}
}
