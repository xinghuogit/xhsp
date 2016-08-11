package com.xh.shopping.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String strconfig = config.getInitParameter("uploadpath");
		System.out.println("strconfig:" + strconfig);
	}

	/**
	 * 保存普通form表单域
	 */
	protected Map<String, String> parameters;
	/**
	 * 保存上传的文件
	 */
	protected Map<String, FileItem> files;

	private int sizeThreshold = DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD;

	private long sizeMax = -1;

	private String encoding = "utf-8";// 字符编码，当读取上传表单的各部分时会用到该encoding

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		parse(request);
		System.out.println(parameters.get("possess"));
		System.out.println(parameters.get("id"));
		String id = parameters.get("id");
		PrintWriter out = response.getWriter();
		Iterator iterator = files.values().iterator();
		while (iterator.hasNext()) {
			FileItem item = (FileItem) iterator.next();
			String fileName = getFileName(item);
			long size = item.getSize();
			File file = new File(
					"E:\\git\\J2EE\\xhsps\\xhsp\\WebContent\\image\\product\\",
					id + "11.jpg");
			// File file = new File("F:\\Fupload\\temp\\", fileName);
			System.out.println("fileName:" + fileName);
			try {
				item.write(file);
				out.println("fileName:" + fileName + "		" + "size:" + size);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void parse(HttpServletRequest request) {

		parameters = new HashMap<String, String>();
		files = new HashMap<String, FileItem>();
		// Create a factory for disk-based file items

		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Set factory constraints
		factory.setSizeThreshold(sizeThreshold);

		// factory.setRepository(repository);
		// Create a new file upload handler

		ServletFileUpload upload = new ServletFileUpload(factory);
		// Set overall request size constraint

		upload.setSizeMax(sizeMax);
		upload.setHeaderEncoding(encoding);
		try {
			List items = upload.parseRequest(request);
			Iterator iterator = items.iterator();

			while (iterator.hasNext()) {
				FileItem item = (FileItem) iterator.next();
				if (item.isFormField()) {// 如果是文件域的表单信息
					String fieldName = item.getFieldName();
					String value = item.getString();
					parameters.put(fieldName, value);
				} else {
					String fieldName = item.getFieldName();
					files.put(fieldName, item);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	}

	public String getFileName(FileItem item) {
		String fileName = item.getName();
		fileName = replace(fileName, "\\", "/");
		fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
		return fileName;
	}

	public static String replace(String source, String oldString,
			String newString) {
		StringBuffer output = new StringBuffer();
		int lengthOfSource = source.length();
		int lengthOfOld = oldString.length();
		int posStart = 0;

		int pos;
		while ((pos = source.indexOf(oldString, posStart)) >= 0) {
			output.append(source.substring(posStart, pos));
			output.append(newString);
			posStart = pos + lengthOfOld;
		}
		if (posStart < lengthOfSource) {
			output.append(source.substring(posStart));
		}
		return output.toString();
	}

}
