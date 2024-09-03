public class EquacaoSegundoGrau {

    private double a;
    private double b;
    private double c;

    public EquacaoSegundoGrau(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("O coeficiente 'a' não pode ser zero em uma equação do segundo grau.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void calcularRaizes() {
        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            // Duas raízes reais e distintas
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.printf("Raízes: %.2f e %.2f%n", raiz1, raiz2);
        } else if (discriminante == 0) {
            // Uma raiz real (raízes iguais)
            double raiz = -b / (2 * a);
            System.out.printf("Raiz: %.2f%n", raiz);
        } else {
            // Discriminante negativo, raízes complexas
            double parteReal = -b / (2 * a);
            double parteImaginaria = Math.sqrt(-discriminante) / (2 * a);
            System.out.printf("Raízes complexas: %.2f ± %.2fi%n", parteReal, parteImaginaria);
        }
    }

    @Override
    public String toString() {
        return String.format("%.2fx^2 + %.2fx + %.2f = 0", a, b, c);
    }

    public static void main(String[] args) {
        // Exemplo de uso:
        EquacaoSegundoGrau eq = new EquacaoSegundoGrau(1, -3, 2);
        System.out.println(eq);
        eq.calcularRaizes();
    }
}
