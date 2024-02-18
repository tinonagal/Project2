package com.zms.service;

import java.util.List;

import com.zms.bean.Batch;
import com.zms.dao.BatchDao;

public class BatchService {

	BatchDao bd = new BatchDao();
	public String storeBatch(Batch bat) {
		if(bat.getBid()<100) {
			return "Batch ID must between 100-110, check batches created";
		}else if (bd.storeBatch(bat)>0) {
			return "New Batch created";
		}else {
			return "New Batch was not added";
		}
	}
	public String updateBatch(Batch bat) {
		if(bd.updateBatch(bat)>0) {
			return "Batch Time has been updated successfully";
		}else {
			return "Batch Time update unsuccessful";
		}
	}
	public String deleteBatch(int bid) {
		if(bd.deleteBatch(bid)>0) {
			return "Batch deleted successfully";
		}else {
			return "Batch is not deleted";
		}
	}
	public List<Batch> showBatch() {
		
		return bd.showBatch();
	
}
	
}
