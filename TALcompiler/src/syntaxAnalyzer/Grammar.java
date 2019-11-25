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
import syntaxAnalyzer.parseTable.NonTerminal;

/**
 *
 * @author ayush
 */
public class Grammar {
    
    public HashMap<Integer, Rule> grammar = new HashMap();
    public HashSet<String> nonTerminal = new HashSet();
    public static Grammar G1;
    

    static{
       
        G1 = new Grammar();
        G1.grammar.put(0,Rule.R0);
        G1.grammar.put(1,Rule.R1);
        G1.grammar.put(2,Rule.R2);
        G1.grammar.put(3,Rule.R3);
        G1.grammar.put(4,Rule.R4);
        G1.grammar.put(5,Rule.R5);
        G1.grammar.put(6,Rule.R6);
        G1.grammar.put(7,Rule.R7);
        G1.grammar.put(8,Rule.R8);
        G1.grammar.put(9,Rule.R9);
        G1.grammar.put(10,Rule.R10);
        G1.grammar.put(11,Rule.R11);
        G1.grammar.put(12,Rule.R12);
        G1.grammar.put(13,Rule.R13);
        G1.grammar.put(14,Rule.R14);
        G1.grammar.put(15,Rule.R15);
        G1.grammar.put(16,Rule.R16);
        G1.grammar.put(17,Rule.R17);
        G1.grammar.put(18,Rule.R18);
        G1.grammar.put(19,Rule.R19);
        G1.grammar.put(20,Rule.R20);
        G1.grammar.put(21,Rule.R21);
        G1.grammar.put(22,Rule.R22);
        G1.grammar.put(23,Rule.R23);
        G1.grammar.put(24,Rule.R24);
        G1.grammar.put(25,Rule.R25);
        G1.grammar.put(26,Rule.R26);
        G1.grammar.put(27,Rule.R27);
        G1.grammar.put(28,Rule.R28);
        
        
        G1.nonTerminal.add(NonTerminal.START);
        G1.nonTerminal.add(NonTerminal.B);
        G1.nonTerminal.add(NonTerminal.Y);
        G1.nonTerminal.add(NonTerminal.G);
        G1.nonTerminal.add(NonTerminal.D);
        G1.nonTerminal.add(NonTerminal.E);
        G1.nonTerminal.add(NonTerminal.Z);
        G1.nonTerminal.add(NonTerminal.T);
        G1.nonTerminal.add(NonTerminal.F);
        G1.nonTerminal.add(NonTerminal.P);
        G1.nonTerminal.add(NonTerminal.A);
        G1.nonTerminal.add(NonTerminal.R);
       // G1.nonTerminal.add(NonTerminal);
            
        
    }
        
        
       
}
    


