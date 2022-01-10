package groot.shiro.demo;

import com.sun.imageio.plugins.common.ImageUtil;
import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

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
/*        String a = "C:\\Users\\xw\\Desktop\\农业园Excel导入整理\\20210805\\考核表模板改动版.xls";
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

//        StringBuffer sql = new StringBuffer();

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

/*        String ss = null;
        System.out.println(ss.toString());*/
        /*List<String> imeis = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            imeis.add("0000"+i);
            System.out.println(imeis.get(i));
        }
        System.out.println();
        System.out.println();
        System.out.println();
        int subLength = 2;
        int length = imeis.size() % subLength == 0 ? imeis.size() / subLength : imeis.size() / subLength + 1;
        int count = 0;
        List<String>[] imeiArray = new List[length];
        for (int i = 0; i < imeis.size(); count++, i = subLength * count) {
            imeiArray[count] = imeis.stream().skip(i).limit(subLength).collect(Collectors.toList());
        }
        for(int i = 0; i < imeiArray.length; i ++){
            System.out.println(imeiArray[i]);
        }*/
        //毫秒纳秒转换，尾巴多几个0
/*        long startTimeNano = System.nanoTime();
        long startTimeMillis = System.currentTimeMillis();
        System.out.println("startTimeMillis:" + startTimeMillis);
        System.out.println("startTimeNano / 1000 / 1000:" + startTimeNano/1000/1000);
        System.out.println("startTimeNano:" + startTimeNano);
        System.out.println(startTimeMillis*1000*1000);
        System.out.println(startTimeNano/1000/1000 == startTimeMillis);*/

        /*Scanner scanner = new Scanner(System.in);
        // start coding here
        int i = 0;
        int index = 0;
        String[] array = new String[200];
        while(i < 4){
            String names = scanner.nextLine();
            String[] nArray = names.split(" ");
            for(int j = 0; j < nArray.length; j ++){
                array[index] = nArray[j];
                index ++;
            }
            i ++;
        }
        for(int j = index - 1; j >= 0; j --){
            System.out.println(array[j]);
        }*/
        /*Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String line = scanner.nextLine();
        String[] strArray = line.split(" ");
        int[] array = new int[number];
        for(int i = 0; i < strArray.length; i ++){
            array[i] = Integer.valueOf(strArray[i]);
        }
        for(int i = 0; i < array.length; i ++){
            for(int j = 0; j < array.length; j ++){
            }

        }*/
/*        List<Map> list = new ArrayList<>();
        Map<String, Object> maps = new HashMap<>();
*//*        maps.put("sourceType","JD");
        maps.put("othdorder","");*//*
        maps.put("skuId","4071570");
        maps.put("price","0.1");
        maps.put("num","1");
        list.add(maps);
        System.out.println(JSONObject.toJSONString(list));*/
        /*String s = "\"123_8\"";
        System.out.println(s);
        System.out.println(s.replaceAll("\"",""));
        System.out.println(s.substring(s.lastIndexOf("_") + 1));*/


/*        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE TO_ORDERSALE_MAIN T SET T.F_ORDER_STATUSCODE = (CASE WHEN (SELECT SUM(F_GOODS_COUNT)-SUM(F_ACCEPT_COUNT) ");
        sql.append("FROM TO_ORDERSALE_SUB T WHERE T.F_ORDER_NUMBER=?)> 0 THEN 'HZTDQS' ELSE 'HZTJS' END) ,T.F_CHECK_DATE = TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') WHERE T.F_ORDER_NUMBER = ?");
        System.out.println(sql.toString());*/

        /*StringBuffer sql = new StringBuffer();
        sql.append("UPDATE TO_ORDERSALE_MAIN T SET T.F_ORDER_STATUSCODE = (CASE WHEN (SELECT SUM(F_DELIV_COUNT)-SUM(F_ACCEPT_COUNT + F_REFUSE_COUNT) ");
        sql.append("FROM TO_ORDERSALE_SUB T WHERE T.F_ORDER_NUMBER=?)> 0 THEN 'HZTBFQS' ELSE 'HZTJS' END),T.F_CHECK_DATE = TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') WHERE T.F_ORDER_NUMBER = ?");
        System.out.println(sql);*/

/*        Object obj = null;
        System.out.println("" + (obj));*/
