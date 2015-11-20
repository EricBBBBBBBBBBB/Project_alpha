/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Account > User > Trainer, Trainee, Admin
********************************************/

import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import java.time.LocalDate;
import java.time.Period;

import java.time.temporal.ChronoField;
public class Test {

    public static void main(String[] args) {
        
        //dateOfBirth
        Date current = new Date();
        Date birth = new Date();
        birth.setTime(831571200000L);
        int different = birth.compareTo(current);
        

        //Long testDate = date.getTime();
        System.out.println("======");
        //System.out.println("Date of register: " + sdf.format(testDate));
        System.out.println("----" + different);
        System.out.println("======");

LocalDate today = LocalDate.of(2015, 5, 9);//.now();
LocalDate birthday = LocalDate.of(1996, 5, 9);
Period period = Period.between(birthday, today);
System.out.println(period.getYears());



    }
}
