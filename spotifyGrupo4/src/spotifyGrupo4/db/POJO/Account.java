package spotifyGrupo4.db.POJO;

import java.util.Date;
import java.util.Objects;

public abstract class Account {

	private int id = 0;
	private int postalCode = 0;
	private String city = null;
	private String country = null;
	private Date birthDate = null;
	private String dni = null;
	private String name = null;
	private String middleName = null;
	private String surName = null;
	private String accountType = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountType, birthDate, city, country, dni, id, middleName, name, postalCode, surName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountType, other.accountType) && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(dni, other.dni) && id == other.id && Objects.equals(middleName, other.middleName)
				&& Objects.equals(name, other.name) && postalCode == other.postalCode
				&& Objects.equals(surName, other.surName);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", postalCode=" + postalCode + ", city=" + city + ", country=" + country
				+ ", birthDate=" + birthDate + ", dni=" + dni + ", name=" + name + ", middleName=" + middleName
				+ ", surName=" + surName + ", accountType=" + accountType + "]";
	}

}
