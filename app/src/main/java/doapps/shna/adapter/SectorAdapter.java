package doapps.shna.adapter;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.zaihuishou.expandablerecycleradapter.viewholder.AbstractAdapterItem;

import doapps.shna.R;
import doapps.shna.activity.AboutActivity;
import doapps.shna.activity.SelectionActivity;
import doapps.shna.model.SectorDTO;


/**
 * Created by Bryam Soto on 03/08/2016.
 */
public class SectorAdapter extends AbstractAdapterItem {

    private TextView tvName;
    private SectorDTO sectorDTO;

    @Override
    public int getLayoutResId() {
        return R.layout.item_sector;
    }

    @Override
    public void onBindViews(final View root) {
        tvName = (TextView) root.findViewById(R.id.tvName);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, sectorDTO.getName(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(view.getContext(), AboutActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onSetViews() {
    }

    @Override
    public void onUpdateViews(Object model, int position) {
        if (model instanceof SectorDTO) {
            sectorDTO = (SectorDTO) model;
            tvName.setText(sectorDTO.getName());
        }
    }
}