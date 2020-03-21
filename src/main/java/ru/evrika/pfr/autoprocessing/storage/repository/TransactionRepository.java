package ru.evrika.pfr.autoprocessing.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evrika.pfr.autoprocessing.core.model.TransactionInfo;

/**
 * Created by Sergei Balashov on 11.03.2020.
 */
public interface TransactionRepository extends JpaRepository<Long, TransactionInfo>{
}
