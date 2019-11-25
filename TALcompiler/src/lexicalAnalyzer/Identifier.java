/*
 * author Ayush Chaurasia (CSJMA16001390016)
 */
package lexicalAnalyzer;

import lexicalAnalyzer.Token;

public class Identifier
extends Token {
    String v;

    public Identifier() {
    }

    public Identifier(String value) {
        super("Identifier", value);
    }
}
