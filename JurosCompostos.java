public class JurosCompostos {

    private double principal;
    private double taxaJurosAnual;
    private int capitalizacoesPorAno;

    public JurosCompostos(double principal, double taxaJurosAnual, int capitalizacoesPorAno) {
        if (principal <= 0) {
            throw new IllegalArgumentException("O principal deve ser um valor positivo.");
        }
        if (taxaJurosAnual < 0 || taxaJurosAnual > 1) {
            throw new IllegalArgumentException("A taxa de juros anual deve estar entre 0 e 1.");
        }
        if (capitalizacoesPorAno <= 0) {
            throw new IllegalArgumentException("O número de capitalizações por ano deve ser positivo.");
        }
        this.principal = principal;
        this.taxaJurosAnual = taxaJurosAnual;
        this.capitalizacoesPorAno = capitalizacoesPorAno;
    }

    public double calcularMontante(double anos) {
        if (anos < 0) {
            throw new IllegalArgumentException("O número de anos deve ser não-negativo.");
        }
        double r = taxaJurosAnual;
        int n = capitalizacoesPorAno;
        double A = principal * Math.pow(1 + r / n, n * anos);
        return A;
    }

    @Override
    public String toString() {
        return String.format("Principal: R$%.2f\nTaxa de Juros Anual: %.2f%%\nCapitalizações por Ano: %d",
                             principal, taxaJurosAnual * 100, capitalizacoesPorAno);
    }

    public static void main(String[] args) {
        // Exemplo de uso:
        double principal = 1000; // Valor inicial investido ou emprestado
        double taxaJurosAnual = 0.05; // Taxa de juros anual de 5%
        int capitalizacoesPorAno = 12; // Juros capitalizados mensalmente

        JurosCompostos juros = new JurosCompostos(principal, taxaJurosAnual, capitalizacoesPorAno);
        double anos = 5; // Tempo em anos
        double montante = juros.calcularMontante(anos);

        System.out.println(juros);
        System.out.printf("Montante após %.2f anos: R$%.2f%n", anos, montante);
    }
}
