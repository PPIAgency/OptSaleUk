package com.opt.saleuk.dto;

import lombok.Data;

/**
 * Created by Arizel on 07.01.2018.
 */
@Data
public class ResponseDTO {
    boolean isSuccess;
    String message;

    public ResponseDTO(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ResponseDTO(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public ResponseDTO() {
    }
}
