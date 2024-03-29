[TOC]

# Spring & Spring Boot

## 什么是框架？

具有约束性的，支撑开发人员去实现各种功能的半成品的项目。

## 什么是容器？

容器是一种为某种特定组件的运行提供必要支持的软件环境。

例如，`Tomcat` 就是一个 `Servlet` 容器，它可以为 `Servlet` 提供运行环境。还有类似 `Docker` 提供了必要的 `Linux` 环境以便运行特定的 `Linux` 进程。

## 什么是 `Spring` ？

![Spring主要模块](Spring.assets/jvme0c60b4606711fc4a0b6faf03230247a.png)

---

`Spring` 是一个支持快速开发 `Java EE` 应用程序的框架。它提供了一系列底层容器和基础设施，并可以和大量常用的开源框架集成。

> 部分模块：`Spring Core`、`Spring AOP`、`Spring Data Access`、`Spring Web`、`Spring TestX`...

## `IoC` 原理，为什么要使用 `IoC`？

**`IoC` (`Inverse of Control`)** **控制反转**是一种设计思想，将原本在程序中手动创建对象的控制权，交由 `Spring` 框架来管理。其中**控制**指的是对象创建 (实例化、管理) 的权力、**反转**指的是将控制权交给 `Spring` 框架。

在传统应用程序中，控制权在程序本身，会产生很多缺点。

如果一个系统有大量的组件，他们生命周期和相互之间的依赖关系还由组件自身来维护的话，会大大增加系统的复杂度，会导致组件之间的耦合，给测试和维护带来很大困难。

在使用 `IoC` 的时候，控制权发生了反转，`IoC` 容器掌握了控制权，所有组件不再由应用程序自己创建和配置。这样，应用程序可以直接使用已经创建并配置好的组件。

> 例如在一个图书管理系统中，`BookService` 需要 `DataSource` 组件来对数据库进行操作，传统方法是在 `BookService` 中 `new` 一个 `DataSource`；使用了 `IoC` 之后，`BookService` 不需要再自己创建 `DataSource` ，而是等待 `IOC容器` 注入一个 `DataSource`。
>
> 所以 `IoC` 又称为 `Dependency Injection` 依赖注入，它将组件的创建和配置与组件的使用分离，由 `IoC` 容器管理组件的生命周期。

## 什么是 `AOP`？

`AOP` 是 `Aspect Oriented Programming` 面向切面编程。

> `OOP` 是 `Object Oriented Programming` 面向对象编程，`OOP` 的主要功能是数据封装继承和多态。

`AOP` 是一种新的编程方式，它和 `OOP` 不同，`OOP` 把系统看作多个对象的交互，`AOP` 把系统分解为不同的关注点，或者称为切面 `Aspect`。其实就是将那些与业务无关，却为业务模块所共同调用的逻辑 (例如事务处理、日志管理、权限控制等) 封装起来，减少系统的重复代码，降低模块间的耦合度，提高可拓展性和可维护性。

> 例如在图书管理系统中，业务组件 `BookService` 中有添加新的书籍 `createBook()` 这个业务方法，在传统的 `OOP` 中该方法中除了实现业务逻辑，还需要进行安全检查、日志记录和事务处理等，这些代码会重复出现在每个业务方法中，很难模块化。而使用 `AOP` 可以把安全检查、日志记录和事务处理抽取为三个 `Aspect` ，织入到 `BookService` 中。在调用 `createBook()` 方法时，会对方法进行拦截，并在拦截前后进行安全检查、日志、事务等处理。

**`AOP` 是基于动态代理的**，如果要代理的对象实现了接口，那么 `Spring AOP` 会使用 **`JDK Proxy`**，去创建代理对象。对于没有实现接口的对象 `Spring AOP` 会使用 **`Cglib Proxy`** 生成一个被代理对象的子类来作为代理对象。也可以使用 `AspectJ` 作为 `AOP` 框架。

### `Spring AOP` 和 `AspectJ AOP` 有什么区别？

