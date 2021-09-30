package com.farm.Bean;

import java.io.InputStream;

import javax.servlet.http.Part;

import com.mysql.cj.jdbc.Blob;

public class CropBean {

	private int id;
	private String crop_name;
	private String crop_month;
	private String crop_desc;
	private String image;
	private String start_month;
	private String end_month;
	
	
	
	
	public String getStart_month() {
		return start_month;
	}
	public void setStart_month(String start_month) {
		this.start_month = start_month;
	}
	public String getEnd_month() {
		return end_month;
	}
	public void setEnd_month(String end_month) {
		this.end_month = end_month;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCrop_name() {
		return crop_name;
	}
	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}
	public String getCrop_month() {
		return crop_month;
	}
	public void setCrop_month(String crop_month) {
		this.crop_month = crop_month;
	}
	public String getCrop_desc() {
		return crop_desc;
	}
	public void setCrop_desc(String crop_desc) {
		this.crop_desc = crop_desc;
	}
	
	
	
	
}
