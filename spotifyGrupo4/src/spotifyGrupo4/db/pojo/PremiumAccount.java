package spotifyGrupo4.db.pojo;

import java.util.Date;
import java.util.Objects;

public class PremiumAccount extends Account {

	private int cardNumber = 0;
	private Date expiringDate = null;
	private int cardCvv = 0;

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpiringDate() {
		return expiringDate;
	}

	public void setExpiringDate(Date expiringDate) {
		this.expiringDate = expiringDate;
	}

	public int getCardCvv() {
		return cardCvv;
	}

	public void setCardCvv(int cardCvv) {
		this.cardCvv = cardCvv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cardCvv, cardNumber, expiringDate);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremiumAccount other = (PremiumAccount) obj;
		return cardCvv == other.cardCvv && cardNumber == other.cardNumber
				&& Objects.equals(expiringDate, other.expiringDate);
	}

	@Override
	public String toString() {
		return "PremiumAccount [cardNumber=" + cardNumber + ", expiringDate=" + expiringDate + ", cardCvv=" + cardCvv
				+ "]";
	}

}
