package doapps.shna.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zaihuishou.expandablerecycleradapter.adapter.BaseExpandableAdapter;
import com.zaihuishou.expandablerecycleradapter.viewholder.AbstractAdapterItem;

import java.util.ArrayList;
import java.util.List;

import doapps.shna.R;
import doapps.shna.adapter.RiverAdapter;
import doapps.shna.adapter.SectorAdapter;
import doapps.shna.model.RiverDTO;
import doapps.shna.model.SectorDTO;

public class SelectionActivity extends AppCompatActivity {

    private final int ITEM_TYPE_RIVER = 1;
    private final int ITEM_TYPE_SECTOR = 2;

    private RecyclerView recyclerView;
    private BaseExpandableAdapter baseExpandableAdapter;
    private List<RiverDTO> riverList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        initData();
        baseExpandableAdapter = new BaseExpandableAdapter(riverList) {
            @NonNull
            @Override
            public AbstractAdapterItem<Object> getItemView(Object type) {
                int itemType = (int) type;
                switch (itemType) {
                    case ITEM_TYPE_RIVER:
                        return new RiverAdapter();
                    case ITEM_TYPE_SECTOR:
                        return new SectorAdapter();
                }
                return null;
            }

            @Override
            public Object getItemViewType(Object t) {
                if (t instanceof RiverDTO) {
                    return ITEM_TYPE_RIVER;
                } else if (t instanceof SectorDTO) {
                    return ITEM_TYPE_SECTOR;
                }
                return -1;
            }
        };
        /**
         * LinearLayoutManager
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        /**
         * GridLayoutManager
         */
        recyclerView.setAdapter(baseExpandableAdapter);
        /**
         * set ExpandCollapseListener
         */
        baseExpandableAdapter.setExpandCollapseListener(new BaseExpandableAdapter.ExpandCollapseListener() {
            @Override
            public void onListItemExpanded(int position) {

            }

            @Override
            public void onListItemCollapsed(int position) {

            }
        });
    }

    private void initData() {
        riverList = new ArrayList<>();

        RiverDTO riverDTO = new RiverDTO();
        riverDTO.setName("Amazonas");
        List<SectorDTO> sectorList = new ArrayList<>();
        SectorDTO sectorDTO = new SectorDTO();
        sectorDTO.setName("Santa Rosa");
        sectorList.add(sectorDTO);
        sectorDTO = new SectorDTO();
        sectorDTO.setName("Iquitos");
        sectorList.add(sectorDTO);
        riverDTO.setSectorList(sectorList);
        riverList.add(riverDTO);

        riverDTO = new RiverDTO();
        riverDTO.setName("Marañon");
        sectorList = new ArrayList<>();
        sectorDTO = new SectorDTO();
        sectorDTO.setName("Nauta");
        sectorList.add(sectorDTO);
        sectorDTO = new SectorDTO();
        sectorDTO.setName("San Regis");
        sectorList.add(sectorDTO);
        riverDTO.setSectorList(sectorList);
        riverList.add(riverDTO);

        riverDTO = new RiverDTO();
        riverDTO.setName("Ucayali");
        sectorList = new ArrayList<>();
        sectorDTO = new SectorDTO();
        sectorDTO.setName("Pucallpa");
        sectorList.add(sectorDTO);
        sectorDTO = new SectorDTO();
        sectorDTO.setName("Requena");
        sectorList.add(sectorDTO);
        riverDTO.setSectorList(sectorList);
        riverList.add(riverDTO);

        riverDTO = new RiverDTO();
        riverDTO.setName("Napo");
        sectorList = new ArrayList<>();
        sectorDTO = new SectorDTO();
        sectorDTO.setName("Mazan");
        sectorList.add(sectorDTO);
        riverDTO.setSectorList(sectorList);
        riverList.add(riverDTO);

        riverDTO = new RiverDTO();
        riverDTO.setName("Putumayo");
        sectorList = new ArrayList<>();
        sectorDTO = new SectorDTO();
        sectorDTO.setName("Guepi");
        sectorList.add(sectorDTO);
        sectorDTO = new SectorDTO();
        sectorDTO.setName("Alamo");
        sectorList.add(sectorDTO);
        sectorDTO = new SectorDTO();
        sectorDTO.setName("San Antonio de Estecho");
        sectorList.add(sectorDTO);
        riverDTO.setSectorList(sectorList);
        riverList.add(riverDTO);

        riverDTO = new RiverDTO();
        riverDTO.setName("Huallaga");
        sectorList = new ArrayList<>();
        sectorDTO = new SectorDTO();
        sectorDTO.setName("Yurimaguas");
        sectorList.add(sectorDTO);
        riverDTO.setSectorList(sectorList);
        riverList.add(riverDTO);

        riverDTO = new RiverDTO();
        riverDTO.setName("Yaravi");
        sectorList = new ArrayList<>();
        sectorDTO = new SectorDTO();
        sectorDTO.setName("Angamos");
        sectorList.add(sectorDTO);
        riverDTO.setSectorList(sectorList);
        riverList.add(riverDTO);

        riverDTO = new RiverDTO();
        riverDTO.setName("Napo");
        sectorList = new ArrayList<>();
        sectorDTO = new SectorDTO();
        sectorDTO.setName("Puerto Maldonado");
        sectorList.add(sectorDTO);
        riverDTO.setSectorList(sectorList);
        riverList.add(riverDTO);

    }

    @NonNull
    private RiverDTO createRiver(String riverName) {
        RiverDTO riverDTO = new RiverDTO();
        riverDTO.setName(riverName);
        List<SectorDTO> sectorList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            SectorDTO sectorDTO = new SectorDTO();
            sectorDTO.setName("Iquitos");
            sectorList.add(sectorDTO);
        }
        riverDTO.setSectorList(sectorList);
        return riverDTO;
    }

}
