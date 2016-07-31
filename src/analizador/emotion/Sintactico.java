/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analizador.emotion;
import java.util.Stack;
/**
 *
 * @author Pedro Castro
 */
public class Sintactico {
    Stack pilaPredictiva = new Stack();
    int matrizPredictiva[][]=new int[37][44];
    private int p0[],p1[],p2[],p3[],p4[],p5[],p6[],p7[],p8[],p9[],p10[],p11[],p12[],p13[],p14[],p15[],p16[],p17[],p18[],p19[],p20[],p21[],p22[],p23[],p24[],p25[],p26[],p27[],p28[],p29[],p30[],p31[],p32[],p33[],p34[],p35[],p36[],p37[],p38[],p39[],p40[],p41[],p42[],p43[],p44[],p45[],p46[],p47[],p48[],p49[],p50[],p51[],p52[],p53[],p54[],p55[],p56[],p57[],p58[],p59[],p60[],p61[],p62[],p63[],p64[],p65[],p66[],p67[],p68[],p69[],p70[],p71[],p72[],p73[],p74[],p75[],p76[],p77[],p78[],p79[],p80[],p81[],p82[],p83[],p84[],p85[],p86[],p87[],p88[],p89[],p90[];
    int producciones[][];
    
    public Sintactico(){
        matriz();
        declaraProducciones();
    }
    
    public int analizar(){
        int col;
        int est;
        int p;
        int top;
        insertaProduccion(0);
        //while(!Tokens.tokens.isEmpty()){
            Tokens tok=((Tokens)(Tokens.tokens.poll()));
            est=tok.getEstado();
            col=tok.getColumna();
            while(!pilaPredictiva.isEmpty()){
                top=Integer.parseInt(pilaPredictiva.peek().toString());
                if(top>=0 && top<=46){
                    p=matrizPredictiva[top][col];
                    pilaPredictiva.pop();
                    insertaProduccion(p);
                }
                if(top>=100 && top<=143){
                    if(top==est){
                        pilaPredictiva.pop();
                        tok=((Tokens)(Tokens.tokens.poll()));
                        est=tok.getEstado();
                        col=tok.getColumna();                        
                    }
                    else{
                        return 1;
                    }
                }
            }
        //}

        return 0;
    }
    
