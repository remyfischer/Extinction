/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extinction;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author remyf
 */
public class Extinction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Initialisation de menaces et d'espèces
        
        Scanner sc = new Scanner(System.in);
        int reponse = 0;
        
        Menace deforestation = new Menace("déforestation");
        Menace surpeche = new Menace("sur-pêche");
        Menace pesticide = new Menace("pesticide");
        Menace pollution = new Menace("pollution");
        
        Espece espece1 = new Espece("Orang-outan", 1000, deforestation, "vertébré", "mammifère");
        Espece espece2 = new Espece("Abeille", 100000, pesticide, "invertébré", "insecte");
        Espece espece3 = new Espece("Homo sapiens sapiens", 700000000, pollution, "vertébré", "mammifère");
        
        espece1.ajoutMenace(pollution);
        
        ArrayList<Espece> listeEspece = new ArrayList();
        
        listeEspece.add(espece1);
        listeEspece.add(espece2);
        listeEspece.add(espece3);
        
        do{
            
        
            System.out.println("---- Menu d'accueil ----");
            System.out.println("1 - Menu Menace");
            System.out.println("2 - Menu espèce");
            System.out.println("3 - Menu extinction");
            System.out.println("5 - Quitter");



            do{

                reponse = sc.nextInt();

            } while(reponse != 1 && reponse != 2 && reponse != 3 && reponse != 5);

            if(reponse == 1){



            }
        
        } while (reponse != 5);
        
        
        
        extinction_menace_date(espece1, deforestation, 10, 2050);
        reset(espece1, espece2, espece3);
        extinction_menace(espece2, pesticide, 10);
        reset(espece1, espece2, espece3);
        extinction_menace_date_liste(listeEspece, pollution, 10, 2050);
        reset(espece1, espece2, espece3);
        
    }
    
    public static void extinction_menace_date(Espece _espece, Menace _menace, int _pourcentageMenace, int _annee){
        
        boolean menace = false;
        double coefficientMenace = (100.0-_pourcentageMenace)/100.0;
        double nombreIndividus;
        
        for(int i = 0 ; i < _espece.getListeMenace().size() ; i++){
            
            if(_espece.getListeMenace().get(i).equals(_menace)) menace = true;
            
        }
        
        if(menace == true){
            
            for(int i = 2018 ; i <= _annee ; i++){
                
                _espece.setNbIndividu(_espece.getNbIndividu()*coefficientMenace);               
                
                
            }
            
            if(_espece.getNbIndividu() < 50){
                
                System.out.println(_espece.getNom()+" sera en éteint en "+_annee+".");
                
            } else {
                
                System.out.println(_espece.getNom()+" ne sera pas éteint en "+_annee+" il restera "+_espece.getNbIndividu()+" individus.");
                
            }
            
        } else {
            
            System.out.println("Espèce non concernée par cette menace");
            
        }
        
        
        
    }
    
    public static void extinction_menace(Espece _espece, Menace _menace, int _pourcentageMenace){
        
        boolean menace = false;
        double coefficientMenace = (100.0-_pourcentageMenace)/100.0;
        int annee = 2018;
        
        for(int i = 0 ; i < _espece.getListeMenace().size() ; i++){
            
            if(_espece.getListeMenace().get(i).equals(_menace)) menace = true;
            
        }
        
        if(menace == true){
            
            do{
                
                annee++;
                _espece.setNbIndividu(_espece.getNbIndividu()*coefficientMenace);
                
            } while(_espece.getNbIndividu() >= 50);
            
                
            System.out.println(_espece.getNom()+" sera en éteint en "+annee+".");                
            
            
        } else {
            
            System.out.println("Espèce non concernée par cette menace");
            
        }
        
        
        
    }
    
    public static void extinction_menace_date_liste(ArrayList<Espece> _listeEspece, Menace _menace, int _pourcentageMenace, int _annee){
        
        double coefficientMenace = (100.0-_pourcentageMenace)/100.0;
        boolean menace;
        
        for(int i = 0 ; i < _listeEspece.size() ; i++){
            
            menace = false;
            
            for(int j = 0 ; j < _listeEspece.get(i).getListeMenace().size() ; j++){
                
                if(_listeEspece.get(i).getListeMenace().get(j).equals(_menace)) menace = true;
                
            }
            
            if(menace == true){
                
                for(int j = 2018 ; j <= _annee ; j++){
                
                    _listeEspece.get(i).setNbIndividu(_listeEspece.get(i).getNbIndividu()*coefficientMenace);
                
                }
                
                
            }
            
        }
        
        for(int i = 0 ; i < _listeEspece.size() ; i++){
            
            if(_listeEspece.get(i).getNbIndividu() < 50) System.out.println(_listeEspece.get(i).getNom()+" sera éteint en "+_annee+".");
            
        }      
    
    }
    
    // fonction de reset pour réinitialiser les valeurs pour les trois espèces
    public static void reset(Espece _espece1, Espece _espece2, Espece _espece3){
        
        _espece1.setNbIndividu(1000);
        _espece2.setNbIndividu(100000);
        _espece3.setNbIndividu(700000000);
        
    }
    
}
