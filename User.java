
package game;


/*zero is O 
one is x

*/

public class User {
    public String input;
    public int input1;
    
    public User(){}
    
    public User(int choice){
        input1 = choice;
        decide(choice);
    
    }
    public void decide(int opt){
        if(opt == 0){
            input = "O";
        }else{
            input ="X";
        
        }
    }
    
    
}