    public void declaraProducciones(){
        /**0-PROGRAM-> class ( id ) DECLARA ESTATUTOS endclass */
        p0=new int[]{100,119,101,120,1,9,100};
        /**1-DECLARA-> declare ID_DIM AUX1 of TIPO ; AUX2 */
        p1=new int[]{100,4,2,100,8,123,3};
        /**2-DECLARA-> ? */
        p2=new int[]{};
        /**3-AUX1-> ? */
        p3=new int[]{};
        /**4-AUX1 -> , ID_DIM AUX1 */
        p4=new int[]{124,4,2};
        /**5-AUX2-> E*/
        p5=new int[]{};   
        /**6-AUX2-> DECLARA */
        p6=new int[]{1};
        /**7-ID_DIM-> id AUX3 */
        p7=new int[]{101,5};
        /**AUX3-> E*/
        p8=new int[]{};
        /**AUX3-> DIM */
        p9=new int[]{6};
        /**DIM-> [ cte.entera ] AUX4 */
        p10=new int[]{121,102,122,7};
        /**AUX4-> E */
        p11=new int[]{};
        /**AUX4-> DIM */
        p12=new int[]{6};
        /**TIPO-> int */
        p13=new int[]{100};
        /**TIPO-> float */
        p14=new int[]{100};
        /**TIPO-> char */
        p15=new int[]{100};
        /**TIPO-> string */
        p16=new int[]{100};
        /**ESTATUTOS-> E */
        p17=new int[]{};
        /**ESTATUTOS -> EST_ASIG ; AUX5 */
        p18=new int[]{11,123,10};
        /**ESTATUTOS -> EST_IF ; AUX5 */
        p19=new int[]{16,123,10};
        /**ESTATUTOS -> EST_WHILE ; AUX5 */
        p20=new int[]{18,123,10};
        /**ESTATUTOS -> EST_DO ; AUX5 */
        p21=new int[]{19,123,10};
        /**ESTATUTOS -> EST_READ ; AUX5 */
        p22=new int[]{20,123,10};
        /**ESTATUTOS -> EST_WRITE ; AUX5 */
        p23=new int[]{22,123,10};
        /**AUX5 -> E */
        p24=new int[]{};
        /**AUX5 -> ESTATUTOS */
        p25=new int[]{9};
        /** EST_ASIG -> ASIG = EXPR */
        p26=new int[]{13,109,24};
        /**ASIG-> id AUX6 */
        p27=new int[]{101,12};
        /** AUX6-> E*/
        p28=new int[]{};
        /**AUX6 -> DIM_ASIG */
        p29=new int[]{14};
        /** AUX6 -> [ EXPR AUX7 ] */
        p30=new int[]{121,24,15,122};
        /** AUX7-> E*/
        p31=new int[]{};
        /** AUX7-> , EXPR AUX7 */
        p32=new int[]{124,24,15};
        /**EST_IF -> if ( EXPR ) ESTATUTOS AUX8 */
        p33=new int[]{100,119,24,120,9,17};
        /** AUX8-> else ESTATUTOS endif */
        p34=new int[]{100,9,100};
        /** AUX8 -> endif*/
        p35=new int[]{100};
        /** EST_WHILE-> while ( EXPR ) ESTATUTOS endwhile*/
        p36=new int[]{100,119,24,120,9,100};
        /** EST_DO -> do ESTATUTOS while ( EXPR ) enddo*/
        p37=new int[]{100,9,100,119,24,120,100};
        /**EST_READ -> read ( id AUX9 ) */
        p38=new int[]{100,119,101,21,120};
        /**AUX9 -> E*/
        p39=new int[]{};
        /**AUX9 -> , id AUX9 */
        p40=new int[]{124,101,21};
        /** EST_WRITE -> write ( EXPR AUX10 ) 1*/
        p41=new int[]{100,119,24,23,120};
        /**AUX10-> E*/
        p42=new int[]{};
        /**AUX10 -> , EXPR AUX10 */
        p43=new int[]{124,24,23};
        /**EXPR -> EXPR2 AUX11*/
        p44=new int[]{26,25};
        /**AUX11 -> E */
        p45=new int[]{};
        /**AUX11-> || EXPR */
        p46=new int[]{118,24};
        /** EXPR2 -> EXPR3 AUX12  */
        p47=new int[]{28,27};
        /**AUX12 -> E*/
        p48=new int[]{};
        /**AUX12 -> && EXPR2 */
        p49=new int[]{117,26};
        /**EXPR3 -> EXPR4 */
        p50=new int[]{29};
        /**EXPR3 -> ! EXPR4 */
        p51=new int[]{116,29};
        /**EXPR4 -> EXPR5 AUX13*/
        p52=new int[]{31,30};
        /**AUX13 -> OPREL EXPR5*/
        p53=new int[]{36,31};
        /**AUX13 -> E*/
        p54=new int[]{};
        /**EXPR5 -> TERM AUX14*/
        p55=new int[]{33,32};
        /**AUX14 -> E*/
        p56=new int[]{};
        /**AUX14 -> + EXPR5 */
        p57=new int[]{105,31};
        /**AUX14 -> - EXPR5 */
        p58=new int[]{106,31};
        /**TERM -> FACT AUX15 */
        p59=new int[]{35,34};
        /**AUX15 -> E */
        p60=new int[]{};
        /**AUX15 -> * TERM */
        p61=new int[]{107,33};
        /**AUX15 -> / TERM */
        p62=new int[]{108,33};
        /** AUX15 -> % TERM */
        p63=new int[]{128,33};
        /**FACT -> ASIG */
        p64=new int[]{13};
        /**FACT -> cte.entera */
        p65=new int[]{102};
        /**FACT -> cte.real */
        p66=new int[]{103};
        /**FACT -> cte.notacion */
        p67=new int[]{104};
        /**FACT -> cte.caracter */
        p68=new int[]{125};
        /**FACT -> cte.string*/
        p69=new int[]{126};
        /**FACT -> ( EXPR ) */
        p70=new int[]{119,24,120};
        /**OPREL -> == */
        p71=new int[]{110};
        /**OPREL -> != */
        p72=new int[]{115};
        /**OPREL -> < */
        p73=new int[]{111};
        /**OPREL -> <= */
        p74=new int[]{112};
        /**OPREL -> > */
        p75=new int[]{113};
        /**OPREL -> >= */
        p76=new int[]{114};
        
        producciones=new int[][]{p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,p38,p39,p40,p41,p42,p43,p44,p45,p46,p47,p48,p49,p50,p51,p52,p53,p54,p55,p56,p57,p58,p59,p60,p61,p62,p63,p64,p65,p66,p67,p68,p69,p70,p71,p72,p73,p74,p75,p76};
    }
    
