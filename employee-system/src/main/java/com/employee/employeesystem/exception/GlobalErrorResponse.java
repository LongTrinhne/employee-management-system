package com.employee.employeesystem.exception;

import lombok.Data;

@Data
public class GlobalErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
