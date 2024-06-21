import javax.swing.*;

public class PagamentoCartao extends FormaPagamento {
    private String numeroCartao;
    private String nomeCartao;
    private String validade;
    private String cvv;

    public PagamentoCartao(double valor, String numeroCartao, String nomeCartao, String validade, String cvv) {
        super(valor);
        this.numeroCartao = numeroCartao;
        this.nomeCartao = nomeCartao;
        this.validade = validade;
        this.cvv = cvv;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public void pagar() {
        JOptionPane.showMessageDialog(null,"Esperando pagamento: ");
    }
    @Override
    public void validacao(boolean validacao){
        if (validacao == true) {
            JOptionPane.showMessageDialog(null,"Pagamento realizado com cartao: ");
        }else{
            JOptionPane.showMessageDialog(null, "Falha no pagamento");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Cartão: " + numeroCartao;
    }
}

