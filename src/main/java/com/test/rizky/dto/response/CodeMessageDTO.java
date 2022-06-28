package com.test.rizky.dto.response;

import com.google.gson.Gson;

import java.io.Serializable;

public class CodeMessageDTO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1984231296228848518L;

    private String code;
    private String object;
    private String field;
    private String message;
    private MessageDTO messageData;

    public CodeMessageDTO(String code, String en, String in, Object o, Object o1, MessageDTO messageDTO) {
    }

    public CodeMessageDTO(String code, String message) {
        this(code, message, null, null);
    }

    public CodeMessageDTO(String code, String object, String message) {
        this(code, message, object, null);
    }

    public CodeMessageDTO(String code, String message, String object, String field) {
        this(code, message, object, field, null);
    }

    public CodeMessageDTO(String code, String message, String object, String field,
                          MessageDTO messageData) {
        this.code = code;
        this.object = object;
        this.field = field;
        this.message = message;
        this.messageData = messageData;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageDTO getMessageData() {
        return messageData;
    }

    public void setMessageData(MessageDTO messageData) {
        this.messageData = messageData;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
