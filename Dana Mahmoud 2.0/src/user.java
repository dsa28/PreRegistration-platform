/**
 * Created by user on 16-Apr-17.
 */
public class user {

    private String name;
    private int id;
    private String password;


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


    String getName()
    {
        return name;
    }

    user()
    {
        name = "TBA";
        id = 0;
    }

    user(String name, int id, String password)
    {
        this.name = name;
        this.id = id;
        this.password = password;
    }


}

