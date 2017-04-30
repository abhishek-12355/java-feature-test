package com.netshell.test.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonNullDeserializer implements Test {
	
	private String message = "[\"{\\\"name\\\":\\\"Capital Systems\\\",\\\"location\\\":{\\\"street1\\\":\\\"65 Boston Post Road\\\",\\\"street2\\\":null,\\\"street3\\\":null,\\\"street4\\\":null,\\\"city\\\":\\\"Boston\\\",\\\"postcode\\\":\\\"34234234\\\",\\\"stateOrProvince\\\":\\\"CA\\\",\\\"country\\\":\\\"US\\\",\\\"longitude\\\":\\\"0.0\\\",\\\"latitude\\\":\\\"0.0\\\",\\\"key\\\":\\\"290\\\"},\\\"id\\\":\\\"303\\\"}\"]";
	
//	private String message = "[\"{\\\"abc\\\":null}\"]";

	@Override
	public void execute() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		/*String readValue = mapper.readValue(message, String.class);
		Site site = mapper.readValue(readValue, Site.class);
		System.out.println(site);*/
		
		String[] readValue = mapper.readValue(message, String[].class);
		
		System.out.println(Arrays.toString(readValue));

		List<Site> sites = new ArrayList<>();
		for (String siteStr : readValue) {
            Site site = mapper.readValue(siteStr, Site.class);
			sites.add(site);
        }
		
		System.out.println(sites.toString());
	}

	public static class Site implements Serializable {

		private static final long serialVersionUID = 1L;

		private String ID;
		private String name;
		private Location location;
		private String siteGroupID;
		private String siteGroupName;
		
		/*public Site(String iD, String name, Location location, String siteGroupID, String siteGroupName) {
			super();
			ID = iD;
			this.name = name;
			this.location = location;
			this.siteGroupID = siteGroupID;
			this.siteGroupName = siteGroupName;
		}*/

		public String getID() {
			return ID;
		}

		public void setID(final String iD) {
			ID = iD;
		}

		public String getName() {
			return name;
		}

		public void setName(final String name) {
			this.name = name;
		}

		public Location getLocation() {
			return location;
		}

		public void setLocation(final Location location) {
			this.location = location;
		}

		public String getSiteGroupID() {
			return siteGroupID;
		}

		public void setSiteGroupID(final String siteGroupID) {
			this.siteGroupID = siteGroupID;
		}

		public String getSiteGroupName() {
			return siteGroupName;
		}

		public void setSiteGroupName(final String siteGroupName) {
			this.siteGroupName = siteGroupName;
		}

	}
	
	public static class Location implements Serializable {

		private static final long serialVersionUID = 1L;

		private String key;
		private String street1;
		private String street2;
		private String street3;
		private String street4;
		private String city;
		private String postcode;
		private String stateOrProvince;
		private String country;
		private String longitude;
		private String latitude;
		
		

		/*public Location(String key, String street1, String street2, String street3, String street4, String city,
				String postcode, String stateOrProvince, String country, String longitude, String latitude) {
			super();
			this.key = key;
			this.street1 = street1;
			this.street2 = street2;
			this.street3 = street3;
			this.street4 = street4;
			this.city = city;
			this.postcode = postcode;
			this.stateOrProvince = stateOrProvince;
			this.country = country;
			this.longitude = longitude;
			this.latitude = latitude;
		}*/

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getStreet1() {
			return street1;
		}

		public void setStreet1(String street1) {
			this.street1 = street1;
		}

		public String getStreet2() {
			return street2;
		}

		public void setStreet2(String street2) {
			this.street2 = street2;
		}

		public String getStreet3() {
			return street3;
		}

		public void setStreet3(String street3) {
			this.street3 = street3;
		}

		public String getStreet4() {
			return street4;
		}

		public void setStreet4(String street4) {
			this.street4 = street4;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getPostcode() {
			return postcode;
		}

		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}

		public String getStateOrProvince() {
			return stateOrProvince;
		}

		public void setStateOrProvince(String stateOrProvince) {
			this.stateOrProvince = stateOrProvince;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

	}

}