**`Spring AOP` 属于运行时增强，而 `AspectJ` 是编译时增强。** `Spring AOP` 基于代理 (`Proxying`)，而 `AspectJ` 基于字节码操作 ( `Bytecode Manipulation` )。

## Spring Bean

`Bean` 代指的就是被 `IoC` 容器所管理的对象。可以通过 `xml` 、注解或配置类来配置数据。

### 将一个类声明为 `Bean` 的注解有哪些？

- `@Component`：通用的注解，可标注任意类为 `Spring` 组件。如果一个 `Bean` 不知道属于哪个层，可以使用`@Component` 注解标注。
- `@Repository`：对应持久层即 `Dao` 层，主要用于数据库相关操作。
- `@Service`：对应服务层，主要涉及一些复杂的业务逻辑。
- `@Controller`：对应 `Spring MVC` 控制层，主要接受用户请求并调用 `Service` 层返回数据给前端页面。

### `@Component` 和 `@Bean` 的区别是什么？

- `@Component` 作用于类，而 `@Bean` 作用于方法。

- `@Component` 通常是通过类路径扫描来自动侦测以及自动装配到 `Spring` 容器中

  可以使用 `@ComponentScan` 定义要扫描的路径从中找出标识了需要装配的类自动装配到 `Spring` 容器中。

  `@Bean` 根据方法返回的对象产生一个 `Bean` 对象，并将这个对象交给 `Spring` 管理。产生这个 `Bean` 对象的方法`Spring` 只会调用一次，随后这个 `Spring` 将会将这个 `Bean` 对象放在自己的 `IOC` 容器中。

### 注入 `Bean` 的注解有哪些？

`Spring` 内置的 `@Autowired` 以及 `JDK` 内置的 `@Resource` 和 `@Inject` 都可以用于注入 `Bean`。

### `@Inject` 注解

可以用在构造方法和普通方法，自动注入参数。

也可以在属性上直接注入。

### `@Autowired` 和 `@Resource` 的区别是什么？

`Autowired` 属于 `Spring` 内置的注解，默认的注入方式为 `byType` (根据类型进行匹配)，会优先根据接口类型去匹配并注入 `Bean` (接口的实现类)。

当一个接口存在多个实现类的话，`byType` 的方式会找到多个满足条件的 `Bean`。这种情况下，注入方式会变为 `byName` (根据名称进行匹配)，名称通常就是首字母小写的类名。

一般通过 `@Qualifier` 来显式指定名称而不是依赖变量的名称。`@Qualifier(value = "className")`。

`@Resource` 属于 `JDK` 提供的注解，默认注入方式为 `byName`。如果无法通过名称匹配到对应的 `Bean`，注入方式变为 `byType`。`@Resource` 比较常用的属性：`name`、`type`。

### `@RestController` 的作用？

`@RestController` 是 `@Controller` 和 `@ResponseBody` 的合集。

表示这个 `controller` 的所有 `API` 返回的都是数据 ，不会返回视图。

### `Bean` 的作用域 (`@Scope`)？

`Spring` 中 `Bean` 的作用域通常有下面几种：

- **`singleton`**：单实例。`Spring` 中的 `Bean` 默认都是单例的，对应单例设计模式的应用。
- **`prototype`**：每次从容器中调用 `Bean`，都返回一个新的实例。
- **`request`**：每一次 `HTTP` 请求都会产生一个新的 `Bean`，仅在当前 `HTTP request` 内有效。
- **`session`**：每一次来自新 `session` 的 `HTTP` 请求都会产生一个新的 `Bean`，仅在当前 `HTTP session` 内有效。

### 单例 `Bean` 的线程安全问题？

当多个线程操作同一个对象的时候存在资源竞争。如果 `Bean` 中存在可变的成员变量，多线程情况下可能会造成数据不一致。

可以在类中定义一个 `ThreadLocal` 成员变量，将可变成员变量保存在 `ThreadLocal` 中。

### `Bean` 的生命周期？

![Spring Bean 生命周期](Spring.assets/b5d264565657a5395c2781081a7483e1.jpg)

---

// TODO

