package com.example.mohamed.quraaan.API.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RadiosResponse{

	@SerializedName("Radios")
	private List<RecitersItem> radios;

	public void setRadios(List<RecitersItem> radios){
		this.radios = radios;
	}

	public List<RecitersItem> getRadios(){
		return radios;
	}

	@Override
 	public String toString(){
		return 
			"RadiosResponse{" + 
			"radios = '" + radios + '\'' + 
			"}";
		}
}