/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extinction;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author remyf
 */
public class Espece {
    
    private static AtomicInteger genID = new AtomicInteger();
    private final int code;
    private String nom;
    private double nbIndividu;
    private ArrayList<Menace> listeMenace;
    private String regne;
    private String embranchement;
    
    public Espece(){
        
        this.code = genID.getAndIncrement();
        this.nom = "nom";
        this.nbIndividu = 0;
        listeMenace = new ArrayList<>();
        this.regne = "regne";
        this.embranchement = "embranchement";
        
    }
    
    public Espece (String _nom, double _nbIndividu, Menace _menace, String _regne, String _embranchement){
        
        this.code = genID.getAndIncrement();
        this.nom = _nom;
        this.nbIndividu = _nbIndividu;
        listeMenace = new ArrayList<>();
        this.listeMenace.add(_menace);
        this.regne = _regne;
        this.embranchement = _embranchement;
        
    }
    
    public int getCode(){
        
        return code;
        
    }
    
    public String getNom(){
        
        return nom;
        
    }
    
    public double getNbIndividu(){
        
        return nbIndividu; 
        
    }
   

    public ArrayList<Menace> getListeMenace() {
        
        return listeMenace;
        
    }
    
    public String getRegne() {
    
        return regne;
        
    }
    
    public String getEmbranchement() {
    
        return embranchement;
        
    }
    
    public void setNom(String _nom){
        
        this.nom = _nom;
        
    }
    
    public void setNbIndividu(double _nbIndividu){
        
        this.nbIndividu = _nbIndividu;
        
    }

    public void setListeMenace(ArrayList<Menace> listeMenace) {
        
        this.listeMenace = listeMenace;
        
    }


    public void setRegne(String regne) {
        
        this.regne = regne;
        
    }
   

    public void setEmbranchement(String embranchement) {
        
        this.embranchement = embranchement;
        
    }
    
    public void ajoutMenace (Menace _menace){
        
        this.listeMenace.add(_menace);
        
    }
    
    public void suppressionMenace (Menace _menace){
        
        this.listeMenace.remove(_menace);
        
    }
    
    
    
   
    
    
    
    
    
}
