package ShirwardIsland.Farmer;

public abstract class Farmer
{
   // protected String type;
    protected int levelReq;
    protected int waterBonus;
    protected int earnBuyBonus;
    protected int cropBonus;

    public Farmer(int levelReq, int waterBonus, int earnBuyBonus, int cropBonus)
    {
        this.levelReq = levelReq;
        this.waterBonus = waterBonus;
        this.earnBuyBonus = earnBuyBonus;
        this.cropBonus = cropBonus;
    }
}
