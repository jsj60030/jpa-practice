package com.bono.movie.Ticket;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TicketController {

	private final TicketService ticketService;
	
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	//예매
	@PostMapping(value = "/mvReserve")
	public Ticket mvReserve(@RequestBody TicketInfo request) {

		return ticketService.mvReserve(request);
	}
	
	//예매취소
}