### Spring 循环依赖问题？

使用三级缓存机制解决循环依赖问题。

* 「singletonObjects」中缓存的是已经经历了完整生命周期的bean对象。
* 「earlySingletonObjects」比 singletonObjects 多了一个 early ，表示缓存的是早期的 bean对象。早期指的是 Bean 的生命周期还没走完就把这个 Bean 放入了 earlySingletonObjects。
* 「singletonFactories」中缓存的是 ObjectFactory，表示对象工厂，用来创建某个对象的。

![在这里插入图片描述](Spring.assets/4f8be94c2b604ff09bff074414221a5c.png)

A 的 Bean 在创建过程中，在进行依赖注入之前，先把 A 的原始 Bean 放入缓存（提早暴露，只要放到缓存了，其他 Bean 需要时就可以从缓存中拿了），放入缓存后，再进行依赖注入，此时 A 的Bean 依赖了 B 的 Bean 。

如果 B 的 Bean 不存在，则需要创建 B 的 Bean，而创建 B 的 Bean 的过程和 A 一样，也是先创建一个 B 的原始对象，然后把 B 的原始对象提早暴露出来放入缓存中，然后在对 B 的原始对象进行依赖注入 A，此时能从缓存中拿到 A 的原始对象（虽然是 A 的原始对象，还不是最终的 Bean），B 的原始对象依赖注入完了之后，B 的生命周期结束，那么 A 的生命周期也能结束。

因为整个过程中，都只有一个 A 原始对象，所以对于 B 而言，就算在属性注入时，注入的是 A 原始对
象，也没有关系，因为A 原始对象在后续的生命周期中在堆中没有发生变化。

## 前后端传值注解？

### `@PathVariable` 和 `@RequestParam`？

`@PathVariable`用于获取路径参数，`@RequestParam`用于获取查询参数。一个方法可以有多个 `@RequestParam`和 `@PathVariable`。

```java
@RequestMapping("/sys/{path}/student");
public Student getStudent(
    @PathVariable("path") String path, 
    @RequestParam(value = "name") String name) {
    ...
}
// "/sys/xxx/student?name=param" => path=xxx, name=param
```

### `@RequestBody`?

用于读取 `Request` 请求 (可能是 `POST`、`PUT`、`DELETE`、`GET` 请求) 的 `body` 部分并且 **`Content-Type` 为 `application/json`** 格式的数据，接收到数据之后会自动将数据绑定到 `Java` 对象。

`Spring` 会使用 `HttpMessageConverter` 将请求的 `body` 中的 `json` 字符串转换为 `java` 对象。

一个请求方法只可以有一个`@RequestBody`。

## 全局异常处理？

// TODO

### `Spring` 如何解决循环依赖问题？

#### 构造器注入循环依赖
无法解决，抛出异常。

#### field属性注入（setter方法注入）循环依赖
![img.png](Spring.assets/Spring创建Bean的流程.png)

* `createBeanInstance`：实例化，其实也就是调用对象的构造方法实例化对象。
* `populateBean`：填充属性，这一步主要是对bean的依赖属性进行注入(@Autowired)。
* `initializeBean`：回到一些形如initMethod、InitializingBean等方法

循环依赖主要发生在第二步（populateBean），也就是field属性注入的处理。




## `Spring MVC`

`MVC` 是一个设计模式。它被分为三个核心部件：模型、视图、控制器。其核心思想是将业务逻辑、数据、显示分离。

- 视图是用户看到并与之交互的界面。
- 模型表示业务数据，并提供数据给视图。
- 控制器接受用户的请求并调用模型和视图去完成用户的请求。

`Spring MVC` 一般把后端项目分为 `Service` 层 (处理业务)、`Dao` 层 (数据库操作)、`Entity` 层 (实体类)、`Controller` 层 (控制层)。

### SpringMVC 工作原理？

![img](Spring.assets/de6d2b213f112297298f3e223bf08f28.png)

---

