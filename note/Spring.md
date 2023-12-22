

# Spring

## 1 简介

- Spring ： 春天 --> 给软件行业带来的春天
- 2002， 首次推出了Spring框架的雏形：interface21框架
- spring框架即以interface21框架为基础，经过重新设计，并不断丰富其内涵，于2004年3月24日，发布了1.0正式版。
- spring的缔造者Rod Johnson。这位仁兄很牛，出生于澳大利亚，毕业于悉尼大学计算机系。到这还是平平无奇，但是他还有另一个身份，音乐学的博士。因为自己爱好音乐，便攻读了音乐学的博士。果然编程的极致是艺术，而艺术相通的。
- Spring的理念：使现有的技术更加容易使用，本身是一个大杂烩，整理现有的技术框架
- SSH： Struct2 + Spring + Hibernate
- SSM： SpringMVC + Spring + Mybatis



```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.6</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.3.6</version>
</dependency>

```



### 1.2 优点

- Spring是一个开源的免费的框架（容器）！
- Spring是一个轻量级的、非入侵式的框架！
- 控制反转（IOC）， 面向切面编程（AOP）
- 支持事务的处理， 对框架整合的支持！

**总结：Spring就是一个轻量级的控制反转（IOC） 和面向切面编程（AOP）的框架**

### 1.3 组成

![image-20210423103448089](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210709103751.png)



1.4 拓展

在Spring官网有这个介绍：现代的java开发！说白了就是基于Spring的开发

![image-20210423103656015](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210704103446.png)

- Spring Boot
  - 一个快速开发的脚手架
  - 基于SpringBoot可以快速的开发单个微服务
  - 约定大于配置！
- Spring Cloud
  - SpringCloud 是基于SpringBoot实现的

因为现在大多数公司都在使用SpringBoot进行快速开发， 学习SpringBoot的前提，需要完全掌握Spring及SpringMVC！承上启下的作用！



弊端：发展了太久之后，违背了原来的理念！配置十分繁琐，人称：“配置地狱”

## 2. IOC理论推导

1. UserDao接口

2. UserDaoImp 实现类

3. UserService 业务接口

4. UserServiceImpl 业务实现类

   ![image-20210423110930859](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210704103502.png)

在我们之前的业务中，用户的需求可能会影响我们原本的代码，我们需要根据用户的需求去修改源代码！如果程序代码十分大，修改一次的成本代价十分昂贵！

我们使用一个Set接口实现，已经发生了革命性的变化

```java
  private UserDao userDao;
  // 使用set进行动态实现值的注入
  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

```



-  之前，程序是主动创建对象！控制权权在程序员手上！
- 使用set注入后，程序不再具有主动性，而是变成了被动的接受对象！

这种思想，从本质上解决了问题，我们程序员不用再去管理对象的创建了。系统的耦合性大大降低，可以专注的在业务的实现上！这就是IOC的原型

![image-20210423110947421](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210704103509.png)

**控制反转IoC（Inversion of Control），是一种设计思想，DI（依赖注入）是实现IoC的一种方法**也有人认为DI只是IoC的另一种说法。

没有IoC的程序中，我们使用面向对象编程，对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制。控制反转后将对象的创建转移给第三方。个人认为所谓控制反转就是：获得依赖对象的方式反转了。

采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的。而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。

> **控制反转是一种通过描述（XML或注解）并通过第三方去生产或者获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方式是依赖注入（Dependency Injection，DI）。**



## 3. HelloSpring

1. 创建实体类

   ```java
   package com.xxx.pojo;
   
   public class User {
     private String name;
   
     public String getName() {
       return name;
     }
   
     public void setName(String name) {
       this.name = name;
     }
   
     @Override
     public String toString() {
       return "User{" +
               "name='" + name + '\'' +
               '}';
     }
   }
   
   ```

   

2. 创建Application.xml文件

   ````xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/c"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
   http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans ">
     <!-- 使用Spring来创建对象， 在Spring这些都称为Bean
          类型 变量名 = new 类型();
          User user = new User();
          bean = 对象 new User();
          id = 变量名
          class = new 的对象
          property 相当于给对象中的属性附一个值
      -->
   <!--  <context:annotation-config/>-->
     <bean id="User" class="com.xxx.pojo.User">
       <property name="name" value="Spring"/>
     </bean>
   </beans>
   ````

   

3. 测试

   ````java
   import com.xxx.pojo.User;
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.support.ClassPathXmlApplicationContext;
   
   public class MyTest {
     public static void main(String[] args) {
   	//    获取Spring的上下文对象！
       ApplicationContext context = new 	ClassPathXmlApplicationContext("beans.xml");
   //    我们的对象现在都在Spring中的管理了，我们要使用，直接去取出来就可以
       User hello = context.getBean(User.class);
       System.out.println(hello.toString());
     }
   }
   
   ````

   

**思考问题 ?**

