import com.excel.ExcelUtil;
import com.seven.Application;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ExcelText {
    /**
     * 测试类的方法按理来说,不应该接收参数,这里是模拟server层的实现类来写的,所以本测试无法运行
     *
     * @param response 请求
     * @throws Exception
     */
    @Test
    public void excelTest(HttpServletResponse response) throws Exception {
        try {
            ExcelUtil excelUtil = new ExcelUtil("测试");
            OutputStream ouputStream = excelUtil.setUpHeader(response);


            // 2、创建信息
            String[] saleOrder = {"第一列", "第二列"};
            List<List<String>> list = new ArrayList<List<String>>();
            List<String> rowData = new ArrayList<String>();
            rowData.add("第一列数据");
            rowData.add("第二列数据");
            list.add(rowData);

            // 3、写入
            XSSFWorkbook workbook = new XSSFWorkbook();
            // 第一个表格内容
            excelUtil.exportExcel(workbook, 0, "库存台账数据导入模板", saleOrder, list);
            // 写出
            workbook.write(ouputStream);
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
