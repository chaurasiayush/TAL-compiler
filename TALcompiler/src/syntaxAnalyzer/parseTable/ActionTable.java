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

//import java.util.;

import java.util.Hashtable;
import lexicalAnalyzer.Tag;
import syntaxAnalyzer.Infopkg;
import talcompiler.TALcompiler;

/**
 *
 * @author ayush
 */
public class ActionTable {
    
    Hashtable<String,Block> atable = new Hashtable();
    
    public static final ActionTable AT1 = new ActionTable();
    
//-----------------------------------------------------------------------------------------------------------------------------------
    
    private String getAllKey(String k){
        
        String s = k.split("\\.")[0];
        //System.out.println("st: "+s);
        
        String allKeys[] = new String[20];
        
        allKeys[0] = s.concat("."+Tag.SYMBL_OPBR);
        allKeys[1] = s.concat("."+Tag.SYMBL_CLBR);
        allKeys[2] = s.concat("."+Tag.OP_MULTIPLY);
        allKeys[3] = s.concat("."+Tag.OP_PLUS);
        allKeys[4] = s.concat("."+Tag.OP_MINUS);
        allKeys[5] = s.concat("."+Tag.OP_DEVIDE);
        allKeys[6] = s.concat("."+Tag.SYMBL_SEMICOLON);
        allKeys[7] = s.concat("."+Tag.OP_ASGN);
        allKeys[8] = s.concat("."+Tag.KW_DATATYPE);
        allKeys[9] = s.concat("."+Tag.IDSP_EXE);
        allKeys[10] = s.concat("."+Tag.FLOAT_NO);
        allKeys[11] = s.concat("."+Tag.ID);
        allKeys[12] = s.concat("."+Tag.LTRL);
        allKeys[13] = s.concat("."+Tag.INT_NO);
        allKeys[14] = s.concat("."+Tag.REPLY);
        allKeys[15] = s.concat("."+Tag.IDSP_SHOW);
        allKeys[16] = s.concat("."+Tag.IDSP_SHOWINE);
        allKeys[17] = s.concat("."+Tag.SYMBL_OPCR);
        allKeys[18] = s.concat("."+Tag.SYMBL_CLCR);
        allKeys[19] = s.concat("."+Tag.END);
        
        String values = "";
        for(String ki:allKeys){
            //SSystem.out.println("KEYs : "+ki); 
            
            try{
                Block kb = atable.get(ki);
                if(kb != null){
                    values = values.concat(":"+ki.split("\\.")[1]);
                    //System.out.println("CORRESPONDING VALUE- "+values+"\n");
                    //System.out.println("KEY RECEIVED AT ACTION TABLE : "+ki+"\nCORRESPONDING VALUE:  intinfo - "+kb.intInfo+"\tactionType - "+kb.actiontype+"\n\n");
                }
            }catch(Exception e){
                System.out.println("KEexcept"); 
            }  
        }
        return values;
    }
    
    
//-----------------------------------------------------------------------------------------------------------------------------------

    public Infopkg getAction(String k){
        
        Block b  = null;
        
        try{
             b = atable.get(k);
        }catch(Exception e){
            System.out.println("KEexcept"); 
        }
        
        Infopkg retInfo = null;
        
        
        if(b != null){
           //System.out.println("KEY RECEIVED AT ACTION TABLE : "+k+"\nCORRESPONDING VALUE:  intinfo - "+b.intInfo+"\tactionType - "+b.actiontype+"\n\n");

            if(b.actiontype == ActionType.SHIFT)
                 retInfo = new Infopkg(b.intInfo,b.actiontype);

            else if(b.actiontype == ActionType.REDUCE)
                retInfo = new Infopkg(b.intInfo,b.actiontype,0);

            else if(b.actiontype == ActionType.ACCEPT){
                retInfo = new Infopkg(0, ActionType.ACCEPT);
            }
        
        }
        else{
            
            retInfo = new Infopkg();
            retInfo.nterminal = this.getAllKey(k);
            retInfo.actionType = ActionType.SUGGEST;
//             retInfo.actionType = ActionType.SUGGEST;
            
//            String ky[] = this.getAllKey(k).trim().split(":");
//            for(String i : ky)
//                System.out.println("Expected: "+i);
            
        }
        
        return retInfo;
        
    }
   