- Hello 对象是谁创建的 ?
- hello 对象是由Spring创建的
- Hello 对象的属性是怎么设置的 ?
- hello 对象的属性是由Spring容器设置的 ,

这个过程就叫控制反转 :

控制 : 谁来控制对象的创建 , 传统应用程序的对象是由程序本身控制创建的 , 使用Spring后 , 对象是由Spring来创建的 .

反转 : 程序本身不创建对象 , 而变成被动的接收对象 .

依赖注入 : 就是利用set方法来进行注入的.

IOC是一种编程思想 , 由主动的编程变成被动的接收 .

可以通过newClassPathXmlApplicationContext去浏览一下底层源码 .

**OK , 到了现在 , 我们彻底不用再程序中去改动了 , 要实现不同的操作 , 只需要在xml配置文件中进行修改 , 所谓的IoC,一句话搞定 : 对象由Spring 来创建 , 管理 , 装配 !**



## 4. IOC 创建对象的方式

1. 无参构造

2. 有参构造的方法

   1. 下标赋值

      ```xml
      <!-- 通过下标赋值 -->
        <bean id="User" class="com.xxx.pojo.User">
          <constructor-arg index="0" value="yefeng"/>
        </bean>
      ```

   2. 类型

      ```xml
      <!-- 通过类型，不建议使用 -->
        <bean id="User" class="com.xxx.pojo.User">
          <constructor-arg type="java.lang.String" value="qingjia"/>
        </bean>
      ```

   3. 参数名

      ```xml
      <!-- 直接通过参数名来设置 -->
        <bean id="User" class="com.xxx.pojo.User">
          <constructor-arg name="name" value="叶枫"/>
        </bean>
      ```

   总结：在配置文件加载的时候，容器中管理的对象就已经初始化了

## 5. Spring配置

### 5.1 别名

```xml
<!-- 直接通过参数名来设置 -->
  <bean id="User" class="com.xxx.pojo.User">
    <constructor-arg name="name" value="叶枫"/>
  </bean>
```



### 5.2  Bean的配置

```xml
  <!--
    id: bean的唯一标识符，也就是相当于我们学的对象名
    class：bean对象所对应的全限定名： 包名+类型
    name：也就是名别，而且name可以同时取多个名别
   -->
  <bean id="User" class="com.xxx.pojo.User" name="user1 u2,user3;user4">
    <property name="name" value="系部开发"/>
  </bean>
```



### 5.3 import

这个import，一般用于团队开发使用，他可以将多个配置文件，导入合并为一个假设，现在项目中有多个人开发，这三个人复制不同的类开发，不同的类需要注册在不同的bean中，我们可以利用import将所有的人beans.xml合并为一个总的！

- 张三
- 李四
- 王五
- applicationContext.xml

```xml
<import resource="beans.xml"/>
<import resource="beans1.xml"/>
<import resource="beans2.xml"/>
```



使用的时候，直接使用总的配置就可以了

## 6.  依赖注入

### 6.1 构造器注入

前面已经说过了

### **6.2 Set方式注入**  **[重点]**

- 依赖注入：set注入
  - 依赖：bean对象的创建依赖容器
  - 注入：bean对象中的所有属性，由容器来注入

[环境搭建]

1. 复杂类型

   ```java
   package com.xxx.pojo;
   
   public class Address {
     private String address;
   
     public String getAddress() {
       return address;
     }
   
     public void setAddress(String address) {
       this.address = address;
     }
   }
   
   ```

   

2. 真实测试对象

   ```java
   package com.xxx.pojo;
   
   import java.util.*;
   
   public class Student {
     private String name;
     private Address address;
     private String[] books;
     private List<String> hobbys;
     private Map<String, String> card;
     private Set<String> games;
     private Properties info;
     private String wife;
   
   
     public Student() {
     }
   
     public String getName() {
       return name;
     }
   
     public void setName(String name) {
       this.name = name;
     }
   
     public Address getAddress() {
       return address;
     }
   
     public void setAddress(Address address) {
       this.address = address;
     }
   
     public String[] getBooks() {
       return books;
     }
   
     public void setBooks(String[] books) {
       this.books = books;
     }
   
     public List<String> getHobbys() {
       return hobbys;
     }
   
     public void setHobbys(List<String> hobbys) {
       this.hobbys = hobbys;
     }
   
     public Map<String, String> getCard() {
       return card;
     }
   
     public void setCard(Map<String, String> card) {
       this.card = card;
     }
   
     public Set<String> getGames() {
       return games;
     }
   
     public void setGames(Set<String> games) {
       this.games = games;
     }
   
     public Properties getInfo() {
       return info;
     }
   
     public void setInfo(Properties info) {
       this.info = info;
     }
   
     public String getWife() {
       return wife;
     }
   
     public void setWife(String wife) {
       this.wife = wife;
     }
   
     @Override
     public String toString() {
       return "Student{" +
               "name='" + name + '\'' +
               ", address=" + address +
               ", books=" + Arrays.toString(books) +
               ", hobbys=" + hobbys +
               ", card=" + card +
               ", games=" + games +
               ", info=" + info +
               ", wife='" + wife + '\'' +
               '}';
     }
   }
   
   ```

