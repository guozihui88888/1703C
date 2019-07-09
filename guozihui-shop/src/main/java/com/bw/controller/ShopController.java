package com.bw.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.entity.Buss;
import com.bw.entity.Shop;
import com.bw.service.ShopService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
public class ShopController {
	@Resource
	private ShopService service;
	
	
	@RequestMapping("list.do")
	public String findAll(ModelMap map,String name,Integer bid,@RequestParam(defaultValue="1",required=true)Integer pageNum){
		Page<Object> page = PageHelper.startPage(pageNum,2);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("name", name);
		hashMap.put("bid", bid);
		List<Shop> list =service.findAll(hashMap);
		PageInfo<Shop> info = new PageInfo<Shop>(list);
		List<Buss> bus =service.findbid();
		map.addAttribute("info", info);
		map.addAttribute("bus", bus);
		return "list";
		
	}
	@RequestMapping("findbid.do")
	@ResponseBody
	public List<Buss> findbid(){
		List<Buss> list =service.findbid();
		return list;
	}
	@RequestMapping("addshop.do")
	@ResponseBody
	public int addshop(String sname,String indate,Integer sid,String bid){
		Shop shop = new Shop();
		shop.setSname(sname);
		shop.setIndate(indate);
		int i=service.addshop(shop);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("sid", sid);
		String[] split = bid.split(",");
		for (String string : split) {
			map.put("bid", string);
			int j =service.addbus(map);		
		}
			
		return  i;
	}
	@RequestMapping("chakan.do")
	public String chakan(Integer sid,ModelMap map){
		List<Shop> list =service.chakan(sid);
		System.out.println(list);
		map.addAttribute("list", list);
		return "chakan";
		
	}
	
	@RequestMapping("delbus.do")
	@ResponseBody
	public int delbus(String sid){
		int i =service.delbus(sid);
		return i;
	}
}
