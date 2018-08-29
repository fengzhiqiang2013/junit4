package com.first;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class CustomAnswer implements Answer<String> {  
    public String answer(InvocationOnMock invocation) throws Throwable {  
        Object[] args = invocation.getArguments();  
        Integer num = (Integer)args[0];  
        if( num>3 ){  
        	System.out.println("正常");
            return "yes";  
        } else {  
        	System.out.println("异常");
            throw new RuntimeException();  
        }  
    }
}
