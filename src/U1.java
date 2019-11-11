public class U1 extends Rocket {

    public U1() {
        this.cost = 100;
        this.weight = 10000;
        this.maxWeight = 18000;
        this.currentWeight = this.weight;
        this.launchExplosion = 0.05;
        this.landingCrash = 0.01;
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = launchExplosion * (currentWeight - weight) / (maxWeight - weight);
        return chanceOfLaunchExplosion < Math.random();
    }

    @Override
    public boolean land() {
        double chanceOfLandingCrash = landingCrash * (currentWeight - weight) / (maxWeight - weight);
        return chanceOfLandingCrash > Math.random();
    }
}
