package Vu;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Locale.Category;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modele.DataGraph;
import Modele.ModeleTab;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * <b>PanelGraphTab est la classe qui contient le JFXPanel et le tableau.</b>
 * <p>
 * Cette classe crée un JPanel qui contient un JFXPanel.
 * </p>
 * 
 * @author Alexis COLIN & Bastien RENAUDEAU
 * @version 1.0
 */

public class PanelGraphTab extends JPanel{
	Chart chart;
	private Tab table = new Tab();
	private JButton newGraph = new JButton("Créer graphe");
	private JButton openGraph = new JButton("Ouvrir graphe");
	private static DataGraph data;
	private File file;
	private final JFXPanel jfxPanel = new JFXPanel();
	private static int tampon = 1;
	
	/**
     * Constructeur PanelGraphTab.
     * 
     * @param parDataGraph
     * @param parFile
     */
	public PanelGraphTab(DataGraph parDataGraph, File parFile){ 
		
		file = parFile;
		data = parDataGraph;
		
		// ---------- Graph ----------
		
		this.add(jfxPanel);
		Platform.runLater(new Runnable() { 
			@Override 
				public void run() { 
					initFX(data); 
				} 
			});
		
		// ---------- Tab ----------
		
		table.setModel(new ModeleTab(data));
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(550, 10*40));
		this.add(scroll);
		
	}
	
	/**
     * Vide la variable DataGraph.
     * 
     * @see DataGraph
     */
	public void viderDataGraph(){
		data = new DataGraph();
	}
	
	/**
     * Remplace la variable DataGraph.
     * 
     * @param parDataGraph
     * @see DataGraph
     */
	public void setDataGraph(DataGraph parDataGraph){
		data = parDataGraph;
	}
	
	/**
     * Applique les données au tableau.
     * 
     * @param mod
     * @see ModeleTab
     */
	public void setModel(ModeleTab mod)
	{
		table.setModel(mod);
	}
	
	/**
     * Applique les données au graphique.
     * 
     * @param parDataGraph
     * @see DataGraph
     */
	public void initFX(DataGraph parDataGraph) { // This method is invoked on the EDT thread 
		Group root = new Group();
		if (tampon == 1){
			chart = initChartLine(parDataGraph);
		}
		if (tampon == 2){
			chart = initChartBar(parDataGraph);
		}
		if (tampon == 3){
			chart = initChartBubble(parDataGraph);
		}
		if (tampon == 4){
			chart = initChartArea(parDataGraph);
		}
		chart.setLayoutX(0);
		root.getChildren().add(chart); 
		Scene scene = new Scene(root, 500, 400);
		jfxPanel.setScene(scene); 
	}
	
	/**
     * Retourne le type de graphique à afficher.
     * 
     * @param parType
     * @return Type de graphique
     */
	public static int setType(int parType){
		tampon = parType;
		return tampon;
	}

	
	// ---------- Graph ----------
	
	/**
     * Retourne la structure du graphique Area.
     * 
     * @param parDataGraph
     * @see AreaChart
     * @return Chart du graphique Area
     */
	public static Chart initChartArea(DataGraph parDataGraph) {
		int minA = (int) Collections.min(parDataGraph.getListeX());
		int maxA = (int) Collections.max(parDataGraph.getListeX());
		int pasA = (((int) Collections.max(parDataGraph.getListeX())+1)-(int) Collections.min(parDataGraph.getListeX()))/parDataGraph.getNbrE();
		int minO = (int) Collections.min(parDataGraph.getListeY(parDataGraph.getNbrS()));
		int maxO = (int) Collections.max(parDataGraph.getListeY(parDataGraph.getNbrS()));
		int pasO = (((int) Collections.max(parDataGraph.getListeY(parDataGraph.getNbrS()))+1)-(int) Collections.min(parDataGraph.getListeY(parDataGraph.getNbrS())))/parDataGraph.getNbrE();
		final NumberAxis xAxis = new NumberAxis(minA,maxA,pasA );
        final NumberAxis yAxis = new NumberAxis(minO,maxO,pasO);
        
        final AreaChart<Number,Number> c = new AreaChart<Number,Number>(xAxis,yAxis);
        Scene scene  = new Scene(c);
        
        xAxis.setLabel(parDataGraph.getTitreX());
        yAxis.setLabel(parDataGraph.getTitreY());
        c.setTitle(parDataGraph.getTitre());
        
        XYChart.Series series1,series2,series3,series4,series5,series6;
        
        if (parDataGraph.getNbrS()==1){
        	series1 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            }
        	c.getData().addAll(series1);
        }
        
        if (parDataGraph.getNbrS()==2){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            }
        	c.getData().addAll(series1, series2);
        }
        
        if (parDataGraph.getNbrS()==3){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            }
        	c.getData().addAll(series1, series2, series3);
        }
        
        if (parDataGraph.getNbrS()==4){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(4,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4);
        }
        
        if (parDataGraph.getNbrS()==5){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series5 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	series5.setName(parDataGraph.getTitreS(4));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(4,i)));
            	series5.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(5,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4, series5);
        }
        
        if (parDataGraph.getNbrS()==6){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series5 = new XYChart.Series();
        	series6 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	series5.setName(parDataGraph.getTitreS(4));
        	series6.setName(parDataGraph.getTitreS(5));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(4,i)));
            	series5.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(5,i)));
            	series6.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(6,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4, series5, series6);
        }
        
        return c;
	}
	
	/**
     * Retourne la structure du graphique Line.
     * 
     * @param parDataGraph
     * @see LineaChart
     * @return Chart du graphique Line
     */
	public static Chart initChartLine(DataGraph parDataGraph) {
		int minA = (int) Collections.min(parDataGraph.getListeX());
		int maxA = (int) Collections.max(parDataGraph.getListeX());
		int pasA = (((int) Collections.max(parDataGraph.getListeX())+1)-(int) Collections.min(parDataGraph.getListeX()))/parDataGraph.getNbrE();
		int minO = (int) Collections.min(parDataGraph.getListeY(parDataGraph.getNbrS()));
		int maxO = (int) Collections.max(parDataGraph.getListeY(parDataGraph.getNbrS()));
		int pasO = (((int) Collections.max(parDataGraph.getListeY(parDataGraph.getNbrS()))+1)-(int) Collections.min(parDataGraph.getListeY(parDataGraph.getNbrS())))/parDataGraph.getNbrE();
		final NumberAxis xAxis = new NumberAxis(minA,maxA,pasA );
        final NumberAxis yAxis = new NumberAxis(minO,maxO,pasO);
        
        final LineChart<Number,Number> c = new LineChart<Number,Number>(xAxis,yAxis);
        Scene scene  = new Scene(c);
        
        xAxis.setLabel(parDataGraph.getTitreX());
        yAxis.setLabel(parDataGraph.getTitreY());
        c.setTitle(parDataGraph.getTitre());
        
        XYChart.Series series1,series2,series3,series4,series5,series6;
        
        if (parDataGraph.getNbrS()==1){
        	series1 = new XYChart.Series();
        	
        	series1.setName(parDataGraph.getTitreS(0));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            }
        	c.getData().addAll(series1);
        }
        
        if (parDataGraph.getNbrS()==2){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            }
        	c.getData().addAll(series1, series2);
        }
        
        if (parDataGraph.getNbrS()==3){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            }
        	c.getData().addAll(series1, series2, series3);
        }
        
        if (parDataGraph.getNbrS()==4){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(4,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4);
        }
        
        if (parDataGraph.getNbrS()==5){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series5 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	series5.setName(parDataGraph.getTitreS(4));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(4,i)));
            	series5.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(5,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4, series5);
        }
        
        if (parDataGraph.getNbrS()==6){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series5 = new XYChart.Series();
        	series6 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	series5.setName(parDataGraph.getTitreS(4));
        	series6.setName(parDataGraph.getTitreS(5));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(4,i)));
            	series5.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(5,i)));
            	series6.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(6,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4, series5, series6);
        }
        
        return c;
	}
	
	/**
     * Retourne la structure du graphique Bar.
     * 
     * @param parDataGraph
     * @see BarChart
     * @return Chart du graphique Bar
     */
	public static Chart initChartBar(DataGraph parDataGraph) {
		int pasO = (((int) Collections.max(parDataGraph.getListeY(parDataGraph.getNbrS()))+1)-(int) Collections.min(parDataGraph.getListeY(parDataGraph.getNbrS())))/parDataGraph.getNbrE();
		int minO = (int) Collections.min(parDataGraph.getListeY(parDataGraph.getNbrS()))-pasO;
		int maxO = (int) Collections.max(parDataGraph.getListeY(parDataGraph.getNbrS()));
		final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis(minO,maxO,pasO);
        
        final BarChart<String,Number> c = new BarChart<String,Number>(xAxis,yAxis);
        Scene scene  = new Scene(c);
        
        xAxis.setLabel(parDataGraph.getTitreX());
        yAxis.setLabel(parDataGraph.getTitreY());
        c.setTitle(parDataGraph.getTitre());
        
        XYChart.Series series1,series2,series3,series4,series5,series6;
        
        if (parDataGraph.getNbrS()==1){
        	series1 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)),parDataGraph.getElementY(1,i)));
            }
        	c.getData().addAll(series1);
        }
        
        if (parDataGraph.getNbrS()==2){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(2,i)));
            }
        	c.getData().addAll(series1, series2);
        }
        
        if (parDataGraph.getNbrS()==3){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(3,i)));
            }
        	c.getData().addAll(series1, series2, series3);
        }
        
        if (parDataGraph.getNbrS()==4){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(4,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4);
        }
        
        if (parDataGraph.getNbrS()==5){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series5 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	series5.setName(parDataGraph.getTitreS(4));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(4,i)));
            	series5.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(5,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4, series5);
        }
        
        if (parDataGraph.getNbrS()==6){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series5 = new XYChart.Series();
        	series6 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	series5.setName(parDataGraph.getTitreS(4));
        	series6.setName(parDataGraph.getTitreS(5));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(4,i)));
            	series5.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(5,i)));
            	series6.getData().add(new XYChart.Data(Integer.toString(parDataGraph.getAbscisse(i)), parDataGraph.getElementY(6,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4, series5, series6);
        }
        
        return c;
	}
	
	/**
     * Retourne la structure du graphique Bubble.
     * 
     * @param parDataGraph
     * @see BubbleChart
     * @return Chart du graphique bubble
     */
	public static Chart initChartBubble(DataGraph parDataGraph) {
		int minA = (int) Collections.min(parDataGraph.getListeX());
		int maxA = (int) Collections.max(parDataGraph.getListeX());
		int pasA = (((int) Collections.max(parDataGraph.getListeX())+1)-(int) Collections.min(parDataGraph.getListeX()))/parDataGraph.getNbrE();
		int minO = (int) Collections.min(parDataGraph.getListeY(parDataGraph.getNbrS()));
		int maxO = (int) Collections.max(parDataGraph.getListeY(parDataGraph.getNbrS()));
		int pasO = (((int) Collections.max(parDataGraph.getListeY(parDataGraph.getNbrS()))+1)-(int) Collections.min(parDataGraph.getListeY(parDataGraph.getNbrS())))/parDataGraph.getNbrE();
		final NumberAxis xAxis = new NumberAxis(minA-pasA,maxA+pasA,pasA );
        final NumberAxis yAxis = new NumberAxis(minO-pasO,maxO+pasO,pasO);
        
        final BubbleChart<Number,Number> c = new BubbleChart<Number,Number>(xAxis,yAxis);
        Scene scene  = new Scene(c);
        
        xAxis.setLabel(parDataGraph.getTitreX());
        yAxis.setLabel(parDataGraph.getTitreY());
        c.setTitle(parDataGraph.getTitre());
        
        XYChart.Series series1,series2,series3,series4,series5,series6;
        
        if (parDataGraph.getNbrS()==1){
        	series1 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            }
        	c.getData().addAll(series1);
        }
        
        if (parDataGraph.getNbrS()==2){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            }
        	c.getData().addAll(series1, series2);
        }
        
        if (parDataGraph.getNbrS()==3){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            }
        	c.getData().addAll(series1, series2, series3);
        }
        
        if (parDataGraph.getNbrS()==4){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(4,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4);
        }
        
        if (parDataGraph.getNbrS()==5){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series5 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	series5.setName(parDataGraph.getTitreS(4));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(4,i)));
            	series5.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(5,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4, series5);
        }
        
        if (parDataGraph.getNbrS()==6){
        	series1 = new XYChart.Series();
        	series2 = new XYChart.Series();
        	series3 = new XYChart.Series();
        	series4 = new XYChart.Series();
        	series5 = new XYChart.Series();
        	series6 = new XYChart.Series();
        	series1.setName(parDataGraph.getTitreS(0));
        	series2.setName(parDataGraph.getTitreS(1));
        	series3.setName(parDataGraph.getTitreS(2));
        	series4.setName(parDataGraph.getTitreS(3));
        	series5.setName(parDataGraph.getTitreS(4));
        	series6.setName(parDataGraph.getTitreS(5));
        	for (int i=0 ; i<parDataGraph.getNbrE() ; i++){
            	series1.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(1,i)));
            	series2.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(2,i)));
            	series3.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(3,i)));
            	series4.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(4,i)));
            	series5.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(5,i)));
            	series6.getData().add(new XYChart.Data(parDataGraph.getAbscisse(i), parDataGraph.getElementY(6,i)));
            }
        	c.getData().addAll(series1, series2, series3, series4, series5, series6);
        }
        
        return c;
	}
}
