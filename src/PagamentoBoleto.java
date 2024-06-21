import javax.swing.*;

public class PagamentoBoleto extends FormaPagamento {
    private String codigoBarras;
    private boolean validacao;

    public PagamentoBoleto(double valor, String codigoBarras, boolean validacao) {
        super(valor);
        this.codigoBarras = codigoBarras;
        this.validacao = validacao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void pagar() {
        JOptionPane.showMessageDialog(null,"Esperando escaneamento do boleto: " );
    }
    @Override
    public void validacao(boolean validacao){
        if (validacao == true) {
           JOptionPane.showMessageDialog(null,"Pagamento realizado com boleto: ");
        }else{
            JOptionPane.showMessageDialog(null, "Falha no pagamento");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Boleto: " + codigoBarras;
    }
}
