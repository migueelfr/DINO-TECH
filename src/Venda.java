import java.util.Date;

public class Venda {
    private Cliente cliente;
    private Carrinho carrinho;
    private FormaPagamento formaPagamento;
    private Date data;

    public Venda(Cliente cliente, Carrinho carrinho, FormaPagamento formaPagamento) {
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.formaPagamento = formaPagamento;
        this.data = new Date();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void realizarVenda() {
        formaPagamento.pagar();
        System.out.println("Venda realizada com sucesso!");
    }

    @Override
    public String toString() {
        return "Venda [cliente=" + cliente + ", carrinho=" + carrinho + ", formaPagamento=" + formaPagamento + ", data="
                + data + "]";
    }
}