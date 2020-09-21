
package risk_;

import java.util.ArrayList;
import java.util.Collections;


public class Country {
    
    private int soldiers;
    private int newSoldiers;
    private int attacker;
    private int defender;

    public Country(int soldiers, int newSoldiers) {
        this.soldiers = soldiers;
        this.newSoldiers = newSoldiers;
    }
    
    public void reinforcments(){
        if(soldiers>=newSoldiers){
            soldiers+=newSoldiers;
        }
    }
    
    public void attack(Country country){
        System.out.println("Saját támadók: "+attackerNumber(this)+" ellenfélé: "+attackerNumber(country));
        System.out.println("Saját védekezők: "+defenderNumber(this)+" ellenfélé: "+defenderNumber(country));
        
        ArrayList<Integer> diceRollsOwnAttacker =new ArrayList<Integer>();
        ArrayList<Integer> diceRollsOwnDefender =new ArrayList<Integer>();
        ArrayList<Integer> diceRollsEnemyAttacker =new ArrayList<Integer>();
        ArrayList<Integer> diceRollsEnemyDefender =new ArrayList<Integer>();
        
        diceRoll(diceRollsOwnAttacker,attackerNumber(this),1,this);
        //diceRoll(diceRollsOwnDefender,defenderNumber(this),2,this);
        //diceRoll(diceRollsEnemyAttacker,attackerNumber(country),1,country);
        diceRoll(diceRollsEnemyDefender,defenderNumber(country),2,country);
        
        Collections.sort(diceRollsOwnAttacker, Collections.reverseOrder());
        Collections.sort(diceRollsOwnDefender, Collections.reverseOrder());
        Collections.sort(diceRollsEnemyAttacker, Collections.reverseOrder());
        Collections.sort(diceRollsEnemyDefender, Collections.reverseOrder());
        
        System.out.println("");
        System.out.println("Párbaj");
        System.out.println("Saját támadóim: "+attackerNumber(this));
        System.out.println("Ellenség védekezői: "+defenderNumber(country));
        System.out.println("");
        
        duel(diceRollsOwnAttacker,diceRollsEnemyDefender, country);
    }

    public int attackerNumber(Country country){
        if(country.getSoldiers()==3){
            setAttacker(2);
        }
        else if(country.getSoldiers()==2){
            setAttacker(1);
        }
        else if(country.getSoldiers()==1 || country.getSoldiers()==0){
            setAttacker(0);
        }
        else{
            setAttacker(3);
        }
        return getAttacker();
    }
    
    public int defenderNumber(Country country){
        if(country.getSoldiers()>=1 && country.getSoldiers()<=4){
            setDefender(1);
        }
        else if(country.getSoldiers()==0){
            setDefender(0);
        }
        else{
            setDefender(2);
        }
        return getDefender();
    }

    public void diceRoll(ArrayList<Integer> list, int soldiers, int type, Country country){
        int dice=6;
        for (int i = 0; i < soldiers; i++) {
            list.add((int)(Math.random()*dice)+1);
            if(type==1 && country.equals(this)){
                System.out.println((i+1)+". Saját támadó dobása: "+list.get(i));
            }
            else if(type==1 && country.equals(country)){
                System.out.println((i+1)+". Ellenfél támadó dobása: "+list.get(i));
            }
            else if(type==2 && country.equals(this)){
                System.out.println((i+1)+". Saját védekező dobása: "+list.get(i));
            }
            else{
                System.out.println((i+1)+". Ellenfél védekező dobása: "+list.get(i));
            }
    }
    }
        
    public void duel(ArrayList<Integer> attacker, ArrayList<Integer> defender, Country country){
        for (int i = 0; i < attacker.size(); i++) {
                for (int j = 0; j < defender.size(); j++) {
                    if(attacker.get(i)>defender.get(j)){
                       country.setSoldiers(country.getSoldiers()-1);
                       System.out.println("Az enyém nyert, a katonáim: "+this.getSoldiers()+" Az ellenség katonái: "+country.getSoldiers());
                    }
                    else if(attacker.get(i)==defender.get(j)){
                       this.setSoldiers(this.getSoldiers()-1);
                       System.out.println("Az övé nyert, a katonáim: "+this.getSoldiers()+" Az ellenség katonái: "+country.getSoldiers());
                    }
                    else{
                       this.setSoldiers(this.getSoldiers()-1);
                       System.out.println("Az övé nyert, a katonáim: "+this.getSoldiers()+" Az ellenség katonái: "+country.getSoldiers());
                    }
                }
                break;
        }
    }
    public int getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(int soldiers) {
        this.soldiers = soldiers;
    }

    public int getAttacker() {
        return attacker;
    }

    public void setAttacker(int attacker) {
        this.attacker = attacker;
    }

    public int getDefender() {
        return defender;
    }

    public void setDefender(int defender) {
        this.defender = defender;
    }
}
