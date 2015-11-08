/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* Account.java: 
********************************************/

import java.util.ArrayList;

public class Account {

    // data member (To save the User Infomation without FileIOSystem)
    public static ArrayList<User> UserList = new ArrayList<User>(); 

    public static void initUserList() {       //initialization
        UserList.add(new Trainee("e1", "e"));
        UserList.add(new Trainee("e2", "e"));
        UserList.add(new Trainee("e3", "e"));
        UserList.add(new Trainer("r1", "r"));
        UserList.add(new Trainer("r2", "r"));
        UserList.add(new Admin("adm", "a"));
    }

    public static boolean updateUserList(User user) {
        if(UserList.add(user))
            return true;
        else
            return false;
    }

    public static ArrayList<User> getUserList() {
        return UserList;
    }

    public static boolean removeUser(int listID) {
        return true;
    }

    public static boolean removeUser(String userName) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getUserName().equals(userName)) {
                UserList.remove(i);
                return true;
            }
        }
        return false;
    }


}
