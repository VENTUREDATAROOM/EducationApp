package com.education.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="test_series")
public class TestSeries {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long testSeriesId;
	private String testSeriesName;
	private String classCode;
	private byte[] testPdf;

}
