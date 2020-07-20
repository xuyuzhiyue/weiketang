package com.ideabobo.action;


import javax.annotation.Resource;
import javax.swing.*;

import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ideabobo.model.Bill;
import com.ideabobo.model.Changci;
import com.ideabobo.model.Good;
import com.ideabobo.model.Posts;
import com.ideabobo.model.Replay;
import com.ideabobo.model.Room;
import com.ideabobo.model.User;
import com.ideabobo.service.BaseService;
import com.ideabobo.service.BillService;
import com.ideabobo.service.GoodService;
import com.ideabobo.service.PostsService;
import com.ideabobo.service.ReplayService;
import com.ideabobo.service.ShopService;
import com.ideabobo.service.TypeService;
import com.ideabobo.service.UserService;
import com.ideabobo.util.GetNowTime;
import com.ideabobo.util.IdeaAction;

@Controller
public class ClientAction extends IdeaAction {
	@Resource
    private BaseService baseService;
    @Resource
    private BillService billService;
    @Resource
    private ShopService shopService;
    @Resource
    private GoodService goodService;

    @Resource
    private TypeService typeService;
    @Resource
    private UserService userService;
    @Resource
    private PostsService postsService;
    @Resource
    private ReplayService replayService;
    public Gson gson = new Gson();
    private static final long serialVersionUID = -3218238026025256103L;

    public String wehall(){
//		String openid = request.getParameter("openid");
//		session.put("openid", openid);
        return SUCCESS;
    }

    public void login(){
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        User user = new User();
        user.setPasswd(passwd);
        user.setUsername(encodeGet(username));
        User r = userService.find(user);
        if(r!=null){
            renderJsonpObj(r);
        }else{
            renderJsonpString("fail");
        }
    }

    public void checkUser(){
        User u = new User();
        String username = request.getParameter("username");
        u.setUsername(username);
        User r = userService.find(u);
        if(r!=null){
            renderJsonpString("fail");
        }else{
            renderJsonpString("success");
        }
    }

    public void updateUser(){
        String tel = request.getParameter("tel");
        String qq = request.getParameter("qq");
        String wechat = request.getParameter("wechat");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String sex = request.getParameter("sex");
        String id = request.getParameter("id");

        User user = userService.find(id);

        user.setId(Integer.parseInt(id));
        user.setTel(tel);
        user.setWechat(wechat);
        user.setQq(qq);
        user.setEmail(email);
        user.setBirth(birth);
        user.setSex(encodeGet(sex));

        userService.update(user);
        renderJsonpString("success");
    }

    public void changePasswd(){
        String passwd = request.getParameter("passwd");
        String id = request.getParameter("id");
        User user = userService.find(id);
        user.setPasswd(passwd);
        userService.update(user);
        renderJsonpString("success");
    }

    public void register(){
        String tel = request.getParameter("tel");
        String qq = request.getParameter("qq");
        String wechat = request.getParameter("wechat");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String sex = request.getParameter("sex");
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String passwd = request.getParameter("passwd");
        String roletype = "2";

        User user = new User();

        user.setTel(tel);
        user.setWechat(wechat);
        user.setQq(qq);
        user.setEmail(email);
        user.setBirth(birth);
        user.setSex(encodeGet(sex));
        user.setPasswd(passwd);
        user.setRoletype(roletype);
        user.setUsername(encodeGet(username));
        user.setAddress(encodeGet(address));

        userService.save(user);

        renderJsonpString("success");
    }

    public void listShop(){
        renderJsonpObj(shopService.list());
    }
    public void listGood(){
    	String hql = "from Good t where 1=1";
        String type = request.getParameter("stype");
        String btype = request.getParameter("btype");
        String typeid = request.getParameter("typeid");
        String sid = request.getParameter("sid");
        Good g = new Good();
        if (type != null&& !"".equals(type)) {
            hql+=" and t.typeid='"+type+"'";
        }
        if(sid != null&& !"".equals(sid)){
        	hql+=" and t.sid='"+sid+"'";
        }
        if(btype != null&& !"".equals(btype)){
        	hql+=" and t.btype='"+btype+"'";
        }
        /*if(typeid != null&& !"".equals(typeid)){
           g.setTypeid(typeid);
        }*/
        hql+= " order by t.score desc";
        renderJsonpObj(baseService.list(hql));
    }

    public void listType(){
        renderJsonpObj(typeService.list());
    }
    
    public void listBillGoods(){
    	String gids = request.getParameter("gids");
    	String hql = "from Good t where t.id in ("+gids+")";
    	renderJsonpObj(baseService.list(hql));
    }

    public void billState(){
    	String idstr = request.getParameter("id");
    	String statecn = request.getParameter("statecn");
    	statecn = encodeGet(statecn);
    	Bill b = (Bill) baseService.find(Integer.parseInt(idstr), Bill.class);
    	b.setStatecn(statecn);
    	baseService.update(b);
    	renderJsonpObj(b);
    }

    public void saveBill(){
        Bill bill = (Bill) getByRequest(new Bill(), true);
        bill.setNdate(GetNowTime.getNowTimeEn());
        bill.setStatecn("未付款");
        billService.save(bill);
        if(bill.getType()!=null && bill.getType()==1){
        	String sites = request.getParameter("sites");
        	String cid = request.getParameter("cid");
        	Changci cc = (Changci) baseService.find(Integer.parseInt(cid), Changci.class);
        	String sitesold = cc.getSites();
        	if(sitesold!=null && !sitesold.equals("")){
        		sitesold = sitesold+","+sites;
        	}else{
        		sitesold = sites;
        	}
        	cc.setSites(sitesold);
        	baseService.update(cc);
        	
        }
        renderJsonpObj(bill);

    }

