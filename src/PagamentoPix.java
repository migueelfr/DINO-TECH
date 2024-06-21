import javax.swing.*;

public class PagamentoPix extends FormaPagamento {
    private boolean validacao;

    public PagamentoPix(double valor, boolean validacao) {
        super(valor);
        this.validacao = validacao;
    }

    @Override
    public void pagar() {
        JOptionPane.showMessageDialog(null,"Esperando escaneamento: ");
    }
    @Override
    public void validacao(boolean validacao){
        if (validacao) {
            JOptionPane.showMessageDialog(null,"Pagamento realizado com Pix:");
        }else{
            JOptionPane.showMessageDialog(null, "Falha no pagamento");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", qrCode: ";
    }
}

