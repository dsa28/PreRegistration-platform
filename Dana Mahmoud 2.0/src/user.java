/**
 * Created by user on 16-Apr-17.
 */
public class user {

    private String name;
    private int id;
    private String password;

    public int getId()
    {
        return id;
    }


    public user checkPassword(String password)
    {
        if (this.password.equals(password))
        {
            return this;
        }

        return null;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof  user)
        {
            return id == ((user) o).id;
        }

        return false;
    }

    @Override
    public int hashCode() //hashcode so we can store users in a hashmap
    {
        return id;
    }

    public void print()
    {
        System.out.println(name);
    }

    public int getTab()
    {
        //Function get tab is used for GUI
        //it is used to determine the type of GUI to be used depending on the user
        //1 for student
        //2 for teacher
        //3 for admin
        return 3;
    }

    String getName()
    {
        return name;
    }

    user()
    {
        name = "TBA";
        id = 0;
    }

    user(int id)
    {
        this.id = id;
    }

    user(String name, int id, String password)
    {
        this.name = name;
        this.id = id;
        this.password = password;
    }


}