1. 客户端（浏览器）发送请求，直接请求到 `DispatcherServlet`。
2. `DispatcherServlet` 根据请求信息调用 `HandlerMapping`，解析请求对应的 `Handler`。
3. 解析到对应的 `Handler`（也就是我们平常说的 `Controller` 控制器）后，开始由 `HandlerAdapter` 适配器处理。
4. `HandlerAdapter` 会根据 `Handler`来调用真正的处理器开处理请求，并处理相应的业务逻辑。
5. 处理器处理完业务后，会返回一个 `ModelAndView` 对象，`Model` 是返回的数据对象，`View` 是个逻辑上的 `View`。
6. `ViewResolver` 会根据逻辑 `View` 查找实际的 `View`。
7. `DispaterServlet` 把返回的 `Model` 传给 `View`（视图渲染）。
8. 把 `View` 返回给浏览器。

## `Spring` 事务

### 什么是事务？

事务是逻辑上的一组操作，要么都执行，要么都不执行。

如果组中的所有操作都成功，则认为事务成功，即使只有一个操作失败，事务也不成功。如果一个操作失败，则事务将回滚，该事务所有操作的影响都将取消。

### 事务的特性 (`ACID`) 了解么？

1. 原子性 `atomicity`：即不可分割性，事务中的操作要么全部被执行，要么全部不执行。
2. 一致性 `consistency`：事务执行前后数据库状态都是正确的，例如 `A` 向 `B`  转账是一个事务，转账后两人的余额总和是不变的 。
3. 隔离性 `isolation`：数据库允许多个并发事务同时对数据进行读写，隔离性可以防止多个事务并发执行时由于交叉执行而导致数据的不一致。事务隔离分为不同级别，包括未提交读 (`Read uncommitted`)、读已提交 (`read committed`)、可重复读(`repeatable read`) 和串行化 (`Serializable`)。
4. 持久性 `durability`：当事务正确提交之后，其结果将永久保存在数据库中。

###  `MySQL` 怎么保证原子性的？

如果想要保证事务的原子性，就需要在异常发生时，对已经执行的操作进行**回滚**。在 `MySQL` 中，恢复机制是通过 **回滚日志 (`undo log`)** 实现的，所有事务进行的修改都会先记录到这个回滚日志中，然后再执行。

如果执行过程中遇到异常，`Mysql` 会利用 **回滚日志** 中的信息将数据回滚到修改之前。

并且，回滚日志会先于数据持久化到磁盘上。这样就保证了即使数据库突然宕机，用户再次启动数据库还能够通过查询回滚日志来回滚将之前未完成的事务。

### `Spring` 支持两种方式的事务管理？

- 编程式事务：在代码中硬编码。通过 `TransactionTemplate` 或者 `TransactionManager` 手动管理事务。
- 声明式事务：基于 `XML` 或**注解**实现。实际也是通过 `AOP` 来实现。

### `Spring` 事务管理接口？

事务管理相关最重要的 `3` 个接口：

- **`PlatformTransactionManager`**：(平台) 事务管理器，`Spring` 事务的核心。

  其中定义了获得事务、提交事务和回滚事务三个方法。由不同平台的事务管理器去实现他们。

- **`TransactionDefinition`**：定义事务信息。它是 `PlatformTransactionManager` 中 `getTransaction(TransactionDefinition definition)` 方法的参数。

  其中定义了，获取事务传播行为、隔离级别、超时时间、是否只读的方法。

- **`TransactionStatus`**：记录事务的状态。它是 `PlatformTransactionManager` 中 `getTransaction()` 方法的返回值。

  其中定义了，判断事务是否是新事务、是否为只回滚、是否已完成等方法。

### 事务传播行为？

**`PROPAGATION_REQUIRED`**：

**`PROPAGATION_REQUIRES_NEW`**：

**`PROPAGATION_NESTED`**：

**`PROPAGATION_MANDATORY`**：

// TODO



### 事务隔离级别？

`MySQL` 默认采用的 `REPEATABLE_READ` 隔离级别，`Oracle` 默认采用的 `READ_COMMITTED` 隔离级别。

