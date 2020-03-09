package ru.evrika.pfr.autoprocessing.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
@Getter
@AllArgsConstructor
public enum TransactionType {

    intelligence("сведения", PackageType.Pension, "Pension"),
    request("запрос", PackageType.Pension, "Pension-Request"),
    requestReceipt("запросКвитанция", PackageType.ReSign, "ReSign: Pension-Request"),
    deliveryConfirmation("подтверждениеПолучения", PackageType.ReSign, "Resign: Pension"),
    protocolP("протокол", PackageType.Protocol, "Pension-Protocol-P"),
    protocolN("протокол", PackageType.Protocol, "Pension-Protocol-N"),
    response("ответ", PackageType.Protocol, "Pension-Reply"),
    mail("письмо", PackageType.Pension, "Pension-Unformal"),
    mailReceipt("письмоКвитанция", PackageType.ReSign, "ReSign: Pension-Unformal"),
    errorNotification("уведомлениеОбОшибке", PackageType.ReSign, "Pension-Error-Notification"),
    packageProcessingError("ОшибкаОбработкиПакета", PackageType.Protocol, "Pension-Error-Notification"),
    regInfo("регистрационнаяИнформация", PackageType.Pension, "RegInfo"),
    protocolReceipt("протоколКвитанция", PackageType.Pension, "ReSign: Protocol"),
    unknown("неизестно", PackageType.Unknown, "Unknown");

    private String name;

    private PackageType type;

    private String subject;

    public static TransactionType of(String name) {
        try {
            return TransactionType.valueOf(name);
        } catch (IllegalArgumentException e) {
            return unknown;
        }
    }
}
