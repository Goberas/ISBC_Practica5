/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 15-mar-2012, 20:36:25
 */

package GUI;

import java.util.ArrayList;
import java.util.Iterator;

import es.ucm.fdi.gaia.ontobridge.OntoBridge;
import es.ucm.fdi.gaia.ontobridge.OntologyDocument;

/**
 *
 * @author gobo
 */
public class InterfazConsultas extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    public InterfazConsultas() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bConsulta1 = new javax.swing.JButton();
        bConsulta2 = new javax.swing.JButton();
        bConsulta3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bConsulta1.setText("Consulta 1");
        bConsulta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lanzaConsulta1(evt);
            }
        });

        bConsulta2.setText("Consulta 2");
        bConsulta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lanzaConsulta2(evt);
            }
        });

        bConsulta3.setText("Consulta 3");
        bConsulta3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lanzaConsulta3(evt);
            }
        });

        tResultado.setColumns(20);
        tResultado.setEditable(false);
        tResultado.setRows(5);
        jScrollPane1.setViewportView(tResultado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bConsulta1)
                        .addGap(18, 18, 18)
                        .addComponent(bConsulta2)
                        .addGap(18, 18, 18)
                        .addComponent(bConsulta3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bConsulta1)
                    .addComponent(bConsulta2)
                    .addComponent(bConsulta3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lanzaConsulta1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lanzaConsulta1
        tResultado.setText("Actores que hayan participado en al menos tres peliculas:\n"+masDeTresPeliculas());
        // TODO add your handling code here:
    }//GEN-LAST:event_lanzaConsulta1

    private void lanzaConsulta2(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lanzaConsulta2
        tResultado.setText("Actores que comparten reparto con Javier Bardem:\n"+repartoBardem());
        // TODO add your handling code here:
    }//GEN-LAST:event_lanzaConsulta2

    private void lanzaConsulta3(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lanzaConsulta3        
    	tResultado.setText("Personajes que aparecen alguna serie o pelicula espanyola:\n"+actoresPeliculaEspanola());
    }//GEN-LAST:event_lanzaConsulta3

    private static void inicializaOntobridge(){
    	ob= new OntoBridge();
    	ob.initWithPelletReasoner();
    	
    	OntologyDocument actoresOnto= new OntologyDocument("http://www.owl-ontologies.com/Actores.owl", "file:doc/ontologia/Actores.owl");
    	ob.loadOntology(actoresOnto, new ArrayList<OntologyDocument>(), false);
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    ///// Consultas
    
    private static String masDeTresPeliculas(){
    	String lista = "\n";
    	if(ob.existsClass("Actor")){
    		Iterator<String> it = ob.listInstances("Actor");
    		ArrayList<String> actores = new ArrayList<String>();
    		while(it.hasNext()){
    			actores.add(it.next());
    		}
    		int[] indActor= new int[actores.size()];
    		for(int i=0; i< actores.size();i++)
    			indActor[i]=0;
    		
    		Iterator<String> itPelis = ob.listInstances("Pelicula");
    		ArrayList<String> pelis = new ArrayList<String>();
    		while(itPelis.hasNext())
    			pelis.add(itPelis.next());
    		
    		for(String pelicula : pelis){
    			Iterator<String> itPeli = ob.listPropertyValue(pelicula, "reparto");
    			ArrayList<String> actoresPeli = new ArrayList<String>();
    			while(itPeli.hasNext())
        			actoresPeli.add(itPeli.next());
    			
    			for(String actor:actoresPeli){
    				int i=actores.indexOf(actor);
    				indActor[i]++;
    			}
    		}
    		for(int i=0; i<actores.size();i++)
    			if(indActor[i]>2){
					String nombreActor[]=actores.get(i).split("#");
					lista += nombreActor[1]+"\n";
    			}
    	}
    	
    	return lista;
    		
    }
    
    private static String actoresPeliculaEspanola(){
    	String lista = "\n";
    	if(ob.existsClass("Actores_espanola")){
    		Iterator<String> it = ob.listInstances("Actores_espanola");
    		while(it.hasNext()){
				String nombreActor[]=it.next().split("#");
				lista += nombreActor[1]+"\n";
    		}
    	}
    	return lista;	
    }
    
    private static String repartoBardem(){
    	String lista = "\n";
    	if(ob.existsClass("Comparte_reparto_con_Bardem")){
    		Iterator<String> it = ob.listInstances("Comparte_reparto_con_Bardem");
    		while(it.hasNext()){
    			String actor = "";
    			actor += it.next()+"\n";
    			int n = actor.length();
    			if (!actor.substring(n-7,n).equals("Bardem"+'\n')){
    				String nombreActor[]=actor.split("#");
    				lista += nombreActor[1]+"\n";
    			}
    		}
    	}
    	return lista;	
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
    	inicializaOntobridge();
    	
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazConsultas().setVisible(true);
            }
        });
    }

    private static OntoBridge ob;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConsulta1;
    private javax.swing.JButton bConsulta2;
    private javax.swing.JButton bConsulta3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tResultado;
    // End of variables declaration//GEN-END:variables

}
