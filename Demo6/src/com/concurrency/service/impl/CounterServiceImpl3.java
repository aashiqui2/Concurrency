package com.concurrency.service.impl;

import java.util.concurrent.locks.Lock;

import com.concurrency.service.CounterService;

public class CounterServiceImpl3 implements CounterService {
	private int count;
	private Lock lock;

	public CounterServiceImpl3(Lock lock) {
		super();
		this.lock = lock;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void incrementCount() {
		lock.lock();  // acquire
		++count; // count = count + 1
		lock.unlock(); // release
	}
}
