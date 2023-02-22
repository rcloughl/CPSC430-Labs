import java.util.Random;
public class Family {
    private int girls;
    private int boys;
    public static int totalBoys;
    public static int totalGirls;

    //family constructor
    public Family(){
        boys=0;
        girls=0;
    }

    //increments the children by one (setter but for our specific needs)
    private void incGirls(){
        this.girls+=1;
    }
    private void incBoys(){
        this.boys+=1;
    }
    //getters for the children
    public int getGirls(){
        return this.girls;
    }
    public int getBoys(){
        return this.boys;
    }
    //simulates a single family's birthings until a daughter is had
    public static boolean step(Family f){
        Random rand = new Random();
        while (f.getGirls()==0){
            if (rand.nextInt(2)==1){
                f.incBoys();
                rand.nextInt(2);
            }
            else {
                f.incGirls();
            }
        }
        totalBoys+=f.getBoys();
        totalGirls+=f.getGirls();
        return true;
    }

    public static void main(String [] args){
        // create the one million families
        Family[] families = new Family[1000000];
        //loop through the one millions families and add an empty family to each
        for (int i=0; i<families.length; i++){
            families[i]=new Family();
        }
        //go through the families child bearings
        for (Family fam : families){
            if (fam.step(fam)){
            }
        }
        System.out.printf("Total number of girls: %,d %n", Family.totalGirls);
        System.out.printf("Total number of boys: %,d %n", Family.totalBoys);
        double girls = Family.totalGirls;
        double total = Family.totalGirls+Family.totalBoys;
        double perc = girls/total;
        System.out.println("Total percent of girls: "+ perc +" %");
    }
}
