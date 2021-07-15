package com.cxf.febs.server.system.service;

import com.cxf.febs.server.system.entity.MyHeaderInfo;
import com.cxf.febs.server.system.entity.User;
import com.dtflys.forest.annotation.*;
import com.xiaoleilu.hutool.system.UserInfo;

import java.util.Map;

/**
 * @author sixpence
 * @version 1.0 2021/7/8
 */
public interface HttpClient {

    /**
     * GET http://localhost:8080/hello
     */
    @Request("http://localhost:8080/hello")
    String simpleRequest();

    /**
     * GET http://localhost:8080/hello/user?uname=foo
     * HEADER:
     *     Accept: text/plain
     */
    @Request(
            url = "http://localhost:8080/hello/user",
            headers = "Accept: text/plain"
    )
    String sendRequest(@Var("uname") String username);

    /**
     * 通过 @Request 注解的 type 参数指定 HTTP 请求的方式。
     * type大小写不敏感
     */
    @Request(
            url = "http://localhost:8080/hello",
            type = "POST"
    )
    String simplePost();

    /**
     * 使用 @Post 注解，可以去掉 type = "POST" 这行属性
     * @Post 等价于 @PostRequest
     */
    @Post("http://localhost:8080/hello")
    String simplePost1();

    /**
     * 整个完整的URL都通过 @Var 注解或 @DataVariable 注解修饰的参数动态传入
     */
    @Request("${myURL}")
    String send1(@Var("myURL") String myURL);

    /**
     * 通过参数转入的值值作为URL的一部分
     */
    @Request("http://${myURL}/abc")
    String send2(@Var("myURL") String myURL);


    /**
     * 直接在url字符串的问号后面部分直接写上 参数名=参数值 的形式
     * 等号后面的参数值部分可以用 ${变量名} 这种字符串模板的形式替代
     * 在发送请求时会动态拼接成一个完整的URL
     */
    @Request("http://localhost:8080/abc?a=${a}&b=${b}&id=0")
    String send2(@Var("a") String a, @Var("b") String b);


    /**
     * 使用 @Query 注解，可以直接将该注解修饰的参数动态绑定到请求url中
     * 注解的 value 值即代表它在url的Query部分的参数名
     */
    @Request("http://localhost:8080/abc?id=0")
    String send3(@Query("a") String a, @Query("b") String b);


    /**
     * 使用 @Query 注解，可以修饰 Map 类型的参数
     * 很自然的，Map 的 Key 将作为 URL 的参数名， Value 将作为 URL 的参数值
     * 这时候 @Query 注解不定义名称
     */
    @Get("http://localhost:8080/abc?id=0")
    String send2(@Query Map<String, Object> map);


    /**
     * @Query 注解也可以修饰自定义类型的对象参数
     * 依据对象类的 Getter 和 Setter 的规则取出属性
     * 其属性名为 URL 参数名，属性值为 URL 参数值
     * 这时候 @Query 注解不定义名称
     */
    @Get("http://localhost:8080/abc?id=0")
    String send2(@Query UserInfo user);

    /**
     * (1) 需要单个单个定义 参数名=参数值 的时候，@Query注解的value值一定要有，比如 @Query("name") String name
     *
     * (2) 需要绑定对象的时候，@Query注解的value值一定要空着，比如 @Query User user 或 @Query Map map
     */

    /**
     * GET http://localhost:8080/hello/user
     * HEADER:
     *     Accept-Charset: gbk
     *     Content-Type: text/plain
     *
     */
    @Request(
            url = "http://localhost:8080/hello/user",
            headers = {
                    "Accept-Charset: ${encoding}",
                    "Content-Type: text/plain"
            }
    )
    String bindingHeader(@Var("encoding") String encoding);


    /**
     * 使用 @Header 注解将参数绑定到请求头上
     * @Header 注解的 value 指为请求头的名称，参数值为请求头的值
     * @Header("Accept") String accept将字符串类型参数绑定到请求头 Accept 上
     * @Header("accessToken") String accessToken将字符串类型参数绑定到请求头 accessToken 上
     */
    @Post("http://localhost:8080/hello/user?username=foo")
    void postUser(@Header("Accept") String accept, @Header("accessToken") String accessToken);

    /**
     * 使用 @Header 注解可以修饰 Map 类型的参数
     * Map 的 Key 指为请求头的名称，Value 为请求头的值
     * 通过此方式，可以将 Map 中所有的键值对批量地绑定到请求头中
     */
    @Post("http://localhost:8080/hello/user?username=foo")
    void headHelloUser(@Header Map<String, Object> headerMap);


    /**
     * 使用 @Header 注解可以修饰自定义类型的对象参数
     * 依据对象类的 Getter 和 Setter 的规则取出属性
     * 其属性名为 URL 请求头的名称，属性值为请求头的值
     * 以此方式，将一个对象中的所有属性批量地绑定到请求头中
     */
    @Post("http://localhost:8080/hello/user?username=foo")
    void headHelloUser(@Header MyHeaderInfo headersInfo);

    /**
     * 默认body格式为 application/x-www-form-urlencoded，即以表单形式序列化数据
     */
    @Post(
            url = "http://localhost:8080/user",
            headers = {"Accept:text/plain"}
    )
    String sendPost(@Body("username") String username, @Body("password") String password);

    /**
     * contentType 属性不设置默认为 application/x-www-form-urlencoded
     * 要以对象作为表达传输项时，其 @Body 注解的 value 名称不能设置
     *
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/x-www-form-urlencoded
     * BODY:
     *     username=foo&password=bar
     */
    @Post(
            url = "http://localhost:8080/hello/user",
            headers = {"Accept:text/plain"}
    )
    String send(@Body User user);

    /**
     * 被@JSONBody注解修饰的参数会根据其类型被自定解析为JSON字符串
     * 使用@JSONBody注解时可以省略 contentType = "application/json"属性设置
     *
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/json
     * BODY:
     *     {"username": "foo", "password": "bar"}
     */
    @Post("http://localhost:8080/hello/user")
    String helloUser(@JSONBody User user);

    /**
     * 按键值对分别修饰不同的参数
     * 这时每个参数前的 @JSONBody 注解必须填上 value 属性或 name 属性的值，作为JSON的字段名称
     *
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/json
     * BODY:
     *     {"username": "foo", "password": "bar"}
     */
    @Post("http://localhost:8080/hello/user")
    String helloUser(@JSONBody("username") String username, @JSONBody("password") String password);
}
