package com.bw.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Buss;
import com.bw.entity.Shop;
import com.bw.mapper.ShopDao;
@Service
public class ShopServiceImpl implements ShopService{
	@Resource
	private ShopDao dao;
	@Override
	public List<Shop> findAll(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return dao.findAll(hashMap);
	}
	@Override
	public List<Buss> findbid() {
		// TODO Auto-generated method stub
		return dao.findbid();
	}
	@Override
	public int addshop(Shop shop) {
		// TODO Auto-generated method stub
		return dao.addshop(shop);
	}
	@Override
	public int addbus(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.addbus(map);
	}

	public int delbus(String sid) {
		// TODO Auto-generated method stub
		return dao.delbus(sid);
	}
	@Override
	public List<Shop> chakan(Integer sid) {
		// TODO Auto-generated method stub
		return dao.chakan(sid);
	}

}
