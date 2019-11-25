/*
 * author Ayush Chaurasia (CSJMA16001390016)
 */
package lexicalAnalyzer;

import lexicalAnalyzer.Token;

public class IntNO
extends Token {
    IntNO(Integer value) {
        super(Tag.INT_NO, value.toString());
    }
}
