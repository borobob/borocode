/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capaDatos;


/**
 *
 * @author BORO
 */
public class validaRut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }

    public boolean validaRut(String rut){

            // TODO Valida Rut
       boolean siNo = false;
//       rut = "4299006-K"; // Rut con  K 4299006-K
       String dv = rut.substring(rut.length()-1 ,rut.length());
       String rutSDV="1";
       String x ="";

       //Separo rut de dv
       for(int i=0;i<rut.length()-2;i++){
           rutSDV = rut.substring(i,i+1);
           x= x + rutSDV;
       }

       int multiplicador= 2;
       int acomula=0;
       //Calculos
        for (int i=0;i<x.length();i++){
       int numero = Integer.parseInt(x.substring(x.length()-i-1 ,x.length()-i))*multiplicador;
       acomula = acomula + numero;

        multiplicador++;
        if(multiplicador==8){multiplicador=2;}
        }
       int verificar = 11-(acomula%11);
       String dvFinal = verificar +"";
       if(verificar>=10){
                         dvFinal="K";
                        }
       if(verificar==11){
                         dvFinal="0";
                        }
       if(dv.equalsIgnoreCase(dvFinal))
       {
           siNo=true;
       }
       return siNo;
    } // fin validaRut

}