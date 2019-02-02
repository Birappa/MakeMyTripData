package com.makemytrip.data.service;

import com.makemytrip.data.exception.SequenceException;

public interface SequenceService {

	long getNextSequenceId(String key)throws SequenceException;
}
