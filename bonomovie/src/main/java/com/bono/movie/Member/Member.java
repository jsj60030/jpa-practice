package com.bono.movie.Member;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "MEMBER")
@Data
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEM_NUM")
	private Long memNum;

	@Column(name = "MEM_ID")
	private String memId;

	@Column(name = "MEM_PW")
	private String memPw;

	@Column(name = "MEM_NAME")
	private String memName;

	@Column(name = "MEM_GENDER")
	private Integer memGender;

	@Temporal(TemporalType.DATE)
	@Column(name = "MEM_BIRTHDAY")
	private Date memBirthday;

	@Column(name = "MEM_MOBILE")
	private String memMobile;

	@Column(name = "MEM_EMAIL")
	private String memEmail;

	@Column(name = "MEM_POINT")
	private Integer memPoint;

	@Column(name = "MEM_MONEY")
	private Integer memMoney;

	@Column(name = "MEM_ADMIN")
	@Enumerated(EnumType.STRING)
	private MemberAdmin memAdmin;

	@Enumerated(EnumType.STRING)
	@Column(name = "MEM_STATE")
	private MemberState memState;

	@Column(name = "MEM_JOINDATE")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private LocalDate memJoindate;

	@Column(name = "MEM_SYSDATE")
	@UpdateTimestamp
	private LocalDateTime memSysdate;
	
}
