package groot.shiro.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/3/26
 */
public class Demo {

    public static void main(String[] args) {
       /* Realm realm = null;
        SecurityManager securityManager = new DefaultSecurityManager(realm);
        //Make the SecurityManager instance available to the entire application via static memory:
        SecurityUtils.setSecurityManager(securityManager);*/

        /*String str = "123.jPg";
        str = str.toLowerCase();
        System.out.println(str.substring(str.lastIndexOf(".", str.length())));*/

//        List<Object> list = new ArrayList<>();
        /*String responseString = HttpUtils.post("http://127.0.0.1:10086/demo/getBookname_1");
        System.out.println(responseString);
        Book book = JSONObject.parseObject(responseString, Book.class);
        System.out.println(book);
        System.out.println(book.getName());*/
//        System.out.println(System.getenv());
        /*List<Object> list = new ArrayList<>();
        list.sort((a, b) -> {
            return 0;
        });*/

     /*   p((a, b) -> {
            System.out.println();
        });*/

//        LambdaInterface li = ((a, b) -> System.out.println(Demo.getName((Book) a) + Demo.getAge((Student) b)));

//        BiPredicate<String, String> biPredicate = (str1, str2) -> str1.length() > str2.length();

//        System.out.println(biPredicate);
        // NewBook(price) extends Book(name)
        /*NewBook newBook = new NewBook();
        newBook.setName("newBook");
        newBook.setPrice(1.1);
        System.out.println("newBook:" + newBook + "," + newBook.getName());
        Book book = newBook;
        System.out.println("newBook->book:" + book + "," + book.getName());
        NewBook newBook2 = (NewBook) book;
        System.out.println("book<-newBook2:" + newBook2 + "," + newBook2.getName());
        newBook2 = newBook;
        System.out.println("newBook==>newBook2:" + newBook2 + "," + newBook2.getName());*/
//        Class<?> clazz = Demo.class;
//        System.out.println(Configuration.class.getName());
        Integer[] ints = {9, 2, 1, 4, 10, 7};
        List<Integer> list = Arrays.asList(ints);
//        List<Integer> list = new ArrayList<>();
//        list.addAll(Arrays.asList(ints));
        list.sort((a, b) -> {
            return Integer.compare((Integer) b, (Integer) a);
        });
        list.forEach(e -> System.out.println(e.intValue()));


    }

    public static String getName(Book b) {
        return b.getName();
    }

    public static int getAge(Student s) {
        return s.getAge();
    }

}
