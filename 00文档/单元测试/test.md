# 单元测试
	开发或者测试写的一段代码，用于明确判断功能的正确性

# 单元测试能做什么
1. 单元测试不但会使你的工作完成得更轻松。而且会令你的设计会变得更好，甚至大大减少你花在调试上面的时间
2. 提高代码质量
3. 减少bug
4. 放心地修改、重构
5. 后期维护成本降低（测试一键就能全部执行）
# 注意点
1. 测试的路径要全面，测试用例尽量全面
2. 当然测试都要通过，通不过就没有意义
3. 如果函数很复杂，不好测试，抽象函数有问题，要注意
4. 难点在mock

# 单元测试 注解
|										|	|															|
|--										|--	|--	
|@Before		|初始化方法											|OperateTest_Befre_After			|
|@After			|释放资源											|OperateTest_Befre_After			|
|@Test			|测试方法，在这里可以测试期望异常和超时时间			|OperateTest_Test					|
|@Ignore		|忽略的测试方法										|OperateTest_BeforeClass_Ignore		|
|@BeforeClass	|针对所有测试，只执行一次，且必须为static void		|OperateTest_BeforeClass_AfterClass	|
|@AfterClass	|针对所有测试，只执行一次，且必须为static void		|OperateTest_BeforeClass_AfterClass	|
|@RunWith		|指定测试类使用某个运行器							|AllTest2							|
|@Rule			|允许灵活添加或重新定义测试类中的每个测试方法的行为	|OperateTest_Rule					|
|@FixMethodOrder|指定测试方法的执行顺序								|OperateTest_FixMethodOrder			|

提问：执行顺序？

# JUnit 实例
## @Test 测试类OperateTest_Test
## @Before--@After 测试类OperateTest_Before_After
	1. @Before在@Test之前执行，@After在@Test之后执行
	2. 一个类可以写多个@Befor和@After
	3. 每执行一个@Test 就会执行一次 @Before和@After
## @BeforeClass--@AfterClass 测试类测试类OperateTest_BeforeClass_AfterClass
	1. 只执行一次，且必须为static void
	2. 一个类只有一个 @BeforeClass和@AfterClass
## @RunWith 
	1. @RunWith就是一个运行器
	2. @RunWith(JUnit4.class)就是指用JUnit4来运行
	3. @RunWith(SpringJUnit4ClassRunner.class), 让测试运行于Spring测试环境, 
