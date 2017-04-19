import java.util.ArrayList;

/**
 * Created by user on 15-Apr-17.
 */
public class data_storage {
    ArrayList<ArrayList<String>> alluserinfo;
    ArrayList<String> singleuserinfo;
    ArrayList<String> courses;
    data_storage()
    {
        alluserinfo=new ArrayList<>();          //sample test of few users
        
        singleuserinfo=new ArrayList<>();
        singleuserinfo.add("201500007");
        singleuserinfo.add("secret");
        singleuserinfo.add("student");
        singleuserinfo.add("EECE 230");
        singleuserinfo.add("MATH 202");
        singleuserinfo.add("CMPS 211");
        alluserinfo.add(singleuserinfo);
    
        singleuserinfo=new ArrayList<>();
        singleuserinfo.add("201600097");
        singleuserinfo.add("secret1");
        singleuserinfo.add("student");
        singleuserinfo.add("EECE 230");
        singleuserinfo.add("MATH 202");
        alluserinfo.add(singleuserinfo);
    
        singleuserinfo=new ArrayList<>();
        singleuserinfo.add("201600087");
        singleuserinfo.add("secret2");
        singleuserinfo.add("student");
        singleuserinfo.add("EECE 231");
        singleuserinfo.add("MATH 202");
        singleuserinfo.add("ECON 211");
        alluserinfo.add(singleuserinfo);
    
        singleuserinfo=new ArrayList<>();
        singleuserinfo.add("teach1");
        singleuserinfo.add("secret");
        singleuserinfo.add("teacher");
        singleuserinfo.add("EECE 231");
        alluserinfo.add(singleuserinfo);
    
        singleuserinfo=new ArrayList<>();
        singleuserinfo.add("teach2");
        singleuserinfo.add("secret1");
        singleuserinfo.add("teacher");
        singleuserinfo.add("ECON 211");
        alluserinfo.add(singleuserinfo);
    
        singleuserinfo=new ArrayList<>();
        singleuserinfo.add("admin1");
        singleuserinfo.add("secret");
        singleuserinfo.add("admin");
        singleuserinfo.add("all courses");
        singleuserinfo.add("all rooms");
        alluserinfo.add(singleuserinfo);
        
    }
    public ArrayList<Integer> auth(String Id, String Pin)       //checks username and password
    {                                                           //then associate with user type
        ArrayList<Integer> k=new ArrayList<>();
        for(int i=0;i<alluserinfo.size();i++)
        {
            if(alluserinfo.get(i).get(0).equals(Id)&&alluserinfo.get(i).get(1).equals(Pin))
            {
                if(alluserinfo.get(i).get(2).equals("admin")) {//returns type and position for easy referral
                    k.add(1);
                    k.add(i);
                    return k;
                }
                if(alluserinfo.get(i).get(2).equals("teacher") ){
                    k.add(2);
                    k.add(i);
                    return k;
                }
                if(alluserinfo.get(i).get(2).equals("student")) {
                    k.add(3);
                    k.add(i);
                    return k;
                }
            }
        }
        return k;
    }
    public ArrayList<String> getuserdata(int i)
    {
        courses=new ArrayList<>();
        for(int j=3;j<alluserinfo.get(i).size();j++)
            courses.add(alluserinfo.get(i).get(j));
        return courses;
    }
    
}
