package com.test.rizky.exeption;

import com.test.rizky.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.ResourceAccessException;

import static com.test.rizky.constant.constant.ErrorCode.CONNECTION_REFUSED;
import static com.test.rizky.constant.constant.ErrorCode.UNKNOWN;
import static com.test.rizky.dto.response.ResponseDTO.ERROR;
import static org.hibernate.internal.util.collections.CollectionHelper.isEmpty;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    ResponseDTO handleAllException(Exception ex) {
        if (ex instanceof ErrorApp) {
            ErrorApp errorData = (ErrorApp) ex;

            if (errorData.getErrorClass() != null) {
                return errorData.getErrorClass();
            }

            else if (isEmpty(errorData.getListError())) {
                String errorCode = errorData.getCode();
                String message = errorData.getMessage();
                return ERROR(errorCode, message);
            }

            else {
                return ERROR(errorData.getListError());
            }
        }

        else if (ex instanceof ResourceAccessException) {
            return ERROR(CONNECTION_REFUSED, "Tidak dapat terhubung dengan micro services");
        }

        else {
            return ERROR(UNKNOWN, ex.getMessage());
        }
    }
}
