/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalAnalyzer;

/**
 *
 * @author ayush
 */
public class Token {
    
    public String value;
    public String tag;
    
    public Token(){}
    public Token(String tag, String value){
        this.value = value;
        this.tag = tag;
    }
   
    
}
