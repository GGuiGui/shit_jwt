package com.holy.shit_jwt.common;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class CommonResponse<T> {
    private boolean success = true;
    private T result;

    private String error;

    public CommonResponse(T data){
        this.result = data;
    }

    @Getter
    @NoArgsConstructor
    public static class ofList<T>{
        private List<T> result;
        public ofList(List<T> data){
            this.result = data;
        }
    }
}
