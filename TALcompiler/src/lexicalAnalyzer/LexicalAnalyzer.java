/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalAnalyzer;

import java.io.IOException;
import java.util.HashMap;
import errorHandler.Error;
import symbolTable.*;
import talcompiler.TALcompiler;
/**
 *
 * @author ayush
 */
public class LexicalAnalyzer {
 
    HashMap<String, Keyword> keyw = new HashMap();
    HashMap<String, IdentifierSpecial> idsp = new HashMap();
    char peek = ' ';
    int line = 1;
    char schar[] = {';','+','-','/','*','(',')','{','}','='};

//-----------------------------------------------------------------------------------------------------------------------    
   
    public LexicalAnalyzer(){
        reserveKW();
        reserveIDSP();
    }
    
    private void reserveKW(){
        keyw.put("intg",Keyword.intg );
        keyw.put("reply",Keyword.reply);
        keyw.put("floatg",Keyword.floatg);
        keyw.put("loop",Keyword.loop);
        keyw.put("pcond",Keyword.pcond);
        keyw.put("scond",Keyword.scond);
        keyw.put("fcond",Keyword.fcond);
        keyw.put("ctrue",Keyword.ctrue);
        keyw.put("cfalse",Keyword.cfalse);
        keyw.put("endure",Keyword.endure);
        keyw.put("interrupt",Keyword.interrupt);
    }
    
    private void reserveIDSP() {
        this.idsp.put("show", IdentifierSpecial.show);
        this.idsp.put("showLine", IdentifierSpecial.showLine);
        this.idsp.put("exe", IdentifierSpecial.exe);
    }
//-----------------------------------------------------------------------------------------------------------------------
    
    private void read(){
        try{    
            peek = (char)System.in.read();
            
        }catch(IOException e){
            System.out.println("Inavalid Char!!");
        }
    }
    
    private boolean readChar(char a){
        read();
        if(peek == a)
            return true;
        //peek = ' ';
        return false;
    }
    
//-----------------------------------------------------------------------------------------------------------------------
    public int getLine(){
        return this.line;
    }
    
