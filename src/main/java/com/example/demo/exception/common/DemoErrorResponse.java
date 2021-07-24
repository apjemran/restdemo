package com.example.demo.exception.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DemoErrorResponse {
	//General error message about nature of error
    private String message;
 
    //Specific errors in API request processing
    private List<String> details;
 

}
