import java.util.ArrayList;

public class country {
    int id;
    String tag;
    ArrayList<String> player;
    String ideology;
    int mils=0;
    int civs=0;
    int docks=0;
    int avalmp=0;
    int lockedmp=0;
    int totmp=0;
    int numdivs=0;
    int numboats=0;

    country(int iid, String itag, String iplayer){
        id = iid;
        tag=itag;
        player.add(iplayer);
    }
}
