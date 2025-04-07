package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.PaymentDto;

public interface PaymentService {
    boolean savePayment(PaymentDto paymentDto) throws Exception;
}
