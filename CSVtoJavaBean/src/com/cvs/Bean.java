package com.cvs;

public class Bean {

	int id;
	String imiê;
	String nazwisko;
	String email;
	String gender;
	String ip_adress;
	String company_name;
	String country;
	String language;
	String description;
	
	
	
	public Bean(int id, String imiê, String nazwisko, String email, String gender, String ip_adress,
			String company_name, String country, String language, String description) {
		super();
		this.id = id;
		this.imiê = imiê;
		this.nazwisko = nazwisko;
		this.email = email;
		this.gender = gender;
		this.ip_adress = ip_adress;
		this.company_name = company_name;
		this.country = country;
		this.language = language;
		this.description = description;
	}
	
	
	
	@Override
	public String toString() {
		return "Bean [id=" + id + ", imiê=" + imiê + ", nazwisko=" + nazwisko + ", email=" + email + ", gender="
				+ gender + ", ip_adress=" + ip_adress + ", company_name=" + company_name + ", country=" + country
				+ ", language=" + language + ", description=" + description + "]";
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImiê() {
		return imiê;
	}
	public void setImiê(String imiê) {
		this.imiê = imiê;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIp_adress() {
		return ip_adress;
	}
	public void setIp_adress(String ip_adress) {
		this.ip_adress = ip_adress;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
