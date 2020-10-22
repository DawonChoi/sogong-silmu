package kr.gsm.controller;

import java.util.HashMap;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		keyAdd();
	}

	private void keyAdd() {
		mappings.put("/list.do", new MemberListPojo());
		mappings.put("/insert.do", new MemberInsertPojo());
		mappings.put("/delete.do", new MemberDeletePojo());
		mappings.put("/content.do", new MemberContentPojo());
		mappings.put("/update.do", new MemberUpdatePojo());
		
		mappings.put("/insertForm.do", new MemberInsertFormController());
	}
	
	public Controller getController(String url) {
		return mappings.get(url);
	}
}
