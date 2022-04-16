import java.nio.file.Path;
import java.nio.file.Paths;

public class AutoArchiverMain {

    public static void main (String[] args) {

    //config stuff
    //

        //Should be fileCreate(runArchive);
        //to create file with path to the zipped archive

        //Can be used to get the proper path properly (generated from system variables
        //Path saveGameDir = Paths.get();

        //Hardcoded for Mich's machine
        Path saveGameDir = Paths.get("C:\\Users\\ericm\\Documents\\Paradox Interactive\\Hearts of Iron IV\\save games");
        System.out.println(runArchive(saveGameDir));
    }

    public static String runArchive(Path saveGameDir) {
        var zippedOutput = "";

        return zippedOutput;
    }

}