    public Token getToken(){
        
        
        for (;; read()) {
            if (peek == ' ' || peek == '\t') {
                //continue;
            } else if (peek == '\n') {
                line = line + 1;
            } else {
                break;
            }
        }
        
        switch(peek){
            
            case '=':
                
                if(readChar('=')){
                   TALcompiler.TAGTRACER.println("\"==\""+"                 <OP_EQ>");
                   return Operator.EQUAL;
                }
                //read();
                TALcompiler.TAGTRACER.println("\"=\""+"                     <OP_ASGN>");    
                return Operator.ASGN;
                
            case '+':
                read();
                TALcompiler.TAGTRACER.println("\"+\""+"                     <OP_PLUS>");
                return Operator.PLUS;
                
            case '-':
                read();
                TALcompiler.TAGTRACER.println("\"-\""+"                     <"+"OP_MINUS"+">");
                return Operator.MINUS;
                
            case '*':
                read();
                TALcompiler.TAGTRACER.println("\"*\""+"                     <OP_MULTIPLY>");
                return Operator.MULTIPLY;
                
            case '/':
                read();
                TALcompiler.TAGTRACER.println("\"/\""+"                     <OP_DEVIDE>");
                return Operator.DEVIDE;
                
            case '(':
                read();
                TALcompiler.TAGTRACER.println("\"(\"\t\t"+"                     <SYMBL_OPBR>");
                return Symbol.OPENBR;
                
            case ')':
                read();
                TALcompiler.TAGTRACER.println("\")\"\t\t"+"                     <SYMBL_CLBR>");
                return Symbol.CLOSEBR;
                
            case '{':
                read();
                TALcompiler.TAGTRACER.println("\"{\"\t\t"+"                     <SYMBL_OPCR>");
                return Symbol.OPENCR;
                
            case '}':
                read();
                TALcompiler.TAGTRACER.println("\"}\"\t\t"+"                     <SYMBL_CLCR>");
                return Symbol.CLOSECR;
                
            case ';':
                read();
                TALcompiler.TAGTRACER.println("\":\"\t\t"+"                     <SYMBL_SEMICOLON>");
                return Symbol.SEMICLN;
                
            case (char)-1:
                read();
                TALcompiler.TAGTRACER.println("\"$\"\t\t"+"         <END>");
                return Symbol.EOF;
                
        }// switch ends here
        
        //----------------------------------------------------------------------------------------------------------------
        
        if(Character.isLetter(peek)){                                           // creates token for valid IDETIFIER
                                                                                
            StringBuilder sb = new StringBuilder();

            do{
                sb.append(peek);
                read();
            }while(Character.isLetterOrDigit(peek));
        
            String s = sb.toString();
            Keyword w = keyw.get(s);
            if(w != null){
                TALcompiler.TAGTRACER.println("\""+s+"\""+"                 <"+"Keyworrd"+">");
                return w;
            }
            IdentifierSpecial sid = this.idsp.get(s);
            if (sid != null) {
                TALcompiler.TAGTRACER.println("\"" + s + "\"                <" + "Special_ID" + ">");
                if (!SymbolTable.stable.containsKey(s)) {
                    STData sd = new STData(sid, this.line);
                    SymbolTable.stable.put(s, sd);
                }
                return sid;
                
            } else {
                TALcompiler.TAGTRACER.println("\"" + s + "\"                <" + "Identifier" + ">");
                Identifier id = new Identifier(s);
                if (!SymbolTable.stable.containsKey(s)) {
                    STData sd = new STData(id, this.line);
                    SymbolTable.stable.put(s, sd);
                }
                return id;
            }
        }
        
        
        //----------------------------------------------------------------------------------------------------------------
        
        
        else if(Character.isDigit(peek)){                                            //creates token for INTEGER numbers as well as INVALID IDENTIFIERS (eg: 07id)
            
            StringBuilder sb = new StringBuilder();
            int vlue = 0;                
            do{
                sb.append(peek);
                vlue = vlue*10 + Character.digit(peek, 10);        
                read();
            }while((peek != ' '|| peek != ';' || peek != '+' || peek != '-' 
                    || peek != '/' || peek != '*' || peek != '(' || peek != ')' 
                    || peek != '{' || peek != '}' || peek == '\t')&& Character.isDigit(peek));
            
            if(peek == '.'){
                float x = vlue, d = 10;
                for (;;) {
                    read();
                    if (!Character.isDigit(peek)) {
                        break;
                    }
                    x = x + Character.digit(peek, 10) / d;
                    d = d * 10;
                }
                FloatNO fn = new FloatNO(x);
                TALcompiler.TAGTRACER.println("\""+x+"\"\t                  "+"<"+fn.tag+">");
                return fn;
            }
            
            
            else if(peek == ' '|| peek == ';' || peek == '+' || peek == '-' 
               || peek == '/' || peek == '*' || peek == '(' || peek == ')' 
               || peek == '{' || peek == '}' || peek == '\t'){
                IntNO n = new IntNO(vlue);
                TALcompiler.TAGTRACER.println("\""+vlue+"\"                 "+"<"+n.tag+">");
                return n;
 
            }
            
            else{                                                               //creates INVALID IDENTIFIERS
               
                do{
                    sb.append(peek);
                    read();
                }while(Character.isLetterOrDigit(peek));
                String sbstr = sb.toString();
                Error.lexicalErrorBadID(sbstr,line);
                TALcompiler.TAGTRACER.println("\""+sbstr+"\"                 "+"<BAD_IDENTIFIER>");
                return new Token(Tag.BADCHAR,sbstr);
            }
        }
        
        else if(peek == '"'){
            StringBuilder sb = new StringBuilder();
            while(true){
                read();
                if(peek == '"'){
                    read();
                    break;
                }
                sb.append(peek);
            }
            String literal = sb.toString();
            TALcompiler.TAGTRACER.println("\""+literal+"\"                  "+"<"+Tag.LTRL+">");
            return new Literal(literal);
        }

        else if(peek!=13){
            Error.lexicalErrorBadChar(peek,line);
            Token t = new Token(Tag.BADCHAR,String.valueOf(peek));
            peek = ' ';
            return t;
        }
        
            //System.out.println("tryyyyyy:"+(int)peek);
        Token t = new Token();
        peek = ' ';
        return t;
    }
}

