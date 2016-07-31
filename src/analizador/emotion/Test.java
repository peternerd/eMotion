/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analizador.emotion;

import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Pedro Castro
 */
public class Test {
    
    public static void main(String args[]) throws IOException{
        JFileChooser selector=new JFileChooser();
        selector.showOpenDialog(null);
        Lexico lex=new Lexico(selector.getSelectedFile());
        Sintactico sin=new Sintactico();
        lex.analizar();
        
        if(sin.analizar()==0){
            System.out.println("Correcto");
        }
        else{
            System.out.println("Incorrecto");
        }
    }
    
}
