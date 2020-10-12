package com.example.mohamed.quraaan.APIs.Model;

import com.google.gson.annotations.SerializedName;

public class RecitersItem{

	@SerializedName("Server")
	private String server;

	@SerializedName("letter")
	private String letter;

	@SerializedName("name")
	private String name;

	@SerializedName("count")
	private String count;

	@SerializedName("suras")
	private String suras;

	@SerializedName("rewaya")
	private String rewaya;

	@SerializedName("id")
	private String id;

	public void setServer(String server){
		this.server = server;
	}

	public String getServer(){
		return server;
	}

	public void setLetter(String letter){
		this.letter = letter;
	}

	public String getLetter(){
		return letter;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCount(String count){
		this.count = count;
	}

	public String getCount(){
		return count;
	}

	public void setSuras(String suras){
		this.suras = suras;
	}

	public String getSuras(){
		return suras;
	}

	public void setRewaya(String rewaya){
		this.rewaya = rewaya;
	}

	public String getRewaya(){
		return rewaya;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"RecitersItem{" + 
			"server = '" + server + '\'' + 
			",letter = '" + letter + '\'' + 
			",name = '" + name + '\'' + 
			",count = '" + count + '\'' + 
			",suras = '" + suras + '\'' + 
			",rewaya = '" + rewaya + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}