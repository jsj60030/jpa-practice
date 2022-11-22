package com.bono.movie.Movie;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "MOVIE")
@Data
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MV_NUM")
	private Long mvNum;
	
	@Column(name = "MV_STATE")
	private String mvState;

	@Column(name = "MV_STORY")
	private String mvStory;

	@Column(name = "MV_IMG")
	private String mvImg;
	
	@Column(name = "MV_AVI")
	private String mvAvi;
	
	@Column(name = "MV_PICK")
	private Integer mvPick;
	
	@Column(name = "MV_GENDER")
	private String mvGender;
	
	@Column(name = "MV_AGE")
	private Integer mvAge;
	
	@Column(name = "MV_NAME")
	private String mvName;
	
	@Column(name = "MV_DATE_START")
	private LocalDate mvDateStart;
	
	@Column(name = "MV_DATE_END")
	private LocalDate mvDateEnd;
	
	@Column(name = "MV_TIME")
	private Time mvTime;
	
	@Column(name = "MV_GRADE")
	private Integer mvGrade;
}
