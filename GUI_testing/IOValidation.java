/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* IOValidation.java: 
********************************************/
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

class IOValidation{

	public static void main(String[] args) {

        ArrayList<String> emails = new ArrayList<String>();
        emails.add("2014/9/5");
        emails.add("2015/12/12");
        emails.add("1993/5/9");
        emails.add("1996/2/9");
         
        //Invalid emails
        emails.add("196/2/9");
        emails.add("1996/20/9");
        emails.add("1996/2/900");
        emails.add("2014.9.5");
        for(int i = 0; i < emails.size(); i++){
            String email = emails.get(i);
            System.out.println(email +" : "+ IOValidation.dateValid(email));

        }
	}
	
	public static boolean stringValid(String inStr) {
		if(inStr.isEmpty()){
			return false;
		} else if(!inStr.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			return false;
		}
		return true;
	}

    public static boolean emailValid(String inStr) {
        if(inStr.isEmpty())
            return false;
        String regex = "^[a-zA-Z0-9._]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";  // set the regex
        Pattern pattern = Pattern.compile(regex);   // compile the pattern
        Matcher matcher = pattern.matcher(inStr);   // validate the email
        if(matcher.matches())
            return true;
        else
            return false;
    }

    public static boolean phoneValid(String inStr) {
        if(inStr.isEmpty())
            return false;
        String regex = "[0-9]{8}";  // set the regex
        Pattern pattern = Pattern.compile(regex);   // compile the pattern
        Matcher matcher = pattern.matcher(inStr);   // validate the email
        if(matcher.matches())
            return true;
        else
            return false;
    }
	
	public static boolean numberValid(String inStr) {
        if(inStr.isEmpty())
            return false;
        String regex = "[0-200]";  // set the regex
        Pattern pattern = Pattern.compile(regex);   // compile the pattern
        Matcher matcher = pattern.matcher(inStr);   // validate the email
        if(matcher.matches())
            return true;
        else
            return false;
    }

    public static boolean usernameValid(String inStr) {
        if(inStr.isEmpty())
            return false;
        String regex = "[a-z]{1}[a-z0-9]{7,11}";  // set the regex
        Pattern pattern = Pattern.compile(regex);   // compile the pattern
        Matcher matcher = pattern.matcher(inStr);   // validate the email
        if(matcher.matches())
            return true;
        else
            return false;
    }
	
    public static boolean passwordValid(String inStr) {
        if(inStr.isEmpty())
            return false;
        String regex = "[a-zA-Z0-9]{6,16}";  // set the regex
        Pattern pattern = Pattern.compile(regex);   // compile the pattern
        Matcher matcher = pattern.matcher(inStr);   // validate the email
        if(matcher.matches())
            return true;
        else
            return false;
    }

    public static boolean dateValid(String inStr) {
        if(inStr.isEmpty())
            return false;
        String regex = "[0-9]{4}+[-]+[0-9]{2}+[-]+[0-9]{2}";  // set the regex
        Pattern pattern = Pattern.compile(regex);   // compile the pattern
        Matcher matcher = pattern.matcher(inStr);   // validate the email
        if(matcher.matches())
            return true;
        else
            return false;
    }

}