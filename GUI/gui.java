import javax.swing.*;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by mahmoudsafar on 4/17/17.
 */
public class gui {
    private JTextField usernameInput;
    private JPanel form;
    private JPasswordField passwordInput;
    private JButton loginButton;
    private JLabel errorLabel;
    private JTabbedPane navigation;
    private JButton refreshButton;
    private JButton inboxButton;

    //Navigation Tabs Indices --Not sure if needed but it does help...
    private int loginTab = 0;
    private int dashboardTab = 1;


    // private UserSystem userSystem;

    //Below should include all functions to be defined and triggered upon any input being done on the form


    //Login Button Pressed
    public gui() {
    	
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                //Submit input to user system
                String username = usernameInput.getText();
                char[] password = passwordInput.getPassword();
                //boolean check = userSystem.checkCredentials(username, password);
                /*
                if (check == true)
                {
                    errorLabel.setText("");
                    //Goes to next tab (dashboard of index 1)
                    navigation.setSelectedIndex(1);
                }

                else
                {
                errorLabel.setText("Please enter correct credentials");
                }
                 */



            }
        });
    }
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				gui gui  = new gui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}
