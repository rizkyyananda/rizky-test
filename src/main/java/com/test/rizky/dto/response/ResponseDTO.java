package com.test.rizky.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResponseDTO implements Serializable {
    private static final long serialVersionUID = -2661750008906770848L;

    private static final String FIELD_STATUS = "status";
    private static final String FIELD_ERROR = "error";
    private static final String FIELD_DATA = "data";
    private static final String FIELD_INFO = "info";

    public enum Status{
        SUCCESS, ERROR
    }

    private Boolean status;
    private List<CodeMessageDTO> error;
    private Serializable data;
    private Map<String, String> info;

    public ResponseDTO() {}

    private ResponseDTO(Boolean status, Serializable data, List<CodeMessageDTO> error) {
        this.status = status;
        this.data   = data;
        this.error  = error;
    }

    public static ResponseDTO SUCCESS(Serializable data) {
        return new ResponseDTO(true, data, null);
    }

    public static ResponseDTO SUCCESS() {
        return new ResponseDTO(true, null, null);
    }

    public static ResponseDTO STATUS(Boolean status, Serializable data) {
        return new ResponseDTO(status, data, null);
    }

    public static ResponseDTO ERROR(List<CodeMessageDTO> error) {
        return new ResponseDTO(false, null, error);
    }

    public static ResponseDTO ERROR() {
        return new ResponseDTO(false, null, null);
    }

    public static ResponseDTO ERROR(CodeMessageDTO error) {
        List<CodeMessageDTO> list = new ArrayList<CodeMessageDTO>();
        list.add(error);
        return ERROR(list);
    }

    public static ResponseDTO ERROR(String code, String message) {
        return ERROR(new CodeMessageDTO(code, message));
    }

    public static ResponseDTO ERROR(String code, MessageDTO messageDTO) {
        return ERROR(new CodeMessageDTO(code, messageDTO.getEN(), messageDTO.getIN(), null, null, messageDTO));
    }

    public static ResponseDTO ERROR(String code) {
        return ERROR(new CodeMessageDTO(code, null));
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<CodeMessageDTO> getError() {
        return error;
    }

    public void setError(List<CodeMessageDTO> error) {
        this.error = error;
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }


    public Serializable getInfo(String key) {
        return info != null ? info.get(key) : null;
    }

    public Set<String> keysInfo() {
        return info != null ? info.keySet() : null;
    }

    public boolean hasError() {
        return error != null && !error.isEmpty();
    }
}

