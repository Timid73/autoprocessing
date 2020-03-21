package ru.evrika.pfr.autoprocessing.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

/**
 * Created by Sergei Balashov on 11.03.2020.
 */
public interface PackageRepository extends JpaRepository<Long, PackageInfo>{
}
