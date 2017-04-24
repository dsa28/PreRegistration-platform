import javax.swing.*;
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
    private JTabbedPane states;
    private JTabbedPane menu;
    private JTable table1;
    private JTextField enterCourseNumberTextField;
    private JTextField courseAbbreviation;
    private JButton searchButton;
    private JTable table2;
    private JTable table3;
    private JList list1;

    //States Tabs Indices --Not sure if needed but it does help...
    private int loginTab = 0;
    private int userBackendTab = 1;

    //Menus Tabs Indices
    //int ...


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
                    states.setSelectedIndex(1);
                }

                else
                {
                errorLabel.setText("Please enter correct credentials");
                }
                 */



            }
        });
    }



}
