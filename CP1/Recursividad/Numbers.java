// ChatGPT

public class Numbers {

    private static double N = 25;

    // Fórmula directa: formula(z) = (z + √(4 + z²)) / 2
    public static double formula(double z) {
        return round((z + Math.sqrt(4.0 + Math.pow(z, 2))) / 2.0);
    }

    // Calcula el valor recursivo f(z,25)/f(z,24)
    public static double recursive(double z) {
        return round(recursive(z, (int) N) / recursive(z, (int) N - 1));
    }

    // Calcula el valor iterativo f(z,25)/f(z,24)
    public static double iterative(double z) {
        return round(iterative(z, (int) N) / iterative(z, (int) N - 1));
    }

    // -----------------------------
    // Métodos privados (sección Errors / Improvement / Update)
    // -----------------------------

    // Implementación recursiva de f(z, n)
    // f(z,0) = 1, f(z,1) = 1, f(z,n) = z*f(z,n-1) + f(z,n-2)
    private static double recursive(double z, int n) {
        if (n == 0 || n == 1)
            return 1.0;
        return z * recursive(z, n - 1) + recursive(z, n - 2);
    }

    // Implementación iterativa (sin recursión)
    private static double iterative(double z, int n) {
        if (n == 0 || n == 1)
            return 1.0;

        double prev2 = 1.0; // f(z,0)
        double prev1 = 1.0; // f(z,1)

        for (int i = 2; i <= n; i++) {
            double cur = z * prev1 + prev2; // f(z,i)
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1; // f(z,n)
    }

    // Método para redondear a 10 decimales
    private static double round(double value) {
        double ROUND = 10000000000.0; // 10^10
        return Math.round(value * ROUND) / ROUND;
    }

    // -----------------------------
    // MAIN (no se debe modificar)
    // -----------------------------
    public static void main(String[] args) {
        String[] metallics = {
                "Platinum", // [0]
                "Golden",   // [1]
                "Silver",   // [2]
                "Bronze",   // [3]
                "Copper",   // [4]
                "Nickel",   // [5]
                "Aluminum", // [6]
                "Iron",     // [7]
                "Tin",      // [8]
                "Lead",     // [9]
        };
        for (var z = 0; z < metallics.length; z++) {
            System.out.println("\n[" + z + "] " + metallics[z]);
            System.out.println(" ↳ formula(" + z + ")   ≈ " + formula(z));
            System.out.println(" ↳ recursive(" + z + ") ≈ " + recursive(z));
            System.out.println(" ↳ iterative(" + z + ") ≈ " + iterative(z));
        }
    }
}

