/**
 * 
 */
package com.look.common.util;

/**
 * 文件上传结果
 */
public class FileUploadResult extends BaseResult {
	/**
	 * 文件目录
	 */
	private String fileDir;
	/**
	 * 文件服务器IP
	 */
	private String fileServerIp;
	/**
	 * 文件服务器端口
	 */
	private String fileServerPort;

	public String getFileDir() {
		return fileDir;
	}

	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}

	public String getFileServerIp() {
		return fileServerIp;
	}

	public void setFileServerIp(String fileServerIp) {
		this.fileServerIp = fileServerIp;
	}

	public String getFileServerPort() {
		return fileServerPort;
	}

	public void setFileServerPort(String fileServerPort) {
		this.fileServerPort = fileServerPort;
	}



	
	
}