1. 读未提交 `READ_UNCOMMITTED`：一个事务可以读取另一个未提交事务的数据。

   **可能会导致脏读、不可重复读或幻读**。

2. 读已提交 `READ_COMMITTED`：一个事务要等另一个事务提交后才能读取数据。

   **可能会导致不可重复读或幻读**。

3. 可重复读 `REPEATABLE_READ`：事务开启，不再允许其他事务的 `UPDATE` 修改操作。

   **可能会导致幻读**。

4. 串行化 `SERIALIZABLE`：最高的事务隔离级别，在该级别下，事务串行化顺序执行，可以避免脏读、不可重复读与幻读。但是这种事务隔离级别效率低下，比较耗数据库性能，一般不使用。

### Spring 事务失效的情况？

* 事务控制类没有被Spring IOC容器管理。

* 方法中抛出受检查异常，spring默认只会回滚非检查异常和error异常。可以通过配置 `配置rollbackFor`解决。

* 方法自己捕获了异常。spring事务只有捕捉到了业务抛出去的异常，才能进行后续的处理。可以通过将捕获到的异常原样抛出；`setRollbackOnly()` 来解决。

* 事务控制的方法非public、方法用final、static修饰。

### 并发事务带来的问题？

**脏读：**一个事务得到了另一个事务尚未提交的数据。

**不可重复读：**一个事务范围内两个相同的查询返回了不同的数据 (中途其他事务改变了数据)。

**幻读：**幻读与不可重复读类似。当事务 `A` 读取了几行数据，接着事务 `B` 插入了一些数据。随后事务 `A` 再次查询数据，就会发现多了一些原本不存在的记录，像发生了幻觉一样，所以称为幻读。

**不可重复读和幻读区别：**

不可重复读的重点是修改。比如多次读取一条记录发现其中某些列的值被修改。

幻读的重点在于新增或者删除。比如多次执行同一条查询语句时，发现记录增多或减少了。

### 事务只读属性？

对于只有读取数据查询的事务，可以指定事务类型为 `readonly`，即只读事务。只读事务不涉及数据的修改，数据库会提供一些优化手段，适合用在有多条数据库查询操作的方法中。

- 如果一次执行单条查询语句，则没有必要启用事务支持。
- 如果一次执行多条查询语句，例如统计查询，报表查询，在这种场景下，多条查询 `SQL` 必须保证整体的读一致性。否则在执行两条 `SQL` 之间，数据发生改变，则该次整体的统计查询将会出现读数据不一致的情况，此时应该启用事务。

### 事务回滚规则？

默认情况下，事务只有遇到 `Error` 和运行期异常 (`RuntimeException` 的子类) 才会回滚。在遇到检查型(`Checked`) 异常时不会回滚。

可以使用 `@Transactional(rollbackFor= MyException.class)` 来自定义要回滚的异常。

### `@Transactional` 注解？

一般作用在方法和类上，作用在类上表示对所有的 `public` 都生效。

**`@Transactional` 的常用配置参数**：事务传播行为、事务隔离级别、超时时间、是否只读和回滚类型。

`@Transactional` 的工作机制是基于 `AOP` 实现的。

// TODO 

## `Spring Boot`

### 相比于 `Spring` 的优点

* 遵循"习惯优于配置"原则，springboot只需要很少的配置。
* 可以完全不使用xml文件配置，只使用自动配置和JAVA Config即可。
* 内嵌的Tomcat服务器，不需要额外配置服务器。
* spring boot提供了更多的starters来快速构建业务框架，starters可以理解为启动器，包含了一些列可以集成到应用的依赖，可以一站式集成spring及其他技术，而不需要到处找依赖包。
* 项目可以快速构建，另外还可以更加简单的配置整合第三方框架。

### Spring Boot 启动流程？

运行一个SpringBoot项目，引入相关 `Starters` 和依赖后，再编写一个启动类，在这个启动类标上 `@SpringBootApplication` 注解，就可以启动运行项目了。

```java
//MainApplication.java
@SpringBootApplication
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
```

