package ru.evrika.pfr.autoprocessing.core.usecase.worker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.core.model.TransactionInfo;
import ru.evrika.pfr.autoprocessing.core.service.EmailService;
import ru.evrika.pfr.autoprocessing.core.service.TransactionService;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProtocolWorker implements PackageWorker {

    private final TransactionService transactionService;

    private final EmailService emailService;

    @Override
    public void execute(PackageInfo packageInfo) {
        TransactionInfo transactionInfo = transactionService.find(packageInfo.getUid());
        transactionInfo.setProtocol(packageInfo);
        transactionService.save(transactionInfo);
        emailService.createMessage(packageInfo);
    }
}
