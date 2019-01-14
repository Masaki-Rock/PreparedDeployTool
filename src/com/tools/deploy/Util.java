package com.tools.deploy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;

public class Util {

	public static String getNameWithoutExtension(File file) {

		  String fileName = file.getName();
		  return getNameWithoutExtension(fileName);
	}

	public static String getNameWithoutExtension(String fileName) {

		  int index = fileName.lastIndexOf('.');
		  if (index!=-1)
		  {
		    return fileName.substring(0, index);
		  }
		  return "";
	}

	public static void copyfile(File f, String targetdir) {
        File fileIn = new File(f.getAbsolutePath());
		File fileOut = new File(targetdir +  "/" + f.getName());
		try {
			fileOut.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// FileChannelクラスのオブジェクトを生成する
		FileChannel inCh = null;
		FileChannel outCh = null;
		try {
			inCh = new FileInputStream(f).getChannel();
			outCh = new FileOutputStream(fileOut).getChannel();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//transferToメソッドを使用してファイルをコピーする
		try {
			inCh.transferTo(0, inCh.size(), outCh);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Boolean isDeployDir(File dir, Long flong) {

        SimpleDateFormat sdf = new SimpleDateFormat(Const.TIMESTAMP_FORMAT);
		
		for (File f : dir.listFiles()) {
    		// System.out.println(">> The compare " + f.getName() +  " is " + sdf.format(f.lastModified()));
			// System.out.println(">> The deploy files is existed ... ");
    		if (flong < f.lastModified()) return true;
    		
        }
		// System.out.println(">> The deploy files is not existed... ");
		return false;
	}
}
