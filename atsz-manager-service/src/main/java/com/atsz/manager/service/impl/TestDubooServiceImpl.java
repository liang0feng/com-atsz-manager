package com.atsz.manager.service.impl;

import org.springframework.stereotype.Service;

import com.atsz.manager.service.TestDubboService;

@Service
public class TestDubooServiceImpl implements TestDubboService {

	@Override
	public String test01() {
		String str = "Hello world!";
		return str;
	}

}
