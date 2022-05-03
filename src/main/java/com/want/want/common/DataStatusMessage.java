package com.want.want.common;

public enum DataStatusMessage {
    INSERT_SUCCESS("insert success"),
    UPDATE_SUCCESS("update success"),
    DELETE_SUCCESS("delete success"),
    INSERT_FAIL("insert fail"),
    UPDATE_FAIL("update fail"),
    DELETE_FAIL("delete fail");

    private String message;

    DataStatusMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
