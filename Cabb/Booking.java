package Cabb;
import  Mainwindow.MainWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;





public class Booking extends JFrame {
       public Booking(MainWindow mainWindow) {
    	   this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	   this.setTitle("Welcome to Taxi Aid");
    	   this.setResizable(false);
           this. setSize(500, 400); 
           this.setLocationRelativeTo(null);
			
       
           
           
           
           
           this.addWindowListener(new WindowAdapter() {
        	   @Override
    			public void windowClosing(WindowEvent e) {
        	   
        	   int result = JOptionPane.showConfirmDialog(Booking.this, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    			
    			if(result == JOptionPane.YES_OPTION) {
    				Booking.this.dispose();
    			}
        	   }
           
           });
           
           
           
           
           
           
           
           JPanel mainPanel = new JPanel();
           mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
           mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
           mainPanel.setBackground(Color.WHITE);
          
           
           
           
           
           
           
           
           
           JLabel la = new JLabel("Login or Signup");
           la.setAlignmentX(Component.CENTER_ALIGNMENT);
           la.setFont(new Font("Arial", Font.BOLD, 22));
           mainPanel.add(la);
           
          
           
           JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 70));
           buttonPanel.setOpaque(false);
           
           
    	   
           JButton loginButton = new JButton("Login");
           loginButton.setFocusable(false);
           loginButton.setBorder(null);
           loginButton.setBackground(new Color(252, 128, 5));
           loginButton.setForeground(new Color(227,230,236));
           loginButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
           loginButton.setPreferredSize(new Dimension(110, 40));
           
           
           
           JButton signUpButton = new JButton("Sign Up");
           signUpButton.setFocusable(false);
           signUpButton.setBorder(null);
           signUpButton.setBackground(new Color(9, 79, 208));
           signUpButton.setForeground(new Color(227,230,236));
           signUpButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
           signUpButton.setPreferredSize(new Dimension(110, 40));
           
           JTextField emailField = new JTextField(5);
           
           
           //Radio Buttons
           ButtonGroup gr = new ButtonGroup();

           JRadioButton fr = new JRadioButton("Female");
           fr.setFocusable(false);
           fr.setPreferredSize(new Dimension(100, 30));
           fr.setOpaque(false);
           
           JRadioButton mr = new JRadioButton("Male");
           mr.setFocusable(false);
           mr.setPreferredSize(new Dimension(100,30));
           mr.setOpaque(false);
           
           
           
           JPanel term = new JPanel(new FlowLayout(FlowLayout.LEFT));
           term.setOpaque(false);
           
           JCheckBox checkBox = new JCheckBox("I accept the terms and Condtions");
           checkBox.setSelected(true);
           checkBox.setFocusable(false);
           checkBox.setOpaque(false);
           term.add(checkBox);
          
           
           
           
           
           JTextField usernameField = new JTextField(5);
           usernameField.addFocusListener(new FocusAdapter() {
               
               public void focusLost(FocusEvent e){
                   boolean nameTest = isValidName(usernameField.getText());
                   if(nameTest){
                	   usernameField.setBackground(Color.WHITE);
                   }
                   else{
                	   usernameField.setBackground(Color.RED); // Set background color to red for an invalid input
                       JOptionPane.showMessageDialog(null, "Invalid name format. Please enter a valid name.");
                   }
               }
           });
                    
           
           JPasswordField passwordField = new JPasswordField(5);
           passwordField.setEchoChar('*');
           passwordField.addKeyListener(new KeyAdapter() {
               
               public void keyTyped(KeyEvent e){
                   char c = e.getKeyChar();
                   System.out.print(c);
               }
           });
           
           
           
           
           
           
           ExAdmins reg = new ExAdmins();
           NewAdmins register = new NewAdmins();
           
           signUpButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	    	JDialog dialog = new JDialog();
        	        dialog.setTitle("Sign Up");
        	        dialog.setLayout(new BorderLayout());
        	        dialog.setResizable(false);
        	    	
        	        JPanel panel = new JPanel();
        	        //panel.setLayout(new GridLayout(0, 2));
        	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        	        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        	        panel.setPreferredSize(new Dimension(450, 300));
        	        

