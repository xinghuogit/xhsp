/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：RequestContentType.java
 * 内容摘要：RequestContentType.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年3月30日 上午11:01:47
 * 修改记录：
 * 修改日期：2016年3月30日 上午11:01:47
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @filename 文件名称：RequestContentType.java
 * @contents 内容摘要：当请求属性为multipart/form-data
 */
public class RequestContentType {

	@SuppressWarnings("rawtypes")
	public static void setRequestContentType(HttpServletRequest request) {
		int yourMaxMemorySize = 314572800;
		int yourMaxRequestSize = 314572800;

		File yourTempDirectory = new File("D:/test/mytest.txt");

		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 当上传文件太大时，因为虚拟机能使用的内存是有限的，所以此时要通过临时文件来实现上传文件的保存
		// 此方法是设置是否使用临时文件的临界值（单位：字节）
		factory.setSizeThreshold(yourMaxMemorySize);

		// 与上一个结合使用，设置临时文件的路径（绝对路径）
		// factory.setRepository(yourTempDirectory);
		factory.setRepository(yourTempDirectory);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 设置上传内容的大小限制（单位：字节）
		upload.setSizeMax(yourMaxRequestSize);

		// Parse the request
		List<?> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();

			if (item.isFormField()) {
				// 如果是普通表单字段
				String name = item.getFieldName();
				String value = item.getString();
				System.out.println("name:" + name + "\nvalue" + value);
			} else {
				// 如果是文件字段
				String fieldName = item.getFieldName();
				String fileName = item.getName();
				String contentType = item.getContentType();
				System.out.println("fieldName:" + fieldName + "\nfileName"
						+ fileName + "\ncontentType" + contentType);
				// boolean isInMemory = item.isInMemory();
				// long sizeInBytes = item.getSize();
				// Process a file upload
				// if (writeToFile) {
				// File uploadedFile = new File();
				// item.write(uploadedFile);
				// } else {
				// InputStream uploadedStream = item.getInputStream();
				// uploadedStream.close();
				// }
			}
		}
	}
}
