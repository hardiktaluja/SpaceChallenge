public class U2 extends Rocket {

    public U2() {
        this.cost = 120;
        this.weight = 18000;
        this.maxWeight = 29000;
        this.currentWeight = this.weight;
        this.launchExplosion = 0.04;
        this.landingCrash = 0.08;
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = launchExplosion * (currentWeight - weight) / (maxWeight - weight);
        return chanceOfLaunchExplosion > Math.random();
    }

    @Override
    public boolean land() {
        double chanceOfLandingCrash = landingCrash * (currentWeight - weight) / (maxWeight - weight);
        return chanceOfLandingCrash > Math.random();
    }

}
