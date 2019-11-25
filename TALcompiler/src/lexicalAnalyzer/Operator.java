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
public class Operator extends Token{
    
    Operator(String tag, String value){
        super(tag,value);
    }
    
    public static Operator PLUS = new Operator(Tag.OP_PLUS, "+");
    public static Operator EQUAL = new Operator(Tag.OP_EQ, "==");
    public static Operator ASGN = new Operator(Tag.OP_ASGN, "=");
    public static Operator MINUS = new Operator(Tag.OP_MINUS, "-");
    public static Operator DEVIDE = new Operator(Tag.OP_DEVIDE, "/");
    public static Operator MULTIPLY = new Operator(Tag.OP_MULTIPLY, "*");
}
