package study.javalang.ch09.patterns.observer;

public class ObserverImpl {
    class NYTimes implements Observer{
        @Override
        public void notify(String tweet) {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY! " + tweet);
            }
        }
    }

    class Guardian implements Observer{

        @Override
        public void notify(String tweet) {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in GD! " + tweet);
            }
        }
    }

    class LeMonde implements Observer{

        @Override
        public void notify(String tweet) {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in LM! " + tweet);
            }
        }
    }
}
