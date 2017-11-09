package ca.ulaval.glo4002.carregistry.domain;

public class CarOwnerId {
	private int id;

	public CarOwnerId(int id) {
		this.id = id;
	}

	private CarOwnerId() {
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

		return ((CarOwnerId) other).id == id;
	}
}
