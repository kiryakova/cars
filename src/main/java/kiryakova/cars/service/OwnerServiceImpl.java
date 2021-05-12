package kiryakova.cars.service;

import kiryakova.cars.common.ConstantsDefinition;
import kiryakova.cars.domain.entities.Owner;
import kiryakova.cars.domain.models.service.OwnerServiceModel;
import kiryakova.cars.error.OwnerNotDeletedException;
import kiryakova.cars.error.OwnerNotFoundException;
import kiryakova.cars.error.OwnerNotSavedException;
import kiryakova.cars.repository.OwnerRepository;
import kiryakova.cars.validation.OwnerValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerValidationService ownerValidation;
    private final ModelMapper modelMapper;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerValidationService ownerValidation, ModelMapper modelMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerValidation = ownerValidation;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createOwner(OwnerServiceModel ownerServiceModel) {
        if(!ownerValidation.isValid(ownerServiceModel)){
            throw new IllegalArgumentException();
        }

        Owner owner = this.modelMapper.map(ownerServiceModel, Owner.class);

        if(this.checkIfOwnerEgnAlreadyExists(owner.getEgn())) {
            throw new OwnerNotSavedException(
                    String.format(
                            ConstantsDefinition.OwnerConstants.OWNER_ALREADY_EXISTS,
                            owner.getEgn())
            );
        }

        try {
            this.ownerRepository.save(owner);
        } catch (Exception ignored){
            throw new OwnerNotSavedException(
                    String.format(
                            ConstantsDefinition.OwnerConstants.UNSUCCESSFUL_SAVED_OWNER,
                            owner.getEgn())
            );
        }
    }

    @Override
    public void updateOwner(String id, OwnerServiceModel ownerServiceModel) {
        Owner owner = this.ownerRepository.findById(id).orElse(null);

        this.checkIfOwnerFound(owner, ownerServiceModel.getEgn());

        try {
            owner.setFirstName(ownerServiceModel.getFirstName());
            owner.setLastName(ownerServiceModel.getLastName());
            owner.setEgn(ownerServiceModel.getEgn());
            owner.setAddress(ownerServiceModel.getAddress());
            owner.setPhone(ownerServiceModel.getPhone());

            this.ownerRepository.save(owner);
        } catch (Exception ignored){
            throw new OwnerNotSavedException(
                    String.format(
                            ConstantsDefinition.OwnerConstants.UNSUCCESSFUL_UPDATED_OWNER,
                            owner.getEgn())
            );
        }
    }

    @Override
    public void deleteOwner(String id) {
        Owner owner = this.ownerRepository
                .findById(id).orElse(null);

        this.checkIfOwnerFound(owner);

        try {
            this.ownerRepository.delete(owner);
        }catch (Exception ignored){
            throw new OwnerNotDeletedException(
                    String.format(
                            ConstantsDefinition.OwnerConstants.UNSUCCESSFUL_DELETE_OWNER,
                            owner.getEgn())
            );
        }
    }

    @Override
    public OwnerServiceModel findOwnerById(String id) {
        Owner owner = this.ownerRepository
                .findById(id).orElse(null);

        this.checkIfOwnerFound(owner);

        return this.modelMapper.map(owner, OwnerServiceModel.class);
    }

    @Override
    public List<OwnerServiceModel> findAllOwners() {

        return this.ownerRepository.findAllOwners()
                .stream()
                .map(p -> this.modelMapper.map(p, OwnerServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean checkIfOwnerEgnAlreadyExists(Long egn) {
        Owner owner = this.ownerRepository
                .findByEgn(egn).orElse(null);

        if(owner == null) {
            return false;
        }

        return true;
    }

    private void checkIfOwnerFound(Owner owner) {
        if(!ownerValidation.isValid(owner)) {
            throw new OwnerNotFoundException(ConstantsDefinition
                    .OwnerConstants.NO_SUCH_OWNER);
        }
    }

    private void checkIfOwnerFound(Owner owner, Long egn) {
        if(!ownerValidation.isValid(owner)) {
            throw new OwnerNotFoundException(
                    String.format(
                            ConstantsDefinition.OwnerConstants.NO_OWNER_WITH_EGN,
                            egn)
            );
        }
    }
}
