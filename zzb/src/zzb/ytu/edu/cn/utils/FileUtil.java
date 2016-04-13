package zzb.ytu.edu.cn.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUtil {
	
	/*
	 * �ļ��ϴ�
	 * **/
	public static class FileUpload {
		public static  HashMap<String, String> fileUpload(String savePath,
				String tempPath, HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
			HashMap<String,String> result = new HashMap<String,String>();
			String status = "";
			String path = "";
			
			File tmpFile = new File(tempPath);
			if (!tmpFile.exists()) {
				// ������ʱĿ¼
				tmpFile.mkdir();
			}

			try {
				// ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
				// 1������һ��DiskFileItemFactory����
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// ���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼���С�
				factory.setSizeThreshold(1024 * 100);// ���û������Ĵ�СΪ100KB�������ָ������ô�������Ĵ�СĬ����10KB
				// �����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
				factory.setRepository(tmpFile);
				// 2������һ���ļ��ϴ�������
				ServletFileUpload upload = new ServletFileUpload(factory);
				// �����ļ��ϴ�����
				upload.setProgressListener(new ProgressListener() {
					public void update(long pBytesRead, long pContentLength,
							int arg2) {
						/**
						 * �ļ���СΪ��14608,��ǰ�Ѵ���4096 �ļ���СΪ��14608,��ǰ�Ѵ���7367
						 * �ļ���СΪ��14608,��ǰ�Ѵ���11419 �ļ���СΪ��14608,��ǰ�Ѵ���14608
						 */
					}
				});
				// ����ϴ��ļ�������������
				upload.setHeaderEncoding("UTF-8");
				// 3���ж��ύ�����������Ƿ����ϴ���������
				if (!ServletFileUpload.isMultipartContent(request)) {
					// ���մ�ͳ��ʽ��ȡ����
					
				}

				// �����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ������Ϊ1024*1024�ֽڣ�Ҳ����1MB
				upload.setFileSizeMax(1024 * 1024);
				// �����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ��Ķ���ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ10MB
				upload.setSizeMax(1024 * 1024 * 10);
				// 4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem item : list) {
					// ���fileitem�з�װ������ͨ�����������
					if (item.isFormField()) {
						String name = item.getFieldName();
						// �����ͨ����������ݵ�������������
						String value = item.getString("UTF-8");
						// value = new String(value.getBytes("iso8859-1"),"UTF-8");
						result.put(name, value);
					} else {// ���fileitem�з�װ�����ϴ��ļ�
							// �õ��ϴ����ļ����ƣ�
						String filename = item.getName();
						if (filename == null || filename.trim().equals("")) {
							continue;
						}
						// ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺
						// c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
						// �����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
						filename = filename
								.substring(filename.lastIndexOf("/") + 1);
						// �õ��ϴ��ļ�����չ��
						@SuppressWarnings("unused")
						String fileExtName = filename.substring(filename
								.lastIndexOf(".") + 1);
						// �����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
//						System.out.println("�ϴ����ļ�����չ���ǣ�" + fileExtName);
						// ��ȡitem�е��ϴ��ļ���������
						InputStream in = item.getInputStream();
						// �õ��ļ����������
						String saveFilename = makeFileName(filename);
						// �õ��ļ��ı���Ŀ¼
						String realSavePath = makePath(saveFilename, savePath);
						path = realSavePath+"/" + saveFilename;
						// ����һ���ļ������
						FileOutputStream out = new FileOutputStream(realSavePath
								+ "/" + saveFilename);
						// ����һ��������
						byte buffer[] = new byte[1024];
						// �ж��������е������Ƿ��Ѿ�����ı�ʶ
						int len = 0;
						// ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
						while ((len = in.read(buffer)) > 0) {
							// ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\"
							// + filename)����
							out.write(buffer, 0, len);
						}
						// �ر�������
						in.close();
						// �ر������
						out.close();
						status = "200";
					}
				}
			} catch (FileUploadBase.FileSizeLimitExceededException e) {
				e.printStackTrace();
				request.setAttribute("message", "�����ļ��������ֵ������");
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
				
			} catch (FileUploadBase.SizeLimitExceededException e) {
				e.printStackTrace();
				request.setAttribute("message", "�ϴ��ļ����ܵĴ�С�������Ƶ����ֵ������");
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				result.put("status", status);
				result.put("path",path);
			}
			return result;
		}

		/**
		 * @Method: makeFileName
		 * @Description: �����ϴ��ļ����ļ������ļ����ԣ�uuid+"_"+�ļ���ԭʼ����
		 * @Anthor:�°�����
		 * @param filename
		 *            �ļ���ԭʼ����
		 * @return uuid+"_"+�ļ���ԭʼ����
		 */
		private static String makeFileName(String filename) { // 2.jpg
			// Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
			return UUID.randomUUID().toString() + "_" + filename;
		}

		/**
		 * Ϊ��ֹһ��Ŀ¼�������̫���ļ���Ҫʹ��hash�㷨��ɢ�洢
		 * 
		 * @Method: makePath
		 * @Description:
		 * @Anthor:�°�����
		 * 
		 * @param filename
		 *            �ļ�����Ҫ�����ļ������ɴ洢Ŀ¼
		 * @param savePath
		 *            �ļ��洢·��
		 * @return �µĴ洢Ŀ¼
		 */
		private static String makePath(String filename, String savePath) {
			// �õ��ļ�����hashCode��ֵ���õ��ľ���filename����ַ����������ڴ��еĵ�ַ
			int hashcode = filename.hashCode();
			int dir1 = hashcode & 0xf; // 0--15
			int dir2 = (hashcode & 0xf0) >> 4; // 0-15
			// �����µı���Ŀ¼
			String dir = savePath + "/" + dir1 + "/" + dir2; // upload\2\3
																// upload\3\5
			// File�ȿ��Դ����ļ�Ҳ���Դ���Ŀ¼
			File file = new File(dir);
			// ���Ŀ¼������
			if (!file.exists()) {
				// ����Ŀ¼
				file.mkdirs();
			}
			return dir;
		}
	}

	
	/*
	 * �г����������ļ�
	 * **/
	public static class ListFile  {
		 /**
		    * @Method: listfile
		    * @Description: �ݹ����ָ��Ŀ¼�µ������ļ�
		    * @Anthor:�°�����
		    * @param file ������һ���ļ���Ҳ����һ���ļ�Ŀ¼
		    * @param map �洢�ļ�����Map����
		    */ 
		    public static void listfile(File file,Map<String,String> map){
		        //���file����Ĳ���һ���ļ�������һ��Ŀ¼
		        if(!file.isFile()){
		            //�г���Ŀ¼�µ������ļ���Ŀ¼
		            File files[] = file.listFiles();
		            //����files[]����
		            for(File f : files){
		                //�ݹ�
		                listfile(f,map);
		            }
		        }else{
		            /**
		             * �����ļ������ϴ�����ļ�����uuid_�ļ�������ʽȥ���������ģ�ȥ���ļ�����uuid_����
		                file.getName().indexOf("_")�����ַ����е�һ�γ���"_"�ַ���λ�ã�����ļ��������ڣ�9349249849-88343-8344_��_��_��.avi
		                ��ôfile.getName().substring(file.getName().indexOf("_")+1)����֮��Ϳ��Եõ���_��_��.avi����
		             */
		            String realName = file.getName().substring(file.getName().indexOf("_")+1);
		            //file.getName()�õ������ļ���ԭʼ���ƣ����������Ψһ�ģ���˿�����Ϊkey��realName�Ǵ����������ƣ��п��ܻ��ظ�
		            map.put(file.getName(), realName);
		        }
		    }
	}
	
	/*
	 * �ļ�����
	 * **/
	public static class FileDownload{
		
		/**
	    * @Method: findFileSavePathByFileName
	    * @Description: ͨ���ļ����ʹ洢�ϴ��ļ���Ŀ¼�ҳ�Ҫ���ص��ļ�������·��
	    * @Anthor:�°�����
	    * @param filename Ҫ���ص��ļ���
	    * @param saveRootPath �ϴ��ļ�����ĸ�Ŀ¼��Ҳ����/WEB-INF/uploadĿ¼
	    * @return Ҫ���ص��ļ��Ĵ洢Ŀ¼
	    */ 
	    public static String findFileSavePathByFileName(String filename,String saveRootPath){
	        int hashcode = filename.hashCode();
	        int dir1 = hashcode&0xf;  //0--15
	        int dir2 = (hashcode&0xf0)>>4;  //0-15
	        String dir = saveRootPath + "/" + dir1 + "/" + dir2;  //upload\2\3  upload\3\5
	        File file = new File(dir);
	        if(!file.exists()){
	            //����Ŀ¼
	            file.mkdirs();
	        }
	        return dir;
	    }
	}
	
}
