package com.tools.deploy;

import java.util.HashSet;
import java.util.Set;

public class MetaObject {

	private String name;
	
	private Set<String> elements;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		// 変更箇所
		if (Const.META_DIR_APEXCLASS.equals(name)) {
			this.name = Const.META_NAME_APEXCLASS;
		}
		if (Const.META_DIR_CUSTOMOBJECT.equals(name)) {
			this.name = Const.META_NAME_CUSTOMOBJECT;
		}
	}

	public Set<String> getElements() {
		return elements;
	}

	public void addElement(String ename) {
		if (this.elements == null) {
			this.elements = new HashSet<String>();
		}
		// 変更箇所
		if (ename.matches(Const.IGNORE_FILE_APEX)) return;
		this.elements.add(Util.getNameWithoutExtension(ename));
	}
}
