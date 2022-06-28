package com.test.rizky.shared.util;


import java.util.List;

public class ObjectUtil {
    @SuppressWarnings("rawtypes")
    public static boolean isExist(Object object){
        if (object != null){
            if (object instanceof String){
                String data = (String) object;
                if (data.equalsIgnoreCase("null")){
                    return false;
                }else{
                    return !((String) object).isEmpty();
                }
            }else if (object instanceof List){
                return (((List) object).size()) > 0;
            }else{
                return true;
            }
        }else {
            return false;
        }
    }
}
