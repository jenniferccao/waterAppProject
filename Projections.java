
public class Projections {
  private static double totalConsumed = 0.0;
  private static final double SHOWER_FLOW_RATE = 0.18;
  private static final double HAND_WASHING_FLOW_RATE = 0.09;
  private static final double DISH_WASHING_FLOW_RATE = 0.02;
  private static final double TOOTH_BRUSHING_FLOW_RATE = 0.08;
  private static final double BATH_RATE = 132.5;
  private static final double DISH_WASHER_FLOW_RATE = 32;
  private static final double FOOD_PREP_RATE = 15;
  private static final double TOILET_RATE = 10.5;

  private static final double LAUNDRY_RATE = 150;

  private static final int NUM_ACTIVITIES = 9; //temporary constant

  public static double calculateShower(int minutes, int seconds) {
    int totalSeconds = (minutes * 60) + seconds;
    double showerConsumed = totalSeconds * SHOWER_FLOW_RATE;
    totalConsumed += showerConsumed;
    return showerConsumed;
  }

  public static double calculateHandWashing(int minutes, int seconds){
    int totalSeconds = (minutes * 60) + seconds;
    double handWashingConsumed = totalSeconds * HAND_WASHING_FLOW_RATE;
    totalConsumed += handWashingConsumed;
    return handWashingConsumed;
  }

  public static double calculateDishWashing(int minutes, int seconds){
    int totalSeconds = (minutes * 60) + seconds;
    double dishWashingConsumed = totalSeconds * DISH_WASHING_FLOW_RATE;
    totalConsumed += dishWashingConsumed;
    return dishWashingConsumed;
  }


  public static double calculateToothBrushing(int minutes, int seconds){
    int totalSeconds = (minutes * 60) + seconds;
    double toothBrushingConsumed = totalSeconds * TOOTH_BRUSHING_FLOW_RATE;
    totalConsumed += toothBrushingConsumed;
    return toothBrushingConsumed;

  }

  public static double calculateBath(int frequency){
    double bathConsumed = frequency * BATH_RATE;
    totalConsumed += bathConsumed;
    return bathConsumed;

  }

  public static double calculateDishwasher(int frequency){
    double dishwasherConsumed = frequency * DISH_WASHER_FLOW_RATE;
    totalConsumed += dishwasherConsumed;
    return dishwasherConsumed;
  }

  public static double calculateFoodPrep(int frequency){
    double foodPrepConsumed = frequency * FOOD_PREP_RATE;
    totalConsumed += foodPrepConsumed;
    return foodPrepConsumed;
  }

  public static double calculateToilet(int frequency){
    double bathConsumed = frequency * TOILET_RATE;
    totalConsumed += bathConsumed;
    return bathConsumed;
  }

  public static double calculateLaundry(int frequency){
    double laundryConsumed = frequency * LAUNDRY_RATE;
    totalConsumed += laundryConsumed;
    return laundryConsumed;
  }
  public static double getTotalConsumed() {
    return totalConsumed;
  }

  public static void setTotalConsumed(double num) {
    totalConsumed = num;
  }

  public static double[] getData() {
    double[] data = {SHOWER_FLOW_RATE, HAND_WASHING_FLOW_RATE, DISH_WASHING_FLOW_RATE,
                     TOOTH_BRUSHING_FLOW_RATE, BATH_RATE, DISH_WASHER_FLOW_RATE,
                     FOOD_PREP_RATE, TOILET_RATE, LAUNDRY_RATE};
    return data;
  }

  public static String[] getDataNames() {
    String[] dataAct = {"Shower", "Hand wash", "Dish wash (hand)", "Tooth brush", "Bath", "Dish wash (machine)", "Food prep", "Toilet", "Laundry"};
    return dataAct;
  }

  public static int getNumActivities() {
    return NUM_ACTIVITIES;
  }
}