如上代码，在 `MainApplication` 启动类上标注了 `@SpringBootApplication` 注解，然后在 `main` 函数中调用`SpringApplication.run(MainApplication.class, args);` 这句代码就可以启动 SpringBoot。

```java
// SpringBootApplication.java 
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = {
		// TODO 这两个排除过滤器TypeExcludeFilter和AutoConfigurationExcludeFilter暂不知道啥作用
		@Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public @interface SpringBootApplication {
        // 等同于EnableAutoConfiguration注解的exclude属性
	@AliasFor(annotation = EnableAutoConfiguration.class)
	Class<?>[] exclude() default {};
        // 等同于EnableAutoConfiguration注解的excludeName属性
	@AliasFor(annotation = EnableAutoConfiguration.class)
	String[] excludeName() default {};
        // 等同于ComponentScan注解的basePackages属性
	@AliasFor(annotation = ComponentScan.class, attribute = "basePackages")
	String[] scanBasePackages() default {};
        // 等同于ComponentScan注解的basePackageClasses属性
	@AliasFor(annotation = ComponentScan.class, attribute = "basePackageClasses")
	Class<?>[] scanBasePackageClasses() default {};
}
```

`@SpringBootApplication` 注解是一个组合注解，主要由 `@SpringBootConfiguration`，`@EnableAutoConfiguration` 和`@ComponentScan` 这三个注解组合而成。

因此 `@SpringBootApplication` 注解主要作为一个配置类，能够触发包扫描和自动配置的逻辑，从而使得 SpringBoot 的相关 `bean` 被注册进 Spring 容器。

---

在 SpringApplication.run 方法中会 new 一个 SpringApplication 对象，并调用其 run 方法来启动，这个 run 方法里面就是启动流程。

1. 从`spring.factories`配置文件中**加载**`**EventPublishingRunListener**`**对象**，该对象拥有`SimpleApplicationEventMulticaster`属性，即在SpringBoot启动过程的不同阶段用来发射内置的生命周期事件;
2. **准备环境变量**，包括系统变量，环境变量，命令行参数，默认变量，`servlet`相关配置变量，随机值以及配置文件（比如`application.properties`）等;
3. 控制台**打印SpringBoot的**`**bannner**`**标志**；
4. **根据不同类型环境创建不同类型的**`**applicationcontext**`**容器**，因为这里是`servlet`环境，所以创建的是`AnnotationConfigServletWebServerApplicationContext`容器对象；
5. 从`spring.factories`配置文件中**加载**`**FailureAnalyzers**`**对象**,用来报告SpringBoot启动过程中的异常；
6. **为刚创建的容器对象做一些初始化工作**，准备一些容器属性值等，对`ApplicationContext`应用一些相关的后置处理和调用各个`ApplicationContextInitializer`的初始化方法来执行一些初始化逻辑等；
7. **刷新容器**，这一步至关重要。比如调用`bean factory`的后置处理器，注册`BeanPostProcessor`后置处理器，初始化事件广播器且广播事件，初始化剩下的单例`bean`和SpringBoot创建内嵌的`Tomcat`服务器等等重要且复杂的逻辑都在这里实现，主要步骤可见代码的注释，关于这里的逻辑会在以后的spring源码分析专题详细分析；
8. **执行刷新容器后的后置处理逻辑**，注意这里为空方法；
9. **调用**`**ApplicationRunner**`**和**`**CommandLineRunner**`**的run方法**，我们实现这两个接口可以在spring容器启动后需要的一些东西比如加载一些业务数据等;
10. **报告启动异常**，即若启动过程中抛出异常，此时用`FailureAnalyzers`来报告异常;
11. 最终**返回容器对象**，这里调用方法没有声明对象来接收。





### `SpringBoot` 自动装配？

通过注解或者一些简单的配置就能在 `Spring Boot` 的帮助下实现某块功能。

`@SpringBootApplication` 中有一个 `@EnableAutoConfiguration` 注解。

