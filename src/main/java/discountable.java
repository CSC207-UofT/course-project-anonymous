public interface discountable {
    public double getFlightDiscount(double price);
    public double getMealDiscount(double price);
    public double getExtraBaggageDiscount(double price);
}
