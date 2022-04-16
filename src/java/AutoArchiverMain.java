import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AutoArchiverMain {

    public static final String HOI_4_EXTENSION = ".hoi4";

    public static void main (String[] args) throws InterruptedException, IOException {

    //config stuff
    //

        //Should be fileCreate(runArchive);
        //to create file with path to the zipped archive

        //Can be used to get the proper path properly (generated from system variables
        //Path saveGameDir = Paths.get();

        //Hardcoded for Mich's machine
        //Path saveGameDir = Paths.get("C:\\Users\\ericm\\Documents\\Paradox Interactive\\Hearts of Iron IV\\save games");
        //actually I think we want to point it directly to the autosave
        Path saveGameDir = Paths.get("C:\\Users\\ericm\\Documents\\Paradox Interactive\\Hearts of Iron IV\\save games\\autosave.hoi4");
        Path archiveDir = Paths.get("C:\\Users\\ericm\\archive\\");
        long startTimeMili = System.currentTimeMillis();
        //18000000l is five hours
        //long endTime = Long.parseLong(startTimeMili+"18000000l");

        long endTime = Long.parseLong(startTimeMili+"336000");

        System.out.println("Program Start time " + Utils.getCurrentTime());
        System.out.println("Program Will End At " + String.valueOf(Utils.getTime(endTime)));
        System.out.println(runArchive(saveGameDir, archiveDir, endTime));
        System.out.println("Program End time " + Utils.getCurrentTime());

    }

    public static String runArchive(Path saveGameDir, Path archiveDir, long endTime) throws InterruptedException, IOException {
        var zippedOutput = "";
        long lastFileSize = 0l;
        int counter = 0;
        while (System.currentTimeMillis() <= endTime) {
            File currentAutosave = new File(saveGameDir.toUri());
            if (!(currentAutosave.length() == lastFileSize)) {
                counter++;
                lastFileSize = currentAutosave.length();
                System.out.println("autosaveSize: " + currentAutosave.length());
                //Broken file look up........
                //File archivedAutoSave = new File(archiveDir.toUri()+"\\autosave-"+String.valueOf(counter)+HOI_4_EXTENSION);
                String autoSaveArchive = "C:\\Users\\ericm\\archive\\autosave-"+ counter +HOI_4_EXTENSION;
                File archivedAutoSave = new File(autoSaveArchive);
                FileUtils.copyFile(currentAutosave, archivedAutoSave);
            }
            System.out.println("Current time before sleep " + Utils.getCurrentTime());
            Thread.sleep(5000);
            System.out.println("Current time after sleep " + Utils.getCurrentTime());
            System.out.println("running next check");
        }

        return zippedOutput;
    }

}
