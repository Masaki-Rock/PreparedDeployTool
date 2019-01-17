package com.tools.deploy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;

public class Util {

	/**
	 * ファイル名取得処理
	 * @param file 拡張子を含むファイル名
	 * @return ファイル名
	 */
	public static String getNameWithoutExtension(File file) {

		  String fileName = file.getName();
		  return getNameWithoutExtension(fileName);
	}

	public static String getNameWithoutExtension(String fileName) {

		  int index = fileName.lastIndexOf('.');
		  if (index != -1) {
		    return fileName.substring(0, index);
		  }
		  return fileName;
	}
	
	/**
	 * ディレクトリ名取得処理
	 * @param fileName ディレクトリを含むファイル名
	 * @return ディレクトリ名
	 */
	public static String getDirName(String fileName) {

		  int index = fileName.lastIndexOf(getSep());
		  if (index != -1) {
		    return fileName.substring(0, index);
		  }
		  return "";
	}

	public static void copyfile(File source, String targetdir) {

		File target = new File(targetdir +  getSep() + source.getName());
		copyfile(source, target);
	}
	
	public static void copyfile(String sourcePath) {
		
		String targetPath = sourcePath.replace(Const.SRC_PATH, Const.DEPLOY_PATH);
		File source = new File(sourcePath);
		File target = new File(targetPath);
		if (!source.exists()) return;
		copyfile(source, target);
	}

	public static void copyfile(File fileIn, File fileOut) {

		try {
			fileOut.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// FileChannelクラスのオブジェクトを生成する
		FileChannel inCh = null;
		FileChannel outCh = null;
		try {
			inCh = new FileInputStream(fileIn).getChannel();
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

	/**
	 * デプロイディレクトリ
	 * @param dir
	 * @param flong
	 * @return
	 */
	public static Boolean isDeployDir(File dir, Long flong) {

        SimpleDateFormat sdf = new SimpleDateFormat(Const.TIMESTAMP_FORMAT);
		
		for (File f : dir.listFiles()) {
    		
			// System.out.println(">> The compare " + f.getName() +  " is " + sdf.format(f.lastModified()) + " : " + sdf.format(flong));
			if (f.isDirectory() && isDeployDir(f, flong)) return true;
    		if ((!f.isDirectory()) && isChangedFile(f, flong)) {
    			// System.out.println(">> The deploy files is existed ... ");
    			return true;
    		}
    		
        }
		// System.out.println(">> The deploy files is not existed... ");
		return false;
	}
	
	public static Boolean isChangedFile(File f, Long key) {
		Long from = key - Long.parseLong("30000");
		Long to = key + Long.parseLong("30000");
		if (from > f.lastModified() || to < f.lastModified()) return true;
		return false;
	}
	
	/**
	 * ディレクトリ削除処理
	 * @param dir ディレクトリ
	 */
	public static void delDir(File dir) {
		
		if (!dir.exists()) return;
        for (File f : dir.listFiles()) {
        	
        	// ディレクトリ判断
        	if (f.isDirectory()) {
        		delDir(f);
        		continue;
        	}
        	f.delete();
        }
        dir.delete();
	}
	
	public static String getSep() {
		if (Const.OS_NAME.startsWith("windows")) {
			return "\\";
		}
		return "/";
	}
	
	public static String convertRegex(String val) {
		if (Const.OS_NAME.startsWith("windows")) {
			return val.replace("\\", "\\\\");
		}
		return val;
	}
}
