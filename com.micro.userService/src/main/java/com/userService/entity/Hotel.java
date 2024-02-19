package com.userService.entity;

public class Hotel {


    private String hotelId;
    private String hotelName;
    private String hotelLocation;
    private String about;
	public Hotel(String hotelId, String hotelName, String hotelLocation, String about) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.about = about;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelLocation=" + hotelLocation
				+ ", about=" + about + "]";
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelLocation() {
		return hotelLocation;
	}
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
}
