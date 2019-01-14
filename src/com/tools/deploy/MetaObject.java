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
		// 除外ファイル名
//		if (ename.matches(Const.IGNORE_FILE_APEX)) return;
		
		// マニュフェスト用加工処理
		String tname = ename.replaceFirst(Const.SRC_PATH + "/" + this.dirname + "/", "");
		if (Const.META_NAME_APEX_TRIGGER[0].equals(this.name)
				|| Const.META_NAME_APEX_CLASS[0].equals(this.name)) {
			this.members.add(Util.getNameWithoutExtension(Util.getNameWithoutExtension(tname)));
			this.memberNames.add(ename);
			return;
		}
		if (Const.META_NAME_LIGHTNING_COMPONENT[0].equals(this.name)) {
			this.members.add(Util.getDirName(tname));
			this.memberNames.add(ename);
			return;
		}
		this.members.add(Util.getNameWithoutExtension(tname));
		this.memberNames.add(ename);
	}
}
