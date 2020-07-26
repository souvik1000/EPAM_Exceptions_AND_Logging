import java.util.*;
import java.util.Scanner;
import java.io.IOException;
//import org.apache.logging.log4j.LogManager;
import java.util.logging.*;

@SuppressWarnings("unused")
public class MainClass {
    public static void main(String args[]) throws IOException {
    	//final org.apache.logging.log4j.Logger logger = LogManager.getLogger(MainClass.class);
    	final Logger logger = Logger.getLogger(MainClass.class.getName());
		Handler handle = new ConsoleHandler();
		handle.setLevel(Level.ALL);
		logger.addHandler(handle);
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        logger.info("\nEnter 1 to calculating Interest\nEnter 2 for calculating the constructionCost\nEnter 3 to exit\nEnter Your Choice\n");
        int choose = scan.nextInt();
        
        switch (choose) {
            case 1:
            	logger.info("\nEnter SI for simple interest\nEnter CI for compound interest\nEnter EXIT\nEnter Your Choice\n");
                switch (scan.next()){
                    case "SI":
                        logger.info("\nEnter \"Principal Amount\" , \"Rate of Interest\" and \"Duration in Years\"\t");
                        logger.info("The Simple Interest will be Rs." + SimpleInterest.simpleInterest(scan.nextDouble(), scan.nextDouble(), scan.nextDouble()));
                        break;
                    case "CI":
                        logger.info("\nEnter \"Principal Amount\" , \"Rate of Interest\" and \"Duration in Years\"\t");
                        logger.info("The Compound Interest will be Rs." + CompoundInterest.compoundInterest(scan.nextDouble(), scan.nextDouble(), scan.nextDouble()));
                        break;
                    case "EXIT":
                    	logger.info("ThankYou For Your Uses of Our Program.");
                        System.exit(0);
                    default:
                        logger.info("Wrong Choice!!!");
                }
                break;
                
            case 2:
            	String stdmaterials[] = ConstructionCost.get();
            	logger.info("\n\t**** Standard Material ****\n");
                for (int i = 0; i < stdmaterials.length; i++)
                    logger.info("Enter " + (i + 1) + " to select " + stdmaterials[i]);
                byte selectedMaterial = (byte)(scan.nextByte() - 1);
                logger.info("\nEnter area of house(in sqft):- \t");
                float area = scan.nextFloat();
                boolean FullyAutomated = false;
                if(stdmaterials[selectedMaterial].equals("HighStandardMaterial")) {
                    logger.info("\nEnter \"True\" for fully automation or enter \"False\" for otherwise\t");
                    FullyAutomated = scan.nextBoolean();
                }
                logger.info("The total cost for selected area of house will be Rs." + ConstructionCost.constructionCost(stdmaterials[selectedMaterial], area, FullyAutomated));
                break;
                
            case 3:
            	logger.info("ThankYou For Your Uses of Our Program.");
                System.exit(0);
                
            default:
            	logger.info("Wrong Choice!!!");
        }
    }
}
