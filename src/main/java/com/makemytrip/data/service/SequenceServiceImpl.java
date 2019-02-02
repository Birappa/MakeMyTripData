package com.makemytrip.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.makemytrip.data.exception.SequenceException;
import com.makemytrip.data.model.SequenceId;

@Service("SequenceService")
public class SequenceServiceImpl implements SequenceService {

	@Autowired
	private MongoOperations mongoOperation;
	
	@Override
	public long getNextSequenceId(String key)throws SequenceException {
		
		SequenceId seqId = mongoOperation.findAndModify(new Query(Criteria.where("_id").is(key)), new Update().inc("seq", 1), new FindAndModifyOptions().returnNew(true), SequenceId.class);
		
		if (seqId == null) {
			throw new SequenceException("Unable to get sequence id for key : " + key);
		  }
		return seqId.getSeq();
	}

}
