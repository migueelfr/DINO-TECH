import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemVenda> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemVenda item : itens) {
            total += item.calcularTotal();
        }
        return total;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ItemVenda item : itens) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total: R$ ").append(calcularTotal());
        return sb.toString();
    }
}

