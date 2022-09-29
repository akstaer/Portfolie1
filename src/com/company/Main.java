package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //Container vessel
        ContainerVessel c = new ContainerVessel("Danmark", 5.5, 10.0, 20.5); //objekt
        c.loadingCargo(10,5);
        System.out.println("The capacity of the container vessel is " + c.utilityLevelOfCapacity()+ "%");

        //Tanker vessel
        TankerVessel t = new TankerVessel("Tyskland", 5, 20, 40); //objekt
        t.loadingCargo(8);
        System.out.println("Numbers of compartments: " + t.tal);
        t.utilityLevelOfCapacity();

        //RoRo vessel
        RoRoVessel r = new RoRoVessel("Kroatien", 10, 500, 2000, 1000);
        r.loadingCargo(4,7);
        System.out.println(r.utilityLevelOfCapacity() + " % of the lane is used");

    }
}

abstract class Vessels {
    private String flagNation;
    private double draft;
    private double length;
    private double width;

    //get&set for FlagNation
    //public String getFlagNation(){return flagNation;}
    public void setFlagNation(String flagNation){
        this.flagNation = flagNation;
    }
    //get&set Draft
    //public double getDraft(){return draft;}
    public void setDraft(double draft){
        this.draft= draft;
    }

    //get&set Length
    //public double getLength(){return length;}
    public void setLength(double length){this.length = length;}

    //get&set width
    //public double getWidth(){return width;}
    public void setWidth(double width) {this.width = width;}
}

class ContainerVessel extends Vessels {
    double containerCapacity; //privat or not??
    int numbersOfContainer;
    double positionX;
    double positionY;
    String destination;

    public ContainerVessel(String flagNation, double draft, double width, double length) { // constructor
        setFlagNation(flagNation);
        setDraft(draft);
        setWidth(width);
        setLength(length);

    }
    public void loadingCargo(int containerCapacity, int numbersOfContainer ) {
        this.containerCapacity = containerCapacity;
        this.numbersOfContainer = numbersOfContainer;
    }

    public double utilityLevelOfCapacity() {

        double n = (numbersOfContainer/containerCapacity)*100;

        return n;
    }

    public void trackingContainer(double positionX, double positionY){

        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void futureDestination(String destination){
        this.destination = destination;
    }
}

class TankerVessel extends Vessels {
    public int cargo;
    private int compartments;
    public boolean isCompartmentFilled = false;
    Random r = new Random();
    int tal = r.nextInt(10 + 1);

    public TankerVessel(String flagNation, double draft, double width, double length) { //constructor
        setFlagNation(flagNation);
        setDraft(draft);
        setWidth(width);
        setLength(length);

    }

    public void loadingCargo(int cargo) {
        this.compartments = tal;
        this.cargo = cargo;

    }

    public void utilityLevelOfCapacity () {
        if(compartments == cargo ){
            isCompartmentFilled = true;
            System.out.println("All the compartments are full");
        }
        else if (compartments > cargo){
            isCompartmentFilled = false;
            int n = compartments - cargo;
            System.out.println(n + " of the compartments are empty!");
        }
        else {
            isCompartmentFilled= false;
            int h = cargo - compartments;
            System.out.println("There is not room for the last " + h + " cargos");
        }
    }
}

class RoRoVessel extends Vessels {
    private double laneMeters;
    public int cars; //8 meter
    public int trucks; //30 meters

    public RoRoVessel(String flagNation, int draft, int width, int length, double laneMeters){
        setFlagNation(flagNation);
        setDraft(draft);
        setWidth(width);
        setLength(length);
        this.laneMeters = laneMeters;
    }

    public void loadingCargo (int cars, int trucks) {
        this.cars = cars;
        this.trucks = trucks;


    }
    public double utilityLevelOfCapacity() {

        double l = (cars*8+trucks*30) / laneMeters*100;
        return l;
    }
}



