/**
 * Represents country data from the World Indicators 2000 dataset.
 * Each CountryData object stores information about a single country including
 * its name, region, mobile phone usage, population, and GDP.
 *
 * @author AP CSA Student
 * @version 1.0
 */
public class CountryData {

    /** The name of the country */
    private String country;
    
    /** The geographic region (Africa, Americas, Asia, Europe, Oceania) */
    private String region;
    
    /** The mobile phone usage rate (as a decimal, e.g., 0.082 = 8.2%) */
    private double mobilePhoneUsage;
    
    /** The total population of the country */
    private double populationTotal;
    
    /** The Gross Domestic Product of the country */
    private double gdp;

    /**
     * Constructs a CountryData object with all attributes.
     *
     * @param country the name of the country
     * @param region the geographic region of the country
     * @param mobilePhoneUsage the mobile phone usage rate
     * @param populationTotal the total population
     * @param gdp the Gross Domestic Product
     */
    public CountryData(String country, String region, double mobilePhoneUsage, 
                       double populationTotal, double gdp) {
        this.country = country;
        this.region = region;
        this.mobilePhoneUsage = mobilePhoneUsage;
        this.populationTotal = populationTotal;
        this.gdp = gdp;
    }

    /**
     * Returns the name of the country.
     *
     * @return the country name
     */
    public String getCountry() {
        return country;
    }

    /**
     * Returns the geographic region of the country.
     *
     * @return the region name
     */
    public String getRegion() {
        return region;
    }

    /**
     * Returns the mobile phone usage rate.
     *
     * @return the mobile phone usage as a decimal
     */
    public double getMobilePhoneUsage() {
        return mobilePhoneUsage;
    }

    /**
     * Returns the total population of the country.
     *
     * @return the population total
     */
    public double getPopulationTotal() {
        return populationTotal;
    }

    /**
     * Returns the GDP of the country.
     *
     * @return the Gross Domestic Product
     */
    public double getGDP() {
        return gdp;
    }

    /**
     * Determines if the country is in the Western Hemisphere.
     * Countries in the Americas region are considered Western Hemisphere.
     *
     * @return true if the country is in the Western Hemisphere, false otherwise
     */
    public boolean isWesternHemisphere() {
        return region != null && 
               (region.equalsIgnoreCase("Americas") || region.equalsIgnoreCase("The Americas"));
    }

    /**
     * Returns a string representation of this country's data.
     *
     * @return a formatted string containing all country information
     */
    @Override
    public String toString() {
        return String.format("%s (%s) - Mobile Usage: %.4f, Population: %.0f, GDP: $%.0f",
                           country, region, mobilePhoneUsage, populationTotal, gdp);
    }
}