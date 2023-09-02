import java.awt.*;

public class Vetor {
    double vetorArray[] = new double[3];

    Vetor(double ...eixo ) {
        for (int i = 0; i < vetorArray.length; i++) {
            this.vetorArray[i] = eixo[i];
        }
    }

    Vetor Adicao(Vetor vetor2) {
        Vetor novo = new Vetor(vetorArray);
        for (int i = 0; i < vetorArray.length; i++ ) {
            novo.vetorArray[i] += vetor2.vetorArray[i];
        }
        return novo;
    }

    Vetor Subtracao(Vetor vetor2) {
        Vetor novo = new Vetor(vetorArray);
        for (int i = 0; i < vetorArray.length; i++ ) {
            novo.vetorArray[i] -= vetor2.vetorArray[i];
        }
        return novo;
    }

    Vetor MultiplicacaoConstante(double valor) {
        Vetor novo = new Vetor(vetorArray);
        for (int i = 0; i < vetorArray.length; i++ ) {
            novo.vetorArray[i] *= valor;
        }
        return novo;
    }

    Vetor DivisaoConstante(double valor) {
        Vetor novo = new Vetor(vetorArray);
        for (int i = 0; i < vetorArray.length; i++ ) {
            novo.vetorArray[i] /= valor;
        }
        return novo;
    }

    double ProdutoEscalar(Vetor vetor2) {
        double resultado = 0;
        for (int i = 0; i < vetorArray.length; i++ ) {
            resultado += vetorArray[i] * vetor2.vetorArray[i] ;
        }
        return resultado;
    }

    double Modulo() {
        return Math.sqrt(ProdutoEscalar(this));
    }

    Vetor Unitario() {
       return DivisaoConstante(Modulo());
    }

    public Color getCor(){
        int r = (int)Math.min(255*vetorArray[0], 255);
        int g = (int)Math.min(255*vetorArray[1], 255);
        int b = (int)Math.min(255*vetorArray[2], 255);

        Color cor = Color.BLACK;
        try{
            cor =  new Color(r,g,b);
        }
        catch(Exception e){
            //System.out.println(r+ " " + g + " "+b);
        }

        return cor;
    }

}
