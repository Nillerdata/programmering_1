package opg5;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast;
    private ArrayList<Episode> episodes = new ArrayList<>();

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public Episode createEpisode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        Episode episode = new Episode(number, guestActors, lengthMinutes);
        episodes.add(episode);
        return episode;
    }

    public void removeEpisode(int number) {
//kan laves med while. lad være med at slå mig ihjel
        for (Episode e : episodes) {
            if (e.getNumber() == number) {
                episodes.remove(number);
                break;
            }

        }
    }

    /**
     * Return the total length (in minutes) of all the
     * episodes in the series.
     */
    public int totalLength() {
        int totaltRunTime = 0;
        for (Episode e : episodes) {
            totaltRunTime += e.getLengthMinutes();
        }
        return totaltRunTime;
    }

    /**
     * Return the total list of all guest actors from all
     * episodes.
     */
    public ArrayList<String> getGuestActors() {
        ArrayList<String> newguestactors = getGuestActors();
        for (int i = 0; i < episodes.size(); i++) {
            for (Episode e : episodes) {
                for (String actor : e.getGuestActors()) {
                    if (!newguestactors.contains(actor)) {
                        newguestactors.add(actor);
                    }
                }
            }
        }
        return newguestactors;
    }
}

