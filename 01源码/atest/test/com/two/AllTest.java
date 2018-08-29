package com.two;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

import com.two.service.BookService_A_Test;
import com.two.service.BookService_B_Test;
import com.two.service.BookService_C_Test;
import com.two.service.BookService_D_Test;
import com.two.service.BookService_E_Test;
import com.two.service.BookService_F_Test;
import com.two.service.BookService_G_Test;

public class AllTest {
	public static Test suite(){
		TestSuite suite = new TestSuite("Test for package1");     
		//添加自己管理的测试用例类
		suite.addTest(new JUnit4TestAdapter(BookService_A_Test.class));                               
		suite.addTest(new JUnit4TestAdapter(BookService_B_Test.class));
		suite.addTest(new JUnit4TestAdapter(BookService_C_Test.class));
		suite.addTest(new JUnit4TestAdapter(BookService_D_Test.class));
		suite.addTest(new JUnit4TestAdapter(BookService_E_Test.class));
		suite.addTest(new JUnit4TestAdapter(BookService_F_Test.class));
		suite.addTest(new JUnit4TestAdapter(BookService_G_Test.class));
		
		return suite;       
	}
}
