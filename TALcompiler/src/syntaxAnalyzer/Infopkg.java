/*

--------------------------------
 TALcompiler project           
--------------------------------
 Developed by-   
  * Abhishek Kumar Singh          
  * Anish Shrivastav                
  * Ayush Chaurasia    
--------------------------------

 */
package syntaxAnalyzer;

/**
 *
 * @author ayush
 */
public class Infopkg {
    
    public int state;
    public int ruleNO;
    public String actionType;
    
    public String terminal;
    public String nterminal;
    
    public Infopkg(){
    
        this.actionType = "NO_ACTION";
        this.nterminal = "-1";
        this.ruleNO = -1;
        this.state = -1;
        this.terminal = "-1";
    }
    
    
    public Infopkg(int state, String actionType){                 //for shift
        
        this.state = state;
        this.actionType  = actionType;
        
    }
    
    public Infopkg(int ruleNO, String actionType, int a){
                                                                             //for reduce
        this.ruleNO = ruleNO;
        this.actionType  = actionType;
        
    }
}
