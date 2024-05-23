import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;

public class CookItGUI extends JFrame {

    private CookIt cookIt = new CookIt();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField UserInput;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CookItGUI frame = new CookItGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CookItGUI() {
    	setTitle("CookIt.com");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 550, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 153, 102));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("CookIt");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(232, 0, 70, 25);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Discover a recipe with ingredients you already have!");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(97, 25, 376, 18);
        contentPane.add(lblNewLabel_1);

        JButton btnViewIngr = new JButton("View Known Ingredients");
        btnViewIngr.setBackground(Color.LIGHT_GRAY);
        btnViewIngr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display known ingredients
                textArea.setText(cookIt.displayKnownIngredients());
            }
        });
        btnViewIngr.setBounds(10, 201, 133, 23);
        contentPane.add(btnViewIngr);

        JButton btnInput = new JButton("Reset");
        btnInput.setBackground(Color.LIGHT_GRAY);
        btnInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Reset user input and output fields
                UserInput.setText("");
                textArea.setText("");
                CookIt cookItss = new CookIt();
            }
        });
        btnInput.setBounds(169, 201, 133, 23);
        contentPane.add(btnInput);

        UserInput = new JTextField();
        UserInput.setBackground(new Color(255, 250, 240));
        UserInput.setBounds(10, 54, 292, 125);
        contentPane.add(UserInput);
        UserInput.setColumns(10);

        JButton btnIngredInput = new JButton("Enter Ingredients");
        btnIngredInput.setBackground(Color.LIGHT_GRAY);
        btnIngredInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Process user input ingredients
                String userInput = UserInput.getText();
                textArea.setText(cookIt.processUserInput(userInput));
            }
        });
        btnIngredInput.setBounds(10, 268, 133, 23);
        contentPane.add(btnIngredInput);

        JButton btnNewButton = new JButton("View Recipes");
        btnNewButton.setBackground(Color.LIGHT_GRAY);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display matching recipes
            	textArea.setText(cookIt.displayMatchingRecipes());
            }
        });
        btnNewButton.setBounds(169, 268, 133, 23);
        contentPane.add(btnNewButton);
        

        
        textArea = new JTextArea();
        textArea.setBackground(new Color(255, 250, 240));
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setBounds(1, 1, 60, 45);
        contentPane.add(textArea);
        
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(312, 54, 201, 296);
        contentPane.add(scrollPane);
    }
}
