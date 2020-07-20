package com.ideabobo.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;



import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.ideabobo.model.Room;
import com.ideabobo.model.Type;
import com.ideabobo.service.RoomService;
import com.ideabobo.util.GetNowTime;
import com.ideabobo.util.IdeaAction;
import com.ideabobo.util.Page;

@Controller
public class RoomAction extends IdeaAction {
	@Resource
	private RoomService roomService;
	private static final long serialVersionUID = -3218238026025256103L;
	private Room room;
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String room(){
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
		page = roomService.findByPage(page, paramsMap);
		Gson json = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", page.getTotal());
		map.put("rows", page.getList());
		render(json.toJson(map));		
	}
	
	public void add(){
		String action = request.getParameter("action");
		if(room != null){
			if(action.equals("add")){
				roomService.save(room);
				render("操作成功!");
			}else {
				String id = request.getParameter("id");
				room.setId(Integer.parseInt(id));
				roomService.update(room);
				render("操作成功!");
			}
		}		
	}
	
	public void deleteItem(){
		String id = request.getParameter("id");
		roomService.delete(Integer.parseInt(id));
		render("操作成功");
	}
	
	public void roomList(){
		String sid = request.getParameter("sid");
		Room r = new Room();
		r.setPid(Integer.parseInt(sid));
		
		ArrayList<Room> list = (ArrayList<Room>) roomService.list(r);
		Gson json = new Gson();
		render(json.toJson(list));
	}
	

}
