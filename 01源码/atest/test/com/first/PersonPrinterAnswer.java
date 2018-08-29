package com.first;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.two.bean.TAuthor;


public class PersonPrinterAnswer implements Answer<Object> {
    private TAuthor author;

    @Override
    public TAuthor answer(InvocationOnMock invocationOnMock) {
        Object[] args = invocationOnMock.getArguments();
        author = (TAuthor) args[0];
        return author;
    }
    
    public TAuthor getTAuthor() {
        return author;
    }
}
