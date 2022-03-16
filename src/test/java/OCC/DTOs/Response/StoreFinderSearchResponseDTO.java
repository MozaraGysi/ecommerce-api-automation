package OCC.DTOs.Response;

import Common.AbstractDTO;

import java.util.List;

public class StoreFinderSearchResponseDTO extends AbstractDTO<StoreFinderSearchResponseDTO> {

    private List<StoresResponseDTO> stores;

    public List<StoresResponseDTO> getStores() {
        return stores;
    }

    public void setStores(List<StoresResponseDTO> stores) {
        this.stores = stores;
    }

}
