package com.bw.service;

import java.util.HashMap;
import java.util.List;

import com.bw.entity.Buss;
import com.bw.entity.Shop;

public interface ShopService {

	List<Shop> findAll(HashMap<String, Object> hashMap);

	List<Buss> findbid();

	int addshop(Shop shop);

	int addbus(HashMap<String, Object> map);


	int delbus(String sid);

	List<Shop> chakan(Integer sid);

}
