package com.first;

import java.util.Arrays;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * 定义自己的rule
 * 
 * @author aran
 *
 */
public class RepeatableRule  implements MethodRule{
	//Loop times  
    int times=1;  
    //Loop methods  
    String[] testMethods = null;  
      
    RepeatableRule(int times, String[] testMethods){  
        this.times = times;  
        this.testMethods = testMethods;  
    }  
    
    /**
     * 定义循环执行
     */
	@Override
	public Statement apply(final Statement base, final FrameworkMethod method, final Object target) {
		return new Statement() {  
	         @Override  
	         public void evaluate() throws Throwable {  
	            int loopTime = 1;  
	            //System.out.println(method.getName());
	            if(Arrays.asList(testMethods).contains(method.getName())){//test method name matched  
	                loopTime = times;  
	            }
	            System.out.println(target.getClass());
	            //执行次数 
	            for(int i = 0; i < loopTime; i++){
	                base.evaluate();  
	            }
	         }  
	      }; 
	}
	
}
