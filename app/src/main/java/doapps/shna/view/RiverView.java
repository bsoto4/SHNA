package doapps.shna.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import doapps.shna.R;

public class RiverView extends LinearLayout {

    private TextView txvRiver;
    private ImageView imgArrow;
    private LinearLayout lytHeader, lytBody, lytSector;
    private LayoutInflater layoutInflater;

    public RiverView(Context context, String river) {
        super(context);
        init(river, context);
    }

    private void init(String river, Context context) {
        layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.item_river, this);

        txvRiver = (TextView) findViewById(R.id.txv_river);
        lytHeader = (LinearLayout) findViewById(R.id.lyt_header);
        lytBody = (LinearLayout) findViewById(R.id.lyt_body);
        lytSector = (LinearLayout) findViewById(R.id.lyt_sector);
        imgArrow = (ImageView) findViewById(R.id.ic_arrow);

        txvRiver.setText(river);

        lytHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lytBody.getVisibility() == View.GONE) {
                    lytBody.setVisibility(VISIBLE);
                    imgArrow.setImageResource(R.drawable.ic_up);
                } else {
                    lytBody.setVisibility(GONE);
                    imgArrow.setImageResource(R.drawable.ic_down);
                }
            }
        });

        lytSector.addView(new SectorView(context, "Iquitos"));
        lytSector.addView(new SectorView(context, "Santa Rosa"));

    }

}
