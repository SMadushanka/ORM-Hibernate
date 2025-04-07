package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.PaymentDto;
import lk.ijse.orm.ormhibernatefinalcw.service.SuperService;

public interface PaymentService extends SuperService {
    boolean savePayment(PaymentDto paymentDto) throws Exception;
}
