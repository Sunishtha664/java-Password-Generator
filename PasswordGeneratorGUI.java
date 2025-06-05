import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame{
    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
        setTitle("Password Generator");
        setSize(540,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        passwordGenerator = new PasswordGenerator();

        addGUIComponents();
    }
    public void addGUIComponents(){
        JLabel titlelabel = new JLabel("Password Generator");
        titlelabel.setFont(new Font("Serif", Font.BOLD, 32));
        titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlelabel.setBounds(0, 20, 540, 40);
        add(titlelabel);

        //passwordoutput area
        JTextArea passwordoutput = new JTextArea();
        passwordoutput.setEditable(false);
        passwordoutput.setFont(new Font("Serif", Font.PLAIN, 25));

        JScrollPane passwordoutputpane = new JScrollPane(passwordoutput);
        passwordoutputpane.setBounds(30, 80, 480, 80);
        passwordoutputpane.setBorder(BorderFactory.createLineBorder(Color.black));
        add(passwordoutputpane);

        //passwordlength
        // Password Length Label
        JLabel passwordlengthlabel = new JLabel("Password Length:");
        passwordlengthlabel.setFont(new Font("Serif", Font.PLAIN, 25));
        passwordlengthlabel.setBounds(30, 190, 220, 40);  // Reduced width to 220
        add(passwordlengthlabel);
        // Password Length Input Area
        JTextArea passwordlengthinputarea = new JTextArea();
        passwordlengthinputarea.setFont(new Font("Serif", Font.PLAIN, 25));
        passwordlengthinputarea.setBorder(BorderFactory.createLineBorder(Color.black));
        passwordlengthinputarea.setBounds(210, 190, 100, 40);  // Aligned vertically with label
        add(passwordlengthinputarea);

        //buttons
        //uppercase
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setBounds(30, 280, 230, 50);// Top-left
        uppercaseToggle.setFont(new Font("Serif", Font.PLAIN, 20));
        add(uppercaseToggle);
        //lowercase
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setBounds(280, 280, 230, 50);  // Top-right
        lowercaseToggle.setFont(new Font("Serif", Font.PLAIN, 20));
        add(lowercaseToggle);
        //number
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setBounds(30, 350, 230, 50);  // Bottom-left
        numbersToggle.setFont(new Font("Serif", Font.PLAIN, 20));
        add(numbersToggle);
        //symbol
        JToggleButton symbolToggle = new JToggleButton("Special Symbols");
        symbolToggle.setBounds(280, 350, 230, 50);  // Bottom-right
        symbolToggle.setFont(new Font("Serif", Font.PLAIN, 20));
        add(symbolToggle);


        //generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Serif", Font.PLAIN, 20));
        generateButton.setBounds(155, 420, 230, 50);
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            if(passwordlengthinputarea.getText().length() <=0){return;}
            boolean anyToggleSelected = uppercaseToggle.isSelected()||
                    lowercaseToggle.isSelected()||numbersToggle.isSelected()
                    ||symbolToggle.isSelected();

            //generate password
                int passwordlength = Integer.parseInt(passwordlengthinputarea.getText());//converts text into integer value
                if(anyToggleSelected){
                    String generatedPassword=PasswordGenerator.generatePassword(passwordlength,
                            uppercaseToggle.isSelected(),lowercaseToggle.isSelected(),numbersToggle.isSelected(),
                            symbolToggle.isSelected());

                    //display password back to the user
                    passwordoutput.setText(generatedPassword);
                }

            }

        });
        add(generateButton);

    }
}