测试类BookControllerTest，来自[博客](https://blog.csdn.net/u013803262/article/details/52253825?locationNum=6)
	4. @RunWith(Suite.class)的话就是一套测试集合
## @FixMethodOrder
	1. @FixMethodOrder(MethodSorters.JVM)//指定测试方法按定义的顺序执行
	2. @FixMethodOrder(MethodSorters.DEFAULT)//以确定系统默认但不可预期的顺序执行 
	3. @FixMethodOrder(MethodSorters.NAME_ASCENDING)//按方法名字母顺序执行
## @Rule
[博客1](https://blog.csdn.net/tanzhangwen/article/details/8265898)
[博客2](https://blog.csdn.net/michaellufhl/article/details/5955098)
[博客3](https://blog.csdn.net/yqj2065/article/details/39945617)
## 断言assert
|										|															|				|
|--										|--															|--				|
|assertArrayEquals(expecteds, actuals)	|查看两个数组是否相等。										|				|
|ssertEquals(expected, actual)			|查看两个对象是否相等。类似于字符串比较使用的equals()方法	|				|
|assertNotEquals(first, second)			|查看两个对象是否不相等。									|				|
|assertNull(object)						|查看对象是否为空。											|				|
|assertNotNull(object)					|查看对象是否不为空。										|				|
|assertSame(expected, actual)			|查看两个对象的引用是否相等。类似于使用“==”比较两个对象	|				|
|assertNotSame(unexpected, actual)		|查看两个对象的引用是否不相等。类似于使用“!=”比较两个对象	|				|
|assertTrue(condition)					|查看运行结果是否为true。									|				|
|assertFalse(condition)					|查看运行结果是否为false。									|				|
|assertThat(actual, matcher)			|查看实际值是否满足指定的条件								|				|
|fail()									|让测试失败													|CommonTest		|

# mock
## 为啥用mock
在做单元测试的时候，我们会发现我们要测试的方法会引用很多外部依赖的对象，比如：（发送邮件，网络通讯，远程服务, 文件系统等等）。 而我们没法控制这些外部依赖的对象，为了解决这个问题，我们就需要用到Mock工具来模拟这些外部依赖的对象，来完成单元测试。
## mock 工具
现如今比较流行的Mock工具有jMock 、EasyMock 、Mockito，但是都有一个共同的缺点：不能mock静态、final、私有方法等。而PowerMock能够完美的弥补以上三个Mock工具的不足。
## 讲解案例采用Mockito + PowerMock
## Mockito jar
``` xml
<!-- junit -->
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency>
```
``` xml
<!-- 此jar是sprig将mock对象注入测试方法 -->
    <dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-test</artifactId>
	<version>4.2.8.RELEASE</version>
	<scope>test</scope>
</dependency>
```
``` xml
<!-- mockito -->
<dependency>
	<groupId>org.powermock</groupId>
	<artifactId>powermock-api-mockito</artifactId> 
	<version>1.6.6</version> 
</dependency>
```
``` xml
<!-- PowerMockito 依赖 -->
<dependency>  
	<groupId>org.powermock</groupId>  
	<artifactId>powermock-module-junit4</artifactId>  
	<version>1.6.6</version>  
	<scope>test</scope>  
</dependency>
```

## Mockitod的模拟方法
[Mockito教程](https://www.cnblogs.com/Ming8006/p/6297333.html#c1.1)

|													|										|							|
|--													|--										|--							|
|Mockito.mock(classToMock)							|模拟对象								|测试类 BookService_A_Test	|
|Mockito.doAnswer(answer)							|doAnswer用来判断执行的方法和方法的参数	|测试类BookService_H_Test	|
|Mockito.verify(mock)								|判断执行的次数和顺序					|							|
|Mockito.doNothing().when(mock).[method]			|不做任何事								|测试类 BookService_A_Test	|
|Mockito.doReturn(toBeReturned).when(mock).[method]	|指定返回的结果。						|测试类 BookService_G_Test	|
|Mockito.doThrow(toBeThrown).when(mock).[method]	|模拟抛出异常。							|							|
|Mockito.doCallRealMethod().when(mock).[method]		|调用真实的方法							|测试类 BookService_G_Test	|
|Mockito.spy(Object);								|用spy监控真实对象,设置对象行为			|测试类 BookService_G_Test	|
|Mockito.reset(mock);								|重置mock								|测试类 BookService_G_Test	|
## PowerMockito的模拟方法
[PowerMockito博客](https://www.cnblogs.com/hunterCecil/p/5721468.html)

	1. 必须加注解@PrepareForTest和@RunWith,注解@PrepareForTest里写的类是final方法所在的类
	2. 当某个测试方法被注解@PrepareForTest标注以后，在运行测试用例时，会创建一个新的org.powermock.core.classloader.MockClassLoader实例，然后加载该测试用例使用到的类（系统类除外）。
|																|																			|							|
|--																|--																			|--							|
|PowerMockito.whenNew(type).withArguments().thenReturn(Object)	|模拟new 出来的对象															|BookService_I_Test			|
|PowerMockito.when(method).thenReturn(Object)					|Mock普通对象的final方法;普通类的静态方法;私有方法;系统类的静态和final方法	|测试类 BookService_J_Test	|

# 覆盖率
	工具 EclEmma
	1. eclipse的插件，推荐下载后手动按装，安装完成后在测试类右键有个 Coverage As
	2. 从运行结果可以看到，有多种颜色，其中 绿色表示代码被执行到；黄色表示代码部分执行到；红色表示代码没有被执行到
	3. 导出测试报告
 ![EclEmma Coverage As](/image/coverage.png)
</br>
![EclEmma颜色](/image/yanse.jpg)
</br>
![EclEmma覆盖率](/image/fugailv.jpg)
</br>
[EclEmma博客](https://blog.csdn.net/wzyzzu/article/details/51365582)
