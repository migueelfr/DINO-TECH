import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDeLogin extends JFrame {

    public TelaDeLogin() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ImageIcon imagemIcon = new ImageIcon("src/dinotech.png");
        Image image = imagemIcon.getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);

        JLabel imageLabel = new JLabel(imageIcon);
        headerPanel.add(imageLabel);

        JLabel label = new JLabel("Bem vindo a DinoTech", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(label);
        add(headerPanel, BorderLayout.NORTH);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        loginPanel.add(Box.createVerticalStrut(20));

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        userPanel.add(new JLabel("Usuário:"));
        JTextField usuarioField = new JTextField(15);
        userPanel.add(usuarioField);
        loginPanel.add(userPanel);

        JPanel passPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        passPanel.add(new JLabel("Senha:"));
        JPasswordField senhaField = new JPasswordField(15);
        passPanel.add(senhaField);
        loginPanel.add(passPanel);

        loginPanel.add(Box.createVerticalStrut(20));

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());

                if (usuario.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                } else {

                    new TelaInicial().setVisible(true);
                    dispose();
                }
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(loginButton);

        loginPanel.add(buttonPanel);

        add(loginPanel, BorderLayout.CENTER);


        JButton criarContaButton = new JButton("Criar Conta");
        criarContaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CriarConta().setVisible(true);
            }
        });

        buttonPanel.add(criarContaButton);


        class CriarConta extends JFrame {
            public CriarConta() {
                setTitle("Criar Conta");
                setSize(400, 300);
                setLayout(new GridLayout(5, 2, 10, 10)); // Layout com 5 linhas e 2 colunas

                add(new JLabel("E-mail:"));
                JTextField emailField = new JTextField();
                add(emailField);

                add(new JLabel("Usuário:"));
                JTextField usuarioField = new JTextField();
                add(usuarioField);


                add(new JLabel("Senha:"));
                JPasswordField senhaField = new JPasswordField();
                add(senhaField);

                add(new JLabel("Data de Nascimento:"));
                JTextField dataNascField = new JTextField();
                add(dataNascField);

                JButton criarButton = new JButton("Criar");
                criarButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    }
                });

                add(criarButton);
            }
        }
    }
        public static void main (String[]args){
            SwingUtilities.invokeLater(() -> {
                new TelaDeLogin().setVisible(true);
            });
        }
    }



