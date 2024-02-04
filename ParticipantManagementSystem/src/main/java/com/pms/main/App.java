package com.pms.main;
import java.util.List;
import java.util.Scanner;

import com.pms.bean.Participant;
import com.pms.resouce.DBresource;
import com.pms.service.ParticipantService;

public class App {

	public static void main(String[] args) {
	ParticipantService ps =  new ParticipantService();
	//Participant p1 = new Participant(6,"Nao Takao", "naok@gmail.com","027633222",1);
	//String result = ps.createParticipant(p1);
	//System.out.println(result);
	Scanner sc = new Scanner(System.in);
	String con ="";
	int pid;
	int bid;
	String name;
	String email;
	String phone;
	String result;
	System.out.println("Welcome to Zumba management Sytem");
	do {
		System.out.println("1: Add Participant 2: Update Participant name 3: Delete Participant 4: Find Participant");
		System.out.println("5: Show Batch 1 Participants 6: Show Batch 2 Participants 7: Show all Prticipants");
		System.out.println("Please enter your choice: ");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Please enter Participant ID");
			pid = sc.nextInt();
			System.out.println("Please enter Participant Name");
			name = sc.next();
			System.out.println("Please enter Participant Email");
			email = sc.next();
			System.out.println("Please enter Participant Phone Number");
			phone = sc.next();
			System.out.println("Please enter Participant Batch");
			bid = sc.nextInt();
			Participant p1 = new Participant(pid,name,email,phone,bid);
			result = ps.createParticipant(p1);
			System.out.println(result);
			break;
			
		case 2:
			System.out.println("Please enter Participant ID");
			pid = sc.nextInt();
			System.out.println("Please enter New Participant Name");
			name = sc.next();
			Participant p2 = new Participant();
			p2.setPid(pid);
			p2.setName(name);
			result = ps.updateParticipant(p2);
			System.out.println(result);
			break;
			
		case 3:
			System.out.println("Please enter Participant ID");
			pid = sc.nextInt();
			result = ps.deleteParticipant(pid);
			System.out.println(result);
			break;
			
		case 4:
			System.out.println("Please enter Participant ID");
			pid = sc.nextInt();
			result = ps.findParticipant(pid);
			System.out.println(result);
			break;
			
		case 5:
			List<Participant> batch1Participant = ps.Batch1Participant();
			for(Participant p :batch1Participant) {
				System.out.println("PID: "+p.getPid()+ " Name: "+p.getName()+ " Email: "+p.getEmail()+ " Phone: "+p.getPhone()+ " Batch ID: "+p.getBid());
			} 
			break;
			
		case 6:
			List<Participant> batch2Participant = ps.Batch2Participant();
			for(Participant p :batch2Participant) {
				System.out.println("PID: "+p.getPid()+ " Name: "+p.getName()+ " Email: "+p.getEmail()+ " Phone: "+p.getPhone()+ " Batch ID: "+p.getBid());
			} 
			break;
			
			
		case 7:
			List<Participant> listofParticipant = ps.findallParticipant();
			for(Participant p :listofParticipant) {
				System.out.println("PID: "+p.getPid()+ " Name: "+p.getName()+ " Email: "+p.getEmail()+ " Phone: "+p.getPhone()+ " Batch ID: "+p.getBid());
			} 
			break;	
			
			default: System.out.println("Wrong choice");			
			break;
			

			
		}
		System.out.println("Do you want to continue?(y/n)");
		con = sc.next();
	}while (con.equals("y"));
	System.out.println("Thank you");
	DBresource.close();
	sc.close();
	}

	private static int nextInt() {
		// TODO Auto-generated method stub
		return 0;
	}

}
