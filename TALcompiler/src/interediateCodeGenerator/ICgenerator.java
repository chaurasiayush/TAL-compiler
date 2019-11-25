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
package interediateCodeGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author ayush
 */
public class ICgenerator{
    
    int tab = 0;
    PrintStream tofile;
    
    public ICgenerator(){
        
        try{
            
            tofile = new PrintStream("TAL_prg.java");
            
        }catch(FileNotFoundException e){

                System.out.println("Output file could not be created!!\n");
                errorHandler.Error.exitPrg();

            }
        tofile.println("/* this file is generated through TALcompiler \n");
        tofile.println("\n"+
                        "--------------------------------\n" +
                        "           TALcompiler          \n" +
                        "--------------------------------\n" +
                        " Developed by-   \n" +
                        "  * Abhishek Kumar Singh        \n" +
                        "  * Anish Shrivastav            \n" +
                        "  * Ayush Chaurasia    \n" +
                        "--------------------------------\n" +
                        " \n*/\n");
        
        tofile.println("import java.lang.*;");
        tofile.println("import java.util.*;");
        tofile.println("import java.io.*;");
        tofile.println("\n");
        tofile.println("public class TAL_prg{");
        tofile.println();
        tab++;
        tofile.println("}");
    }

    public void WriteLine(String Line){
        
        for(int i = tab; i>0; i--)
            tofile.print("    ");
        
        tofile.println(Line);
        
    }
    
    public void IncrTab(){
        this.tab++;
    }
    
    public void DcrTab(){
        this.tab--;
    }
    
}

class Test{
    
    public static void main(String args[]) throws Exception{
        
       ICgenerator g = new ICgenerator();
       //g.IncrTab();
       g.WriteLine("int a;");
       g.WriteLine("int d;");
       g.WriteLine("int h;");
       g.WriteLine("int g;");
        
    }
    
}
