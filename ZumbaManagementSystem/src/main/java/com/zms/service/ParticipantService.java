package com.zms.service;

import java.util.List;

import com.zms.bean.Participant;
import com.zms.dao.ParticipantDao;

public class ParticipantService {

	ParticipantDao pd = new ParticipantDao();
	public String storeParticipant(Participant par) {
		if(par.getName().isEmpty()) {
			return "Name cannot be empty";
		}else if(pd.storeParticipant(par)>0) {
			return "Participant recorded successfully";
		}else {
			return "Participant NOT recorded successfully";
		}
	}
	
	public String updateParticipantBatch(Participant par) {
		if(pd.updateParticipantBatch(par)>0) {
			return "Batch ID has been updated successfully";
		}else {
			return "Batch ID update unsuccessful";
		}
	}
	
	public String deleteParticipant(int pid) {
		if(pd.deleteParticipant(pid)>0) {
			return "Participant deleted successfully";
		}else {
			return "Participant is not deleted";
		}
	}
	public List<Participant> showParticipants() {
		
			return pd.showParticipants();
		
	}
}
