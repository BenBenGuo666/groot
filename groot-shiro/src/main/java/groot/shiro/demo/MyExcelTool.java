package groot.shiro.demo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/8/10
 */
public class MyExcelTool {

    private int firstRowNum = 0;
    private int firstCellNum = 0;
    private int lastCellNum = 0;
    private int lastRowNum = 0;
    private Sheet sheet = null;
    private File file = null;
    private int inited = 0;
    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";
    private Workbook workbook = null;
    private InputStream inputStream = null;

    public void setCellVlaue(int rowNum, int cellNum, String value) {
        Row row = this.sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);
        cell.setCellType(CellType.STRING);
        cell.setCellValue(value);
    }

    /**
     * 修改 Excel
     *
     * @param sourceExcelFile
     * @param targetTemplateExcelFile
     * @param targetExcelFile
     */
    public static void xiugaiExcel(File sourceExcelFile, File targetTemplateExcelFile, File targetExcelFile) {
        MyExcelTool targetTemplateExcel = new MyExcelTool();
        targetTemplateExcel.init(targetTemplateExcelFile);
        targetTemplateExcel.unMerge();
        targetTemplateExcel.bubuAfterUnMerge(11, 12);

        MyExcelTool sourceExcel = new MyExcelTool();
        sourceExcel.init(sourceExcelFile);

        String i0j0 = sourceExcel.papa(0, 0);
        i0j0 = i0j0.substring(5, i0j0.length());

        for (int i = 3, ti = 1; i < sourceExcel.getLasRowNum() || ti < targetTemplateExcel.getLasRowNum(); i++, ti++) {
            String j5 = sourceExcel.papa(i, 5);
            String j7 = sourceExcel.papa(i, 7);
            String j8 = sourceExcel.papa(i, 8);
            targetTemplateExcel.setCellVlaue(ti, 8, j7);
            targetTemplateExcel.setCellVlaue(ti, 11, j5);
            targetTemplateExcel.setCellVlaue(ti, 12, j8);
            targetTemplateExcel.setCellVlaue(ti, 13, i0j0);
        }
        targetTemplateExcel.bubuAfterUnMerge(11, 12);
        targetTemplateExcel.write(targetExcelFile);
        sourceExcel.close();
        targetTemplateExcel.close();

    }

    private void t() {
        String jdFileAddr = "C:\\Users\\xw\\Desktop\\上线\\京东地址信息.xls";
        String ptFileAddr = "C:\\Users\\xw\\Desktop\\上线\\平台地址信息.xlsx";
        File jdFile = new File(jdFileAddr);
        File ptFile = new File(ptFileAddr);
        MyExcelTool jdExcel = new MyExcelTool();
        jdExcel.init(jdFile);
        jdExcel.printExcel();
        jdExcel.mapByMapInList().stream()
                .forEach(e -> {
                    if ("3".equals(String.valueOf(e.get("F_JB")))) {
                        System.out.println(e);
                    }
                });
//        MyExcelTool ptExcel = new MyExcelTool();
//        ptExcel.init(ptFile);
//        ptExcel.printExcel();
//        ptExcel.mapByMapInList();
//        System.out.println(ptExcel.mapByMapInList());
//        ptExcel.mapByMapInList().stream().forEach(e -> if("3".equals(String.valueOf(e.get("F_JB")))) System.out.println(e));
    }


    public static void main(String[] args) {
        MyExcelTool myExcelTool = new MyExcelTool();
        myExcelTool.t();
        /*String sourceDirPath = "C:\\Users\\xw\\Desktop\\农业园Excel导入整理\\20210802园区考核表";
        String targerDirPath = "C:\\Users\\xw\\Desktop\\农业园Excel导入整理\\20210802";
        String templatePath = "C:\\Users\\xw\\Desktop\\农业园Excel导入整理\\考核表模板改动版.xls";
      *//*  File sourceExcelFile = new File(sourceDirPath + "\\" + "2021-08-07泰州市现代农业产业示范园考核表（江苏古溪现代农业科技园）.xls");
        File targetTemplateExcelFile = new File(templatePath);
        File targetExcelFile = new File(targerDirPath + "\\" + "2021-08-07泰州市现代农业产业示范园考核表（江苏古溪现代农业科技园）.xls");
        xiugaiExcel(sourceExcelFile, targetTemplateExcelFile, targetExcelFile);*//*
        File sourceDir = new File(sourceDirPath);
        final int threads = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        long startTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(sourceDir.list().length - 1);
        for (String fileName : sourceDir.list()) {
            executorService.execute(() -> {
                try {
                    System.out.print(Thread.currentThread().getName() + "修改了:");
                    System.out.println(fileName);
                    File sourceExcelFile = new File(sourceDirPath + "\\" + fileName);
                    File targetTemplateExcelFile = new File(templatePath);
                    File targetExcelFile = new File(targerDirPath + "\\" + fileName);
                    xiugaiExcel(sourceExcelFile, targetTemplateExcelFile, targetExcelFile);
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime) + " ms,数量:" + sourceDir.list().length);
*/
    }

    public int getLastCellNum() {
        return this.lastCellNum;
    }

    public int getLasRowNum() {
        return this.lastRowNum;
    }

    public void close() {
        try {
            if (workbook != null) {
                workbook.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public Sheet getSheet() {
        return this.sheet;
    }

    public Workbook getWorkbook() {
        return this.workbook;
    }

    public void write(File file) {
        try {
            OutputStream outputStream = new FileOutputStream(file);
            this.workbook.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(File file) {
        this.file = file;
        try {
            this.inputStream = new FileInputStream(file);
            if (file.getName().endsWith(XLS)) {
                this.workbook = new HSSFWorkbook(inputStream);
                this.sheet = this.workbook.getSheetAt(0);
            } else {
                this.workbook = new XSSFWorkbook(inputStream);
                this.sheet = this.workbook.getSheetAt(0);
            }
            this.lastRowNum = this.sheet.getLastRowNum();
            this.lastCellNum = this.sheet.getRow(this.sheet.getFirstRowNum()).getLastCellNum();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        inited = 1;
    }

    /**
     * 取消所有合并单元格
     */
    public void unMerge() {
        List<CellRangeAddress> cellRangeAddressList = this.sheet.getMergedRegions();
        List<Integer> indices = new ArrayList<>();
        if (Collections.isNotEmpty(cellRangeAddressList)) {
            for (int i = 0; i < cellRangeAddressList.size(); i++) {
                indices.add(i);
            }
        }
        this.sheet.removeMergedRegions(indices);
    }

    /**
     * 打印 excel 内容
     */
    public void printExcel() {
        this.resetInitIndex();
        for (int i = 0; i < this.lastRowNum; i++) {
            for (int j = 0; j < this.lastCellNum; j++) {
                String value = papa(i, j);
                System.out.print(value + " ");
            }
            System.out.println();
            this.resetIndex(i, this.lastCellNum);
        }
    }

    public List<Map<String, Object>> mapByMapInList() {
        List<Map<String, Object>> result = new ArrayList<>();
        this.resetInitIndex();
        String[] keys = new String[this.lastCellNum];
        for (int i = 0; i < this.lastCellNum; i++) {
            keys[i] = papa(0, i);
        }
        for (int i = 1; i < this.lastRowNum; i++) {
            Map<String, Object> map = new LinkedHashMap<>();
            for (int j = 0; j < this.lastCellNum; j++) {
                map.put(keys[j], papa(i, j));
//                String value = papa(i, j);
//                System.out.print(value + " ");
            }
            result.add(map);
//            System.out.println();
            this.resetIndex(i, this.lastCellNum);
        }
        return result;
    }


    /**
     * 填充单元格拆解之后的数据
     * 忽略列号
     *
     * @param ignoreQueue
     */
    public void bubuAfterUnMerge(int... ignoreQueue) {
        this.resetInitIndex();
        Map<Integer, Integer> ignoreQueueCache = new HashMap<>(ignoreQueue.length * 2);
        if (ignoreQueue != null) {
            for (int ignore : ignoreQueue) {
                ignoreQueueCache.put(ignore, ignore);
            }
        }
        for (int i = 0; i <= this.lastRowNum; i++) {
            for (int j = 0; j < this.lastCellNum; j++) {
                if (ignoreQueue != null) {
                    if (ignoreQueueCache.get(j) != null) {
                        continue;
                    }
                }
                if (StringUtils.isEmpty(this.papa(i, j))) {
                    this.bubupapa(i, j);
                }
            }
            this.resetIndex(i, this.lastCellNum);
        }
    }

    /**
     * 爬爬
     */
    public String papa(int rowNum, int cellNum) {
        if (this.inited == 0 || this.sheet == null) {
            System.out.println("sheet 未初始化");
            return "";
        }
        Row row = this.sheet.getRow(rowNum);
        if (row == null) {
            return "";
        }
        Cell cell = row.getCell(cellNum);
        if (cell == null) {
            return "";
        }
        return parseValue(cell);

    }

    private String parseValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case FORMULA:
                String formula = cell.getCellFormula();
                BigDecimal numeric = new BigDecimal(cell.getNumericCellValue()).setScale(2, BigDecimal.ROUND_HALF_UP);
                if (formula.contains("/")) {
                    DecimalFormat df = new DecimalFormat("0%");
                    return df.format(numeric);
                }
                return numeric.toString();
            case BOOLEAN:
            case NUMERIC:
            default:
                cell.setCellType(CellType.STRING);
                return cell.getStringCellValue();
        }
    }

    private void resetInitIndex() {
        this.lastRowNum = sheet.getLastRowNum();
        this.lastCellNum = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
    }

    private void resetIndex(int rowNum, int cellNum) {
        Row row = this.sheet.getRow(rowNum);
        if (row != null && rowNum < this.lastRowNum && cellNum == row.getLastCellNum()) {
            this.lastCellNum = this.sheet.getRow(rowNum + 1).getLastCellNum();
        }
    }

    /**
     * 补爬
     */
    public String bubupapa(int rowNum, int cellNum) {
        String cellValue = "";
        for (int i = rowNum - 1; i > 0; i--) {
            Row row = this.sheet.getRow(i);
            if (row == null) {
                break;
            }
            String value = this.parseValue(row.getCell(cellNum));
            if (StringUtils.isNotEmpty(value)) {
                Cell cell = this.sheet.getRow(rowNum).getCell(cellNum);
                if (cell != null) {
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue(value);
                }
                cellValue = value;
                break;
            }
        }
        return cellValue;
    }

    /**
     * 改改
     */
    public static String gaigai(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        str = str.replaceAll(" ", "");
        str = str.replaceAll("．", "");
        str = str.replaceAll("（", "(").replaceAll("）", ")");
        int subLength = 0;
        int i = 0;
        while (i != -1 && i < str.length()) {
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                subLength++;
                i++;
                continue;
            }
            if (str.charAt(i) == 46) {
                subLength++;
                i++;
                continue;
            }
            i = -1;
        }
        return str.substring(subLength, str.length());
    }

}
