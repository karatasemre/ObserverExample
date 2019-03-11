package observerexample.com.observerexample;

import android.content.Context;
import android.os.CountDownTimer;

import java.util.Observable;

public class TrafficLambsViewModel extends Observable {
    public Context context;

    public int counter = 0;  // 0: Red, 1: Yellow, 2: Green

    public TrafficLambsViewModel(Context context) {
        this.context = context;
        startTimer();
    }

    public void startTimer() {
        new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                counter++;

                setChanged();
                notifyObservers();

                startTimer();
            }
        }.start();
    }



    public int getCounterVal() {
        return counter;
    }
}
