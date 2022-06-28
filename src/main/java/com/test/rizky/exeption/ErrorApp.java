package com.test.rizky.exeption;

import com.test.rizky.dto.response.CodeMessageDTO;
import com.test.rizky.dto.response.MessageDTO;
import com.test.rizky.dto.response.ResponseDTO;

import java.util.List;

public class ErrorApp extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 7408238172292703275L;

    private String code;

    private String object;

    private List<CodeMessageDTO> listError;

    private ResponseDTO errorClass;

    private MessageDTO messageDTO;


    public ErrorApp() {
        super();
    }

    public ErrorApp(String code, String message) {
        super(message);
        this.code = code;
    }

    public ErrorApp(String code, MessageDTO messageDTO) {
        super(messageDTO.getEN());
        this.code = code;
        this.messageDTO = messageDTO;
    }

    public ErrorApp(String code, String message, String object) {
        super(message);
        this.code = code;
        this.object = object;
    }

    public ErrorApp(List<CodeMessageDTO> listError) {
        this.listError = listError;
    }

    public ErrorApp(ResponseDTO listError) {
        this.errorClass = listError;
    }

    public ErrorApp(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CodeMessageDTO> getListError() {
        return listError;
    }

    public void setListError(List<CodeMessageDTO> listError) {
        this.listError = listError;
    }

    public ResponseDTO getErrorClass() {
        return errorClass;
    }

    public void setErrorClass(ResponseDTO errorClass) {
        this.errorClass = errorClass;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public MessageDTO getMessageDTO() {
        return messageDTO;
    }

    public void setMessageDTO(MessageDTO messageDTO) {
        this.messageDTO = messageDTO;
    }
}
