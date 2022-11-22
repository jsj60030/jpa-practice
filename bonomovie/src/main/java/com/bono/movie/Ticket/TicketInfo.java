package com.bono.movie.Ticket;

import lombok.Value;

@Value
public class TicketInfo {
	
	private Integer tkCost;
	private String tkSeat;
	private String tkPay;
	private Integer tkRestate;
	private Integer tkCount;
	private Integer tkState;
	
	public TicketInfo() {
		
		this.tkCost = 0;
		this.tkSeat = "default";
		this.tkPay = "신용카드";
		this.tkRestate = 0;
		this.tkCount = 0;
		this.tkState = 0;
		
	}
}
