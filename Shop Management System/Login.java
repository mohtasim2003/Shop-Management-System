import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import Classes.*; // Make sure this package exists with Shop and ShortpassException

public class Login extends JFrame implements ActionListener, MouseListener {

    JLabel username, password, loginMsg, frameImage, login, sms;
    JPanel leftPanel;
    JButton loginButton, resetButton, exit1;
    JTextField usernameField;
    JPasswordField userPasswordField;
    Font font;

    public Login() {

        font = new Font("Book Antiqua", 0, 18);

        this.setTitle("Shop Management System");
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Left panel
        leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 480, 800);
        leftPanel.setBackground(new Color(0, 204, 0));
        leftPanel.setLayout(null);
        this.add(leftPanel);

        ImageIcon img = new ImageIcon("Icon/download.png");
        frameImage = new JLabel(img);
        frameImage.setBounds(0, 50, 480, 800);
        leftPanel.add(frameImage);

        sms = new JLabel("Shop Management System");
        sms.setBounds(20, 50, 500, 40);
        sms.setForeground(new Color(255, 255, 255));
        sms.setFont(new Font("Algerian", 0, 32));
        leftPanel.add(sms);

        // Username label
        username = new JLabel("Username :");
        username.setBounds(502, 300, 247, 32);
        username.setForeground(new Color(0, 0, 51));
        username.setFont(font);
        this.add(username);

        // Login Page title
        login = new JLabel("Login Page");
        login.setOpaque(true);
        login.setBounds(502, 50, 247, 32);
        login.setForeground(new Color(0, 0, 51));
        login.setFont(new Font("Book Antiqua", 0, 24));
        this.add(login);

        // Password label
        password = new JLabel("Password :");
        password.setBounds(502, 370, 247, 32);
        password.setForeground(new Color(0, 0, 51));
        password.setFont(font);
        this.add(password);

        // Message label
        loginMsg = new JLabel();
        loginMsg.setBounds(635, 600, 450, 32);
        loginMsg.setForeground(Color.BLACK);
        loginMsg.setFont(font);
        this.add(loginMsg);

        // Username field
        usernameField = new JTextField();
        usernameField.setBounds(645, 304, 285, 32);
        usernameField.setFont(font);
        usernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        this.add(usernameField);

        // Password field
        userPasswordField = new JPasswordField();
        userPasswordField.setBounds(645, 374, 285, 32);
        userPasswordField.setFont(font);
        userPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        this.add(userPasswordField);

        // Login button
        loginButton = new JButton("Log In");
        loginButton.setBounds(635, 570, 95, 35);
        loginButton.setBackground(new Color(0, 204, 0));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(font);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.addMouseListener(this);
        this.add(loginButton);

        // Reset button
        resetButton = new JButton("Reset");
        resetButton.setBounds(765, 570, 95, 35);
        resetButton.setBackground(new Color(0, 204, 0));
        resetButton.setForeground(Color.WHITE);
        resetButton.setFont(font);
        resetButton.addActionListener(this);
        resetButton.addMouseListener(this);
        this.add(resetButton);

        // Exit button
        exit1 = new JButton("Exit");
        exit1.setBounds(895, 570, 95, 35);
        exit1.setBackground(new Color(255, 0, 0));
        exit1.setForeground(Color.WHITE);
        exit1.setFont(font);
        exit1.addActionListener(this);
        exit1.addMouseListener(this);
        this.add(exit1);
    }

    // MouseListener methods
    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == loginButton) {
            loginButton.setBackground(Color.WHITE);
            loginButton.setForeground(new Color(0, 204, 0));
        } else if (me.getSource() == resetButton) {
            resetButton.setBackground(Color.WHITE);
            resetButton.setForeground(new Color(0, 204, 0));
        } else if (me.getSource() == exit1) {
            exit1.setBackground(Color.WHITE);
            exit1.setForeground(new Color(255, 0, 0));
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == loginButton) {
            loginButton.setBackground(new Color(0, 204, 0));
            loginButton.setForeground(Color.WHITE);
        } else if (me.getSource() == resetButton) {
            resetButton.setBackground(new Color(0, 204, 0));
            resetButton.setForeground(Color.WHITE);
        } else if (me.getSource() == exit1) {
            exit1.setBackground(new Color(255, 0, 0));
            exit1.setForeground(Color.WHITE);
        }
    }

    // ActionListener
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            usernameField.setText(null);
            userPasswordField.setText(null);
            loginMsg.setText(null);
        }

        if (e.getSource() == loginButton) {
            String adminUsername = usernameField.getText();
            String adminPassword = String.valueOf(userPasswordField.getPassword());
            try {
                if (adminPassword.length() == 3) {
                    if (adminUsername.equals("123") && adminPassword.equals("123")) {
                        showMessageDialog(null, "Log in Successful");
                        Shop s = new Shop(this);
                        s.setVisible(true);
                        this.setVisible(false);
                    } else {
                        showMessageDialog(null, "Incorrect Username or Password! Please Try again!");
                    }
                } else {
                    throw new ShortpassException();
                }
            } catch (ShortpassException se) {
                showMessageDialog(null, se.getMessage());
            }
        }

        if (e.getSource() == exit1) {
            System.exit(0);
        }
    }
}
