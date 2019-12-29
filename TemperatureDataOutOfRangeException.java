public class TemperatureDataOutOfRangeException extends Exception {

	private static final long serialVersionUID = 2325938556507610365L;

	public TemperatureDataOutOfRangeException() {
		System.out.println("We are sorry!\nThe data is unavailable!\nSerial Version " + serialVersionUID + "\n");
		for (int i = 0; i < 35; i++) {
			System.out.print("#");
		}
		System.out.println("\n");
	}
}
