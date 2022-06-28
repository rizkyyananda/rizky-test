package com.test.rizky.shared.util;

import com.test.rizky.dto.response.MessageDTO;
import com.test.rizky.exeption.ErrorApp;

import static com.test.rizky.constant.constant.ErrorCode.EMPTY_DATA;
import static com.test.rizky.shared.util.ObjectUtil.isExist;

public class ValidatorUtil {

    public static void validateField(Object object,String fieldName){
        if (!isExist(object)){
            MessageDTO messageDTO = new MessageDTO();
            messageDTO.setEN(String.format("%s can't be empty", fieldName));
            messageDTO.setIN(String.format("%s tidak boleh kosong", fieldName));
            throw new ErrorApp(EMPTY_DATA, messageDTO);
        }
    }


}
