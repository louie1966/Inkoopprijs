package nl.louie66;

import java.util.*;

public class Inkoopprijs {
    /*
     * De verkoopprijs wordt berekend zonder en met btw.
     * @author: Rene de Leeuw
     * */

    public static void main(String[] args) {

        // Hier worden de constanten gedefinieerd
        final double BTW_HOOG = 21;
        final double BTW_LAAG = 6;

        // De scanner slaat de input van gebruikers op
        Scanner scan = new Scanner(System.in);
        System.out.println("Wat is de inkoopprijs?");
        String inkoopPrijs = scan.nextLine();
        System.out.println("Wat is de marge?");
        String marge = scan.nextLine();
        scan.close();

        // De input van de gebruiker wordt getoond
        System.out.printf("Inkoopprijs: %s\n", inkoopPrijs);
        System.out.printf("Winstmarge (in %%): %s\n", marge);
        System.out.println();

        // Er wordt input met een comma ',' verwacht,
        // deze moeten een punt '.' zijn
        inkoopPrijs = inkoopPrijs.replace(',', '.');

        // Tekst wordt 3 maal naar console geprint wat de uitkomst is
        // 14 getallen achter de comma
        System.out.printf("Verkoopprijs exclusief BTW : %.14f\n",
                berekenVerkoopPrijs(Double.parseDouble(inkoopPrijs),
                        Double.parseDouble(marge),
                        0));
        System.out.printf("Verkoopprijs inclusief 6%% BTW: %.15f\n",
                berekenVerkoopPrijs(Double.parseDouble(inkoopPrijs),
                        Double.parseDouble(marge),
                        BTW_LAAG));
        System.out.printf("Verkoopprijs inclusief 21%% BTW: %.14f\n",
                berekenVerkoopPrijs(Double.parseDouble(inkoopPrijs),
                        Double.parseDouble(marge),
                        BTW_HOOG));

    }

    public static double berekenVerkoopPrijs(double inkoopPrijs, double marge, double btw) {
        /*
         * Verkoopprijs wordt berekend.
         * @param inkoopPrijs prijs ingegeven door de gebruiker
         * @param marge ophoogpercentage om verkoopprijs te berekenen
         * @param btw ophoogpercentage om de btw over de verkoopprijs te berekenen
         * @return verkoopPrijs retourneerd de berekende verkoopprijs
         * */

        double verkoopPrijs = inkoopPrijs * (1 + (marge / 100)) * (1 + (btw / 100));
        return verkoopPrijs;
    }
}
