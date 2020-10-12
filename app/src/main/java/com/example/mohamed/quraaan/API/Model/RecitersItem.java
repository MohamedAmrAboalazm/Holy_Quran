package com.example.mohamed.quraaan.API.Model;


import com.google.gson.annotations.SerializedName;

public class RecitersItem {

	@SerializedName("Rewaya")
	private String rewaya;

	@SerializedName("IsCompleted")
	private String isCompleted;

	@SerializedName("TotalAvailable")
	private String totalAvailable;

	@SerializedName("ID")
	private String iD;

	@SerializedName("BitRate")
	private String bitRate;

	@SerializedName("MusshafType")
	private String musshafType;

	@SerializedName("URL")
	private String uRL;

	@SerializedName("Name")
	private String name;

	public void setRewaya(String rewaya){
		this.rewaya = rewaya;
	}

	public String getRewaya(){
		return rewaya;
	}

	public void setIsCompleted(String isCompleted){
		this.isCompleted = isCompleted;
	}

	public String getIsCompleted(){
		return isCompleted;
	}

	public void setTotalAvailable(String totalAvailable){
		this.totalAvailable = totalAvailable;
	}

	public String getTotalAvailable(){
		return totalAvailable;
	}

	public void setID(String iD){
		this.iD = iD;
	}

	public String getID(){
		return iD;
	}

	public void setBitRate(String bitRate){
		this.bitRate = bitRate;
	}

	public String getBitRate(){
		return bitRate;
	}

	public void setMusshafType(String musshafType){
		this.musshafType = musshafType;
	}

	public String getMusshafType(){
		return musshafType;
	}

	public void setURL(String uRL){
		this.uRL = uRL;
	}

	public String getURL(){
		return uRL;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"RecitersItem{" +
			"rewaya = '" + rewaya + '\'' + 
			",isCompleted = '" + isCompleted + '\'' + 
			",totalAvailable = '" + totalAvailable + '\'' + 
			",iD = '" + iD + '\'' + 
			",bitRate = '" + bitRate + '\'' + 
			",musshafType = '" + musshafType + '\'' + 
			",uRL = '" + uRL + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}