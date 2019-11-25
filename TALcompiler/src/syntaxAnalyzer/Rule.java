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

import syntaxAnalyzer.parseTable.NonTerminal;

/**
 *
 * @author ayush
 */
class Rule{
    
    public int size;
    public String nonterminal;
    
    public static Rule R0, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13,
            R14, R15, R16, R17, R18, R19, R20, R21, R22, R23, R24, R25, R26, R27, R28;
    
    public Rule(int sz, String nt){
        
        this.size = sz;
        this.nonterminal = nt;
        
    }
    
    static{
        R0 = new Rule(1,NonTerminal.START);
        
        R1 = new Rule(4,NonTerminal.S);
        
        R2 = new Rule(3,NonTerminal.B);
        
        R3 = new Rule(0,NonTerminal.Y);
        R4 = new Rule(2,NonTerminal.Y);
        
        R5 = new Rule(2,NonTerminal.G);
        R6 = new Rule(2,NonTerminal.G);
        R7 = new Rule(2,NonTerminal.G);
        
        R8 = new Rule(3,NonTerminal.D);
        
        R9 = new Rule(4,NonTerminal.E);
        R10 = new Rule(2,NonTerminal.E);
        
        R11 = new Rule(3,NonTerminal.Z);
        R12 = new Rule(3,NonTerminal.Z);
        R13 = new Rule(1,NonTerminal.Z);
        
        R14 = new Rule(3,NonTerminal.T);
        R15 = new Rule(3,NonTerminal.T);
        R16 = new Rule(1,NonTerminal.T);
        
        R17 = new Rule(3,NonTerminal.F);
        R18 = new Rule(1,NonTerminal.F);
        R19 = new Rule(1,NonTerminal.F);
        R20 = new Rule(1,NonTerminal.F);
        
        R21 = new Rule(5,NonTerminal.P);
        R22 = new Rule(5,NonTerminal.P);
        
        R23 = new Rule(1,NonTerminal.A);
        R24 = new Rule(1,NonTerminal.A);
        R25 = new Rule(1,NonTerminal.A);
        
        R26 = new Rule(3,NonTerminal.R);
        R27 = new Rule(2,NonTerminal.R);
        R28 = new Rule(0,NonTerminal.R);
        //R5 = new Rule(1,NonTerminal.R);
//        R1 = new Rule(4,NonTerminal);
//        R1 = new Rule(4,NonTerminal);

    }
}