package kiryakova.cars.service;

import kiryakova.cars.domain.models.service.OwnerServiceModel;

import java.util.List;

public interface OwnerService {
    void createOwner(OwnerServiceModel ownerServiceModel);

    void updateOwner(String id, OwnerServiceModel ownerServiceModel);

    void deleteOwner(String id);

    OwnerServiceModel findOwnerById(String id);

    List<OwnerServiceModel> findAllOwners(String ownerId);

    boolean checkIfOwnerEgnAlreadyExists(Long egn);
}
