import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarrinhoDeCompras extends JFrame {
    private Carrinho carrinho;

    public CarrinhoDeCompras(Carrinho carrinho) {
        this.carrinho = carrinho;

        setTitle("Carrinho de Compras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Carrinho de Compras", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        JPanel carrinhoPanel = new JPanel(new GridLayout(0, 1, 10, 10));

        for (ItemVenda item : carrinho.getItens()) {
            JLabel itemLabel = new JLabel(item.getProduto().getNome() + " - Quantidade: " + item.getQuantidade() + " - Preço: R$ " + item.calcularTotal());
            carrinhoPanel.add(itemLabel);
        }

        add(new JScrollPane(carrinhoPanel), BorderLayout.CENTER);

        JLabel totalLabel = new JLabel("Total: R$ " + carrinho.calcularTotal(), SwingConstants.CENTER);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(totalLabel, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton backButton = new JButton("Voltar à Tela Inicial");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaInicial().setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(backButton);

        JButton checkoutButton = new JButton("Finalizar Compra");
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (carrinho.getItens().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seu carrinho está vazio. Adicione itens antes de finalizar a compra.");
                } else {
                    new TelaDePagamento(carrinho).setVisible(true);
                    dispose();
                }
            }
        });
        buttonPanel.add(checkoutButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Carrinho carrinho = new Carrinho();
            new CarrinhoDeCompras(carrinho).setVisible(true);
        });
    }
}