package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "MyTeam";
        } else if (query.contains("largest:")) {
            String string = query.substring(query.indexOf("largest:")+8).trim();
            String[] array = string.split(",");
            int[] intArray = new int[array.length];
            for(int i = 0; i< array.length; i++){
                intArray[i] = Integer.valueOf(array[i].trim());
            }
            int max = 0;
            for(int i = 0; i< intArray.length; i++){
                if(i == 0) {
                    max = intArray[0];
                }
                if(intArray[i] > max){
                    max = intArray[i];
                }
            }
            // TODO extend the programm here
            return String.valueOf(max);
        }
        else if(query.contains("what is")&& query.contains("plus")){
            String[] splitted = query.split(",");
            return String.valueOf(Integer.valueOf(splitted[3])+Integer.valueOf(splitted[5]));

        }
        else if(query.contains("what is")&& query.contains("multiplied ")){
            String[] splitted = query.split(",");
            return String.valueOf(Integer.valueOf(splitted[3])*Integer.valueOf(splitted[6]));
        }
        else{
            return "";
        }
    }
}
