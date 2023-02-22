public class main {
    public static void main(String [] args){
        Family[] families = new Family[1000000];
        for (int i=0; i<families.length; i++){
            families[i]=new Family();
        }
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
