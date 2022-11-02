package app;

/**
 * Class represeting a LGA from the Studio Project database
 * In the template, this only uses the code and name for 2016
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class LGAExtended {
   // LGA 2016 Code
   public int code16;

   // LGA 2016 Name
   public String name16;

   // LGA 2016 type
   public String type16;

   // LGA 2016 area
   public double area16;

   //Population Count
   public int populationCount;

   public String age;

   // default constructor
   public LGAExtended() {

   }

   /**
    * Create an LGA and set the fields
    */
   public LGAExtended(String name16, int code16,String age, int populationCount) {
      this.code16 = code16;
      this.name16 = name16;
      this.age = age;
      this.populationCount = populationCount;
   }

   public int getCode16() {
      return code16;
   }

   public String getName16() {
      return name16;
   }

   public String getType16() {
      return type16;
   }

   public double getArea16() {
      return area16;
   }

    public int getPopulationCount() {
        return populationCount;
    }

      public String getAge() {
         return age;
      }
}