        	       /** JTextField nameInput = new JTextField(10);
        	        JTextField emailInput = new JTextField(10);
        	        JTextField phoneInput = new JTextField(10);
        	        JTextField passwordInput = new JTextField(10);**/

        	        
        	        JRadioButton maleRadio = new JRadioButton("Male");
        	        JRadioButton femaleRadio = new JRadioButton("Female");
        	        ButtonGroup genderGroup = new ButtonGroup();
        	        genderGroup.add(maleRadio);
        	        genderGroup.add(femaleRadio);
        	        JPanel genderPanel = new JPanel();
        	        genderPanel.add(maleRadio);
        	        genderPanel.add(femaleRadio);
        	        
        	        

        	        JCheckBox termsCheckbox = new JCheckBox("I accept the terms and conditions");
                    termsCheckbox.setAlignmentX(LEFT_ALIGNMENT);
        	        JPanel bt = new JPanel();
        	        JButton sub = new JButton("Submit");
        	        sub.setBackground(new Color(204,227,10));
        	        sub.setForeground(Color.WHITE);
        	        sub.setBorder(null);
        	        sub.setFocusable(false);
        	        sub.setPreferredSize(new Dimension(100, 30));
        	        
        	        
        	        JButton cancel = new JButton("Cancel");
        	        cancel.setBackground(new Color(122,10,227)); 
        	        cancel.setForeground(Color.WHITE);
        	        cancel.setBorder(null);
        	        cancel.setFocusable(false);
        	        cancel.setPreferredSize(new Dimension(100, 30));
        	        
        	        JTextField nameInput = new JTextField(20);
        	        nameInput.setAlignmentX(Component.LEFT_ALIGNMENT);
        	        

        	        JTextField emailInput = new JTextField(20);
        	        emailInput.setAlignmentX(Component.LEFT_ALIGNMENT);
        	        

        	        JTextField phoneInput = new JTextField(20);
        	        phoneInput.setAlignmentX(Component.LEFT_ALIGNMENT);

        	        JPasswordField passwordInput = new JPasswordField(20);
        	        passwordInput.setAlignmentX(Component.LEFT_ALIGNMENT);
        	        passwordInput.setEchoChar('*');
        	           passwordInput.addKeyListener(new KeyAdapter() {
        	               
        	               public void keyTyped(KeyEvent e){
        	                   char c = e.getKeyChar();
        	                   System.out.print(c);
        	               }
        	           });
        	        
        	        
        	        
        	        dialog.add(panel, BorderLayout.CENTER);
        	        


        	        panel.add(new JLabel("Name:"));
        	        panel.add(nameInput);
        	        panel.add(new JLabel("Email:"));
        	        panel.add(emailInput);
        	        panel.add(new JLabel("Phone Number:"));
        	        panel.add(phoneInput);
        	        panel.add(new JLabel("Password:"));
        	        panel.add(passwordInput);
        	        panel.add(termsCheckbox);
        	        panel.add(genderPanel);
        	 

        	        bt.add(sub);
        	        bt.add(cancel);
        	        panel.add(bt);

        	        dialog.add(panel, BorderLayout.CENTER);
        	        sub.addActionListener(new ActionListener() {
        	            public void actionPerformed(ActionEvent e) {
        	                String name = nameInput.getText();
        	                String password = passwordInput.getText();
        	                String email = emailInput.getText();
        	                String phoneNumber = phoneInput.getText().trim();
        	                String gender;

        	                if (maleRadio.isSelected()) {
        	                    gender = "Male";
        	                } else if (femaleRadio.isSelected()) {
        	                    gender = "Female";
        	                } else {
        	                    JOptionPane.showMessageDialog(Booking.this, "Please select a gender.", "Warning", JOptionPane.WARNING_MESSAGE);
        	                    return;
        	                }

        	                if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || (!maleRadio.isSelected() && !femaleRadio.isSelected()) || !termsCheckbox.isSelected()) {
        	                    JOptionPane.showMessageDialog(Booking.this, "Please fill in all fields and accept the terms.", "Warning", JOptionPane.WARNING_MESSAGE);
        	                } else {
        	                    // Ensure phone number is exactly 10 digits
        	                    if (!phoneNumber.matches("\\d{10}")) {
        	                        JOptionPane.showMessageDialog(Booking.this, "Please enter a valid phone number.", "Warning", JOptionPane.WARNING_MESSAGE);
        	                        return;
        	                    }
                                
        	                    try {
        	                        Long phone = Long.parseLong(phoneNumber);
        	                        NewUser add = new NewUser(name, password, email, gender, phone);
        	                        register.Addmin(add);
        	                        JOptionPane.showMessageDialog(Booking.this, "Sign up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        	                        dialog.dispose();
									mainWindow.setVisible(true);
									dispose();
        	                      //  MainWindow mw = new MainWindow();
        	                       // mw.main();
        	                        //new MainWindow().setVisible(true);
        	                        //mw.main(); 
        	                    } catch (NumberFormatException ex) {
        	                        JOptionPane.showMessageDialog(Booking.this, "Please enter a valid phone number.", "Warning", JOptionPane.WARNING_MESSAGE);
        	                    }
        	                }
        	            }
        	        });