//        System.out.println(new String(obj + "").length());

        /*String pattern = "^/payment/pay/goPayCallBack\\S+$";
        System.out.println(
                Pattern.matches(pattern,"/payment/pay/goPayCallBack?sessionId=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNzg4MzgwMyIsImNoYW5uZWwiOiJXRUIiLCJleHAiOjE2Mzk2MjMzMTJ9.Ge7xrG87wWdgU6za8XnnW8ms4X2w6HCnfjvnc8SozYjW_lS76QoLYhE3Xuq4AkcRtOd6UxCgcc11xGoATo9-5w&userId=123456")
        );*/

   /*     String pattern = "^/common/sms\\S+$";
        System.out.println(
                Pattern.matches(pattern,"/common/sms/goPayCallBack?sessionId=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNzg4MzgwMyIsImNoYW5uZWwiOiJXRUIiLCJleHAiOjE2Mzk2MjMzMTJ9.Ge7xrG87wWdgU6za8XnnW8ms4X2w6HCnfjvnc8SozYjW_lS76QoLYhE3Xuq4AkcRtOd6UxCgcc11xGoATo9-5w&userId=123456")
        );*/

/*        String t = "aabccsdsdsd";
        String p = "aab";
        for(int i = 0; i < 10000; i ++){
            t += "a";
        }
        System.out.println(t.indexOf(p));
        System.out.println(t.hashCode());
        System.out.println(p.hashCode());*/
/*

        StringBuffer sb = new StringBuffer();
        sb.append(" SELECT T.F_ID,T.F_ORG_NUM AS ORGNUM,T.F_LINK_MANNAME AS USERNAME,");
        sb.append("T.F_LINK_MOBILE AS PHONE,T.F_ADDRESS AS ADDRESS,T.F_REVIEW_STATUS,T.F_ADDR_FLAG,");
        sb.append("T.PROV,T.CITY,T.COUNTY,T.TOWN,");
        sb.append("NVL(provA.F_AREA_NAME,'-') \"PROVNAME\",NVL(cityA.F_AREA_NAME,'-') \"CITYNAME\",");
        sb.append("NVL(countyA.F_AREA_NAME,'-') \"COUNTYNAME\",NVL(townA.F_AREA_NAME,'-') \"TOWNNAME\" ");
        sb.append("FROM XW_RECEIVER_INFO T ");
        sb.append("LEFT JOIN TO_THD_AREA provA ON T.PROV = provA.F_AREA_NUM AND provA.F_SOURCE_TYPE = 'B2B' ");
        sb.append("LEFT JOIN TO_THD_AREA cityA ON T.CITY = cityA.F_AREA_NUM AND cityA.F_SOURCE_TYPE = 'B2B' ");
        sb.append("LEFT JOIN TO_THD_AREA countyA ON T.COUNTY = countyA.F_AREA_NUM AND countyA.F_SOURCE_TYPE = 'B2B' ");
        sb.append("LEFT JOIN TO_THD_AREA townA ON T.TOWN = townA.F_AREA_NUM AND townA.F_SOURCE_TYPE = 'B2B' ");
        sb.append("WHERE 1 = 1 ");

        System.out.println(sb);
*/


/*        System.out.println("加载当前类的加载器:" + Demo.class.getClassLoader());
        System.out.println("加载应用程序类加载器的加载器"
                + Demo.class.getClassLoader().getClass().getClassLoader());
        System.out.println("String类的启动类加载器" + String.class.getClassLoader());*/
/*        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
/*        String s = null;
        System.out.println("null".equals(s));*/
        //一寸照片制作
        /*String imageName = "java_coffee.jpg";
        String srcPath = "C:\\Users\\xw\\Desktop\\上线\\guobenben3.jpg";

        imageName = "java_coffee_resize.jpg";
        String destPath = "C:\\Users\\xw\\Desktop\\上线\\guobenben4.jpg";
        boolean forceSize = true;
        resizeImage(srcPath, destPath, 295, 413, forceSize);*/
    }

    /*public static boolean resizeImage (String srcPath, String destPath, int newWith, int newHeight, boolean forceSize) throws IOException {
        if (forceSize) {
            Thumbnails.of(srcPath).forceSize(newWith, newHeight).toFile(destPath);
        } else {
            Thumbnails.of(srcPath).width(newWith).height(newHeight).toFile(destPath);
        }
        return true;
    }*/

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
