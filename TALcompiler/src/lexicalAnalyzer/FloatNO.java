/*
 * author Ayush Chaurasia (CSJMA16001390016)
 */
package lexicalAnalyzer;

import lexicalAnalyzer.Token;

public class FloatNO
extends Token {
    public FloatNO(Float f) {
        super(Tag.FLOAT_NO, f.toString());
    }
}
