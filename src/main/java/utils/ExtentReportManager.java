package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getReporter() throws IOException {
        if (extent == null) {
            String reportPath = "reports/ExtentReports/index.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.loadXMLConfig("src/test/resources/extent-config.xml");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Project", "BStackDemo Automation");
            extent.setSystemInfo("Browser", ConfigReader.get("browser"));
            extent.setSystemInfo("Base URL", ConfigReader.get("baseUrl"));
        }
        return extent;
    }
}
