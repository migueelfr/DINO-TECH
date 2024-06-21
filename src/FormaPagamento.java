public abstract class FormaPagamento {
    private double valor;
    private boolean validacao = true;

    public FormaPagamento(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public abstract void pagar();

    public abstract void validacao(boolean validacao);

    @Override
    public String toString() {
        return "Valor: " + valor;
    }
}

