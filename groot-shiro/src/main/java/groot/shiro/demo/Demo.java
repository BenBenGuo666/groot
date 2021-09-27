package groot.shiro.demo;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/3/26
 */
public class Demo {

    public static void main(String[] args) throws IOException {
       /* Realm realm = null;
        SecurityManager securityManager = new DefaultSecurityManager(realm);
        //Make the SecurityManager instance available to the entire application via static memory:
        SecurityUtils.setSecurityManager(securityManager);*/

        /*String str = "123.jPg";
        str = str.toLowerCase();
        System.out.println(str.substring(0, str.lastIndexOf(".")));*/

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
       /* Integer[] ints = {9, 2, 1, 4, 10, 7};
        List<Integer> list = Arrays.asList(ints);*/
//        List<Integer> list = new ArrayList<>();
//        list.addAll(Arrays.asList(ints));
       /* list.sort((a, b) -> {
            return Integer.compare((Integer) b, (Integer) a);
        });
        list.forEach(e -> System.out.println(e.intValue()));
*/
//        FileSystemResource fileSystemResource = new FileSystemResource("C:\\Users\\xw\\Desktop\\workspace\\workspace.txt");
//        InputStream inputStream = fileSystemResource.getInputStream();
        /*FileChannel fileChannel = (FileChannel) fileSystemResource.readableChannel();
        ByteBuffer buff = ByteBuffer.allocate((int) fileSystemResource.contentLength());
        fileChannel.read(buff);
        buff.rewind();
        String content = new String(buff.array());*/
        /*while(fileChannel.read(buff) != -1){
            buff.flip();
            content = content + new String(buff.array());
//            buff.clear();
            buff.rewind();
        }*/
//        fileChannel.close();
//        System.out.println(content);
        /*System.out.println(Double.valueOf(".51"));*/


        //ArrayList
        //20210602 arrayList 特性
        /*List A = new ArrayList();
        for (int i = 0; i < 10; i++) {
            A.add(i);
        }
        System.out.println(A);
        //结论：排序是队列特性
        List B = new ArrayList();
        for (int i = 0; i < 4; i++) {
            B.add(i - 3);
        }
        A.addAll(B);
        System.out.println(A);
        //结论: 队列特性，B 集合保持原有顺序，* 相同元素不会覆盖。
        //20210602 arrayList api
        Collections.reverse(A);
        System.out.println(A);
        //LinkedHashSet
        List<Book> bookList = new ArrayList<>();
        NewBook book = new NewBook();
        book.setName("飞鸟集");
        book.setPrices("20");
        book.setPrice(0.1);
        bookList.add(book);
        NewBook book2 = new NewBook();
        book2.setName("飞鸟集");
        book2.setPrices("10");
        book2.setPrice(0.2);
        bookList.add(book2);
        System.out.println(bookList);
        Set set = new LinkedHashSet(bookList);
        System.out.println(set);
        System.out.println(book.equals(book2));
        bookList.clear();
        bookList.addAll(set);
        System.out.println(bookList);*/
        //结论：new LinkedHashSet 不是覆盖去重

//        System.out.println(new Date().getTime());
       /* String number = "ssss";
        int s = Integer.getInteger(number);
        System.out.println(s);*/
//        System.out.println(Demo.class.getSimpleName());
//        ref(new Demo());
        /*Boolean b = null;
        System.out.println((false != b));*/
        /*BigDecimal bd = new BigDecimal(0.0D);
        for (int i = 0; i < 5; i++) {
            bd = bd.add(new BigDecimal(i + 1));
        }
        System.out.println(bd.doubleValue());*/
        /*String a = "C:\\Users\\xw\\Desktop\\农业园Excel导入整理\\20210805\\考核表模板改动版.xls";
        System.out.println(a.substring(a.lastIndexOf("\\") + 1, a.length()));*/
        /*List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        int i = 0;
        System.out.println(stringList.get(i++));
        System.out.println(stringList.get(i++));
        System.out.println(stringList.get(i++));
        System.out.println(stringList.get(i++));
        System.out.println(i);*/
//        int i = 0;
        /*for (; i < 5; i++) {
            System.out.println((int)Math.pow(10, i));
        }*/
/*        System.out.println(121 % 10);
        System.out.println(324 % 10);
        System.out.println(1125 % 10);
        System.out.println(0126 % 10);
        System.out.println(0126);
        BigInteger bigInteger = BigInteger.valueOf(1210);
        System.out.println(bigInteger.mod(BigInteger.valueOf(100)).toString());*/
        //旅游
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("in:");
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int days = Integer.valueOf(strs[0]);
        double oneDayFoodCost = Double.valueOf(strs[1]);
        double oneWayFlightCost = Double.valueOf(strs[2]);
        double oneNightHotelCost = Double.valueOf(strs[3]);
        double total = days * oneDayFoodCost + 2 * oneWayFlightCost + (days - 1) * oneNightHotelCost;
        System.out.println(total);*/
        /*System.out.print("Please input duration in days:");
        int days = scanner.nextInt();
        System.out.print("Please input total food cost per day:");
        double oneDayFoodCost = scanner.nextDouble();
        System.out.print("Please input one-way flight cost:");
        double oneWayFlightCost = scanner.nextDouble();
        System.out.print("Please input cost of one night in a hotel:");
        double oneNightHotelCost = scanner.nextDouble();
        double total = days * oneDayFoodCost + 2 * oneWayFlightCost + (days - 1) * oneNightHotelCost;
        System.out.println("total cost:" + total);*/
        /*boolean b1 = true;
        boolean b2 = false;
        System.out.println(!b1 && b2);
        System.out.println(b1 || !!b2);
        System.out.println(!b1 && !b2);
        System.out.println(!b1 || b2);
        System.out.println(!(b1 || b2));*/
        /*String fileName = "8307条.xls";
        String dirPath = "C:\\Users\\xw\\Desktop\\";
        File file = new File(dirPath + fileName);
        System.out.println(file.getPath());
        System.out.println(file.length()/1024 + "KB");*/

        StringBuffer sql = new StringBuffer();

        /*List<String> checkList = vo.getSkuList().stream().map(sku -> {
            Stream stream = sku.getImeiList().stream();
            if (stream.count() != stream.distinct().count()) {
                return sku.getSkuId() + "存在重复的串号";
            }
            return null;
        }).collect(Collectors.toList());
        if (checkList.stream().count() > 0) {
            return R.failed(checkList.toString());
        }*/

        String ss = null;
        System.out.println(ss.toString());

    }

    public static void ref(Object obj) {
        System.out.println(obj.getClass().getSimpleName());
    }

    public static String getName(Book b) {
        return b.getName();
    }

    public static int getAge(Student s) {
        return s.getAge();
    }

}