    static{
    
        
                AT1.atable.put(String.valueOf(2).concat("."+Tag.SYMBL_OPBR), new Block(3,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(6).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(7).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(8).concat("."+Tag.SYMBL_OPBR), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(9).concat("."+Tag.SYMBL_OPBR), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(11).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(12).concat("."+Tag.SYMBL_OPBR), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(20).concat("."+Tag.SYMBL_OPBR), new Block(37,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(21).concat("."+Tag.SYMBL_OPBR), new Block(38,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(24).concat("."+Tag.SYMBL_OPBR), new Block(5,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(25).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(26).concat("."+Tag.SYMBL_OPBR), new Block(6,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(28).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(29).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(30).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(32).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(33).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(34).concat("."+Tag.SYMBL_OPBR), new Block(10,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(36).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(37).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(38).concat("."+Tag.SYMBL_OPBR), new Block(7,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(40).concat("."+Tag.SYMBL_OPBR), new Block(27,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(46).concat("."+Tag.SYMBL_OPBR), new Block(8,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(52).concat("."+Tag.SYMBL_OPBR), new Block(26,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(53).concat("."+Tag.SYMBL_OPBR), new Block(9,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(56).concat("."+Tag.SYMBL_OPBR), new Block(21,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(57).concat("."+Tag.SYMBL_OPBR), new Block(22,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(3).concat("."+Tag.SYMBL_CLBR), new Block(4,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(10).concat("."+Tag.SYMBL_CLBR), new Block(16,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(13).concat("."+Tag.SYMBL_CLBR), new Block(13,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(17).concat("."+Tag.SYMBL_CLBR), new Block(20,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(18).concat("."+Tag.SYMBL_CLBR), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(19).concat("."+Tag.SYMBL_CLBR), new Block(19,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(22).concat("."+Tag.SYMBL_CLBR), new Block(39,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(23).concat("."+Tag.SYMBL_CLBR), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(37).concat("."+Tag.SYMBL_CLBR), new Block(25,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(38).concat("."+Tag.SYMBL_CLBR), new Block(25,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(39).concat("."+Tag.SYMBL_CLBR), new Block(17,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(42).concat("."+Tag.SYMBL_CLBR), new Block(14,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(43).concat("."+Tag.SYMBL_CLBR), new Block(15,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(44).concat("."+Tag.SYMBL_CLBR), new Block(11,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(45).concat("."+Tag.SYMBL_CLBR), new Block(12,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(48).concat("."+Tag.SYMBL_CLBR), new Block(54,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(49).concat("."+Tag.SYMBL_CLBR), new Block(23,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(50).concat("."+Tag.SYMBL_CLBR), new Block(24,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(51).concat("."+Tag.SYMBL_CLBR), new Block(55,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(10).concat("."+Tag.OP_MULTIPLY), new Block(16,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(13).concat("."+Tag.OP_MULTIPLY), new Block(29,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(17).concat("."+Tag.OP_MULTIPLY), new Block(20,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(18).concat("."+Tag.OP_MULTIPLY), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(19).concat("."+Tag.OP_MULTIPLY), new Block(19,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(23).concat("."+Tag.OP_MULTIPLY), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(39).concat("."+Tag.OP_MULTIPLY), new Block(17,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(42).concat("."+Tag.OP_MULTIPLY), new Block(14,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(43).concat("."+Tag.OP_MULTIPLY), new Block(15,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(44).concat("."+Tag.OP_MULTIPLY), new Block(29,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(45).concat("."+Tag.OP_MULTIPLY), new Block(29,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(10).concat("."+Tag.OP_PLUS), new Block(16,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(13).concat("."+Tag.OP_PLUS), new Block(13,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(15).concat("."+Tag.OP_PLUS), new Block(32,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(17).concat("."+Tag.OP_PLUS), new Block(20,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(18).concat("."+Tag.OP_PLUS), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(19).concat("."+Tag.OP_PLUS), new Block(19,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(22).concat("."+Tag.OP_PLUS), new Block(32,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(23).concat("."+Tag.OP_PLUS), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(39).concat("."+Tag.OP_PLUS), new Block(17,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(41).concat("."+Tag.OP_PLUS), new Block(32,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(42).concat("."+Tag.OP_PLUS), new Block(14,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(43).concat("."+Tag.OP_PLUS), new Block(15,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(44).concat("."+Tag.OP_PLUS), new Block(11,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(45).concat("."+Tag.OP_PLUS), new Block(12,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(47).concat("."+Tag.OP_PLUS), new Block(32,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(49).concat("."+Tag.OP_PLUS), new Block(32,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(10).concat("."+Tag.OP_MINUS), new Block(16,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(13).concat("."+Tag.OP_MINUS), new Block(13,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(15).concat("."+Tag.OP_MINUS), new Block(33,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(17).concat("."+Tag.OP_MINUS), new Block(20,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(18).concat("."+Tag.OP_MINUS), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(19).concat("."+Tag.OP_MINUS), new Block(19,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(22).concat("."+Tag.OP_MINUS), new Block(33,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(23).concat("."+Tag.OP_MINUS), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(39).concat("."+Tag.OP_MINUS), new Block(17,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(41).concat("."+Tag.OP_MINUS), new Block(33,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(42).concat("."+Tag.OP_MINUS), new Block(14,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(43).concat("."+Tag.OP_MINUS), new Block(15,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(44).concat("."+Tag.OP_MINUS), new Block(11,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(45).concat("."+Tag.OP_MINUS), new Block(12,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(47).concat("."+Tag.OP_MINUS), new Block(33,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(49).concat("."+Tag.OP_MINUS), new Block(33,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(10).concat("."+Tag.OP_DEVIDE), new Block(16,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(13).concat("."+Tag.OP_DEVIDE), new Block(30,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(17).concat("."+Tag.OP_DEVIDE), new Block(20,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(18).concat("."+Tag.OP_DEVIDE), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(19).concat("."+Tag.OP_DEVIDE), new Block(19,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(23).concat("."+Tag.OP_DEVIDE), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(39).concat("."+Tag.OP_DEVIDE), new Block(17,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(42).concat("."+Tag.OP_DEVIDE), new Block(14,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(43).concat("."+Tag.OP_DEVIDE), new Block(15,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(44).concat("."+Tag.OP_DEVIDE), new Block(30,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(45).concat("."+Tag.OP_DEVIDE), new Block(30,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(10).concat("."+Tag.SYMBL_SEMICOLON), new Block(16,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(13).concat("."+Tag.SYMBL_SEMICOLON), new Block(13,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(15).concat("."+Tag.SYMBL_SEMICOLON), new Block(34,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(17).concat("."+Tag.SYMBL_SEMICOLON), new Block(20,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(18).concat("."+Tag.SYMBL_SEMICOLON), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(19).concat("."+Tag.SYMBL_SEMICOLON), new Block(19,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(23).concat("."+Tag.SYMBL_SEMICOLON), new Block(18,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(25).concat("."+Tag.SYMBL_SEMICOLON), new Block(40,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(35).concat("."+Tag.SYMBL_SEMICOLON), new Block(46,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(39).concat("."+Tag.SYMBL_SEMICOLON), new Block(17,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(41).concat("."+Tag.SYMBL_SEMICOLON), new Block(52,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(42).concat("."+Tag.SYMBL_SEMICOLON), new Block(14,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(43).concat("."+Tag.SYMBL_SEMICOLON), new Block(15,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(44).concat("."+Tag.SYMBL_SEMICOLON), new Block(11,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(45).concat("."+Tag.SYMBL_SEMICOLON), new Block(12,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(47).concat("."+Tag.SYMBL_SEMICOLON), new Block(53,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(54).concat("."+Tag.SYMBL_SEMICOLON), new Block(56,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(55).concat("."+Tag.SYMBL_SEMICOLON), new Block(57,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(18).concat("."+Tag.OP_ASGN), new Block(36,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(6).concat("."+Tag.KW_DATATYPE), new Block(16,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(8).concat("."+Tag.KW_DATATYPE), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(9).concat("."+Tag.KW_DATATYPE), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(11).concat("."+Tag.KW_DATATYPE), new Block(16,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(12).concat("."+Tag.KW_DATATYPE), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(24).concat("."+Tag.KW_DATATYPE), new Block(5,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(26).concat("."+Tag.KW_DATATYPE), new Block(6,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(28).concat("."+Tag.KW_DATATYPE), new Block(7,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(34).concat("."+Tag.KW_DATATYPE), new Block(10,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(40).concat("."+Tag.KW_DATATYPE), new Block(27,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(46).concat("."+Tag.KW_DATATYPE), new Block(8,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(52).concat("."+Tag.KW_DATATYPE), new Block(26,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(53).concat("."+Tag.KW_DATATYPE), new Block(9,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(56).concat("."+Tag.KW_DATATYPE), new Block(21,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(57).concat("."+Tag.KW_DATATYPE), new Block(22,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(0).concat("."+Tag.IDSP_EXE), new Block(2,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(6).concat("."+Tag.FLOAT_NO), new Block(17,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(7).concat("."+Tag.FLOAT_NO), new Block(17,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(8).concat("."+Tag.FLOAT_NO), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(9).concat("."+Tag.FLOAT_NO), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(11).concat("."+Tag.FLOAT_NO), new Block(17,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(12).concat("."+Tag.FLOAT_NO), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(24).concat("."+Tag.FLOAT_NO), new Block(5,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(25).concat("."+Tag.FLOAT_NO), new Block(17,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(26).concat("."+Tag.FLOAT_NO), new Block(6,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(28).concat("."+Tag.FLOAT_NO), new Block(7,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(29).concat("."+Tag.FLOAT_NO), new Block(17,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(30).concat("."+Tag.FLOAT_NO), new Block(17,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(32).concat("."+Tag.FLOAT_NO), new Block(17,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(33).concat("."+Tag.FLOAT_NO), new Block(17,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(34).concat("."+Tag.FLOAT_NO), new Block(10,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(36).concat("."+Tag.FLOAT_NO), new Block(17,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(37).concat("."+Tag.FLOAT_NO), new Block(17,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(38).concat("."+Tag.FLOAT_NO), new Block(17,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(40).concat("."+Tag.FLOAT_NO), new Block(27,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(46).concat("."+Tag.FLOAT_NO), new Block(8,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(52).concat("."+Tag.FLOAT_NO), new Block(26,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(53).concat("."+Tag.FLOAT_NO), new Block(9,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(56).concat("."+Tag.FLOAT_NO), new Block(21,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(57).concat("."+Tag.FLOAT_NO), new Block(22,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(6).concat("."+Tag.ID), new Block(18,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(7).concat("."+Tag.ID), new Block(23,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(8).concat("."+Tag.ID), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(9).concat("."+Tag.ID), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(11).concat("."+Tag.ID), new Block(18,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(12).concat("."+Tag.ID), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(16).concat("."+Tag.ID), new Block(35,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(24).concat("."+Tag.ID), new Block(5,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(25).concat("."+Tag.ID), new Block(23,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(26).concat("."+Tag.ID), new Block(6,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(28).concat("."+Tag.ID), new Block(7,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(29).concat("."+Tag.ID), new Block(23,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(30).concat("."+Tag.ID), new Block(23,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(32).concat("."+Tag.ID), new Block(23,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(33).concat("."+Tag.ID), new Block(23,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(34).concat("."+Tag.ID), new Block(10,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(36).concat("."+Tag.ID), new Block(23,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(37).concat("."+Tag.ID), new Block(23,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(38).concat("."+Tag.ID), new Block(23,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(40).concat("."+Tag.ID), new Block(27,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(46).concat("."+Tag.ID), new Block(8,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(52).concat("."+Tag.ID), new Block(26,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(53).concat("."+Tag.ID), new Block(9,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(56).concat("."+Tag.ID), new Block(21,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(57).concat("."+Tag.ID), new Block(22,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(37).concat("."+Tag.LTRL), new Block(50,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(38).concat("."+Tag.LTRL), new Block(50,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(6).concat("."+Tag.INT_NO), new Block(19,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(7).concat("."+Tag.INT_NO), new Block(19,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(8).concat("."+Tag.INT_NO), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(9).concat("."+Tag.INT_NO), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(11).concat("."+Tag.INT_NO), new Block(19,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(12).concat("."+Tag.INT_NO), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(24).concat("."+Tag.INT_NO), new Block(5,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(25).concat("."+Tag.INT_NO), new Block(19,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(26).concat("."+Tag.INT_NO), new Block(6,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(28).concat("."+Tag.INT_NO), new Block(7,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(29).concat("."+Tag.INT_NO), new Block(19,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(30).concat("."+Tag.INT_NO), new Block(19,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(32).concat("."+Tag.INT_NO), new Block(19,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(33).concat("."+Tag.INT_NO), new Block(19,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(34).concat("."+Tag.INT_NO), new Block(10,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(36).concat("."+Tag.INT_NO), new Block(19,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(37).concat("."+Tag.INT_NO), new Block(19,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(38).concat("."+Tag.INT_NO), new Block(19,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(40).concat("."+Tag.INT_NO), new Block(27,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(46).concat("."+Tag.INT_NO), new Block(8,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(52).concat("."+Tag.INT_NO), new Block(26,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(53).concat("."+Tag.INT_NO), new Block(9,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(56).concat("."+Tag.INT_NO), new Block(21,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(57).concat("."+Tag.INT_NO), new Block(22,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(8).concat("."+Tag.REPLY), new Block(25,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(9).concat("."+Tag.REPLY), new Block(25,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(12).concat("."+Tag.REPLY), new Block(25,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(34).concat("."+Tag.REPLY), new Block(10,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(46).concat("."+Tag.REPLY), new Block(8,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(53).concat("."+Tag.REPLY), new Block(9,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(56).concat("."+Tag.REPLY), new Block(21,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(57).concat("."+Tag.REPLY), new Block(22,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(6).concat("."+Tag.IDSP_SHOW), new Block(20,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(8).concat("."+Tag.IDSP_SHOW), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(9).concat("."+Tag.IDSP_SHOW), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(11).concat("."+Tag.IDSP_SHOW), new Block(20,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(12).concat("."+Tag.IDSP_SHOW), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(24).concat("."+Tag.IDSP_SHOW), new Block(5,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(26).concat("."+Tag.IDSP_SHOW), new Block(6,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(28).concat("."+Tag.IDSP_SHOW), new Block(7,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(34).concat("."+Tag.IDSP_SHOW), new Block(10,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(40).concat("."+Tag.IDSP_SHOW), new Block(27,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(46).concat("."+Tag.IDSP_SHOW), new Block(8,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(52).concat("."+Tag.IDSP_SHOW), new Block(26,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(53).concat("."+Tag.IDSP_SHOW), new Block(9,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(56).concat("."+Tag.IDSP_SHOW), new Block(21,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(57).concat("."+Tag.IDSP_SHOW), new Block(22,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(6).concat("."+Tag.IDSP_SHOWINE), new Block(21,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(8).concat("."+Tag.IDSP_SHOWINE), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(9).concat("."+Tag.IDSP_SHOWINE), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(11).concat("."+Tag.IDSP_SHOWINE), new Block(21,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(12).concat("."+Tag.IDSP_SHOWINE), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(24).concat("."+Tag.IDSP_SHOWINE), new Block(5,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(26).concat("."+Tag.IDSP_SHOWINE), new Block(6,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(28).concat("."+Tag.IDSP_SHOWINE), new Block(7,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(34).concat("."+Tag.IDSP_SHOWINE), new Block(10,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(40).concat("."+Tag.IDSP_SHOWINE), new Block(27,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(46).concat("."+Tag.IDSP_SHOWINE), new Block(8,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(52).concat("."+Tag.IDSP_SHOWINE), new Block(26,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(53).concat("."+Tag.IDSP_SHOWINE), new Block(9,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(56).concat("."+Tag.IDSP_SHOWINE), new Block(21,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(57).concat("."+Tag.IDSP_SHOWINE), new Block(22,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(4).concat("."+Tag.SYMBL_OPCR), new Block(6,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(6).concat("."+Tag.SYMBL_CLCR), new Block(3,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(8).concat("."+Tag.SYMBL_CLCR), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(9).concat("."+Tag.SYMBL_CLCR), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(11).concat("."+Tag.SYMBL_CLCR), new Block(3,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(12).concat("."+Tag.SYMBL_CLCR), new Block(28,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(14).concat("."+Tag.SYMBL_CLCR), new Block(31,ActionType.SHIFT));
                AT1.atable.put(String.valueOf(24).concat("."+Tag.SYMBL_CLCR), new Block(5,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(26).concat("."+Tag.SYMBL_CLCR), new Block(6,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(27).concat("."+Tag.SYMBL_CLCR), new Block(4,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(28).concat("."+Tag.SYMBL_CLCR), new Block(7,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(34).concat("."+Tag.SYMBL_CLCR), new Block(10,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(40).concat("."+Tag.SYMBL_CLCR), new Block(27,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(46).concat("."+Tag.SYMBL_CLCR), new Block(8,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(52).concat("."+Tag.SYMBL_CLCR), new Block(26,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(53).concat("."+Tag.SYMBL_CLCR), new Block(9,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(56).concat("."+Tag.SYMBL_CLCR), new Block(21,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(57).concat("."+Tag.SYMBL_CLCR), new Block(22,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(1).concat("."+Tag.END), new Block(0,ActionType.ACCEPT));
                AT1.atable.put(String.valueOf(5).concat("."+Tag.END), new Block(1,ActionType.REDUCE));
                AT1.atable.put(String.valueOf(31).concat("."+Tag.END), new Block(2,ActionType.REDUCE));
    }
}


//==========================================================================================================================================================================




//===================================================================================================================================================================================================================================


class Block{
    
    int intInfo;
    String actiontype;
    
    public Block(int intInfo, String actiontype){
        
        this.intInfo = intInfo;
        this.actiontype = actiontype;
        
    }
}



//=======================================================================================================================================================================================================================================


class ActionTableDriver{

    public static void main(String Arg[]){

        ActionTable a = ActionTable.AT1;
        
        //Block b = a.atable.get("1.$");
        
                Infopkg i = new Infopkg();
               i= a.getAction("2.".concat(Tag.SYMBL_OPBR));
        System.out.println(i.actionType+" "+i.state+" "+i.nterminal+" "+i.terminal);
}


}