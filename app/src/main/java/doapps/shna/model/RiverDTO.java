package doapps.shna.model;

import com.zaihuishou.expandablerecycleradapter.model.ExpandableListItem;

import java.util.List;

/**
 * Created by Bryam Soto on 03/08/2016.
 */
public class RiverDTO implements ExpandableListItem {

    private boolean expanded = false;
    private int id;
    private String name;
    private List<SectorDTO> sectorList;

    @Override
    public List<?> getChildItemList() {
        return sectorList;
    }

    public void setSectorList(List<SectorDTO> sectorList) {
        this.sectorList = sectorList;
    }

    @Override
    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public void setExpanded(boolean isExpanded) {
        expanded = isExpanded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
