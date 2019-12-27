import java.util.Random;
import java.math.BigDecimal; // Вариант округления N 2
import java.math.RoundingMode; // Вариант округления N 2


public class WeatherProvider {
	
	private static double temperatureForToday = generateTemperature();
    private static double[] temperaturesFor10Days = generateTemperaturesForecastFor10Days();

    private static double generateTemperature() {
        Random rd = new Random(); 
        double temperature = 350 * (rd.nextDouble() - 0.5);// Без округления и Вариант округления N 2
        //double temperature = (double)((int) (300 * (rd.nextDouble() - 0.5) * 10)) / 10; // Вариант округления N 1
        double roundTemperature = new BigDecimal(temperature).setScale(1, RoundingMode.UP).doubleValue(); // Вариант округления N 2
        return roundTemperature; // Вариант округления N 2
        
        //return temperature; // Без округления и Вариант округления N 1
    }

    private static double[] generateTemperaturesForecastFor10Days() {
        double [] forecastArray = new double [10];
        for(int i = 0; i < forecastArray.length; i++) {
        	forecastArray [i] = generateTemperature();
        }
        return forecastArray;
    }  


    public static double getTemperatureForToday() {
        if(temperatureForToday >= -150 && temperatureForToday <= 150) {
        	return temperatureForToday;
        }
        double temperatureForTodayRounded = 200;
        if(temperatureForToday >= -152 && temperatureForToday < -150) {
        	temperatureForTodayRounded = -150;
        }
        else if(temperatureForToday > 150 && temperatureForToday <= 152) {
           	temperatureForTodayRounded = 150;
        }
        return temperatureForTodayRounded;
    }

    public static double[] getTemperaturesForecastFor10Days() {
    	for(int i = 0; i < temperaturesFor10Days.length; i++) {
        	if(temperaturesFor10Days [i] < -150 || temperaturesFor10Days [i] > 150){
        		break;
        	}
        	else if(i == temperaturesFor10Days.length - 1){
        		return temperaturesFor10Days;
        	}
        }
        double [] temperaturesFor10DaysRounded = new double [temperaturesFor10Days.length];
        for(int i = 0; i < temperaturesFor10Days.length; i++) {
        	if(temperaturesFor10Days [i] >= -150 && temperaturesFor10Days [i] <= 150){
        		temperaturesFor10DaysRounded[i] = temperaturesFor10Days[i];
        		continue;
        	}
        	temperaturesFor10DaysRounded[i] = 200;
        	if(temperaturesFor10Days [i] >= -152 && temperaturesFor10Days [i] < -150) {
        		temperaturesFor10DaysRounded[i] = -150;
        	}
        	else if(temperaturesFor10Days [i] > 150 && temperaturesFor10Days[i] <= 152) {
        		temperaturesFor10DaysRounded[i] = 150;
        	}
        }
        return temperaturesFor10DaysRounded;
    }

    public static double calculateAvgFor10Days() {
        double avgTemp10Days = 0;
    	for(int i = 0; i < temperaturesFor10Days.length; i++) {
    		avgTemp10Days += temperaturesFor10Days[i];
    	}
    	return avgTemp10Days/temperaturesFor10Days.length;
    }

    public static double getMaxTemperatureFor10Days() {
    	double MaxTemp10Days = temperaturesFor10Days[0];
    	for(int i = 1; i < temperaturesFor10Days.length; i++) {
    		if(MaxTemp10Days >= temperaturesFor10Days[i]) {
    			continue;
    		}
    		MaxTemp10Days = temperaturesFor10Days[i];
    	}
    	return MaxTemp10Days;
    }

    public static double getMinTemperatureFor10Days() {
    	double MinTemp10Days = temperaturesFor10Days[0];
    	for(int i = 1; i < temperaturesFor10Days.length; i++) {
    		if(MinTemp10Days <= temperaturesFor10Days[i]) {
    			continue;
    		}
    		MinTemp10Days = temperaturesFor10Days[i];
    	}
    	return MinTemp10Days;
    }
}