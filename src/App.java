import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main application for the Data Analysis Mini‑Project.
 * This program analyzes the World Indicators 2000 dataset to answer the question:
 * "Is mobile phone usage greater in the western or eastern hemisphere?"
 *
 * @author AP CSA Student
 * @version 1.0
 */
public class App {

    /**
     * Main method that loads data, performs analysis, and displays results.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        // Update this with your CSV file path
        File file = new File("WorldIndicators2000.csv");

        // Create an ArrayList of CountryData objects to store data
        ArrayList<CountryData> dataList = new ArrayList<>();

        // Read file using Scanner
        try {
            Scanner scanner = new Scanner(file);
            
            // Skip header row
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            
            // Loop through rows
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                // Split by commas (handle potential commas in quotes)
                String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                
                try {
                    // Extract the columns we need
                    String country = columns[0].replace("\"", "").trim();
                    String region = columns.length > 24 ? columns[24].replace("\"", "").trim() : "";
                    
                    // Parse mobile phone usage (column 17)
                    String mobileStr = columns.length > 17 ? columns[17].trim() : "";
                    
                    // Parse population total (column 21)
                    String popStr = columns.length > 21 ? columns[21].trim() : "";
                    
                    // Parse GDP (column 8)
                    String gdpStr = columns.length > 8 ? columns[8].trim() : "";
                    
                    // Only add countries with valid mobile phone usage data
                    if (!mobileStr.isEmpty() && !region.isEmpty() && 
                        !popStr.isEmpty() && !gdpStr.isEmpty()) {
                        
                        double mobilePhoneUsage = Double.parseDouble(mobileStr);
                        double populationTotal = Double.parseDouble(popStr);
                        double gdp = Double.parseDouble(gdpStr);
                        
                        // Create new CountryData object and add to list
                        CountryData countryData = new CountryData(country, region, 
                                                                  mobilePhoneUsage, 
                                                                  populationTotal, gdp);
                        dataList.add(countryData);
                    }
                    
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    // Skip rows with parsing errors
                    continue;
                }
            }
            
            scanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + file.getName());
            System.out.println("Please make sure WorldIndicators2000.csv is in the correct location.");
            return;
        }

        // Print header
        System.out.println("=".repeat(70));
        System.out.println("WORLD INDICATORS 2000 - MOBILE PHONE USAGE ANALYSIS");
        System.out.println("=".repeat(70));
        System.out.println();

        // Call analysis methods
        System.out.println("Total countries loaded with complete data: " + dataList.size());
        System.out.println();
        
        // Algorithm 1: Find max and min mobile phone usage
        findExtremeValues(dataList);
        System.out.println();
        
        // Algorithm 2: Calculate average by hemisphere
        double westernAvg = calculateAverageByHemisphere(dataList, true);
        double easternAvg = calculateAverageByHemisphere(dataList, false);
        
        // Algorithm 3: Count countries by hemisphere
        int westernCount = countByHemisphere(dataList, true);
        int easternCount = countByHemisphere(dataList, false);
        
        System.out.println("Western Hemisphere (Americas):");
        System.out.println("  - Countries analyzed: " + westernCount);
        System.out.printf("  - Average mobile phone usage: %.4f (%.2f%%)%n", 
                         westernAvg, westernAvg * 100);
        System.out.println();
        
        System.out.println("Eastern Hemisphere (Africa, Asia, Europe, Oceania):");
        System.out.println("  - Countries analyzed: " + easternCount);
        System.out.printf("  - Average mobile phone usage: %.4f (%.2f%%)%n", 
                         easternAvg, easternAvg * 100);
        System.out.println();
        
        // Answer the guiding question
        System.out.println("=".repeat(70));
        System.out.println("ANSWER TO GUIDING QUESTION:");
        System.out.println("Is mobile phone usage greater in the western or eastern hemisphere?");
        System.out.println("=".repeat(70));
        
        if (westernAvg > easternAvg) {
            double difference = westernAvg - easternAvg;
            System.out.printf("Mobile phone usage is GREATER in the WESTERN Hemisphere.%n");
            System.out.printf("The Western Hemisphere has %.4f (%.2f%%) higher usage on average.%n",
                            difference, difference * 100);
        } else if (easternAvg > westernAvg) {
            double difference = easternAvg - westernAvg;
            System.out.printf("Mobile phone usage is GREATER in the EASTERN Hemisphere.%n");
            System.out.printf("The Eastern Hemisphere has %.4f (%.2f%%) higher usage on average.%n",
                            difference, difference * 100);
        } else {
            System.out.println("Mobile phone usage is EQUAL in both hemispheres.");
        }
        System.out.println();
        
        System.out.println("Note: In the year 2000, mobile phone technology was still in early");
        System.out.println("adoption globally, with usage rates being relatively low overall.");
        System.out.println("=".repeat(70));
    }

    /**
     * Finds and prints the countries with maximum and minimum mobile phone usage.
     *
     * @param dataList the ArrayList of CountryData objects to analyze
     */
    public static void findExtremeValues(ArrayList<CountryData> dataList) {
        if (dataList.isEmpty()) {
            System.out.println("No data to analyze.");
            return;
        }
        
        CountryData maxCountry = dataList.get(0);
        CountryData minCountry = dataList.get(0);
        
        for (CountryData country : dataList) {
            if (country.getMobilePhoneUsage() > maxCountry.getMobilePhoneUsage()) {
                maxCountry = country;
            }
            if (country.getMobilePhoneUsage() < minCountry.getMobilePhoneUsage()) {
                minCountry = country;
            }
        }
        
        System.out.println("Country with HIGHEST mobile phone usage:");
        System.out.printf("  %s - %.4f (%.2f%%)%n", 
                         maxCountry.getCountry(), 
                         maxCountry.getMobilePhoneUsage(),
                         maxCountry.getMobilePhoneUsage() * 100);
        
        System.out.println("Country with LOWEST mobile phone usage:");
        System.out.printf("  %s - %.4f (%.2f%%)%n", 
                         minCountry.getCountry(), 
                         minCountry.getMobilePhoneUsage(),
                         minCountry.getMobilePhoneUsage() * 100);
    }

    /**
     * Calculates the average mobile phone usage for a specified hemisphere.
     *
     * @param dataList the ArrayList of CountryData objects to analyze
     * @param isWestern true for Western Hemisphere, false for Eastern Hemisphere
     * @return the average mobile phone usage for the specified hemisphere
     */
    public static double calculateAverageByHemisphere(ArrayList<CountryData> dataList, 
                                                     boolean isWestern) {
        double sum = 0.0;
        int count = 0;
        
        for (CountryData country : dataList) {
            if (country.isWesternHemisphere() == isWestern) {
                sum += country.getMobilePhoneUsage();
                count++;
            }
        }
        
        return count > 0 ? sum / count : 0.0;
    }

    /**
     * Counts the number of countries in a specified hemisphere.
     *
     * @param dataList the ArrayList of CountryData objects to analyze
     * @param isWestern true for Western Hemisphere, false for Eastern Hemisphere
     * @return the number of countries in the specified hemisphere
     */
    public static int countByHemisphere(ArrayList<CountryData> dataList, boolean isWestern) {
        int count = 0;
        
        for (CountryData country : dataList) {
            if (country.isWesternHemisphere() == isWestern) {
                count++;
            }
        }
        
        return count;
    }

}