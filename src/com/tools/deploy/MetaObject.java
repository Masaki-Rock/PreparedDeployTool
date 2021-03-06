package com.tools.deploy;

import java.util.HashSet;
import java.util.Set;

public class MetaObject {

	private String dirname;

	private String name;
	
	private Set<String> members;
	
	private Set<String> memberNames;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		// 変更箇所
		this.name = "";
		for (int i = 0; i < Const.META_NAME.length; i++) {
			if (Const.META_NAME[i][1].equals(name)) {
				this.dirname = name;
				this.name = Const.META_NAME[i][0];
			}
		}
		System.out.println("Metadata type name is..." + this.name + " : " + name);
	}

	public Set<String> getMembers() {
		return members;
	}
	
	public Set<String> getMemberNames() {
		return memberNames;
	}

	public void addMember(String ename) {
		if (this.members == null) {
			this.members = new HashSet<String>();
			this.memberNames = new HashSet<String>();
		}
		// Ignore File
		if (ename.matches(Const.IGNORE_FILE)) return;
		
		// マニュフェスト用加工処理
		String tname = ename.replace(Const.SRC_PATH + Util.getSep() + this.dirname + Util.getSep(), "");
		if (Const.META_NAME_APEX_CLASS.equals(this.name)) {
			this.members.add(Util.getNameWithoutExtension(Util.getNameWithoutExtension(tname)));
			String cmpName = ename;
			for (String orign : Const.APEX_CLASS_EXTENSIONS) {
				cmpName = cmpName.replaceFirst(orign, "");
			}
			for (String orign : Const.APEX_CLASS_EXTENSIONS) {
				orign = orign.replaceAll(Const.EXTENTIONS_REGREX, "");
				this.memberNames.add(cmpName + orign);
			}
			return;
		}
		if (Const.META_NAME_APEX_TRIGGER.equals(this.name)) {
			this.members.add(Util.getNameWithoutExtension(Util.getNameWithoutExtension(tname)));
			String cmpName = ename;
			for (String orign : Const.APEX_TRIGGER_EXTENSIONS) {
				cmpName = cmpName.replaceFirst(orign, "");
			}
			for (String orign : Const.APEX_TRIGGER_EXTENSIONS) {
				orign = orign.replaceAll(Const.EXTENTIONS_REGREX, "");
				this.memberNames.add(cmpName + orign);
			}
			return;
		}
		if (Const.META_NAME_LIGHTNING_COMPONENT.equals(this.name)) {
			this.members.add(Util.getDirName(tname));
			String cmpName = ename;
			for (String orign : Const.LIGHTNING_COMPONENT_EXTENSIONS) {
				cmpName = cmpName.replaceFirst(orign, "");
			}
			for (String orign : Const.LIGHTNING_COMPONENT_EXTENSIONS) {
				orign = orign.replaceAll(Const.EXTENTIONS_REGREX, "");
				this.memberNames.add(cmpName + orign);
			}
			return;
		}
		if (Const.META_NAME_STATICSOURCE.equals(this.name)) {
			this.members.add(Util.getNameWithoutExtension(Util.getNameWithoutExtension(tname)));
			String cmpName = ename;
			for (String orign : Const.APEX_STATICSOURCE_EXTENSIONS) {
				cmpName = cmpName.replaceFirst(orign, "");
			}
			for (String orign : Const.APEX_STATICSOURCE_EXTENSIONS) {
				orign = orign.replaceAll(Const.EXTENTIONS_REGREX, "");
				this.memberNames.add(cmpName + orign);
			}
			return;
		}
		if (Const.META_NAME_STATICSOURCE.equals(this.name)) {
			this.members.add(Util.getNameWithoutExtension(Util.getNameWithoutExtension(tname)));
			String cmpName = ename;
			for (String orign : Const.APEX_STATICSOURCE_EXTENSIONS) {
				cmpName = cmpName.replaceFirst(orign, "");
			}
			for (String orign : Const.APEX_STATICSOURCE_EXTENSIONS) {
				orign = orign.replaceAll(Const.EXTENTIONS_REGREX, "");
				this.memberNames.add(cmpName + orign);
			}
			return;
		}
		if (Const.META_NAME_APEX_PAGE.equals(this.name)) {
			this.members.add(Util.getNameWithoutExtension(Util.getNameWithoutExtension(tname)));
			String cmpName = ename;
			for (String orign : Const.APEX_PAGES_EXTENSIONS) {
				cmpName = cmpName.replaceFirst(orign, "");
			}
			for (String orign : Const.APEX_PAGES_EXTENSIONS) {
				orign = orign.replaceAll(Const.EXTENTIONS_REGREX, "");
				this.memberNames.add(cmpName + orign);
			}
			return;
		}
		if (Const.META_NAME_REPORT.equals(this.name) || Const.META_NAME_DASHBOARD.equals(this.name)) {
			// Ignore File
			if (ename.matches(Const.IGNORE_REPORT_FILE)) return;
			this.members.add(Util.getNameWithoutExtension(tname.replace("\\", "/")));
			this.members.add(Util.getDirName(tname));
			String folderxml = Const.SRC_PATH + Util.getSep() + this.dirname + Util.getSep() + Util.getDirName(tname) + "-meta.xml";
			this.memberNames.add(folderxml);
			this.memberNames.add(ename);
			return;
		}
		if (Const.META_NAME_CUSTOM_METADATA.equals(this.name) || Const.META_NAME_QUICK_ACTION.equals(this.name)) {
			this.members.add(Util.getNameWithoutExtension(tname));
			this.memberNames.add(ename);
			return;
		}
		this.members.add(Util.getNameWithoutExtension(Util.getNameWithoutExtension(tname)));
		this.memberNames.add(ename);
	}
}
