/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talcompiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import syntaxAnalyzer.Grammar;
import syntaxAnalyzer.SLRparser;
import syntaxAnalyzer.parseTable.ActionTable;
import syntaxAnalyzer.parseTable.GotoTable;
import java.lang.ArrayIndexOutOfBoundsException;
import errorHandler.Error;
import interediateCodeGenerator.ICgenerator;

/**
 *
 * @author ayush
 */
public class TALcompiler {

    public static PrintStream logWriter;
    public static PrintStream TAGTRACER;
    
    public static InputStream orig = System.in;
    
    

    
    public static void main(String args[]) throws IOException {
        
        System.out.println("ENTER FILE NAME TO COMPILE: ");
        Scanner dc = new Scanner(System.in);
        
        
        try{
            
            String path = dc.nextLine();
            System.out.println();
            
            if(path.length() == 0)
                throw new ArrayIndexOutOfBoundsException();
            
            File f = new File(path);
            FileInputStream fs = new FileInputStream(f); 
            System.setIn(fs); 
            
        }catch(FileNotFoundException e){
            
            System.out.println("no such file found!!\n");
            Error.exitPrg();
    
        }
        catch(ArrayIndexOutOfBoundsException ae){
            
            System.out.println("YOU MUST ENTER THE FILE NAME TO COMPILE!!\n");
            Error.exitPrg();
            
        }
        //LexicalAnalyzer la = new LexicalAnalyzer(); 
        try {
            logWriter  = new PrintStream("parselog.log");
            TAGTRACER  = new PrintStream("tagtrace.log");
            
        }catch (IOException e){
            System.out.println("log Files coulden't be created!");
        }
       
        SLRparser parser = new SLRparser(ActionTable.AT1, GotoTable.GT1, Grammar.G1);
        ICgenerator g = new ICgenerator();
        parser.parse();
        
        
        Error.exitPrg();
       
    }
    

}
    

