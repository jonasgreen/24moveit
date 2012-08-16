package com.moveit.client.util;



/**
 *
 */
public class StringUtil <T, V> {

    public static String commaSep(String ... vals) {
        StringBuffer sb =new StringBuffer();
        int index = 0;
        for (String val : vals) {
            if(val == null || val.equals("")){
                //ignore
            }
            else{
                if(index != 0 && sb.length() != 0){
                    sb.append(", ").append(val);
                }
                else{
                    sb.append(val);
                }
            }
            index++;
        }
        return sb.toString();
    }

    public static String capitalizeFirst(String s){
        if(isEmpty(s)){
            return s;
        }
        if(s.length() == 1){
            return s.toUpperCase();
        }
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }

    public static boolean isEmpty(String s){
        return s == null || s.length()== 0;
    }

    public static String valueOf(double d){
        return String.valueOf(d).replace('.', ',');
    }

    public static void main(String[] args){

        System.out.println(capitalizeFirst("randers"));
    }


    
}
