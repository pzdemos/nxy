package com.ahead.controller;

import java.util.List;
import java.util.Map;

import com.ahead.bean.Tiaojian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahead.bean.Goods;
import com.ahead.bean.Types;
import com.ahead.dao.GoodsDao;
import com.ahead.dao.TypesDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class GoodsController {
	@Autowired
	GoodsDao goodsDao;
	@Autowired
	TypesDao typesDao;
	private int nums = 4;//每页显示的商品数量
	@RequestMapping("/select")
	public String Select(Tiaojian newtj, Integer topage, Map<String, Object> map, HttpServletRequest request) {
		Integer page = 1;//page当前页,topage要去第几页
		HttpSession session = request.getSession();
		System.out.println(session.getAttributeNames());
		if(session.getAttribute("page") == null) {//如果Session没有当前页，说明是初次访问
			session.setAttribute("page", 1);//给默认的初始页数1
			session.setAttribute("oldtj", new Tiaojian(null, null, null, 0, nums));//初次访问时新增默认条件
		}
		Tiaojian oldtj = (Tiaojian) session.getAttribute("oldtj");//先获取旧的查询条件
		if(newtj!=null && (newtj.getName() != null||newtj.getIsDesc()!=null||newtj.getTypesId()!=null)) {//如果用户使用了新的查询条件
			oldtj = newtj;//那么就更新旧条件
			page = 1;//页数还原到第一页
		}
		if(topage == null) {//当用户没有使用翻页功能(不需要跳转页面)
			page = (Integer) session.getAttribute("page");//使用旧的页数
		}else {//用户想跳转到新的页面
			int row = goodsDao.SelectMaxRow(oldtj);//查询数据库里的总
			int maxpage = 0;
			if(row % nums >0) {//例如总共10条数据 每页3个 10除3余1 所以多出来的拿一个也需要有一页
				maxpage = row / nums + 1;
			}else {//例如总共9条数据 每页3个 9除3正好整除就不需要额外增加一页
				maxpage = row / nums;
			}
			if(topage<1) {
				topage = 1;//最小不能小于1
			}
			if(topage > maxpage) {
				topage = maxpage;//最大不能超过最大页数
			}
			page = topage;//把当前页修改为新页数
		}
		oldtj.setRow((page-1)*nums);//计算过的查询页数放到查询条件里
		oldtj.setNums(nums);
		List<Goods> glist = goodsDao.Select(oldtj);
		session.setAttribute("page", page);//刷新session中记录的新页数
		session.setAttribute("oldtj", oldtj);//刷新session中记录的新查询条件
		List<Types> tlist = typesDao.SelectAll();
		session.setAttribute("tlist", tlist);
		map.put("glist", glist);
		return "show";
	}
	@RequestMapping("/selectOrder")
	public String SelectOrder(int isdesc,Map<String, Object> map){
		List<Goods> glist = goodsDao.SelectOrder(isdesc);
		map.put("glist", glist);
		return "show";
	}

	@RequestMapping("/selectByName")
	public String SelectByName(String name,Map<String, Object> map) {
		List<Goods> glist = goodsDao.SelectByName("%"+name+"%");
		map.put("glist", glist);
		return "show";
	}
	@RequestMapping("/selectByTypes")
	public String SelectByTypes(int typesId,Map<String, Object> map) {
		List<Goods> glist = goodsDao.SelectByTypes(typesId);
		map.put("glist", glist);
		return "show";//跳转到show.ftl
	}

	@RequestMapping("/show")
	public String Show(Map<String, Object> map) {
		List<Goods> glist = goodsDao.SelectAll();
		map.put("glist", glist);
		return "show";//跳转到show.ftl
	}
}


