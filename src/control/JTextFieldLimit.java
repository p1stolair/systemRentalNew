/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author APB
 */
public class JTextFieldLimit extends PlainDocument {

    private int limit;
    private String alphaNumeric = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .-";
    private String acceptedChars = null;

    public JTextFieldLimit(int limit) {
        this.limit = limit;
        acceptedChars = alphaNumeric;
    }

    public JTextFieldLimit(int limit, String acceptedChar) {
        super();
        this.limit = limit;
        this.acceptedChars = acceptedChar;
    }

    public void masukinString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (acceptedChars.indexOf(str.valueOf(str.charAt(i))) == -1) {
                return;
            }
        }
        super.insertString(offset, str, attr);
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        if ((getLength() + str.length()) <= limit) {
            masukinString(offset, str, attr);
        }
    }
}
