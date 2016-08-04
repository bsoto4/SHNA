package doapps.shna.adapter;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zaihuishou.expandablerecycleradapter.viewholder.AbstractExpandableAdapterItem;

import doapps.shna.R;
import doapps.shna.entity.RiverDTO;


/**
 * Created by Bryam Soto on 03/08/2016.
 */
public class RiverAdapter extends AbstractExpandableAdapterItem {

    private TextView tvName;
    private ImageView icArrow;
    private RiverDTO riverDTO;

    @Override
    public int getLayoutResId() {
        return R.layout.item_river;
    }

    @Override
    public void onBindViews(final View root) {

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doExpandOrUnexpand();
            }
        });
        tvName = (TextView) root.findViewById(R.id.tvName);
        icArrow = (ImageView) root.findViewById(R.id.icArrow);
    }

    @Override
    public void onExpansionToggled(boolean expanded) {
        float start, target;
        if (expanded) {
            start = 0f;
            target = 90f;
        } else {
            start = 90f;
            target = 0f;
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(icArrow, View.ROTATION, start, target);
        objectAnimator.setDuration(300);
        objectAnimator.start();
    }

    @Override
    public void onSetViews() {
        icArrow.setImageResource(0);
        icArrow.setImageResource(R.drawable.ic_arrow);
    }

    @Override
    public void onUpdateViews(Object model, int position) {
        super.onUpdateViews(model, position);
        onSetViews();
        onExpansionToggled(getExpandableListItem().isExpanded());
        riverDTO = (RiverDTO) model;
        tvName.setText(riverDTO.getName());
    }


}