    /**Llena la tabla predictiva con los valores correspondientes*/
    private void matriz(){
        //se llena toda la tabla predictiva con el valor del error
        for(int i=0;i<matrizPredictiva.length;i++){
            for(int j=0;j<matrizPredictiva[i].length;j++){
                matrizPredictiva[i][j]=600;
            }
        }
        //-----------------------------------------------------------
        //luego se llenan las casillas con los valores que son aceptados
        //Columna Identificador
        matrizPredictiva[1][0]=2;
        matrizPredictiva[3][0]=5;
        matrizPredictiva[4][0]=7;
        matrizPredictiva[9][0]=18;
        matrizPredictiva[10][0]=25;
        matrizPredictiva[11][0]=26;
        matrizPredictiva[13][0]=27;
        matrizPredictiva[24][0]=44;
        matrizPredictiva[26][0]=47;
        matrizPredictiva[28][0]=50;
        matrizPredictiva[29][0]=52;
        matrizPredictiva[31][0]=55;
        matrizPredictiva[33][0]=59;
        matrizPredictiva[35][0]=64;
        //Fin columna identificador
        
        //Columna class
        matrizPredictiva[0][1]=0;
        //FIn columna class
        
        //Columna endclass
        matrizPredictiva[1][2]=2;
        matrizPredictiva[3][2]=5;
        matrizPredictiva[9][2]=17;
        matrizPredictiva[10][2]=24;
        //fin columna endclass
        
        //Columna int
        matrizPredictiva[8][3]=13;
        //FIn columna int
        
        //Columna float
        matrizPredictiva[8][4]=14;
        //Fin columna float
        
        //Columna char
        matrizPredictiva[8][5]=15;
        //Fin Columna char
        
        //Columna string
        matrizPredictiva[8][6]=16;
        //Fin Columna string
        
        //Columna if
        matrizPredictiva[1][7]=2;
        matrizPredictiva[3][7]=5;
        matrizPredictiva[9][7]=19;
        matrizPredictiva[10][7]=25;
        matrizPredictiva[16][7]=33;
        //Fin Columna if
        
        //Columna else
        matrizPredictiva[9][8]=17;
        matrizPredictiva[10][8]=24;
        matrizPredictiva[17][8]=34;
        //Fin Columna else
        
        //Columna endif
        matrizPredictiva[9][9]=17;
        matrizPredictiva[10][9]=24;
        matrizPredictiva[17][9]=35;
        //Fin Columna endif
        
        //Columna do
        matrizPredictiva[1][10]=2;
        matrizPredictiva[3][10]=5;
        matrizPredictiva[9][10]=21;
        matrizPredictiva[10][10]=25;
        matrizPredictiva[19][10]=37;
        //Fin Columna do
        
        //Columna enddo
        matrizPredictiva[9][11]=17;
        //Fin Columna enddo
        
        //Columna while
        matrizPredictiva[1][12]=2;
        matrizPredictiva[3][12]=5;
        matrizPredictiva[9][12]=20;
        matrizPredictiva[10][12]=24;
        matrizPredictiva[18][12]=36;
        //Fin Columna while
        
        //Columna endwhile
        matrizPredictiva[10][13]=24;
        //Fin Columna endwhile
        
        //Columna read
        matrizPredictiva[1][14]=2;
        matrizPredictiva[3][14]=5;
        matrizPredictiva[9][14]=22;
        matrizPredictiva[10][14]=25;
        matrizPredictiva[20][14]=38;
        //Fin Columna read
        
        //Columna write
        matrizPredictiva[1][15]=2;
        matrizPredictiva[3][15]=5;
        matrizPredictiva[9][15]=23;
        matrizPredictiva[10][15]=25;
        matrizPredictiva[22][15]=41;
        //Fin Columna write
        
        //Columna declare
        matrizPredictiva[1][16]=1;
        matrizPredictiva[3][16]=6;
        //Fin Columna declare
        
        //Columna of
        matrizPredictiva[2][17]=3;
        matrizPredictiva[5][17]=8;
        matrizPredictiva[7][17]=11;
        //Fin Columna of
        
        //Columna cte.entero
        matrizPredictiva[24][18]=44;
        matrizPredictiva[26][18]=47;
        matrizPredictiva[28][18]=50;
        matrizPredictiva[29][18]=52;
        matrizPredictiva[31][18]=55;
        matrizPredictiva[33][18]=59;
        matrizPredictiva[35][18]=65;
        //Fin Columna cte.entero
        
        //Columna cte.real
        matrizPredictiva[24][19]=44;
        matrizPredictiva[26][19]=47;
        matrizPredictiva[28][19]=50;
        matrizPredictiva[29][19]=52;
        matrizPredictiva[31][19]=55;
        matrizPredictiva[33][19]=59;
        matrizPredictiva[35][19]=66;
        //Fin Columna cte.real
        
        //Columna cte notacion
        matrizPredictiva[24][20]=44;
        matrizPredictiva[26][20]=47;
        matrizPredictiva[28][20]=50;
        matrizPredictiva[29][20]=52;
        matrizPredictiva[31][20]=55;
        matrizPredictiva[33][20]=59;
        matrizPredictiva[35][20]=67;
        //Fin Columna cte.notacion
        
        //Columna +
        matrizPredictiva[12][21]=28;
        matrizPredictiva[32][21]=57;
        matrizPredictiva[34][21]=60;
        //Fin Columna +
        
        //Columna -
        matrizPredictiva[12][22]=28;
        matrizPredictiva[32][22]=58;
        matrizPredictiva[34][22]=60;
        //Fin Columna -
        
        //Columna /
        matrizPredictiva[12][23]=28;
        matrizPredictiva[34][23]=62;
        //Fin Columna /
        
        //Columna *
        matrizPredictiva[12][24]=28;
        matrizPredictiva[34][24]=61;
        //Fin Columna *
        
        //Columna =
        matrizPredictiva[12][25]=28;
        //Fin Columna = 
        
        //Columna ==
        matrizPredictiva[12][26]=28;
        matrizPredictiva[30][26]=53;
        matrizPredictiva[32][26]=56;
        matrizPredictiva[34][26]=60;
        matrizPredictiva[36][26]=71;
        //Fin Columna ==
        
        //Columna <
        matrizPredictiva[12][27]=28;
        matrizPredictiva[30][27]=53;
        matrizPredictiva[32][27]=56;
        matrizPredictiva[34][27]=60;
        matrizPredictiva[36][27]=73;
        //Fin Columna <
        
        //Columna <=
        matrizPredictiva[12][28]=28;
        matrizPredictiva[30][28]=53;
        matrizPredictiva[32][28]=56;
        matrizPredictiva[34][28]=60;
        matrizPredictiva[36][28]=74;
        //Fin Columna <=
        
        //Columna >
        matrizPredictiva[12][29]=28;
        matrizPredictiva[30][29]=53;
        matrizPredictiva[32][29]=56;
        matrizPredictiva[34][29]=60;
        matrizPredictiva[36][29]=75;
        //Fin Columna >
        
        //Columna >=
        matrizPredictiva[12][30]=28;
        matrizPredictiva[30][39]=53;
        matrizPredictiva[32][30]=56;
        matrizPredictiva[34][30]=60;
        matrizPredictiva[36][30]=76;
        //Fin Columna >=
        
        //Columna !=
        matrizPredictiva[12][31]=28;
        matrizPredictiva[30][31]=53;
        matrizPredictiva[32][31]=56;
        matrizPredictiva[34][31]=60;
        matrizPredictiva[36][31]=72;
        //Fin Columna !=
        
        //Columna !
        matrizPredictiva[24][32]=44;
        matrizPredictiva[26][32]=47;
        matrizPredictiva[28][32]=51;
        //Fin Columna !
        
        //Columna &&
        matrizPredictiva[12][33]=28;
        matrizPredictiva[27][33]=49;
        matrizPredictiva[30][33]=54;
        matrizPredictiva[32][33]=56;
        matrizPredictiva[34][33]=60;
        //Fin Columna &&
        
        //Columna ||
        matrizPredictiva[12][34]=28;
        matrizPredictiva[25][34]=46;
        matrizPredictiva[27][34]=48;
        matrizPredictiva[30][34]=54;
        matrizPredictiva[32][34]=56;
        matrizPredictiva[34][34]=60;
        //Fin Columna ||
        
        //Columna (
        matrizPredictiva[24][35]=44;
        matrizPredictiva[26][35]=47;
        matrizPredictiva[28][35]=50;
        matrizPredictiva[29][35]=52;
        matrizPredictiva[31][35]=55;
        matrizPredictiva[33][35]=59;
        matrizPredictiva[35][35]=70;
        //Fin Columna (
        
        //Columna )
        matrizPredictiva[12][36]=28;
        matrizPredictiva[21][36]=39;
        matrizPredictiva[23][36]=42;
        matrizPredictiva[25][36]=45;
        matrizPredictiva[27][36]=48;
        matrizPredictiva[30][36]=54;
        matrizPredictiva[32][36]=56;
        matrizPredictiva[34][36]=60;
        //Fin Columna )
        
        //Columna [
        matrizPredictiva[5][37]=9;
        matrizPredictiva[6][37]=10;
        matrizPredictiva[7][37]=12;
        matrizPredictiva[12][37]=29;
        matrizPredictiva[14][37]=30;
        //Fin Columna [
        
        //Columna ]
        matrizPredictiva[12][38]=28;
        matrizPredictiva[15][38]=31;
        matrizPredictiva[25][38]=45;
        matrizPredictiva[27][38]=48;
        matrizPredictiva[30][38]=54;
        matrizPredictiva[32][38]=56;
        matrizPredictiva[34][38]=60;
        //Fin Columna ]
        
        //Columna ;
        matrizPredictiva[9][39]=24;
        matrizPredictiva[12][39]=28;
        matrizPredictiva[25][39]=45;
        matrizPredictiva[27][39]=48;
        matrizPredictiva[30][39]=54;
        matrizPredictiva[32][39]=56;
        matrizPredictiva[34][39]=60;
        //Fin Columna ;
        
        //Columna ,
        matrizPredictiva[2][40]=4;
        matrizPredictiva[5][40]=8;
        matrizPredictiva[7][40]=11;
        matrizPredictiva[12][40]=28;
        matrizPredictiva[15][40]=32;
        matrizPredictiva[21][40]=40;
        matrizPredictiva[23][40]=43;
        matrizPredictiva[25][40]=45;
        matrizPredictiva[27][40]=48;
        matrizPredictiva[30][40]=54;
        matrizPredictiva[32][40]=56;
        matrizPredictiva[34][40]=60;
        //Fin Columna ,
        
        //Columna cte.caracter
        matrizPredictiva[24][41]=44;
        matrizPredictiva[26][41]=47;
        matrizPredictiva[28][41]=50;
        matrizPredictiva[29][41]=52;
        matrizPredictiva[31][41]=55;
        matrizPredictiva[33][41]=59;
        matrizPredictiva[35][41]=68;
        //Fin Columna cte.caracter
        
        //Columna cte.string 
        matrizPredictiva[24][42]=44;
        matrizPredictiva[26][42]=47;
        matrizPredictiva[28][42]=50;
        matrizPredictiva[29][42]=52;
        matrizPredictiva[31][42]=55;
        matrizPredictiva[33][42]=59;
        matrizPredictiva[35][42]=69;
        //Fin Columna cte.string 
        
        //Columna %
        matrizPredictiva[34][43]=63;
        //Fin columna %
    }
    
    public void insertaProduccion(int p){
        for(int i=producciones[p].length-1;i>=0;i--){
            pilaPredictiva.push(producciones[p][i]);
        }
    }
}
