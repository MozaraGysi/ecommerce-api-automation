package OCC.DTOs;

import Common.AbstractDTO;
import java.util.List;

public class StoreFinderSearchResponseDTO extends AbstractDTO<StoreFinderSearchResponseDTO> {

    private List<StoresDTO> stores;

    public List<StoresDTO> getStores() {
        return stores;
    }

    public void setStores(List<StoresDTO> stores) {
        this.stores = stores;
    }

}
