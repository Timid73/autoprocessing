package ru.evrika.pfr.autoprocessing.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

/**
 * Created by Sergei Balashov on 07.03.2020.
 */
@Service
@RequiredArgsConstructor
public class MailBuilder {

    private final TemplateEngine templateEngine;

    public String build(String from, String to, PackageInfo packageInfo) {
        Context context = new Context();
        //context.setVariable("message", message);
        return templateEngine.process("mailTemplate", context);
    }

}

