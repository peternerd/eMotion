/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analizador.emotion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro Castro
 */
public class Lexico {
    BufferedReader entrada;
    PushbackReader devolver;
    File archivo;
    int estado=0;
    String lexema="";
    char caracter;
    final int estadoInicial=0, estadoFinal=19;
    int col=0;
    int matrizTransicion[][]= new int[20][31];
    
    
    public Lexico(File f){
        archivo=f;
        try {
            entrada=new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lexico.class.getName()).log(Level.SEVERE, null, ex);
        }
        devolver = new PushbackReader(entrada);
        matriz();
    }
    
    public int analizar() throws IOException{
        while(entrada.ready()){
            estado=0;
            while(estado>=estadoInicial && estado<=estadoFinal){
                caracter=(char)devolver.read();
                
                col=buscaColumna(caracter);
                estado=matrizTransicion[estado][col];
                if(estado>=100 && estado<=129){
                    
                    if( (estado>= 105 && estado<=108) || (estado>=119 && estado<=124) || estado==128){
                        lexema=lexema+caracter;
                    }
                    if(estado==125){
                        lexema=lexema+caracter;    
                    }
                    if(estado==118 || estado==117 || estado==115 || estado==114 || estado==112 || estado==110){
                        lexema=lexema+caracter;   
                        
                    }
                    if(estado==100 || estado==101 || estado==109 || estado==111 || estado==113 || estado==116 || estado==126 || estado==102 || estado==103 || estado==104){
                        devolver.unread(caracter);
                    }
                   
                }
                else{
                    lexema=lexema+caracter;                    
                    
                }                
            }
            lexema=lexema.trim();
            System.out.println(lexema+"\t\t"+estado);
            if(estado!=127){
                Tokens.tokens.add(new Tokens(lexema,estado));
            }            
            lexema="";
        }
        return 0;
    }
    
    public void matriz(){
    matrizTransicion[0][0]=1;
    matrizTransicion[0][1]=2;
    matrizTransicion[0][2]=3;
    matrizTransicion[0][3]=2;
    matrizTransicion[0][4]=1;
    matrizTransicion[0][5]=105;
    matrizTransicion[0][6]=106;
    matrizTransicion[0][7]=107;
    matrizTransicion[0][8]=108;
    matrizTransicion[0][9]=10;
    matrizTransicion[0][10]=11;
    matrizTransicion[0][11]=9;
    matrizTransicion[0][12]=12;
    matrizTransicion[0][13]=13;
    matrizTransicion[0][14]=14;
    matrizTransicion[0][15]=15;
    matrizTransicion[0][16]=17;
    matrizTransicion[0][17]=128;
    matrizTransicion[0][18]=0;
    matrizTransicion[0][19]=119;
    matrizTransicion[0][20]=120;
    matrizTransicion[0][21]=121;
    matrizTransicion[0][22]=122;
    matrizTransicion[0][23]=124;
    matrizTransicion[0][24]=123;
    matrizTransicion[0][25]=0;
    matrizTransicion[0][26]=0;
    matrizTransicion[0][27]=506;
    matrizTransicion[0][28]=506;
    matrizTransicion[0][29]=506;
    matrizTransicion[0][30]=19;

    //Fila 1
    for(int i=0;i<30;i++){
        matrizTransicion[1][i]=100;
    }
    matrizTransicion[1][0]=1;
    matrizTransicion[1][1]=2;
    matrizTransicion[1][2]=2;
    matrizTransicion[1][3]=2;
    matrizTransicion[1][4]=1;
    matrizTransicion[1][28]=2;
    //Fin fila 1

    //Fila 2
    for(int i=0;i<30;i++){
        matrizTransicion[2][i]=101;
    }
    matrizTransicion[2][0]=2;
    matrizTransicion[2][1]=2;
    matrizTransicion[2][2]=2;
    matrizTransicion[2][3]=2;
    matrizTransicion[2][4]=2;
    matrizTransicion[2][28]=2;
    //Fin fila 2

   //Fila 3
   for(int i=0;i<30;i++){
       matrizTransicion[3][i]=102;
   }
   matrizTransicion[3][2]=3;
   matrizTransicion[3][29]=4;
   //Fin fila 3

   //Fila 4
   for(int i=0;i<30;i++){
       matrizTransicion[4][i]=500;
   }
   matrizTransicion[4][2]=5;
   //Fin fila 4

   //Fila 5
   for(int i=0;i<30;i++){
       matrizTransicion[5][i]=103;
   }
   matrizTransicion[5][2]=5;
   matrizTransicion[5][3]=6;
   matrizTransicion[5][4]=6;
   //Fin fila 5

   //Fila 6
   for(int i=0;i<30;i++){
       matrizTransicion[6][i]=501;
   }
   matrizTransicion[6][2]=8;
   matrizTransicion[6][5]=7;
   matrizTransicion[6][6]=7;
   //Fin fila 6

   //Fila 7
   for(int i=0;i<30;i++){
       matrizTransicion[7][i]=502;
   }
   matrizTransicion[7][2]=8;
   //Fin fila 7

   //Fila 8
   for(int i=0;i<30;i++){
       matrizTransicion[8][i]=104;
   }
   matrizTransicion[8][2]=8;
   //Fin fila 8

   //Fila 9
   for(int i=0;i<30;i++){
       matrizTransicion[9][i]=109;
   }
   matrizTransicion[9][11]=110;
   //Fin fila 9

   //Fila 10
   for(int i=0;i<30;i++){
       matrizTransicion[10][i]=111;
   }
   matrizTransicion[10][11]=112;
   //Fin fila 10

   //Fila 11
   for(int i=0;i<30;i++){
       matrizTransicion[11][i]=113;
   }
   matrizTransicion[11][11]=114;
   //Fin fila 11

   //Fila 12
   for(int i=0;i<30;i++){
       matrizTransicion[12][i]=116;
   }
   matrizTransicion[12][11]=115;
   //Fin fila 12

   //Fila 13
   for(int i=0;i<30;i++){
       matrizTransicion[13][i]=503;
   }
   matrizTransicion[13][13]=117;
   //Fin fila 13

   //Fila 14
   for(int i=0;i<30;i++){
       matrizTransicion[14][i]=504;
   }
   matrizTransicion[14][14]=118;
   //Fin fila 14

   //Fila 15
   for(int i=0;i<30;i++){
       matrizTransicion[15][i]=16;
   }
   matrizTransicion[15][15]=505;
   //Fin fila 15

   //Fila 16
   for(int i=0;i<30;i++){
       matrizTransicion[16][i]=507;
   }
   matrizTransicion[16][15]=125;
   //Fin fila 16

   //Fila 17
   for(int i=0;i<30;i++){
       matrizTransicion[17][i]=17;
   }
   matrizTransicion[17][16]=18;
   //Fin fila 17

   //Fila 18
   for(int i=0;i<30;i++){
       matrizTransicion[18][i]=126;
   }
   matrizTransicion[18][16]=17;
   //Fin fila 18

   //Fila 19
   for(int i=0;i<30;i++){
       matrizTransicion[19][i]=19;
   }
   matrizTransicion[19][18]=127;
   //Fin fila 19
    }
    
    public int buscaColumna(char c){
    if(Character.isLetter(c)){
        if(Character.isLowerCase(c)){
            if(c=='e'){
                return 4;
            }
            else{
                return 0;
            }
        }
        else{
            if(c=='E'){
                return 3;
            }
            else{
                return 1;
            }
        }
    }
    else if(Character.isDigit(c)){
        return 2;
    }
    else{
        switch(c){
            case '+':
                return 5;
            case '-':
                return 6;
            case '*':
                return 7;
            case '/':
                return 8;
            case '<':
                return 9;
            case '>':
                return 10;
            case '=':
                return 11;
             case '!':
                return 12;
             case '&':
                return 13;
             case '|':
                return 14;
             case '\'':
                return 15;
             case '"':
                return 16;
             case '%':
                return 17;
             case '\n':
                return 18;
             case '\r':
                 return 18;
             case '(':
                return 19;
             case ')':
                return 20;
             case '[':
                return 21;
             case ']':
                return 22;
             case ',':
                return 23;
             case ';':
                return 24;
             case '\t':
                return 25;
             case ' ':
                return 26;
             case '_':
                return 28;
             case '.':
                return 29;
             case '#':
                 return 30;
             default:
                return 27;
        }
    }
}
    
    public String leerArchivo() throws IOException{
        String texto ="";
        entrada.mark(5000);
        try {
            while(entrada.ready()){
                texto=texto+entrada.readLine()+"\n";        
            }
        } catch (IOException ex) {
            Logger.getLogger(Lexico.class.getName()).log(Level.SEVERE, null, ex);
        }
        entrada.reset();
        return texto;
    }
}
