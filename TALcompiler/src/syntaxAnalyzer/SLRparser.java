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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import lexicalAnalyzer.*;
import lexicalAnalyzer.Token;
import syntaxAnalyzer.parseTable.ActionType;
import syntaxAnalyzer.parseTable.ActionTable;
import syntaxAnalyzer.parseTable.GotoTable;
import talcompiler.TALcompiler;
import errorHandler.Error;

/**
 *
 * @author ayush
 */
public class SLRparser {
    
    ActionTable aTble;
    GotoTable gotoTble;
    HashMap<Integer, Rule> grammar;
    HashSet<String> nonTerminal;
    Token currentToken;
    int errorCount = 0;
    
    LexicalAnalyzer lex = new LexicalAnalyzer();
    Stack<String> stack = new Stack();
    
    
    public SLRparser(ActionTable a, GotoTable gtable, Grammar gm){
       
        this.aTble = a;
        this.gotoTble = gtable;
        this.grammar = gm.grammar;
        this.nonTerminal = gm.nonTerminal;
        stack.push("0");
        this.incrReadPtr();
        
    }
    
    private void incrReadPtr(){
        
        currentToken = lex.getToken();
        if(currentToken.tag == null)
            incrReadPtr();
        else if(currentToken.tag == Tag.BADCHAR)
            Error.exitPrg();
    }
    
    private int peekState(){
        
        try{
            return Integer.parseInt(stack.peek());   
        }
        catch(NumberFormatException e){
            return -1;
        }
    }
    
    
    public boolean parse(){
        
        do{
            int peekState = this.peekState();

            TALcompiler.logWriter.println("STACK CONTENTS: "+stack);
            if(peekState != -1){    
                
                String key = String.valueOf(peekState).concat("."+this.currentToken.tag);
                Infopkg cInfo = new Infopkg();
                
                
                    cInfo =  this.aTble.getAction(key);         
                    TALcompiler.logWriter.println("ACTION PERFORMED: "+cInfo.actionType+" "+((cInfo.ruleNO!=0)? cInfo.ruleNO:cInfo.state));
                    
                if(cInfo.actionType == ActionType.SUGGEST){
                    
                    String expv[] = cInfo.nterminal.split(":");
                    
                        
                    if(expv[1].compareTo(Tag.END) == 0){
                        Error.notAllowed(currentToken, lex.getLine());
                        Error.exitPrg();
                    }
                        
                    Error.syntaxError(expv, currentToken, lex.getLine());
                    Error.exitPrg();
                    //System.exit(1);
                }

                else if(cInfo.actionType == ActionType.ACCEPT){
                    
                    System.out.println("ACCEPTED!!!!");
                    stack.pop();
                    TALcompiler.logWriter.println("STACK AFTER ACTION: "+stack);
                    return true;
                    
                }
                
                else if(cInfo.actionType == ActionType.SHIFT){

                    stack.push(this.currentToken.tag); 
                    stack.push(String.valueOf(cInfo.state));
                    this.incrReadPtr();
                    TALcompiler.logWriter.println("STACK AFTER ACTION: "+stack);

                }
                
                else if(cInfo.actionType == ActionType.REDUCE){
                    
                   
                    Rule rule = this.grammar.get(cInfo.ruleNO);
                    int loop = rule.size;                                                   
                    
                    for(int i=0;i<2*loop;i++)
                        stack.pop();
                    
                    String gotoKey = String.valueOf(this.peekState()).concat("."+rule.nonterminal);
                    
                    int st = this.gotoTble.getGoto(gotoKey);      
                    stack.push(rule.nonterminal);
                    stack.push(String.valueOf(st));
                    TALcompiler.logWriter.println("GOTO STATE:"+st);
                    TALcompiler.logWriter.println("STACK AFTER ACTION: "+stack);
                }
                TALcompiler.logWriter.println();
                TALcompiler.logWriter.println();
                
            } 
        
        }while(true);

    }
}
