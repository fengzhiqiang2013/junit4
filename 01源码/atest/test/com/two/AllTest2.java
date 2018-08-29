package com.two;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.two.service.BookService_A_Test;
import com.two.service.BookService_B_Test;
import com.two.service.BookService_C_Test;
import com.two.service.BookService_D_Test;
import com.two.service.BookService_E_Test;
import com.two.service.BookService_G_Test;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BookService_A_Test.class,
	BookService_B_Test.class,
	BookService_C_Test.class,
	BookService_D_Test.class,
	BookService_E_Test.class,
	BookService_G_Test.class
	}) 
public class AllTest2 {

}
