
package risk_;

import javax.swing.JOptionPane;


public class War {

    public static void human_vs_ai(Country player, Country ai){
        
        int answer=0;

        while(player.getSoldiers()>1 && ai.getSoldiers()>0){
        answer = JOptionPane.showConfirmDialog(null, "Akarsz támadni?");
        if(answer==0 && ai.getSoldiers()>0){
            player.attack(ai);
        }
        else if(answer==1){
            while(player.getSoldiers()>0 && ai.getSoldiers()>1){
                ai.attack(player);
            }
            break;
        }
        else{
            System.out.println("Kilépett");
            break;
        }
        }
    }

}
    
    

