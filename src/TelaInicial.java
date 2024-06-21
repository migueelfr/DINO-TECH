import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaInicial extends JFrame {
    private List<Produto> produtos;
    private Carrinho carrinho;

    public TelaInicial() {
        carrinho = new Carrinho();
        produtos = new ArrayList<>();
        produtos.add(new Produto("Processador Ryzen 7 5700x3d", 1200.00, 10, "src/imagem/amdryzen1.png"));
        produtos.add(new Produto("Memória RAM 16GB", 600.00, 20, "src/imagem/ram16gb1.png"));
        produtos.add(new Produto("Placa de Vídeo GTX 1660", 2500.00, 5, "src/imagem/gtx1.png"));
        produtos.add(new Produto("SSD NVME 512GB", 400.00, 15, "src/imagem/ssdd1.png"));
        produtos.add(new Produto("Fonte 600W", 300.00, 7, "src/imagem/fonte1.png"));
        produtos.add(new Produto("Gabinete Rise Aquário", 450.00, 12, "src/imagem/gabinete1.png"));
        produtos.add(new Produto("Placa Mãe ASUS TUF B550M", 800.00, 8, "src/imagem/placa1.png"));
        produtos.add(new Produto("Water Cooler", 150.00, 25, "src/imagem/cooler1.jpg"));
        produtos.add(new Produto("Mouse G PRO x SUPERLIGHT", 120.00, 30, "src/imagem/mouse1.jpg"));

        setTitle("Produtos Disponíveis");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Produtos Disponíveis", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        JPanel produtosPanel = new JPanel(new GridLayout(3, 3, 10, 10));

        for (Produto produto : produtos) {
            produtosPanel.add(criarPainelProduto(produto));
        }

        add(new JScrollPane(produtosPanel), BorderLayout.CENTER);

        JButton carrinhoButton = new JButton("Ir para Carrinho");
        carrinhoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CarrinhoDeCompras(carrinho).setVisible(true);
                dispose();
            }
        });

        add(carrinhoButton, BorderLayout.SOUTH);
    }

    private JPanel criarPainelProduto(Produto produto) {
        JPanel produtoPanel = new JPanel(new BorderLayout());

        ImageIcon icon = new ImageIcon(produto.getCaminhoImagem());
        JLabel imagemLabel = new JLabel(icon);
        produtoPanel.add(imagemLabel, BorderLayout.NORTH);

        JLabel produtoLabel = new JLabel("<html>" + produto.getNome() + "<br/>Preço: R$ " + produto.getPreco() + "</html>");
        produtoPanel.add(produtoLabel, BorderLayout.CENTER);

        JButton adicionarButton = new JButton("Adicionar ao Carrinho");
        adicionarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carrinho.adicionarItem(new ItemVenda(produto, 1));
                JOptionPane.showMessageDialog(null, produto.getNome() + " adicionado ao carrinho.");
            }
        });
        produtoPanel.add(adicionarButton, BorderLayout.SOUTH);

        return produtoPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaInicial().setVisible(true);
        });
    }
}