3. bean.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
     <bean id="student" class="com.xxx.pojo.Student">
       <!--  第一种，普通值注入，value  -->
       <property name="name" value="叶枫"/>
     </bean>
   </beans>
   ```

4. 测试

   ```java
   import com.xxx.pojo.Student;
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.support.ClassPathXmlApplicationContext;
   
   public class MyTest {
     public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
       Student student = (Student) context.getBean("student");
       System.out.println(student.getName());
     }
   }
   
   ```

5. 完善注入信息

   ```XML
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
     <bean id="address" class="com.xxx.pojo.Address">
       <property name="address" value="西安"/>
     </bean>
     <bean id="student" class="com.xxx.pojo.Student">
       <!--  第一种，普通值注入，value  -->
       <property name="name" value="叶枫"/>
       <!--  第二种，bean注入， ref  -->
       <property name="address" ref="address"/>
       <!-- 数组注入， ref -->
       <property name="books">
         <array>
           <value>叶枫</value>
           <value>小枫</value>
           <value>小曦</value>
           <value>小晖</value>
         </array>
       </property>
       <!--  List  -->
       <property name="hobbys">
         <list>
           <value>抽烟</value>
           <value>喝酒</value>
           <value>烫头</value>
         </list>
       </property>
       <!--  Map  -->
       <property name="card">
         <map>
           <entry key="身份证" value="1234345341378217398"/>
           <entry key="手机号码" value="123456789523"/>
         </map>
       </property>
       <!--  Set  -->
       <property name="games">
         <set>
           <value>LOL</value>
           <value>COC</value>
           <value>BOB</value>
         </set>
       </property>
       <!--  null  -->
       <property name="wife">
         <null/>
       </property>
       <!--  properties  -->
       <property name="info">
         <props>
           <prop key="学号">2012</prop>
           <prop key="姓名">yefeng</prop>
           <prop key="性别">man</prop>
         </props>
       </property>
     </bean>
   </beans>
   ```

   

### 6.3 拓展方式注入

1. beans.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:p="http://www.springframework.org/schema/p"
          xmlns:c="http://www.springframework.org/schema/c"
          xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
     <!-- p命名空间注入， 可以直接注入属性的值：property -->
     <bean id="user" class="com.xxx.pojo.User" p:name="叶枫" p:age="18"/>
     <!-- c命名空间注入， 通过构造器注入：construct-args -->
     <bean id="user2" class="com.xxx.pojo.User" c:name="叶枫" c:age="17"/>
   </beans>
   ```

2. 测试

   ```java
     @Test
     public void test(){
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       User user = context.getBean("user2", User.class);
       System.out.println(user);
     }
   ```

注意点：p命令和c命名空间不能直接使用，需要导入xml约束

```xml
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
```

### 6.4 Bean的作用域

![image-20210423173951072](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210704103521.png)

1. 单例模式（Spring默认机制）

   ```xml
   <bean id="user2" class="com.xxx.pojo.User" c:name="叶枫" c:age="17" scope="singleton"/>
   ```

   

2. 原型模式

   ````xml
   <bean id="user2" class="com.xxx.pojo.User" scope="prototype"/>
   ````

3. 其余的`request`，`session`，`application`和`websocket`这些个只能在 Web开发中使用到

## 7. Bean的自动装配

- 自动装配是Spring满足bean依赖的一种方式！
- Spring会在上下文中自动寻找，并自动给bean装配属性

在Spring中有三种装配的方式

1. 在xml中显示的配置
2. 在java中显示配置
3. 隐式的自动装配bean [重要]

### 7.1 测试

- 环境搭建：一个人有两个宠物

### 7.2 ByName自动装配

```xml
  <!--
	byName: 会自动在容器上下文中查找，和自己对象set方法后面的值对应的bean的beanID
-->
  <bean id="people" class="com.xxx.pojo.People" autowire="byName">
    <property name="name" value="叶枫"/>
  </bean>
```



### 7.3 ByType自动装配

```xml
  <!--   byType: 会自动在容器上下文中查找，和自己对象属性类型相同的bean -->
  <bean id="people" class="com.xxx.pojo.People">
    <property name="name" value="小叶枫"/>
    <property name="cat" ref="cat"/>
    <property name="dog" ref="dog"/>
  </bean>
```



小结：

- byName的时候，需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致！
- byName的时候，需要保证所有bean的class唯一，并且这个bean需要和自动注入的属性的类型一致！

### 7.4 使用注解实现自动装配

jdk1.5支持的注解， Spring2.5就支持注解了

要使用注解须知：

1. 导入约束: context约束

