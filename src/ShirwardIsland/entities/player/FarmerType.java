package ShirwardIsland.entities.player;

import ShirwardIsland.Farmer.Farmer;

public enum FarmerType {
    FARMER(0,0,0,0,0, "Farmer"), REGISTERED_FARMER(10,2,0,0.5,200, "Registered Farmer"),
    DISTINGUISHED_FARMER(15,3,1,0.10,250,"Distinguished Farmer"), HONORABLE_FARMER(20,5,2,.15,350,"Honorable Farmer");


    int levelreq, earningbuying, wfbonus, registrationfee;
    String farmertype;
    String description;


    double harvesttime;


    FarmerType(int levelreq, int earningbuying, int wfbonus,  double harvesttime, int registrationfee, String farmertype) {
        this.levelreq = levelreq;
        this.earningbuying = earningbuying;
        this.wfbonus = wfbonus;
        this.registrationfee = registrationfee;
        this.harvesttime = harvesttime;
        this.farmertype = farmertype;
        this.description = "To register you need to pay " + registrationfee + " Object coins and a level of " + levelreq + "is required";
    }

    public String getFarmertype() {
        return farmertype;
    }
    public int getLevelreq() {
        return levelreq;
    }

    public int getEarningbuying() {
        return earningbuying;
    }

    public int getWfbonus() {
        return wfbonus;
    }

    public int getRegistrationfee() {
        return registrationfee;
    }

    public double getHarvesttime() {
        return harvesttime;
    }

    public String getDescription() {
        return description;
    }

    public FarmerType nextFarmerType(FarmerType farmerType){

        switch (farmerType.getFarmertype()){
            case "Farmer" : return REGISTERED_FARMER;
            case "Registered Farmer" : return DISTINGUISHED_FARMER;
            case "Distinguished Farmer" : return HONORABLE_FARMER;
            case "Honorable Farmer" : return null;
        }

        return null;
    }
}