        	        cancel.addActionListener(new ActionListener() {
        	            @Override
        	            public void actionPerformed(ActionEvent e) {
        	                nameInput.setText("");
        	                emailInput.setText("");
        	                phoneInput.setText("");
        	                passwordInput.setText("");
        	                genderGroup.clearSelection();
        	                termsCheckbox.setSelected(false);
        	                dialog.dispose();
        	            }
        	        });
        	        
        	        dialog.pack();
        	        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	        dialog.setLocationRelativeTo(null); // Center the dialog on the screen
        	        dialog.setVisible(true);
        	    }
        	});
        	            
        	            

        	            
           
          /** JButton sub = new JButton("Submit");
           sub.setFocusable(false);
           sub.setPreferredSize(new Dimension(100, 30));
           
           JButton cancelButton = new JButton("Cancel");
           cancelButton.setFocusable(false);
           cancelButton.setPreferredSize(new Dimension(100, 30));**/
           
           
        	        	    
        	   
           
           
           
    	   
           loginButton.addActionListener(new ActionListener() {
               
               public void actionPerformed(ActionEvent e) {
            	   JPanel panel = new JPanel();
                   panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                   JTextField usernameInput = new JTextField(15);
                   JPasswordField passwordInput = new JPasswordField(15);

                   panel.add(new JLabel("Username:"));
                   panel.add(usernameInput);
                   panel.add(new JLabel("Password:"));
                   panel.add(passwordInput);
                   

                   int result = JOptionPane.showConfirmDialog(Booking.this, panel, "Login", JOptionPane.OK_CANCEL_OPTION);

                   if (result == JOptionPane.OK_OPTION) {
                       String username = usernameInput.getText();
                       String password = new String(passwordInput.getPassword());

                       if (username.isEmpty() || password.isEmpty()) {
                           JOptionPane.showMessageDialog(Booking.this, "Please fill in both username and password.", "Warning", JOptionPane.WARNING_MESSAGE);
                           
                       } else {
                           // Perform login validation here
                    	   boolean isValidName = (username) != null;
                    	   //Admins add = new Admins(username, password);
                    	 boolean val =  reg.validateLogin(username,password);
                           if (isValidName) {
                        	   if (val) {
                                   JOptionPane.showMessageDialog(Booking.this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
								   mainWindow.setVisible(true);
								   dispose();
                                  // MainWindow mw = new MainWindow();
                                  // mw.main();
                                  // MainWindow mw = new MainWindow();
                             //      new MainWindow().setVisible(true);
							 return;
                        	   }
                        	   
                              else {
                               JOptionPane.showMessageDialog(Booking.this, "Invalid username or password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                               
                           }
                       }
                   }
               }
               }});
           buttonPanel.add(loginButton);
           buttonPanel.add(signUpButton);
           //buttonPanel.add(sub);
           //buttonPanel.add(cancelButton);
           mainPanel.add(buttonPanel);
           add(mainPanel);
           }
           
           
           public boolean isValidName(String name) {
          	    
               if(!name.matches("[a-zA-Z ]+") || name.length()<2){
                   return false;
               }
               return true;
           
       
           
    	   
       }
}

           