2. 配置注解支持： <context:annotation-config/>

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           https://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           https://www.springframework.org/schema/context/spring-context.xsd">
   
       <context:annotation-config/>
   
   </beans>
   ```



@Autowired

直接在属性上使用即可！ 也可以在set方式上使用

使用@Autowired我们可以不用编写set方法了，前提是你这个自动装配的属性在IOC（Spring)容器中存在，且符号名字Byname！

科普：

```
@Nullable 字段标记了这个注解，说明这个字段可以为null
```

```java
public @interface Autowired {
  boolean required() default true;
}
```



如果使用@Autowired自动装配的环境比较复杂，自动装配无法通过一个注解【@Autowired】完成的时候、我们可以使用@Qualifier（value=“xxx")去配置@Autowired的使用，指定一个唯一的bean对象注入

```java
public class People {
  @Autowired
  @Qualifier(value = "cat")
  private Cat cat;
  @Autowired
  @Qualifier(value = "dog")
  private Dog dog;
  private String name;
}
```



@Resource注解

```java
public class People {
  @Resource(name = "cat1")
  private Cat cat;
  @Resource
  private Dog dog;
  private String name;
}
```

小结：

@Resource和@Autowired的区别：

- 都是用来自动装配的，都可以放在属性字段上

- @Autowired通过byType的方式实现，而且必须要求这个对象存在 【常用】

- @Resource默认通过byname实现，如果找不到名字，则通过byType实现！如果两个都找不到情况下，就报错 【常用】

- 执行顺序不同：@Autowired通过byType的方式实现。 @Resource默认通过byname实现

  

## 8. 使用注解开发

在使用Spring4之后，要使用注解开发，

1. bean

2. 属性如何注入

   ```java
   // 等价于<bean id="User" class="com.xxx.pojo.User"/>
   // @Component 组件
   @Component
   public class User {
     public String name;
     //  相当于<property name="name" value="1234"/>
     @Value("12345")
     public void setName(String name) {
       this.name = name;
     }
   }
   ```

   

3. 衍生的注解

   @Component有几个衍生注解，我们将在web开发中，会按照MVC三层架构分层！

   - dao [@Repository]
   - service [@Service]
   - controller [@Controller]

   这四个注解功能都是一样的，都代表将某个类注册的Spring中，装配Bean

4. 自动装配置

   ```java
   - @Autowired:自动装配通过类型。名字
   	如果Autowired不能唯一自动装配上属性，则需要通过@Qualifier（value="xxx")
   - @Nullable 字段标记了这个注解，说明这个字段可以为null
   - @Resource 自动装配通过名字。类型
   
   ```

   

5. 作用域

   ```java
   @Component
   @Scope("prototype")
   public class User {
     public String name;
     //  相当于<property name="name" value="1234"/>
     @Value("12345")
     public void setName(String name) {
       this.name = name;
     }
   }
   ```

   

6. 小结

   xml与注解：

   - xml更加万能，适用于任何场合！维护简单方便
   - 注解不是自己类使用不了，维护相对复杂！

   xml与注解最佳实践：

   - xml用来管理bean
   - 注解只负责完成属性的注入
   - 我们在使用的过程中，只需要注意一个问题：必须让注解生效，就需要开启注解的支持

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           https://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           https://www.springframework.org/schema/context/spring-context.xsd">
     <!-- 指定要扫描的包，这个包下的注解就会生效 -->
     <context:component-scan base-package="com.xxx.pojo"/>
     <context:annotation-config/>
   </beans>
   ```



## 9. 使用Java的方式配置Spring

我们现在要完全不适用Spring的xml配置了，全权交给java来做

javaConfig是Spring的一个子项目，在Spring4之后，它成为了一个新功能

![image-20210430114459691](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210704103530.png)

实体类：

```java
package com.xxx.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// 这里这个注解的意思，就是说明这个类被Spring接管了，注册到了容器中
@Component
public class User {
  private String name;

  public String getName() {
    return name;
  }
  @Value("yefeng") // 属性注入值
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" +
            "name='" + name + '\'' +
            '}';
  }
}

```



配置文件：

```java
package com.xxx.config;

import com.xxx.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 这个也会被Spring容器托管，注册到容器中，因为他本来也是一个@component
// @Configuration代表这就是一个配置类，就和我们之前看的beans.xml
@Configuration
@ComponentScan("com.xxx.pojo")
@Import(MyConfig2.class)
public class MyConfig {
//  注册一个bean， 就相当于我们之前写的一个bean标签
//  这个方法的名字,就相当于bean标签中的id属性
//  这个方法的返回值,就相当于bean标签中的class属性
  @Bean
  public User getUser(){
    return new User(); // 就是返回要注入到的bean对象
  }
}


```



测试：

```java
import com.xxx.config.MyConfig;
import com.xxx.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    User getUser = (User) context.getBean("getUser");
    System.out.println(getUser.getName());

  }
}

```

这种纯java的配置方式，在SpringBoot随处可见！

## 10. AOP代理模式

为什么要学习代理模式？

因为这就是SpringAOP的底层 [Spring AOP 和SpringMVC]

