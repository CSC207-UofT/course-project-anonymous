public interface Refundable {
    public double calculateRefundByDaysLeft(double price, int daysLeft);
    public double calculateDateChangeChargeByDateLeft(double price, int daysLeft);
}