该注解中有一个 `@Import({AutoConfigurationImportSelector.class})` 注解，会向 `IOC` 容器中导入 `AutoConfigurationImportSelector` 这个选择器组件，其中实现了 `selectImports` 方法，这个方法主要用于**获取所有符合条件的类的全限定类名，把他们加载到 `IoC` 容器中**。

该方法中调用了 `getAutoConfigurationEntry()`。该方法主要是获取需要加载的所有全类名。

```java
private static final AutoConfigurationEntry EMPTY_ENTRY = new AutoConfigurationEntry();

AutoConfigurationEntry getAutoConfigurationEntry(AutoConfigurationMetadata autoConfigurationMetadata, AnnotationMetadata annotationMetadata) {
    // <1>.
    if (!this.isEnabled(annotationMetadata)) {
        return EMPTY_ENTRY;
    } else {
        // <2>.
        AnnotationAttributes attributes = this.getAttributes(annotationMetadata);
        // <3>.
        List<String> configurations = this.getCandidateConfigurations(annotationMetadata, attributes);
        // <4>.
        configurations = this.removeDuplicates(configurations);
        Set<String> exclusions = this.getExclusions(annotationMetadata, attributes);
        this.checkExcludedClasses(configurations, exclusions);
        configurations.removeAll(exclusions);
        configurations = this.filter(configurations, autoConfigurationMetadata);
        this.fireAutoConfigurationImportEvents(configurations, exclusions);
        // <5>
        return new AutoConfigurationImportSelector.AutoConfigurationEntry(configurations, exclusions);
    }
}
```

该方法的执行步骤：

1. `isEnabled()` 方法，判断自动装配开关是否打开。默认是打开的，可以在配置文件中设置。

2. `getAttributes()` 方法，获取 `EnableAutoConfiguration` 注解中的 `exclude` 和 `excludeName`。

3. `getCandidateConfigurations()` 方法，通过 `SpringFactoriesLoader` 读取 `autoconfiguration` `jar` 包下的 `META-INF/spring.factories` 文件，获取需要自动装配的所有配置类的全类名。

4. `fireAutoConfigurationImportEvents()` 方法，将不需要加载的类去除。

   `@ConditionalOnClass` 中的所有条件都满足，该类才会生效。

5. 最后返回一个存放着需要加载的类的 `Selector`。

所以 `@import` 方法使用这个 `Selector` 可以正确的将 `Spring Boot` 所需要的类加载到 `IOC` 容器中。

// TODO more specific



### Spring Boot 读取配置的方式

* 通过 `Environment` 类来读取配置信息。
* 通过 `@Value` 注解读取配置信息（推荐使用）。
* 通过 `@ConfigurationProperties` 注解读取配置信息。
* 通过 `@PropertySource+@Value` 注解读取配置信息。
* 通过 `@PropertySource+@ConfigurationProperties` 注解读取配置信息。
* 通过 `Properties` 类读取配置信息。



### `.properties` 和 `.yaml` 的区别

* 定位不同。properties 就是用来在 Spring Boot 项目中设置属性的。yaml 是一种标记语言，除了配置属性还可以做别的操作。
* 语法不同。等号和冒号。yml更简洁。
* yml 更好的支持多种数据类型。yml 除了可以很好的配置基础数据类型之外，它还可以很方便的配置对象、集合等数据类型。
* yml 可以跨语言。properties 只能用于 Spring Boot 项目。



### BO (Bussiness) 业务对象

主要在服务内部使用的业务对象

可以包含多个对象，可以用于对象的聚合操作

### VO (View Object) 视图对象

和视图打交道的，那么经历了视图的都归属于这个类，所以我们的输入输出类都是属于 VO。

### PO (Persistent Object) 永久对象

这些对象对应着数据库的每一个字段名以下是我的数据库表（如下表），所以我entity类对应着数据库的每个列，称为PO。

### DTO (Data Transfer Object) 数据传输对象

在服务间的调用中，传输的数据对象
DTO是可以存在于各层服务中（接口、服务、数据库等等）服务间的交互使用DTO来解耦



| ddd  |      |      |
| ---- | ---- | ---- |
|      |      |      |
|      |      |      |
|      |      |      |