代理模式的分类：

- 静态代理
- 动态代理

![image-20210502123431317](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210709103804.png)

### 10.1 静态代理

角色分析：

- 抽象角色：一般会使用接口或者抽象类来解决
- 真是角色：被代理的角色
- 代理角色：代理真实角色，代理真实角色后，我们一般会做一写附属操作
- 客户：访问代理对象的人

代码步骤：

1. 接口

   ```java
   // 租房
   public interface Rent {
     public void Rent();
   }
   
   ```

   

2. 真是角色

   ```java
   // 房东
   public class Host implements Rent{
     @Override
     public void Rent() {
       System.out.println("我要租房子");
     }
   }
   ```

   

3. 代理角色

   ```java
   public class Proxy {
     private Host host;
   
     public Proxy() {
     }
   
     public Proxy(Host host) {
       this.host = host;
     }
   
     public void setHost(Host host) {
       this.host = host;
     }
     public void rent(){
       host.Rent();
       seeHouse();
       hetong();
       fare();
     }
   //  看房
     public void seeHouse(){
       System.out.println("中介带你看房");
     }
     public void hetong(){
       System.out.println("签合同");
     }
     public void fare(){
       System.out.println("收中介费");
     }
   }
   ```

   

4. 客户端访问代理角色

   ```java
   public class Client {
     public static void main(String[] args) {
       Host host = new Host();
   //    代理
       Proxy proxy = new Proxy(host);
       proxy.rent();
     }
   }
   ```

   

代理模式的好处：

- 可以使真是角色的操作更加纯粹！不用去关注一些公共的业务
- 公共也就就交给代理角色！实现了业务的分工
- 公共业务发生扩展的时候，方便集中管理！

缺点：

- 一个真是角色就会产生一个代理角色；代码量会翻倍~开发效率会变低~

### 10.2 加深理解

代码：

1. 接口

   ```java
   public interface UserService {
     public void add();
     public void delete();
     public void update();
     public void query();
   }
   
   ```

   

2. 真是角色

   ```java
   public class UserServiceImpl implements UserService{
     @Override
     public void add() {
       System.out.println("添加了一个用户");
     }
   
     @Override
     public void delete() {
       System.out.println("删除了一个用户");
     }
   
     @Override
     public void update() {
       System.out.println("修改了一个用户");
     }
   
     @Override
     public void query() {
       System.out.println("查询了一个用户");
     }
   //  改动原有的业务代码，是公司大忌
   }
   ```

   

3. 代理角色

   ```java
   public class UserServiceProxy implements UserService{
     private UserServiceImpl userService;
   
     public void setUserService(UserServiceImpl userService) {
       this.userService = userService;
     }
   
     @Override
     public void add() {
       log("add");
       userService.add();
     }
   
     @Override
     public void delete() {
       log("delete");
       userService.delete();
     }
   
     @Override
     public void update() {
       log("update");
       userService.update();
     }
   
     @Override
     public void query() {
       log("query");
       userService.query();
     }
   //  日志方法
     public void log(String msg){
       System.out.println("debug 使用了" + msg + "方法");
     }
   }
   
   ```

   

4. 客户端访问代理角色

   ```java
   public class Cient {
     public static void main(String[] args) {
       UserServiceImpl userService = new UserServiceImpl();
       UserServiceProxy proxy = new UserServiceProxy();
       proxy.setUserService(userService);
       proxy.add();
     }
   }
   ```

   

AOP理解

![image-20210502130054519](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210704103623.png)

### 10.3 动态代理

- 动态代理和静态代理角色一样
- 动态代理的代理类是动态生成的，不是我们直接写好的！
- 动态代理分为两大类：基于接口的动态代理， 基于类的动态代理
  - 基于接口--JDK动态代理  	[我们使用这个]
  - 基于类：cglib
  - java字节码实现：javasist

需要了解两个类：Proxy代理，InvocationHandler：调用处理程序



动态代理的好处：

- 可以使真是角色的操作更加纯粹！不用去关注一些公共的业务
- 公共也就就交给代理角色！实现了业务的分工
- 公共业务发生扩展的时候，方便集中管理！
- 一个动态搭理类代理的是一个接口，一般就是对应的一类业务
- 一个动态代理类可以代理多个类，只要是实现了同一个接口即可！



## 11. AOP

### 11.1 什么是AOP

AOP (Aspect Oriented Programming)意为:面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术。AOP是OOP的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。
![在这里插入图片描述](https://raw.githubusercontent.com/lengyingmofeng/imgs/main/imgs/20201112130947442.png)

### 11.2 AOP在Spring中的作用

**提供声明式事物；允许用户自定义切面**

- 横切关注点:跨越应用程序多个模块的方法或功能。即是，与我们业务逻辑无关的，但是我们需要关注的部分，就是横切关注点。如日志，安全，缓存，事务等等....
- 切面(ASPECT):横切关注点被模块化的特殊对象。即，它是一个类。

- 通知(Advice):切面必须要完成的工作。即，它是类中的一个方法。

- 目标（Target):被通知对象。

