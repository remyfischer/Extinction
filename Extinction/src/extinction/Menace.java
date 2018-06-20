/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extinction;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author remyf
 */
public class Menace {
    
    private static AtomicInteger genID = new AtomicInteger();
    private final int code;
    private String libelle;
    
    public Menace(){
        
        this.code = genID.getAndIncrement();
        this.libelle = "menace indéterminée";
        
    }
    
    public Menace(String _libelle){
        
        this.code = genID.getAndIncrement();
        this.libelle = _libelle;
        
    }

    public int getCode() {
        
        return code;
        
    }


    public String getLibelle() {
        
        return libelle;
        
    }

    public void setLibelle(String _libelle) {
        
        this.libelle = _libelle;
        
    }
    
    
    
}
