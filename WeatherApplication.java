public class WeatherApplication {

	public static void main(String[] args) {

		printWeatherRounded();
		printWeatherOriginal();

	}

	public static void printWeatherOriginal() {
		for (int i = 0; i < 13; i++) {
			System.out.print("#");
		}
		System.out.print(" WEATHER ");
		for (int i = 0; i < 13; i++) {
			System.out.print("#");
		}
		System.out.println("\n           original data\n");

		System.out.printf("TODAY: %7.1f C\n\n", WeatherProvider.getTemperatureForTodayOriginal());

		for (int i = 0; i < 35; i++) {
			System.out.print("-");
		}
		System.out.println("\n\nFORECAST FOR 10 DAYS\n");

		for (int i = 0; i < 10; i++) {
			System.out.printf("DAY %2d: %6.1f C\n", i + 1,
					WeatherProvider.getTemperaturesForecastFor10DaysOriginal()[i]);
		}
		System.out.println();
		System.out.printf("MAX: %9.1f C\n", WeatherProvider.getMaxTemperatureFor10DaysOriginal());
		System.out.printf("AVG: %9.1f C\n", WeatherProvider.calculateAvgFor10DaysOriginal());
		System.out.printf("MIN: %9.1f C\n\n", WeatherProvider.getMinTemperatureFor10DaysOriginal());
		for (int i = 0; i < 35; i++) {
			System.out.print("#");
		}
		System.out.println("\n");
	}

	public static void printWeatherRounded() {
		for (int i = 0; i < 13; i++) {
			System.out.print("#");
		}
		System.out.print(" WEATHER ");
		for (int i = 0; i < 13; i++) {
			System.out.print("#");
		}
		System.out.println("\n           for customers\n");
		try {
			WeatherProvider.getTemperatureForTodayRounded();
			WeatherProvider.getTemperaturesForecastFor10DaysRounded();

			System.out.printf("TODAY: %7.1f C\n\n", WeatherProvider.getTemperatureForTodayRounded());

			for (int i = 0; i < 35; i++) {
				System.out.print("-");
			}
			System.out.println("\n\nFORECAST FOR 10 DAYS\n");

			for (int i = 0; i < 10; i++) {
				System.out.printf("DAY %2d: %6.1f C\n", i + 1,
						WeatherProvider.getTemperaturesForecastFor10DaysRounded()[i]);
			}
			System.out.println();
			System.out.printf("MAX: %9.1f C\n", WeatherProvider.getMaxTemperatureFor10DaysRounded());
			System.out.printf("AVG: %9.1f C\n", WeatherProvider.calculateAvgFor10DaysRounded());
			System.out.printf("MIN: %9.1f C\n\n", WeatherProvider.getMinTemperatureFor10DaysRounded());

			for (int i = 0; i < 35; i++) {
				System.out.print("#");
			}
			System.out.println("\n");
		} catch (TemperatureDataOutOfRangeException exception) {

		}
	}
}