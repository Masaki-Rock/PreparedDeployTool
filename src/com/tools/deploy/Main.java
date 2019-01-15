package com.tools.deploy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
		System.out.println("-- Option help -------");
		System.out.println("    Arg0 is Hour[0-24].");
		System.out.println("    Arg1 is Minites[0-59].");
		System.out.println("    Arg2 is SRC Folder(Not Mandatary).");
		System.out.println("    If Arrangement is Nothing, It is compare by Manifestfile's lastModified date.");
		System.out.println("----------------------");
				
		// ワークディレクトリ初期化
		String srcpath = Const.SRC_DIR ;
		if (args.length == 3) {
			srcpath = Util.getSep() + args[2];
		}
        Const.SRC_PATH = Const.CURRENT_PATH + srcpath;
        System.out.println("The SRC directory Path is " + Const.SRC_PATH);
        File deploydir = new File(Const.DEPLOY_PATH);
        Util.delDir(deploydir);
        deploydir.mkdir();
        System.out.println("The Deploy derectory is deleted...");
        
        // 比較日付初期化
        File manifest = new File(Const.SRC_PATH + Const.MANIFEST_FILE);
        Long flong = manifest.lastModified();
        if (args.length >= 2) {
        	Calendar cl = Calendar.getInstance();
        	cl.set(Calendar.HOUR, Integer.parseInt(args[0]));
        	cl.set(Calendar.MINUTE, Integer.parseInt(args[1]));
    		flong = cl.getTimeInMillis();
        }
        
		System.out.println("The start date of the compare date is " + sdf.format(flong));
        
        //(3) 対象ファイルのファイルオブジェクト生成
        List<MetaObject> mlist = new ArrayList<MetaObject>();
        File rootdir = new File(Const.SRC_PATH);
        if (!rootdir.isDirectory()) return;
        copyMetadir(rootdir, mlist, flong);

        // マニュフェストファイル作成
        if (mlist.isEmpty()) {
        	deploydir.delete();
        	System.out.println("Finish Deploy Tool...");
        	return;
        }
        System.out.println("Manifest file create...");
        XMLWriter writer = new XMLWriter();
        writer.create(Const.DEPLOY_PATH, mlist);
        
		System.out.println("Finish Deploy Tool...");
	}
	
	/**
	 * デプロイディレクトリへデプロイ対象コピー処理
	 * @param dir ディレクトリ
	 * @param mlist マニュフェスト作成用情報
	 * @param flong 日付比較ロング値
	 * @return
	 */
	public static List<MetaObject> copyMetadir(File dir, List<MetaObject> mlist, Long flong) {

        for (File f : dir.listFiles()) {
        	
        	// ディレクトリ判断
        	if ((!f.isDirectory()) || !Util.isDeployDir(f, flong)) continue;
        	
        	// メタタイプセット
        	MetaObject m = new MetaObject();
            m.setName(f.getName());
        	
            // デプロイ先へフォルダ作成
            String mdirStr = Const.DEPLOY_PATH + Util.getSep() + f.getName();
            File mdir = new File(mdirStr);
            mdir.mkdir();
            
            System.out.println("The start copy to deploy directory...");
            m = copydir(f, m, flong, mdirStr);

        	mlist.add(m);
        }
        
        for (MetaObject m : mlist) {
        	for (String path : m.getMemberNames()) {
        		Util.copyfile(path);
        	}
        }
        
		return mlist;
	}
	
	public static MetaObject copydir(File f, MetaObject m, Long flong, String mdirStr) {

		SimpleDateFormat sdf = new SimpleDateFormat(Const.TIMESTAMP_FORMAT);
		
		for (File cf : f.listFiles()) {
    		
			String tdirStr = mdirStr;
			// サブフォルダ用
        	if (cf.isDirectory()) {
        		System.out.println(">> directory is " + cf.getName() );
        		tdirStr =  tdirStr + Util.getSep() + cf.getName();
                File mdir = new File(tdirStr);
                mdir.mkdir();
        		m = copydir(cf, m, flong, tdirStr);
        		continue;
        	}
        	
    		if (flong >= cf.lastModified()) continue;
    		System.out.println(">> The deploy target file is " + cf.getName() + " < last modify date : " + sdf.format(cf.lastModified()) + " >");
    		
    		// メンバーセット
    		m.addMember(cf.getAbsolutePath());
        }
    	return m;
	}
}
