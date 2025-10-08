package com.concurrency.service.impl;

import com.concurrency.service.CounterService;


public class CounterServiceImpl implements CounterService {
	private int count;

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void incrementCount() {
		++count;
	}
}
