package com.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * excel导出
 */
public class ExcelUtil {
    //文件名称
    private String fileName;

    public ExcelUtil(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @param workbook   文件
     * @param sheetNum   当前第几页工作薄
     * @param title 表头
     * @param headers    当前表格的标题
     * @param result     类容  -- 一个二位数组 类容放在第二层
     * @throws Exception
     */
    public void exportExcel(XSSFWorkbook workbook, int sheetNum,
                            String title, String[] headers, List<List<String>> result) throws Exception {
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, title);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        XSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        XSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);
        //设置边框为细边框
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);

        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell((short) i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }
        // 遍历集合数据，产生数据行
        if (result != null) {
            int index = 1;
            for (List<String> m : result) {
                row = sheet.createRow(index);
                int cellIndex = 0;
                for (String str : m) {
                    XSSFCell cell = row.createCell((short) cellIndex);
                    cell.setCellValue(str);
                    cellIndex++;
                }
                index++;
            }
        }
    }

    /**
     * @param response 请求头
     * @return
     * @throws Exception
     */
    public OutputStream setUpHeader(HttpServletResponse response) throws Exception {
        // 1、输出的文件地址及名称
        response.reset(); // 重置response的设置
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
        return response.getOutputStream();
    }

    /**
     * 模拟server层的实现类方法调用
     *
     * @param response
     * @throws Exception
     */
    public void excelTest(HttpServletResponse response) throws Exception {
        try {
            ExcelUtil excelUtil = new ExcelUtil("测试");
            OutputStream ouputStream = excelUtil.setUpHeader(response);


            /**
             * 2、创建信息
             * list         表示是第几行的数据
             * rowData      表示这一行数据的每一列
             */
            String[] saleOrder = {"第一列", "第二列"};
            List<List<String>> list = new ArrayList<List<String>>();
            List<String> rowData = new ArrayList<String>();
            rowData.add("第一列数据");
            rowData.add("第二列数据");
            list.add(rowData);

            // 3、写入
            XSSFWorkbook workbook = new XSSFWorkbook();

            //这个工作簿的表头内容
            String title = "这个工作簿的表头";

            // 第一个表格内容
            excelUtil.exportExcel(workbook, 0, title, saleOrder, list);

            // 写出
            workbook.write(ouputStream);
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
