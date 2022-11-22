package com.bono.movie.Ticket;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "Ticket")
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TK_NUM")
	private Long tkNum;

	@Column(name = "TK_MEMNUM")
	private Integer tkMemnum;

	@Column(name = "TK_COST")
	private Integer tkCost;

	@Column(name = "TK_SEAT")
	private String tkSeat;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "TK_DATE")
	private LocalDate tkDATE;

	@Column(name = "TK_PAY")
	private String tkPay;

	@Column(name = "TK_MVNUM")
	private Integer tkMvnum;

	@Column(name = "TK_RESTATE")
	private Integer tkRestate;

	@Column(name = "TK_COUNT")
	private Integer tkCount;

	@Column(name = "TK_STATE")
	private Integer tkState;
}
