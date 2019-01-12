package com.tools.deploy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 実行クラス
 * @author masaki.kawaguchi
 */
public class Main {
	
	/**
	 * 実行メソット
	 * @param args 引数
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
        SimpleDateFormat sdf = new SimpleDateFormat(Const.TIMESTAMP_FORMAT);
        
		System.out.println("Start Deploy Tool...");

		//　入力情報セット
		if (args.length == 0) {
			System.out.println("-- Option help -------");
			System.out.println("    Arg0 is Hour[0-24].");
			System.out.println("    Arg1 is Minites[0-59].");
			System.out.println("    Arg2 is SRC Folder(Not Mandatary).");
			System.out.println("----------------------");
			return;
		}
				
		//　入力情報セット
		if (args.length < 2) return;
		String srcpath = Const.SRC_DIR ;
		if (args.length == 3) {
			srcpath = "/" + args[2];
		}
		Date fdate = new Date();
		fdate.setHours(Integer.parseInt(args[0]));
		fdate.setMinutes(Integer.parseInt(args[1]));
		Long flong = fdate.getTime();
		System.out.println("The start date of the compare date is " + sdf.format(flong));
		
		// ワークディレクトリ
        String srcPath = new File("").getAbsolutePath() + srcpath;
        String deployPath = new File("").getAbsolutePath() + Const.DEPLOY_DIR;
        System.out.println("The SRC Directory Path is " + srcPath);
        File deploydir = new File(deployPath);
        deploydir.deleteOnExit();
        deploydir.mkdir();
        
        //(3) 対象ファイルのファイルオブジェクト生成
        List<MetaObject> mlist = new ArrayList<MetaObject>();
        File rootdir = new File(srcPath);
        if (!rootdir.isDirectory()) return;
        for (File f : rootdir.listFiles()) {
        	
        	// ディレクトリ判断
        	if ((!f.isDirectory()) || !Util.isDeployDir(f, flong)) continue;
        	
        	// メタタイプセット
        	MetaObject m = new MetaObject();
            m.setName(f.getName());
        	
            // デプロイ先へフォルダ作成
            String mdirStr = deployPath + "/" + f.getName();
            File mdir = new File(mdirStr);
            mdir.mkdir();
            
            System.out.println("The start copy to deploy directory...");
        	for (File cf : f.listFiles()) {
 
        		if (flong >= cf.lastModified()) continue;
        		System.out.println(">> The deploy target file is " + cf.getName() + " < last modify date : " + sdf.format(f.lastModified()) + " >");
        		
        		// メンバーセット
        		m.addElement(cf.getName());
        		
        		// ファイルコピー
        		Util.copyfile(cf, mdirStr);
            }
        	mlist.add(m);
        }

        // マニュフェストファイル作成
        XMLWriter writer = new XMLWriter();
        writer.create(deployPath, mlist);
        
		System.out.println("Finish Deploy Tool...");
	}
}
