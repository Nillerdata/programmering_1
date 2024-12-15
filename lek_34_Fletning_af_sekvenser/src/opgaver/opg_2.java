package opgaver;

import java.util.Arrays;

public class opg_2 {
    public static void main(String[] args) {
        // Initialiserer to arrays med heltal
        int[] l1 = {2, 4, 6, 8, 10, 12, 14};
        int[] l2 = {1, 2, 4, 5, 6, 9, 12, 17};

        // Udskriver de fælles tal mellem l1 og l2 ved at kalde metoden fællesTal
        System.out.println(Arrays.toString(fællesTal(l1, l2)));
    }

    /**
     * Returnerer et sorteret array, der indeholder alle elementer,
     * som l1 og l2 har til fælles.
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og indeholder ikke tomme pladser
     */
    public static int[] fællesTal(int[] l1, int[] l2) {
        // Initialiserer et array til at gemme de fælles elementer
        int[] samlet = new int[Math.min(l1.length, l2.length)];

        // Indekser til at iterere gennem l1, l2 og samlet
        int i1 = 0;
        int i2 = 0;
        int j = 0;

        // Løkke, der fortsætter, så længe der er elementer tilbage i både l1 og l2
        while (i1 < l1.length && i2 < l2.length) {
            // Hvis elementet i l1 er mindre end elementet i l2
            if (l1[i1] < l2[i2]) {
                // Gå til næste element i l1
                i1++;
            } else if (l1[i1] > l2[i2]) {
                // Hvis elementet i l1 er større end elementet i l2, gå til næste element i l2
                i2++;
            } else {
                // Hvis elementerne er ens, tilføj elementet til samlet
                samlet[j] = l2[i2];
                i1++;
                i2++;
                j++;
            }
        }

        // Returnerer arrayet samlet med de fælles elementer
        return Arrays.copyOf(samlet, j);
    }
}

