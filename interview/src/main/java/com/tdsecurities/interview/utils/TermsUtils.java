package com.tdsecurities.interview.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TermsUtils {
   public String  findDifference(Date d1, Date d2)   {
        long difference_In_Time
                = d1.getTime() - d2.getTime();
        long difference_In_Days
                = (difference_In_Time
                / (1000 * 60 * 60 * 24))
                % 365;
       long difference_In_Years
               = (difference_In_Time
               / (1000l * 60 * 60 * 24 * 365));

       if(difference_In_Years>50)
       {
           return "50yr+";
       } else if(difference_In_Years>=30){
           return "30yr-50yr";
       } else if(difference_In_Years>=10){
           return "10yr-30yr";
       } else if(difference_In_Years>=1){
           return "1yr-10yr";
       } else if(difference_In_Days>=183){
           return "6m-1yr";
       } else if(difference_In_Days>=30){
           return "1m-6m";
       } else if(difference_In_Days>=0){
           return "0m-1m";
       } else {
           return null;
       }
    }
}

