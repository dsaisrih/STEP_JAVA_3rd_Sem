class Content {
    String title;

    public Content(String title) {
        this.title = title;
    }

    public void play() {
        System.out.println("Playing: " + title);
    }
}

class Movie extends Content {
    int duration;
    double rating;

    public Movie(String title, int duration, double rating) {
        super(title);
        this.duration = duration;
        this.rating = rating;
    }

    public void showSubtitles() {
        System.out.println("Showing subtitles for movie: " + title);
    }
}

class TVSeries extends Content {
    int seasons;
    int episodes;

    public TVSeries(String title, int seasons, int episodes) {
        super(title);
        this.seasons = seasons;
        this.episodes = episodes;
    }

    public void suggestNextEpisode() {
        System.out.println("Suggested next episode for series: " + title);
    }
}

class Documentary extends Content {
    String topic;

    public Documentary(String title, String topic) {
        super(title);
        this.topic = topic;
    }

    public void showEducationalTags() {
        System.out.println("Educational tags for " + title + ": Topic - " + topic);
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Content c1 = new Movie("Inception", 148, 9.0);
        Content c2 = new TVSeries("Stranger Things", 4, 34);
        Content c3 = new Documentary("Planet Earth", "Nature");

        Content[] library = {c1, c2, c3};

        for (Content content : library) {
            content.play();

            // Downcasting: Access specific features
            if (content instanceof Movie) {
                Movie m = (Movie) content;
                m.showSubtitles();
            } else if (content instanceof TVSeries) {
                TVSeries t = (TVSeries) content;
                t.suggestNextEpisode();
            } else if (content instanceof Documentary) {
                Documentary d = (Documentary) content;
                d.showEducationalTags();
            }
        }
    }
}
