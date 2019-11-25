/*
 * author Ayush Chaurasia (CSJMA16001390016)
 */
package lexicalAnalyzer;

import lexicalAnalyzer.Token;

public class IdentifierSpecial
extends Token {
    String v;
    public static final IdentifierSpecial show = new IdentifierSpecial(Tag.IDSP_SHOW, "System.out.print");
    public static final IdentifierSpecial showLine = new IdentifierSpecial(Tag.IDSP_SHOWINE, "System.out.println");
    public static final IdentifierSpecial exe = new IdentifierSpecial(Tag.IDSP_EXE, "main");

    public IdentifierSpecial() {
    }

    public IdentifierSpecial(String tag, String value) {
        super(tag, value);
    }
}
