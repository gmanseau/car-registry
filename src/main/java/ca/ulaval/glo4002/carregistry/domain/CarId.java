package ca.ulaval.glo4002.carregistry.domain;

import java.util.Objects;

public class CarId {
	private int id;

	public CarId(int id) {
		this.id = id;
	}

	private CarId() {
		// For persistence or serialization only
	}

	public int toInteger() {
		return id;
	}

	public boolean isNew() {
		return id == 0;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(id);
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}

		if (getClass() != other.getClass()) {
			return false;
		}

		return ((CarId) other).id == id;
	}

}
