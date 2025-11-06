class Post {
    String author;
    String content;
    String time;

    public Post(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public void display() {
        System.out.println(author + " posted: " + content + " at " + time);
    }
}

class InstagramPost extends Post {
    int likes;

    public InstagramPost(String author, String content, String time, int likes) {
        super(author, content, time);
        this.likes = likes;
    }

    @Override
    public void display() {
        System.out.println("📸 Instagram Post: " + content + " #" + author + " | Likes: " + likes);
    }
}

class TwitterPost extends Post {
    int retweets;

    public TwitterPost(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }

    @Override
    public void display() {
        System.out.println("🐦 Twitter Post: " + content + " (" + content.length() + " chars) | Retweets: " + retweets);
    }
}

class LinkedInPost extends Post {
    int connections;

    public LinkedInPost(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }

    @Override
    public void display() {
        System.out.println("💼 LinkedIn Post: " + author + " | " + content + " | Connections: " + connections);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Post insta = new InstagramPost("Alice", "Enjoying vacation!", "10:00 AM", 500);
        Post twitter = new TwitterPost("Bob", "Learning Java!", "11:00 AM", 200);
        Post linkedin = new LinkedInPost("Charlie", "New job opportunity!", "12:00 PM", 1000);

        insta.display();
        twitter.display();
        linkedin.display();
    }
}
