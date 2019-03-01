package Controleur;

import java.io.*;

import Modele.DataGraph;

/**
 * <b>Sauvegarde permet de stocker le DataGraph dans un fichier</b>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class Sauvegarde {
	
	/**
     * Lit le fichier de sauvegarde
     * 
     * @param parFichier
     * @return objetLu
     */
	public static Object lecture(File parFichier)
	{
		ObjectInputStream flux;
		Object objetLu = null;
		
		try{
			flux = new ObjectInputStream(new FileInputStream(parFichier));
			objetLu = (Object)flux.readObject();
			flux.close();
		}
		
		catch(ClassNotFoundException parException)
		{
			System.err.println(parException.toString());
			System.exit(1);
		}
		
		catch(IOException parException)
		{
			System.err.println("Erreur lecture du fichier" + parException.toString());
			System.exit(1);
		}
		return objetLu;
	}
	
	/**
     * Ecrit le fichier de sauvegarde
     * 
     * @param parFichier
     * @param parObjet
     */
	public static void ecriture(File parFichier,Object parObjet)
	{
		ObjectOutputStream flux = null;
		
		try{
			flux = new ObjectOutputStream(new FileOutputStream(parFichier));
			flux.writeObject(parObjet);
			flux.flush();
			flux.close();
		}
		
		catch(IOException parException)
		{
			System.err.println("Problème à l'écriture\n" + parException.toString());
			System.exit(1);
		}
	}
}