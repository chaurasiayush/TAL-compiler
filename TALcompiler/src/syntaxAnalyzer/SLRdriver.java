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

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import syntaxAnalyzer.parseTable.ActionTable;
//import syntaxAnalyzer.parseTable.GotoTable;
//
///**
// *
// * @author ayush
// */
//public class SLRdriver {
//    
//    static File outlog = new File("log.txt");
//    static  FileWriter logWriter;
//    
//    static {
//        try {
//           logWriter = new FileWriter(outlog);
//        }catch (IOException e){
//            System.out.println("log File coulden't be created!");
//        }
//    }
//    
//    public static void main(String args[]) throws Exception{
//        
//        File f = new File("inp2.tal");
//        
//        FileInputStream fs = new FileInputStream(f); 
//        
//        System.setIn(fs);
//        //LexicalAnalyzer la = new LexicalAnalyzer();
//       
//        SLRparser parser = new SLRparser(ActionTable.AT1, GotoTable.GT1, Grammar.G1);
//        parser.parse();
//       
//    }
//    
//}
