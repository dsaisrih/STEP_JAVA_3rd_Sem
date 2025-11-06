class SocialMedia {
    void post() {
        System.out.println("Generic social media post");
    }
}

class Instagram extends SocialMedia {
    @Override
    void post() {
        System.out.println("Photo posted on Instagram");
    }
}

class Twitter extends SocialMedia {
    @Override
    void post() {
        System.out.println("Tweet posted on Twitter");
    }
}

public class OverridingDemo {
    public static void main(String[] args) {
        SocialMedia sm1 = new Instagram();
        SocialMedia sm2 = new Twitter();

        sm1.post();  // Instagram version
        sm2.post();  // Twitter version
    }
}
