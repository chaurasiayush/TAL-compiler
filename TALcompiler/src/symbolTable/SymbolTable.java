/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;

import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author ayush
 */
public class SymbolTable {
    public static HashMap<String,STData> stable = new HashMap();
    
    public void include(STData d)throws Exception{
        if(!stable.containsKey(d.name)){
            stable.put(d.name, d);
        }
        else
            System.out.println("variable \""+d.name+"\" is already declaired");
    }
    
}
