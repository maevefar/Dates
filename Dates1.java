import java.util.*;
//import java.io.File;
//import java.io.FileNotFoundException;

public class Dates1{

    private static final float MIN_YEAR_SHORT = 49;
    private static final float MAX_YEAR_SHORT = 50;
    private static final float MAX_YEAR = 3000;
    private static final float MIN_YEAR = 1753;

    public static boolean containsAllDigits(String word){
        for (int i = 0; i < word.length(); i++){
            if(!Character.isDigit(word.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private static String checkSplit(String date){
        String splitter = " ";
        if (date.contains("-")){
            splitter = "-";
        }
        else if (date.contains("/")){
            splitter = "/";
        }
        return splitter;
    }

    private static String dayCheck(String day, String month, String year){

        if (containsAllDigits(day)) {
            Hashtable<String, Integer> daysInMonths = new Hashtable<String, Integer>();
            daysInMonths.put("Jan", 31);
            daysInMonths.put("Mar", 31);
            daysInMonths.put("Apr", 30);
            daysInMonths.put("May", 31);
            daysInMonths.put("Jun", 30);
            daysInMonths.put("Jul", 31); 
            daysInMonths.put("Aug", 31);
            daysInMonths.put("Sep", 30);
            daysInMonths.put("Oct", 31);
            daysInMonths.put("Nov", 30);
            daysInMonths.put("Dec", 31);
            daysInMonths.put("Feb", 29); 

            int numberDays = daysInMonths.get(month);

            if (Integer.parseInt(day) <= 0 || Integer.parseInt(day) > numberDays || day.length() > 2){
                return "Invalid Day"; //day is invalid  
            }

            if ((day.equals("29")) && (month.equals("Feb"))) {
                int integerYear = Integer.parseInt(year);
                if (integerYear % 4 == 0 && integerYear % 100 != 0 ){ 
                    return day;  
                }
                else if (integerYear % 4 == 0 && integerYear % 100 == 0 && integerYear % 400 == 0){
                    return day;
                }
                else{
                    return "Invalid Day";
                }
            }
            if (day.length() == 1){
                day = "0" + day;
            }
            return day;
        }
        else{
            return "Invalid Day"; 

        }
    }

    

    private static String monthCheck(String month){

        List<String> months = Arrays.asList("jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec");

        if (month.length() < 3 && containsAllDigits(month)){ //changes numeric to letters
            try{
                if (Integer.parseInt(month) > 0 && Integer.parseInt(month) < 13){
                 month = months.get(Integer.parseInt(month)-1);
                    return month.substring(0,1).toUpperCase() + month.substring(1).toLowerCase();
                }
            }
            catch (NumberFormatException nfe){
                System.err.println("Invalid Month");
            }
        }
        
        else if (month.length() == 3){ 
            String monthsUpper = month.toUpperCase();
            String monthsLower = month.toLowerCase();
            String monthsOther = (month.substring(0,1).toUpperCase() + month.substring(1).toLowerCase()); 
            if (months.contains(monthsLower)){ //is a correct month
                if(month.equals(monthsLower) || month.equals(monthsUpper) || month.equals(monthsOther) ){ //check correct capitalizaiotn 
                    return monthsOther;
                }
            }
        }
        return "Invalid Month";
    }

    private static String yearCheck(String year){
        if (containsAllDigits(year)){
            if (year.length() == 2 && Integer.parseInt(year) >= 0 && Integer.parseInt(year) <= 99){
                if (Integer.parseInt(year) >= MAX_YEAR_SHORT){
                    year = "19" + year;
                }
                else if (Integer.parseInt(year) <= MIN_YEAR_SHORT){
                    year = "20" + year;
                }
            }

            else if (year.length() == 4){
                if (Integer.parseInt(year) < MIN_YEAR || Integer.parseInt(year) > MAX_YEAR ){
                    return "Invalid Year";
                }
            }
            else {
                return "Invalid Year";
            }
            return year;
        }
        else{
            return "Invalid Year";
        }
    }

    public static int splitCount(String line, String splitter){
        int lengthOfLine = line.length();
        int numberOfSplitters = 0;
        for (int i = 0; i < lengthOfLine; i++){
            if (line.charAt(i) == splitter.charAt(0)){
                numberOfSplitters++;
            }
        }
        return numberOfSplitters;
    }

    public static void dateCheck (String[] date, String line){
        if (date.length == 3){
            String day = date[0];
            String month = date[1];
            String year = date[2];

            String monthFinal = monthCheck(month);
            if (monthFinal.equals("Invalid Month")){
                line = line + " - INVALID";
                System.err.println("Invalid Month");
            }
            else{
                String dayFinal = dayCheck(day, monthFinal, year);
                if(dayFinal.equals("Invalid Day")){
                    line = line + " - INVALID";
                    System.err.println("Invalid Day");
                }
                else{
                    String yearFinal = yearCheck(year); 
                    if(yearFinal.equals("Invalid Year")){
                        line = line + " - INVALID";
                        System.err.println("Invalid Year");
                    }
                    else{
                        line = dayFinal + " " + monthFinal + " " + yearFinal;
                    }
                }
            }
            System.out.println(line);
        }
    }
    
    public static void main(String[] args){

        //try {
            //File datesFile = new File("1.in");
            Scanner scan = new Scanner(System.in); //change to System.in for auto judge and comment out try catch 
            while (scan.hasNextLine()){
                String line = scan.nextLine();

                String splitter = checkSplit(line);

                int numberOfSplits = splitCount(line, splitter);

                if (numberOfSplits == 2){
                    String[] date = line.split(splitter); 
                    dateCheck(date, line); //// 
                    //all the code was here 
                }
                else{
                    System.out.println(line + " - INVALID");    
                } 
            }
            scan.close();
        //}
        
        //catch (FileNotFoundException e){
            //System.err.println("Error");
        //}
        
        /* //INITAL TESTING 
        //tests for days 
        System.out.println("DAY TESTS");
        System.out.println(dayCheck("14", "Jan", "2000")); 
        System.out.println(dayCheck("29", "Feb", "2000")); 
        System.out.println(dayCheck("29", "Feb", "2001")); //not leap year
        System.out.println(dayCheck("56", "Feb", "2000")); //invalid day 
        System.out.println(dayCheck("08", "Sep", "1986"));

        //tests for months
        System.out.println("MONTH TESTS");
        System.out.println(monthCheck("01"));
        System.out.println(monthCheck("1"));
        System.out.println(monthCheck("11"));
        System.out.println(monthCheck("jan"));
        System.out.println(monthCheck("JAN"));
        System.out.println(monthCheck("Jan"));
        //bad cases
        System.out.println(monthCheck("jAn"));
        System.out.println(monthCheck("111"));
        System.out.println(monthCheck("00"));
        System.out.println(monthCheck("17"));
        System.out.println(monthCheck("a45g"));
        //System.out.println(monthCheck("aa"));

        //tests for splits 
        System.out.println("SPLIT TESTS");
        System.out.println(checkSplit("01/14/2002"));
        System.out.println(checkSplit("01-14-2002"));
        System.out.println(checkSplit("01 14 2002"));

        //tests for year
        System.out.println(yearCheck("2000"));
        System.out.println(yearCheck("56"));
        System.out.println(yearCheck("42"));
        System.out.println(yearCheck("2000000"));
        System.out.println(yearCheck("20"));
        System.out.println(yearCheck("abc"));

        */
    }
}





