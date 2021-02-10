package odogo.plantary.util.except;

public class PlanetaryWorldInvalidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlanetaryWorldInvalidException(String reason) {
		super(reason);
	}
}
