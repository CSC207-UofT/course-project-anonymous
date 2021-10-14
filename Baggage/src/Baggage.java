abstract class Baggage {
    // An abstract class that stores information about customer baggage.
    private double weight;
    //weight of this baggage
    private double width;
    //width of this baggage
    private double height;
    //height of this baggage

    /**
     * Creates a new Baggage.
     *
     * @param weight          weight of this baggage.
     * @param width           width of this baggage.
     * @param height          height of this baggage.
     */
    public Baggage(double weight, double width, double height){
        this.weight = weight;
        this.width = width;
        this.height = height;
    }


    public double getweight(){
        return this.weight;
    }
    public double getwidth(){
        return this.width;
    }
    public double getwheight(){
        return this.height;
    }
    public void setweight(double new_weight){
        this.weight = new_weight;
    }
    public void setWidth(double new_width){
        this.width = new_width;
    }
    public void setHeight(double new_height){
        this.height = new_height;
    }

//    @Override
//    public String toString(){
//        return "This baggage has dimensions : " this.weight;
//    }
}
