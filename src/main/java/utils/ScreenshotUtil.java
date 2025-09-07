package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String takeScreenshot(String methodName) {
        WebDriver driver = DriverFactory.getDriver();

        if (driver == null) {
            System.out.println("Driver is null, skipping screenshot for: " + methodName);
            return null;
        }

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String path = "reports/Screenshots/" + methodName + "_" + timestamp + ".png";
//            Files.createDirectories(Paths.get("Screenshots"));
            Files.copy(src.toPath(), Paths.get(path));
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
