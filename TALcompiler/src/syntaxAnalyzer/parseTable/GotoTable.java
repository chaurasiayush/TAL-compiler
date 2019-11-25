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
package syntaxAnalyzer.parseTable;

import java.util.HashMap;
import syntaxAnalyzer.Infopkg;

/**
 *
 * @author ayush
 */
public class GotoTable {
    
    HashMap<String,Integer> gototable = new HashMap();
    
    public static final GotoTable GT1 = new GotoTable();
    
    public int getGoto(String key){
        
        int gotostate = gototable.get(key);
        return gotostate;
        
    }
    static{
        
        
        GT1.gototable.put(String.valueOf(37).concat("."+NonTerminal.A), 48);
        GT1.gototable.put(String.valueOf(38).concat("."+NonTerminal.A), 51);
        GT1.gototable.put(String.valueOf(4).concat("."+NonTerminal.B), 5);
        GT1.gototable.put(String.valueOf(6).concat("."+NonTerminal.D), 8);
        GT1.gototable.put(String.valueOf(11).concat("."+NonTerminal.D), 8);
        GT1.gototable.put(String.valueOf(6).concat("."+NonTerminal.E), 9);
        GT1.gototable.put(String.valueOf(11).concat("."+NonTerminal.E), 9);
        GT1.gototable.put(String.valueOf(6).concat("."+NonTerminal.F), 10);
        GT1.gototable.put(String.valueOf(7).concat("."+NonTerminal.F), 10);
        GT1.gototable.put(String.valueOf(11).concat("."+NonTerminal.F), 10);
        GT1.gototable.put(String.valueOf(25).concat("."+NonTerminal.F), 10);
        GT1.gototable.put(String.valueOf(29).concat("."+NonTerminal.F), 42);
        GT1.gototable.put(String.valueOf(30).concat("."+NonTerminal.F), 43);
        GT1.gototable.put(String.valueOf(32).concat("."+NonTerminal.F), 10);
        GT1.gototable.put(String.valueOf(33).concat("."+NonTerminal.F), 10);
        GT1.gototable.put(String.valueOf(36).concat("."+NonTerminal.F), 10);
        GT1.gototable.put(String.valueOf(37).concat("."+NonTerminal.F), 10);
        GT1.gototable.put(String.valueOf(38).concat("."+NonTerminal.F), 10);
        GT1.gototable.put(String.valueOf(6).concat("."+NonTerminal.G), 11);
        GT1.gototable.put(String.valueOf(11).concat("."+NonTerminal.G), 11);
        GT1.gototable.put(String.valueOf(6).concat("."+NonTerminal.P), 12);
        GT1.gototable.put(String.valueOf(11).concat("."+NonTerminal.P), 12);
        GT1.gototable.put(String.valueOf(8).concat("."+NonTerminal.R), 24);
        GT1.gototable.put(String.valueOf(9).concat("."+NonTerminal.R), 26);
        GT1.gototable.put(String.valueOf(12).concat("."+NonTerminal.R), 28);
        GT1.gototable.put(String.valueOf(0).concat("."+NonTerminal.S), 1);
        GT1.gototable.put(String.valueOf(6).concat("."+NonTerminal.T), 13);
        GT1.gototable.put(String.valueOf(7).concat("."+NonTerminal.T), 13);
        GT1.gototable.put(String.valueOf(11).concat("."+NonTerminal.T), 13);
        GT1.gototable.put(String.valueOf(25).concat("."+NonTerminal.T), 13);
        GT1.gototable.put(String.valueOf(32).concat("."+NonTerminal.T), 44);
        GT1.gototable.put(String.valueOf(33).concat("."+NonTerminal.T), 45);
        GT1.gototable.put(String.valueOf(36).concat("."+NonTerminal.T), 13);
        GT1.gototable.put(String.valueOf(37).concat("."+NonTerminal.T), 13);
        GT1.gototable.put(String.valueOf(38).concat("."+NonTerminal.T), 13);
        GT1.gototable.put(String.valueOf(6).concat("."+NonTerminal.Y), 14);
        GT1.gototable.put(String.valueOf(11).concat("."+NonTerminal.Y), 27);
        GT1.gototable.put(String.valueOf(6).concat("."+NonTerminal.Z), 15);
        GT1.gototable.put(String.valueOf(7).concat("."+NonTerminal.Z), 22);
        GT1.gototable.put(String.valueOf(11).concat("."+NonTerminal.Z), 15);
        GT1.gototable.put(String.valueOf(25).concat("."+NonTerminal.Z), 41);
        GT1.gototable.put(String.valueOf(36).concat("."+NonTerminal.Z), 47);
        GT1.gototable.put(String.valueOf(37).concat("."+NonTerminal.Z), 49);
        GT1.gototable.put(String.valueOf(38).concat("."+NonTerminal.Z), 49);


    }
    
}