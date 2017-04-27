import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by user on 14-Apr-17.
 */
public class gui2 implements ActionListener{
    private JPanel panelmain;
    JButton button, button2;
    JLabel l1, l2;
    int userorder=-1;
    JTextArea id, pin, coursename, cname;
    public String Id, Pin;
    public User_System system;
    JFrame frame;
    int state=-1;           //after sign in, we will know the user type, and work accordingly
    Student s;
    Admin a;
    Teacher t;
    data_storage d;
    gui2(User_System s)
    {
        system=s;
        d=s.db;
        panelmain = new JPanel();
        panelmain.setLayout(new BorderLayout());
        panelmain.setPreferredSize(new Dimension(700,350));
        
        signinscreen();
        
        frame=new JFrame("prereg");
        frame.setContentPane(panelmain);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(50,50);
        frame.setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button&&state==-1) {//sign in first screen
            Id = id.getText();
            Pin = pin.getText();
            //state=system.authenticate(Id, Pin);
            ArrayList<Integer> c=system.check(Id, Pin);
            state=c.get(0);
            userorder=c.get(1);
            if(state==1)
                adminscreen(userorder);
            if(state==2)
                teacherscreen(userorder);
            if(state==3)
                studentscreen(userorder);
            if(state==-1)
                System.out.println("wrong user id/pin");//fix output to gui
        }
        if(e.getSource()==button2&&state==3)
        {
            if(!coursename.getText().equals("")) {
                s.addcourse(new Course(coursename.getText()));
                studentscreen(userorder);
            }
        }
        if(e.getSource()==button2&&state==2)
        {
            if(!coursename.getText().equals("")) {
                t.addcourse(new Course(coursename.getText()));
                teacherscreen(userorder);
            }
        }
        if(e.getSource()==button&&state==3)
        {
            //loop through teachers who have the respective course and request
        }
    }
    public void signinscreen()
    {
        JPanel panel1=new JPanel();
        l1 = new JLabel();
        panel1.add(l1);
        l1.setText("User ID: ");
        id =new JTextArea();
        panel1.add(id);
        id.setColumns(20);
        id.setPreferredSize(new Dimension(20,15));
        panelmain.add(panel1, BorderLayout.NORTH);
        
        JPanel panel2=new JPanel();
        l2 = new JLabel();
        panel2.add(l2);
        l2.setText("PIN: ");
        pin =new JTextArea();
        panel2.add(pin);
        pin.setColumns(20);
        pin.setPreferredSize(new Dimension(20,15));
        panelmain.add(panel2, BorderLayout.CENTER);
    
        JPanel panel3=new JPanel();
        button=new JButton();
        button.addActionListener(this);
        button.setText("Sign in");
        panel3.add(button);
        panelmain.add(panel3,BorderLayout.SOUTH);
    }
    public void studentscreen(int i) {
        panelmain.removeAll();
        
        JPanel panel1=new JPanel();
        JTextArea area=new JTextArea();
        ArrayList<String> a;
       a = d.getuserdata(i);//User getUserInfo ?
        s = new Student(a, d, i);
        String output="";
        for(int j=0;j<s.courses.size();j++)
            output+=s.courses.get(j).toString()+"\n";
        area.setText(output);
        area.setFocusable(false);
        area.setEditable(false);
        panel1.add(area);
        panelmain.add(panel1, BorderLayout.NORTH);
        
        JPanel panel2=new JPanel();
        button2=new JButton();
        button2.setText("add this course");
        button2.addActionListener(this);
        coursename=new JTextArea();
        coursename.setColumns(20);
        coursename.setPreferredSize(new Dimension(20,15));
        panel2.add(coursename);
        panel2.add(button2);
        panelmain.add(panel2, BorderLayout.SOUTH);
        
        JPanel panel3=new JPanel();
        button=new JButton();
        button.addActionListener(this);
        button.setText("request capacity");
        cname=new JTextArea();
        cname.setColumns(20);
        cname.setPreferredSize(new Dimension(20,15));
        panel3.add(cname);
        panel3.add(button);
        panelmain.add(panel3, BorderLayout.CENTER);
        
        frame.pack();
    }
    public void teacherscreen(int i) {
        panelmain.removeAll();
    
        JPanel panel1=new JPanel();
        JTextArea area=new JTextArea();
        ArrayList<String> a;
        a = d.getuserdata(i);//User getUserInfo
        t = new Teacher(a, d, i);
        String output="";
        for(int j=0;j<t.courses.size();j++)
            output+=t.courses.get(j).toString()+"\n";
        area.setText(output);
        area.setFocusable(false);
        area.setEditable(false);
        panel1.add(area);
        panelmain.add(panel1, BorderLayout.NORTH);
    
        JPanel panel2=new JPanel();
        button2=new JButton();
        button2.setText("add this course");
        button2.addActionListener(this);
        coursename=new JTextArea();
        coursename.setColumns(20);
        coursename.setPreferredSize(new Dimension(20,15));
        panel2.add(coursename);
        panel2.add(button2);
        panelmain.add(panel2, BorderLayout.SOUTH);
        
        frame.pack();
    }
    public void adminscreen(int i) {
        panelmain.removeAll();
        frame.pack();
    }
    
   

}
