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
		this.name = "";
		for (int i = 0; i < Const.META_NAME.length; i++) {
			if (Const.META_NAME[i][1].equals(name)) {
				this.name = Const.META_NAME[i][0];
			}
		}
		System.out.println("Metadata type name is..." + this.name + " : " + name);
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
