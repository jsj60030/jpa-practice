package com.bono.movie.Movie;

import java.sql.Date;
import java.sql.Time;

import lombok.Value;

@Value
public class MovieInfo {

	private String mvState;
	private String mvStory;
	private String mvImg;
	private String mvAvi;
	private Integer mvPick;
	private String mvGender;
	private String mvAge;
	private String mvName;
	private Date mvDateStart;
	private Date mvDateEnd;
	private Time mvTime;
	private Integer mvGrade;

	public MovieInfo() {
		
		this.mvState = "default";
		this.mvStory = "default";
		this.mvImg = "default";
		this.mvAvi = "default";
		this.mvPick = 0;
		this.mvGender = "default";
		this.mvAge = "default";
		this.mvName = "default";
		this.mvDateStart = Date.valueOf("0001-01-01");
		this.mvDateEnd = Date.valueOf("0001-01-01");
		this.mvTime = Time.valueOf("00:00:01");
		this.mvGrade = 0;
	}
}