- 代理(Proxy) :向目标对象应用通知之后创建的对象。
- 切入点(PointCut):切面通知执行的“地点"的定义
- 连接点(JointPoint) : 与切入点匹配的执行点。

![在这里插入图片描述](https://raw.githubusercontent.com/lengyingmofeng/imgs/main/imgs/20201112131307360.png)

在SpringAOP，通过Advice定义横切逻辑，Spring中支持5种类型的advice：

![在这里插入图片描述](https://raw.githubusercontent.com/lengyingmofeng/imgs/main/imgs/20201120104454887.png)

即Aop在不改变原有代码的情况下，去增加新的功能

### 11.3 使用Spring 实现Aop

导入Aop依赖包

```xml
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjweaver</artifactId>
      <version>1.9.4</version>
    </dependency>
```

搭建需求：

1. 创建接口

   ```java
   package com.xxx.service;
   
   public interface UserService {
     public void add();
     public void delete();
     public void update();
     public void query();
   }
   
   ```

2. 调用接口

   ```java
   package com.xxx.service;
   
   public class UserServiceImpl implements UserService{
   
     @Override
     public void add() {
       System.out.println("添加了一个用户");
     }
   
     @Override
     public void delete() {
       System.out.println("删除了一个用户");
     }
   
     @Override
     public void update() {
       System.out.println("修改了一个用户");
     }
   
     @Override
     public void query() {
       System.out.println("查询了一个用户");
     }
   }
   
   ```



#### 方式一：使用Spring的API接口 [主要SpringAPI接口实现]

1. 创建日志类

   **前置日志**

   ```java
   package com.xxx.log;
   
   import org.springframework.aop.MethodBeforeAdvice;
   
   import java.lang.reflect.Method;
   
   public class Log implements MethodBeforeAdvice {
   //  method： 要执行的目标对象的方法
   //  args：参数
   //  target： 目标对象
     @Override
     public void before(Method method, Object[] objects, Object target) throws Throwable {
       System.out.println(target.getClass().getName() + "的" + method.getName() + "被执行了");
     }
   }
   
   ```

   **后置日志**

   ```java
   package com.xxx.log;
   
   import org.springframework.aop.AfterReturningAdvice;
   
   import java.lang.reflect.Method;
   
   public class AfterLog implements AfterReturningAdvice {
   //  returnValue:返回值
   
     @Override
     public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
       System.out.println("执行了" + method.getName() + "方法，返回结果为：" + returnValue);
     }
   }
   
   ```

   

2. 创建applicationContext.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:aop="http://www.springframework.org/schema/aop"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/aop
           http://www.springframework.org/schema/aop/spring-aop.xsd">
     <bean id="userService" class="com.xxx.service.UserServiceImpl"/>
     <bean id="log" class="com.xxx.log.Log"/>
     <bean id="afterLog" class="com.xxx.log.AfterLog"/>
   <!--   方式一：使用原生SpringAPI接口-->
   <!--   配置aop-->
     <aop:config>
       <!-- 切入点:execution:表达式，execution（要执行的位置！ 修饰符， 返回值， 类型， 方法名 ）  -->
       <aop:pointcut id="pointcut" expression="execution(* com.xxx.service.UserServiceImpl.*(..))"/>
       <!--  执行环绕增强  -->
       <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
       <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/>
     </aop:config>
   </beans>
   ```

   

3. 测试

   ```java
   import com.xxx.service.UserService;
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.support.ClassPathXmlApplicationContext;
   
   public class MyTest {
     public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
   //    动态代理代理的是接口：注意点
       UserService bean = context.getBean(UserService.class);
       bean.add();
       bean.query();
     }
   }
   
   ```

   

#### 方式二：自定义来实现AOP [主要是切面定义]

1. 自定义类

   ```java
   package com.xxx.diy;
   
   public class DiyPointCut {
     public void before(){
       System.out.println("执行前");
     }
     public void after(){
       System.out.println("执行后");
     }
   }
   
   ```

   

2. applicationContext.xml配置

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:aop="http://www.springframework.org/schema/aop"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/aop
           http://www.springframework.org/schema/aop/spring-aop.xsd">
     <!-- 方式二：自定义类 -->
     <bean id="diy" class="com.xxx.diy.DiyPointCut"/>
     <aop:config>
       <!--  自定义切面，ref要引用的类  -->
       <aop:aspect ref="diy">
       <!--   切入点   -->
         <aop:pointcut id="point" expression="execution(* com.xxx.service.UserServiceImpl.* (..))"/>
         <!--通知-->
         <aop:before method="before" pointcut-ref="point"/>
         <aop:after method="after" pointcut-ref="point"/>
       </aop:aspect>
     </aop:config>
   
   </beans>
   ```

   ​	

3. 测试

   ```java
   import com.xxx.service.UserService;
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.support.ClassPathXmlApplicationContext;
   
   public class MyTest {
     public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
   //    动态代理代理的是接口：注意点
       UserService bean = context.getBean(UserService.class);
       bean.add();
       bean.query();
     }
   }
   
   ```



#### 方式三：使用注解实现

1. 创建类

   ````java
   package com.xxx.diy;
   
   import org.aspectj.lang.ProceedingJoinPoint;
   import org.aspectj.lang.annotation.After;
   import org.aspectj.lang.annotation.Around;
   import org.aspectj.lang.annotation.Aspect;
   import org.aspectj.lang.annotation.Before;
   
   // 标记这个类是一个切面
   @Aspect
   public class AnnotationPoiontCut {
     @Before("execution(* com.xxx.service.UserServiceImpl.*(..))")
     public void before(){
       System.out.println("使用前");
     }
   
     @After("execution(* com.xxx.service.UserServiceImpl.*(..))")
     public void after(){
       System.out.println("使用后");
     }
   //  在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
     @Around("execution(* com.xxx.service.UserServiceImpl.*(..))")
     public void around(ProceedingJoinPoint jp) throws Throwable {
       System.out.println("环绕前");
   //    执行方法
       Object proceed = jp.proceed();
       System.out.println("环绕后");
     }
   }
   
   ````

2. 配置applicationContext.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:aop="http://www.springframework.org/schema/aop"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/aop
           http://www.springframework.org/schema/aop/spring-aop.xsd">
     <!-- 方式三 -->
     <bean id="annotationPointCut" class="com.xxx.diy.AnnotationPoiontCut"/>
     <!-- 开启注解 默认JDK proxy-target-class="false" proxy-target-class="true" -->
     <aop:aspectj-autoproxy/>
   </beans>
   ```

3. 测试

   ```java
   import com.xxx.service.UserService;
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.support.ClassPathXmlApplicationContext;
   
   public class MyTest {
     public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
   //    动态代理代理的是接口：注意点
       UserService bean = context.getBean(UserService.class);
       bean.add();
       bean.query();
     }
   }
   
   ```



## 12 整合Mybatis

步骤：

1. 导入相关jar包
   - junit
   
     ```xml
     <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
     </dependency>
     ```
   
     
   
   - mybatis
   
     ```xml
     <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.2</version>
     </dependency>
     ```
   
     
   
   - mysql数据库
   
     ```xml
     <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
     </dependency>
     ```
   
     
   
   - spring相关的
   
     ```xml
     <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.1.10.RELEASE</version>
     </dependency>
     <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.1.10.RELEASE</version>
     </dependency>
     ```
   
     
   
   - aop织入
   
     ```xml
     <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.4</version>
     </dependency>
     ```
   
     
   
   - mybatis-spring 2 **重点**
   
     ```xml
     <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>2.0.2</version>
     </dependency>
     ```
   
   - 配置maven静态资源过滤问题！
   
     ```xml
     <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
     </build>
     ```
   
2. 编写配置文件
3. 测试

### 12.1 回忆mybatis

1. 编写实体类

   ```java
   public class User {
      private int id;  //id
      private String name;   //姓名
      private String pwd;   //密码
   }
   ```

   

2. 编写核心配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE configuration
          PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-config.dtd">
   <configuration>
   
      <typeAliases>
          <package name="com.kuang.pojo"/>
      </typeAliases>
   
      <environments default="development">
          <environment id="development">
              <transactionManager type="JDBC"/>
              <dataSource type="POOLED">
                  <property name="driver" value="com.mysql.jdbc.Driver"/>
                  <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=utf8"/>
                  <property name="username" value="root"/>
                  <property name="password" value="123456"/>
              </dataSource>
          </environment>
      </environments>
   
      <mappers>
          <package name="com.kuang.dao"/>
      </mappers>
   </configuration>
   
   ```

   

