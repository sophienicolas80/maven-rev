package fr.formation;

import fr.formation.services.Calcul;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
       //System.out.println( "Hello Sophie!" );
       Calcul calcul = new Calcul();
       int resSomme = calcul.somme(2,3);
       System.out.println(resSomme);

    } 
}
