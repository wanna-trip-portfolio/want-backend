package com.want.want.common;

import lombok.Data;

@Data
public class WantResBody {

    private String result;
    private Object data;

    public WantResBody (String result) {
        this.result = result;
    }

    public WantResBody(String result, Object data) {
        this.result = result;
        this.data = data;
    }

    public WantResBody data(Object data) {
        this.data = data;
        return this;
    }

    public static WantResBody success() {
        return new WantResBody("success");
    }

    public static WantResBody fail() {
        return new WantResBody("fail");
    }

    public static WantResBody success(Object data) {
        return success().data(data);
    }

    public static WantResBody fail(Object data) {
        return fail().data(data);
    }

    public static WantResBody success(DataStatusMessage status) {
        return success().data(status.getMessage());
    }

    public static WantResBody fail(DataStatusMessage status) {
        return fail().data(status.getMessage());
    }
}