3. 编写接口

   ```xml
   public interface UserMapper {
      public List<User> selectUser();
   }
   
   ```

   

4. 编写Mapper.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
          PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <mapper namespace="com.kuang.dao.UserMapper">
   
      <select id="selectUser" resultType="User">
       select * from user
      </select>
   
   </mapper>
   
   ```

   

5. 测试

   ```java
   @Test
   public void selectUser() throws IOException {
   
      String resource = "mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = newSqlSessionFactoryBuilder().build(inputStream);
      SqlSession sqlSession = sqlSessionFactory.openSession();
   
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
   
      List<User> userList = mapper.selectUser();
      for (User user: userList){
          System.out.println(user);
     }
   
      sqlSession.close();
   }
   
   ```

   

### 12.2 Mybatis-Spring

引入Spring之前需要了解mybatis-spring包中的一些重要类；

http://www.mybatis.org/spring/zh/index.html

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613182215232.png)

**什么是 MyBatis-Spring？**

MyBatis-Spring 会帮助你将 MyBatis 代码无缝地整合到 Spring 中。

**知识基础**

在开始使用 MyBatis-Spring 之前，你需要先熟悉 Spring 和 MyBatis 这两个框架和有关它们的术语。这很重要

MyBatis-Spring 需要以下版本：

| MyBatis-Spring | MyBatis | Spring 框架 | Spring Batch | Java    |
| -------------- | ------- | ----------- | ------------ | ------- |
| 2.0            | 3.5+    | 5.0+        | 4.0+         | Java 8+ |
| 1.3            | 3.4+    | 3.2.2+      | 2.1+         | Java 6+ |

如果使用 Maven 作为构建工具，仅需要在 pom.xml 中加入以下代码即可：

```xml
<dependency>
   <groupId>org.mybatis</groupId>
   <artifactId>mybatis-spring</artifactId>
   <version>2.0.2</version>
