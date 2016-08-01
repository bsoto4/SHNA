package doapps.shna.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import doapps.shna.R;
import doapps.shna.view.RiverView;

public class SelectionActivity extends AppCompatActivity {

    private LinearLayout layoutRiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        layoutRiver = (LinearLayout) findViewById(R.id.lyt_river);

        layoutRiver.addView(new RiverView(getBaseContext(), "Rio Amazonas"));
        layoutRiver.addView(new RiverView(getBaseContext(), "Rio Marañon"));
        layoutRiver.addView(new RiverView(getBaseContext(), "Rio Ucayali"));
        layoutRiver.addView(new RiverView(getBaseContext(), "Rio Napo"));
        layoutRiver.addView(new RiverView(getBaseContext(), "Rio Putumayo"));
        layoutRiver.addView(new RiverView(getBaseContext(), "Rio Huallaga"));
        layoutRiver.addView(new RiverView(getBaseContext(), "Rio Yaravi"));
        layoutRiver.addView(new RiverView(getBaseContext(), "Rio Madre de Dios"));
    }

}
