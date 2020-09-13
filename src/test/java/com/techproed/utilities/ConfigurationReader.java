package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    // ConfigurationReader : class i projemizin heryerinden
    // nesne uretmeden, miras almadan kullanabilecek sekilde tasarlayalim

    // static : program calisir calismaz, bellekte yer tutmaya yarayan keyword
    static Properties properties;

    static {
        // okumak istedigimiz configurations.properties file in dosya yolu
        //
        String path = "configuration.properties";
        try{
            // okumak istedigimiz dosyanin path ini yaziyorsun
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        }catch (Exception e){
            // try catch : dene = hata alirsan yakala, Bu islemi dene eger hata alirsan, programi durdurma
        }
    }
    // properties.getProperty("username"); --> manager2

      public static String getProperty(String key){
      return properties.getProperty(key);
}




}
