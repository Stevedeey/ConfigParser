import configparser.ConfigParserClass;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ConfigParserTest {
    configparser.ConfigParserClass config = new configparser.ConfigParserClass("config.txt");

    configparser.ConfigParserClass configDev = new configparser.ConfigParserClass("config.txt.dev");

    configparser.ConfigParserClass configStaging = new configparser.ConfigParserClass("config.txt.staging");

    //TESTING FOR PRODUCTION
    //Testing for name
    @Test
    public  void testForProductionName() throws IOException {
        String productionNameKey = "name";
        Assert.assertEquals("fintek", config.getFieldValue(productionNameKey));
        Assert.assertNotEquals("fintek-development",config.getFieldValue(productionNameKey));
        Assert.assertNotEquals("fintek-staging",config.getFieldValue(productionNameKey));
        Assert.assertNotEquals("fintrack-staging",config.getFieldValue(productionNameKey));
    }
    //Testing for production DBNAME
    @Test
    public  void testForProductionDbName() throws IOException {
        String poductionDbName = "dbname";
        Assert.assertEquals("sq04_db", config.getFieldValue(poductionDbName));
      Assert.assertNotEquals("sq04_db-development",config.getFieldValue(poductionDbName));
        Assert.assertNotEquals("sq04_db-staging",config.getFieldValue(poductionDbName));
    }
    //Testing for production Host
    @Test
    public  void testForProductionHost() throws IOException {
        String poductionHost = "host";
        Assert.assertEquals("127.0.0.1", config.getFieldValue(poductionHost));

    }
    //Testing for production Context URL
    @Test
    public  void testForContextUrl() throws IOException {
        String poductionContextUrl = "context-url";
        Assert.assertEquals("/api/v1", config.getFieldValue(poductionContextUrl));

    }

    //Testing for production Mode
    @Test
    public  void testForProductionMode() throws IOException {
        String poductionModeKey = "mode";
        Assert.assertEquals("production", config.getFieldValue(poductionModeKey));
        Assert.assertNotEquals("development",config.getFieldValue(poductionModeKey));
        Assert.assertNotEquals("staging",config.getFieldValue(poductionModeKey));
    }

    //Testing for production Theme
    @Test
    public  void testForProductionTheme() throws IOException {
        String poductionThemeKey = "theme";
        Assert.assertEquals("green", config.getFieldValue(poductionThemeKey));
        Assert.assertNotEquals("yellow",config.getFieldValue(poductionThemeKey));
        Assert.assertNotEquals("blue",config.getFieldValue(poductionThemeKey));
    }
    //Testing for production PIPELINE
    @Test
    public  void testForProductionPipeLine() throws IOException {
        String poductionPipelineKey = "pipeline";
        Assert.assertEquals("fast", config.getFieldValue(poductionPipelineKey));
        Assert.assertNotEquals("fast-development",config.getFieldValue(poductionPipelineKey));
        Assert.assertNotEquals("fast-staging",config.getFieldValue(poductionPipelineKey));
    }




    //Testing FOR DEVELOPMENT

    @Test
    public  void testForevelopmentName() throws IOException {
        String productionNameKey = "name";
        Assert.assertNotEquals("fintek-staging", configDev.getFieldValue(productionNameKey));
        Assert.assertNotEquals("fintek",configDev.getFieldValue(productionNameKey));
        Assert.assertEquals("fintek-development",configDev.getFieldValue(productionNameKey));
        Assert.assertNotEquals("fintrack-development",configDev.getFieldValue(productionNameKey));
    }
    //Testing for Development DBNAME
    @Test
    public  void testForDevelopmentDbName() throws IOException {
        String developmentDbName = "dbname";
        Assert.assertEquals("sq04_db-development", configDev.getFieldValue(developmentDbName));
        Assert.assertNotEquals("sq04_db",configDev.getFieldValue(developmentDbName));
        Assert.assertNotEquals("sq04_db-staging",configDev.getFieldValue(developmentDbName));
    }
//    //Testing for development Host
    @Test
    public  void testForDevelopmentHost() throws IOException {
        String developmentHost = "host";
        Assert.assertEquals("127.0.0.1", configDev.getFieldValue(developmentHost));

    }
//    //Testing for DEVELOPMENT Context URL
    @Test
    public  void testForDevelopmentContextUrl() throws IOException {

        String developmentContextUrl = "context-url";
        Assert.assertEquals("/api/v1", configDev.getFieldValue(developmentContextUrl));

    }

//    //Testing for development Mode
    @Test
    public  void testForDevelopmentMode() throws IOException {
        String developmentModeKey = "mode";
        Assert.assertEquals("development", configDev.getFieldValue(developmentModeKey));
        Assert.assertNotEquals("production",configDev.getFieldValue(developmentModeKey));
        Assert.assertNotEquals("staging",configDev.getFieldValue(developmentModeKey));
    }
//
    //Testing for development Theme
    @Test
    public  void testForDevelopmentTheme() throws IOException {
        String developmentThemeKey = "theme";
        Assert.assertEquals("yellow", configDev.getFieldValue(developmentThemeKey));
        Assert.assertNotEquals("green",configDev.getFieldValue(developmentThemeKey));
        Assert.assertNotEquals("blue",configDev.getFieldValue(developmentThemeKey));
    }
    //Testing for DEVELOPMENT pipeline
    @Test
    public  void testForDevelopmentPipeLine() throws IOException {
        String developmentPipelineKey = "pipeline";
        Assert.assertEquals("fast-development", configDev.getFieldValue(developmentPipelineKey));
        Assert.assertNotEquals("fast",configDev.getFieldValue(developmentPipelineKey));
        Assert.assertNotEquals("fast-staging",configDev.getFieldValue(developmentPipelineKey));
    }



    //Testing FOR STAGING

    @Test
    public  void testForStagingName() throws IOException {
        String productionNameKey = "name";
        Assert.assertNotEquals("fintek-development", configStaging.getFieldValue(productionNameKey));
        Assert.assertNotEquals("fintek",configStaging.getFieldValue(productionNameKey));
        Assert.assertEquals("fintek-staging",configStaging.getFieldValue(productionNameKey));
        Assert.assertNotEquals("fintrack-development",configStaging.getFieldValue(productionNameKey));
    }
    //Testing for Development DBNAME
    @Test
    public  void testForStagingDbName() throws IOException {
        String developmentDbName = "dbname";
        Assert.assertNotEquals("sq04_db-development", configStaging.getFieldValue(developmentDbName));
        Assert.assertEquals("sq04_db",configStaging.getFieldValue(developmentDbName));

    }
//    //    //Testing for development Host
    @Test
    public  void testForStagingHost() throws IOException {
        String developmentHost = "host";
        Assert.assertEquals("127.0.0.1", configStaging.getFieldValue(developmentHost));

    }

    //Testing for Staging Context URL
    @Test
    public  void testForStagingContextUrl() throws IOException {

        String stagingContextUrl = "context-url";
        Assert.assertEquals("/api/v1", configStaging.getFieldValue(stagingContextUrl));

    }
//
//    //    //Testing for development Mode
    @Test
    public  void testForStagingMode() throws IOException {
        String stagingModeKey = "mode";
        Assert.assertNotEquals("development", configStaging.getFieldValue(stagingModeKey));
        Assert.assertNotEquals("production",configStaging.getFieldValue(stagingModeKey));
        Assert.assertEquals("staging",configStaging.getFieldValue(stagingModeKey));
    }
//    //
//    //Testing for development Theme
    @Test
    public  void testForStagingTheme() throws IOException {
        String stagingThemeKey = "theme";
        Assert.assertNotEquals("yellow", configStaging.getFieldValue(stagingThemeKey));
        Assert.assertNotEquals("green",configStaging.getFieldValue(stagingThemeKey));
        Assert.assertEquals("blue",configStaging.getFieldValue(stagingThemeKey));
    }
//    //Testing for DEVELOPMENT pipeline
    @Test
    public  void testForStagingPipeLine() throws IOException {
        String stagingPipelineKey = "pipeline";
        Assert.assertNotEquals("fast-development", configStaging.getFieldValue(stagingPipelineKey));
        Assert.assertNotEquals("fast",configStaging.getFieldValue(stagingPipelineKey));
        Assert.assertEquals("fast-staging",configStaging.getFieldValue(stagingPipelineKey));
    }








//    @Test
//    public  void testDevelopmentConfig() throws IOException {
//        String productionName = "name";
//        Assert.assertEquals("fintek-development", configDev.getFieldValue(productionName));
//    }
//    @Test
//    public  void testStagingConfig() throws IOException {
//        String productionName = "name";
//        Assert.assertEquals("fintek-staging", configStaging.getFieldValue(productionName));
//    }

}
