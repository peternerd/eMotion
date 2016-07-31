/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analizador.emotion;

import java.util.LinkedList;

/**
 *
 * @author Pedro Castro
 */
public class Tokens {
    private String lexema;
    private int estado;
    private int columna;
    private String palabras[]={"class","endclass","int","float","char","string","if","else","endif","do","enddo","while","endwhile","read","write","declare","of"};
    public static LinkedList tokens = new LinkedList<Tokens>();
    
    public Tokens(String lexema, int estado){
        this.lexema=lexema;
        this.estado=estado;
        this.columna=getColumna(estado,lexema);
        
    }
    
    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    public int getColumna(int est,String lexema){
        switch(est){
            case 100:
                
                if(compruebaPalabra(lexema)){
                    for(int i=0;i<palabras.length;i++){
                        if(palabras[i].equals(lexema)){
                            return i+1;
                        }
                    }
                }         
              
            case 101:
                return 0;
            case 102:
                return 18;                
            case 103:
                return 19;
            case 104:
                return 20;
            case 105:
                return 21;
            case 106:
                return 22;
            case 107:
                return 24;
            case 108:
                return 23;
            case 109:
                return 25;
            case 110:
                return 26;
            case 111:
                return 27;
            case 112:
                return 28;
            case 113:
                return 29;
            case 114:
                return 30;
            case 115:
                return 31;
            case 116:
                return 32;
            case 117:
                return 33;
            case 118:
                return 34;
            case 119:
                return 35;
            case 120:
                return 36;
            case 121:
                return 37;    
            case 122:
                return 38;   
            case 123:
                return 39;   
            case 124:
                return 40;    
            case 125:
                return 41;
            case 126:
                return 42;
            //case 127:
                //return 43;
            case 128:
                return 43;    
        }  
        return -1;
    }
    
    public boolean compruebaPalabra(String lex){
        
        for(int i=0;i<palabras.length;i++){
            try{
                
            if(lex.equals(palabras[i])){
                return true;
            }
            }
            catch(NullPointerException e){
                e.printStackTrace();
            }
        }
        
        return false;
    }
    
    public static String elementos(){
        String texto="";
        String lex;
        int est;
        for(int i=0;i<tokens.size();i++){
             lex=((Tokens)(tokens.get(i))).getLexema();
             est=((Tokens)(tokens.get(i))).getEstado();
             texto=texto+lex+"\t\t"+est+"\n";
        }
        
        return texto;
        
    }
}
