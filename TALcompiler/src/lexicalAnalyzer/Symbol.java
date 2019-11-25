/*
 * author Ayush Chaurasia (CSJMA16001390016)
 */
package lexicalAnalyzer;

import lexicalAnalyzer.Token;

public class Symbol
extends Token {
    
    char lexeme;
    public static Symbol OPENBR = new Symbol(Tag.SYMBL_OPBR,"(");
    public static Symbol CLOSEBR = new Symbol(Tag.SYMBL_CLBR, ")");
    public static Symbol OPENCR = new Symbol(Tag.SYMBL_OPCR, "{");
    public static Symbol CLOSECR = new Symbol(Tag.SYMBL_CLCR, "}");
    public static Symbol SEMICLN = new Symbol(Tag.SYMBL_SEMICOLON, ";");
    public static Symbol EOF = new Symbol(Tag.END, "$");

    Symbol(String tag, String value) {
        super(tag, value);
        this.lexeme = value.charAt(0);
    }
}
