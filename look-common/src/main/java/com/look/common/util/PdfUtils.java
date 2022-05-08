package com.look.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class PdfUtils {

    public static final String DOC = "doc";
    public static final String DOCX = "docx";
    public static final String PDF = "pdf";
    public static final String XLS = "xls";
    public static final String XLSX = "xlsx";
    public static final String MP4 = "mp4";
    public static final String PPT = "ppt";
    public static final String PPTX = "pptx";

    // 8 代表word保存成html
    public static final int WORD2HTML = 8;
    // 17代表word保存成pdf
    public static final int WD2PDF = 17;
    public static final int PPT2PDF = 32;
    public static final int XLS2PDF = 0;
    private static Logger logger= LoggerFactory.getLogger(PdfUtils.class);

    public static void main(String[] args) {
//        String pptfile = "C:/Users/Administrator/Desktop/ceshi.pptx";
//        String pdffile = "C:/Users/Administrator/Desktop/数字模拟电路.pdf";
//        ppt2pdf(pptfile,pdffile);
//        pdf2Image(pdffile);
//        String word="D:/小程序维保参数 (1).docx";
//        String pdf="D:/小程序维保参数 (1).pdf";
        String word="D:/车辆月度成本明细文档说明.doc";
        String pdf="D:/pdfTemp/车辆月度成本明细文档说明.pdf";
//        String word="D:/轴数时效查询.xls";
//        String pdf="D:/pdfTemp/轴数时效查询.xls";
        formatConvert(word,pdf);
    }
    /**
     * @author
     * @version
     * @param
     * @return
     * TODO 文件转换结束删除文件
     */
    public static void clearFiles(String workspaceRootPath) {
        File file = new File(workspaceRootPath);
        if (file.exists()) {
            deleteFile(file);
        }
    }
    public static void deleteFile(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i=0; i<files.length; i++){
                deleteFile(files[i]);
            }
        }
        file.delete();
    }

    /**
     * @author
     * @version
     * @param
     * @return
     * TODO 文件转换
     */
    public static Integer formatConvert( String resourcePath,String pdffile){
        Integer pages = 0;
        try {
            String resourceType=resourcePath.substring(resourcePath.lastIndexOf(".")+1);
            String pdffilePath = pdffile.substring(0, pdffile.lastIndexOf("."));
            if(resourceType.equalsIgnoreCase(DOC)||resourceType.equalsIgnoreCase(DOCX)){
                //word转成pdf和图片
                wordUtil("pdf",resourcePath,pdffilePath+".pdf");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return pages;
    }
    /**
     * 判断当前系统为Windows还Linexs
     * @param toType
     * @param resoursfile
     * @param pdffile
     */
    public static void wordUtil(String toType,String resoursfile,String pdffile){
        try {
            //掉用windows的WPS文档转化失败
            long start = System.currentTimeMillis();
            String command;
            boolean flag;
            String osName = System.getProperty("os.name");

            String[] commands = new String[3];
            if (osName.contains("Windows") ) {
                //判断应用程序是否存在
                command = "soffice --headless --invisible --convert-to "+toType+":writer_"+toType+"_Export " + resoursfile + " --outdir " + pdffile.substring(0,pdffile.lastIndexOf("/"));
                commands = new String[]{"cmd", "/c", command};
            }else {
                command = "/opt/libreoffice5.3/program/soffice --headless --invisible --convert-to "+toType+":writer_"+toType+"_Export " + resoursfile + " --outdir "+ pdffile.substring(0,pdffile.lastIndexOf("/"));
                commands = new String[]{"/bin/sh", "-c", command};
            }
            //文档转PDF
            executeLibreOfficeCommand(commands);
            long end = System.currentTimeMillis();
            logger.debug("用时:{} ms", end - start);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    /**
     * 执行command指令
     * @param commands
     * @return
     */
    public static boolean executeLibreOfficeCommand(String[] commands) {
        // Process可以控制该子进程的执行或获取该子进程的信息
        Process process;
        try {
            process = Runtime.getRuntime().exec(commands);// exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
        } catch (IOException e) {
            logger.error(" convertOffice2PDF {} error", commands, e);
            return false;
        }
        int exitStatus = 0;
        try {
            exitStatus = process.waitFor();// 等待子进程完成再往下执行，返回值是子线程执行完毕的返回值,返回0表示正常结束
            // 第二种接受返回值的方法
            int i = process.exitValue(); // 接收执行完毕的返回值
            logger.debug("i----" + i);
        } catch (InterruptedException e) {
            logger.error("InterruptedException  convertOffice2PDF {}", commands, e);
            return false;
        }
        if (exitStatus != 0) {
            logger.error("convertOffice2PDF cmd exitStatus {}", exitStatus);
        } else {
            logger.debug("convertOffice2PDF cmd exitStatus {}", exitStatus);
        }
        process.destroy(); // 销毁子进程
        logger.info("转化结束.......");
        return true;
    }
}
