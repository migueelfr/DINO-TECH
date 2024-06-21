import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarConta extends JFrame {
    public CriarConta() {
        setTitle("Criar Conta");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.setBackground(Color.WHITE);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        centerPanel.add(new JLabel("E-mail:"), gbc);
        JTextField emailField = new JTextField(20);
        centerPanel.add(emailField, gbc);

        centerPanel.add(new JLabel("Usuário:"), gbc);
        JTextField usuarioField = new JTextField(20);
        centerPanel.add(usuarioField, gbc);

        centerPanel.add(new JLabel("Senha:"), gbc);
        JPasswordField senhaField = new JPasswordField(20);
        centerPanel.add(senhaField, gbc);

        centerPanel.add(new JLabel("Data de Nascimento:"), gbc);
        JTextField dataNascField = new JTextField(20);
        centerPanel.add(dataNascField, gbc);

        JButton criarButton = new JButton("Criar");

        add(centerPanel, BorderLayout.CENTER);

        add(criarButton, BorderLayout.SOUTH);

        criarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());
                String dataNasc = dataNascField.getText();

                if (email.isEmpty() || usuario.isEmpty() || senha.isEmpty() || dataNasc.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                } else {
                    // Crie a conta aqui (se todos os campos estiverem preenchidos)
                    JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
                    dispose();
                }
            }
        });
    }
}
