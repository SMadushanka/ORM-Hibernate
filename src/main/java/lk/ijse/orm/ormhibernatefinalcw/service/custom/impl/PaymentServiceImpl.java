package lk.ijse.orm.ormhibernatefinalcw.service.custom.impl;

import lk.ijse.orm.ormhibernatefinalcw.dao.DaoFactory;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.PatcientDao;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.PaymentDao;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.ProgrammeDao;
import lk.ijse.orm.ormhibernatefinalcw.dto.PaymentDto;
import lk.ijse.orm.ormhibernatefinalcw.entity.Patcient;
import lk.ijse.orm.ormhibernatefinalcw.entity.Payment;
import lk.ijse.orm.ormhibernatefinalcw.entity.Programme;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.PaymentService;

public class PaymentServiceImpl implements PaymentService {

    PaymentDao paymentDao = (PaymentDao) DaoFactory.getInstance().getDao(DaoFactory.Type.PAYMENT);
    ProgrammeDao programmeDao = (ProgrammeDao) DaoFactory.getInstance().getDao(DaoFactory.Type.PROGRAMME);
    PatcientDao patcientDao = (PatcientDao) DaoFactory.getInstance().getDao(DaoFactory.Type.PATCIENT);


    @Override
    public boolean savePayment(PaymentDto paymentDto) throws Exception{

        Programme programme = programmeDao.findById(paymentDto.getProgramme());

        return paymentDao.save(new Payment(
                paymentDto.getId(),
                paymentDto.getDate(),
                paymentDto.getAmount(),
                paymentDto.getPatcient(),
                programme
        ));
    }
}