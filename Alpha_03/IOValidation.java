/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* IOValidation.java: 
********************************************/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IOValidation{

	public static void main(String[] args) {
        System.out.println(IOValidation.stringValid(""));
        System.out.println(IOValidation.stringValid("APPAP"));
        System.out.println(IOValidation.stringValid("12312312516"));
        System.out.println(IOValidation.stringValid("APP12412AP"));
        System.out.println(IOValidation.stringValid("!@#!%#$%"));
	}
	
	public static boolean stringValid(String inStr) {
		if(inStr.isEmpty()){
			return false;
		//} else if(Pattern.matches("[a-zA-Z&&[0-9]+]", inStr)) {
		} else if(!inStr.matches("[A-Za-z0-9]+")) {
			return false;
		}
		return true;
	}	
}