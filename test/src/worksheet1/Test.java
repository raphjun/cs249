/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package worksheet1;

/**
 *
 * @author jason
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "Hello";
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        System.out.println(s + first + last);
        String firstCharRemoved = s.substring(1, s.length());
        String lastCharRemoved = s.substring(0, s.length() - 1);
        System.out.println(firstCharRemoved + " " + lastCharRemoved);
    }
}
