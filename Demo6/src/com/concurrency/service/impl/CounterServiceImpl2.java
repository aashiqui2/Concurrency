package com.concurrency.service.impl;

import com.concurrency.service.CounterService;


public class CounterServiceImpl2 implements CounterService {
	private int count;

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public synchronized void incrementCount() {
		++count;
	}
}
