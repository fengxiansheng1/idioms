package io.renren.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FileReadTxt {
	public static void main(String[] args) throws IOException {
		final String srcPath = "D:\\account\\idioms\\";
		Map<String,String> map=readTxt(srcPath);
	}
	
	public static  Map<String,String>  readTxt(String partPath) throws IOException {
		Map<String,String> map=new HashMap<String,String>();
		File srcFile = new File(partPath);
		File[] files = srcFile.listFiles();
		int sum = 0;
		if(files!=null){
			
			long start = System.currentTimeMillis();
		
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
	
				try {
					String encoding = "GBK";

					if (file.isFile() && file.exists()) { // 判断文件是否存在
						InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
						BufferedReader bufferedReader = new BufferedReader(read);
						String lineTxt = null;
						while ((lineTxt = bufferedReader.readLine()) != null) {
							String gg=lineTxt.replace("、", "");
							map.put(gg, gg);
						}

						read.close();
					} else {
						System.out.println("找不到指定的文件" );
						
					}
				} catch (Exception e) {
					System.out.println("exception :" + e.getMessage());
					e.printStackTrace();
				}

				 //logger.info("文件内容行数:" + temp.size());
			}

			System.out.println("一共add条数:" + sum);
			System.out.println("共花费时间:" + (System.currentTimeMillis() - start) / 1000 + "秒");
		}
		

		return map;

	}

}
