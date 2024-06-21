import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaDePagamento extends JFrame {
    private Carrinho carrinho;

    public TelaDePagamento(Carrinho carrinho) {
        this.carrinho = carrinho;
        Color corDestaque = new Color(255, 0, 0);
        Color corTexto = new Color(0, 0, 5);
        setTitle("Pagamento");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JLabel label = new JLabel("Tela de Pagamento", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setOpaque(true);
        label.setBackground(corDestaque);
        label.setForeground(Color.WHITE);
        add(label, BorderLayout.NORTH);


        JPanel pagamentoPanel = new JPanel();
        pagamentoPanel.setLayout(new BoxLayout(pagamentoPanel, BoxLayout.Y_AXIS));
        pagamentoPanel.setBackground(Color.WHITE);
        pagamentoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Font fonteCampos = new Font("Arial", Font.PLAIN, 14);

        JLabel cartaoLabel = new JLabel("Número do Cartão:");
        cartaoLabel.setFont(fonteCampos);
        cartaoLabel.setForeground(corTexto);
        pagamentoPanel.add(cartaoLabel);

        JTextField cartaoField = new JTextField();
        PlainDocument docCartao = (PlainDocument) cartaoField.getDocument();
        docCartao.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d*") && (fb.getDocument().getLength() + text.length()) <= 16) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*") && (fb.getDocument().getLength() + string.length()) <= 16) {
                    super.insertString(fb, offset, string, attr);
                }
            }
        });
        cartaoField.setFont(fonteCampos);
        cartaoField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pagamentoPanel.add(cartaoField);

        pagamentoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel nomeLabel = new JLabel("Nome no Cartão:");
        nomeLabel.setFont(fonteCampos);
        nomeLabel.setForeground(corTexto);
        pagamentoPanel.add(nomeLabel);

        JTextField nomeField = new JTextField();
        PlainDocument docNome = (PlainDocument) nomeField.getDocument();
        docNome.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z ]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[a-zA-Z ]*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }
        });
        nomeField.setFont(fonteCampos);
        nomeField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pagamentoPanel.add(nomeField);

        pagamentoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setFont(fonteCampos);
        cpfLabel.setForeground(corTexto);
        pagamentoPanel.add(cpfLabel);

        JTextField cpfField = new JTextField();
        PlainDocument docCpf = (PlainDocument) cpfField.getDocument();
        docCpf.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d*") && (fb.getDocument().getLength() + text.length()) <= 11) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*") && (fb.getDocument().getLength() + string.length()) <= 11) {
                    super.insertString(fb, offset, string, attr);
                }
            }
        });
        cpfField.setFont(fonteCampos);
        cpfField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pagamentoPanel.add(cpfField);

        pagamentoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setFont(fonteCampos);
        cvvLabel.setForeground(corTexto);
        pagamentoPanel.add(cvvLabel);

        JTextField cvvField = new JTextField();
        PlainDocument docCvv = (PlainDocument) cvvField.getDocument();
        docCvv.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d*") && (fb.getDocument().getLength() + text.length()) <= 3) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*") && (fb.getDocument().getLength() + string.length()) <= 3) {
                    super.insertString(fb, offset, string, attr);
                }
            }
        });
        cvvField.setFont(fonteCampos);
        cvvField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pagamentoPanel.add(cvvField);

        pagamentoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel totalLabel = new JLabel("Valor Total:");
        totalLabel.setFont(fonteCampos);
        totalLabel.setForeground(corTexto);
        pagamentoPanel.add(totalLabel);

        JTextField totalField = new JTextField(String.format("R$ %.2f", carrinho.calcularTotal()));
        totalField.setFont(fonteCampos);
        totalField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        totalField.setEditable(false);
        pagamentoPanel.add(totalField);

        add(pagamentoPanel, BorderLayout.CENTER);

        JButton escolherPagamentoButton = new JButton("Escolher Forma de Pagamento");
        escolherPagamentoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] opcoesPagamento = {"Cartão de Crédito", "Boleto", "Pix"};
                String formaPagamento = (String) JOptionPane.showInputDialog(null,
                        "Escolha a forma de pagamento:", "Forma de Pagamento", JOptionPane.QUESTION_MESSAGE, null, opcoesPagamento, opcoesPagamento[0]);
                switch (formaPagamento) {
                    case "Boleto":
                        mostrarTelaBoleto();
                        break;
                    case "Pix":
                        mostrarTelaPix();
                        break;
                }
            }
        });

        pagamentoPanel.add(escolherPagamentoButton);

        JButton pagarButton = new JButton("Pagar");
        pagarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verifica se algum dos campos está vazio
                if (cartaoField.getText().trim().isEmpty() ||
                        nomeField.getText().trim().isEmpty() ||
                        cpfField.getText().trim().isEmpty() ||
                        cvvField.getText().trim().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Por favor, complete todos os campos do cartão.");
                } else {
                    FormaPagamento pagamento = new PagamentoCartao(carrinho.calcularTotal(), cartaoField.getText(), nomeField.getText(), cpfField.getText(), cvvField.getText());
                    pagamento.pagar();
                    JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso!");
                    new TelaInicial().setVisible(true);

                }
            }
        });

        add(pagarButton, BorderLayout.SOUTH);
        add(pagamentoPanel, BorderLayout.CENTER);
    }

        private void mostrarTelaBoleto() {
            JDialog boletoDialog = new JDialog(this, "Pagamento com Boleto", true);
            boletoDialog.setSize(400, 600);
            boletoDialog.setLayout(new BorderLayout());
            JButton copiarButton = new JButton("Copiar Código");
            copiarButton.addActionListener(event -> {
                String codigoPix = "7891234567895";
                StringSelection stringSelection = new StringSelection(codigoPix);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                JOptionPane.showMessageDialog(boletoDialog, "Código do Boleto copiado!");
            });

            JLabel boletoLabel = new JLabel("Código de Barras do Boleto", SwingConstants.CENTER);
            boletoLabel.setFont(new Font("Arial", Font.BOLD, 16));
            boletoDialog.add(boletoLabel, BorderLayout.NORTH);

            ImageIcon barcodeIcon = new ImageIcon("src/barcode.png");

            JLabel barcodeLabel = new JLabel(barcodeIcon);
            barcodeLabel.setHorizontalAlignment(JLabel.CENTER);
            boletoDialog.add(barcodeLabel, BorderLayout.CENTER);

            JButton fecharButton = new JButton("Fechar");
            fecharButton.addActionListener(event -> boletoDialog.dispose());
            boletoDialog.add(fecharButton, BorderLayout.SOUTH);

            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
            bottomPanel.add(copiarButton);
            boletoDialog.add(bottomPanel, BorderLayout.SOUTH);

            boletoDialog.setLocationRelativeTo(this);
            boletoDialog.setVisible(true);
            boletoDialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    FormaPagamento boleto = new PagamentoBoleto(carrinho.calcularTotal(), "", true );
                    boleto.pagar();
                    JOptionPane.showMessageDialog(boletoDialog, "Pagamento concluído");
                    new TelaInicial().setVisible(true);
                }
            });


            dispose();
        }


    private void mostrarTelaPix() {
        JDialog pixDialog = new JDialog(this, "Pagamento com Pix", true);
        pixDialog.setSize(400, 600);
        pixDialog.setLayout(new BorderLayout());
        JButton copiarButton = new JButton("Copiar Código");
        copiarButton.addActionListener(event -> {
            String codigoPix = "123e4567-e89b-12d3-a456-426614174000";
            StringSelection stringSelection = new StringSelection(codigoPix);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            JOptionPane.showMessageDialog(pixDialog, "Código do Pix copiado!");
        });
        pixDialog.add(copiarButton, BorderLayout.EAST);
        JLabel pixLabel = new JLabel("QR Code do Pix", SwingConstants.CENTER);
        pixLabel.setFont(new Font("Arial", Font.BOLD, 16));
        pixDialog.add(pixLabel, BorderLayout.NORTH);

        ImageIcon qrCodeIcon = new ImageIcon("src/qr-code.png");

        JLabel qrCodeLabel = new JLabel(qrCodeIcon);
        qrCodeLabel.setHorizontalAlignment(JLabel.CENTER);
        pixDialog.add(qrCodeLabel, BorderLayout.CENTER);

        JButton fecharButton = new JButton("Fechar");
        fecharButton.addActionListener(event -> pixDialog.dispose());
        pixDialog.add(fecharButton, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.add(fecharButton);
        bottomPanel.add(copiarButton);
        pixDialog.add(bottomPanel, BorderLayout.SOUTH);

        pixDialog.setLocationRelativeTo(this);
        pixDialog.setVisible(true);
        pixDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                FormaPagamento pix = new PagamentoPix(carrinho.calcularTotal(), true);
                pix.pagar();
                JOptionPane.showMessageDialog(pixDialog, "Pagamento concluído");
                new TelaInicial().setVisible(true);
            }
        });


        dispose();
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Carrinho carrinho = new Carrinho();
            new TelaDePagamento(carrinho).setVisible(true);
        });
    }
}

