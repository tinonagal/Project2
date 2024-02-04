package com.pms.service;

import java.util.Iterator;
import java.util.List;

import com.pms.bean.Participant;
import com.pms.dao.ParticipantDao;

public class ParticipantService {

	ParticipantDao pd = new ParticipantDao();
	
	public String createParticipant (Participant participant) {
		if(pd.createParticipant(participant)>0) {
			return "Participant details stored successfully";
		}else {
			return "Participant didn't get stored";
		}
	}
	public String updateParticipant (Participant participant) {
		if(pd.updateParticipantName(participant)>0) {
			return "Participant name updated successfully";
		}else {
			return "Participant ID is not present "+participant.getPid();
		}
	}
	
	public String deleteParticipant (int pid) {
		if(pd.deleteParticipant(pid)>0) {
			return "Participant deleted successfully";
		}else {
			return "Participant ID is not present "+pid;
		}
	}
	public String findParticipant (int pid) {
		Participant p = pd.findParticipant(pid);
		if(p==null) {
			return "Participant not present "+pid;
		}else {
			return p.toString();
		}
		
	}

	public List<Participant> Batch1Participant () {
		List<Participant> batch1Participant = pd.Batch1Participant();
		
		return batch1Participant;
		
	}
	public List<Participant> Batch2Participant () {
		List<Participant> batch2Participant = pd.Batch2Participant();
		
		return batch2Participant;
		
	}
	public List<Participant> findallParticipant () {
		List<Participant> listofParticipant = pd.findallParticipant();
		
		return listofParticipant;
		
	}
	
}
