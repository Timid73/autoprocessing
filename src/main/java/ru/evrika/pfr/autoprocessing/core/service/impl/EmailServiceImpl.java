package ru.evrika.pfr.autoprocessing.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.config.EmailProperty;
import ru.evrika.pfr.autoprocessing.config.PathProperty;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.core.service.EmailService;
import ru.evrika.pfr.autoprocessing.core.service.MailBuilder;
import ru.evrika.pfr.autoprocessing.file.FileService;
import ru.evrika.pfr.autoprocessing.storage.data.EmailDataProvider;

import java.util.UUID;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    private final MailBuilder mailBuilder;

    private final FileService fileService;

    private final EmailProperty emailProperty;

    private final PathProperty pathProperty;

    private final EmailDataProvider emailDataProvider;


    public void createMessage(PackageInfo packageInfo) {
        String emailTo = emailDataProvider.findEmailByRegNum(packageInfo.getRegNumTo());
        String emailContent = mailBuilder.build(emailProperty.getBti(), emailTo, packageInfo);
        String mailFileName = pathProperty.getDipost() + "\\M_TDM." + UUID.randomUUID().toString().substring(0, 4);
        fileService.create(emailContent, mailFileName);
    }
}
