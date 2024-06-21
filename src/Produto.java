public class Produto {
    private String nome;
    private double preco;
    private int estoque;
    private String caminhoImagem;

    public Produto(String nome, double preco, int estoque, String caminhoImagem) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.caminhoImagem = caminhoImagem;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
