package ro.ccar.addressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ccar.addressservice.entity.Address;
import java.util.Optional;

//@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM addresses WHERE id = :id"
    )
    Optional<Address> findAddressById(@Param("id") int id);
}
