public class Esfera {
    double raio;
    Vetor centro;

    public Esfera(double raio, Vetor centro) {
        this.raio = raio;
        this.centro = centro;
    }

    boolean Colidir(Vetor p0, Vetor dr) {
        Vetor w = p0.Subtracao(centro);
        double a = dr.ProdutoEscalar(dr);
        double b = w.ProdutoEscalar(dr) * 2;
        double c = w.ProdutoEscalar(w) - raio*raio;
        return b * b - (4 * a * c) > 0;
    }
}
