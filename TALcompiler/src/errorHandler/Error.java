/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorHandler;

import java.io.IOException;
import static java.lang.Math.exp;
import lexicalAnalyzer.Token;
import static talcompiler.TALcompiler.orig;

/**
 *
 * @author ayush
 */
public class Error {
    
    public static int i;
    
    public static void exitPrg(){
       
        System.setIn(orig);
        System.out.print("\n\n\nPRESS ANY KEY TO EXIT.....");
        try{
            System.in.read();
            System.exit(0);
        }catch(Exception e){
            System.out.println(e.toString());
            System.exit(0);
        }
    }
        
    
    public static void SyntaxError(int l){
        System.out.println("Syntax Error at Line : \""+l+"\"");
    }
    
    public static void notAllowed(Token tk, int l){
        System.out.println("SYNTAX ERROR: NOTHING IS ALLOWED AFTER END OF PARENTHESES (ie. '}') BUT FOUND \""+tk.tag+"\" AT LINE: \""+l+"\"");
    }
    
    public static void lexicalErrorBadID(String id,int line){
        System.out.println("LEXICAL ERROR: FOUND BAD IDENTIFIER \""+id+"\" AT LINE : "+line);
    }
        
    
    public static void lexicalErrorBadChar(char id,int line){
        System.out.println("LEXICAL ERROR: FOUND BAD CHAR \""+id+"\" AT LINE : "+line);
    }
    
    
    public static void syntaxError(String expected[], Token currentToken ,int lineNo){
        
        System.out.print("SYNTAX ERROR: THERE IS AN ERROR NEAR LINE NO "+lineNo+", EXPECTED "); 
                    for(int i = 0; i< expected.length ; i++){
                        
                        if(expected[i].length()>0 &&i!=expected.length-1)
                            System.out.print("'"+expected[i]+"' OR ");
                        else if(i == expected.length-1)
                            System.out.print("'"+expected[i]+"' ");
                        
                    }
                    System.out.println("BUT FOUND '"+currentToken.tag+"'.");
    }
    
}
