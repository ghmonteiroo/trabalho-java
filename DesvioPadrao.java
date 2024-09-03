import java.util.List;

public class DesvioPadrao {

    private List<Double> dados;

    public DesvioPadrao(List<Double> dados) {
        if (dados == null || dados.isEmpty()) {
            throw new IllegalArgumentException("A lista de dados não pode ser nula ou vazia.");
        }
        this.dados = dados;
    }

    private double calcularMedia() {
        double soma = 0.0;
        for (double dado : dados) {
            soma += dado;
        }
        return soma / dados.size();
    }

    public double calcularDesvioPadrao(boolean amostral) {
        double media = calcularMedia();
        double somaQuadrados = 0.0;
        for (double dado : dados) {
            somaQuadrados += Math.pow(dado - media, 2);
        }

        int divisor = amostral ? dados.size() - 1 : dados.size();
        return Math.sqrt(somaQuadrados / divisor);
    }

    @Override
    public String toString() {
        return String.format("Dados: %s\nDesvio padrão amostral: %.2f\nDesvio padrão populacional: %.2f",
                             dados, calcularDesvioPadrao(true), calcularDesvioPadrao(false));
    }

    public static void main(String[] args) {
        // Exemplo de uso:
        List<Double> dados = List.of(10.0, 12.0, 23.0, 23.0, 16.0, 23.0, 21.0, 16.0);
        DesvioPadrao desvio = new DesvioPadrao(dados);
        
        System.out.println(desvio);
        System.out.printf("Desvio padrão amostral: %.2f%n", desvio.calcularDesvioPadrao(true));
        System.out.printf("Desvio padrão populacional: %.2f%n", desvio.calcularDesvioPadrao(false));
    }
}
