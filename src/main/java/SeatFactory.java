public class SeatFactory {

    /**
     * return the desired object of type Seat
     *
     * @param seatType the type of Seat
     * @param id       the seat's id
     * @param price    the seat's price
     * @return the object of the corresponding type MembershipStatus
     **/
    public Seat getSeat(String seatType, int id, double price) {
        if (seatType == null) {
            return null;
        }
        if (seatType.equalsIgnoreCase("ECONOMYSEAT")) {
            return new EconomySeat(id, price);

        } else if (seatType.equalsIgnoreCase("FIRSTCLASSSEAT")) {
            return new FirstClassSeat(id, price);

        } else if (seatType.equalsIgnoreCase("BUSINESSCLASSSEAT")) {
            return new BusinessClassSeat(id, price);
        }
        return null;
    }
}
