package com.bono.movie.Ticket;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bono.movie.Member.Member;
import com.bono.movie.Member.MemberInfo;
import com.bono.movie.Member.MemberRepository;
import com.bono.movie.Movie.Movie;
import com.bono.movie.Movie.MovieInfo;
import com.bono.movie.Movie.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TicketService {
	private final MemberRepository memberRepository;
	private final MovieRepository movieRepository;
	private final TicketRepository ticketRepository;

	public TicketService(MemberRepository memberRepository, MovieRepository movieRepository,
			TicketRepository ticketRepository) {

		this.memberRepository = memberRepository;
		this.movieRepository = movieRepository;
		this.ticketRepository = ticketRepository;
	}

	// 예매
	public Ticket mvReserve(@RequestBody TicketInfo request, @RequestBody TicketInfo request1, @RequestBody MemberInfo request2,
			@RequestBody MovieInfo request3) {

		log.info("/mvReserve, request :{}", request);

		Member member = memberRepository.findById(request2.getMemNum())
				.orElseThrow(() -> new IllegalArgumentException("No Customer"));

		Movie movie = movieRepository.findById(request3.getMvNum())
				.orElseThrow(() -> new IllegalArgumentException("No Movie"));

		Ticket ticket = new Ticket();

		ticket.setTkMemnum(request2.getMemName());
		ticket.setTkMvnum(request3.getMvName());
		ticket.setTkCost(request.getTkCost());
		ticket.setTkSeat(request.getTkSeat());
		ticket.setTkPay(request.getTkPay());
		ticket.setTkRestate(request.getTkRestate());
		ticket.setTkCount(request.getTkCount());
		ticket.setTkState(request.getTkState());

		// 예매 정보 db 저장
		ticket = ticketRepository.save(ticket);

		log.info(ticket.toString());

		return ticket;
	}

	// 예매 취소(결제 취소)
}