</dependency>

```



要和 Spring 一起使用 MyBatis，需要在 Spring 应用上下文中定义至少两样东西：一个 SqlSessionFactory 和至少一个数据映射器类。

在 MyBatis-Spring 中，可使用SqlSessionFactoryBean来创建 SqlSessionFactory。要配置这个工厂 bean，只需要把下面代码放在 Spring 的 XML 配置文件中：

```xml
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
 <property name="dataSource" ref="dataSource" />
</bean>

```



注意：SqlSessionFactory需要一个 DataSource（数据源）。这可以是任意的 DataSource，只需要和配置其它 Spring 数据库连接一样配置它就可以了。

在基础的 MyBatis 用法中，是通过 SqlSessionFactoryBuilder 来创建 SqlSessionFactory 的。而在 MyBatis-Spring 中，则使用 SqlSessionFactoryBean 来创建。

在 MyBatis 中，你可以使用 SqlSessionFactory 来创建 SqlSession。一旦你获得一个 session 之后，你可以使用它来执行映射了的语句，提交或回滚连接，最后，当不再需要它的时候，你可以关闭 session。

SqlSessionFactory有一个唯一的必要属性：用于 JDBC 的 DataSource。这可以是任意的 DataSource 对象，它的配置方法和其它 Spring 数据库连接是一样的。

一个常用的属性是 configLocation，它用来指定 MyBatis 的 XML 配置文件路径。它在需要修改 MyBatis 的基础配置非常有用。通常，基础配置指的是 < settings> 或 < typeAliases>元素。

需要注意的是，这个配置文件并不需要是一个完整的 MyBatis 配置。确切地说，任何环境配置（），数据源（）和 MyBatis 的事务管理器（）都会被忽略。SqlSessionFactoryBean 会创建它自有的 MyBatis 环境配置（Environment），并按要求设置自定义环境的值。

SqlSessionTemplate 是 MyBatis-Spring 的核心。作为 SqlSession 的一个实现，这意味着可以使用它无缝代替你代码中已经在使用的 SqlSession。

模板可以参与到 Spring 的事务管理中，并且由于其是线程安全的，可以供多个映射器类使用，你应该总是用 SqlSessionTemplate 来替换 MyBatis 默认的 DefaultSqlSession 实现。在同一应用程序中的不同类之间混杂使用可能会引起数据一致性的问题。

可以使用 SqlSessionFactory 作为构造方法的参数来创建 SqlSessionTemplate 对象。

```xml
<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
 <constructor-arg index="0" ref="sqlSessionFactory" />
</bean>

```



现在，这个 bean 就可以直接注入到你的 DAO bean 中了。你需要在你的 bean 中添加一个 SqlSession 属性，就像下面这样：

```java
public class UserDaoImpl implements UserDao {

 private SqlSession sqlSession;

 public void setSqlSession(SqlSession sqlSession) {
   this.sqlSession = sqlSession;
}

 public User getUser(String userId) {
   return sqlSession.getMapper...;
}
}
```



按下面这样，注入 SqlSessionTemplate：

```xml
<bean id="userDao" class="org.mybatis.spring.sample.dao.UserDaoImpl">
 <property name="sqlSession" ref="sqlSession" />
</bean>
```

## 13. 事务管理

### 13. 1. 回顾事物

- 把一组业务当成一个业务来做；要么都成功，要么都失败
- 事物在项目开发中，十分的重要，涉及到数据的一致性问题，不能马虎！
- 确保完整性和一致性

事物的ACID原则：

- 原子性
- 一致性
- 隔离性
  - 多个业务可能操作同一个资源，防止数据损坏
- 持久性
  - 事物一旦提交，无论系统发生什么问题，结果都不会再被影响，被持久化的写到存储器中！



### 13.2 spring中的事务管理

- 声明式事物：AOP
- 编程式事物：需要在代码中，进行事物的管理



思考：

为什么需要事物？

- 如果不配置事物，可能存在数据提交不一致的情况下
- 如果我们不在Spring中去配置声明式事物，我们就需要在代码手动配置事物！
- 事物在项目开发中十分的重要，设计到数据的一致性和完整性问题，不容马虎！

