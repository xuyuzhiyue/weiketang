package com.ideabobo.action;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.ideabobo.model.Changci;
import com.ideabobo.service.ChangciService;
import com.ideabobo.util.GetNowTime;
import com.ideabobo.util.IdeaAction;
import com.ideabobo.util.Page;

@Controller
public class ChangciAction extends IdeaAction {
	@Resource
	private ChangciService changciService;
	private static final long serialVersionUID = -3218238026025256103L;
	private Changci changci;
	public Changci getChangci() {
		return changci;
	}

	public void setChangci(Changci changci) {
		this.changci = changci;
	}

	public String changci(){
		return SUCCESS;
	}
	
	public void getList(){
		String pid = request.getParameter("pid");
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		Page page = new Page();
		Map paramsMap = new HashMap();
		paramsMap.put("pid", pid);
		paramsMap.put("sort", "order by "+sort+" "+order);
		String pageNo = (String) this.request.getParameter("page");
		String pageSizes = (String) this.request.getParameter("rows");
		if (pageNo == null) {
			page.setPageSize(10);
			page.setPageNo(1);
		} else {
			page.setPageSize(Integer.parseInt(pageSizes));
			page.setPageNo(Integer.parseInt(pageNo));
		}
		page = changciService.findByPage(page, paramsMap);
		Gson json = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", page.getTotal());
		map.put("rows", page.getList());
		render(json.toJson(map));		
	}
	
	public void add(){
		String action = request.getParameter("action");
		if(changci != null){
			if(action.equals("add")){
				changciService.save(changci);
				render("操作成功!");
			}else {
				String id = request.getParameter("id");
				changci.setId(Integer.parseInt(id));
				changciService.update(changci);
				render("操作成功!");
			}
		}		
	}
	
	public void deleteItem(){
		String id = request.getParameter("id");
		changciService.delete(Integer.parseInt(id));
		render("操作成功");
	}
	

}
