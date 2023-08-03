package hellojpa.domain;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;
	private String zipcode;
	private String street;

	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getStreet() {
		return street;
	}

	private void setCity(String city) {
		this.city = city;
	}

	private void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	private void setStreet(String street) {
		this.street = street;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Address address = (Address)o;
		return Objects.equals(getCity(), address.getCity()) && Objects.equals(getZipcode(),
			address.getZipcode()) && Objects.equals(getStreet(), address.getStreet());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCity(), getZipcode(), getStreet());
	}
}
