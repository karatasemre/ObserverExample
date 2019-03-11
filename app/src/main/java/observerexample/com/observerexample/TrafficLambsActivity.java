package observerexample.com.observerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Observable;
import java.util.Observer;

public class TrafficLambsActivity extends AppCompatActivity implements Observer {

    TrafficLambsViewModel trafficLambsViewModel;
    ImageView trafficLamb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trafficLamb = findViewById(R.id.traffic_lamb);

        trafficLambsViewModel = new TrafficLambsViewModel(this);

        setupObserver(trafficLambsViewModel);

    }

    private void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof TrafficLambsViewModel) {
            TrafficLambsViewModel trafficLambsViewModel = (TrafficLambsViewModel) o;

            int counter = trafficLambsViewModel.getCounterVal();

            if (counter % 3 == 0) {
                trafficLamb.setImageResource(R.drawable.red);
            } else if (counter % 3 == 1) {
                trafficLamb.setImageResource(R.drawable.yellow);
            } else if (counter % 3 == 2) {
                trafficLamb.setImageResource(R.drawable.green);
            }
        }
    }
}
