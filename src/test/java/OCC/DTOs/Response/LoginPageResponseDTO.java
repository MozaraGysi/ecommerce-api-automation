package OCC.DTOs.Response;

import Common.AbstractDTO;

import java.util.List;

public class LoginPageResponseDTO extends AbstractDTO<LoginPageResponseDTO> {
    private List<RecoveryOptionsResponseDTO> recoveryOptions;

    public List<RecoveryOptionsResponseDTO> getRecoveryOptions() {
        return recoveryOptions;
    }

    public void setRecoveryOptions(List<RecoveryOptionsResponseDTO> recoveryOptions) {
        this.recoveryOptions = recoveryOptions;
    }
}
