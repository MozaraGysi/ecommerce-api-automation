package OCC.DTOs;

import Common.AbstractDTO;

import java.util.List;

public class LoginPageResponseDTO extends AbstractDTO<LoginPageResponseDTO> {
    private List<RecoveryOptionsDTO> recoveryOptions;

    public List<RecoveryOptionsDTO> getRecoveryOptions() {
        return recoveryOptions;
    }

    public void setRecoveryOptions(List<RecoveryOptionsDTO> recoveryOptions) {
        this.recoveryOptions = recoveryOptions;
    }
}
