/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;

import lexicalAnalyzer.Identifier;
import lexicalAnalyzer.IdentifierSpecial;
import lexicalAnalyzer.Tag;

/**
 *
 * @author ayush
 */
public class STData {
    
    //public int srPointer;
    public String name;
    public int size;
    public String type;
    public int lineOfDeclairation;
    
    public STData(Identifier i, int lod){
        
        //this.srPointer = pnt;
        this.name = i.value;
        this.type = i.tag;
        this.lineOfDeclairation = lod;
        
        if(i.tag == Tag.INT_NO)
            this.size = Integer.SIZE;
        else if(i.tag == Tag.FLOAT_NO){
            this.size = Float.SIZE;
        }
    }
    
    public STData(IdentifierSpecial i, int lod){
        
        //this.srPointer = pnt;
        this.name = i.value;
        this.type = i.tag;
        this.lineOfDeclairation = lod;
       
    }
}
