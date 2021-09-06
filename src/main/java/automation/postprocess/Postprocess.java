package automation.postprocess;

import automation.utility.Utility;
import deersheep.automation.utility.JunitReportTool;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Postprocess {

    public static void modifyJunitReportClassName() {
        Path junitReportFolder = Paths.get(System.getProperty("user.dir"), "build", "test-results", "junit");
        Set<String> junitReportSet = new HashSet<>(){{
            add("regression.PortalTest");
            add("regression.LoginTest");
        }};
        for (String reportName : junitReportSet) {
            Path reportPath = Paths.get(junitReportFolder.toString(), reportName + ".xml");
            JunitReportTool.modifyJunitReportClassName(reportPath, "Portal Test", reportName);
            JunitReportTool.modifyJunitReportClassName(reportPath, "Login Test", reportName);
        }
    }

    public static void archiveTestResults() {

        // make archive folder
        File archiveFolder = new File(Paths.get(System.getProperty("user.dir"), "archive", Utility.getBuildNum()).toString());
        if (!archiveFolder.exists()) {
            archiveFolder.mkdirs();
        }

        // copy test-results folder to archive
        Path testResultsFolder = Paths.get(System.getProperty("user.dir"), "build", "test-results");
        File tempFolder = new File(Paths.get(System.getProperty("user.dir"), "archive", "test-results").toString());

        try {
            if (tempFolder.exists()) {
                FileUtils.deleteDirectory(tempFolder);
            }
            FileUtils.copyDirectory(new File(testResultsFolder.toString()), tempFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // copy junit & cucumber reports to archive/build-num
        Path junitReportFolder = Paths.get(System.getProperty("user.dir"), "build", "test-results", "junit");
        Path cucumberReportFolder = Paths.get(System.getProperty("user.dir"), "build", "test-results", "cucumber");

        try {
            FileUtils.copyDirectory(new File(junitReportFolder.toString()), archiveFolder);
            FileUtils.copyDirectory(new File(cucumberReportFolder.toString()), archiveFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        modifyJunitReportClassName();
        archiveTestResults();
    }

}
