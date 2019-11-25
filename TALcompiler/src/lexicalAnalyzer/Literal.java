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
public class Literal extends Token{
    
    Literal(String value){
        super(Tag.LTRL, value);
    }
}
