package spotifyGrupo4.db.pojo;

import java.util.Date;
import java.util.Objects;

public abstract class Account {

	private int id = 0;
	private int postalCode = 0;
	private String city = null;
	private String country = null;
	private Date birthDate = null;
	private Date lastLogin = null;
	private String dni = null;
	private String name = null;
	private String middleName = null;
	private String surName = null;
	private String accountType = null;
	private Boolean isBloqued = null;
	private String password = null;
	private Date registryDate = null;

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

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
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

	public Boolean getIsBloqued() {
		return isBloqued;
	}

	public void setIsBloqued(Boolean isBloqued) {
		this.isBloqued = isBloqued;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountType, birthDate, city, country, dni, id, isBloqued, lastLogin, middleName, name,
				postalCode, surName);
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
				&& Objects.equals(dni, other.dni) && id == other.id && Objects.equals(isBloqued, other.isBloqued)
				&& Objects.equals(lastLogin, other.lastLogin) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(name, other.name) && postalCode == other.postalCode
				&& Objects.equals(surName, other.surName);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", postalCode=" + postalCode + ", city=" + city + ", country=" + country
				+ ", birthDate=" + birthDate + ", lastLogin=" + lastLogin + ", dni=" + dni + ", name=" + name
				+ ", middleName=" + middleName + ", surName=" + surName + ", accountType=" + accountType
				+ ", isBloqued=" + isBloqued + ", password=" + password + ", registryDate=" + registryDate + "]";
	}

	public Date getRegistryDate() {
		return registryDate;
	}

	public void setRegistryDate(Date registryDate) {
		this.registryDate = registryDate;
	}

}