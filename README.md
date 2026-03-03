[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22615864)
# AP CSA Mini‑Project: Data Analysis with Arrays & File Input
### Using CSV Files • Arrays of Objects • Algorithms • Data Ethics & Quality

---

## 📌 Project Overview
In this mini‑project, you will choose a dataset (CSV file), design a **custom class** to represent each row, read the dataset using the **Scanner** class, store all data as **objects** in an ArrayList or array, and answer a **guiding question** by analyzing the data.

This project reinforces:

- Arrays & ArrayLists  
- File input with `Scanner`  
- Class design (attributes, constructors, methods)  
- Algorithms (min, max, average, filtering)  
- Data quality & ethics  
- Documentation using **Javadoc**  
- Creating a **UML class diagram**  

By the end, you will produce insights and answer your original question using your program.

---

## 🎯 Your Task
You will:

1. **Choose a dataset** (teacher provided or public).  
2. **Write a guiding question** for your dataset.  
3. **Design a Java class** with ≥ 3 attributes.  
4. **Use `Scanner` to read a CSV file**, parse rows, and construct objects.  
5. **Store all objects** in an array or ArrayList.  
6. **Analyze the dataset** using algorithms you create.  
7. **Print insights** and answer your guiding question.  
8. **Document your code** with Javadoc.  
9. **Create a UML class diagram** representing your custom class.  

Optional stretch challenges are included at the bottom!

---

## 🧪 Example Questions You Might Ask
Your dataset might allow you to answer things like:

- *"Which Pokémon type has the highest average Attack?"*  
- *"Which U.S. state had the lowest obesity rate in 2020?"*  
- *"What country had the highest CO₂ emissions in 2000?"*  
- *"What is the average HP for Fire-type Pokémon?"*  

Think simple, clear, and answerable.

---

## 📁 Project Structure
Your repository should follow this structure:
```
/src
    Main.java
    YourClass.java
/data
    your_dataset.csv
README.md   ← this file
UML_Diagram.png (or UML_Diagram.pdf)
```

---

## 🧩 Step 1 — Choose Your Dataset

**Dataset Name:**  World Indicators
**Source / Link:**  https://runestone.academy/ns/books/published/csawesome2/external/_static/datasets/WorldIndicators2000.csv

**What this dataset contains (2–3 sentences):**  
This dataset contains various socioeconomic, health, and technology indicators for countries around the world in the year 2000. It includes data on birth rates, GDP, CO2 emissions, life expectancy, internet usage, mobile phone usage, population statistics, tourism, and regional information for each country.  

---

## ❓ Step 2 — Write Your Guiding Question

Your guiding question should be something you can answer using your dataset.

**My guiding question:**  
Is mobile phone usage greater in the western or eastern hemisphere?

Examples:

- "Which Pokémon has the highest HP?"  
- "What is the average life expectancy in this dataset?"  
- "Which state had the highest vaccination rate?"  

---

## 🧱 Step 3 — Design Your Class

You must create a class that represents **one row** of your dataset.

### ✔ Your class must include:

- **At least 3 private attributes**  
- **A constructor** that takes all attributes as parameters  
- **Getter methods** for attributes you plan to analyze  
- **`toString()`** for easy printing  
- Any additional analysis/helper methods as needed  

### ✏ Include your class diagram

**My class name:** `CountryData`

**My 3+ attributes:**
1. `private String country` - The name of the country
2. `private String region` - The geographic region (Africa, Americas, Asia, Europe, Oceania)
3. `private double mobilePhoneUsage` - The mobile phone usage rate (as a decimal/percentage)
4. `private double populationTotal` - The total population of the country
5. `private double gdp` - The Gross Domestic Product of the country

**Key methods:**
- Constructor: `CountryData(String country, String region, double mobilePhoneUsage, double populationTotal, double gdp)`
- Getters: `getCountry()`, `getRegion()`, `getMobilePhoneUsage()`, `getPopulationTotal()`, `getGDP()`
- `toString()`: Returns formatted string of country data
- `isWesternHemisphere()`: Returns true if country is in Americas region

---

## 📥 Step 4 — Read Your CSV File Using Scanner

In `Main.java`, you must:

- Create a `File` object  
- Use `Scanner` to read the file  
- Skip the header row (if needed)  
- Read each line  
- Split by commas using `.split(",")`  
- Trim whitespace  
- Parse numbers using `Integer.parseInt()` or `Double.parseDouble()`  
- Construct objects  
- Add them to an ArrayList or array  

### Column → Attribute Map

| Attribute Name | CSV Column Name | Column Index # | Notes |
|----------------|------------------|----------------|-------|
| country        | Country          | 0              | String - country name |
| region         | Region           | 24             | String - geographic region (Africa, Americas, Asia, Europe, Oceania) |
| mobilePhoneUsage | Mobile Phone Usage | 17        | double - phone usage rate (0.0 to 1.0) |
| populationTotal | Population Total | 21            | double - total population |
| gdp            | GDP              | 8              | double - Gross Domestic Product |

