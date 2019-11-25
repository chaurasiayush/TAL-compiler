/*
 * author Ayush Chaurasia (CSJMA16001390016)
 */
package lexicalAnalyzer;

import lexicalAnalyzer.Token;

public class Keyword
extends Token {
    
    public static final Keyword reply = new Keyword(Tag.REPLY, KeywordValues.REPLY);
    public static final Keyword intg = new Keyword(Tag.KW_DATATYPE, KeywordValues.INTG);
    public static final Keyword floatg = new Keyword(Tag.KW_DATATYPE, KeywordValues.FLOATG);
    public static final Keyword loop = new Keyword(Tag.LOOP, KeywordValues.LOOP);
    public static final Keyword pcond = new Keyword(Tag.PCOND, KeywordValues.PCOND);
    public static final Keyword scond = new Keyword(Tag.SCOND, KeywordValues.SCOND);
    public static final Keyword fcond = new Keyword(Tag.FCOND, KeywordValues.FCOND);
    public static final Keyword ctrue = new Keyword(Tag.CTRUE, KeywordValues.CTRUE);
    public static final Keyword cfalse = new Keyword(Tag.CFALSE, KeywordValues.CFALSE);
    public static final Keyword endure = new Keyword(Tag.ENDURE, KeywordValues.ENDURE);
    public static final Keyword interrupt = new Keyword(Tag.INTERRUPT, KeywordValues.INTERRUPT);

    Keyword(String tag,String value) {
        super(tag, value);
    }
}
