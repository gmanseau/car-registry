package ca.ulaval.glo4002.carregistry.domain;

public class CarOwnerId {
	public static final int NEW = 0;

	private Integer id;

	public CarOwnerId(int id) {
		this.id = id;
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