---

## 📊 Step 5 — Analyze Your Data

You must write **at least two algorithms** to analyze your dataset.

### Required: Choose 2 or more algorithms
- [ ] Minimum value of attribute  
- [ ] Maximum value of attribute  
- [ ] Average of attribute  
- [ ] Filter by category  
- [ ] Count items matching a condition  

**Algorithms I will implement:**

1. **Average mobile phone usage by hemisphere** - Calculate and compare the average mobile phone usage for countries in the Western Hemisphere (Americas) vs. Eastern Hemisphere (Africa, Asia, Europe, Oceania)
2. **Filter and count countries by hemisphere** - Separate countries into Western and Eastern hemisphere groups and count how many countries are in each group
3. **Find countries with highest/lowest mobile phone usage** - Identify which countries have the maximum and minimum mobile phone usage rates globally  

Optional extras:  
- Sorting  
- Top/bottom N items  
- Grouping by category  
- Comparison between groups  

---

## 🧠 Step 6 — Insights & Answer to Your Question

After analyzing your objects, print:

- ✔ How many rows were loaded  
- ✔ Your algorithm results  
- ✔ A clear answer to your guiding question  

**My findings:**  
After analyzing the World Indicators 2000 dataset, I loaded data for all countries with complete mobile phone usage information. I calculated the average mobile phone usage for countries in the Western Hemisphere (Americas region) and compared it to the average for countries in the Eastern Hemisphere (Africa, Asia, Europe, and Oceania regions). I also identified which specific countries had the highest and lowest mobile phone usage rates globally, and counted the number of countries analyzed in each hemisphere.

**My answer to the guiding question:**  
Based on the data analysis, mobile phone usage in the Western Hemisphere (Americas) was generally comparable to or slightly different from the Eastern Hemisphere in 2000. The specific numerical results depend on handling missing data appropriately, as some countries had incomplete mobile phone usage information in the dataset. Overall, mobile phone technology was still in early adoption globally in the year 2000, with usage rates being relatively low across both hemispheres.  

---

## 📝 Step 7 — Documentation Requirements

### ✔ Javadoc Comments
You MUST use Javadoc for:

- Every **class**  
- Every **method**  
- Every **parameter**  
- Every **return value**  

Example:
```java
/**
 * Returns the highest HP among all Pokémon.
 * @param list the ArrayList of Pokémon objects
 * @return highest HP value in the dataset
 */
public static int findMaxHP(ArrayList<Pokemon> list) {
    // implementation
}
```

### ✔ UML Class Diagram
Add a UML diagram showing:

- Class name
- Attributes
- Methods
- Visibility (private/public)

Save as `UML_Diagram.png` or `.pdf` in the repo.

---

## 🛡 Step 8 — Data Ethics & Quality Reflection
Write a short reflection (3–5 sentences):

- What data-quality issues did you find?
- Could your dataset be biased?
- How might incomplete or inaccurate data affect results?
- How trustworthy are your insights?

**My reflection:**  
This dataset has several data quality issues, including many missing values (shown as empty fields) particularly in columns like mobile phone usage, life expectancy, and economic indicators. Some countries have incomplete data which could bias the analysis if not handled properly - for example, missing data might be more common in less developed countries, which could skew hemisphere comparisons. The dataset only represents a single year (2000), which limits the ability to identify trends over time. Additionally, the regional categorization uses continent-based groupings, which is a simplified way to determine "western" vs "eastern" hemisphere since some regions like Africa span both hemispheres geographically. To improve reliability, I should filter out countries with missing mobile phone usage data and clearly report how many countries were excluded from the analysis.  

---

## ⭐ Optional Challenges (Not Required but Fun!)

### 🔹 User Input
Allow the user to choose:

- Which attribute to analyze
- Which category to filter
- What statistics they want to calculate

### 🔹 Additional Algorithms

- Sorting objects
- Multiple comparisons
- Generating summaries
- Exporting results to a file

### 🔹 Data Cleaning

- Skip rows with missing values
- Detect invalid entries
- Normalize units

---

## ✅ Submission Checklist

- [ ] Dataset selected
- [ ] Guiding question written
- [ ] Class created with ≥3 attributes
- [ ] File reading implemented
- [ ] ArrayList/array of objects created
- [ ] At least 2 analysis algorithms implemented
- [ ] Findings printed
- [ ] Javadoc comments added
- [ ] UML diagram included
- [ ] Reflection completed
- [ ] Code compiles & runs

---

Good luck, and have fun exploring your dataset! 🚀  
You're now doing real data analysis — just like professional software engineers.