    public void saveBills(){
        String bills = request.getParameter("bills");
        bills = encodeGet(bills);
        JsonParser parser = new JsonParser();
        JsonArray blist = parser.parse(bills).getAsJsonArray();
        for(int i=0;i<blist.size();i++){
            JsonElement jo = blist.get(i);
            JsonObject obj = (JsonObject) parser.parse(jo.toString());
            Bill bill = new Bill();
            bill.setTotal(obj.get("total").getAsString());
            bill.setSid(obj.get("sid").getAsString());
            bill.setShop(obj.get("shop").getAsString());
            bill.setUid(obj.get("uid").getAsString());
            bill.setUser(obj.get("user").getAsString());
            bill.setNdate(GetNowTime.getNowTimeNian());
            bill.setGids(obj.get("gids").getAsString());
            bill.setGnames(obj.get("gnames").getAsString());
            bill.setAddress(obj.get("address").getAsString());
            bill.setTel(obj.get("tel").getAsString());
            bill.setNote(obj.get("note").getAsString());
            billService.save(bill);
        }

        renderJsonpString("提交成功!");
    }

    public void mybills(){
        String uid = request.getParameter("uid");
        Bill b = new Bill();
        b.setUid(uid);
        renderJsonpObj(billService.list(b));
    }
    public void myshopbills(){
        String sid = request.getParameter("sid");
        Bill b = new Bill();
        b.setSid(sid);
        renderJsonpObj(billService.list(b));
    }
    public Bill updateXiaoliang(Bill bill){
        String billstr = bill.getBill();
        JsonParser parser = new JsonParser();
        JsonArray ja = parser.parse(billstr).getAsJsonArray();
        String gnames = "";
        for(int i=0;i<ja.size();i++){
            JsonElement jo = ja.get(i);
            JsonObject obj = (JsonObject) parser.parse(jo.toString());
            String id = obj.get("id").getAsString();
            Good g = goodService.find(id);
            int count = Integer.parseInt(g.getCount());
            int bcount = Integer.parseInt(obj.get("count").getAsString());
            int total = count+bcount;
            g.setCount(total+"");
            if(i == 0){
                gnames+=obj.get("gname").getAsString();
            }else{
                gnames+=","+obj.get("gname").getAsString();
            }
            bill.setGnames(gnames);
            goodService.update(g);
        }
        return bill;
    }

    public void deleteGood(){
        String id = request.getParameter("id");
        goodService.delete(Integer.parseInt(id));
        renderJsonpString("success");
    }
    public void deleteBill(){
        String id = request.getParameter("id");
        billService.delete(Integer.parseInt(id));
        renderJsonpString("success");
    }
    
    public void addPosts(){
    	Posts p = (Posts) getByRequest(new Posts(), true);
/*    	String uid = request.getParameter("uid");
    	String title = encodeGet(request.getParameter("title"));
    	String note = encodeGet(request.getParameter("note"));
    	String username = encodeGet(request.getParameter("username"));*/
    	String ndate = GetNowTime.getNowTimeEn();
/*    	Posts p = new Posts();
    	p.setUid(uid);
    	p.setTitle(title);
    	p.setUsername(username);
    	p.setNote(note);*/
    	p.setNdate(ndate);
    	postsService.save(p);
    	renderJsonpString("success");
    }
    public void listPosts(){
        renderJsonpObj(postsService.list());
    }
    public void listReplay(){
    	String pid = request.getParameter("pid");
    	Replay r = new Replay();
    	r.setPid(pid);
        renderJsonpObj(replayService.list(r));
    }
    public void deletePosts(){
    	String id = request.getParameter("id");
    	postsService.delete(Integer.parseInt(id));    	
    	renderJsonpString("success");
    }
    public void addReplay(){
    	String uid = request.getParameter("uid");
    	String pid = request.getParameter("pid");
    	String note = encodeGet(request.getParameter("note"));
    	String username = encodeGet(request.getParameter("username"));
    	String ndate = GetNowTime.getNowTimeEn();
    	Replay m = new Replay();
    	m.setUid(uid);
    	m.setPid(pid);
    	m.setUsername(username);
    	m.setNote(note);
    	m.setNdate(ndate);
    	replayService.save(m);
    	renderJsonpString("success");
    }
    
    public void saveGood(){
    	Good info = (Good) getByRequest(new Good(), true);
    	baseService.save(info);
        renderJsonpString("success");
    }
    
    public void delPosts(){
    	String id = request.getParameter("id");
    	baseService.delete(Integer.parseInt(id), Posts.class);
    	renderJsonpString("success");
    }
    
    public void listChangci(){
    	String pid = request.getParameter("pid");
    	renderJsonpObj(baseService.list("from Changci t where t.pid="+pid));
    }
    public void getRoom(){
    	String id = request.getParameter("id");
    	renderJsonpObj(baseService.find(Integer.parseInt(id), Room.class));
    }
    public void listNotice(){
        renderJsonpObj(baseService.list("from Notice"));
    }
}
