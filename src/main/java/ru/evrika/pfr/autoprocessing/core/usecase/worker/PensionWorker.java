package ru.evrika.pfr.autoprocessing.core.usecase.worker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.config.PathProperty;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.core.model.TransactionInfo;
import ru.evrika.pfr.autoprocessing.core.service.EmailService;
import ru.evrika.pfr.autoprocessing.core.service.TransactionService;
import ru.evrika.pfr.autoprocessing.file.FileService;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PensionWorker implements PackageWorker {

    private final TransactionService transactionService;

    private final FileService fileService;

    private final PathProperty pathProperty;

    private final EmailService emailService;

    @Override
    public void execute(PackageInfo packageInfo) {
        TransactionInfo transactionInfo = transactionService.create(packageInfo);
        transactionService.save(transactionInfo);
        if (packageInfo.getRegNumFrom().length() < 10) { //TODO wtf 10???
            emailService.createMessage(packageInfo);
        } else {
            fileService.copy(packageInfo.getFileName(), pathProperty.getVipnet());
        }
    }
}
