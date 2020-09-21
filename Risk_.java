/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk_;

/**
 *
 * @author Patrícia
 */
public class Risk_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Country country=new Country(5,2);
        Country country2=new Country(4,2);
        //country.attack(country2);
        
        War.human_vs_ai(country, country2);
        
        System.out.println("Saját katonák: "+country.getSoldiers());
        System.out.println("Ai katonák: "+country2.getSoldiers());
        
    }
    
}
