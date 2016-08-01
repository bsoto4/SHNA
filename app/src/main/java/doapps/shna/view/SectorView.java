package doapps.shna.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import doapps.shna.R;

/**
 * Created by Bryam Soto on 01/08/2016.
 */
public class SectorView extends LinearLayout {

    private LayoutInflater layoutInflater;
    private TextView txvSector;

    public SectorView(Context context, String sector) {
        super(context);
        layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.item_sector, this);

        txvSector = (TextView) findViewById(R.id.txv_sector);
        txvSector.setText(sector);
    }
}
