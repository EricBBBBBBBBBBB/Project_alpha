/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* Account.java: 
********************************************/

import java.util.ArrayList;

public class Account {

    // data member (To save the Users Infomation without FileIOSystem)
    public static ArrayList<Users> myList = new ArrayList<Users>(); 

    public static void initMyList() {       //initialization
        myList.add(new Users("e1", "e", 0));
        myList.add(new Users("e2", "e", 0));
        myList.add(new Users("e3", "e", 0));
        myList.add(new Users("r1", "r", 1));
        myList.add(new Users("r2", "r", 1));
        myList.add(new Users("adm", "a", 2));
    }

    public static boolean updateMyList(Users user) {
        if(myList.add(user))
            return true;
        else
            return false;
    }

    public static ArrayList<Users> getMyList() {
        return myList;
    }

    public static boolean removeUser(int listID) {
        return true;
    }

    public static boolean removeUser(String userName) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getUserName().equals(userName)) {
                myList.remove(i);
                return true;
            }
        }
        return false;
    }


}
